import javax.swing.JFrame;

public class ExGUISwing_01 extends JFrame {
	ExGUISwing_01() {
		super("ExGUISwing_01");
		setSize(250, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String argv[]) {
		ExGUISwing_01 a = new ExGUISwing_01();
		a.setVisible(true);
	}
}
