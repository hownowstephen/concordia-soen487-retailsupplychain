/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.manufacturer;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;

/**
 *
 * @author st_youn
 */
public class Product {

    // Location of the products xml file
    private static final String PRODUCT_XML = "/home/jose/test/test3/soen487-retailsupplychain/ManufacturerService/src/java/org/soen487/supplychain/manufacturer/products.xml";
    // Member variables
    private String productName;
    private String manufacturerName;
    private String productType;
    private float unitPrice;

    public Product() {
    }

    public Product(String productName) {
        try {
            System.out.println("inside Product: productName = "+productName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new FileReader(PRODUCT_XML));

            Document doc = db.parse(is);
            
            NodeList nodes = doc.getElementsByTagName("product");
            System.out.println(nodes.getLength());
            // Loop through and print out all of the title elements
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                //System.out.println("inside loop"+getTextValue(element,"productType"));
                System.out.println("inside loop: item name = "+element.getAttribute("name"));
                //if(getTextValue(element,"productType").equals(productName)){
                if(element.getAttribute("name").equals(productName)){
                    setManufacturerName(getTextValue(element,"manufacturerName"));
                    setProductType(getTextValue(element,"productType"));
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
}
