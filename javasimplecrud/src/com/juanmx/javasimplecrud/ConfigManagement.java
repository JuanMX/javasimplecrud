package com.juanmx.javasimplecrud;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * CONFIG.config file management
 * for now it stored the look and feel selected for the menu bar in viewSimpleCrud 
 * 
 * @author juanmx
 *
 */
public class ConfigManagement {
	
	private static Properties prop = new Properties();
	private static final  String CONFIG_FILE = "CONFIG.config";
	
	public void setConfig(String key, String value) {
		
		try{
			
			prop.setProperty(key, value);
			prop.store(new FileOutputStream(CONFIG_FILE), null);
			System.out.println("Set config " + key + " " + value + " " + CONFIG_FILE);
		    
		}catch(IOException e){
			JOptionPane.showMessageDialog( null, "Something went wrong when saving the changes", "!", JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
		}
		
	}
	
	public String getConfig(String key) {
		
		String value = "";
		
		try {
			prop.load(new FileInputStream(CONFIG_FILE));
			value = prop.getProperty(key);
			
		}catch(IOException e) {
			JOptionPane.showMessageDialog( null, "Something went wrong when reading the config file", "!", JOptionPane.ERROR_MESSAGE );
			
			e.printStackTrace();
		}finally {
			System.out.println("Get config " + key + " " + value + " " + CONFIG_FILE);
		}
		
		return value;
	}
}
