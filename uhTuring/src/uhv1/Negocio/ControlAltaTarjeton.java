/*
Clase ControlAltaTarjetón permite a al sistema llevar el control sobre los atributos y métodos necesarios
para administrar el Alta un Tarjetón. 
*/
//sentencia del paquete
package uhv1.Negocio;
//sentencia de importación
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uhv1.ControlPrincipal;
import uhv1.Persistencia.DAOTarjeton;
import uhv1.Vistas.VentanaAltaTarjeton;

//Declaracion de clase 
public class ControlAltaTarjeton {
    
    public ControlAltaTarjeton(){//constuctor default
    }
    
    //inicio de flujo de US
    public void inicia(Responsable hab){
        //Se evalua si el Responsable tiene retasos acumulados en su pago de cuotas de mantenimiento.
        if(hab.getSaldo()>80){
            //En caso de retraso se despliega una ventana con el aviso de retraso
            JOptionPane.showMessageDialog(null, "Aviso: Este habitante cuenta con retrasos de cuota de \nmantenimiento por lo que no es posible asignar nuevo tarjetón.", "Aviso:",JOptionPane.INFORMATION_MESSAGE);
            ControlPrincipal cp = new ControlPrincipal();
            cp.inicia();
        }else{
        //En caso que se encuentre que el Responsable está al corriente en sus pagos continua
        java.awt.EventQueue.invokeLater(() -> {
            try {
                //Se instancia la VentanaAltaTarjeton y se despliega
                new VentanaAltaTarjeton(hab).setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(VentanaAltaTarjeton.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        }
    }
    
    //metodo que recibe los datos la ventana alta tarjeton
    public boolean recibeDatosFormulario(Responsable hab, String plac) throws SQLException{
        boolean exito;//boolenao para decidir si el responsable tiene asignados dos  tarjetones
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");//Instancia un formato para las fechas 
        java.sql.Date fechaActual; //calcula la fecha actual
        fechaActual = java.sql.Date.valueOf(LocalDate.now());
        Calendar cal = Calendar.getInstance();//intsancia para sumar un mes a la fecha actual
        cal.add(Calendar.MONTH, 1);//suma un mes
        java.sql.Date fechaFin = new java.sql.Date(cal.getTimeInMillis());//cast tipo Date
        String fechaImpresion = fechaActual.toString();
        String fechaVencimiento = fechaFin.toString();
        String estado = "Activo";
        //Instancia tarjeton; 
        Tarjeton tarj = new Tarjeton(0, 0, plac,fechaImpresion ,fechaVencimiento ,estado );
        DAOTarjeton daot = new DAOTarjeton();
        //llamada a DAO para agregar tarjetón recibe false si se cuentan 2 o más tarjetones
        exito = daot.agregaTarjeton(hab, tarj);
        VentanaAltaTarjeton vat = new VentanaAltaTarjeton();
        vat.ventanaExito(exito); //Envía el booleano para decidir que mensaje mostrar.
        return (exito);
    }
    
}
