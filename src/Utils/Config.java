/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author aaguerra
 */
public class Config {
    
    Properties properties = null;
	 
    /** Configuration file name */
    public final static String CONFIG_FILE_NAME = "resources/config_1.properties";
    //public final static String CONFIG_FILE_NAME = "config.properties";
    
    public final static String SPLIT = "SPLIT";
    
    public final static String SO_LINUX = "SO_LINUX";
    public final static String SO_WINDOWS = "SO_WINDOWS";
    public final static String SO_LINUX_RUTA_FILE = "SO_LINUX_RUTA_FILE";
    public final static String SO_WINDOWS_RUTA_FILE = "SO_WINDOWS_RUTA_FILE";
    public final static String FACTURACION_HEADER = "FACTURACION_HEADER";
    public final static String FACTURACION_DETALLE = "FACTURACION_DETALLE";
 
    private Config() {
        this.properties = new Properties();
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//Configuration
 
    /**
     * Implementando Singleton
     *
     * @return
     */
    public static Config getInstance() {
        //return  new Config();
        return ConfigurationHolder.INSTANCE;
    }
 
    private static class ConfigurationHolder {
 
        private static final Config INSTANCE = new Config();
    }
 
    /**
     * Retorna la propiedad de configuración solicitada
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }//getProperty
    
}
