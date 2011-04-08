/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.retail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.soen487.supplychain.warehouse.*;

/**
 *
 * @author Jose
 */
public class submitOrder {

    private List<Integer> warehouse_indexes;
    private ItemShippingStatusList ship_info;
    private ItemList itemList;
    private Customer custInfo;
    private ItemShippingStatusList order_status;
    private boolean order_complete;

    public submitOrder() {
    }

    submitOrder(ItemList itemList, Customer custInfo) {
        this.itemList = itemList;
        this.custInfo = custInfo;
        order_complete = false;

    }

    public ItemShippingStatusList execute() {
        warehouse_indexes = Arrays.asList(1, 2, 3);
        Collections.shuffle(warehouse_indexes); // sets a random ordered list of warehouse to be called

        // call the warehouses in the random ordered list
        for(Integer warehouse : warehouse_indexes){

            ship_info = warehouse_call(itemList, custInfo, warehouse.intValue());

            // Copy the first call as the first status list of the order from client
            if(order_status == null){
                deepClone();
            }

            updateLists(ship_info.getItems(), itemList.getItems(), order_status.getItems());

            // determine if order has been complete
            order_complete = true;
            for(Item i : itemList.getItems()){
                if(i.getQuantity() != 0){
                    order_complete = false;
                    break;
                }
            }

            if(order_complete){
                System.out.println("-- Order Ccomplete --");
                break;
            }else{
                 System.out.println("-- Order NOT Ccomplete --");
            }
            
        }
        return order_status;
    }

    private ItemShippingStatusList warehouse_call(ItemList itemList, Customer custInfo, int rand) {
        switch (rand) {
            case 1: // Warehouse 1
                System.out.println(" -->> calling warehouse 1");
                return shipGoods(itemList, custInfo);
            case 2: // Warehouse 2
                System.out.println(" -->> calling warehouse 2");
                return shipGoods_2(itemList, custInfo);
            case 3: // Warehouse 3
                System.out.println(" -->> calling warehouse 3");
                return shipGoods_3(itemList, custInfo);
            default:
                System.out.println(" -->> no calls, something failed with random index!!");
                return null;
        }
    }

    private void updateLists(List<ItemStatus> shipped_list, List<Item> order_list, List<ItemStatus> track_order_list) {

        for(int x = order_list.size()-1; x >= 0 ; x--){
            // update ordered item with what's left to order from previous call to warehouse.
            order_list.get(x).setQuantity(shipped_list.get(x).getNotShipped());
            track_order_list.get(x).setNotShipped(track_order_list.get(x).getNotShipped() - shipped_list.get(x).getShipped());
            track_order_list.get(x).setShipped(track_order_list.get(x).getShipped() + shipped_list.get(x).getShipped());
        }



    }

    private void deepClone(){
        ArrayList<ItemStatus> i = (ArrayList<ItemStatus>) ship_info.getItems();

        order_status = new ItemShippingStatusList();
        ArrayList<ItemStatus> order_status_list = (ArrayList<ItemStatus>) order_status.getItems();

        for (ItemStatus x : i){
            ItemStatus temp = new ItemStatus();
            temp.setItem(x.getItem());
            temp.setShipped(0);
            temp.setNotShipped(x.getNotShipped()+x.getShipped());
            order_status_list.add(temp);
            
        }
    }

    private static ItemShippingStatusList shipGoods(org.soen487.supplychain.warehouse.ItemList itemList, org.soen487.supplychain.warehouse.Customer info) {
        org.soen487.supplychain.warehouse.Warehouse1Service service = new org.soen487.supplychain.warehouse.Warehouse1Service();
        org.soen487.supplychain.warehouse.Warehouse1 port = service.getWarehouse1Port();
        return port.shipGoods(itemList, info);
    }

    private static ItemShippingStatusList shipGoods_2(org.soen487.supplychain.warehouse.ItemList itemList, org.soen487.supplychain.warehouse.Customer info) {
        org.soen487.supplychain.warehouse.Warehouse2Service service = new org.soen487.supplychain.warehouse.Warehouse2Service();
        org.soen487.supplychain.warehouse.Warehouse2 port = service.getWarehouse2Port();
        return port.shipGoods(itemList, info);
    }

    private static ItemShippingStatusList shipGoods_3(org.soen487.supplychain.warehouse.ItemList itemList, org.soen487.supplychain.warehouse.Customer info) {
        org.soen487.supplychain.warehouse.Warehouse3Service service = new org.soen487.supplychain.warehouse.Warehouse3Service();
        org.soen487.supplychain.warehouse.Warehouse3 port = service.getWarehouse3Port();
        return port.shipGoods(itemList, info);
    }


}
