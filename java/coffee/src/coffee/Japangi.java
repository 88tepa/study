package coffee;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class Japangi extends Frame implements ActionListener {
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	private Image img1, img2, img3, img4, img5, img6, imgPick;
	
	Font fontP15 = new Font("SansSerif", Font.PLAIN, 15);
	Font fontP20 = new Font("SansSerif", Font.PLAIN, 20);
	Font fontP25 = new Font("SansSerif", Font.PLAIN, 25);
	Font fontP30 = new Font("SansSerif", Font.PLAIN, 30);
	
	Font fontB15 = new Font("SansSerif", Font.BOLD, 15);
	Font fontB20 = new Font("SansSerif", Font.BOLD, 20);
	Font fontB25 = new Font("SansSerif", Font.BOLD, 25);
	Font fontB30 = new Font("SansSerif", Font.BOLD, 30);

	Font fontB40 = new Font("SansSerif", Font.BOLD, 40);

	int n1 =0;
	int n2 =0;
	int n3 =0;
	int n4 =0;
	int n5 =0;
	int n6 =0;
	int nTot = 0;
	
	int p1 = 0;
	int p2 = 0;
	int p3 = 0;
	int p4 = 0;
	int p5 = 0;
	int p6 = 0;
	int pTot = 0;
	
	int moneyTot = 0;
	
	Label lbTitle = new Label("Ŀ�� ���Ǳ�");
	
	Label lbQty1 = new Label("���� 0��");
	Label lbQty2 = new Label("���� 0��");
	Label lbQty3 = new Label("���� 0��");
	Label lbQty4 = new Label("���� 0��");
	Label lbQty5 = new Label("���� 0��");
	Label lbQty6 = new Label("���� 0��");
	
	Button btn1 = new Button("����������");
	Button btn2 = new Button("�Ƹ޸�ī��");
	Button btn3 = new Button("ī���");
	Button btn4 = new Button("īǪġ��");
	Button btn5 = new Button("ī��ḶŰ�ƶ�");
	Button btn6 = new Button("ī���ī");
	
	Label lbQty1Price = new Label("1000��");
	Label lbQty2Price = new Label("2000��");
	Label lbQty3Price = new Label("3000��");
	Label lbQty4Price = new Label("3000��");
	Label lbQty5Price = new Label("4000��");
	Label lbQty6Price = new Label("3000��");
	
	Label lbPick = new Label("���û�ǰ");
	Label lbName = new Label("ȣ�ѷ�Ŀ��");
	Label lbQtyPick = new Label("���� : 0��");
	Label lbPrice = new Label("�ݾ� : 0��");
	Label lbQtyTot = new Label("�� ���� : 0��");
	
	Label lbInMoney = new Label("���Աݾ�");
	Button btn1k = new Button("1000��");
	Button btn5k = new Button("5000��");
	Button btn10k = new Button("10000��");
	Button btnPay = new Button("�����ϱ�");
	Button btnReset = new Button("�ʱ�ȭ");
	Label lbInMoneyTot = new Label("�����ܾ� :  0��");
	Label lbPayMoneyTot = new Label("�����ݾ� :  0��");
	
	
	// �α��� üũ ����
	boolean loginCheck = false;
	
	Japangi() {
		super("���Ǳ�");
		this.setSize(1000,850);
		this.center();
		this.init();
		this.start();
		this.setVisible(true); //�� �κ��� �־�� â�� ���̰� ���� ��
	}
	void init() { //initialize ���Ӹ��� �� init 	
		
		this.setLayout(null); //absolute ������� ���̾ ��ġ�Ҽ� �ְ� ����
		
		img1 = Toolkit.getDefaultToolkit().getImage("coffee_img/Espresso.jpg");
		img2 = Toolkit.getDefaultToolkit().getImage("coffee_img/Americano.jpg");
		img3 = Toolkit.getDefaultToolkit().getImage("coffee_img/CaffeLatte.jpg");
		img4 = Toolkit.getDefaultToolkit().getImage("coffee_img/Cappuccino.jpg");
		img5 = Toolkit.getDefaultToolkit().getImage("coffee_img/CaramelMacchiato.jpg");
		img6 = Toolkit.getDefaultToolkit().getImage("coffee_img/CaffeMocha.jpg");
		imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/HoroloCoffeeLogo.png");
//		imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/HoroloCoffeeLogo.jpg? jpeg?");
		
		this.add(lbTitle);
		lbTitle.setFont(fontB40);
		lbTitle.setBounds(375, 50, 250, 50);
		
		this.add(lbQty1);
		lbQty1.setFont(fontB20);
		lbQty1.setBounds(110, 270, 100, 30);
		this.add(lbQty2);
		lbQty2.setFont(fontB20);
		lbQty2.setBounds(290, 270, 100, 30);
		this.add(lbQty3);
		lbQty3.setFont(fontB20);
		lbQty3.setBounds(470, 270, 100, 30);
		this.add(lbQty4);
		lbQty4.setFont(fontB20);
		lbQty4.setBounds(110, 550, 100, 30);
		this.add(lbQty5);
		lbQty5.setFont(fontB20);
		lbQty5.setBounds(290, 550, 100, 30);
		this.add(lbQty6);
		lbQty6.setFont(fontB20);
		lbQty6.setBounds(470, 550, 100, 30);
		
		this.add(btn1);
		btn1.setFont(fontB20);
		btn1.setBounds(90, 300, 130, 30);
		this.add(btn2);
		btn2.setFont(fontB20);
		btn2.setBounds(270, 300, 130, 30);
		this.add(btn3);
		btn3.setFont(fontB20);
		btn3.setBounds(450, 300, 130, 30);
		this.add(btn4);
		btn4.setFont(fontB20);
		btn4.setBounds(90, 580, 130, 30);
		this.add(btn5);
		btn5.setFont(fontB15);
		btn5.setBounds(270, 580, 130, 30);
		this.add(btn6);
		btn6.setFont(fontB20);
		btn6.setBounds(450, 580, 130, 30);
		
		this.add(lbQty1Price);
		lbQty1Price.setFont(fontB20);
		lbQty1Price.setBounds(120, 330, 130, 30);
		this.add(lbQty2Price);
		lbQty2Price.setFont(fontB20);
		lbQty2Price.setBounds(300, 330, 130, 30);
		this.add(lbQty3Price);
		lbQty3Price.setFont(fontB20);
		lbQty3Price.setBounds(480, 330, 130, 30);
		this.add(lbQty4Price);
		lbQty4Price.setFont(fontB20);
		lbQty4Price.setBounds(120, 610, 130, 30);
		this.add(lbQty5Price);
		lbQty5Price.setFont(fontB20);
		lbQty5Price.setBounds(300, 610, 130, 30);
		this.add(lbQty6Price);
		lbQty6Price.setFont(fontB20);
		lbQty6Price.setBounds(480, 610, 130, 30);
		
		this.add(lbInMoney);
		lbInMoney.setFont(fontB20);
		lbInMoney.setBounds(90, 670, 130, 30);
		this.add(btn1k);
		btn1k.setFont(fontB30);
		btn1k.setBounds(90, 710, 130, 40);
		this.add(btn5k);
		btn5k.setFont(fontB30);
		btn5k.setBounds(270, 710, 130, 40);
		this.add(btn10k);
		btn10k.setFont(fontB30);
		btn10k.setBounds(450, 710, 130, 40);
		
		this.add(lbInMoneyTot);
		lbInMoneyTot.setFont(fontB30);
		lbInMoneyTot.setBounds(90, 770, 310, 40);
		this.add(lbPayMoneyTot);
		lbPayMoneyTot.setFont(fontB30);
		lbPayMoneyTot.setBounds(450, 770, 310, 40);
		
		this.add(lbPick);
		lbPick.setFont(fontB40);
		lbPick.setBounds(680, 140, 180, 40);
		this.add(lbName);
		lbName.setFont(fontB25);
		lbName.setBounds(670, 420, 200, 40);
		this.add(lbQtyPick);
		lbQtyPick.setFont(fontB25);
		lbQtyPick.setBounds(670, 470, 200, 40);
		this.add(lbPrice);
		lbPrice.setFont(fontB25);
		lbPrice.setBounds(670, 520, 200, 40);
		this.add(lbQtyTot);
		lbQtyTot.setFont(fontB25);
		lbQtyTot.setBounds(670, 570, 200, 40);
		
		this.add(btnPay);
		btnPay.setFont(fontB40);
		btnPay.setBounds(620, 680, 300, 70);
		this.add(btnReset);
		btnReset.setFont(fontB30);
		btnReset.setBounds(820, 760, 100, 40);
		
	}
	public void paint(Graphics g) {
		g.drawImage(img1, 80, 110, 150, 150, this);
		g.drawImage(img2, 260, 110, 150, 150, this);
		g.drawImage(img3, 440, 110, 150, 150, this);
		g.drawImage(img4, 80, 390, 150, 150, this);
		g.drawImage(img5, 260, 390, 150, 150, this);
		g.drawImage(img6, 440, 390, 150, 150, this);
		g.drawImage(imgPick, 670, 200, 200, 200, this);
		g.drawRect(80, 110, 150, 150); // 1
		g.drawRect(260, 110, 150, 150); // 2
		g.drawRect(440, 110, 150, 150); // 3
		g.drawRect(80, 390, 150, 150); // 4
		g.drawRect(260, 390, 150, 150); // 5
		g.drawRect(440, 390, 150, 150); // 6
		g.drawRoundRect(620, 110, 300, 540, 20, 20); // ����â
	}
	void start() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		
		btn1k.addActionListener(this);
		btn5k.addActionListener(this);
		btn10k.addActionListener(this);
		btnPay.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			int price= 1000;
			lbName.setText("����������");
			this.n1++;
			this.nTot++;
			this.p1 += price;
			this.pTot += price;
			lbQty1.setText("���� "+this.n1+"��");
			lbQtyPick.setText("���� : "+this.n1+"��");
			lbPrice.setText("�ݾ� : "+this.p1+"��");
			imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/Espresso.jpg");
			this.repaint();
		}
		if(e.getSource() == btn2) {
			int price= 2000;
			lbName.setText("�Ƹ޸�ī��");
			this.n2++;
			this.nTot++;
			this.p2 += price;
			this.pTot += price;
			lbQty2.setText("���� "+this.n2+"��");
			lbQtyPick.setText("���� : "+this.n2+"��");
			lbPrice.setText("�ݾ� : "+this.p2+"��");
			imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/Americano.jpg");
			this.repaint();
		}
		if(e.getSource() == btn3) {
			int price= 3000;
			lbName.setText("ī���");
			this.n3++;
			this.nTot++;
			this.p3 += price;
			this.pTot += price;
			lbQty3.setText("���� "+this.n3+"��");
			lbQtyPick.setText("���� : "+this.n3+"��");
			lbPrice.setText("�ݾ� : "+this.p3+"��");
			imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/CaffeLatte.jpg");
			this.repaint();
		}
		if(e.getSource() == btn4) {
			int price= 3000;
			lbName.setText("īǪġ��");
			this.n4++;
			this.nTot++;
			this.p4 += price;
			this.pTot += price;
			lbQty4.setText("���� "+this.n4+"��");
			lbQtyPick.setText("���� : "+this.n4+"��");
			lbPrice.setText("�ݾ� : "+this.p4+"��");
			imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/Cappuccino.jpg");
			this.repaint();
		}
		if(e.getSource() == btn5) {
			int price= 4000;
			lbName.setText("ī��ḶŰ�ƶ�");
			this.n5++;
			this.nTot++;
			this.p5 += price;
			this.pTot += price;
			lbQty5.setText("���� "+this.n5+"��");
			lbQtyPick.setText("���� : "+this.n5+"��");
			lbPrice.setText("�ݾ� : "+this.p5+"��");
			imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/CaramelMacchiato.jpg");
			this.repaint();
		}
		if(e.getSource() == btn6) {
			int price= 3000;
			lbName.setText("ī���ī");
			this.n6++;
			this.nTot++;
			this.p6 += price;
			this.pTot += price;
			lbQty6.setText("���� "+this.n6+"��");
			lbQtyPick.setText("���� : "+this.n6+"��");
			lbPrice.setText("�ݾ� : "+this.p6+"��");
			imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/CaffeMocha.jpg");
			this.repaint();
		}
		if(e.getSource() == btn1k) {
			int money = 1000;
			this.moneyTot += money;
		}
		if(e.getSource() == btn5k) {
			int money = 5000;
			this.moneyTot += money;
		}
		if(e.getSource() == btn10k) {
			int money = 10000;
			this.moneyTot += money;
		}
		lbInMoneyTot.setText("�����ܾ� :  "+this.moneyTot+"��");
		lbQtyTot.setText("�� ���� : "+this.nTot+"��");
		lbPayMoneyTot.setText("�����ݾ� :  "+this.pTot+"��");
		if(e.getSource() == btnPay) {
			if(0 == this.pTot) {
				msg("���� Ŀ�Ǹ� ���� �� �ּ���");
				return;
			}
			if(this.moneyTot >= this.pTot) {
				msg("�����մϴ�!");
				if(this.moneyTot > this.pTot) {
					int result = 0;					
					result = this.moneyTot - this.pTot;
					msg("�Ž������� "+result+"�� �Դϴ�.");
				}
				reset();
			}
			if(this.moneyTot < this.pTot) {
				msg("���� �ݾ��� �����մϴ�!");
				return;
			}
		}
		if(e.getSource() == btnReset) {
			reset();
		}
	}
	void reset() {
		lbName.setText("ȣ�ѷ�Ŀ��");
		
		this.n1 = 0;
		this.n2 = 0;
		this.n3 = 0;
		this.n4 = 0;
		this.n5 = 0;
		this.n6 = 0;
		this.nTot = 0;
		this.p1 = 0;
		this.p2 = 0;
		this.p3 = 0;
		this.p4 = 0;
		this.p5 = 0;
		this.p6 = 0;
		this.pTot = 0;
		this.moneyTot = 0;
		lbQty1.setText("���� "+this.n1+"��");
		lbQty2.setText("���� "+this.n2+"��");
		lbQty3.setText("���� "+this.n3+"��");
		lbQty4.setText("���� "+this.n4+"��");
		lbQty5.setText("���� "+this.n5+"��");
		lbQty6.setText("���� "+this.n6+"��");
		lbQtyPick.setText("���� : 0��");
		lbPrice.setText("�ݾ� : 0��");
						
		lbInMoneyTot.setText("�����ܾ� :  "+this.moneyTot+"��");
		lbQtyTot.setText("�� ���� : "+this.nTot+"��");
		lbPayMoneyTot.setText("�����ݾ� :  "+this.pTot+"��");

		imgPick = Toolkit.getDefaultToolkit().getImage("coffee_img/HoroloCoffeeLogo.png");
		this.repaint();
	}
//	void logIn(String myId, String myPw) {
//		try {
//			Class.forName("org.gjt.mm.mysql.Driver");
//		} catch (ClassNotFoundException ee) {
//			System.out.println("����̺갡 ����ȵ�");
//			System.exit(0);
//		}
//		Connection conn = null;
//		String url = "jdbc:mysql://127.0.0.1:3306/dw202?useUnicode=true&characterEncoding=utf8"; // ���� ������ �� 127.0.0.1 �� ��
//		String id = "root";
//		String pass = "qwer";
//		Statement stmt = null;
//		ResultSet rs = null;
//		String query = "select * from member";
//		try {
//			conn = DriverManager.getConnection(url, id, pass);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				if(rs.getString(2).equals(myId) && rs.getString(3).equals(myPw)) {
//					loginCheck=true;
//					break;
//				}
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (SQLException ee) {
//			System.err.println("error = " + ee.toString());
//		}
//	}
	void msg(String msg) {
		final Dialog dlg = new Dialog(this, "�˸� �޼���â", true);
		dlg.setLayout(null);
		Label lbMsg = new Label(msg);
		
		dlg.add(lbMsg);
		lbMsg.setFont(fontB20);
		lbMsg.setBounds(80, 100, 300, 30);
		
		dlg.setSize(400, 200);
		dlg.setLocation(800, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
}