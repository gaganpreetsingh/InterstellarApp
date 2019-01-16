
package com.gagan.jaxws.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for planetVertex complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planetVertex">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adjacencies" type="{http://soap.service.gagan.com/}edge" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="planetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planetNode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="predecessor" type="{http://soap.service.gagan.com/}planetVertex" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planetVertex", propOrder = {
    "adjacencies",
    "distance",
    "planetName",
    "planetNode",
    "predecessor"
})
public class PlanetVertex {

    @XmlElement(nillable = true)
    protected List<Edge> adjacencies;
    protected double distance;
    protected String planetName;
    protected String planetNode;
    protected PlanetVertex predecessor;

    /**
     * Gets the value of the adjacencies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adjacencies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdjacencies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Edge }
     * 
     * 
     */
    public List<Edge> getAdjacencies() {
        if (adjacencies == null) {
            adjacencies = new ArrayList<Edge>();
        }
        return this.adjacencies;
    }

    /**
     * Gets the value of the distance property.
     * 
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     */
    public void setDistance(double value) {
        this.distance = value;
    }

    /**
     * Gets the value of the planetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanetName() {
        return planetName;
    }

    /**
     * Sets the value of the planetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanetName(String value) {
        this.planetName = value;
    }

    /**
     * Gets the value of the planetNode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanetNode() {
        return planetNode;
    }

    /**
     * Sets the value of the planetNode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanetNode(String value) {
        this.planetNode = value;
    }

    /**
     * Gets the value of the predecessor property.
     * 
     * @return
     *     possible object is
     *     {@link PlanetVertex }
     *     
     */
    public PlanetVertex getPredecessor() {
        return predecessor;
    }

    /**
     * Sets the value of the predecessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanetVertex }
     *     
     */
    public void setPredecessor(PlanetVertex value) {
        this.predecessor = value;
    }

}
