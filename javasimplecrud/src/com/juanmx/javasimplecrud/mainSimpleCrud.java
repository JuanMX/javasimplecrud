package com.juanmx.javasimplecrud;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
/**
 * Main class, it launches the project
 * 
 * @author juanmx
 *
 */

public class mainSimpleCrud {
	
	/**
	 * Creates a new SimpleCrud and launch it
	 * Class SimpleCrud.java creates the view
	 * 
	 * TODO Read the Look and Feel from the config file
	 * @param args
	 */

	public static void main(String[] args) {
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        //UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
            }
	    } 
	    catch (Exception e) {
	    // If Nimbus is not available, you can set the GUI to another look and feel.
	    }
		
		viewSimpleCrud newViewSimpleCrud = new viewSimpleCrud();
		newViewSimpleCrud.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		newViewSimpleCrud.setSize( 1280, 720 );
		newViewSimpleCrud.setVisible( true );
		newViewSimpleCrud.setLocationRelativeTo(null);

	}

}
