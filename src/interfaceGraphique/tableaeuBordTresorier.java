package interfaceGraphique;

import javax.swing.JFrame;

import Beans.Balade;
import Beans.Membre;
import Beans.Tresorier;
import Beans.Vehicule;
import Models.BaladeModel;
import Models.MembreModel;
import Models.VehiculeModel;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class tableaeuBordTresorier extends JFrame {
	private List<Vehicule> listVehicule = null;
	public tableaeuBordTresorier(Tresorier tre) {
		
		/********************************************************************/
		this.setSize(600,750);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		/*******************************************************************/
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 23, 438, 38);
		getContentPane().add(panel);
		/****************************************************************/
		
		JLabel lblTitre = new JLabel("WELCOME " +tre.getNom()+ " "+ tre.getPrenom());
		panel.add(lblTitre);
		
		/*obtention de la liste des nouveaux membre*/
		MembreModel mem_mod = new MembreModel();
		List<Membre> listNewMem = mem_mod.getListNewMem();
		int N =listNewMem.size();
		String[] list = new String[N];
		for (int i=0; i<N;i++) {
			list[i] =listNewMem.get(i).getId() +" " +listNewMem.get(i).getNom()+ " " +listNewMem.get(i).getPrenom(); 
		}
		
		JButton btnSeDeconnecter = new JButton("se deconnecter");
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new login();
			}
		});
		btnSeDeconnecter.setBounds(330, 72, 118, 23);
		getContentPane().add(btnSeDeconnecter);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(20, 67, 156, 115);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 209, 464, 227);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblListesBalades = new JLabel("listes balades");
		lblListesBalades.setBounds(141, 11, 101, 14);
		panel_2.add(lblListesBalades);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(30, 444, 454, 246);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblListeDesVoitures = new JLabel("liste des voitures");
		lblListeDesVoitures.setBounds(32, 11, 100, 14);
		panel_3.add(lblListeDesVoitures);
		Panel panel_4 = new Panel();
		panel_4.setBounds(197, 41, 247, 195);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNom = new JLabel("nom : ");
		lblNom.setBounds(10, 11, 46, 14);
		panel_4.add(lblNom);
		
		JLabel lblPrenom = new JLabel("prenom : ");
		lblPrenom.setBounds(10, 36, 46, 14);
		panel_4.add(lblPrenom);
		
		JLabel lblTel = new JLabel("tel : ");
		lblTel.setBounds(10, 61, 46, 14);
		panel_4.add(lblTel);
		
		JLabel lblAdresse = new JLabel("adresse : ");
		lblAdresse.setBounds(10, 86, 75, 14);
		panel_4.add(lblAdresse);
		
		JButton btnPayer = new JButton("payer");
		btnPayer.setBounds(78, 161, 89, 23);
		panel_4.add(btnPayer);
		
		JLabel lblPayer = new JLabel("");
		lblPayer.setBounds(56, 136, 144, 14);
		panel_4.add(lblPayer);
		
		JLabel txtNom = new JLabel("");
		txtNom.setBounds(122, 11, 100, 14);
		panel_4.add(txtNom);
		
		JLabel txtprenom = new JLabel("");
		txtprenom.setBounds(122, 36, 100, 14);
		panel_4.add(txtprenom);
		
		JLabel txtTel = new JLabel("");
		txtTel.setBounds(122, 61, 100, 14);
		panel_4.add(txtTel);
		
		JLabel txtAdresse = new JLabel("");
		txtAdresse.setBounds(122, 86, 100, 14);
		panel_4.add(txtAdresse);
		
		JLabel lblPropritaire = new JLabel("propritaire");
		lblPropritaire.setBounds(298, 11, 92, 14);
		panel_3.add(lblPropritaire);
		
		/*****************************************************************************************************************/
		// liste de toutes les balade 
		BaladeModel balMod = new BaladeModel();
		List<Balade> listBalade =  balMod.findAll();
		
		java.awt.List list_1 = new java.awt.List();
		list_1.setBounds(10, 31, 177, 195);
		list_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie){
				MembreModel memMod = new MembreModel();
	        	Membre mem = memMod.findProprioVeh(listVehicule.get(list_1.getSelectedIndex()));
	        	txtNom.setText(mem.getNom());
	        	txtprenom.setText(mem.getPrenom());
	        	txtTel.setText(mem.getTel());
	        	txtAdresse.setText(mem.getAdresse());
	        	if(listVehicule.get(list_1.getSelectedIndex()).getPayer().equals("oui")) {
	        		lblPayer.setText("paiement déja effectué");
	        		btnPayer.setVisible(false);
	        	}
	        	else {
	        		lblPayer.setText("");
	        		btnPayer.setVisible(true);
	        	}
	    	}
		});
	        
		panel_3.add(list_1);
		
		java.awt.List listBal = new java.awt.List();
		listBal.addItemListener(new ItemListener(){
	        @SuppressWarnings("deprecation")
			public void itemStateChanged(ItemEvent ie){
	        	list_1.clear();
				VehiculeModel vehMod = new VehiculeModel();
				listVehicule = vehMod.findVehiculeBalade(listBalade.get(listBal.getSelectedIndex()));
				for(Vehicule veh : listVehicule)
					list_1.add(veh.toString());

				
					
			}
		});
		
		btnPayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VehiculeModel vehMod = new VehiculeModel();
				if(vehMod.update(listVehicule.get(list_1.getSelectedIndex()))) {
					JOptionPane.showMessageDialog(null, "paiement effectué");
					dispose();
					new tableaeuBordTresorier(tre);
				}
				
			}
		});
		
		listBal.setBounds(10, 59, 356, 158);
		panel_2.add(listBal);
		/* initialisation de la liste des balades*/
		if(listBalade.size()>0) {
			for(Balade b : listBalade)
				listBal.add(b.toString());
		}
		/*******************************************************************************************/
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList jlist = new JList(list);
		jlist.setBounds(26, 38, 104, 56);
		panel_1.add(jlist);
		jlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Membre mem = listNewMem.get(jlist.getSelectedIndex());
				int res = JOptionPane.showConfirmDialog(null, " conrfimer l'inscription de "+ mem.getNom()+" "+ mem.getPrenom());
				if(res==0) 
					if(mem_mod.update(mem)) {
						JOptionPane.showMessageDialog(null, "inscription confirmée");	
						dispose();
						new tableaeuBordTresorier(tre);
					}
			}
		});
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblNewLabel = new JLabel("nouveau membre");
		lblNewLabel.setBounds(33, 11, 97, 14);
		panel_1.add(lblNewLabel);
		
	
				
	}

	private static final long serialVersionUID = 1L;
}
