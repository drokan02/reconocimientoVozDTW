/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author DroKaN
 */
public class Grabacion extends javax.swing.JFrame {

    /**
     * Creates new form Grabacion1
     */
    public Grabacion() {
        initComponents();
             ImageIcon img = new ImageIcon("src/Imagenes/fondoD.jpg");
            Icon icon = new ImageIcon(img.getImage().getScaledInstance(lbFondo.getWidth(), lbFondo.getHeight(), Image.SCALE_DEFAULT));
            lbFondo.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbMicrof = new javax.swing.JLabel();
        lbfAnimado = new javax.swing.JLabel();
        lbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 140, 50));

        lbMicrof.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        lbMicrof.setForeground(new java.awt.Color(255, 255, 255));
        lbMicrof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMicrof.setText("m");
        lbMicrof.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbMicrof, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 340));

        lbfAnimado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbfAnimado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lbfAnimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 330));
        getContentPane().add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grabacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grabacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grabacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grabacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grabacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbFondo;
    public javax.swing.JLabel lbMicrof;
    public javax.swing.JLabel lbTitulo;
    public javax.swing.JLabel lbfAnimado;
    // End of variables declaration//GEN-END:variables
}
