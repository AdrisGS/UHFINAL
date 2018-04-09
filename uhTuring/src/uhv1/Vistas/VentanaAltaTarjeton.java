/*
La clase VentanaAltaTarjeton despliega la información de Responsable, Casa y los
campos necesarios para ingresar la información del tarjeton
 */
//Sentencia del paquete
package uhv1.Vistas;
//Sentencias de importaciones
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import uhv1.ControlPrincipal;
import uhv1.Negocio.ControlAltaTarjeton;
import uhv1.Negocio.Responsable;

//Clase VentanaAltaTarjeton implementa de JFrame los métodos necesarios para visualizar la
//interfase de usuario para el Alta Tarjeton
public class VentanaAltaTarjeton extends javax.swing.JFrame {
    Date fechaHoy = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Responsable hab;
    Date fechaVencimiento = new Date();
    
    public VentanaAltaTarjeton(){//Constructor vacio
    }
    
    
    public VentanaAltaTarjeton(Responsable hab) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaHoy);
        cal.add(Calendar.MONTH, 1);
        fechaVencimiento = new Date(cal.getTimeInMillis());
        this.hab = hab;
        initComponents();
        setLocationRelativeTo(this);
    }
     //En caso que se halle un error en la asignación del DAO despliega este aviso
    public void ventanaError(){
    JOptionPane.showMessageDialog(null, "Aviso: No se realizó el registro del Tarjetón.", "Aviso:",JOptionPane.INFORMATION_MESSAGE);
    }
    
    //ventanaExito recibe de ControlAltaTarjetón true si se realizó agregó correctamente
    public void ventanaExito(boolean result){
        if(result==true){
            JOptionPane.showMessageDialog(null, "Aviso: Se realizó el registro correcto del Alta del Tarjetón al habitante", "Aviso:",JOptionPane.INFORMATION_MESSAGE);
        }else{
            //En caso de recibir false de ControlAltaTarjetón se despliegiega el aviso de que existen 2 o más tarjetones activos
            JOptionPane.showMessageDialog(null, "Aviso: El avitante ya cuenta con 2 Tarjetones activos\nNo se realizó el registro del Tarjetón.", "Aviso:",JOptionPane.INFORMATION_MESSAGE);           
        }
        ControlPrincipal cp = new ControlPrincipal();
        cp.inicia();
    } 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campo_idHabitante = new javax.swing.JTextField();
        campo_nombre = new javax.swing.JTextField();
        campo_aPat = new javax.swing.JTextField();
        campo_aMat = new javax.swing.JTextField();
        campo_telefono = new javax.swing.JTextField();
        campo_saldo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        campo_idCasa = new javax.swing.JTextField();
        campo_seccion = new javax.swing.JTextField();
        campo_numero = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        campo_idNumEstacionamiento = new javax.swing.JTextField();
        campo_placas = new javax.swing.JTextField();
        campo_fechaImpresion = new javax.swing.JTextField();
        campo_fechaVencimiento = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        campo_estado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        boton_aceptar = new javax.swing.JButton();
        boton_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Ventana alta tarjetón");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("idHabitante:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido Paterno:");

        jLabel4.setText("Apellido Materno:");

        jLabel5.setText("Teléfono:");

        jLabel6.setText("Saldo:");

        campo_idHabitante.setEditable(false);
        campo_idHabitante.setText(Integer.toString(hab.getId())
        );
        campo_idHabitante.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_idHabitante.setEnabled(false);

        campo_nombre.setEditable(false);
        campo_nombre.setText(hab.getNombre());
        campo_nombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_nombre.setEnabled(false);
        campo_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nombreActionPerformed(evt);
            }
        });

        campo_aPat.setEditable(false);
        campo_aPat.setText(hab.getaPat());
        campo_aPat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_aPat.setEnabled(false);
        campo_aPat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_aPatActionPerformed(evt);
            }
        });

        campo_aMat.setEditable(false);
        campo_aMat.setText(hab.getaMat());
        campo_aMat.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_aMat.setEnabled(false);

        campo_telefono.setEditable(false);
        campo_telefono.setText(Float.toString(hab.getTelefono()));
        campo_telefono.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_telefono.setEnabled(false);
        campo_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_telefonoActionPerformed(evt);
            }
        });

        campo_saldo.setEditable(false);
        campo_saldo.setText(Float.toString(hab.getSaldo()));
        campo_saldo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_saldo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campo_telefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(campo_aMat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campo_aPat, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campo_idHabitante, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campo_saldo))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_idHabitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_aPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campo_aMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        campo_idCasa.setEditable(false);
        campo_idCasa.setText(Integer.toString(hab.getCasa().getId()));
        campo_idCasa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_idCasa.setEnabled(false);
        campo_idCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_idCasaActionPerformed(evt);
            }
        });

        campo_seccion.setEditable(false);
        campo_seccion.setText(hab.getCasa().getSeccion());
        campo_seccion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_seccion.setEnabled(false);

        campo_numero.setEditable(false);
        campo_numero.setText(Integer.toString(hab.getCasa().getNumero()));
        campo_numero.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_numero.setEnabled(false);

        jLabel13.setText("Número:");

        jLabel12.setText("Sección:");

        jLabel11.setText("idCasa:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(14, 14, 14)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(13, 13, 13)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campo_numero, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(campo_seccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_idCasa, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campo_idCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(campo_seccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(campo_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Registro de Tarjeton"));

        jLabel7.setText("idNumEstacionamiento:");

        jLabel8.setText("Placas:");

        jLabel9.setText("Fecha de impresión:");

        jLabel10.setText("Fecha de vencimiento:");

        campo_idNumEstacionamiento.setEditable(false);
        campo_idNumEstacionamiento.setText("Nuevo");
        campo_idNumEstacionamiento.setToolTipText("");
        campo_idNumEstacionamiento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_idNumEstacionamiento.setEnabled(false);

        campo_placas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_placasActionPerformed(evt);
            }
        });

        campo_fechaImpresion.setEditable(false);
        campo_fechaImpresion.setText(df.format(fechaHoy));
        campo_fechaImpresion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_fechaImpresion.setEnabled(false);

        campo_fechaVencimiento.setEditable(false);
        campo_fechaVencimiento.setText(df.format(fechaVencimiento)
        );
        campo_fechaVencimiento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_fechaVencimiento.setEnabled(false);

        jLabel15.setText("Estado:");

        campo_estado.setEditable(false);
        campo_estado.setText("Activo");
        campo_estado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        campo_estado.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campo_estado)
                            .addComponent(campo_fechaImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(campo_idNumEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(campo_fechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campo_placas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(campo_idNumEstacionamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(campo_placas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campo_fechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(campo_fechaImpresion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(campo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setText("Datos de la vivienda");

        jLabel14.setText("Datos del habitante");

        boton_aceptar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boton_aceptar.setText("Aceptar");
        boton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aceptarActionPerformed(evt);
            }
        });

        boton_cancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        boton_cancelar.setText("Cancelar");
        boton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(boton_aceptar)
                        .addGap(95, 95, 95)
                        .addComponent(boton_cancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_aceptar)
                    .addComponent(boton_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_aceptarActionPerformed
        if ("".equals(campo_placas.getText())) {
            JOptionPane.showMessageDialog(null, "Aviso: El campo placas es requerido ", "Aviso:", JOptionPane.WARNING_MESSAGE);  
        }
        else{
         ControlAltaTarjeton cat = new ControlAltaTarjeton();
            try {
                //se envian los datos que recibe del formulario
                cat.recibeDatosFormulario(hab, campo_placas.getText());
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAltaTarjeton.class.getName()).log(Level.SEVERE, null, ex);
            }
        dispose();
        }
    }//GEN-LAST:event_boton_aceptarActionPerformed

    private void campo_aPatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_aPatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_aPatActionPerformed

    private void campo_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_telefonoActionPerformed

    private void campo_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nombreActionPerformed

    private void boton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cancelarActionPerformed
        JOptionPane.showMessageDialog(null, "Se canceló el registro de Alta de tarjetón. \n\nNo se realizaron cambios en el habitante.", "Aviso:", JOptionPane.WARNING_MESSAGE);
        ControlPrincipal cp = new ControlPrincipal();
        dispose();
        cp.inicia();
    }//GEN-LAST:event_boton_cancelarActionPerformed

    private void campo_idCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_idCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_idCasaActionPerformed

    private void campo_placasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_placasActionPerformed
        
    }//GEN-LAST:event_campo_placasActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JButton boton_cancelar;
    private javax.swing.JTextField campo_aMat;
    private javax.swing.JTextField campo_aPat;
    private javax.swing.JTextField campo_estado;
    private javax.swing.JTextField campo_fechaImpresion;
    private javax.swing.JTextField campo_fechaVencimiento;
    private javax.swing.JTextField campo_idCasa;
    private javax.swing.JTextField campo_idHabitante;
    private javax.swing.JTextField campo_idNumEstacionamiento;
    private javax.swing.JTextField campo_nombre;
    private javax.swing.JTextField campo_numero;
    private javax.swing.JTextField campo_placas;
    private javax.swing.JTextField campo_saldo;
    private javax.swing.JTextField campo_seccion;
    private javax.swing.JTextField campo_telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
