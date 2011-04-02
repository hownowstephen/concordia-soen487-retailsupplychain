<<<<<<< HEAD:RetailWebService/build/generated-sources/jax-ws/org/soen487/supplychain/warehouse/ShipGoods.java

package org.soen487.supplychain.warehouse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shipGoods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shipGoods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemList" type="{http://warehouse.supplychain.soen487.org/}itemList" minOccurs="0"/>
 *         &lt;element name="info" type="{http://warehouse.supplychain.soen487.org/}customer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipGoods", propOrder = {
    "itemList",
    "info"
})
public class ShipGoods {

    protected ItemList itemList;
    protected Customer info;

    /**
     * Gets the value of the itemList property.
     * 
     * @return
     *     possible object is
     *     {@link ItemList }
     *     
     */
    public ItemList getItemList() {
        return itemList;
    }

    /**
     * Sets the value of the itemList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemList }
     *     
     */
    public void setItemList(ItemList value) {
        this.itemList = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setInfo(Customer value) {
        this.info = value;
    }

}
=======

package org.soen487.supplychain.retail.warehouse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shipGoods complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shipGoods">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itemList" type="{http://warehouse.supplychain.soen487.org/}itemList" minOccurs="0"/>
 *         &lt;element name="info" type="{http://warehouse.supplychain.soen487.org/}customer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shipGoods", propOrder = {
    "itemList",
    "info"
})
public class ShipGoods {

    protected ItemList itemList;
    protected Customer info;

    /**
     * Gets the value of the itemList property.
     * 
     * @return
     *     possible object is
     *     {@link ItemList }
     *     
     */
    public ItemList getItemList() {
        return itemList;
    }

    /**
     * Sets the value of the itemList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemList }
     *     
     */
    public void setItemList(ItemList value) {
        this.itemList = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setInfo(Customer value) {
        this.info = value;
    }

}
>>>>>>> Jose:RetailWebService/build/generated-sources/jax-ws/org/soen487/supplychain/retail/warehouse/ShipGoods.java
