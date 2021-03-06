/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.manufacturer;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author Fabrice
 */
public class ProductQuantity {

    @Resource private WebServiceContext wsc;
    // Location of the products xml file
    private static String PRODUCT_XML = "inventory.xml";
    // Member variables
    private String productName;
    private String manufacturerName;
    private String productType;
    private float unitPrice;
    private int prodQuantity;

    public ProductQuantity() {
  /*      try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new FileReader(PRODUCT_XML));

            Document doc = db.parse(is);

            NodeList nodes = doc.getElementsByTagName("item");
            System.out.println(nodes.getLength());
            // Loop through and print out all of the title elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                //System.out.println("inside loop"+getTextValue(element,"productType"));
                setManufacturerName(getTextValue(element,"manufacturerName"));
                setProductType(getTextValue(element,"productType"));
                setUnitPrice(getFloatValue(element,"unitPrice"));
                setProductQuantity(getIntValue(element,"quantity"));
                setProductName(productName);
                //System.out.println(getTextValue(element,"manufacturerName"));
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
*/
    }

    public ProductQuantity(String productName) {

         MessageContext ctxt = wsc.getMessageContext();
        ServletContext req = (ServletContext) ctxt.get(ctxt.SERVLET_CONTEXT);
        String path = req.getRealPath("WEB-INF");
        if(!PRODUCT_XML.startsWith(path))
            PRODUCT_XML = path + "/" + PRODUCT_XML;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new FileReader(PRODUCT_XML));

            Document doc = db.parse(is);

            NodeList nodes = doc.getElementsByTagName("item");
            System.out.println(nodes.getLength());
            // Loop through and print out all of the title elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                //System.out.println("inside loop"+getTextValue(element,"productType"));
                if(getTextValue(element,"productType").equals(productName)){
                    setProductQuantity(getIntValue(element,"quantity"));
                    setUnitPrice(getFloatValue(element,"unitPrice"));
                    setProductName(productName);
                    //System.out.println(getTextValue(element,"manufacturerName"));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

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

    private int getIntValue(Element ele, String tagName) {
            //in production application you would catch the exception
            return Integer.valueOf(getTextValue(ele,tagName)).intValue();
    }

    public static boolean checkProductType(String type) {
        if(type.equals("DVD player") || type.equals("video camera") || type.equals("TV")){
            return true;
        }
        return false;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        if(checkProductType(productType)){
            this.productType = productType;
        }
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return prodQuantity;
    }

    public void setProductQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }
}
