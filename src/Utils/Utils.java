package Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author aaguerra
 */
public class Utils {
    
    public static SistemaOperativo getSistemaOperatio(){
        /*
        if ((System.getProperty("os.name")).equals(""+Config.getInstance().getProperty(Config.SO_LINUX)))
            return SistemaOperativo.LINUX;
        else
            return  SistemaOperativo.WINDOWS;
        */
        return  SistemaOperativo.WINDOWS;
    }
    
    
    
    public static void ver_ip(){
        String s = null;

                try {

                        // Determinar en qué SO estamos
                        String so = System.getProperty("os.name");

                        String comando;

                        // Comando para Linux
                        if (so.equals("Linux"))
                                comando = "ifconfig";

                        // Comando para Windows
                        else
                                comando = "cmd /c ipconfig";

                        // Ejcutamos el comando
                        Process p = Runtime.getRuntime().exec(comando);

                        BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                                        p.getInputStream()));

                        BufferedReader stdError = new BufferedReader(new InputStreamReader(
                                        p.getErrorStream()));

                        // Leemos la salida del comando
                        System.out.println("Ésta es la salida standard del comando:\n");
                        while ((s = stdInput.readLine()) != null) {
                                System.out.println(s);
                        }

                        // Leemos los errores si los hubiera
                        System.out
                                        .println("Ésta es la salida standard de error del comando (si la hay):\n");
                        while ((s = stdError.readLine()) != null) {
                                System.out.println(s);
                        }

                        System.exit(0);
                } catch (IOException e) {
                        System.out.println("Excepción: ");
                        e.printStackTrace();
                        System.exit(-1);
                }
    }
    
}
