import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * <applet code = "ExGUIAWT_03" width = 400 height = 300></applet>
 */

public class ExGUIAWT_03 extends ExGUIAWT_02 implements ActionListener, MouseListener, MouseMotionListener{
	
	int mouseXPosition;
	
	public void init() {
		super.init();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) { super.paint(g); }
	
	public void actionPerformed(ActionEvent e) { super.actionPerformed(e); }
	
	public void mousePressed(MouseEvent me) { mouseXPosition = me.getX(); }
	
	public void mouseDragged(MouseEvent me) {
		if(me.getX()-mouseXPosition > 0) { super.positiveAction(); }
		else { super.negativeAction(); }
		mouseXPosition = me.getX();
	}
	
	public void mouseMoved(MouseEvent arg0) { }
	public void mouseClicked(MouseEvent arg0) { }
	public void mouseEntered(MouseEvent arg0) { }
	public void mouseExited(MouseEvent arg0) { }
	public void mouseReleased(MouseEvent arg0) { }
}
