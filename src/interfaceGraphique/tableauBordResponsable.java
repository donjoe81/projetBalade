package interfaceGraphique;

import javax.swing.JFrame;

import Beans.Responsable;
import Beans.Vehicule;
import Models.BaladeModel;
import Models.MembreModel;
import Models.VehiculeModel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import Beans.Balade;
import Beans.Membre;

import java.awt.Panel;

public class tableauBordResponsable extends JFrame {
		private ArrayList<Balade> listBalade = null;
		private ArrayList<Vehicule> listVehicule=null;
	public tableauBordResponsable(Responsable res) {
		/*****************************************************************/
		this.setSize(600,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		/****************************************************************************/
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 25, 414, 23);
		getContentPane().add(panel);
		
		
		JLabel lblTitre = new JLabel("WELCOME "+res.getNom()+ " "+res.getPrenom());
		panel.add(lblTitre);
		/*******************************************************************************************/
		JButton btnDeconnecter = new JButton("deconnecter");
		btnDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new login();
			}
		});
		btnDeconnecter.setBounds(446, 25, 116, 23);
		getContentPane().add(btnDeconnecter);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 59, 203, 25);
		getContentPane().add(splitPane);
		
		Panel panel_1 = new Panel();
		panel_1.setVisible(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(256, 88, 328, 271);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		/******************************************************************************************************/
		
				
		java.awt.List listMembre = new java.awt.List();
		listMembre.setBounds(103, 42, 110, 201);
		panel_1.add(listMembre);
		
		java.awt.List listVoiture = new java.awt.List();
		listVoiture.setBounds(10, 42, 86, 201);
		listVoiture.addItemListener(new ItemListener(){
			@SuppressWarnings("deprecation")
			public void itemStateChanged(ItemEvent ie){
				MembreModel memMod = new MembreModel();
				listMembre.clear();
				List<Membre> listM = memMod.findMemVeh(listVehicule.get(listVoiture.getSelectedIndex()));
				if(listM.size()>0) {
					for(Membre mem : listM)
						listMembre.add(mem.getNom()+" " +mem.getPrenom());
				}
				else
					JOptionPane.showMessageDialog(null, "pas de reservation pour cette voiture");
				
				
			}
		});
		panel_1.add(listVoiture);
		
		java.awt.List listA = new java.awt.List();
		listA.addItemListener(new ItemListener(){
	        @SuppressWarnings("deprecation")
			public void itemStateChanged(ItemEvent ie){
	        	listVoiture.clear();
				VehiculeModel vehMod = new VehiculeModel();
				listVehicule = (ArrayList<Vehicule>) vehMod.findVehiculeBalade(listBalade.get(listA.getSelectedIndex()));
				if(listVehicule.size()>0) {
					panel_1.setVisible(true);
					for(Vehicule v : listVehicule)
						listVoiture.add(v.getNumero());	
				}
				else
					JOptionPane.showMessageDialog(null, "pas de vehicule pour cette balade");
				
					
			}
		});
		listA.setBounds(10, 90, 156, 271);
		getContentPane().add(listA);
		
		
		JButton btnNewButton = new JButton("balades");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaladeModel balMod = new BaladeModel();
				listBalade = (ArrayList<Balade>) balMod.findBaladeResponsable(res);
				if(listBalade.size()>0) {
					for(Balade b : listBalade)
						listA.add(b.getDateDepart());
				}
			}
		});
		
		splitPane.setLeftComponent(btnNewButton);
		
		JButton btnAjouterBalade = new JButton("ajouter une balade");
		splitPane.setRightComponent(btnAjouterBalade);
		
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBounds(10, 11, 203, 25);
		panel_1.add(splitPane_1);
		
		JLabel lblListeDesVoitures = new JLabel("liste des voitures");
		splitPane_1.setLeftComponent(lblListeDesVoitures);
		
		JLabel lblListeDesReservations = new JLabel("liste des reservations");
		splitPane_1.setRightComponent(lblListeDesReservations);
		/********************************************************************************/

		btnAjouterBalade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ajoutBalade(res);
			}
		});
	}


	private static final long serialVersionUID = 1L;
}
