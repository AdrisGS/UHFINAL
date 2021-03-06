/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
package uhv1.Vistas;

import javax.swing.JOptionPane;
import uhv1.Negocio.ControlGestionTarjeton;
import uhv1.Negocio.Responsable;
import uhv1.Negocio.Tarjeton;

/**
 *
 * @author adrianags
 */
public class VentanaGestionTarjeton extends javax.swing.JFrame {

    /**
     * Creates new form VentanaGestionTarjeton
     */
    
    ControlGestionTarjeton control;
    Responsable res; 
    Tarjeton tar [];
    public VentanaGestionTarjeton(ControlGestionTarjeton control, Responsable res, Tarjeton tar[]) {
        this.control=control;
        this.res=res;
        this.tar=tar;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonAltaTarjeton = new javax.swing.JButton();
        jButtonCancelaTarjeton = new javax.swing.JButton();
        jLabelHabitante = new javax.swing.JLabel();
        jLabelCasa = new javax.swing.JLabel();
        jTextFieldTarjetones = new javax.swing.JTextField();
        jButtonTarjetones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                formAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Habitante Tarjetón");

        jButtonAltaTarjeton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonAltaTarjeton.setText("Alta tarjetón");
        jButtonAltaTarjeton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaTarjetonActionPerformed(evt);
            }
        });

        jButtonCancelaTarjeton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCancelaTarjeton.setText("Cancelar tarjetón");
        jButtonCancelaTarjeton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelaTarjetonActionPerformed(evt);
            }
        });

        jLabelHabitante.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelHabitante.setText("Habitante: "+ res.getNombre()+ " "+ res.getaPat()+ " "+ res.getaMat());
        jLabelHabitante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelCasa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelCasa.setText("Casa: "+ res.getCasa().getSeccion() + "-" + res.getCasa().getNumero());
        jLabelCasa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextFieldTarjetones.setBackground(new java.awt.Color(240, 240, 240));
        jTextFieldTarjetones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextFieldTarjetones.setCaretColor(new java.awt.Color(14, 14, 14));
        jTextFieldTarjetones.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldTarjetones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTarjetonesActionPerformed(evt);
            }
        });

        jButtonTarjetones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonTarjetones.setText("Tarjetones");
        jButtonTarjetones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTarjetonesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCasa)
                    .addComponent(jLabelHabitante)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonTarjetones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAltaTarjeton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelaTarjeton))
                        .addComponent(jTextFieldTarjetones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelHabitante)
                .addGap(18, 18, 18)
                .addComponent(jLabelCasa)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldTarjetones, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonTarjetones)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAltaTarjeton)
                    .addComponent(jButtonCancelaTarjeton))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAltaTarjetonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaTarjetonActionPerformed
        // TODO add your handling code here:
        control.altaTarjeton();
        setVisible(false);
    }//GEN-LAST:event_jButtonAltaTarjetonActionPerformed

    private void jButtonCancelaTarjetonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelaTarjetonActionPerformed
        // TODO add your handling code here:
        if(tar.length==0){
            JOptionPane.showMessageDialog (null, "No tiene tarjetones activos");  
        }else{
            control.cancelarTarjeton();
            setVisible(false);
        }
        
    }//GEN-LAST:event_jButtonCancelaTarjetonActionPerformed

    private void formAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorMoved

    private void jTextFieldTarjetonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTarjetonesActionPerformed
        // TODO add your handling code here:
        String mensaje;
        if(tar.length==0){
            mensaje= "No tiene tarjetones Activos";
            jTextFieldTarjetones.setText(mensaje);
        }
    }//GEN-LAST:event_jTextFieldTarjetonesActionPerformed

    private void jButtonTarjetonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTarjetonesActionPerformed
        // TODO add your handling code here:
        int i=0; 
        String tarje = null;
        String mensaje= null;
        String aux;
        if(tar.length==0){
            mensaje= "No tiene tarjetones Activos";
            jTextFieldTarjetones.setText(mensaje);
            
        
        }else{
            if(tar.length==1){
                    tarje=tar[i].imprime();
                    jTextFieldTarjetones.setText(tarje);      
            }else{
                aux=tar[i].imprime();
                while(tar.length==2 && i<tar.length){
                    mensaje=tar[i].imprime();
                    tarje=mensaje;
                    i++; 
                }
                jTextFieldTarjetones.setText(aux+" " +tarje);
            }
        }
       
    }//GEN-LAST:event_jButtonTarjetonesActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAltaTarjeton;
    private javax.swing.JButton jButtonCancelaTarjeton;
    private javax.swing.JButton jButtonTarjetones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCasa;
    private javax.swing.JLabel jLabelHabitante;
    private javax.swing.JTextField jTextFieldTarjetones;
    // End of variables declaration//GEN-END:variables
}
