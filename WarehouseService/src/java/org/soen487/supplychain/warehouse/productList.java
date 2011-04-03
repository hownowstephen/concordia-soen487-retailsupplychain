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
 * @author Fabrice
 */
@XmlRootElement
public class productList {

    private ArrayList<String> namesInCatalog;
    private long version;

    public productList() {
        this.namesInCatalog = new ArrayList<String>();
    }

    public void add(String product){
        this.namesInCatalog.add(product);
    }

    @XmlElement(name = "product")
    public ArrayList<String> getItems() {
        return namesInCatalog;
    }

}
