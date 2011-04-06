/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.soen487.supplychain.warehouse;

import javax.xml.bind.annotation.*;

/**
 *
 * @author root
 */
@XmlRootElement
public class Customer {

    private int customerReferenceNumber;
    private String name;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;

    public Customer() {
    }

    public Customer(int customerReferenceNumber, String name, String street1, String street2, String city, String state, String country) {
        this.customerReferenceNumber = customerReferenceNumber;
        this.name = name;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @XmlElement(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "customerReferenceNumber")
    public int getCustomerReferenceNumber() {
        return customerReferenceNumber;
    }

    public void setCustomerReferenceNumber(int customerReferenceNumber) {
        this.customerReferenceNumber = customerReferenceNumber;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlElement(name = "street1")
    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    @XmlElement(name = "street2")
    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

}
