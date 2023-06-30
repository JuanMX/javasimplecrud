package com.juanmx.javasimplecrud;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFileChooser;

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
		JButton buttonChooseImage = new JButton("Search for a image");
		buttonChooseImage.setToolTipText("Search for a image is optional");
		JButton buttonSave = new JButton("Save New Record");
		buttonSave.setBackground(new Color(0,255,255));
		
		// left element preview image
		restrictions.fill = GridBagConstraints.BOTH;
		restrictions.weightx = 40;
		restrictions.weighty = 25;
		imageLabel = new JLabel();
		addComponent(imageLabel, 0, 0, 1, 11);
		
		restrictions.weightx = 75;
		restrictions.weighty = 75;
		
		restrictions.fill = GridBagConstraints.HORIZONTAL;
		descriptionLabel = new JLabel("Description:");
		addComponent(descriptionLabel, 0, 3, 3, 1);
		restrictions.fill = GridBagConstraints.BOTH;
		addComponent( areaTextDescription, 1, 4, 3, 4);
		
		restrictions.fill = GridBagConstraints.HORIZONTAL;
		keyWordsLabel = new JLabel("Key Words:");
		addComponent( keyWordsLabel, 5, 3, 3, 1);
		addComponent( areaTextKeyWords, 6, 4, 3, 2);
		
		
		restrictions.fill = GridBagConstraints.HORIZONTAL;
		addComponent(buttonChooseImage, 9, 4, 2, 1);
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
}
