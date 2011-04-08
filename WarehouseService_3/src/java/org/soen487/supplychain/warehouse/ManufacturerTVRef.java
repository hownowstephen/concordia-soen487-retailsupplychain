
package org.soen487.supplychain.warehouse;

import org.soen487.supplychain.manufacturer.Product;
import org.soen487.supplychain.manufacturer.ProductQuantity;

/**
 *
 * @author jose
 */
public class ManufacturerTVRef extends ManufacturerRef {

    public ManufacturerTVRef() {
    }

    public Product getProductInfo(java.lang.String aProductName) {
        org.soen487.supplychain.manufacturer.Manufacturer1Service service = new org.soen487.supplychain.manufacturer.Manufacturer1Service();
        org.soen487.supplychain.manufacturer.Manufacturer1 port = service.getManufacturer1Port();
        return port.getProductInfo(aProductName);
    }

    public ProductQuantity getProductQuantity(java.lang.String aProductName) {
        org.soen487.supplychain.manufacturer.Manufacturer1Service service = new org.soen487.supplychain.manufacturer.Manufacturer1Service();
        org.soen487.supplychain.manufacturer.Manufacturer1 port = service.getManufacturer1Port();
        return port.getProductQuantity(aProductName);
    }

    public boolean receivePayment(java.lang.String orderNum, float totalPrice) {
        org.soen487.supplychain.manufacturer.Manufacturer1Service service = new org.soen487.supplychain.manufacturer.Manufacturer1Service();
        org.soen487.supplychain.manufacturer.Manufacturer1 port = service.getManufacturer1Port();
        return port.receivePayment(orderNum, totalPrice);
    }

    public boolean processPurchaseOrder(org.soen487.supplychain.manufacturer.PurchaseOrder aPO) {
        org.soen487.supplychain.manufacturer.Manufacturer1Service service = new org.soen487.supplychain.manufacturer.Manufacturer1Service();
        org.soen487.supplychain.manufacturer.Manufacturer1 port = service.getManufacturer1Port();
        return port.processPurchaseOrder(aPO);
    }

}
