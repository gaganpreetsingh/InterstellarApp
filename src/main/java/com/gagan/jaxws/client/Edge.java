
package com.gagan.jaxws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for edge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="edge">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nextVertex" type="{http://soap.service.gagan.com/}planetVertex" minOccurs="0"/>
 *         &lt;element name="parentVertex" type="{http://soap.service.gagan.com/}planetVertex" minOccurs="0"/>
 *         &lt;element name="routeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "edge", propOrder = {
    "nextVertex",
    "parentVertex",
    "routeId",
    "weight"
})
public class Edge {

    protected PlanetVertex nextVertex;
    protected PlanetVertex parentVertex;
    protected Integer routeId;
    protected double weight;

    /**
     * Gets the value of the nextVertex property.
     * 
     * @return
     *     possible object is
     *     {@link PlanetVertex }
     *     
     */
    public PlanetVertex getNextVertex() {
        return nextVertex;
    }

    /**
     * Sets the value of the nextVertex property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanetVertex }
     *     
     */
    public void setNextVertex(PlanetVertex value) {
        this.nextVertex = value;
    }

    /**
     * Gets the value of the parentVertex property.
     * 
     * @return
     *     possible object is
     *     {@link PlanetVertex }
     *     
     */
    public PlanetVertex getParentVertex() {
        return parentVertex;
    }

    /**
     * Sets the value of the parentVertex property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanetVertex }
     *     
     */
    public void setParentVertex(PlanetVertex value) {
        this.parentVertex = value;
    }

    /**
     * Gets the value of the routeId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRouteId() {
        return routeId;
    }

    /**
     * Sets the value of the routeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRouteId(Integer value) {
        this.routeId = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     */
    public void setWeight(double value) {
        this.weight = value;
    }

}
