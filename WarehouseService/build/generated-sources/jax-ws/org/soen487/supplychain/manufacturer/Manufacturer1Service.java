
package org.soen487.supplychain.manufacturer;

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
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Manufacturer1Service", targetNamespace = "http://manufacturer.supplychain.soen487.org/", wsdlLocation = "http://localhost:8080/ManufacturerService/Manufacturer1Service?wsdl")
public class Manufacturer1Service
    extends Service
{

    private final static URL MANUFACTURER1SERVICE_WSDL_LOCATION;
    private final static WebServiceException MANUFACTURER1SERVICE_EXCEPTION;
    private final static QName MANUFACTURER1SERVICE_QNAME = new QName("http://manufacturer.supplychain.soen487.org/", "Manufacturer1Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ManufacturerService/Manufacturer1Service?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MANUFACTURER1SERVICE_WSDL_LOCATION = url;
        MANUFACTURER1SERVICE_EXCEPTION = e;
    }

    public Manufacturer1Service() {
        super(__getWsdlLocation(), MANUFACTURER1SERVICE_QNAME);
    }

    public Manufacturer1Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), MANUFACTURER1SERVICE_QNAME, features);
    }

    public Manufacturer1Service(URL wsdlLocation) {
        super(wsdlLocation, MANUFACTURER1SERVICE_QNAME);
    }

    public Manufacturer1Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MANUFACTURER1SERVICE_QNAME, features);
    }

    public Manufacturer1Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Manufacturer1Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Manufacturer1
     */
    @WebEndpoint(name = "Manufacturer1Port")
    public Manufacturer1 getManufacturer1Port() {
        return super.getPort(new QName("http://manufacturer.supplychain.soen487.org/", "Manufacturer1Port"), Manufacturer1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Manufacturer1
     */
    @WebEndpoint(name = "Manufacturer1Port")
    public Manufacturer1 getManufacturer1Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://manufacturer.supplychain.soen487.org/", "Manufacturer1Port"), Manufacturer1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MANUFACTURER1SERVICE_EXCEPTION!= null) {
            throw MANUFACTURER1SERVICE_EXCEPTION;
        }
        return MANUFACTURER1SERVICE_WSDL_LOCATION;
    }

}
