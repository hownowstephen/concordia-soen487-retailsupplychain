
package org.soen487.supplychain.retail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.soen487.supplychain.warehouse.ItemShippingStatusList;


/**
 * <p>Java class for submitOrderResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="submitOrderResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://warehouse.supplychain.soen487.org/}itemShippingStatusList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "submitOrderResponse", propOrder = {
    "_return"
})
public class SubmitOrderResponse {

    @XmlElement(name = "return")
    protected ItemShippingStatusList _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ItemShippingStatusList }
     *     
     */
    public ItemShippingStatusList getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemShippingStatusList }
     *     
     */
    public void setReturn(ItemShippingStatusList value) {
        this._return = value;
    }

}
