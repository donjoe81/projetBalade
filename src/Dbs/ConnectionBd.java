package Dbs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.swing.JOptionPane;
public class ConnectionBd {
	
    private static Connection snglConnection = null;

    private ConnectionBd() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            String url = "jdbc:ucanaccess://./BD/javaProjetDb.accdb";

            snglConnection = DriverManager.getConnection(url);
        } 
        catch (ClassNotFoundException e) {
        	System.out.println("11111111111111111");
           // JOptionPane.showMessageDialog(null, "Impossible de trouver le driver pour la base de donnée!");
        } 
        catch (SQLException e) {
        	System.out.println("2222222222");
           // JOptionPane.showMessageDialog(null, "Impossible de se connecter à  la base de donnée.");
        }

        if (snglConnection == null) {
        	System.out.println("333333333333");
           // JOptionPane.showMessageDialog(null, "La base de donnée est innaccessible, fermeture du programme.");
           // System.exit(0);
        }
    }

    public static Connection getInstance() {
        if (snglConnection == null) {
            new ConnectionBd();
        }
        return snglConnection;
    }


}
