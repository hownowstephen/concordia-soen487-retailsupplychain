/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

/**
 *
 * @author root
 */
public class ItemStatus {

    private Item item;
    private boolean status;

    public ItemStatus() {}

    public ItemStatus(Item item, boolean status) {
        this.item = item;
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
