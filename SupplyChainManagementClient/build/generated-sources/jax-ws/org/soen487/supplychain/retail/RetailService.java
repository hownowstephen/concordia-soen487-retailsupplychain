
package org.soen487.supplychain.retail;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.1-hudson-28-
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RetailService", targetNamespace = "http://retail.supplychain.soen487.org/", wsdlLocation = "http://localhost:8080/RetailWebService/RetailService?wsdl")
public class RetailService
    extends Service
{

    private final static URL RETAILSERVICE_WSDL_LOCATION;
    private final static WebServiceException RETAILSERVICE_EXCEPTION;
    private final static QName RETAILSERVICE_QNAME = new QName("http://retail.supplychain.soen487.org/", "RetailService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/RetailWebService/RetailService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RETAILSERVICE_WSDL_LOCATION = url;
        RETAILSERVICE_EXCEPTION = e;
    }

    public RetailService() {
        super(__getWsdlLocation(), RETAILSERVICE_QNAME);
    }

    public RetailService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RETAILSERVICE_QNAME, features);
    }

    public RetailService(URL wsdlLocation) {
        super(wsdlLocation, RETAILSERVICE_QNAME);
    }

    public RetailService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RETAILSERVICE_QNAME, features);
    }

    public RetailService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RetailService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Retail
     */
    @WebEndpoint(name = "RetailPort")
    public Retail getRetailPort() {
        return super.getPort(new QName("http://retail.supplychain.soen487.org/", "RetailPort"), Retail.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Retail
     */
    @WebEndpoint(name = "RetailPort")
    public Retail getRetailPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://retail.supplychain.soen487.org/", "RetailPort"), Retail.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RETAILSERVICE_EXCEPTION!= null) {
            throw RETAILSERVICE_EXCEPTION;
        }
        return RETAILSERVICE_WSDL_LOCATION;
    }

}
