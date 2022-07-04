package br.com.fazendasantafe.util;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;


public class Calculadora extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtValor;
	private int coutponto = 0;
	private Robot robot;
	
	private JRadioButton rbHex;
	private JRadioButton rbDec;
	private JRadioButton rbBin;
	private JRadioButton rbOct;
	private JRadioButton rbGraus;
	private JRadioButton rbRadianos;
	private JRadioButton rbGrados;
	
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	
	private double valor = 0;
	private String evento = "";

	public static void main(String[] args) {
		try {
			Calculadora dialog = new Calculadora();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Calculadora() {
		setResizable(false);
		setTitle("Calculadora");
		setBounds(100, 100, 602, 339);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setLocationRelativeTo(null);
		setModal(true);
		
		txtValor = new JTextField();
		txtValor.setDocument(new IntegerDocument(30));
		txtValor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtValor.getText().equals("0")) {
					txtValor.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtValor.getText().equals("")) {
					txtValor.setText("0");
				}
			}
		});
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setText("0");
		txtValor.setBounds(10, 11, 574, 20);
		contentPanel.add(txtValor);
		txtValor.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(10, 40, 574, 28);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rbHex = new JRadioButton("Hex");
		rbHex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbHex.setSelected(true);
				rbDec.setSelected(false);
				rbBin.setSelected(false);
				rbOct.setSelected(false);
				
				/*String array = txtValor.getText();
				char valorTotal;
				int v = 0;
				for (int i = 0; i < array.length(); i++) {
					valorTotal =  txtValor.getText().charAt(i);
					System.out.println(valorTotal);
					System.out.println(Math.pow(16, (array.length()-1)-i));
					v = (int) (v + (valorTotal * Math.pow(16, (array.length()-1)-i)));
					System.out.println(v);
				}
				txtValor.setText(Integer.toString(v));*/
			}
		});
		rbHex.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rbHex.setBounds(3, 3, 58, 22);
		panel.add(rbHex);
		
		rbDec = new JRadioButton("Dec");
		rbDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbDec.setSelected(true);
				rbHex.setSelected(false);
				rbBin.setSelected(false);
				rbOct.setSelected(false);
				
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
				btn8.setEnabled(true);
				btn9.setEnabled(true);
			}
		});
		rbDec.setSelected(true);
		rbDec.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rbDec.setBounds(63, 3, 58, 22);
		panel.add(rbDec);
		
		rbOct = new JRadioButton("Oct");
		rbOct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbOct.setSelected(true);
				rbDec.setSelected(false);
				rbBin.setSelected(false);
				rbHex.setSelected(false);
			
				btn8.setEnabled(false);
				btn9.setEnabled(false);
				
				btn0.setEnabled(true);
				btn1.setEnabled(true);
				btn2.setEnabled(true);
				btn3.setEnabled(true);
				btn4.setEnabled(true);
				btn5.setEnabled(true);
				btn6.setEnabled(true);
				btn7.setEnabled(true);
			}
		});
		rbOct.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rbOct.setBounds(123, 3, 58, 22);
		panel.add(rbOct);
		
		rbBin = new JRadioButton("Bin");
		rbBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbBin.setSelected(true);
				rbDec.setSelected(false);
				rbHex.setSelected(false);
				rbOct.setSelected(false);
				
				btn2.setEnabled(false);
				btn3.setEnabled(false);
				btn4.setEnabled(false);
				btn5.setEnabled(false);
				btn6.setEnabled(false);
				btn7.setEnabled(false);
				btn8.setEnabled(false);
				btn9.setEnabled(false);
			}
		});
		rbBin.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rbBin.setBounds(183, 3, 58, 22);
		panel.add(rbBin);
		
		rbRadianos = new JRadioButton("Radianos");
		rbRadianos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbRadianos.setSelected(true);
				rbGraus.setSelected(false);
				rbGrados.setSelected(false);
			}
		});
		rbRadianos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rbRadianos.setBounds(380, 3, 85, 22);
		panel.add(rbRadianos);
		
		rbGrados = new JRadioButton("Grados");
		rbGrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbGrados.setSelected(true);
				rbRadianos.setSelected(false);
				rbGraus.setSelected(false);
			}
		});
		rbGrados.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rbGrados.setBounds(478, 3, 85, 22);
		panel.add(rbGrados);
		
		rbGraus = new JRadioButton("Graus");
		rbGraus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbGraus.setSelected(true);
				rbRadianos.setSelected(false);
				rbGrados.setSelected(false);
			}
		});
		rbGraus.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rbGraus.setBounds(289, 3, 67, 22);
		panel.add(rbGraus);
		
		JButton btnNewButton = new JButton("C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor = 0;
				txtValor.setText("0");
				txtValor.setDocument(new IntegerDocument(30));
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(479, 79, 105, 36);
		contentPanel.add(btnNewButton);
		
		JButton btnCe = new JButton("CE");
		btnCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor = 0;
				txtValor.setText("0");
				txtValor.setDocument(new IntegerDocument(30));
			}
		});
		btnCe.setForeground(Color.RED);
		btnCe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCe.setBounds(371, 79, 105, 36);
		contentPanel.add(btnCe);
		
		JButton btnBackspace = new JButton("Backspace");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")) {
					txtValor.setText(backspace(txtValor.getText()));
				}
			}
		});
		btnBackspace.setForeground(Color.RED);
		btnBackspace.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBackspace.setBounds(263, 79, 105, 36);
		contentPanel.add(btnBackspace);
		
		JButton btnNewButton_1 = new JButton("&&");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.setBounds(533, 120, 51, 28);
		contentPanel.add(btnNewButton_1);
		
		JButton btnXor = new JButton("Xor");
		btnXor.setEnabled(false);
		btnXor.setForeground(Color.RED);
		btnXor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnXor.setBounds(533, 151, 51, 28);
		contentPanel.add(btnXor);
		
		JButton btnNot = new JButton("Not");
		btnNot.setEnabled(false);
		btnNot.setForeground(Color.RED);
		btnNot.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNot.setBounds(533, 183, 51, 28);
		contentPanel.add(btnNot);
		
		JButton btnInt = new JButton("Int");
		btnInt.setEnabled(false);
		btnInt.setForeground(Color.RED);
		btnInt.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnInt.setBounds(533, 215, 51, 28);
		contentPanel.add(btnInt);
		
		JButton btnMod = new JButton("Md");
		btnMod.setEnabled(false);
		btnMod.setForeground(Color.RED);
		btnMod.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMod.setBounds(479, 120, 51, 28);
		contentPanel.add(btnMod);
		
		JButton btnOr = new JButton("Or");
		btnOr.setEnabled(false);
		btnOr.setForeground(Color.RED);
		btnOr.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnOr.setBounds(479, 151, 51, 28);
		contentPanel.add(btnOr);
		
		JButton btnLsh = new JButton("Lsh");
		btnLsh.setEnabled(false);
		btnLsh.setForeground(Color.RED);
		btnLsh.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnLsh.setBounds(479, 183, 51, 28);
		contentPanel.add(btnLsh);
		
		JButton button_8 = new JButton("=");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (evento.equals("div")) {
					dividir();
				}else if (evento.equals("mult")) {
					multiplicar();
				}else if (evento.equals("som")) {
					somar();
				}else if (evento.equals("sub")) {
					subtrair();
				}
				valor = 0;
			}
		});
		button_8.setForeground(Color.RED);
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_8.setBounds(479, 215, 51, 28);
		contentPanel.add(button_8);
		
		JButton button_9 = new JButton("/");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento = "div";
				dividir();
				txtValor.setDocument(new IntegerDocument(30));
			}
		});
		button_9.setForeground(Color.RED);
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_9.setBounds(425, 120, 51, 28);
		contentPanel.add(button_9);
		
		JButton button_10 = new JButton("*");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento = "mult";
				multiplicar();
				txtValor.setDocument(new IntegerDocument(30));
			}
		});
		button_10.setForeground(Color.RED);
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_10.setBounds(425, 151, 51, 28);
		contentPanel.add(button_10);
		
		JButton button_11 = new JButton("-");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento = "sub";
				subtrair();
				txtValor.setDocument(new IntegerDocument(30));
			}
		});
		button_11.setForeground(Color.RED);
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_11.setBounds(425, 183, 51, 28);
		contentPanel.add(button_11);
		
		JButton button_12 = new JButton("+");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evento = "som";
				somar();
				txtValor.setDocument(new IntegerDocument(30));
			}
		});
		button_12.setForeground(Color.RED);
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_12.setBounds(425, 215, 51, 28);
		contentPanel.add(button_12);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_9);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn9.setForeground(Color.BLUE);
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn9.setBounds(371, 120, 51, 28);
		contentPanel.add(btn9);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_6);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn6.setForeground(Color.BLUE);
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn6.setBounds(371, 151, 51, 28);
		contentPanel.add(btn6);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_3);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn3.setForeground(Color.BLUE);
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn3.setBounds(371, 183, 51, 28);
		contentPanel.add(btn3);
		
		JButton button_16 = new JButton(",");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_PERIOD);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
				/*coutponto+=1;
				if (coutponto == 1) {
					txtValor.setText(txtValor.getText() + ".");
				}*/
			}
		});
		button_16.setForeground(Color.BLUE);
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_16.setBounds(371, 215, 51, 28);
		contentPanel.add(button_16);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_8);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn8.setForeground(Color.BLUE);
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn8.setBounds(317, 120, 51, 28);
		contentPanel.add(btn8);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_5);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn5.setForeground(Color.BLUE);
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn5.setBounds(317, 151, 51, 28);
		contentPanel.add(btn5);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_2);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn2.setForeground(Color.BLUE);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn2.setBounds(317, 183, 51, 28);
		contentPanel.add(btn2);
		
		JButton button_20 = new JButton("+/-");
		button_20.setEnabled(false);
		button_20.setForeground(Color.BLUE);
		button_20.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_20.setBounds(317, 215, 51, 28);
		contentPanel.add(button_20);
		
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_7);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn7.setForeground(Color.BLUE);
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn7.setBounds(263, 120, 51, 28);
		contentPanel.add(btn7);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_4);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn4.setForeground(Color.BLUE);
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn4.setBounds(263, 151, 51, 28);
		contentPanel.add(btn4);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_1);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn1.setForeground(Color.BLUE);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn1.setBounds(263, 183, 51, 28);
		contentPanel.add(btn1);
		
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_0);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn0.setForeground(Color.BLUE);
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn0.setBounds(263, 215, 51, 28);
		contentPanel.add(btn0);
		
		JButton btnA = new JButton("A");
		btnA.setEnabled(false);
		btnA.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnA.setBounds(263, 247, 51, 28);
		contentPanel.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setEnabled(false);
		btnB.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnB.setBounds(317, 247, 51, 28);
		contentPanel.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.setEnabled(false);
		btnC.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnC.setBounds(371, 247, 51, 28);
		contentPanel.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.setEnabled(false);
		btnD.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnD.setBounds(425, 247, 51, 28);
		contentPanel.add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.setEnabled(false);
		btnE.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnE.setBounds(479, 247, 51, 28);
		contentPanel.add(btnE);
		
		JButton btnF = new JButton("F");
		btnF.setEnabled(false);
		btnF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnF.setBounds(533, 247, 51, 28);
		contentPanel.add(btnF);
		
		JButton btnMParaHa = new JButton("M\u00B2 to HA");
		btnMParaHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
					txtValor.setText(Double.toString(Double.parseDouble(txtValor.getText()) / 10000));
				}
			}
		});
		btnMParaHa.setForeground(Color.MAGENTA);
		btnMParaHa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMParaHa.setBounds(10, 120, 89, 28);
		contentPanel.add(btnMParaHa);
		
		JButton btnKmToHa = new JButton("Km\u00B2 to HA");
		btnKmToHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
				txtValor.setText(Double.toString(Double.parseDouble(txtValor.getText()) * 100));
				
				// Com as linhas abaixo o campo txtValor pode receber . (ponto) novamente 
				/*String v = Double.toString(Double.parseDouble(txtValor.getText()) * 100);
				txtValor.setDocument(new IntegerDocument(30));
				txtValor.setText(v);*/
				}
			}
		});
		btnKmToHa.setForeground(Color.MAGENTA);
		btnKmToHa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnKmToHa.setBounds(102, 120, 89, 28);
		contentPanel.add(btnKmToHa);
		
		JButton btnMToAlq = new JButton("M\u00B2 to Alq");
		btnMToAlq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
				txtValor.setText(formataValorNotacao(Double.parseDouble(txtValor.getText()) * 0.0000413).replace(",", "."));
				}
			}
		});
		btnMToAlq.setForeground(Color.MAGENTA);
		btnMToAlq.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnMToAlq.setBounds(10, 151, 89, 28);
		contentPanel.add(btnMToAlq);
		
		JButton btnKmToAlq = new JButton("Km\u00B2 to Alq");
		btnKmToAlq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
				txtValor.setText(formataValorNotacao(/*(*/Double.parseDouble(txtValor.getText()) * 41.3223/*1000000) * 0.0000414*/).replace(",", "."));
				}
			}
		});
		btnKmToAlq.setForeground(Color.MAGENTA);
		btnKmToAlq.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnKmToAlq.setBounds(102, 151, 89, 28);
		contentPanel.add(btnKmToAlq);
		
		JButton btnAlqToHa = new JButton("Alq to HA");
		btnAlqToHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {	
				txtValor.setText(Double.toString(Double.parseDouble(txtValor.getText()) * 2.42));
				}
			}
		});
		btnAlqToHa.setForeground(Color.MAGENTA);
		btnAlqToHa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlqToHa.setBounds(10, 183, 89, 28);
		contentPanel.add(btnAlqToHa);
		
		JButton btnAlqToM = new JButton("Alq to M\u00B2");
		btnAlqToM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
				txtValor.setText(Double.toString(Double.parseDouble(txtValor.getText()) * 24200));
				}
			}
		});
		btnAlqToM.setForeground(Color.MAGENTA);
		btnAlqToM.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAlqToM.setBounds(102, 183, 89, 28);
		contentPanel.add(btnAlqToM);
		
		JButton btnHaToM = new JButton("HA to Alq");
		btnHaToM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
				txtValor.setText(Double.toString(Double.parseDouble(txtValor.getText()) * 0.4132));
				}
			}
		});
		btnHaToM.setForeground(Color.MAGENTA);
		btnHaToM.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHaToM.setBounds(10, 215, 89, 28);
		contentPanel.add(btnHaToM);
		
		JButton btnHaToM_1 = new JButton("HA to M\u00B2");
		btnHaToM_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
				txtValor.setText(Double.toString(Double.parseDouble(txtValor.getText()) / 0.00010000));
				}
			}
		});
		btnHaToM_1.setForeground(Color.MAGENTA);
		btnHaToM_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHaToM_1.setBounds(102, 215, 89, 28);
		contentPanel.add(btnHaToM_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBounds(10, 79, 241, 36);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("(");
		button.setForeground(Color.BLUE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBounds(201, 120, 51, 28);
		contentPanel.add(button);
		
		JButton button_1 = new JButton(")");
		button_1.setForeground(Color.BLUE);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.setBounds(201, 151, 51, 28);
		contentPanel.add(button_1);
		
		JButton btnXy = new JButton("x^3");
		btnXy.setForeground(Color.BLUE);
		btnXy.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnXy.setBounds(201, 183, 51, 28);
		contentPanel.add(btnXy);
		
		JButton btnX = new JButton("x^2");
		btnX.setForeground(Color.BLUE);
		btnX.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnX.setBounds(201, 215, 51, 28);
		contentPanel.add(btnX);
		
		JButton btnAcreToAlq = new JButton("Acre to Alq");
		btnAcreToAlq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
				txtValor.setText(Double.toString(Double.parseDouble(txtValor.getText()) * 0.1672));
				}
			}
		});
		btnAcreToAlq.setForeground(Color.MAGENTA);
		btnAcreToAlq.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAcreToAlq.setBounds(102, 247, 89, 28);
		contentPanel.add(btnAcreToAlq);
		
		JButton btnAcreToHa = new JButton("Acre to HA");
		btnAcreToHa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtValor.getText().equals("")  && !txtValor.getText().equals(".")) {
				txtValor.setText(Double.toString(Double.parseDouble(txtValor.getText()) * 0.4047));
				}
			}
		});
		btnAcreToHa.setForeground(Color.MAGENTA);
		btnAcreToHa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAcreToHa.setBounds(10, 247, 89, 28);
		contentPanel.add(btnAcreToHa);
		
		JButton btnPi = new JButton("pi");
		btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					robot = new Robot();
					txtValor.requestFocus();
		            robot.keyPress(KeyEvent.VK_3);
		            robot.keyPress(KeyEvent.VK_PERIOD);
		            robot.keyPress(KeyEvent.VK_1);
		            robot.keyPress(KeyEvent.VK_4);
		            robot.keyPress(KeyEvent.VK_1);
		            robot.keyPress(KeyEvent.VK_5);
		            robot.keyPress(KeyEvent.VK_9);
		            robot.keyPress(KeyEvent.VK_2);
		            robot.keyPress(KeyEvent.VK_6);
		            robot.keyPress(KeyEvent.VK_5);
		            robot.keyPress(KeyEvent.VK_3);
		            robot.keyPress(KeyEvent.VK_5);
		            robot.keyPress(KeyEvent.VK_8);
		            robot.keyPress(KeyEvent.VK_9);
		            robot.keyPress(KeyEvent.VK_7);
		            robot.keyPress(KeyEvent.VK_9);
		            robot.keyPress(KeyEvent.VK_3);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPi.setForeground(Color.BLUE);
		btnPi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPi.setBounds(201, 247, 51, 28);
		contentPanel.add(btnPi);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenuItem mntmCopiarCtrl = new JMenuItem("Copiar Ctrl + C");
		mntmCopiarCtrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtValor.selectAll();
				txtValor.requestFocus();
				try {
					robot = new Robot();
		            robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_C);
		            robot.keyRelease(KeyEvent.VK_C);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnEditar.add(mntmCopiarCtrl);
		
		JMenuItem mntmColarCtrl = new JMenuItem("Colar   Ctrl + V");
		mntmColarCtrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtValor.selectAll();
				txtValor.requestFocus();
				try {
					robot = new Robot();
		            robot.keyPress(KeyEvent.VK_CONTROL);
		            robot.keyPress(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_V);
		            robot.keyRelease(KeyEvent.VK_CONTROL);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnEditar.add(mntmColarCtrl);
		
		JMenu mnExibir = new JMenu("Exibir");
		menuBar.add(mnExibir);
		
		JMenuItem mntmPadro = new JMenuItem("Padr\u00E3o");
		mnExibir.add(mntmPadro);
		
		JSeparator separator = new JSeparator();
		mnExibir.add(separator);
		
		JMenuItem mntmHexadecimal = new JMenuItem("Hexadecimal");
		mnExibir.add(mntmHexadecimal);
		
		JMenuItem mntmDecimal = new JMenuItem("Decimal");
		mnExibir.add(mntmDecimal);
		
		JMenuItem mntmOctadecimal = new JMenuItem("Octadecimal");
		mnExibir.add(mntmOctadecimal);
		
		JMenuItem mntmBinrio = new JMenuItem("Bin\u00E1rio");
		mnExibir.add(mntmBinrio);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmTpicosDaAjuda = new JMenuItem("T\u00F3picos da Ajuda");
		mntmTpicosDaAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnAjuda.add(mntmTpicosDaAjuda);
	}
	
	public String formataValorRel(double valor) {
		return " " + String.format("%.2f", valor);
	}
	
	public String formataValorNotacao(double valor) {
		return String.format("%.9f", valor);
	}
	
	public static String backspace(String texto) {  
		  int length = texto.length();  
		  return texto.substring(0, length-1);  
	} 
	
	public void dividir(){
		if (valor == 0) {
			valor = Double.parseDouble(txtValor.getText()) * Double.parseDouble(txtValor.getText());
		}
		valor = valor / Double.parseDouble(txtValor.getText());
		txtValor.setText(Double.toString(valor));
		txtValor.selectAll();
	}
	
	public void multiplicar(){
		if (valor == 0) {
			valor = 1;
		}
		valor = valor * Double.parseDouble(txtValor.getText());
		txtValor.setText(Double.toString(valor));
		txtValor.selectAll();
	}
	
	public void somar(){
		valor = valor + Double.parseDouble(txtValor.getText());
		txtValor.setText(Double.toString(valor));
		txtValor.selectAll();
	}
	
	public void subtrair(){
		if (valor == 0) {
			valor = Double.parseDouble(txtValor.getText()) * 2;
		}
		valor = valor - Double.parseDouble(txtValor.getText());
		txtValor.setText(Double.toString(valor));
		txtValor.selectAll();
	}
}