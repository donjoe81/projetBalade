package interfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Beans.Membre;
import Beans.Responsable;
import Beans.Tresorier;
import Models.MembreModel;
import Models.ResponsableModel;
import Models.TresorierModel;

import javax.swing.JPasswordField;
import java.awt.Font;

public class login extends JFrame{
	public login() {
		/*******************************************************/	
		this.setSize(400,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		/********************************************************/
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 56, 374, 38);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnResponsable = new JRadioButton("Responsable");
		rdbtnResponsable.setBounds(6, 5, 111, 23);
		panel.add(rdbtnResponsable);
		
		JRadioButton rdbtnMembre = new JRadioButton("Membre");
		rdbtnMembre.setBounds(141, 5, 89, 23);
		panel.add(rdbtnMembre);
		
		JRadioButton rdbtnTresorier = new JRadioButton("Tresorier");
		rdbtnTresorier.setBounds(257, 5, 111, 23);
		panel.add(rdbtnTresorier);
		/************************************************************************************************/
		rdbtnResponsable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnResponsable.isSelected()){
					rdbtnMembre.setSelected(false);
					rdbtnTresorier.setSelected(false);
					
				}
			}
		});
		
		rdbtnMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMembre.isSelected()){
					rdbtnResponsable.setSelected(false);
					rdbtnTresorier.setSelected(false);
					
				}
			}
		});
		rdbtnTresorier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTresorier.isSelected()){
					rdbtnResponsable.setSelected(false);
					rdbtnMembre.setSelected(false);
					
				}
			}
		});
	/*********************************************************************************************************************/
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 105, 374, 162);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login : ");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLogin.setBounds(10, 40, 82, 14);
		panel_1.add(lblLogin);
		
		JLabel lblPassword = new JLabel("password : ");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(10, 77, 82, 14);
		panel_1.add(lblPassword);
		
		textLogin = new JTextField();
		textLogin.setForeground(Color.BLACK);
		textLogin.setBounds(134, 37, 135, 20);
		panel_1.add(textLogin);
		textLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(134, 74, 135, 20);
		panel_1.add(passwordField);
		
		JLabel lblOu = new JLabel("ou");
		lblOu.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOu.setBounds(134, 133, 65, 14);
		panel_1.add(lblOu);
		
		JLabel lblErreur = new JLabel("");
		lblErreur.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblErreur.setForeground(Color.RED);
		lblErreur.setBounds(80, 105, 244, 14);
		panel_1.add(lblErreur);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(rdbtnResponsable.isSelected()) {
					if(textLogin.getText().equals("") || passwordField.getText().equals(""))
						lblErreur.setText(" login ou password vide");
					else {
						ResponsableModel res_m = new ResponsableModel();
						Responsable res = res_m.findLogin(textLogin.getText(), passwordField.getText());
						if(res!=null) {
							dispose();
							new tableauBordResponsable(res);
						}
						else 
							lblErreur.setText(" login ou password incorrect");
					}
				}
				else
					if(rdbtnMembre.isSelected()) {
						if(textLogin.getText().equals("") || passwordField.getText().equals(""))
							lblErreur.setText(" login ou password vide");
						else {
							MembreModel m = new MembreModel();
							Membre mem = m.findLogin(textLogin.getText(), passwordField.getText());
							if(mem!=null) {
								if(mem.getPayer().equals("true")) {
									dispose();
									new tableauBordMembre(mem);
								}else
									JOptionPane.showMessageDialog(null, "votre inscription est en attente de validation...");
							}
							else
								lblErreur.setText(" login ou password incorrect");
						}
					}
					else
						if(rdbtnTresorier.isSelected()) {
							if(textLogin.getText().equals("") || passwordField.getText().equals(""))
								lblErreur.setText(" login ou password vide");
							else {
								TresorierModel tre_m= new TresorierModel();
								Tresorier tre =tre_m.findLogin(textLogin.getText(), passwordField.getText());
								if(tre!=null) {
									dispose();
									new tableaeuBordTresorier(tre);
								}
								else
									lblErreur.setText(" login ou password incorrect");
							}
						}
						else
							JOptionPane.showMessageDialog(null, "cocher l'une des case : Responsable, membre ou tresorier");
			}
		});
		btnLogin.setBounds(10, 128, 89, 23);
		panel_1.add(btnLogin);
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JButton btnNouveauMembre = new JButton("nouveau membre");
		btnNouveauMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ajoutMembre();
			}
		});
		btnNouveauMembre.setBounds(225, 128, 139, 23);
		panel_1.add(btnNouveauMembre);
		btnNouveauMembre.setFont(new Font("Arial", Font.PLAIN, 12));
		
	
		
		
	}

	private static final long serialVersionUID = 1L;
	private JTextField textLogin;
	private JPasswordField passwordField;
}
