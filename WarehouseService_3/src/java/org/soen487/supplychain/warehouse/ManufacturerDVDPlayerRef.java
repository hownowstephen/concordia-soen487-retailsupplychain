/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import org.soen487.supplychain.manufacturer.Product;
import org.soen487.supplychain.manufacturer.ProductQuantity;

/**
 *
 * @author jose
 */
public class ManufacturerDVDPlayerRef extends ManufacturerRef {

    public ManufacturerDVDPlayerRef() {
    }

    public Product getProductInfo(java.lang.String aProductName) {
        org.soen487.supplychain.manufacturer.Manufacturer3Service service = new org.soen487.supplychain.manufacturer.Manufacturer3Service();
        org.soen487.supplychain.manufacturer.Manufacturer3 port = service.getManufacturer3Port();
        return port.getProductInfo(aProductName);
    }

    public ProductQuantity getProductQuantity(java.lang.String aProductName) {
        org.soen487.supplychain.manufacturer.Manufacturer3Service service = new org.soen487.supplychain.manufacturer.Manufacturer3Service();
        org.soen487.supplychain.manufacturer.Manufacturer3 port = service.getManufacturer3Port();
        return port.getProductQuantity(aProductName);
    }

    public boolean receivePayment(java.lang.String orderNum, float totalPrice) {
        org.soen487.supplychain.manufacturer.Manufacturer3Service service = new org.soen487.supplychain.manufacturer.Manufacturer3Service();
        org.soen487.supplychain.manufacturer.Manufacturer3 port = service.getManufacturer3Port();
        return port.receivePayment(orderNum, totalPrice);
    }

    public boolean processPurchaseOrder(org.soen487.supplychain.manufacturer.PurchaseOrder aPO) {
        org.soen487.supplychain.manufacturer.Manufacturer3Service service = new org.soen487.supplychain.manufacturer.Manufacturer3Service();
        org.soen487.supplychain.manufacturer.Manufacturer3 port = service.getManufacturer3Port();
        return port.processPurchaseOrder(aPO);
    }

}
