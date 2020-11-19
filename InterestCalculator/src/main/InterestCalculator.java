package main;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import accounts.*;
import java.awt.Font;
import java.awt.Insets;

class invalidNum 
{
	public void check(double val) throws Exception
	{
		if(val<0)
			throw new Exception("Enter a non-negative value");
	}
	public void check(double val,double am) throws Exception
	{
		if(val<0 || am<0)
			throw new Exception("Enter a non-negative value");
	}
}
public class InterestCalculator extends JFrame implements ActionListener{

	private JPanel contentPane;
	JRadioButton rdbtnNewRadioButton,rdbtnFdAccount,rdbtnRdAccount;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterestCalculator frame = new InterestCalculator();
					frame.setVisible(true);
					frame.setTitle("Interest Calculator");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterestCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("SB Account");
		rdbtnNewRadioButton.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBounds(52, 87, 116, 37);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("Select your account type:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(41, 33, 204, 37);
		contentPane.add(lblNewLabel);
		
		rdbtnFdAccount = new JRadioButton("FD Account");
		rdbtnFdAccount.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		rdbtnFdAccount.setBounds(52, 146, 116, 37);
		contentPane.add(rdbtnFdAccount);
		
		rdbtnRdAccount = new JRadioButton("RD Account");
		rdbtnRdAccount.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		rdbtnRdAccount.setBounds(52, 208, 122, 37);
		contentPane.add(rdbtnRdAccount);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton); bg.add(rdbtnFdAccount);bg.add(rdbtnRdAccount);
		
		rdbtnNewRadioButton.addActionListener(this);
		rdbtnFdAccount.addActionListener(this);
		rdbtnRdAccount.addActionListener(this);
	
	}
	public void actionPerformed(ActionEvent e)
	{
		
		if(rdbtnNewRadioButton.isSelected())
		{
			SBAccount a;
			JFrame f=new JFrame();
			f.setBounds(100, 100, 431, 433);
			f.getContentPane().setLayout(null);
			f.setVisible(true);
			JLabel lblNewLabel_1 = new JLabel("Enter amount in your account");
			lblNewLabel_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(30, 26, 280, 29);
			f.getContentPane().add(lblNewLabel_1);
			
			JTextField txt=new JTextField();
			txt.setBounds(30,60,150,24);
			f.getContentPane().add(txt);
			
			JLabel lblNewLabel = new JLabel("Account type:");
			lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel.setBounds(30, 90, 132, 29);
			f.getContentPane().add(lblNewLabel);
			
			String options[]= {"Select","Normal","NRI"};
			JComboBox comboBox = new JComboBox(options);
			comboBox.setBounds(30, 130, 78, 25);
			f.getContentPane().add(comboBox);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(40, 180, 300, 125);
			f.getContentPane().add(textArea);
			textArea.setMargin(new Insets(20,20,20,20));
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			textArea.setVisible(false);
			
			JButton btnNewButton = new JButton("Submit");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txt.getText().length()!=0)
					{
						double val=0;
						try
						{
							val=Double.parseDouble(txt.getText());
							invalidNum m=new invalidNum();
							m.check(val);

							if(comboBox.getSelectedIndex()==1)
							{
								SBAccount a=new SBAccount(4,val);
								double res=a.calculateInterest();
								textArea.setVisible(true);
								textArea.setText("Interest Rate for normal account of Rs. "+txt.getText()+" is Rs. "+res);
							}
							else if(comboBox.getSelectedIndex()==2)
							{
								SBAccount a=new SBAccount(6,val);
								double res=a.calculateInterest();
								textArea.setVisible(true);
								textArea.setText("Interest Rate for NRI account of Rs. "+txt.getText()+" is Rs. "+res);
							}	
							else
								JOptionPane.showMessageDialog(f,"Please select an option","Alert",JOptionPane.WARNING_MESSAGE);
						}
						catch(Exception e1)
						{System.out.println(e1);}
					}
					else
						JOptionPane.showMessageDialog(f,"Enter the amount","Alert",JOptionPane.WARNING_MESSAGE);
				}
					
			});
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			btnNewButton.setBounds(185, 130, 107, 29);
			f.getContentPane().add(btnNewButton);
		}
		if(rdbtnRdAccount.isSelected())
		{
			JFrame f=new JFrame();
			f.setBounds(100, 100, 431, 433);
			f.getContentPane().setLayout(null);
			f.setVisible(true);
			f.setVisible(true);
			JLabel lblNewLabel_2 = new JLabel("Amount in account:");
			lblNewLabel_2.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(28, 27, 182, 31);
			f.getContentPane().add(lblNewLabel_2);
			
			textField = new JTextField();
			textField.setBounds(220, 33, 161, 25);
			f.getContentPane().add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_2_1 = new JLabel("Amount to add:");
			lblNewLabel_2_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel_2_1.setBounds(28, 82, 161, 31);
			f.getContentPane().add(lblNewLabel_2_1);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(220, 88, 161, 25);
			f.getContentPane().add(textField_1);
			
			JLabel lblNewLabel_2_1_1 = new JLabel("Months:");
			lblNewLabel_2_1_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel_2_1_1.setBounds(28, 133, 92, 31);
			f.getContentPane().add(lblNewLabel_2_1_1);
			
			JLabel lblNewLabel_2_1_1_1 = new JLabel("Age:");
			lblNewLabel_2_1_1_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel_2_1_1_1.setBounds(28, 185, 92, 31);
			f.getContentPane().add(lblNewLabel_2_1_1_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(130, 139, 137, 25);
			f.getContentPane().add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(130, 191, 137, 25);
			f.getContentPane().add(textField_3);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(28, 279, 353, 104);
			f.getContentPane().add(textArea);
			textArea.setMargin(new Insets(20,20,20,20));
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			textArea.setVisible(false);
			
			JButton btnNewButton_1 = new JButton("Submit");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField.getText().length()!=0 && textField_1.getText().length()!=0 && textField_2.getText().length()!=0 && textField_3.getText().length()!=0)
					{
						double a=0,ma=0;
						try
						{
							a=Double.parseDouble(textField.getText());
							ma=Double.parseDouble(textField_1.getText());
							invalidNum m=new invalidNum();
							m.check(a,ma);
							RDAccount rd=new RDAccount(a,ma,Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()));
							double res=rd.calculateInterest();
							if(res!=-1)
							{
								textArea.setVisible(true);
								textArea.setText("Interest Rate for account of Rs. "+textField.getText()+" is Rs. "+res);
							}
							else
								JOptionPane.showMessageDialog(f,"Enter month correctly ","Alert",JOptionPane.WARNING_MESSAGE);
							
						}
						catch(Exception e1)
						{System.out.println(e1);}
					}
					else
						JOptionPane.showMessageDialog(f,"Enter the field","Alert",JOptionPane.WARNING_MESSAGE);
				}
					
			});
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			btnNewButton_1.setBounds(153, 240, 100, 31);
			f.getContentPane().add(btnNewButton_1);
		
		}
		if(rdbtnFdAccount.isSelected())
		{
			JFrame f=new JFrame();
			f.setBounds(100, 100, 431, 433);
			f.getContentPane().setLayout(null);
			f.setVisible(true);
			f.setVisible(true);
			JLabel lblNewLabel_4 = new JLabel("Amount in account:");
			lblNewLabel_4.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel_4.setBounds(28, 27, 182, 31);
			f.getContentPane().add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(220, 33, 161, 25);
			f.getContentPane().add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_2_1 = new JLabel("Days:");
			lblNewLabel_2_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel_2_1.setBounds(28, 82, 161, 31);
			f.getContentPane().add(lblNewLabel_2_1);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(130, 88, 137, 25);
			f.getContentPane().add(textField_1);
			
			JLabel lblNewLabel_2_1_1 = new JLabel("Age:");
			lblNewLabel_2_1_1.setFont(new Font("Book Antiqua", Font.PLAIN, 20));
			lblNewLabel_2_1_1.setBounds(28, 133, 92, 31);
			f.getContentPane().add(lblNewLabel_2_1_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(130, 139, 137, 25);
			f.getContentPane().add(textField_2);
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(28, 279, 353, 104);
			f.getContentPane().add(textArea);
			textArea.setMargin(new Insets(20,20,20,20));
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			textArea.setEditable(false);
			textArea.setVisible(false);
			
			JButton btnNewButton_1 = new JButton("Submit");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField.getText().length()!=0 && textField_1.getText().length()!=0 && textField_2.getText().length()!=0)
					{
						double a=0,ma=0;
						try
						{
							a=Double.parseDouble(textField.getText());
							invalidNum m=new invalidNum();
							m.check(a);
							FDAccount rd=new FDAccount(a,Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()));
							double res=rd.calculateInterest();
							if(res!=-1)
							{
								textArea.setVisible(true);
								textArea.setText("Interest Rate for account of Rs. "+textField.getText()+" is Rs. "+res);
							}
							else
								JOptionPane.showMessageDialog(f,"Enter number of days correctly ","Alert",JOptionPane.WARNING_MESSAGE);
							
						}
						catch(Exception e1)
						{System.out.println(e1);}
					}
					else
						JOptionPane.showMessageDialog(f,"Enter the field","Alert",JOptionPane.WARNING_MESSAGE);
				}
					
			});
			btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			btnNewButton_1.setBounds(153, 240, 100, 31);
			f.getContentPane().add(btnNewButton_1);
			
		}
	}
}
