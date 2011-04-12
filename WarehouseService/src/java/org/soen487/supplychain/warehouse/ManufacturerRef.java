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
public abstract class ManufacturerRef {
    public abstract Product getProductInfo(java.lang.String aProductName);
    public abstract ProductQuantity getProductQuantity(java.lang.String aProductName);
    public abstract boolean receivePayment(java.lang.String orderNum, float totalPrice);
    public abstract boolean processPurchaseOrder(org.soen487.supplychain.manufacturer.PurchaseOrder aPO);

}
