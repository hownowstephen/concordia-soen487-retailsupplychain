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
    private boolean status;

    public ItemStatus() {}

    public ItemStatus(Item item, boolean status) {
        this.item = item;
        this.status = status;
    }

    @XmlElement(name = "item")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @XmlElement(name = "status")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
