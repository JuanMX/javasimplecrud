package com.juanmx.javasimplecrud;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;

/**
 * In the main view when click the button [New record]
 *     Shows a new window
 *     The new windows is created here
 * 
 * @author juanmx
 *
 */

public class ViewNewRecord extends JFrame{
	
	private GridBagLayout schema;
	private GridBagConstraints restrictions;
	private JLabel imageLabel, descriptionLabel, keyWordsLabel;
	JButton buttonChooseImage = new JButton("Search for a image");
	JButton viewImage = new JButton("view");
	JTextField pathImage;
	
	
	public ViewNewRecord() {
		super("New Record");
		schema = new GridBagLayout();
		setLayout(schema);
		restrictions = new GridBagConstraints();
		
		JTextArea areaTextDescription = new JTextArea("",5,10);
		JTextArea areaTextKeyWords = new JTextArea("",2,2);
		areaTextKeyWords.setToolTipText("Key words for a better search");
		
		String names[] = {"NAME1", "NAME2", "NAME3"};
		JComboBox boxComb = new JComboBox(names);
		
		JTextField fieldText = new JTextField("Field Text");
		
		buttonChooseImage.setToolTipText("Optional Field");
		JButton buttonSave = new JButton("Save New Record");
		buttonSave.setBackground(new Color(0,255,255));
		
		// left element preview image
		restrictions.fill = GridBagConstraints.BOTH;
		restrictions.weightx = 27;
		restrictions.weighty = 100;
		imageLabel = new JLabel();
		addComponent(imageLabel, 0, 0, 2, 11);
		
		restrictions.weightx = 75;
		restrictions.weighty = 100;
		
		restrictions.fill = GridBagConstraints.HORIZONTAL;
		descriptionLabel = new JLabel("Description:");
		addComponent(descriptionLabel, 0, 3, 3, 1);
		restrictions.fill = GridBagConstraints.BOTH;
		addComponent( new JScrollPane(areaTextDescription), 1, 4, 3, 4);
		
		restrictions.fill = GridBagConstraints.BOTH;
		keyWordsLabel = new JLabel("Key Words:");
		addComponent( keyWordsLabel, 5, 3, 3, 1);
		addComponent(  new JScrollPane(areaTextKeyWords), 6, 4, 3, 2);
		
		
		restrictions.fill = GridBagConstraints.HORIZONTAL;
		restrictions.weightx = 0;
		ManagerImageButton managerImageButton = new ManagerImageButton();
		buttonChooseImage.addActionListener(managerImageButton);
		addComponent(buttonChooseImage, 9, 4, 1, 1);
		
		pathImage= new JTextField(1000);
		pathImage.setEnabled(false);
		addComponent(pathImage, 9, 5, 1, 1);
		
		addComponent(viewImage, 9, 6, 1, 1);
		
		
		
		restrictions.fill = GridBagConstraints.NONE;
		addComponent(buttonSave, 10, 4, 2, 1);

		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );   
		setSize( 850, 300 );
		setVisible( true );
		//setResizable(false);
		setLocationRelativeTo(null);
		
		setIconImage(new Utils().getWindowIcon());
	}
	
	private void addComponent(Component component, int row, int column, int width, int height) {
		restrictions.gridx = column;
		restrictions.gridy = row;
		restrictions.gridwidth = width;
		restrictions.gridheight = height;
		schema.setConstraints(component, restrictions);
		add(component);
	}
	
	private class ManagerImageButton implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == buttonChooseImage) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Select a jpg or png image");//title JFileChooser
				fileChooser.setFileFilter(new FileNameExtensionFilter("JPG and PNG Images", "jpg", "JPG", "jpeg", "JPEG", "png", "PNG"));
				int seleccion = fileChooser.showOpenDialog(null);
				
				  
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					
					File fileToSave = fileChooser.getSelectedFile();
					//textSonido.setText("");
					//textSonido.setText(fileToSave.getAbsolutePath());
					String imageAbsolutePath = fileToSave.getAbsolutePath();
					ImageIcon labelImage = new ImageIcon(new ImageIcon(imageAbsolutePath).getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_DEFAULT));
					imageLabel.setIcon(labelImage);
					pathImage.setText(imageAbsolutePath);
					//JOptionPane.showMessageDialog( null, "File name: " + imageAbsolutePath, "You selected", JOptionPane.INFORMATION_MESSAGE );
				}
			}
			
		}
	}
}
