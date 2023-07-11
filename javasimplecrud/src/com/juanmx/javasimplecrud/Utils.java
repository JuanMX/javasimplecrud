package com.juanmx.javasimplecrud;

import java.awt.Image;
import java.awt.Toolkit;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Utils {
	
	public Image getWindowIcon() {
		Toolkit myToolkit = Toolkit.getDefaultToolkit();
		Image windowIcon = myToolkit.getImage("./assets/icon.png");
		return windowIcon;
	}
	
	public int screenPercentageWidth(double xpercentage) {
		
		Toolkit theScreen = Toolkit.getDefaultToolkit();
		Dimension dimensionScreen = theScreen.getScreenSize();

		return (int) ((dimensionScreen.width*xpercentage)/100);
	}
	
	public int screenPercentageHeight(double xpercentage) {
		
		Toolkit theScreen = Toolkit.getDefaultToolkit();
		Dimension dimensionScreen = theScreen.getScreenSize();

		return (int) ((dimensionScreen.height*xpercentage)/100);
	}
}
