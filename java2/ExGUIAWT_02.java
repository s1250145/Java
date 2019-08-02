import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * <applet code = "ExGUIAWT_02" width = 400 height = 300></applet>
 */

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {
	
	int i = 0;
	Button negativeButton = new Button("-");
	Button positiveButton = new Button("+");
	Label label = new Label("0");
	
	public void init() {
		add(negativeButton);
        add(label);
		add(positiveButton);
		
		negativeButton.addActionListener(this);
        positiveButton.addActionListener(this);
        
        negativeButton.setBounds(80, 50, 130, 30);
        positiveButton.setBounds(120, 50, 170, 30);
        label.setBounds(100, 50, 150, 30);
        super.init();
    }

    public void paint(Graphics g) { super.paint(g); }
    
    public void actionPerformed(ActionEvent e) {
    		if(e.getSource() == negativeButton) { negativeAction(); } 
    		else { positiveAction(); }
    }
    
    public void negativeAction() {
    		i--;
		label.setText(Integer.toString(i));
    }
    
    public void positiveAction() {
    		i++;
		label.setText(Integer.toString(i));
    }
}
