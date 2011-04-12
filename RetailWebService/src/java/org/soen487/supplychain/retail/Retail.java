/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.retail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import org.soen487.supplychain.warehouse.*;


/**
 *
 * @author jose
 */
@WebService()
public class Retail {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WarehouseService/WarehouseService.wsdl")


    /**
     * Web service operation
     */
    @WebMethod(operationName = "submitOrder")
    public ItemShippingStatusList submitOrder(@WebParam(name = "itemList")
    ItemList itemList, @WebParam(name = "custInfo")
    Customer custInfo) {
        submitOrder order = new submitOrder(itemList, custInfo);

        return order.execute();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCatalog")

    public ProductList getCatalog() {
        try {
            ProductList productCatalog = new ProductList();
            provideCatalog tester = new provideCatalog();
            productCatalog = tester.getItems();
            System.out.println(tester.getItems());
            return productCatalog;

        } catch(Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

}
