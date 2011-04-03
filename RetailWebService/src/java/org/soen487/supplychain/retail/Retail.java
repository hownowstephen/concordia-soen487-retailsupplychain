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
    @WebMethod(operationName = "Retail")
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

    public productCatalog getCatalog() {
        try {
            productCatalog productCatalog = new productCatalog();
            System.out.println("in webmethod");
            return productCatalog;
            
        } catch(Exception e){
            System.out.println("error: " + e.getMessage());
            return null;
        }
    }

}
