/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

/**
 *
 * @author Fabrice
 */
public class product {

    // Member variables
    private String productName;
    private String manufacturerName;
    private String productType;
    private Float unitPrice;

    public product() {
    }

    product(String manufacturerName, String productType, Float unitPrice) {
        this.manufacturerName = manufacturerName;
        this.productType = productType;
        this.unitPrice = unitPrice;
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
        this.productType = productType;
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

