/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author aaguerra
 */
public class Validator {
    
    /*Variables de valida persona juridica o extranjera*/
    private static final int NUM_PROVINCIAS = 24;
    private static final int[] coeficientes = { 4, 3, 2, 7, 6, 5, 4, 3, 2 };
    private static final int constante = 11;
    
    public static boolean establecimieto(String num){
        try {
            if (num == null) return false;
            else if (num.isEmpty()) return false;
            else if (num.length() != 3) return false;
            else if (Integer.parseInt(num)<=0) return false;
            else return true;
        } catch (java.lang.NumberFormatException  e) {
            return false;
        }
    }
    
    public static boolean punto_emision(String num){
        try {
            if (num == null) return false;
            else if (num.isEmpty()) return false;
            else if (num.length() != 3) return false;
            else if (Integer.parseInt(num)<=0) return false;
            else return true;
        } catch (java.lang.NumberFormatException  e) {
            return false;
        }
    }
    
    public static boolean numero_factura(String num){
        try {
            if (num == null) return false;
            else if (num.isEmpty()) return false;
            else if (num.length() != 9) return false;
            else if (Integer.parseInt(num)<=0) return false;
            else return true;
        } catch (java.lang.NumberFormatException  e) {
            return false;
        }
    }
    
    public static boolean fecha(String num){
        try {
            if (num == null) return false;
            else if (num.isEmpty()) return false;
            else if (num.length() != 8) return false;
            else if (Integer.parseInt(num)<=0) return false;
            else {
                try {
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    formatoFecha.setLenient(false);
                    formatoFecha.parse(num.substring(6, 8)+"/"+num.substring(4, 6)+"/"+num.substring(0, 4));
                    return true;
                } catch (ParseException e) { return false; }                
            }                 
        } catch (java.lang.NumberFormatException  e) {
            return false;
        }
    }
        
    public static boolean cada_vacia(String cad){
        if (cad == null) return false;
        else if (cad.isEmpty()) return false;
        else return true;
    }
    public static boolean email(String email) {
        if (email == null) return false;
        else if (email.isEmpty()) return false;
        else {
            String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            //String email1 = email;
            Boolean b = email.matches(EMAIL_REGEX);
            if( b == false){
                b = email.matches("");
                if( b == false){
                    if (email.equals(null)){
                        b=true;
                    }
                } 
            }
            //System.out.println("is e-mail: "+email+" :Valid = " + b);
            return b;
        }
    }
    
    
    //Valida persona natural
	private static boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;
		 
		try {
			if (cedula.equals(null)) {
				cedulaCorrecta = false;
			} else if (cedula.trim().equals("")) {
				cedulaCorrecta = false;
			} else {
				if (cedula.length() == 10) // ConstantesApp.LongitudCedula
				{
					cedula = cedula.trim();
					int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
					if (tercerDigito < 6) {
						// Coeficientes de validación cédula
						// El decimo digito se lo considera dígito verificador
						int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
						int verificador = Integer.parseInt(cedula.substring(9,10));
						int suma = 0;
						int digito = 0;
						for (int i = 0; i < (cedula.length() - 1); i++) {
						 digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
						 suma += ((digito % 10) + (digito / 10));
						}
						 
						if ((suma % 10 == 0) && (suma % 10 == verificador)) 
						 cedulaCorrecta = true;
						else if ((10 - (suma % 10)) == verificador) 
							 cedulaCorrecta = true;
						else 
						 cedulaCorrecta = false;
					} else 
						cedulaCorrecta = false;
					
				} else {
					//System.out.println("Una excepcion ocurrio en el proceso de validacion 1");
					cedulaCorrecta = false;
				}
			}
		} catch (NumberFormatException nfe) {
			//System.out.println("Una excepcion ocurrio al convertir un string a int");
			cedulaCorrecta = false;
		} catch (Exception err) {
			//System.out.println("Una excepcion ocurrio en el proceso de validacion");
			cedulaCorrecta = false;
		}
		/*	 
		if (!cedulaCorrecta) {
		System.out.println("La Cédula ingresada es Incorrecta");
		}*/
		return cedulaCorrecta;
	}
	
	//Valida persona juridica o extranjera	
	private static Boolean validaRucJE(String ruc) {
		boolean resp_dato = false;
		if (ruc.equals(null)) {
			resp_dato = false;
		} else if (ruc.trim().equals("")) {
			resp_dato = false;
		} else {
			if (ruc.length() == 10) // ConstantesApp.LongitudCedula
			{
				
				final int prov = Integer.parseInt(ruc.substring(0, 2));
				
				if (!((prov > 0) && (prov <= NUM_PROVINCIAS))) {
					resp_dato = false;
				}
		 
				int[] d = new int[10];
				int suma = 0;
		 
				for (int i = 0; i < d.length; i++) {
					d[i] = Integer.parseInt(ruc.charAt(i) + "");
				}
		 
				for (int i = 0; i < d.length - 1; i++) {
					d[i] = d[i] * coeficientes[i];
					suma += d[i];
				}
		 
				int aux, resp;
		 
				aux = suma % constante;
				resp = constante - aux;
		 
				resp = (aux == 0) ? 0 : resp;
		 
				if (resp == d[9]) {
					resp_dato = true;
				} else {
					resp_dato = false;
				}
			} else {
				resp_dato = false;
			}
		}
		return resp_dato;
	}
		
	//Valida persona publica
	private static Boolean validaRucEP(String ruc) {
		boolean resp = false;
		if (ruc.equals(null)) {
			resp = false;
		} else if (ruc.trim().equals("")) {
			resp = false;
		} else {
			if (ruc.length() == 10) // ConstantesApp.LongitudCedula
			{
				final int prov = Integer.parseInt(ruc.substring(0, 2));
				
		 
				if (!((prov > 0) && (prov <= NUM_PROVINCIAS))) {
					resp = false;
				}
		 
				// boolean val = false;
				Integer v1, v2, v3, v4, v5, v6, v7, v8, v9;
				Integer sumatoria;
				Integer modulo;
				Integer digito;
				int[] d = new int[ruc.length()];
		 
				for (int i = 0; i < d.length; i++) {
					d[i] = Integer.parseInt(ruc.charAt(i) + "");
				}
		 
				v1 = d[0] * 3;
				v2 = d[1] * 2;
				v3 = d[2] * 7;
				v4 = d[3] * 6;
				v5 = d[4] * 5;
				v6 = d[5] * 4;
				v7 = d[6] * 3;
				v8 = d[7] * 2;
				v9 = d[8];
		 
				sumatoria = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8;
				modulo = sumatoria % 11;
				if (modulo == 0) {
					return true;
				}
				digito = 11 - modulo;
		 
				if (digito.equals(v9)) {
					resp = true;
				} else {
					resp = false;
				}
			} else {
				resp = false;
			}
		}
		return resp;
	}
	
	private static boolean ci_ruc_valida(String ci_ruc) { 
		
		if (ci_ruc == null) {
			return true;
		} else if (ci_ruc.trim().equals("")){
			return true;
		} else if (ci_ruc.trim().length() != 10){
			return false;
		} else {
		
			if (validadorDeCedula(ci_ruc.trim())) {
				//System.out.println(" opcion 1");
				return true;
			} else if (validaRucJE(ci_ruc.trim())) {
				//System.out.println(" opcion 2");
				return true;
			} else if (validaRucEP(ci_ruc.trim())) {
				//System.out.println(" opcion 3");
				return true;
			} else {
				//System.out.println(" opcion 4");
				return false;
			}
		}
		
	}
        
    public static boolean  ci_ruc(String cad ){
        try {
            if (cad == null) { return false;}
            else if (cad.isEmpty()){return false;}
            //else if (Integer.parseInt(cad) == 0 ){ System.out.println("cedula4="+cad); return false;}
            else if (cad.length() != 10 && cad.length() != 13){ return false;}
            else if (cad.length() == 10) { return ci_ruc_valida(cad); }
            else {
                if(ci_ruc_valida(cad.substring(0, 10)))
                    if (Integer.parseInt(""+cad.subSequence(10, 13)) ==0 ) return false;
                    else return true;
                else return false;
                
            }
        } catch (java.lang.NumberFormatException  e) {
            return false;
        } 
    }
    
    public static boolean guia_remision(String num){
        try {
            if (num != null){
                if (!num.isEmpty()) {
                    if (num.length() != 15) return false;
                    //else if (Integer.parseInt(num)<=0) return false;
                    else {
                        if (Integer.parseInt(num.substring(0, 3)) == 0) return false;
                        if (Integer.parseInt(num.substring(3, 6)) == 0) return false;
                        if (Integer.parseInt(num.substring(6, 15)) == 0) return false;
                    }
                }
            }
            return true;
        } catch (java.lang.NumberFormatException  e) {
            return false;
        }
    }
	
    public static boolean entero(String cad){
        try {
            Integer.parseInt(cad);
            return true;
        } catch (java.lang.NumberFormatException | java.lang.NullPointerException e) {
            return false;
        }
        
    }
    
    public static boolean decimal(String cad){
        try {
            Float.parseFloat(cad);
            return true;
        } catch (java.lang.NumberFormatException | java.lang.NullPointerException e) {
            return false;
        }
        
    }
}
