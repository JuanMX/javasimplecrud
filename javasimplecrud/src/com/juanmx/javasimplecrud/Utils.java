package com.juanmx.javasimplecrud;

import java.awt.Image;
import java.awt.Toolkit;

public class Utils {
	public Image getWindowIcon() {
		Toolkit myToolkit = Toolkit.getDefaultToolkit();
		Image windowIcon = myToolkit.getImage("./assets/icon.png");
		return windowIcon;
	}
	//TODO Create a Method to Obtain x percent from a int value 
}
