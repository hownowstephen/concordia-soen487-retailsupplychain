/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.manufacturer;

import java.io.File;
import java.io.FileReader;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

/**
 *
 * @author st_youn
 */
@WebService()
public class Manufacturer3 {

//    private static final String ORDERS_XML = "/root/NetBeansProjects/SupplyChainManagementClient/web/purchaseorders.xml";
//    private static final String ORDERS_XML = "C:/Users/Jose/Documents/soen487-retailsupplychain/ManufacturerService/src/java/org/soen487/supplychain/manufacturer/purchaseorders.xml";
private static final String ORDERS_XML = "/home/jose/test/test3/soen487-retailsupplychain/ManufacturerService/src/java/org/soen487/supplychain/manufacturer/purchaseorders.xml";
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getProductInfo")
    public Product getProductInfo(@WebParam(name = "aProductName")
    String aProductName) {
        try {
            Product product = new Product(aProductName);
            if(product.getManufacturerName() == null || product.getProductName() == null || product.getProductType() == null || !(product.getUnitPrice() > 0.0)){
                return null;
            }else{
                return product;
            }
        } catch(Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

    @WebMethod(operationName = "getProductQuantity")
    public ProductQuantity getProductQuantity(@WebParam(name = "aProductName")
    String aProductName) {
        try {
            ProductQuantity productQ = new ProductQuantity(aProductName);
            return productQ;
        } catch(Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "receivePayment")
    public boolean receivePayment(@WebParam(name = "orderNum")
    String orderNum, @WebParam(name = "totalPrice")
    float totalPrice) {
        //TODO write your implementation code here:
        File file = new File(ORDERS_XML);
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new FileReader(file));

            Document doc = db.parse(is);
            Document newDoc = db.newDocument();
            Element root = newDoc.createElement("orders");

            boolean flag = false;
            NodeList orders = doc.getElementsByTagName("order");
            // Loops through each element and checks if it is paid
            for(int i=0;i<orders.getLength();i++){
                Element order = (Element) orders.item(i);
                if(getTextValue(order,"orderNum").equals(orderNum)){
                    if(getFloatValue(order,"orderTotal") == totalPrice){
                        // update the xml here
                        order.getElementsByTagName("status").item(0).setTextContent("paid");
                        flag = true;
                    }
                }
                Node newNode = newDoc.importNode(order, true);
                root.appendChild(newNode);
            }
            // Write the updated content to the xml file
            Node docRoot = newDoc.importNode(root,true);
            newDoc.appendChild(docRoot);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(newDoc);
            //StreamResult result = new StreamResult(System.out);
            StreamResult result = new StreamResult(ORDERS_XML);
            transformer.transform(source, result);
            return flag;
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "processPurchaseOrder")
    public boolean processPurchaseOrder(@WebParam(name = "aPO")
    PurchaseOrder aPO) {
        if(aPO.getUnitPrice() >= aPO.getProduct().getUnitPrice()){
            if(produce(aPO.getProduct().getProductName(),aPO.getQuantity())){
                System.out.println("Processing order");
                // Processing the purchase order, needs to be added to the xml file
                File file = new File(ORDERS_XML);
                try{
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    InputSource is = new InputSource();
                    is.setCharacterStream(new FileReader(file));

                    Document doc = db.parse(is);

                    Element root = doc.getDocumentElement();
                    Element e = doc.createElement("order");

                    // Convert the purchase order to an XML format
                    String keys[] = {"orderNum","customerRef","product","quantity","unitPrice"};
                    String values[] = {aPO.getOrderNum(),aPO.getCustomerRef(),aPO.getProduct().getProductName(),Integer.toString(aPO.getQuantity()),Float.toString(aPO.getUnitPrice())};
                    for(int i=0;i<keys.length;i++){
                        Element tmp = doc.createElement(keys[i]);
                        tmp.setTextContent(values[i]);
                        e.appendChild(tmp);
                    }
                    // Set the status to submitted
                    Element status = doc.createElement("status");
                    status.setTextContent("submitted");
                    e.appendChild(status);

                    // Set the order total
                    Element total = doc.createElement("orderTotal");
                    float orderTotal = aPO.getQuantity() * aPO.getUnitPrice();
                    total.setTextContent(Float.toString(orderTotal));
                    e.appendChild(total);

                    // Write the content all as a new element in the root
                    root.appendChild(e);
                    TransformerFactory tf = TransformerFactory.newInstance();
                    Transformer m = tf.newTransformer();
                    DOMSource source = new DOMSource(root);
                    StreamResult result = new StreamResult(file);
                    m.transform(source, result);

                } catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }
                return true;
            }
        }
        System.out.println("Unit price was not greater, not selling");
        return false;
    }

    private boolean produce(String productName, int quantity){
        if(quantity <= 100){
            return true;
        }
        return false;
    }
    private String getTextValue(Element ele, String tagName) {
            String textVal = null;
            NodeList nl = ele.getElementsByTagName(tagName);
            if(nl != null && nl.getLength() > 0) {
                    Element el = (Element)nl.item(0);
                    textVal = el.getFirstChild().getNodeValue();
            }

            return textVal;
    }
    private float getFloatValue(Element ele, String tagName) {
            //in production application you would catch the exception
            return Float.valueOf(getTextValue(ele,tagName)).floatValue();
    }

}
