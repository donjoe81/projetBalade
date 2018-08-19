package interfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Beans.Balade;
import Beans.Membre;
import Models.VehiculeModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ajouterVoiture extends JFrame{
	public ajouterVoiture(Balade balade, Membre membre) {
		this.setSize(400,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		/*******************************************************************************/
		JLabel lblAjoutDuneVoiture = new JLabel("ajout d'une voiture ");
		lblAjoutDuneVoiture.setBounds(165, 11, 128, 14);
		getContentPane().add(lblAjoutDuneVoiture);
		
		JLabel lblNumero = new JLabel("numero : ");
		lblNumero.setBounds(87, 66, 98, 14);
		getContentPane().add(lblNumero);
		
		JLabel lblNombreDePlaces = new JLabel("nombre de place(s) : ");
		lblNombreDePlaces.setBounds(87, 91, 111, 14);
		getContentPane().add(lblNombreDePlaces);
		
		JLabel lblNombreDeVelos = new JLabel("nombre de velo(s) : ");
		lblNombreDeVelos.setBounds(87, 116, 111, 14);
		getContentPane().add(lblNombreDeVelos);
		
		textNumero = new JTextField();
		textNumero.setBounds(243, 63, 86, 20);
		getContentPane().add(textNumero);
		textNumero.setColumns(10);
		
		textNombrePlace = new JTextField();
		textNombrePlace.setBounds(243, 88, 86, 20);
		getContentPane().add(textNombrePlace);
		textNombrePlace.setColumns(10);
		
		textNombreVelo = new JTextField();
		textNombreVelo.setBounds(243, 116, 86, 20);
		getContentPane().add(textNombreVelo);
		textNombreVelo.setColumns(10);
		
		JLabel lblErreur = new JLabel("");
		lblErreur.setBounds(190, 150, 46, 14);
		getContentPane().add(lblErreur);
		/******************************************************************************************************************************/
		// bouton enregistrer
		JButton btnEnregistrer = new JButton("enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehiculeModel v_mod = new VehiculeModel();
				try {
					if(v_mod.create(textNumero.getText(), Integer.parseInt(textNombrePlace.getText()),Integer.parseInt(textNombreVelo.getText()), balade, membre)==0) {
						JOptionPane.showMessageDialog(null, "voitue enregistrer avec succés");
						dispose();
						new tableauBordMembre(membre);
					}
				}catch(Exception ex) {
					lblErreur.setText("verifier le nombre de place ou des velos");
				}
			}
		});
		btnEnregistrer.setBounds(243, 186, 89, 23);
		getContentPane().add(btnEnregistrer);
		
		/******************************************************************************************/
		// bouton annuler
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new tableauBordMembre(membre);
			}
		});
		btnAnnuler.setBounds(72, 186, 89, 23);
		getContentPane().add(btnAnnuler);
		
		/************************************************************************************/

	}
	private static final long serialVersionUID = 1L;
	private JTextField textNumero;
	private JTextField textNombrePlace;
	private JTextField textNombreVelo;
}
