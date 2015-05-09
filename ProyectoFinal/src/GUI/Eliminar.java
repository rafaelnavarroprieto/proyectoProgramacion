/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import informacion.Intermediaria;
import informacion.NombreNoValidoException;
import informacion.UnidadNoExistenteException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Ventana para eliminar unidad
 *
 * @author Rafael Navarro Prieto
 * @version 1.0
 */
public class Eliminar extends javax.swing.JDialog {

    /**
     * clase que se utiliza para los mensajes de error o de informaci�n
     */
    protected final JPanel contentPanel = new JPanel();
    /**
     * Ventana principal
     */
    JFrame ventanaPrincipal;

    /**
     * Constructor
     * @param principal ventana principal 
     */
    public Eliminar(JFrame principal) {
        initComponents();
        ventanaPrincipal = principal;
        setTitle(Intermediaria.archivo.getName() + " - Eliminar unidad - " + Intermediaria.getFecha());
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setText("Nombre de la unidad: ");

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminar)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 350, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/otros/FondoFinal.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 0, 540, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        try {
            if (Intermediaria.lista.getUnidad(nombre.getText()) == null) { // Si no existe la unidad
            }else{
            
            //Mensaje para confirmar la eliminaci�n
            
            Object[] options = {"Si", "No"};
            int respuesta = JOptionPane.showOptionDialog(null, "Vas a eliminar a " + nombre.getText() + " ¿Estas seguro?", "Eliminando",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
            
            //Acci�n a realziar segun el boton pulsado
            
            switch (respuesta) {
                case JOptionPane.YES_OPTION:
                    Intermediaria.lista.eliminar(nombre.getText());
                    JOptionPane.showMessageDialog(contentPanel, "Unidad Eliminada", "Info", JOptionPane.INFORMATION_MESSAGE);
                    nombre.setText("");
                    return;
                case JOptionPane.NO_OPTION:
                    nombre.setText("");
                    return;
            }
            }
        } catch (UnidadNoExistenteException ex) {
            JOptionPane.showMessageDialog(contentPanel, ex.getMessage(), "ERROR!!!!", JOptionPane.ERROR_MESSAGE);
            nombre.setText("");
        } catch (NombreNoValidoException ex) {
            JOptionPane.showMessageDialog(contentPanel, ex.getMessage(), "ERROR!!!!", JOptionPane.ERROR_MESSAGE);
            nombre.setText("");
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing
    /**
     * Al cerrar el programa
     */
    private void cerrar() {
        ventanaPrincipal.setVisible(true);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
