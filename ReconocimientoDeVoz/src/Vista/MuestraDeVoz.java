/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;

/**
 *
 * @author DroKaN
 */
public class MuestraDeVoz extends javax.swing.JFrame {

    public MuestraDeVoz() {
        initComponents();
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcion = new javax.swing.ButtonGroup();
        txtMuestra = new javax.swing.JTextField();
        btGrabar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        btComparar = new javax.swing.JButton();
        btPrueba = new javax.swing.JButton();
        btPlay = new javax.swing.JButton();
        txtError = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbAgregar = new javax.swing.JRadioButton();
        rbReconocer = new javax.swing.JRadioButton();
        gackgron = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtMuestra, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 200, -1));

        btGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/microfono-icono-9040-64.png"))); // NOI18N
        btGrabar.setBorder(null);
        btGrabar.setBorderPainted(false);
        btGrabar.setContentAreaFilled(false);
        btGrabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btGrabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btGrabar.setIconTextGap(-3);
        btGrabar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/microfono-icono-9040-96.png"))); // NOI18N
        btGrabar.setVerifyInputWhenFocusTarget(false);
        btGrabar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(btGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 90, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nueva palabra: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = new String[20];
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 241, 180));

        btComparar.setText("Comparar");
        getContentPane().add(btComparar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        btPrueba.setText("jButton1");
        getContentPane().add(btPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        btPlay.setText("Play");
        getContentPane().add(btPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        txtError.setFont(new java.awt.Font("SimHei", 1, 24)); // NOI18N
        txtError.setForeground(new java.awt.Color(255, 0, 51));
        txtError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 470, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        opcion.add(rbAgregar);
        rbAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbAgregar.setForeground(new java.awt.Color(255, 255, 255));
        rbAgregar.setText("Agregar Muestra");
        jPanel1.add(rbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 7, -1, -1));

        opcion.add(rbReconocer);
        rbReconocer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbReconocer.setForeground(new java.awt.Color(255, 255, 255));
        rbReconocer.setText("Reconocer Voz");
        jPanel1.add(rbReconocer, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 7, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 290, 40));
        getContentPane().add(gackgron, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 380));

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
            java.util.logging.Logger.getLogger(MuestraDeVoz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuestraDeVoz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuestraDeVoz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuestraDeVoz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuestraDeVoz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btComparar;
    public javax.swing.JButton btGrabar;
    public javax.swing.JButton btPlay;
    public javax.swing.JButton btPrueba;
    public javax.swing.JLabel gackgron;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JList<String> jList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup opcion;
    public javax.swing.JRadioButton rbAgregar;
    public javax.swing.JRadioButton rbReconocer;
    public javax.swing.JLabel txtError;
    public javax.swing.JTextField txtMuestra;
    // End of variables declaration//GEN-END:variables
}
