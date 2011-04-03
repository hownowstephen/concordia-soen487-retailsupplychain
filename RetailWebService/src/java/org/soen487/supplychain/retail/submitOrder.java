/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.retail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.soen487.supplychain.warehouse.*;

/**
 *
 * @author Jose
 */
public class submitOrder {

    private ArrayList<Integer> warehouse_indexes;
    private ItemShippingStatusList list_stat;
    private ItemList itemList;
    private Customer custInfo;

    public submitOrder() {
    }

    submitOrder(ItemList itemList, Customer custInfo) {
        this.itemList = itemList;
        this.custInfo = custInfo;

    }

    public ItemShippingStatusList execute() {
        warehouse_indexes = (ArrayList<Integer>) Arrays.asList(1, 2, 3);
        Collections.shuffle(warehouse_indexes); // sets a random ordered list of warehouse to be called

        list_stat = warehouse_call(itemList, custInfo, 1); // TEST PURPOSES ONLY - remove eventually

        list_stat.getItems();

        // call the warehouses in the random ordered list
        for(Integer rand : warehouse_indexes){
            list_stat = warehouse_call(itemList, custInfo, rand.intValue());
            updateList(list_stat, itemList);
            
        }
        return null;
    }

    private ItemShippingStatusList warehouse_call(ItemList itemList, Customer custInfo, int rand) {
        switch (rand) {
            case 1: // Warehouse 1
                return shipGoods(itemList, custInfo);
            case 2: // Warehouse 2
                return shipGoods(itemList, custInfo);
            case 3: // Warehouse 3
                return shipGoods(itemList, custInfo);
            default:
                return null;
        }
    }

    private void updateList(ItemShippingStatusList shipped_list, ItemList order_list) {
        
        for(ItemStatus item_stat : shipped_list.getItems()){
            item_stat.getItem().getProductName();
            item_stat.getShippedQuantity();

        }
    }

    private static ItemShippingStatusList shipGoods(org.soen487.supplychain.warehouse.ItemList itemList, org.soen487.supplychain.warehouse.Customer info) {
        org.soen487.supplychain.warehouse.WarehouseService service = new org.soen487.supplychain.warehouse.WarehouseService();
        org.soen487.supplychain.warehouse.Warehouse port = service.getWarehousePort();
        return port.shipGoods(itemList, info);
    }

}
