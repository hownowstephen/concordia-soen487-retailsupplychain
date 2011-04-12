/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.retail;


import org.soen487.supplychain.warehouse.*;
/**
 *
 * @author Fabrice
 */
public class provideCatalog {
    private ProductList catalog;

    provideCatalog(){
        this.catalog = getInfoForCatalog();
        System.out.println("test: "+this.catalog);
    }

    private static ProductList getInfoForCatalog() {
        org.soen487.supplychain.warehouse.WarehouseService service = new org.soen487.supplychain.warehouse.WarehouseService();
        org.soen487.supplychain.warehouse.Warehouse port = service.getWarehousePort();
        return port.getInfoForCatalog(); 
    }


//    public List<String> convertToString(){
//        return this.catalog.getProduct();
//    }

    public ProductList getItems() {
        return catalog;
    }
}