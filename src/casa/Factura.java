
package casa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para factura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="factura">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ambiente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ci_ruc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detalle_adicional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detalle_adicional_etiqueta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="establecimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="guia_remision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="list_detalle" type="{http://webService/}detalleFactura" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="numero_factura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="punto_emision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razon_social" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "factura", propOrder = {
    "ambiente",
    "ciRuc",
    "detalleAdicional",
    "detalleAdicionalEtiqueta",
    "direccion",
    "email",
    "establecimiento",
    "fecha",
    "guiaRemision",
    "listDetalle",
    "numeroFactura",
    "proveedor",
    "puntoEmision",
    "razonSocial"
})
public class Factura {

    protected int ambiente;
    @XmlElement(name = "ci_ruc")
    protected String ciRuc;
    @XmlElement(name = "detalle_adicional")
    protected String detalleAdicional;
    @XmlElement(name = "detalle_adicional_etiqueta")
    protected String detalleAdicionalEtiqueta;
    protected String direccion;
    protected String email;
    protected String establecimiento;
    protected String fecha;
    @XmlElement(name = "guia_remision")
    protected String guiaRemision;
    @XmlElement(name = "list_detalle", nillable = true)
    protected List<DetalleFactura> listDetalle;
    @XmlElement(name = "numero_factura")
    protected String numeroFactura;
    protected String proveedor;
    @XmlElement(name = "punto_emision")
    protected String puntoEmision;
    @XmlElement(name = "razon_social")
    protected String razonSocial;

    /**
     * Obtiene el valor de la propiedad ambiente.
     * 
     */
    public int getAmbiente() {
        return ambiente;
    }

    /**
     * Define el valor de la propiedad ambiente.
     * 
     */
    public void setAmbiente(int value) {
        this.ambiente = value;
    }

    /**
     * Obtiene el valor de la propiedad ciRuc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiRuc() {
        return ciRuc;
    }

    /**
     * Define el valor de la propiedad ciRuc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiRuc(String value) {
        this.ciRuc = value;
    }

    /**
     * Obtiene el valor de la propiedad detalleAdicional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetalleAdicional() {
        return detalleAdicional;
    }

    /**
     * Define el valor de la propiedad detalleAdicional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetalleAdicional(String value) {
        this.detalleAdicional = value;
    }

    /**
     * Obtiene el valor de la propiedad detalleAdicionalEtiqueta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetalleAdicionalEtiqueta() {
        return detalleAdicionalEtiqueta;
    }

    /**
     * Define el valor de la propiedad detalleAdicionalEtiqueta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetalleAdicionalEtiqueta(String value) {
        this.detalleAdicionalEtiqueta = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad establecimiento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstablecimiento() {
        return establecimiento;
    }

    /**
     * Define el valor de la propiedad establecimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstablecimiento(String value) {
        this.establecimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad guiaRemision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuiaRemision() {
        return guiaRemision;
    }

    /**
     * Define el valor de la propiedad guiaRemision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuiaRemision(String value) {
        this.guiaRemision = value;
    }

    /**
     * Gets the value of the listDetalle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listDetalle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListDetalle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleFactura }
     * 
     * 
     */
    public List<DetalleFactura> getListDetalle() {
        if (listDetalle == null) {
            listDetalle = new ArrayList<DetalleFactura>();
        }
        return this.listDetalle;
    }

    /**
     * Obtiene el valor de la propiedad numeroFactura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * Define el valor de la propiedad numeroFactura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroFactura(String value) {
        this.numeroFactura = value;
    }

    /**
     * Obtiene el valor de la propiedad proveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Define el valor de la propiedad proveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProveedor(String value) {
        this.proveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad puntoEmision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuntoEmision() {
        return puntoEmision;
    }

    /**
     * Define el valor de la propiedad puntoEmision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuntoEmision(String value) {
        this.puntoEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad razonSocial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Define el valor de la propiedad razonSocial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocial(String value) {
        this.razonSocial = value;
    }

}
