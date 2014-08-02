/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package File;

import Error.ErrorDetalleComprobante;
import Error.ErrorFactura;
import casa.DetalleFactura;
import casa.Factura;
import Utils.Config;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.rmi.CORBA.Util;

/**
 *
 * @author aaguerra
 */
public class FacturaCsv {
    
    private static HashMap<String,Factura> facturas;
    
    public static ErrorFactura reedFileHead(String ruta, int ambiente){
        DataInputStream entrada = null;
        try {
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream(ruta);
            // Creamos el objeto de entrada
            entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            facturas = new HashMap<String,Factura>();
            while ((strLinea = buffer.readLine()) != null)   {
                // Imprimimos la línea por pantalla
                //String[] datos = strLinea.split(Config.getInstance().getProperty(Config.SPLIT));
                String[] datos = strLinea.split("\\|");
                //System.out.println (strLinea);
                //System.out.println("valor="+datos.length);
                if (datos.length == 11 || datos.length==9){
                    ErrorFactura error = reedDataHead(datos, ambiente);
                    if ( error != ErrorFactura.NO_HAY) return error;
                } else return ErrorFactura.ArrayIndexOutOfBoundsException;
            }
            return ErrorFactura.NO_HAY;
        } catch (FileNotFoundException e) {
            return ErrorFactura.FILE_HEAD;
        } catch (ArrayIndexOutOfBoundsException e) {
            return ErrorFactura.ArrayIndexOutOfBoundsException;
        } catch (IOException e) {
            return ErrorFactura.FILE_HEAD_READ;
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                
            }
        }        
    }
    
    private static ErrorFactura reedDataHead(String[] datos, int ambiente){
        if (!Utils.Validator.establecimieto(datos[0])) return ErrorFactura.ESTABECIMIENTO;
        if (!Utils.Validator.punto_emision(datos[1])) return ErrorFactura.PUNTO_EMISION;
        if (!Utils.Validator.numero_factura(datos[2])) return ErrorFactura.NUMREO_FACTURA;
        if (!Utils.Validator.fecha(datos[3])) return ErrorFactura.FECHA;
        if (!Utils.Validator.guia_remision(datos[4])) return ErrorFactura.GUIA_REMISION;
        if (!Utils.Validator.ci_ruc(datos[5])) return ErrorFactura.CI_RUC;
        if (!Utils.Validator.cada_vacia(datos[6])) return ErrorFactura.RAZON_SOCIAL;
        if (!Utils.Validator.cada_vacia(datos[7])) return ErrorFactura.DIRECCION;
        if (!Utils.Validator.email(datos[8])) return ErrorFactura.EMAIL; 
        if (datos.length == 11){
            if (!Utils.Validator.cada_vacia(datos[9])) return ErrorFactura.DETALLE_ADICIONAL_ETIQUETA;
            if (!Utils.Validator.cada_vacia(datos[10])) return ErrorFactura.DETALLE_ADICIONAL;
            facturas.put(datos[0]+datos[1]+datos[2]
                    ,createFactura(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7],datos[8],datos[9],datos[10], ambiente ));
        } else facturas.put(datos[0]+datos[1]+datos[2]
                ,createFactura(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7],datos[8],"","", ambiente));
        //factura = new Factura();
        
        return ErrorFactura.NO_HAY;
    }   
    
    public static Factura createFactura(String establecimiento, String punto_emision, String numero_factura, String fecha
            , String guia_remision, String ci_ruc, String razon_social, String direccion, String email, String detalle_adicional_etiqueta, String detalle_adicional, int ambiente){
        Factura factura = new Factura();
        factura.setEstablecimiento(establecimiento);
        factura.setPuntoEmision(punto_emision);
        factura.setNumeroFactura(numero_factura);
        factura.setFecha(fecha);
        factura.setGuiaRemision(guia_remision);
        factura.setCiRuc(ci_ruc);
        factura.setRazonSocial(razon_social);
        factura.setDireccion(direccion);
        factura.setEmail(email);
        factura.setDetalleAdicionalEtiqueta(detalle_adicional_etiqueta);
        factura.setDetalleAdicional(detalle_adicional);
        factura.setProveedor("0702144833");
        factura.setAmbiente(ambiente);
        return  factura;
    }
    
    public static ErrorDetalleComprobante reedFileDetalle(String ruta){
        DataInputStream entrada = null;
        try {
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream(ruta);
            // Creamos el objeto de entrada
            entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                // Imprimimos la línea por pantalla
                //String[] datos = strLinea.split(Config.getInstance().getProperty(Config.SPLIT));
                String[] datos = strLinea.split("\\|");
                //System.out.println (strLinea);
                //System.out.println("valor="+datos.length);
                if (datos.length==9){
                    ErrorDetalleComprobante error = reedDataDetalle(datos);
                    if ( error != ErrorDetalleComprobante.NO_HAY) return error;
                } else return ErrorDetalleComprobante.ArrayIndexOutOfBoundsException;                
            }
            return ErrorDetalleComprobante.NO_HAY;
        } catch (FileNotFoundException e) {
            return ErrorDetalleComprobante.FILE_DETALLE;
        } catch (ArrayIndexOutOfBoundsException e) {
            return ErrorDetalleComprobante.ArrayIndexOutOfBoundsException;
        } catch (IOException e) {
            return ErrorDetalleComprobante.FILE_DETALLE_READ;
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                
            }
        }        
    }
    
    private static ErrorDetalleComprobante reedDataDetalle(String[] datos ) {
        Factura factura = null;
        if (!Utils.Validator.establecimieto(datos[0])) return ErrorDetalleComprobante.ESTABLECIMIENTO;
        if (!Utils.Validator.punto_emision(datos[1])) return ErrorDetalleComprobante.PUNTO_EMISION;
        if (!Utils.Validator.numero_factura(datos[2])) return ErrorDetalleComprobante.NUMERO_DOCUMENTO;        
        factura = facturas.get(datos[0]+datos[1]+datos[2]);
        if (factura == null) return ErrorDetalleComprobante.NO_FACTURA_ASOCIADA;
        if (!Utils.Validator.cada_vacia(datos[3])) return ErrorDetalleComprobante.CODIGO_BIEN_SERVICIO;
        if (!Utils.Validator.entero(datos[4])) return ErrorDetalleComprobante.CANTIDAD;
        if (!Utils.Validator.cada_vacia(datos[5])) return ErrorDetalleComprobante.NOMBRE_BIEN_SERVICIO;
        if (!Utils.Validator.decimal(datos[6])) return ErrorDetalleComprobante.PRECIO_UNITARIO;
        if (!Utils.Validator.entero(datos[7])) return ErrorDetalleComprobante.CODIGO_IMPUESTO;
        if (!Utils.Validator.decimal(datos[8])) return ErrorDetalleComprobante.VALOR_ICE;
        
        factura.getListDetalle().add(createDetalleFactura(datos[3], Integer.parseInt(datos[4]), datos[5], Float.parseFloat(datos[6]), datos[7], Float.parseFloat(datos[8]) ) );
        
        return ErrorDetalleComprobante.NO_HAY;
    }
    
    public static DetalleFactura createDetalleFactura(String codigo_bien_servicio, int cantidad, String nombre_bien_servicio
            , float precio_unitario, String codigo_impuesto, float valor_ice){
        DetalleFactura d = new DetalleFactura();
        d.setCodigoBienServicio(codigo_bien_servicio);
        d.setCantidad(cantidad);
        d.setNombreBienServicio(nombre_bien_servicio);
        d.setPrecioUnitario(precio_unitario);
        d.setCodigoImpuesto(codigo_impuesto);
        d.setValorIce(valor_ice);
        return d;
    }

    public static HashMap<String,Factura> getFacturas() {
        return facturas;
    }
    
}
