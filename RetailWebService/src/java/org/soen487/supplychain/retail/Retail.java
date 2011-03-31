/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.retail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import org.soen487.supplychain.warehouse.ItemShippingStatusList;
import org.soen487.supplychain.warehouse.WarehouseService;


/**
 *
 * @author jose
 */
@WebService()
public class Retail {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WarehouseService/WarehouseService.wsdl")
    private WarehouseService service;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Retail")
    public String Retail(@WebParam(name = "itemList")
    org.soen487.supplychain.warehouse.ItemList itemList, @WebParam(name = "custInfo")
    org.soen487.supplychain.warehouse.Customer custInfo) {
        
        return null;
    }

    private ItemShippingStatusList shipGoods(org.soen487.supplychain.warehouse.ItemList itemList, org.soen487.supplychain.warehouse.Customer info) {
        org.soen487.supplychain.warehouse.Warehouse port = service.getWarehousePort();
        return port.shipGoods(itemList, info);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCatalog")
    public provideCatalog getCatalog() {
        try {
            provideCatalog productCatalog = new provideCatalog();
            return productCatalog;
        } catch(Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }



}
