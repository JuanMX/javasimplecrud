package com.juanmx.javasimplecrud;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

//menu bar
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
/**
 * Here creates the main view
 * 
 * @author juanmx
 *
 */

public class viewSimpleCrud extends JFrame implements ActionListener{
	
	//placeholders layout
	private JButton buttons[];
	private final String names[] = {"North", "South", "East", "West", "Center"};
	private BorderLayout schema;
	
	//menu bar set look and feel
	private JRadioButtonMenuItem lookAndFeels[];
	private ButtonGroup lookAndFeelsButtonGroup;
	
	public viewSimpleCrud(String configLookAndFeel){
		
		super("Simple Crud");
		
		//menu bar
		JMenu menuLookAndFeel = new JMenu("Set Look and Feel");
		menuLookAndFeel.setMnemonic('L');
		
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(menuLookAndFeel);
		
		//String lookAndFeelNames[];
		ArrayList<String> lookAndFeelNames = new ArrayList<String>();
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            lookAndFeelNames.add(info.getName());
		}
		
		lookAndFeels = new JRadioButtonMenuItem[lookAndFeelNames.size()];
		lookAndFeelsButtonGroup = new ButtonGroup();
		
		ManagerElements managerElement = new ManagerElements();
		
		int intSelectedLookAndFeel = 0;
		
		for (int i = 0; i < lookAndFeelNames.size(); i++) {
			lookAndFeels[i] = new JRadioButtonMenuItem(lookAndFeelNames.get(i));
			menuLookAndFeel.add(lookAndFeels[i]);
			lookAndFeelsButtonGroup.add(lookAndFeels[i]);
			lookAndFeels[i].addActionListener(managerElement);
			
			if(configLookAndFeel.equals(lookAndFeelNames.get(i))) {
				intSelectedLookAndFeel = i;
			}
		}
		lookAndFeels[intSelectedLookAndFeel].setSelected(true);
		
		// Place holders for BorderLayout cardinals
		schema = new BorderLayout(17, 5);
		setLayout( schema );
		buttons = new JButton[names.length];
		
		for(int i=0; i<names.length; i++){
			buttons[i] = new JButton(names[i]);
			buttons[i].addActionListener(this);
		}
		add(buttons[0], BorderLayout.NORTH);
		add(buttons[1], BorderLayout.SOUTH);
		add(buttons[2], BorderLayout.EAST);
		add(buttons[3], BorderLayout.WEST);
		add(buttons[4], BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent event){
		for(JButton button : buttons) {
			if(event.getSource() == button) {
				button.setVisible(false);
				
				JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select a file");//titulo de ventana del JFileChooser

                //Permite ver archivos con extencion especifica
                //fileChooser.setFileFilter(new FileNameExtensionFilter("mp3 (*.mp3)", "mp3"));
                int seleccion = fileChooser.showOpenDialog(null);

      
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        //textSonido.setText("");
                        //textSonido.setText(fileToSave.getAbsolutePath());
                        String fileName = fileToSave.getName();
                        JOptionPane.showMessageDialog( null, "File name: " + fileName, "You selected", JOptionPane.INFORMATION_MESSAGE );
                }
			}
			else {
				button.setVisible(true);
			}
		}
		schema.layoutContainer(getContentPane());
	}
	
	
	private class ManagerElements implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String lookAndFeelSelected = "";
			
			for(int i = 0; i < lookAndFeels.length; i++) {
				
				if(event.getSource() == lookAndFeels[i]) {
					
					try {
						
						for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
							
							if (lookAndFeels[i].getText().equals(info.getName())) {
								
								lookAndFeelSelected = info.getName();
								
								ConfigManagement config = new ConfigManagement();
								
								config.setConfig("lookAndFeel", lookAndFeelSelected);
								
								System.out.println("Look and feel selected from the menu bar: " + lookAndFeelSelected);
								
								JOptionPane.showMessageDialog( null, "The look and feel " + lookAndFeelSelected + " will be set next time you run the program", "Can not put the theme at runtime", JOptionPane.INFORMATION_MESSAGE );
								
								break;
							}
						}
					} 
					catch (Exception e) {
						
						JOptionPane.showMessageDialog( null, "A problem ocurred with the look and feel " + lookAndFeelSelected, "!", JOptionPane.ERROR_MESSAGE );
					}
				}
			}
		}
	}
}