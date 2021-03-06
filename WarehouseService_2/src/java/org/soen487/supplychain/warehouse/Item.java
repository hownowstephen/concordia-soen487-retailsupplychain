/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import javax.xml.bind.annotation.*;

/**
 *
 * @author root
 */
@XmlRootElement
public class Item {

    private String productName;
    private String manufacturerName;
    private String productType;
    private float unitPrice;
    private int quantity;

    public Item() {
    }

    public Item(String productName, String manufacturerName, String productType, float unitPrice, int quantity) {
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.productType = productType;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @XmlElement(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @XmlElement(name = "manufacturerName")
    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @XmlElement(name = "productType")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @XmlElement(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlElement(name = "unitPrice")
    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

}
