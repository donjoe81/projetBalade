package interfaceGraphique;

import javax.swing.JFrame;

import Beans.Balade;
import Beans.Membre;
import Beans.Vehicule;
import Models.BaladeModel;
import Models.VehiculeModel;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import  javax.swing.JTextArea;

public class tableauBordMembre extends JFrame {
	public tableauBordMembre(Membre membre) {
		getContentPane().setBackground(Color.WHITE);
		/*****************************************************************************/
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		/*************************************************************************/
		
		java.awt.List list = new java.awt.List();
		list.setBounds(10, 123, 95, 165);
		getContentPane().add(list);
		
		JLabel lblTitre = new JLabel("Welcome "+membre.getNom());
		lblTitre.setForeground(Color.GREEN);
		lblTitre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblTitre.setBounds(155, 11, 133, 14);
		getContentPane().add(lblTitre);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(155, 81, 308, 238);
		panel1.setVisible(false);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblDetailBalade = new JLabel("detail balade");
		lblDetailBalade.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblDetailBalade.setBounds(75, 11, 141, 14);
		panel1.add(lblDetailBalade);
		
		JLabel lbl = new JLabel("date : ");
		lbl.setBounds(10, 35, 46, 14);
		panel1.add(lbl);
		
		JLabel lblDate = new JLabel("New label");
		lblDate.setBounds(106, 36, 46, 14);
		panel1.add(lblDate);
		
		JLabel lblForfaitF = new JLabel("forfait : ");
		lblForfaitF.setBounds(10, 60, 46, 14);
		panel1.add(lblForfaitF);
		
		JLabel lblForfait = new JLabel("New label");
		lblForfait.setBounds(106, 60, 46, 14);
		panel1.add(lblForfait);
		
		JLabel lblDescription_1 = new JLabel("description : ");
		lblDescription_1.setBounds(10, 98, 81, 14);
		panel1.add(lblDescription_1);
		
		JTextArea lblDescription = new JTextArea();
		lblDescription.setBounds(106, 98, 192, 84);
		lblDescription.setEditable(false);
		panel1.add(lblDescription);
		
		JLabel lblBaladesPrevues = new JLabel("balade(s) prevue(s)");
		lblBaladesPrevues.setBounds(10, 103, 117, 14);
		getContentPane().add(lblBaladesPrevues);
		
		/*******************************************************************************************/
		JButton btnSeDeconnecter = new JButton("se deconnecter");
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new login();
			}
		});
		btnSeDeconnecter.setBounds(360, 11, 124, 23);
		getContentPane().add(btnSeDeconnecter);
		/********************************************************************************/
		
		/* liste des balades correspondant aux cath du membre*/
		BaladeModel bal_mod = new BaladeModel(); 
		List<Balade> listBalade = bal_mod.findBaladeMembre(membre);
		for(Balade b : listBalade) 
			list.add(b.getDateDepart());
		   list.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent ie){
		        	panel1.setVisible(true);
		        	lblDate.setText(listBalade.get(list.getSelectedIndex()).getDateDepart());
		        	lblForfait.setText(listBalade.get(list.getSelectedIndex()).getForfait()+"");
		        	lblDescription.setText(listBalade.get(list.getSelectedIndex()).getDescriptif());
		        }
		    });
		   /*********************************************************************************/
			JButton btnProposerUneVoiture = new JButton("proposer une voiture");
			btnProposerUneVoiture.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new ajouterVoiture(listBalade.get(list.getSelectedIndex()), membre);
				}
			});
			btnProposerUneVoiture.setBounds(10, 204, 176, 23);
			panel1.add(btnProposerUneVoiture);
			
			/*****************************************************************************/
			JButton btnReserver = new JButton("reserver");
			btnReserver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VehiculeModel veh_mod = new VehiculeModel();
					if(!veh_mod.testReservationBalade(listBalade.get(list.getSelectedIndex()), membre)) {
						Vehicule veh = veh_mod.vehiculeBalade(listBalade.get(list.getSelectedIndex()));
						if(veh==null)
							JOptionPane.showMessageDialog(null, "pas de vehicule");							
						else {
							int res = veh_mod.InsertReservation(veh, membre);
							if(res==0)
								JOptionPane.showMessageDialog(null, "reservation confirmeé");
							else
								if(res==2)
									JOptionPane.showMessageDialog(null, "vous avez deja une reservation pour cette balade");
						}
					}
					else
						JOptionPane.showMessageDialog(null, "vous avez deja une reservation pour cette balade");
						
				}
			});
			btnReserver.setBounds(209, 204, 89, 23);
			panel1.add(btnReserver);
		
	
			
	}
	private static final long serialVersionUID = 1L;
}
