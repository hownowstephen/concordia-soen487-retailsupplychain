/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Fabrice
 */
@XmlRootElement
public class productList {

    private ArrayList<product> InfoForCatalog;
    private long version;

    public productList() {
        this.InfoForCatalog = new ArrayList<product>();
    }

    public int size(){
        return this.InfoForCatalog.size();
    }

    public product get(int index){
        return this.InfoForCatalog.get(index);
    }
//
//    public void add(product productInfo){
//        this.InfoForCatalog.add(productInfo);
//    }

    @XmlElement(name = "product")
    public ArrayList<product> getItems() {
        return InfoForCatalog;
    }

    public void setCatalog(String manName, String prodType, Float prodValue) {
        product productInfo = new product(manName, prodType, prodValue);
        this.InfoForCatalog.add(productInfo);
    }
}
