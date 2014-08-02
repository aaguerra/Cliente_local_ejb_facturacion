/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Error;

import javax.swing.JOptionPane;

/**
 *
 * @author aaguerra
 */
public class ErrorMsg {
    
    public static void DetalleCsv(ErrorDetalleComprobante error) {
        ErrorFactura e =null;
        switch(error){
                case ESTABLECIMIENTO:
                    JOptionPane.showMessageDialog(null, "Error en el estableciminto");
                    break;
                case PUNTO_EMISION:
                    JOptionPane.showMessageDialog(null, "Error en el punto de emision");
                    break;
                case NUMERO_DOCUMENTO:
                    JOptionPane.showMessageDialog(null, "Error en el numero de documento asociado al detalle");
                    break;
                case ArrayIndexOutOfBoundsException:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo detalle no tiene el tamano correcto");
                    break;
                case NO_FACTURA_ASOCIADA:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo de detalle no posee una factura asociada");
                    break;
                case CODIGO_BIEN_SERVICIO:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo detalle posee un codigo de bien o servicio vacio");
                    break;
                case CANTIDAD:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo detalle poseee una cantidad incorrecta");
                    break;
                case NOMBRE_BIEN_SERVICIO:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo detalle tiene un nombre del bien o servicio vacion");
                    break;
                case PRECIO_UNITARIO:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo detalle tiene un precio unitario incorrecto");
                    break;
                case CODIGO_IMPUESTO:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo detalle  tienen un codigo de impuesto incorrecto");
                    break;
                case VALOR_ICE:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo detalle tiene un valor de ice incorrecto");
                    break;
                case FILE_DETALLE:
                    JOptionPane.showMessageDialog(null, "Error al querer abrir un archivo detalle");
                    break;
                case FILE_DETALLE_READ:
                    JOptionPane.showMessageDialog(null, "Error al leer los datos el archivo detalle");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El archivo se valido con exito");
                    break;
            }
    }
    
    public static void FacturaCsv(ErrorFactura error) {
        switch(error){
                case ESTABECIMIENTO:
                    JOptionPane.showMessageDialog(null, "Error en el estableciminto");
                    break;
                case PUNTO_EMISION:
                    JOptionPane.showMessageDialog(null, "Error en el punto de emision");
                    break;
                case NUMREO_FACTURA:
                    JOptionPane.showMessageDialog(null, "Error en el numero de factura");
                    break;
                case ArrayIndexOutOfBoundsException:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo no tiene el tamano correcto");
                    break;
                case FECHA:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo posee fecha incorrecta");
                    break;
                case GUIA_REMISION:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo posee una guia de remision incorrecta");
                    break;
                case CI_RUC:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo posee un CI/RUC incorrecto");
                    break;
                case RAZON_SOCIAL:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo posee razon social vacia");
                    break;
                case DIRECCION:
                    JOptionPane.showMessageDialog(null, "Una fila del archivo posee una direccion vacia");
                    break;
                case EMAIL:
                    JOptionPane.showMessageDialog(null, "Un email es incorrecto");
                    break;
                case DETALLE_ADICIONAL_ETIQUETA:
                    JOptionPane.showMessageDialog(null, "La etiqueta del d. adicional es incorrecta");
                    break;
                case DETALLE_ADICIONAL:
                    JOptionPane.showMessageDialog(null, "Un campo del detalle adicional debe estar lleno si posee una etiqueta apra el detalle");
                    break;
                case FILE_HEAD:
                    JOptionPane.showMessageDialog(null, "Error al querer abrir un archivo");
                    break;
                case FILE_HEAD_READ:
                    JOptionPane.showMessageDialog(null, "Error al leer los datos el archivo");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El archivo se valido con exito");
                    break;
            }
    }
    
}
