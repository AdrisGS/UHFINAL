
package uhv1.Persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import uhv1.Negocio.Casa;
import uhv1.Negocio.Evento;
import uhv1.Negocio.Responsable;
import uhv1.Persistencia.ManejadorBD;

/**
 *
 * @author darky
 */
public class DAOEvento {
    public DAOEvento(){
    
    }
   public Evento buscaEvento(String nombre) {
        
        String nomE;
        Date fechaR;
        String descripcion;
        int hab;
        int ca;
        float saldo;
        int id;
        
        try {
            Statement statement = ManejadorBD.dameConnection().createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM Evento WHERE nombre_evento ='"+nombre+"';");
            /*se pone el apuntador una fila depues para guardar los datos recibidos*/
            rs.next();
            /* Se guardan los datos del evento recibidos en las variables correspondientes*/
            
            id = rs.getInt("idEvento");
            nomE = rs.getString("nombre_evento");
            fechaR = rs.getDate("fecha_Reservacion");
            descripcion = rs.getString("descripcion");
            saldo = rs.getFloat("saldo");
            hab = rs.getInt("Habitantes_idHabitante");
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("Hubo un error 1");
            e.printStackTrace();
            return null;
        }
        try {

            Statement statement = ManejadorBD.dameConnection().createStatement();
            System.out.println("Aki tamo");
            /* Se busca el habitante  del evento solicitado */
            ResultSet rs3 = statement.executeQuery("SELECT * FROM Habitantes WHERE idHabitante = '" + hab + "';");
            rs3.next();
            ca  = rs3.getInt("Casas_idCasa");
            System.out.println("Aki tamo2");
            Casa aux = null; 
            Responsable habitante = new Responsable(rs3.getInt("idHabitante"), rs3.getString("nombre"), rs3.getString("aPat"), rs3.getString("aMat"), rs3.getFloat("telefono"), aux, rs3.getFloat("saldo"));
            /* Se busca la casa del habitante solicitado */
            ResultSet rs2 = statement.executeQuery("SELECT * FROM Casas WHERE idCasa = '" + ca+ "';");
            rs2.next();
            System.out.println("Aki tamo3");
            /* Se crean los objetos casa y responsable con los datos del habitante solicitado y se asignan al evento*/
            Casa casa = new Casa(rs2.getInt("idCasa"), rs2.getString("seccion"), rs2.getInt("numero"));
            System.out.println("Aki tamo4");
            habitante.setCasa(casa);
            
            System.out.println("Aki tamo5");
            Evento evento = new Evento(id, nomE, fechaR, descripcion, saldo, habitante);
            System.out.println("Aki tamo6");
           
            rs3.close();
            rs2.close();

            return evento;
            
        } catch (SQLException e) {
            System.out.println("Hubo un error 2");
            e.printStackTrace();
            return null;
        }

    }
    
    //Metodo que recibe un evento y lo elimina en la base de datos (Caso de uso CancelarEvento)
    public boolean eliminaEvent(Evento even){
        System.out.println("DAO ELIMINA");
        int resultado = 0;
        try {
            // Statement = declaracion
            Statement statement;
            statement = ManejadorBD.dameConnection().createStatement();   
            resultado = statement.executeUpdate("DELETE FROM Evento WHERE idEvento=" + even.getId() + ";" ); //busca en bd al evento por su id y lo elimina 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(resultado==0){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean registra_evento(Evento eve){
        int llave;
        try {
            // Crea el statement
            Statement statement = uhv1.Persistencia.ManejadorBD.dameConnection().createStatement();
            // Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada            
            statement.execute("INSERT into Evento (Habitantes_idHabitante, nombre_evento, descripcion, fecha_reservacion, saldo, estado) values (" + eve.getHabitante().getId() + ", '" + eve.getNombre()+ "', '" + eve.getDescripcion() + "' , '" + eve.getFechaReservacion()+ "', " + eve.getSaldo() + ", " + eve.getEstado() +  ");", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave

            if (rs != null && rs.next()) {
                llave = rs.getInt(1);
                System.out.println("Id: " + llave);
                eve.setId(llave);
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
     //Metodo que busca el registro de la tabla Evento en base de datos por medio de IdEvento y actualiza el saldo
    public boolean actualizaAbonoEvento(Evento eve){
        
        try {
            Statement statement = ManejadorBD.dameConnection().createStatement();
            statement.execute("UPDATE Evento SET saldo=" + eve.getSaldo() + "WHERE idEvento =" + eve.getId() + ";");
            return true;
            
        } catch (SQLException e) {
            System.out.println("No fue posible el ingreso de saldo");
            e.printStackTrace();
            return false;
        }
    }
}
