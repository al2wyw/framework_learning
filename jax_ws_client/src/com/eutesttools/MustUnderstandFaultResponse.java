
package com.eutesttools;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MustUnderstandFaultResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mustUnderstandFaultResult"
})
@XmlRootElement(name = "MustUnderstandFaultResponse")
public class MustUnderstandFaultResponse {

    @XmlElement(name = "MustUnderstandFaultResult")
    protected String mustUnderstandFaultResult;

    /**
     * Gets the value of the mustUnderstandFaultResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMustUnderstandFaultResult() {
        return mustUnderstandFaultResult;
    }

    /**
     * Sets the value of the mustUnderstandFaultResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMustUnderstandFaultResult(String value) {
        this.mustUnderstandFaultResult = value;
    }

}
