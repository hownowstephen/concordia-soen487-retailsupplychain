/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class ItemShippingStatusList {

    private ArrayList<ItemStatus> items;
    
    public ItemShippingStatusList() {
        this.items = new ArrayList<ItemStatus>();
    }

    public void add(Item item, boolean status){
        this.items.add(new ItemStatus(item,status));
    }

    public ArrayList<ItemStatus> getItems() {
        return items;
    }

}
