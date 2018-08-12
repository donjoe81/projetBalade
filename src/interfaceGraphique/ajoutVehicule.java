package interfaceGraphique;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

public class ajoutVehicule extends JFrame {
	public ajoutVehicule() {
		getContentPane().setBackground(Color.WHITE);
		/********************************************************************************/
		this.setSize(400,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAjoutDuneVoiture = new JLabel("ajout d'une voiture");
		lblAjoutDuneVoiture.setBounds(135, 11, 130, 14);
		getContentPane().add(lblAjoutDuneVoiture);
		/*******************************************************************************/
	}

	private static final long serialVersionUID = 1L;

}
