import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class ExGUISwing_02 extends ExGUISwing_01 {
	// パネルおよびテキストのオブジェクト生成
	JPanel textPanel = new JPanel();
	JPanel leftButton = new JPanel();
	JPanel rightButton = new JPanel();
	JLabel text = new JLabel("Power off");
	
        ExGUISwing_02() {
                super.setTitle("ExGUISwing_02");
                
                // コンテナオブジェクトの取得
                Container ctn = this.getContentPane();
                ctn.setLayout(new FlowLayout());
                
                // 設定
                settingPanelLayout();  
                settingTextFormat();
                
                // パネルへ要素の追加
                leftButton.add(new JButton("PW"));
                leftButton.add(new JButton("AM"));
                leftButton.add(new JButton("FM"));
                textPanel.setBorder(new BevelBorder(1));
                textPanel.add(text);
                rightButton.add(new JButton("CD"));
                rightButton.add(new JButton("Up"));
                rightButton.add(new JButton("Down"));
                
                // コンテナにパネルを配置
                ctn.add(leftButton);
                ctn.add(textPanel);
                ctn.add(rightButton);
                
                // サイズの設定
                setSize(350,150);
        }
        
        // 各パネルのレイアウトを設定
        public void settingPanelLayout() {
        		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 40));
        		leftButton.setLayout(new GridLayout(3,1,2,2));
        		rightButton.setLayout(new GridLayout(3,1,2,2));
        }
        
        // テキストのスタイルを設定
        public void settingTextFormat() {
        		text.setFont(new Font(null, Font.BOLD, 26));
        		text.setForeground(Color.green.darker());
        }
        
        public static void main(String argv[]) {
                ExGUISwing_02 obj = new ExGUISwing_02();
                obj.setVisible(true);
        }
}
