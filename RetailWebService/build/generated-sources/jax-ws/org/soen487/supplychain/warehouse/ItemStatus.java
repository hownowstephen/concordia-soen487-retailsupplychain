
package org.soen487.supplychain.warehouse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itemStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="item" type="{http://warehouse.supplychain.soen487.org/}item" minOccurs="0"/>
 *         &lt;element name="not_shipped" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shipped" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemStatus", propOrder = {
    "item",
    "notShipped",
    "shipped"
})
public class ItemStatus {

    protected Item item;
    @XmlElement(name = "not_shipped")
    protected int notShipped;
    protected int shipped;

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setItem(Item value) {
        this.item = value;
    }

    /**
     * Gets the value of the notShipped property.
     * 
     */
    public int getNotShipped() {
        return notShipped;
    }

    /**
     * Sets the value of the notShipped property.
     * 
     */
    public void setNotShipped(int value) {
        this.notShipped = value;
    }

    /**
     * Gets the value of the shipped property.
     * 
     */
    public int getShipped() {
        return shipped;
    }

    /**
     * Sets the value of the shipped property.
     * 
     */
    public void setShipped(int value) {
        this.shipped = value;
    }

}
