
package org.soen487.supplychain.retail;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.soen487.supplychain.retail package. 
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

    private final static QName _SubmitOrder_QNAME = new QName("http://retail.supplychain.soen487.org/", "submitOrder");
    private final static QName _SubmitOrderResponse_QNAME = new QName("http://retail.supplychain.soen487.org/", "submitOrderResponse");
    private final static QName _GetCatalogResponse_QNAME = new QName("http://retail.supplychain.soen487.org/", "getCatalogResponse");
    private final static QName _GetCatalog_QNAME = new QName("http://retail.supplychain.soen487.org/", "getCatalog");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.soen487.supplychain.retail
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCatalogResponse }
     * 
     */
    public GetCatalogResponse createGetCatalogResponse() {
        return new GetCatalogResponse();
    }

    /**
     * Create an instance of {@link GetCatalog }
     * 
     */
    public GetCatalog createGetCatalog() {
        return new GetCatalog();
    }

    /**
     * Create an instance of {@link SubmitOrder }
     * 
     */
    public SubmitOrder createSubmitOrder() {
        return new SubmitOrder();
    }

    /**
     * Create an instance of {@link SubmitOrderResponse }
     * 
     */
    public SubmitOrderResponse createSubmitOrderResponse() {
        return new SubmitOrderResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://retail.supplychain.soen487.org/", name = "submitOrder")
    public JAXBElement<SubmitOrder> createSubmitOrder(SubmitOrder value) {
        return new JAXBElement<SubmitOrder>(_SubmitOrder_QNAME, SubmitOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://retail.supplychain.soen487.org/", name = "submitOrderResponse")
    public JAXBElement<SubmitOrderResponse> createSubmitOrderResponse(SubmitOrderResponse value) {
        return new JAXBElement<SubmitOrderResponse>(_SubmitOrderResponse_QNAME, SubmitOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://retail.supplychain.soen487.org/", name = "getCatalogResponse")
    public JAXBElement<GetCatalogResponse> createGetCatalogResponse(GetCatalogResponse value) {
        return new JAXBElement<GetCatalogResponse>(_GetCatalogResponse_QNAME, GetCatalogResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalog }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://retail.supplychain.soen487.org/", name = "getCatalog")
    public JAXBElement<GetCatalog> createGetCatalog(GetCatalog value) {
        return new JAXBElement<GetCatalog>(_GetCatalog_QNAME, GetCatalog.class, null, value);
    }

}
