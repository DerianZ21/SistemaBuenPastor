package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class conexion {
    Connection conectar = null;

    public conexion() {
    }
    
    String usuario = "postgres";
    String contraseña = "d123456";
    String dataBase = "bdescuela";
    String ip = "localhost";
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+dataBase;
    
    public Connection iniciarConexion(){
        try {
            Class.forName("org.postgresql.Driver");
            
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
        return conectar;
    }

    public Connection getConectar() {
        return conectar;
    }

    public void setConectar(Connection conectar) {
        this.conectar = conectar;
    }

   
}
 