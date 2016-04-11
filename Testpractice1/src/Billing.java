import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class Billing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textFieldcalculator;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	double firstnum;
	double secondnum;
	double result;
	String answer;
	String operations;
	

	double iTax = 5.50;
	double[] i = new double[5];
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billing frame = new Billing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Billing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 493);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(467, 45, 286, 379);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Calculator", null, panel, null);
		panel.setLayout(null);
		// function of each button in the calculator
		JButton buttonfive = new JButton("5");
		buttonfive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttonfive.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		buttonfive.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonfive.setBounds(45, 117, 50, 45);
		panel.add(buttonfive);
		
		JButton buttonminus = new JButton("-");
		buttonminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textFieldcalculator.getText());
				textFieldcalculator.setText("");
				operations = "-";
			}
		});
		buttonminus.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonminus.setBounds(96, 209, 50, 45);
		panel.add(buttonminus);
		
		JButton buttonthree = new JButton("3");
		buttonthree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttonthree.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		buttonthree.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonthree.setBounds(146, 72, 50, 45);
		panel.add(buttonthree);
		
		JButton buttoneight = new JButton("8");
		buttoneight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttoneight.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		buttoneight.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttoneight.setBounds(196, 117, 50, 45);
		panel.add(buttoneight);
		
		JButton buttontwo = new JButton("2");
		buttontwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttontwo.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		buttontwo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttontwo.setBounds(96, 72, 50, 45);
		panel.add(buttontwo);
		
		JButton buttonmultiply = new JButton("x");
		buttonmultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textFieldcalculator.getText());
				textFieldcalculator.setText("");
				operations = "*";
			}
		});
		buttonmultiply.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonmultiply.setBounds(146, 209, 50, 45);
		panel.add(buttonmultiply);
		
		JButton buttonone = new JButton("1");
		buttonone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttonone.getText();
				textFieldcalculator.setText(entervalue);
				
			}
		});
		buttonone.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonone.setBounds(45, 72, 50, 45);
		panel.add(buttonone);
		
		JButton buttonseven = new JButton("7");
		buttonseven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttonseven.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		buttonseven.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonseven.setBounds(146, 117, 50, 45);
		panel.add(buttonseven);
		
		JButton buttonplus = new JButton("+");
		buttonplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textFieldcalculator.getText());
				textFieldcalculator.setText("");
				operations = "+";
			}
		});
		buttonplus.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonplus.setBounds(46, 209, 50, 45);
		panel.add(buttonplus);
		
		JButton button9 = new JButton("9");
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + button9.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		button9.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		button9.setBounds(46, 163, 50, 45);
		panel.add(button9);
		
		JButton buttondivide = new JButton("/");
		buttondivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textFieldcalculator.getText());
				textFieldcalculator.setText("");
				operations = "/";
			}
		});
		buttondivide.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttondivide.setBounds(196, 209, 50, 45);
		panel.add(buttondivide);
		
		JButton button0 = new JButton("0");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + button0.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		button0.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		button0.setBounds(96, 163, 50, 45);
		panel.add(button0);
		
		JButton buttonsix = new JButton("6");
		buttonsix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttonsix.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		buttonsix.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonsix.setBounds(95, 117, 50, 45);
		panel.add(buttonsix);
		
		JButton buttondot = new JButton(".");
		buttondot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttondot.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		buttondot.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttondot.setBounds(146, 163, 50, 45);
		panel.add(buttondot);
		
		JButton buttonfour = new JButton("4");
		buttonfour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String entervalue = textFieldcalculator.getText() + buttonfour.getText();
				textFieldcalculator.setText(entervalue);
			}
		});
		buttonfour.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonfour.setBounds(196, 72, 50, 45);
		panel.add(buttonfour);
		
		JButton buttonC = new JButton("C");
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldcalculator.setText("");
			}
		});
		buttonC.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonC.setBounds(196, 163, 50, 45);
		panel.add(buttonC);
		
		textFieldcalculator = new JTextField();
		textFieldcalculator.setBounds(25, 25, 235, 36);
		panel.add(textFieldcalculator);
		textFieldcalculator.setColumns(10);
		//operation values of the calculator
		JButton buttonequal = new JButton("=");
		buttonequal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondnum = Double.parseDouble(textFieldcalculator.getText());
				if(operations=="+")
				{
					result = firstnum + secondnum;
					answer = String.format("%.0f", result);
					textFieldcalculator.setText(answer);
				}
				else if(operations=="-")
				{
					result = firstnum - secondnum;
					answer = String.format("%.0f", result);
					textFieldcalculator.setText(answer);
				}
				else if(operations=="*")
				{
					result = firstnum * secondnum;
					answer = String.format("%.0f", result);
					textFieldcalculator.setText(answer);
				}
				else if (operations=="/")
				{
					result = firstnum / secondnum;
					answer = String.format("%.0f", result);
					textFieldcalculator.setText(answer);
				}
			}
		});
		buttonequal.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		buttonequal.setBounds(67, 265, 168, 45);
		panel.add(buttonequal);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_1, null);
		panel_1.setLayout(null);
		
		JCheckBox checkBox = new JCheckBox("Asprin");
		checkBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//double sub = Double.parseDouble(textField_9.getText());
				double Asprin = Double.parseDouble(textField.getText());
				double Asprins = 30;
				
				if (checkBox.isSelected())
				{
					i[0]=(Asprin * Asprins);
					String ASr = String.format("RM %.2f", i[0]);
					textField_9.setText(ASr);
				}
			}
		});
		checkBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		checkBox.setBounds(20, 58, 100, 30);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Anti-Biotics");
		checkBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//double sub = Double.parseDouble(textField_9.getText());
				double Antiboitic = Double.parseDouble(textField_3.getText());
				double Antiboitics = 20.50;
				
				if (checkBox_1.isSelected())
				{
					i[0]=(Antiboitics * Antiboitic);
					String ANr = String.format("RM %.2f", i[0]);
					textField_9.setText(ANr);
				}
			}
		});
		checkBox_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		checkBox_1.setBounds(20, 180, 100, 30);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Injection");
		checkBox_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//double sub = Double.parseDouble(textField_9.getText());
				double Injection = Double.parseDouble(textField_5.getText());
				double Injections = 80;
				
				if (checkBox_2.isSelected())
				{
					i[0]=(Injections * Injection);
					String INr = String.format("RM %.2f", i[0]);
					textField_9.setText(INr);
				}
			}
		});
		checkBox_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		checkBox_2.setBounds(240, 95, 100, 30);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Drip (IV)");
		checkBox_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//double sub = Double.parseDouble(textField_9.getText());
				double Drip = Double.parseDouble(textField_6.getText());
				double Drips = 120.99;
				
				if (checkBox_3.isSelected())
				{
					i[0]=(Drips * Drip);
					String IVr = String.format("RM %.2f", i[0]);
					textField_9.setText(IVr);
				}
			}
		});
		checkBox_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		checkBox_3.setBounds(240, 140, 100, 30);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("BP Test");
		checkBox_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//double sub = Double.parseDouble(textField_9.getText());
				double BPTests = Double.parseDouble(textField_1.getText());
				double BPTest = 8.50;
				
				if (checkBox_4.isSelected())
				{
					i[0]=(BPTests * BPTest);
					String BPr = String.format("RM %.2f", i[0]);
					textField_9.setText(BPr);
				}
			}
		});
		checkBox_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		checkBox_4.setBounds(20, 96, 100, 30);
		contentPane.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("Xray");
		checkBox_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//double sub = Double.parseDouble(textField_9.getText());
				double Xrays = Double.parseDouble(textField_2.getText());
				double xray = 200;
				
				if (checkBox_5.isSelected())
				{
					i[0]=(Xrays * xray);
					String XYr = String.format("RM %.2f", i[0]);
					textField_9.setText(XYr);
				}
			}
		});
		checkBox_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		checkBox_5.setBounds(20, 140, 100, 30);
		contentPane.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("BloodTest");
		checkBox_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//double sub = Double.parseDouble(textField_9.getText());
				double bloodtest = Double.parseDouble(textField_4.getText());
				double bloodtests = 350;
				
				if (checkBox_6.isSelected())
				{
					i[0]=(bloodtests * bloodtest);
					String BTr = String.format("RM %.2f", i[0]);
					textField_9.setText(BTr);
				}
			}
		});
		checkBox_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		checkBox_6.setBounds(240, 58, 100, 30);
		contentPane.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("Preg. Test");
		checkBox_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//double sub = Double.parseDouble(textField_9.getText());
				double pregTest = Double.parseDouble(textField_7.getText());
				double pregTests = 50;
				
				if (checkBox_7.isSelected())
				{
					i[0]=(pregTests * pregTest);
					String PTr = String.format("RM %.2f", i[0]);
					textField_9.setText(PTr);
				}
			}
		});
		checkBox_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		checkBox_7.setBounds(240, 180, 100, 30);
		contentPane.add(checkBox_7);
		
		textField = new JTextField();
		textField.setBounds(148, 60, 70, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 97, 70, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 142, 70, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(148, 182, 70, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(357, 60, 70, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(357, 97, 70, 30);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(357, 142, 70, 30);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(357, 182, 70, 30);
		contentPane.add(textField_7);
		
		JLabel lblNewLabel = new JLabel("Sub Total");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 276, 79, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblTax.setBounds(20, 317, 79, 30);
		contentPane.add(lblTax);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblTotal.setBounds(20, 358, 79, 30);
		contentPane.add(lblTotal);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(111, 278, 200, 30);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(109, 319, 200, 30);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(111, 360, 200, 30);
		contentPane.add(textField_11);
		//clear button
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				//textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				
			}
		});
		btnClear.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnClear.setBounds(336, 278, 90, 30);
		contentPane.add(btnClear);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnReceipt.setBounds(336, 317, 90, 30);
		contentPane.add(btnReceipt);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double subTotals = Double.parseDouble(textField_9.getText());
				double cTax = Double.parseDouble(textField_10.getText());
				double FTotal = (subTotals + cTax);
				
				String iTotal = String.format("RM %.2f", FTotal);
				textField_11.setText(iTotal);	
			}
		});
		btnCalculate.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnCalculate.setBounds(336, 358, 90, 30);
		contentPane.add(btnCalculate);
		
		JCheckBox chckbxTax = new JCheckBox("Tax");
		chckbxTax.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//double itax = 5.50;
				//if (chckbxTax.isSelected()){
				//	String pTax = String.format("%.2f", itax);
				//	textField_10.setText(pTax);
				//}else{
				//	textField_10.setText(null);
				//}
				
				Double iTax;
				iTax =i[0] + i[1] + i[2];
				iTax = iTax/100;
				String cTax = String.format("RM %.2f", iTax);
				textField_10.setText(cTax);
			}
		});
		chckbxTax.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		chckbxTax.setBounds(357, 234, 70, 21);
		contentPane.add(chckbxTax);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManagePatient mp = new ManagePatient();
				mp.setVisible(true);
				dispose();
			}
		});
		btnback.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnback.setBounds(338, 399, 89, 23);
		contentPane.add(btnback);
	}
}
