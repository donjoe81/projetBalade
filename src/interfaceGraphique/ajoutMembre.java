package interfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.MembreModel;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class ajoutMembre extends JFrame {
	public ajoutMembre() {
		/*******************************************/
		this.setSize(400,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 374, 32);
		getContentPane().add(panel);
		
		JLabel lblAjoutDunMembre = new JLabel("AJOUT D'UN MEMBRE");
		panel.add(lblAjoutDunMembre);
		
		JLabel lblNom = new JLabel("NOM (*) : ");
		lblNom.setBounds(46, 85, 81, 14);
		getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("PRENOM : ");
		lblPrenom.setBounds(46, 110, 81, 14);
		getContentPane().add(lblPrenom);
		
		JLabel lblTel = new JLabel("TEL (*) : ");
		lblTel.setBounds(46, 135, 81, 14);
		getContentPane().add(lblTel);
		
		JLabel lblAdresse = new JLabel("ADRESSE : ");
		lblAdresse.setBounds(46, 160, 81, 14);
		getContentPane().add(lblAdresse);
		
		JLabel lblRue = new JLabel("RUE :");
		lblRue.setBounds(71, 195, 56, 14);
		getContentPane().add(lblRue);
		
		JLabel lblLocalite = new JLabel("LOCALITE");
		lblLocalite.setBounds(71, 220, 56, 14);
		getContentPane().add(lblLocalite);
		
		JLabel lblCp = new JLabel("CP : ");
		lblCp.setBounds(71, 245, 58, 14);
		getContentPane().add(lblCp);
		
		JLabel lblLogin = new JLabel("LOGIN (*) : ");
		lblLogin.setBounds(46, 270, 81, 14);
		getContentPane().add(lblLogin);
		
		JLabel lblPass = new JLabel("PASS (*) : ");
		lblPass.setBounds(46, 295, 81, 14);
		getContentPane().add(lblPass);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(198, 82, 150, 20);
		getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(198, 107, 150, 20);
		getContentPane().add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(198, 132, 150, 20);
		getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldRue = new JTextField();
		textFieldRue.setBounds(198, 192, 150, 20);
		getContentPane().add(textFieldRue);
		textFieldRue.setColumns(10);
		
		textFieldLocalite = new JTextField();
		textFieldLocalite.setBounds(198, 217, 150, 20);
		getContentPane().add(textFieldLocalite);
		textFieldLocalite.setColumns(10);
		
		textFieldCp = new JTextField();
		textFieldCp.setBounds(198, 242, 110, 20);
		getContentPane().add(textFieldCp);
		textFieldCp.setColumns(10);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(198, 267, 150, 20);
		getContentPane().add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(198, 292, 150, 20);
		getContentPane().add(textFieldPassword);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login();
			}
		});
		btnAnnuler.setBounds(46, 508, 89, 23);
		getContentPane().add(btnAnnuler);
		/*****************************************************************************************************/
		JLabel lblErreur = new JLabel("");
		lblErreur.setBounds(118, 483, 206, 14);
		lblErreur.setForeground(Color.RED);
		getContentPane().add(lblErreur);
		
		JLabel lblCathegorie = new JLabel("CATHEGORIE");
		lblCathegorie.setBounds(46, 320, 81, 14);
		getContentPane().add(lblCathegorie);
		
		JCheckBox chckbxVttDescendeurs = new JCheckBox("VTT descendeur");
		chckbxVttDescendeurs.setBounds(197, 339, 151, 23);
		getContentPane().add(chckbxVttDescendeurs);
		
		JCheckBox chckbxVttRandonneurs = new JCheckBox("VTT randonneur");
		chckbxVttRandonneurs.setBounds(198, 365, 150, 23);
		getContentPane().add(chckbxVttRandonneurs);
		
		JCheckBox chckbxVttTrialiste = new JCheckBox("VTT trialiste");
		chckbxVttTrialiste.setBounds(198, 391, 97, 23);
		getContentPane().add(chckbxVttTrialiste);
		
		JCheckBox chckbxCyclo = new JCheckBox("Cyclo");
		chckbxCyclo.setBounds(198, 417, 97, 23);
		getContentPane().add(chckbxCyclo);
		/******************************************************************************************************/
		JButton btnEnregistrer = new JButton("enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				MembreModel mem = new MembreModel();
				if(textFieldNom.getText().equals("") ||
				   textFieldTel.getText().equals("") ||
				   textFieldLogin.getText().equals("")|| 
				textFieldPassword.getText().equals(""))
					lblErreur.setText("tous les champs (*) sont obligatoires");
				else {
					//test si   le membre a choisi une cathegorie
					List<String> liste = new ArrayList<String>();
					if(chckbxCyclo.isSelected())
						liste.add(chckbxCyclo.getText());
					if(chckbxVttTrialiste.isSelected())
						liste.add(chckbxVttTrialiste.getText());
					if(chckbxVttRandonneurs.isSelected())
						liste.add(chckbxVttRandonneurs.getText());
					if(chckbxVttDescendeurs.isSelected())
						liste.add(chckbxVttDescendeurs.getText());
					if(liste.size()>0) {// si au moins une cathegorie selectionner
						if(mem.create(textFieldNom.getText(), textFieldPrenom.getText(), textFieldTel.getText(), 
								textFieldRue.getText()+", "+textFieldLocalite.getText(), 
								textFieldLogin.getText(), textFieldPassword.getText(), liste)==0)
							JOptionPane.showMessageDialog(null,"memebre crée");
						dispose();
						new login();
					}
					else
						lblErreur.setText("selectionner au moins une cathegorie");
						
				}
			}
		});
		btnEnregistrer.setBounds(259, 508, 89, 23);
		getContentPane().add(btnEnregistrer);
		/******************************************************************************************************/
	}

	private static final long serialVersionUID = -1521940325457947646L;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldTel;
	private JTextField textFieldRue;
	private JTextField textFieldLocalite;
	private JTextField textFieldCp;
	private JTextField textFieldLogin;
	private JPasswordField textFieldPassword;
}
