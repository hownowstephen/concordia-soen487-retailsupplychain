/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.soen487.supplychain.manufacturer.Product;
import org.soen487.supplychain.manufacturer.PurchaseOrder;

/**
 *
 * @author jose
 */
public class ManufacturerHandler {

    ManufacturerTVRef MTV;
    ManufacturerCameraRef MC;
    ManufacturerDVDPlayerRef MDP;
    ManufacturerRef MR;
    Pattern TVpattern, Campattern, DVDPpattern;
    Matcher matcher;

    public ManufacturerHandler() {
        MTV = new ManufacturerTVRef();
        MC = new ManufacturerCameraRef();
        MDP = new ManufacturerDVDPlayerRef();
        TVpattern = Pattern.compile("[Tt][Vv]");
        Campattern = Pattern.compile("[Cc][Aa][Mm]");
        DVDPpattern = Pattern.compile("[Dd][Vv][Dd]");
    }

    public Product getProductInfo(String name) {
        MR = determineRef(name);
        if (MR == null) return null;
        return MR.getProductInfo(name);
    }

    public boolean processPurchaseOrder(PurchaseOrder order) {
        MR = determineRef(order.getProduct().getProductName());
        if (MR == null) return false;
        return MR.processPurchaseOrder(order);
    }

    public boolean receivePayment(Product prod, String orderNum, float payment) {
        MR = determineRef(prod.getProductName());
        if (MR == null) return false;
        return MR.receivePayment(orderNum, payment);
    }

    private ManufacturerRef determineRef(String attribute){

        matcher = TVpattern.matcher(attribute);
        if(matcher.find()){
            System.out.println("ManufacturerRef -- calling TVRef");
            return new ManufacturerTVRef();
        }
        matcher = Campattern.matcher(attribute);
        if(matcher.find()){
            System.out.println("ManufacturerRef -- calling CAMRef");
            return new ManufacturerCameraRef();
        }
        matcher = DVDPpattern.matcher(attribute);
        if(matcher.find()){
            System.out.println("ManufacturerRef -- calling DVDRef");
            return new ManufacturerDVDPlayerRef();
        }
        System.out.println("ManufacturerRef -- No match Found");
        return null;

    }


    



}
