/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author root
 */
@XmlRootElement
public class ItemList {

    private ArrayList<Item> items;
    private long version;

    public ItemList() {
    }

    public ItemList(ArrayList<Item> items) {
        this.items = items;
    }

    public int size(){
        return this.items.size();
    }

    public Item get(int index){
        return this.items.get(index);
    }

    public void add(Item item){
        this.items.add(item);
    }

    @XmlElement(name = "items")
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


}
