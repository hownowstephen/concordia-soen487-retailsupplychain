/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.retail;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceRef;
import org.soen487.supplychain.warehouse.service.ItemShippingStatusList;
import org.soen487.supplychain.warehouse.service.WarehouseService;

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
    @WebMethod(operationName = "submitOrder")
    public ItemShippingStatusList submitOrder(@WebParam(name = "itemList")
    org.soen487.supplychain.warehouse.service.ItemList itemList, @WebParam(name = "custInfo")
    org.soen487.supplychain.warehouse.service.Customer custInfo) {
        ItemShippingStatusList shipStat;
        shipStat = shipGoods(itemList,custInfo);

        // read from shipStat
        // substract from itemList
        // send to next warehouse if necessary

        //modify shipStat to send back

        return shipStat;
    }

    private ItemShippingStatusList shipGoods(org.soen487.supplychain.warehouse.service.ItemList itemList, org.soen487.supplychain.warehouse.service.Customer info) {
        org.soen487.supplychain.warehouse.service.Warehouse port = service.getWarehousePort();
        return port.shipGoods(itemList, info);
    }

}
