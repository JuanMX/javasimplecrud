package com.juanmx.javasimplecrud;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
/**
 * Main class, it launches the project
 * 
 * @author juanmx
 *
 */

public class MainSimpleCrud {
	
	/**
	 * Creates a new SimpleCrud and launch it
	 * Class SimpleCrud.java creates the view
	 * 
	 * TODO Read the Look and Feel from the config file
	 * @param args
	 */

	public static void main(String[] args) {
		
		String configLookAndFeel;
		ConfigManagement configManagement = new ConfigManagement();
		configLookAndFeel = configManagement.getConfig("lookAndFeel");
		
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if (configLookAndFeel.equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
            }
	    } 
		
	    catch (Exception e) {
	    	JOptionPane.showMessageDialog( null, "Something went wrong when read " + configLookAndFeel + " in the config file", "!", JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
	    }
		
		ViewSimpleCrud newViewSimpleCrud = new ViewSimpleCrud(configLookAndFeel);
		newViewSimpleCrud.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		newViewSimpleCrud.setSize( 1280, 720 );
		newViewSimpleCrud.setVisible( true );
		newViewSimpleCrud.setLocationRelativeTo(null);

	}

}
