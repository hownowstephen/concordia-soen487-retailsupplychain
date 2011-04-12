
package org.soen487.supplychain.warehouse;

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
@WebServiceClient(name = "Warehouse_1Service", targetNamespace = "http://warehouse.supplychain.soen487.org/", wsdlLocation = "http://localhost:8080/WarehouseService/Warehouse_1Service?wsdl")
public class Warehouse1Service
    extends Service
{

    private final static URL WAREHOUSE1SERVICE_WSDL_LOCATION;
    private final static WebServiceException WAREHOUSE1SERVICE_EXCEPTION;
    private final static QName WAREHOUSE1SERVICE_QNAME = new QName("http://warehouse.supplychain.soen487.org/", "Warehouse_1Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WarehouseService/Warehouse_1Service?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WAREHOUSE1SERVICE_WSDL_LOCATION = url;
        WAREHOUSE1SERVICE_EXCEPTION = e;
    }

    public Warehouse1Service() {
        super(__getWsdlLocation(), WAREHOUSE1SERVICE_QNAME);
    }

    public Warehouse1Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WAREHOUSE1SERVICE_QNAME, features);
    }

    public Warehouse1Service(URL wsdlLocation) {
        super(wsdlLocation, WAREHOUSE1SERVICE_QNAME);
    }

    public Warehouse1Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WAREHOUSE1SERVICE_QNAME, features);
    }

    public Warehouse1Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Warehouse1Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Warehouse1
     */
    @WebEndpoint(name = "Warehouse_1Port")
    public Warehouse1 getWarehouse1Port() {
        return super.getPort(new QName("http://warehouse.supplychain.soen487.org/", "Warehouse_1Port"), Warehouse1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Warehouse1
     */
    @WebEndpoint(name = "Warehouse_1Port")
    public Warehouse1 getWarehouse1Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://warehouse.supplychain.soen487.org/", "Warehouse_1Port"), Warehouse1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WAREHOUSE1SERVICE_EXCEPTION!= null) {
            throw WAREHOUSE1SERVICE_EXCEPTION;
        }
        return WAREHOUSE1SERVICE_WSDL_LOCATION;
    }

}
