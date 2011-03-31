
package org.soen487.supplychain.warehouse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.soen487.supplychain.warehouse package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ShipGoods_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "shipGoods");
    private final static QName _ShipGoodsResponse_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "shipGoodsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.soen487.supplychain.warehouse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link ItemList }
     * 
     */
    public ItemList createItemList() {
        return new ItemList();
    }

    /**
     * Create an instance of {@link ShipGoods }
     * 
     */
    public ShipGoods createShipGoods() {
        return new ShipGoods();
    }

    /**
     * Create an instance of {@link ShipGoodsResponse }
     * 
     */
    public ShipGoodsResponse createShipGoodsResponse() {
        return new ShipGoodsResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link ItemShippingStatusList }
     * 
     */
    public ItemShippingStatusList createItemShippingStatusList() {
        return new ItemShippingStatusList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShipGoods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "shipGoods")
    public JAXBElement<ShipGoods> createShipGoods(ShipGoods value) {
        return new JAXBElement<ShipGoods>(_ShipGoods_QNAME, ShipGoods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShipGoodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "shipGoodsResponse")
    public JAXBElement<ShipGoodsResponse> createShipGoodsResponse(ShipGoodsResponse value) {
        return new JAXBElement<ShipGoodsResponse>(_ShipGoodsResponse_QNAME, ShipGoodsResponse.class, null, value);
    }

}
