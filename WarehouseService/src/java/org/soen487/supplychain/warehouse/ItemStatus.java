/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import javax.xml.bind.annotation.*;

/**
 *
 * @author root
 */
@XmlRootElement
public class ItemStatus {

    private Item item;
    private int shipped;
    private int not_shipped;

    public ItemStatus() {}

    public ItemStatus(Item item, int quantity) {
        this.item = item;
        this.shipped = quantity;
        this.not_shipped = 0;
    }

    @XmlElement(name = "item")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @XmlElement(name = "shipped")
    public int getShippedQuatity(){
        return shipped;
    }

    public void setShippedQuatity(int quantity) {
        this.shipped = quantity;
    }

    @XmlElement(name = "not_shipped")
    public int getNot_shipped(){
        return not_shipped;
    }

    public void setNot_shipped(int quantity) {
        this.not_shipped = quantity;
    }

}
