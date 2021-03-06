/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebMethod; 
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.soen487.supplychain.manufacturer.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

/**
 *
 * @author root
 */
@WebService()
public class Warehouse_2 {

    @Resource private WebServiceContext wsc;

    private static String INVENTORY_XML = "inventory.xml";
    private static final int REPLENISH_MINIMUM = 50;
    private static final int REPLENISH_AMOUNT = 200;
    private ArrayList<String> namesInCatalog;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "shipGoods")
    public ItemShippingStatusList shipGoods(@WebParam(name = "itemList")
    org.soen487.supplychain.warehouse.ItemList itemList, @WebParam(name = "info")
    Customer info) {

        MessageContext ctxt = wsc.getMessageContext();
        ServletContext req = (ServletContext) ctxt.get(ctxt.SERVLET_CONTEXT); 
        String path = req.getRealPath("WEB-INF");
        if(!INVENTORY_XML.startsWith(path))
            INVENTORY_XML = path + "/" + INVENTORY_XML;

        File file = new File(INVENTORY_XML);
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new FileReader(file));

            Document doc = db.parse(is);

            NodeList inventory = doc.getElementsByTagName("item");

            ItemShippingStatusList statusList = new ItemShippingStatusList();

            System.out.println("Looping through items");
            // Loop through the items passed in the itemlist
            for(int t=0;t<itemList.size();t++){
                // Grab the item
                Item tmp = (Item) itemList.get(t);
                // Find the item in the inventory
                for(int i=0;i<inventory.getLength();i++){
                    Element xmlItem = (Element) inventory.item(i);
                    System.out.println(xmlItem.getAttribute("name"));
                    // Check if the unique identifiers match
                    if(tmp.getProductName().equals(xmlItem.getAttribute("name"))){
                        int newQuantity = (int) getFloatValue(xmlItem,"quantity") - tmp.getQuantity();
                        if(newQuantity >= 0){
                            // Ship and remove the items from inventory
                            xmlItem.getElementsByTagName("quantity").item(0).setTextContent(Integer.toString(newQuantity));
                            statusList.add(tmp, tmp.getQuantity(),0);
                        }else{
                            // send available stock only
                            statusList.add(tmp, (int) getFloatValue(xmlItem,"quantity"), -newQuantity);
                            xmlItem.getElementsByTagName("quantity").item(0).setTextContent("0");
                        }
                        break;
                    }
                }
            }
            // Write the updated content to the xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(INVENTORY_XML);
            transformer.transform(source, result);

            replenish();

            return statusList;
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return null;

    }

    private void replenish(){

        MessageContext ctxt = wsc.getMessageContext();
        ServletContext req = (ServletContext) ctxt.get(ctxt.SERVLET_CONTEXT);
        String path = req.getRealPath("WEB-INF");
        if(!INVENTORY_XML.startsWith(path))
            INVENTORY_XML = path + "/" + INVENTORY_XML;
        // Performs the replenishing of items in the inventory, if needed
        File file = new File(INVENTORY_XML);
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new FileReader(file));

            Document doc = db.parse(is);

            NodeList inventory = doc.getElementsByTagName("item");
            for(int i=0;i<inventory.getLength();i++){
                Element xmlItem = (Element) inventory.item(i);
                if(getFloatValue(xmlItem,"quantity") < REPLENISH_MINIMUM){
                    ManufacturerHandler manufacturer_handler = new ManufacturerHandler();
                    Product p = manufacturer_handler.getProductInfo(xmlItem.getAttribute("name"));
                    if (p != null) {
                        // Generate a new dummy order
                        PurchaseOrder order = new PurchaseOrder();
                        order.setOrderNum("777777");
                        order.setCustomerRef("JLS");
                        order.setProduct(p);
                        order.setQuantity(90);
                        order.setUnitPrice(5000);
                        // Attempt to process
                        if (manufacturer_handler.processPurchaseOrder(order)) {
                            xmlItem.getElementsByTagName("quantity").item(0).setTextContent(Integer.toString(REPLENISH_AMOUNT));
                            if (manufacturer_handler.receivePayment(order.getProduct(), order.getOrderNum(), order.getQuantity() * order.getUnitPrice())) {
                                System.out.println("WAREHOUSE 2 --- Payment has been received by Manufacturer ----");
                            } else {
                                System.out.println("WAREHOUSE 2 --- Payment has NOT been received by Manufacturer  ----");
                            }
                        } else {
                            System.out.println("WAREHOUSE 2 --- Purchase Order NOT performed ----");
                        }
                    } else {
                        System.out.println("no product found");
                    }

                }
            }

            // Write the updated content to the xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            //StreamResult result = new StreamResult(System.out);
            StreamResult result = new StreamResult(INVENTORY_XML);
            transformer.transform(source, result);

        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static String getTextValue(Element ele, String tagName) {
            String textVal = null;
            NodeList nl = ele.getElementsByTagName(tagName);
            if(nl != null && nl.getLength() > 0) {
                    Element el = (Element)nl.item(0);
                    textVal = el.getFirstChild().getNodeValue();
            }

            return textVal;
    }
    private static float getFloatValue(Element ele, String tagName) {
            //in production application you would catch the exception
            return Float.valueOf(getTextValue(ele,tagName)).floatValue();
    }

    @WebMethod(operationName= "getNameForCatalog")
    public List getNameForCatalog(){

        MessageContext ctxt = wsc.getMessageContext();
        ServletContext req = (ServletContext) ctxt.get(ctxt.SERVLET_CONTEXT);
        String path = req.getRealPath("WEB-INF");
        if(!INVENTORY_XML.startsWith(path))
            INVENTORY_XML = path + "/" + INVENTORY_XML;
         try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            System.out.println(System.getProperty("user.dir"));
            is.setCharacterStream(new FileReader(INVENTORY_XML));

            Document doc = db.parse(is);
            productList current = new productList();
            NodeList nodes = doc.getElementsByTagName("item");
            System.out.println(nodes.getLength());
            // Loop through and print out all of the title elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                //System.out.println("inside loop"+getTextValue(element,"productType"));
                if(!getTextValue(element,"productType").equals("")){
                    System.out.println("in here! "+getTextValue(element,"productType"));
                    current.add(getTextValue(element,"productType"));
                    System.out.println(current.getItems());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }       return null;
    }


}