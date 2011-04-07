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

            System.out.println(" ---->> Response from warehouse call: " + ship_info);

            for (ItemStatus x : ship_info.getItems()) {
                System.out.println("--- execute BEFORE CLONE (ORIGINAL)-->> shipped quantity: " + x.getShipped() + " ptoductName: " + x.getItem().getProductName());
            }

            // Copy the first call as the first status list of the order from client
            if(order_status == null){
                System.out.println(" 1) Cloning Shipping Status list ... ");
                deepClone();
                System.out.println(" 2) Finished Cloning Shipping Status list ");
            }
            for(ItemStatus x : ship_info.getItems()){
                System.out.println("--- execute AFTER CLONE (ORIGINAL) -->> shipped quantity: " + x.getShipped() + " ptoductName: " + x.getItem().getProductName());
            }
            for(ItemStatus x : order_status.getItems()){
                System.out.println("--- execute AFTER CLONE (COPY) -->> shipped quantity: " + x.getShipped() + " ptoductName: " + x.getItem().getProductName());
            }
            System.out.println("-- called updateLists --");
            updateLists(ship_info.getItems(), itemList.getItems(), order_status.getItems());
            System.out.println("-- finished updateLists --");

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
            System.out.println("------- Item " + x + " --------");
            System.out.println("order_list: ProductName = " + order_list.get(x).getProductName() + " ProductType = " + order_list.get(x).getProductType() + " Quantity = " + order_list.get(x).getQuantity());
            System.out.println("shipped_list: ProductName = "+ shipped_list.get(x).getItem().getProductName() + " ProductType = " + shipped_list.get(x).getItem().getProductType() + " shipped = " + shipped_list.get(x).getShipped() );
            System.out.println("BEFORE track_order_list: ProductName = " + track_order_list.get(x).getItem().getProductName() + " ProductType = " + track_order_list.get(x).getItem().getProductType() + " shipped = " + track_order_list.get(x).getShipped() + " not shipped = " +  track_order_list.get(x).getNotShipped() );
            System.out.println("-------------------------------");
            // update ordered item with what's left to order from previous call to warehouse.
            order_list.get(x).setQuantity(shipped_list.get(x).getNotShipped());
            track_order_list.get(x).setNotShipped(track_order_list.get(x).getNotShipped() - shipped_list.get(x).getShipped());
            track_order_list.get(x).setShipped(track_order_list.get(x).getShipped() + shipped_list.get(x).getShipped());
            System.out.println(" AFTER track_order_list: ProductName = " + track_order_list.get(x).getItem().getProductName() + " ProductType = " + track_order_list.get(x).getItem().getProductType() + " shipped = " + track_order_list.get(x).getShipped() + " not shipped = " +  track_order_list.get(x).getNotShipped() );

        }



    }

    private void deepClone(){
        System.out.println(" 1) Cloning Shipping Status list ... ");
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

        System.out.println(" Cloned List: " + order_status);

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
