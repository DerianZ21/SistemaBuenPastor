package vista;

import controlador.controladorUsuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import modelo.usuario;
/**
 * @author Asus
 */
public class vistaUsuarios extends javax.swing.JFrame {
    usuario objUsuarios = new usuario();
    controladorUsuario controlador = new controladorUsuario(this);
    /**
     * Creates new form vistaAlumnos
     */
    public vistaUsuarios() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIDUsuarios.disable();
        controlador.consultarUsuarios(tbListaUsuarios);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Agregar un WindowListener para controlar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aquí puedes realizar acciones adicionales antes de cerrar la vista,
                // o mostrar un cuadro de diálogo de confirmación para cerrar.
                // Por ejemplo:
                int opcion = JOptionPane.showConfirmDialog(vistaUsuarios.this, "¿Deseas cerrar la ventana?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    dispose();
                    vaciarCampos();
                    btnInsertar.setEnabled(true);
                }
            }
        });
    }
    
    public void vaciarCampos(){
        txtIDUsuarios.setText("");
        txtUsername.setText("");
        txtNombreUsuarios.setText("");
        txtApellidoUsuarios.setText("");
        pswContrasenaUsuario.setText("");
        pswConfirmarContrasena.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIDUsuarios = new javax.swing.JTextField();
        txtNombreUsuarios = new javax.swing.JTextField();
        txtApellidoUsuarios = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        pswContrasenaUsuario = new javax.swing.JPasswordField();
        pswConfirmarContrasena = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListaUsuarios = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de USUARIO"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel1.setText("Identificación:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 69, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel2.setText("Nombres:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 109, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel3.setText("Apellidos:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 149, -1, -1));
        jPanel1.add(txtIDUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 179, 30));
        jPanel1.add(txtNombreUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 270, 30));
        jPanel1.add(txtApellidoUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 270, 30));

        btnInsertar.setBackground(new java.awt.Color(14, 248, 0));
        btnInsertar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoGuardar.png"))); // NOI18N
        btnInsertar.setText("Guardar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        jPanel1.add(btnInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 370, 70));

        btnModificar.setBackground(new java.awt.Color(51, 102, 255));
        btnModificar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoModificarBoton.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 180, 60));

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI Emoji", 1, 16)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoEliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 190, 60));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel4.setText("Nombre de usuario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 189, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel5.setText("Contraseña:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 229, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel6.setText("Confimar contraseña:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 269, -1, -1));

        txtUsername.setToolTipText("ej:Arturo23");
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 270, 30));
        jPanel1.add(pswContrasenaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 270, 30));
        jPanel1.add(pswConfirmarContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 270, 30));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 25)); // NOI18N
        jLabel10.setText("DATO DE USARIO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoParaAgregar.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 470, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 21, 460, 460));
        jPanel1.getAccessibleContext().setAccessibleName("DATOS DE USUARIO");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("tabla de USUARIOS"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbListaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListaUsuarios);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 404, 417));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 25)); // NOI18N
        jLabel11.setText("TABLA DE USUARIO");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoParaAgregar.png"))); // NOI18N
        jLabel9.setText("jLabel7");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-490, -20, 970, 500));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 21, 460, 480));
        jPanel2.getAccessibleContext().setAccessibleName("TABLA DE USUARIOS");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoParaAgregar.png"))); // NOI18N
        jLabel8.setText("jLabel7");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 980, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas insertar este usuario?", "Confirmar Inserción", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            controlador.insertarUsuario();
            controlador.consultarUsuarios(tbListaUsuarios);
            vaciarCampos();
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void tbListaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListaUsuariosMouseClicked
        controlador.seleccionarUsuarios(tbListaUsuarios, txtIDUsuarios, txtNombreUsuarios, txtApellidoUsuarios);
        if (tbListaUsuarios.getSelectedRow() != -1) {
            btnInsertar.setEnabled(true);
            } else {
            btnInsertar.setEnabled(false);
        }
        btnInsertar.setEnabled(false);
    }//GEN-LAST:event_tbListaUsuariosMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas modificar este usuario?", "Confirmar Modificación", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            controlador.modificarUsuario();
            controlador.consultarUsuarios(tbListaUsuarios);
            btnInsertar.setEnabled(true);
            vaciarCampos();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este usuario?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            controlador.eliminarUsuario();
            controlador.consultarUsuarios(tbListaUsuarios);
            txtIDUsuarios.setText("");
            txtNombreUsuarios.setText("");
            txtApellidoUsuarios.setText("");
            btnInsertar.setEnabled(true);
            this.vaciarCampos();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(vistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaUsuarios().setVisible(true);
            }
        });
    }

    public JTextField getTxtIDUsuarios() {
        return txtIDUsuarios;
    }

    public void setTxtIDUsuarios(JTextField txtIDUsuarios) {
        this.txtIDUsuarios = txtIDUsuarios;
    }

    public JTextField getTxtApellidoUsuario() {
        return txtApellidoUsuarios;
    }

    public void setTxtApellidoUsuarios(JTextField txtApellidoUsuarios) {
        this.txtApellidoUsuarios = txtApellidoUsuarios;
    }

    public JTextField getTxtNombreUsuario() {
        return txtNombreUsuarios;
    }

    public void setTxtNombreUsuarios(JTextField txtNombreUsuarios) {
        this.txtNombreUsuarios = txtNombreUsuarios;
    }

    public JTable getTbListaUsuarios() {
        return tbListaUsuarios;
    }

    public void setTbListaUsuarios(JTable tbListaUsuarios) {
        this.tbListaUsuarios = tbListaUsuarios;
    }
    
    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }
    
    public JPasswordField getPswConfirmarContrasena() {
        return pswConfirmarContrasena;
    }

    public void setPswConfirmarContrasena(JPasswordField pswConfirmarContrasena) {
        this.pswConfirmarContrasena = pswConfirmarContrasena;
    }

    public JPasswordField getPswContrasenaUsuario() {
        return pswContrasenaUsuario;
    }

    public void setPswContrasenaUsuario(JPasswordField pswContrasenaUsuario) {
        this.pswContrasenaUsuario = pswContrasenaUsuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField pswConfirmarContrasena;
    private javax.swing.JPasswordField pswContrasenaUsuario;
    private javax.swing.JTable tbListaUsuarios;
    private javax.swing.JTextField txtApellidoUsuarios;
    private javax.swing.JTextField txtIDUsuarios;
    private javax.swing.JTextField txtNombreUsuarios;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

}
