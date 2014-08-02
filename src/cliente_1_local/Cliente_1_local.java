/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente_1_local;

import Error.ErrorDetalleComprobante;
import Error.ErrorFactura;
import Error.ErrorMsg;
import File.FacturaCsv;
import Utils.SistemaOperativo;
import Utils.Utils;
import casa.RespuestaComprobantes;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author aaguerra
 */
public class Cliente_1_local {

    /**
     * @param args the command line arguments
     */
    private static SistemaOperativo so;
    private static int ambiente;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            so = Utils.getSistemaOperatio();
            //ambiente = Integer.parseInt(args[0]);
            ambiente = 1;
            switch(1){
            //switch(Integer.valueOf(args[1])){
                case 1:
                    //JOptionPane.showMessageDialog(null, "Es Factura");
                    factura();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "es linux == ");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "es linux == ");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "es linux == ");
                    break;
                case 5:
                    //JOptionPane.showMessageDialog(null, "es windows == "+args[0]);
                    JOptionPane.showMessageDialog(null, "es windows =111= ");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "error en el programa  ");
                    break;
            }
        } catch (java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Solo se admiten numeros [ambiente{1,2}] [codigo comprobante{1,4,5,6,7}]");
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Elija una opcion para firmar ");
        }
        
    }
    
    private static void factura(){
        // lleno al cabecera
        /*ErrorFactura error = FacturaCsv.reedFileHead(((so == SistemaOperativo.LINUX)? Config.getInstance().getProperty(Config.SO_LINUX_RUTA_FILE):Config.getInstance().getProperty(Config.SO_WINDOWS_RUTA_FILE))+
                Config.getInstance().getProperty(Config.FACTURACION_HEADER));            
                */
        ErrorFactura error = FacturaCsv.reedFileHead("C:\\tributasoft\\FA.csv", ambiente);
        if (error != ErrorFactura.NO_HAY) ErrorMsg.FacturaCsv(error);
        //llno el detalle
        else {
            System.out.println("tam="+FacturaCsv.getFacturas().size());
            /*ErrorDetalleComprobante errorD = FacturaCsv.reedFileDetalle(((so == SistemaOperativo.LINUX)? Config.getInstance().getProperty(Config.SO_LINUX_RUTA_FILE):Config.getInstance().getProperty(Config.SO_WINDOWS_RUTA_FILE))+
                    Config.getInstance().getProperty(Config.FACTURACION_DETALLE));            */
            ErrorDetalleComprobante errorD = FacturaCsv.reedFileDetalle("C:\\tributasoft\\DFA.csv");
            if (errorD != ErrorDetalleComprobante.NO_HAY) ErrorMsg.DetalleCsv(errorD);
            else {
                
                casa.Facturas facturas = new casa.Facturas();
                System.out.println("crear facturas");
                ArrayList<Map.Entry> facturas_ = new ArrayList(FacturaCsv.getFacturas().entrySet());
                for (Map.Entry factura : facturas_) {
                    //System.out.println(" se crearon facturas tam = "+((Factura)factura.getValue()));
                    facturas.getFacturas().add( (casa.Factura)factura.getValue() );
                }
                System.out.println(" se crearon facturas tam = "+facturas.getFacturas().size());
                System.out.println(" se crearon facturas = "+facturas.getFacturas().get(0).getProveedor());
                casa.RespuestaComprobantes respuestas = sendFacturaLote(facturas);
                System.out.println("regreso web service");
                JOptionPane.showMessageDialog(null, "paso la validacion");
            }        
        }
    }

    private static RespuestaComprobantes sendFacturaLote(casa.Facturas facturas) {
        casa.FacturacionComprobanteWs_Service service = new casa.FacturacionComprobanteWs_Service();
        casa.FacturacionComprobanteWs port = service.getFacturacionComprobanteWsPort();
        return port.sendFacturaLote(facturas);
    }
    
}
