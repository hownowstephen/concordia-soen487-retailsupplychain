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
        org.soen487.supplychain.warehouse.Warehouse1Service service = new org.soen487.supplychain.warehouse.Warehouse1Service();
        org.soen487.supplychain.warehouse.Warehouse1 port = service.getWarehouse1Port();
        return port.getInfoForCatalog(); 
    }


//    public List<String> convertToString(){
//        return this.catalog.getProduct();
//    }

    public ProductList getItems() {
        return catalog;
    }
}