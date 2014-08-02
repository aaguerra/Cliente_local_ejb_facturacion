
package casa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the casa package. 
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

    private final static QName _SendFacturaLoteResponse_QNAME = new QName("http://webService/", "sendFacturaLoteResponse");
    private final static QName _SendFacturaLote_QNAME = new QName("http://webService/", "sendFacturaLote");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: casa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendFacturaLote }
     * 
     */
    public SendFacturaLote createSendFacturaLote() {
        return new SendFacturaLote();
    }

    /**
     * Create an instance of {@link SendFacturaLoteResponse }
     * 
     */
    public SendFacturaLoteResponse createSendFacturaLoteResponse() {
        return new SendFacturaLoteResponse();
    }

    /**
     * Create an instance of {@link RespuestaComprobante }
     * 
     */
    public RespuestaComprobante createRespuestaComprobante() {
        return new RespuestaComprobante();
    }

    /**
     * Create an instance of {@link Factura }
     * 
     */
    public Factura createFactura() {
        return new Factura();
    }

    /**
     * Create an instance of {@link Comprobante }
     * 
     */
    public Comprobante createComprobante() {
        return new Comprobante();
    }

    /**
     * Create an instance of {@link DetalleFactura }
     * 
     */
    public DetalleFactura createDetalleFactura() {
        return new DetalleFactura();
    }

    /**
     * Create an instance of {@link Facturas }
     * 
     */
    public Facturas createFacturas() {
        return new Facturas();
    }

    /**
     * Create an instance of {@link Mensaje }
     * 
     */
    public Mensaje createMensaje() {
        return new Mensaje();
    }

    /**
     * Create an instance of {@link RespuestaComprobantes }
     * 
     */
    public RespuestaComprobantes createRespuestaComprobantes() {
        return new RespuestaComprobantes();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendFacturaLoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "sendFacturaLoteResponse")
    public JAXBElement<SendFacturaLoteResponse> createSendFacturaLoteResponse(SendFacturaLoteResponse value) {
        return new JAXBElement<SendFacturaLoteResponse>(_SendFacturaLoteResponse_QNAME, SendFacturaLoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendFacturaLote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService/", name = "sendFacturaLote")
    public JAXBElement<SendFacturaLote> createSendFacturaLote(SendFacturaLote value) {
        return new JAXBElement<SendFacturaLote>(_SendFacturaLote_QNAME, SendFacturaLote.class, null, value);
    }

}
