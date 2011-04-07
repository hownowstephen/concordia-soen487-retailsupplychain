package org.soen487.supplychain.warehouse;

import org.soen487.supplychain.manufacturer.Product;
import org.soen487.supplychain.manufacturer.ProductQuantity;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose
 */
public class ManufacturerCameraRef extends ManufacturerRef {

    public ManufacturerCameraRef() {
    }

    public Product getProductInfo(java.lang.String aProductName) {
        org.soen487.supplychain.manufacturer.Manufacturer2Service service = new org.soen487.supplychain.manufacturer.Manufacturer2Service();
        org.soen487.supplychain.manufacturer.Manufacturer2 port = service.getManufacturer2Port();
        return port.getProductInfo(aProductName);
    }

    public ProductQuantity getProductQuantity(java.lang.String aProductName) {
        org.soen487.supplychain.manufacturer.Manufacturer2Service service = new org.soen487.supplychain.manufacturer.Manufacturer2Service();
        org.soen487.supplychain.manufacturer.Manufacturer2 port = service.getManufacturer2Port();
        return port.getProductQuantity(aProductName);
    }

    public boolean receivePayment(java.lang.String orderNum, float totalPrice) {
        org.soen487.supplychain.manufacturer.Manufacturer2Service service = new org.soen487.supplychain.manufacturer.Manufacturer2Service();
        org.soen487.supplychain.manufacturer.Manufacturer2 port = service.getManufacturer2Port();
        return port.receivePayment(orderNum, totalPrice);
    }

    public boolean processPurchaseOrder(org.soen487.supplychain.manufacturer.PurchaseOrder aPO) {
        org.soen487.supplychain.manufacturer.Manufacturer2Service service = new org.soen487.supplychain.manufacturer.Manufacturer2Service();
        org.soen487.supplychain.manufacturer.Manufacturer2 port = service.getManufacturer2Port();
        return port.processPurchaseOrder(aPO);
    }

}
