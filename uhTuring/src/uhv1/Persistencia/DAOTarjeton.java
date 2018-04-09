/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uhv1.Persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uhv1.Negocio.ControlAltaTarjeton;
import uhv1.Negocio.Casa;
import uhv1.Negocio.Responsable;
import uhv1.Negocio.Tarjeton;

/**
 *
 * @author adriana gs
 */
public class DAOTarjeton {
       
    /*
    En este metodo regresa la lista de los tarjetones que tiene un habitante 
    buscando solamente los que están activos y que coinciden con el id de un habitante,
    
    Este metodo recibe un mensaje de control baja dicho metodo ejecuta un query para eliminar
    al habitante de la base de datos
    */
    public Tarjeton[] buscaTarjeton(int id){
       
        System.out.println("Esta en busca DAOTarjeton ");
        
        Statement statement;
        ArrayList<Tarjeton> tarjeton = new ArrayList<Tarjeton>();
        
        try{
            statement = ManejadorBD.dameConnection().createStatement();
            /*
            nombre='" + res.getNombre() + "'AND aPat='" + res.getaPat() + "';"
            */
            ResultSet rs = statement.executeQuery("SELECT * FROM Tarjeton WHERE Habitantes_idHabitante= '"+id +"'AND estado='"+"Activo"+"';");
            while(rs.next()){
                Tarjeton tarje = new Tarjeton(rs.getInt("Habitantes_idHabitante"),rs.getInt("num_estacionamiento"),rs.getString("placas"),rs.getString("fecha_impresion"),rs.getString("fecha_vencimiento"),rs.getString("estado"));
                tarjeton.add(tarje);
            }
 
            Tarjeton tarjetones []= new Tarjeton[tarjeton.size()];
            tarjeton.toArray(tarjetones);
            
            return tarjetones;
        }catch(SQLException e){
            System.out.println("Hubo un error al buscar tarjetones");
            e.printStackTrace();
            return null;
        }
    }

    public void bajaTarjeton(Tarjeton ton, Responsable hab) {

        try {
            Statement statement = ManejadorBD.dameConnection().createStatement();

            statement.execute("UPDATE tarjeton SET estado='" + ton.getEstado()
                    + "'  where num_estacionamiento = '" + ton.getNum_estacionamiento()+ "';"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // agregaTarjeton recibe una inatancia de Responsable y otra de tarjeton para agregar el registro a la tabla tarjeton
    public boolean agregaTarjeton(Responsable hab, Tarjeton tarj) throws SQLException{
        int contActivos = 0;//Cuenta de los tarjetones encontrados
        //String para realizar la consulta sobre los tarjetones con estado Activo.
        String queryActivos = "SELECT * FROM tarjeton WHERE Habitantes_idHabitante = "+hab.getId()+" AND estado = 'Activo'";
        Statement statement = ManejadorBD.dameConnection().createStatement();
        ResultSet rs = statement.executeQuery(queryActivos);//instancia de resultado de la consulta
        //Mientras existan elementos en la consulta se incrementa el contador
        while(rs.next()){
            contActivos++;
        }
        System.out.println("Numero de tarjetones activos: "+contActivos);
        //En el caso de el número de tarjetones Activos sea menor a 2 se agrega el tarjetón a la base de datos
        if(contActivos<2){ 
            try {
                System.out.println(tarj.getFecha_impresion());
                String insertaSQL = "Insert INTO tarjeton(Habitantes_idHabitante, placas, fecha_impresion, fecha_vencimiento, estado) VALUES ("+hab.getId()+", '"+tarj.getPlacas()+"', '"+tarj.getFecha_impresion()+"', '"+tarj.getFecha_vencimiento()+"', '"+tarj.getEstado()+"')";
                statement.execute(insertaSQL);
                System.out.println("Se ha agregado Tarjetón correctamente");
                //Una vez que se agregó el tarjetón a la base de datos se retorna true 
                return (true);

            } catch (SQLException e) {
               e.printStackTrace();
               return (false);
            }
        }
        else{
            //En caso que se encuentren 2 o más tarjetones Activos se retorna false
            return (false);
        }
    }   
  
    /*
     En este metodo se le manda  el tarjeton de dicho habitante
     para que su estado del tarjeton cambie a cancelado
    */
    public Boolean actualizarEstado(Tarjeton tarje) {
        
     try {
            Statement statement = ManejadorBD.dameConnection().createStatement();

            statement.execute("UPDATE tarjeton SET estado='" + tarje.getEstado()
                    + "'  where num_estacionamiento = '" + tarje.getNum_estacionamiento()+ "';"
            );
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    
    }
    
    /*
    Este metodo busca el tarjeton buscado por numero de estacionamiento y que coincida el id de dicho habitante
    y regresa el tarjeron que se requiere o null en caso de no existir
    */
    public Tarjeton buscarTarjetonNum (int numEstacionamiento, int idHabitante){
        try {
            
            Statement statement = ManejadorBD.dameConnection().createStatement();
            
          
            ResultSet rs=statement.executeQuery("SELECT * FROM tarjeton WHERE num_estacionamiento= '"+numEstacionamiento+"' AND Habitantes_idHabitante='"+idHabitante+"' AND estado='"+"Activo"+"';");
            
            rs.next();
            Tarjeton tarjeton = new Tarjeton(rs.getInt("Habitantes_idHabitante"), rs.getInt("num_estacionamiento"),rs.getString("placas"),rs.getString("fecha_impresion"),rs.getString("fecha_vencimiento"),rs.getString("estado"));
           
            rs.close();
            return tarjeton;
            
        }catch (SQLException e){
            System.out.println("Hubo un error al buscar tarjeton");
            e.printStackTrace();
            return null;
        }
        
    }
}
