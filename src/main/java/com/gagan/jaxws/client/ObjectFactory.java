
package com.gagan.jaxws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gagan.jaxws.client package. 
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

    private final static QName _GetAllPlanets_QNAME = new QName("http://soap.service.gagan.com/", "getAllPlanets");
    private final static QName _GetAllPlanetsResponse_QNAME = new QName("http://soap.service.gagan.com/", "getAllPlanetsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gagan.jaxws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllPlanetsResponse }
     * 
     */
    public GetAllPlanetsResponse createGetAllPlanetsResponse() {
        return new GetAllPlanetsResponse();
    }

    /**
     * Create an instance of {@link GetAllPlanets }
     * 
     */
    public GetAllPlanets createGetAllPlanets() {
        return new GetAllPlanets();
    }

    /**
     * Create an instance of {@link PlanetVertex }
     * 
     */
    public PlanetVertex createPlanetVertex() {
        return new PlanetVertex();
    }

    /**
     * Create an instance of {@link Edge }
     * 
     */
    public Edge createEdge() {
        return new Edge();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPlanets }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.gagan.com/", name = "getAllPlanets")
    public JAXBElement<GetAllPlanets> createGetAllPlanets(GetAllPlanets value) {
        return new JAXBElement<GetAllPlanets>(_GetAllPlanets_QNAME, GetAllPlanets.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPlanetsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.service.gagan.com/", name = "getAllPlanetsResponse")
    public JAXBElement<GetAllPlanetsResponse> createGetAllPlanetsResponse(GetAllPlanetsResponse value) {
        return new JAXBElement<GetAllPlanetsResponse>(_GetAllPlanetsResponse_QNAME, GetAllPlanetsResponse.class, null, value);
    }

}
