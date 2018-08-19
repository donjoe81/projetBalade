package interfaceGraphique;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JFrame;

import Beans.Vehicule;
import Models.VehiculeModel;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class testVehicule extends JFrame {
	public testVehicule(List<Vehicule> list) {
		/*****************************************************************************/
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		java.awt.List list_1 = new java.awt.List();
		for(Vehicule v : list)
			list_1.add(v.getNumero());
		
		list_1.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent ie){
		        	VehiculeModel v = new VehiculeModel();
		        	//JOptionPane.showMessageDialog(null, v.nombreReservationParVehicule(list.get(list_1.getSelectedIndex()))+" ");
		        }
		    });
			
		list_1.setBounds(143, 63, 110, 199);
		getContentPane().add(list_1);
		/*************************************************************************/
	}

	private static final long serialVersionUID = 1L;
}
