
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

    private final static QName _ItemShippingStatusList_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "itemShippingStatusList");
    private final static QName _ItemStatus_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "itemStatus");
    private final static QName _Customer_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "customer");
    private final static QName _ShipGoods_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "shipGoods");
    private final static QName _GetInfoForCatalog_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "getInfoForCatalog");
    private final static QName _GetInfoForCatalogResponse_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "getInfoForCatalogResponse");
    private final static QName _ProductList_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "productList");
    private final static QName _Item_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "item");
    private final static QName _ItemList_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "itemList");
    private final static QName _ShipGoodsResponse_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "shipGoodsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.soen487.supplychain.warehouse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShipGoods }
     * 
     */
    public ShipGoods createShipGoods() {
        return new ShipGoods();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link GetInfoForCatalog }
     * 
     */
    public GetInfoForCatalog createGetInfoForCatalog() {
        return new GetInfoForCatalog();
    }

    /**
     * Create an instance of {@link ItemStatus }
     * 
     */
    public ItemStatus createItemStatus() {
        return new ItemStatus();
    }

    /**
     * Create an instance of {@link ProductList }
     * 
     */
    public ProductList createProductList() {
        return new ProductList();
    }

    /**
     * Create an instance of {@link ItemShippingStatusList }
     * 
     */
    public ItemShippingStatusList createItemShippingStatusList() {
        return new ItemShippingStatusList();
    }

    /**
     * Create an instance of {@link GetInfoForCatalogResponse }
     * 
     */
    public GetInfoForCatalogResponse createGetInfoForCatalogResponse() {
        return new GetInfoForCatalogResponse();
    }

    /**
     * Create an instance of {@link ShipGoodsResponse }
     * 
     */
    public ShipGoodsResponse createShipGoodsResponse() {
        return new ShipGoodsResponse();
    }

    /**
     * Create an instance of {@link ItemList }
     * 
     */
    public ItemList createItemList() {
        return new ItemList();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemShippingStatusList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "itemShippingStatusList")
    public JAXBElement<ItemShippingStatusList> createItemShippingStatusList(ItemShippingStatusList value) {
        return new JAXBElement<ItemShippingStatusList>(_ItemShippingStatusList_QNAME, ItemShippingStatusList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "itemStatus")
    public JAXBElement<ItemStatus> createItemStatus(ItemStatus value) {
        return new JAXBElement<ItemStatus>(_ItemStatus_QNAME, ItemStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoForCatalog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "getInfoForCatalog")
    public JAXBElement<GetInfoForCatalog> createGetInfoForCatalog(GetInfoForCatalog value) {
        return new JAXBElement<GetInfoForCatalog>(_GetInfoForCatalog_QNAME, GetInfoForCatalog.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoForCatalogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "getInfoForCatalogResponse")
    public JAXBElement<GetInfoForCatalogResponse> createGetInfoForCatalogResponse(GetInfoForCatalogResponse value) {
        return new JAXBElement<GetInfoForCatalogResponse>(_GetInfoForCatalogResponse_QNAME, GetInfoForCatalogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "productList")
    public JAXBElement<ProductList> createProductList(ProductList value) {
        return new JAXBElement<ProductList>(_ProductList_QNAME, ProductList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.supplychain.soen487.org/", name = "itemList")
    public JAXBElement<ItemList> createItemList(ItemList value) {
        return new JAXBElement<ItemList>(_ItemList_QNAME, ItemList.class, null, value);
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
