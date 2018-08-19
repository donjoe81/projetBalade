package interfaceGraphique;

import javax.swing.JFrame;

import Beans.Balade;
import Beans.Responsable;
import Models.BaladeModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.TextArea;
import java.awt.Button;

public class ajoutBalade extends JFrame {
	public ajoutBalade(Responsable responsable) {
		getContentPane().setBackground(Color.WHITE);
		/*********************************************************************/
		this.setSize(400,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAjoutBalade = new JLabel("ajout balade");
		lblAjoutBalade.setBackground(Color.GREEN);
		lblAjoutBalade.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblAjoutBalade.setBounds(159, 11, 139, 28);
		getContentPane().add(lblAjoutBalade);
		
		JLabel lblDate = new JLabel("date(*)");
		lblDate.setBounds(54, 106, 70, 14);
		getContentPane().add(lblDate);
		
		JLabel lblForfait = new JLabel("forfait(*)");
		lblForfait.setBounds(54, 131, 70, 14);
		getContentPane().add(lblForfait);
		
		JLabel lblLieuDeDepart = new JLabel("lieu de depart");
		lblLieuDeDepart.setBounds(54, 81, 84, 14);
		getContentPane().add(lblLieuDeDepart);
		
		JLabel lblDescriptif = new JLabel("descriptif");
		lblDescriptif.setBounds(54, 156, 70, 14);
		getContentPane().add(lblDescriptif);
		
		textForf = new JTextField();
		textForf.setText("");
		textForf.setBounds(159, 128, 154, 20);
		getContentPane().add(textForf);
		textForf.setColumns(10);
		
		JLabel lblLieuDepart = new JLabel(Balade.adresseClub);
		lblLieuDepart.setBounds(159, 81, 154, 14);
		getContentPane().add(lblLieuDepart);
		
		JButton btnAnnuler = new JButton("annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new tableauBordResponsable(responsable);
			}
		});
		btnAnnuler.setBounds(54, 307, 89, 23);
		getContentPane().add(btnAnnuler);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(159, 100, 154, 20);
		dateChooser.setDateFormatString("dd-mm-yyyy");
		dateChooser.setMinSelectableDate(new Date());
		getContentPane().add(dateChooser);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(159, 159, 225, 113);
		getContentPane().add(textArea);
		
		JLabel lblErreur = new JLabel("");
		lblErreur.setForeground(Color.RED);
		lblErreur.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblErreur.setBounds(55, 50, 278, 14);
		getContentPane().add(lblErreur);
		
		Button button = new Button("enregistrer");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				BaladeModel bal_mod = new BaladeModel();
				int res=-1;
				try {
					res = bal_mod.create(Balade.adresseClub, 
							dateChooser.getDate().getDay()+"/"+dateChooser.getDate().getMonth()+"/"+dateChooser.getDate().getYear(), 
							Double.parseDouble(textForf.getText()), textArea.getText(), responsable);
				}catch(Exception ex) {
					lblErreur.setText("tous les champs (*); sont obligatoires");
				}
				if(res==0) {
					JOptionPane.showMessageDialog(null, "balade crée avec succée");
					dispose();
					new tableauBordResponsable(responsable);
				}
			}
		});
		button.setBounds(263, 308, 70, 22);
		getContentPane().add(button);
		
	
		
	
		/************************************************************************/
		
	}


	private static final long serialVersionUID = 1L;
	private JTextField textForf;
}
