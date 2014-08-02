
package casa;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FacturacionComprobanteWs", targetNamespace = "http://webService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FacturacionComprobanteWs {


    /**
     * 
     * @param facturas
     * @return
     *     returns casa.RespuestaComprobantes
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendFacturaLote", targetNamespace = "http://webService/", className = "casa.SendFacturaLote")
    @ResponseWrapper(localName = "sendFacturaLoteResponse", targetNamespace = "http://webService/", className = "casa.SendFacturaLoteResponse")
    @Action(input = "http://webService/FacturacionComprobanteWs/sendFacturaLoteRequest", output = "http://webService/FacturacionComprobanteWs/sendFacturaLoteResponse")
    public RespuestaComprobantes sendFacturaLote(
        @WebParam(name = "facturas", targetNamespace = "")
        Facturas facturas);

}
