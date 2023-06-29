package com.juanmx.javasimplecrud;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	
	public ViewNewRecord() {
		super("Test New Record GridBagLayout");
		schema = new GridBagLayout();
		setLayout(schema);
		restrictions = new GridBagConstraints();
		
		JTextArea areaText1 = new JTextArea("Area1",5,10);
		JTextArea areaText2 = new JTextArea("Area2",2,2);
		
		String names[] = {"NAME1", "NAME2", "NAME3"};
		JComboBox boxComb = new JComboBox(names);
		
		JTextField fieldText = new JTextField("Field Text");
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");
		
		restrictions.fill = GridBagConstraints.BOTH;
		addComponent(areaText1, 0, 0, 1, 3);
		
		restrictions.fill = GridBagConstraints.HORIZONTAL;
		addComponent(button1, 0, 1, 2, 1);
		
		addComponent(boxComb, 2, 1, 2, 1);
		
		restrictions.weightx = 1000;
		restrictions.weighty = 1;
		restrictions.fill = GridBagConstraints.BOTH;
		addComponent(button2, 1, 1, 1, 1);
		
		restrictions.weightx = 0;
		restrictions.weighty = 0;
		addComponent(button3, 1, 2, 1, 1);
		
		addComponent(fieldText, 3, 0, 2, 1);
		
		addComponent(areaText2, 3, 2, 1, 1);
		
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );   
        setSize( 850, 300 );
        setVisible( true );
        //setResizable(false);
        setLocationRelativeTo(null);
		
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
