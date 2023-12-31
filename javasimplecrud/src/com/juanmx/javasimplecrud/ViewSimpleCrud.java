package com.juanmx.javasimplecrud;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

//menu bar
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

//action buttons CRUD
import javax.swing.JPanel;

//table
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
/**
 * Here creates the main view
 * 
 * @author juanmx
 *
 */

public class ViewSimpleCrud extends JFrame implements ActionListener{
	
	//place holders layout
	private JButton buttons[];
	private final String names[] = {"North", "South", "East", "West", "Center"};
	private BorderLayout schema;
	
	//menu bar set look and feel
	private JRadioButtonMenuItem lookAndFeels[];
	private ButtonGroup lookAndFeelsButtonGroup;
	
	//panel action buttons
	private JPanel panelActionButtons;
	private JButton actionButtons[];
	
	//table
	JTable crudTable;
	
	JMenuBar bar;
	JMenu menuLookAndFeel;
	
	public ViewSimpleCrud(String configLookAndFeel){
		
		super("Java Simple Crud");
		
		//menu bar
		menuLookAndFeel = new JMenu("Set Look and Feel");
		menuLookAndFeel.setMnemonic('L');
		
		
		bar = new JMenuBar();
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
		schema = new BorderLayout(17, 17);
		setLayout( schema );
		/*
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
		*/
		
		//action buttons
		actionButtons = new JButton[3];
		panelActionButtons = new JPanel();
		panelActionButtons.setLayout(new GridLayout(1, actionButtons.length, 17 , 1));
		ManagerCrudButton managerCrudButton = new ManagerCrudButton();
		
		actionButtons[0] = new JButton("Create New");
		actionButtons[0].setBorder(new LineBorder(new Color(0,255,0), 5));
		actionButtons[0].addActionListener(managerCrudButton);
		
		actionButtons[1] = new JButton("Edit Record");
		actionButtons[1].setBorder(new LineBorder(new Color(255,255,0), 5));
		actionButtons[1].addActionListener(managerCrudButton);
		
		actionButtons[2] = new JButton("Delete Record");
		actionButtons[2].setBorder(new LineBorder(new Color(255,0,0), 5));
		actionButtons[2].addActionListener(managerCrudButton);
		
		panelActionButtons.add(actionButtons[0]);
		panelActionButtons.add(actionButtons[1]);
		panelActionButtons.add(actionButtons[2]);
		
		//test data
		String testData[][] = new String[100][5];
		for(int row = 0; row < 100; row++) {
			for(int column = 0; column < 5; column++) {
				testData[row][column] = "test data for ceil (" + row + ", " + column + ")";
			}
		}
		
		
		String crudTableColumnNames[] = {"id", "Description", "Key Words", "Help Image"};
		
		crudTable = new JTable(testData, crudTableColumnNames);
		
		add(new JScrollPane(crudTable), BorderLayout.CENTER);
		add(panelActionButtons, BorderLayout.SOUTH);
		
		//set window icon
		setIconImage(new Utils().getWindowIcon());
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
	
	
	private class ManagerElements extends JFrame implements ActionListener {
		
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
								
								JOptionPane.showMessageDialog( null, "The look and feel " + lookAndFeelSelected + " will be set next time you run the program", "Can not put the theme at runtime :(", JOptionPane.WARNING_MESSAGE );
								
								//setDefaultLookAndFeelDecorated(true);
								//UIManager.setLookAndFeel(info.getClassName());
								//SwingUtilities.updateComponentTreeUI(this);
								
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
	
	private class ManagerCrudButton implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == actionButtons[0]) {
				ViewNewRecord viewNewRecord = new ViewNewRecord();
			}
			else if(event.getSource() == actionButtons[1]) {
				JOptionPane.showMessageDialog( null, "Click on edit ", "!", JOptionPane.PLAIN_MESSAGE );
			}
			else if(event.getSource() == actionButtons[2]) {
				JOptionPane.showMessageDialog( null, "Click on delete ", "!", JOptionPane.PLAIN_MESSAGE );
			}
			else {
				
			}
		}
	}
}