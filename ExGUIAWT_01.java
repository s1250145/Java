import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/*
 * <applet code = "ExGUIAWT" width = 400 height = 300></applet>
 */

public class ExGUIAWT_01 extends Applet{
	public void init() {
		setSize(400,300);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawString("April 11, 2019", 150, 150);
		
		g.setColor(Color.red);
		g.drawArc(100, 50, 200, 200, 0, 360);
	}
}
