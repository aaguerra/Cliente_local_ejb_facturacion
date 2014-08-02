
package casa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para detalleFactura complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="detalleFactura">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codigo_bien_servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo_impuesto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre_bien_servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precio_unitario" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="valor_ice" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleFactura", propOrder = {
    "cantidad",
    "codigoBienServicio",
    "codigoImpuesto",
    "nombreBienServicio",
    "precioUnitario",
    "valorIce"
})
public class DetalleFactura {

    protected int cantidad;
    @XmlElement(name = "codigo_bien_servicio")
    protected String codigoBienServicio;
    @XmlElement(name = "codigo_impuesto")
    protected String codigoImpuesto;
    @XmlElement(name = "nombre_bien_servicio")
    protected String nombreBienServicio;
    @XmlElement(name = "precio_unitario")
    protected float precioUnitario;
    @XmlElement(name = "valor_ice")
    protected float valorIce;

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoBienServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBienServicio() {
        return codigoBienServicio;
    }

    /**
     * Define el valor de la propiedad codigoBienServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBienServicio(String value) {
        this.codigoBienServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoImpuesto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoImpuesto() {
        return codigoImpuesto;
    }

    /**
     * Define el valor de la propiedad codigoImpuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoImpuesto(String value) {
        this.codigoImpuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreBienServicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreBienServicio() {
        return nombreBienServicio;
    }

    /**
     * Define el valor de la propiedad nombreBienServicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreBienServicio(String value) {
        this.nombreBienServicio = value;
    }

    /**
     * Obtiene el valor de la propiedad precioUnitario.
     * 
     */
    public float getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Define el valor de la propiedad precioUnitario.
     * 
     */
    public void setPrecioUnitario(float value) {
        this.precioUnitario = value;
    }

    /**
     * Obtiene el valor de la propiedad valorIce.
     * 
     */
    public float getValorIce() {
        return valorIce;
    }

    /**
     * Define el valor de la propiedad valorIce.
     * 
     */
    public void setValorIce(float value) {
        this.valorIce = value;
    }

}
