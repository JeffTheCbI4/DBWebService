//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.4 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.06.09 at 12:24:47 AM KRAT 
//


package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="org" type="{http://webservice}table"/&gt;
 *         &lt;element name="statusN" type="{http://webservice}table"/&gt;
 *         &lt;element name="userS" type="{http://webservice}table"/&gt;
 *         &lt;element name="machine" type="{http://webservice}table"/&gt;
 *         &lt;element name="orgMachine" type="{http://webservice}table"/&gt;
 *         &lt;element name="locats" type="{http://webservice}table"/&gt;
 *         &lt;element name="texts" type="{http://webservice}table"/&gt;
 *         &lt;element name="textScan" type="{http://webservice}table"/&gt;
 *         &lt;element name="stb" type="{http://webservice}table"/&gt;
 *         &lt;element name="status" type="{http://webservice}table"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "org",
    "statusN",
    "userS",
    "machine",
    "orgMachine",
    "locats",
    "texts",
    "textScan",
    "stb",
    "status"
})
@XmlRootElement(name = "dataExchangeResponse")
public class DataExchangeResponse {

    @XmlElement(required = true)
    protected Table org;
    @XmlElement(required = true)
    protected Table statusN;
    @XmlElement(required = true)
    protected Table userS;
    @XmlElement(required = true)
    protected Table machine;
    @XmlElement(required = true)
    protected Table orgMachine;
    @XmlElement(required = true)
    protected Table locats;
    @XmlElement(required = true)
    protected Table texts;
    @XmlElement(required = true)
    protected Table textScan;
    @XmlElement(required = true)
    protected Table stb;
    @XmlElement(required = true)
    protected Table status;

    /**
     * Gets the value of the org property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getOrg() {
        return org;
    }

    /**
     * Sets the value of the org property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setOrg(Table value) {
        this.org = value;
    }

    /**
     * Gets the value of the statusN property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getStatusN() {
        return statusN;
    }

    /**
     * Sets the value of the statusN property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setStatusN(Table value) {
        this.statusN = value;
    }

    /**
     * Gets the value of the userS property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getUserS() {
        return userS;
    }

    /**
     * Sets the value of the userS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setUserS(Table value) {
        this.userS = value;
    }

    /**
     * Gets the value of the machine property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getMachine() {
        return machine;
    }

    /**
     * Sets the value of the machine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setMachine(Table value) {
        this.machine = value;
    }

    /**
     * Gets the value of the orgMachine property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getOrgMachine() {
        return orgMachine;
    }

    /**
     * Sets the value of the orgMachine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setOrgMachine(Table value) {
        this.orgMachine = value;
    }

    /**
     * Gets the value of the locats property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getLocats() {
        return locats;
    }

    /**
     * Sets the value of the locats property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setLocats(Table value) {
        this.locats = value;
    }

    /**
     * Gets the value of the texts property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getTexts() {
        return texts;
    }

    /**
     * Sets the value of the texts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setTexts(Table value) {
        this.texts = value;
    }

    /**
     * Gets the value of the textScan property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getTextScan() {
        return textScan;
    }

    /**
     * Sets the value of the textScan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setTextScan(Table value) {
        this.textScan = value;
    }

    /**
     * Gets the value of the stb property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getStb() {
        return stb;
    }

    /**
     * Sets the value of the stb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setStb(Table value) {
        this.stb = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Table }
     *     
     */
    public Table getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Table }
     *     
     */
    public void setStatus(Table value) {
        this.status = value;
    }

}
