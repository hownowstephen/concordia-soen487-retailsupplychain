/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

/**
 *
 * @author root
 */
@XmlRootElement
public class ItemShippingStatusList {

    private ArrayList<ItemStatus> items;
    
    public ItemShippingStatusList() {
        this.items = new ArrayList<ItemStatus>();
    }

    public ItemShippingStatusList(ArrayList<ItemStatus> list) {
        this.items = list;
    }

    public void add(Item item, int shipped, int not_shipped){
        System.out.println("ItemShippingStatusList >> item: " + item + " shipped: " + shipped + " not shipped: " + not_shipped);
        this.items.add(new ItemStatus(item,shipped,not_shipped));
    }

    @XmlElement(name = "items")
    public ArrayList<ItemStatus> getItems() {
        return items;
    }

}
