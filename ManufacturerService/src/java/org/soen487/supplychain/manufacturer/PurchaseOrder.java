/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.manufacturer;

/**
 *
 * @author st_youn
 * PurchaseOrder: orderNum (String),
 * customerRef (String),
 * product (Product),
 * quantity (int),
 * unitPrice (float).
 */
public class PurchaseOrder {

    private String orderNum;
    private String customerRef;
    private Product product;
    private int quantity;
    private float unitPrice;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String orderNum, String customerRef, Product product, int quantity, float unitPrice) {
        this.orderNum = orderNum;
        this.customerRef = customerRef;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

}
