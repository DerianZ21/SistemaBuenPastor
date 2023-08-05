/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.controladorAsignarCurso;
import idao.IObserverVistaBeneficiario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class vistaAsignarCurso extends javax.swing.JFrame {
    controladorAsignarCurso controlador = new controladorAsignarCurso(this);

    /**
     * Creates new form vistaAsignarCurso
     */
    public vistaAsignarCurso() {
        initComponents();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Agregar un WindowListener para controlar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aquí puedes realizar acciones adicionales antes de cerrar la vista,
                // o mostrar un cuadro de diálogo de confirmación para cerrar.
                // Por ejemplo:
                int opcion = JOptionPane.showConfirmDialog(vistaAsignarCurso.this, "¿Deseas cerrar la ventana?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    notifyObservers();
                    dispose();
                }
            }
        });
    }
    
    private List<IObserverVistaBeneficiario> observers = new ArrayList<>();

    public void addObserver(IObserverVistaBeneficiario observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (IObserverVistaBeneficiario observer : observers) {
            observer.ActualizarBeneficiario();
            observer.ActivarVentana();
        }
    }
    
    public int SeleccionarCurso(){ 
        int idCurso = -1;
            int filaSeleccionada = this.getTblCursos().getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un curso.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int indiceCedula = 0;

                idCurso =  (int) this.getTblCursos().getValueAt(filaSeleccionada, indiceCedula);
            }
            
         return idCurso;
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
        txtNombreApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAsignarCurso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        BtnRegresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIdBeneficiario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel1.setText("Beneficiario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        txtNombreApellido.setEnabled(false);
        getContentPane().add(txtNombreApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 270, 30));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel2.setText("Cursos:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        btnAsignarCurso.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        btnAsignarCurso.setForeground(new java.awt.Color(255, 0, 51));
        btnAsignarCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoAgregarBeneficiario.png"))); // NOI18N
        btnAsignarCurso.setText("AGREGAR");
        btnAsignarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarCursoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAsignarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, -1, -1));

        tblCursos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 51), new java.awt.Color(204, 0, 51)));
        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCursos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 340, 296));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 19)); // NOI18N
        jLabel3.setText("ASIGNAR CURSO AL BENEFICIARIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        BtnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Regresar.png"))); // NOI18N
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        jLabel5.setText("ID:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        txtIdBeneficiario.setEnabled(false);
        getContentPane().add(txtIdBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 90, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoParaAgregar.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarCursoActionPerformed
        int idCurso = this.SeleccionarCurso();
        if(idCurso!=-1){
            controlador.insertarAsignacionCurso();
        }
    }//GEN-LAST:event_btnAsignarCursoActionPerformed

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        this.setVisible(false);
        notifyObservers();
    }//GEN-LAST:event_BtnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(vistaAsignarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaAsignarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaAsignarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaAsignarCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaAsignarCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JButton btnAsignarCurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTextField txtIdBeneficiario;
    private javax.swing.JTextField txtNombreApellido;
    // End of variables declaration//GEN-END:variables

    public JTextField getTxtNombreApellido() {
        return txtNombreApellido;
    }

    public void setTxtNombreApellido(JTextField txtNombreApellido) {
        this.txtNombreApellido = txtNombreApellido;
    }

    public JTable getTblCursos() {
        return tblCursos;
    }

    public void setTblCursos(JTable tblCursos) {
        this.tblCursos = tblCursos;
    }

    public JTextField getTxtIdBeneficiario() {
        return txtIdBeneficiario;
    }

    public void setTxtIdBeneficiario(JTextField txtIdBeneficiario) {
        this.txtIdBeneficiario = txtIdBeneficiario;
    }
    
    
}
