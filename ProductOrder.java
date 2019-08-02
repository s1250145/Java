import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class SortableDataStore implements Comparable<SortableDataStore> { 
	protected String productItem, noItem, orderInfo;
	public SortableDataStore(String p, String n, String o) {
		productItem = p;
		noItem = n;
		orderInfo = o;
	}
	public SortableDataStore() {
		productItem = null;
		noItem = null;
		orderInfo = null;
	}
	
	public String getName() { return productItem; }
	
	public String getNumber() { return noItem; }
	
	public String toString() { return new String(productItem + ", " + noItem + ", " + orderInfo + "\n"); }
	
	public int compareTo(SortableDataStore v) {
		int result = productItem.compareTo(v.getName());
		return result = result == 0 ? noItem.compareTo(v.getNumber()) : result;
	}
}

public class ProductOrder extends JFrame {
	protected String list_Contents, noOrder, orderInfo;
	protected SortableDataStore[] v = new SortableDataStore[20];

	protected JPanel topp, leftp, rightp,bottomp,centerup, centerdown;
	protected JButton putb, showb, sortb, clearb;
	protected JLabel title, noorder, orderinfo;
	protected JList plist;
	protected JTextField nofield, infofield;
	protected JTextArea contentsarea;
	protected String[] data = {"IBM NoteBook", "Dell Product", "MS Windows", "Sun Workstation", "Oracle DB", "MySQL"};
	protected int idx = 0;
	protected int lastIndex = -1;

	public ProductOrder() {
		getContentPane().setLayout(new BorderLayout());
		topp = new JPanel();
		leftp = new JPanel();
		rightp = new JPanel();
		bottomp = new JPanel();
		centerup = new JPanel();
		centerdown = new JPanel();

		getContentPane().add(topp, "North");
		getContentPane().add(leftp, "West");
		getContentPane().add(rightp, "Center");
		getContentPane().add(bottomp, "South");

		title = new JLabel("Product Order");
		title.setFont(new Font("Product Order",Font.BOLD, 20));
		topp.add(title);

		// plist = 選択できるアイテムのリスト
		plist = new JList(data);
		plist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// リストアイテム選択時の処理
		plist.addListSelectionListener(new ProductItemListener());
		leftp.add(plist);

		noorder = new JLabel("No. of Order Items");
		orderinfo = new JLabel("Order Information");
		nofield = new JTextField();
		infofield = new JTextField();

		// カートに入れるボタン
		putb = new JButton("Put into Cart");
		putb.addActionListener(new PutButtonListener());
		
		// カート内のソートボタン
		sortb = new JButton("Sort Items");
		sortb.addActionListener(new SortButtonListener());
		
		// カート内をリセット
		clearb = new JButton("Reset Cart");
		clearb.addActionListener(new ResetButtonListener());
	
		centerup.setLayout(new GridLayout(2,2));
		centerup.add(noorder);
		centerup.add(orderinfo);
		centerup.add(nofield);
		centerup.add(infofield);
		centerdown.setLayout(new GridLayout(1,2));
		centerdown.add(putb);
		centerdown.add(sortb);
		centerdown.add(clearb);

		rightp.setLayout(new GridLayout(2,1));
		rightp.add(centerup);
		rightp.add(centerdown);

		// カート内を表示するボタン
		showb = new JButton("Show Cart");
		showb.addActionListener(new ShowButtonListener());
		
		contentsarea = new JTextArea(10,1);
		bottomp.setLayout(new GridLayout(1,2));
		bottomp.add(showb);
		bottomp.add(contentsarea);
	}
	
	// -------------------- イベントリスナー --------------------
	
	// リスト選択
	class ProductItemListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			Object selectItem = plist.getSelectedValue();
			if(selectItem != null) list_Contents = selectItem.toString();
		}
	}
	// カートに入れる
	class PutButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setData(nofield, infofield);
			v[++lastIndex] = new SortableDataStore(list_Contents, noOrder, orderInfo);
		}
	}
	// カート内のソート
	class SortButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// ソートを行う
			// nullをチェックする
			// https://codeday.me/jp/qa/20190217/268474.html
			Arrays.sort(v, new Comparator<SortableDataStore>() {
				public int compare(SortableDataStore o1, SortableDataStore o2) {
					if(o1 == null && o2 == null) { return 0; }
					if(o1 == null) { return 1; }
					if(o2 == null) { return -1; }
					return o1.compareTo(o2);
				}
			});
			// ソート結果を表示するためにtextFieldを一度クリア
			contentsarea.setText("");
			for(int i=0; i<=lastIndex; i++) { contentsarea.append(v[i].toString()); }
		}
	}
	// カートの初期化
	class ResetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			v = new SortableDataStore[20];
			idx = 0;
			lastIndex = -1;
			contentsarea.setText("");
		}
	}
	// カート中身の表示
	class ShowButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { showData(); }
	}
	// 配列データの表示
	public void showData() {
		for(int i=idx; i<=lastIndex; i++) { 
			contentsarea.append(v[i].toString());
			idx++;
		}
	}
	// 個数とInfoをセットし入力欄をクリア
	public void setData(JTextField no, JTextField info) {
		noOrder = no.getText();
		orderInfo = info.getText();
		no.setText("");
		info.setText("");
	}
	
	// --------------------------------------------------
	
	public static void main (String args[]) {
		ProductOrder f = new ProductOrder();
		f.setTitle("Product Order");
		f.setSize(500,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}