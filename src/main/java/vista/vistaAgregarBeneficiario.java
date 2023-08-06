/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.toedter.calendar.JDateChooser;
import controlador.controladorAgregarBeneficiario;
import idao.IObserverVistaBeneficiario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Asus
 */
public class vistaAgregarBeneficiario extends javax.swing.JFrame {
    controladorAgregarBeneficiario controladorAgregarBeneficiario = new controladorAgregarBeneficiario(this);
    
    
    
    public vistaAgregarBeneficiario() {
        initComponents();
        txtTipo.setEditable(false);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Agregar un WindowListener para controlar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aquí puedes realizar acciones adicionales antes de cerrar la vista,
                // o mostrar un cuadro de diálogo de confirmación para cerrar.
                // Por ejemplo:
                int opcion = JOptionPane.showConfirmDialog(vistaAgregarBeneficiario.this, "¿Deseas cerrar la ventana?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    notifyObservers();
                    dispose();
                    vaciarCampos();
                }
            }
        });
    }
    
    private List<IObserverVistaBeneficiario> observers = new ArrayList<>();

    public void addObserver(IObserverVistaBeneficiario observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (IObserverVistaBeneficiario observer : observers) {
            observer.ActivarVentana();
            observer.ActualizarBeneficiario();
        }
    }
    
    public void elegirTipo(){
        pnlPadres.setVisible(false);
        btnAgregar.setEnabled(true);
        txtCedula.setEditable(true);
        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        DefaultTableModel tableModel = (DefaultTableModel) tblPadres.getModel();
        tableModel.setRowCount(0);
      
        String[] opciones = {"Hijo","Padre","Madre"};
        int respuesta = JOptionPane.showOptionDialog(this, "Seleccione el tipo de beneficiario:", "Tipo de Beneficiario",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
           
        switch (respuesta) {
            case 0:
                pnlPadres.setVisible(true);
                txtTipo.setText(opciones[0]);
                break;
            case 1:
                controladorAgregarBeneficiario.consultarPadres(tblPadres);
                txtTipo.setText(opciones[1]);
                btnAgregar.setEnabled(false);
                txtCedula.setEditable(false);
                txtNombre.setEditable(false);
                txtApellido.setEditable(false);
                break;
            case 2:
                controladorAgregarBeneficiario.consultarMadres(tblPadres);
                txtTipo.setText(opciones[2]);
                btnAgregar.setEnabled(false);
                txtCedula.setEditable(false);
                txtNombre.setEditable(false);
                txtApellido.setEditable(false);
                break;
            default:
                txtTipo.setText("");
        }
    }
    
    public void vaciarCampos(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        jdcFechaNacimiento.setDate(null);
        txtCedulaMadre.setText("");
        txtNombreMadre.setText("");
        txtApellidoMadre.setText("");
        txtCedulaPadre.setText("");
        txtNombrePadre.setText("");
        txtApellidoPadre.setText("");
        txtTipo.setText("");
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
        txtCedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        pnlPadres = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCedulaPadre = new javax.swing.JTextField();
        txtApellidoPadre = new javax.swing.JTextField();
        txtNombrePadre = new javax.swing.JTextField();
        txtNombreMadre = new javax.swing.JTextField();
        txtApellidoMadre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txtCedulaMadre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        BtnRegresar1 = new javax.swing.JButton();
        btnNuevoPadreMadre = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPadres = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 210, 30));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel1.setText("Nombres:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel2.setText("Apellidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel3.setText("Cédula");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel4.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel5.setText("Teléfono:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel6.setText("Dirección:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel7.setText("E-mail:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel8.setText("Tipo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 370, 30));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 360, 30));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 370, 30));

        jTextField6.setText("jTextField1");
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 229, -1, 0));

        jTextField7.setText("jTextField1");
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 239, -1, 0));

        jTextField8.setText("jTextField1");
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 249, -1, 0));
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 360, 30));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 360, 30));
        jPanel1.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 360, 30));

        jdcFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jdcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 160, 36));

        pnlPadres.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel9.setText("PADRE");
        pnlPadres.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel11.setText("Cédula:");
        pnlPadres.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel13.setText("Apellido:");
        pnlPadres.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel12.setText("Nombre:");
        pnlPadres.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel10.setText("MADRE");
        pnlPadres.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));
        pnlPadres.add(txtCedulaPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 250, 30));
        pnlPadres.add(txtApellidoPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 250, 30));
        pnlPadres.add(txtNombrePadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 250, 30));
        pnlPadres.add(txtNombreMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 270, 30));
        pnlPadres.add(txtApellidoMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 270, 30));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel15.setText("Apellido:");
        pnlPadres.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        jLabel14.setText("Cédula:");
        pnlPadres.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        Nombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        Nombre.setText("Nombre:");
        pnlPadres.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));
        pnlPadres.add(txtCedulaMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 270, 30));

        jPanel1.add(pnlPadres, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 700, 170));

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel16.setText("AGREGAR BENEFICIARIO");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        btnAgregar.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 20)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoAgregarBeneficiario.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 210, -1));

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel17.setText("AGREGAR PADRES");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        BtnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Regresar.png"))); // NOI18N
        BtnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresar1ActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRegresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        btnNuevoPadreMadre.setText("NUEVO PADRE");
        btnNuevoPadreMadre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPadreMadreActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevoPadreMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoParaAgregar.png"))); // NOI18N
        jLabel20.setText("jLabel20");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 790));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoParaAgregar.png"))); // NOI18N
        jLabel21.setText("jLabel20");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 690, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 790));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPadres.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        tblPadres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPadres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPadresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPadres);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 550, 680));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoParaAgregar.png"))); // NOI18N
        jLabel18.setText("jLabel18");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 600, 790));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 0, 630, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String tipo = txtTipo.getText();
        String mensajeConfirmacion = "¿Estás seguro de que deseas agregar el beneficiario?";

        int confirmacion = JOptionPane.showConfirmDialog(this, mensajeConfirmacion, "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (tipo.equals("Hijo")) {
                controladorAgregarBeneficiario.insertarBeneficiariohijo();
                notifyObservers();
            } else {
                if(txtCedula.isEditable()){
                    controladorAgregarBeneficiario.insertarBeneficiarioNuevoPadre();
                }else{
                    controladorAgregarBeneficiario.insertarBeneficiarioPadres();
                }
                notifyObservers();
            }
            vaciarCampos();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblPadresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPadresMouseClicked
        tblPadres.setEnabled(true);
        controladorAgregarBeneficiario.seleccionarPadreMadre(tblPadres, txtCedula, txtNombre, txtApellido);
        if (tblPadres.getSelectedRow() != -1) {
            btnAgregar.setEnabled(true);
            } else {
            btnAgregar.setEnabled(false);
        }
        txtCedula.setEditable(false);
        txtNombre.setEditable(false);
        txtApellido.setEditable(false);
    }//GEN-LAST:event_tblPadresMouseClicked

    private void BtnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresar1ActionPerformed
       this.setVisible(false);
       notifyObservers();
    }//GEN-LAST:event_BtnRegresar1ActionPerformed

    private void btnNuevoPadreMadreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPadreMadreActionPerformed
        txtCedula.setEditable(true);
        txtNombre.setEditable(true);
        txtApellido.setEditable(true);
        tblPadres.setEnabled(false);
        btnAgregar.setEnabled(true);
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
    }//GEN-LAST:event_btnNuevoPadreMadreActionPerformed

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
            java.util.logging.Logger.getLogger(vistaAgregarBeneficiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaAgregarBeneficiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaAgregarBeneficiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaAgregarBeneficiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaAgregarBeneficiario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegresar1;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnNuevoPadreMadre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JPanel pnlPadres;
    private javax.swing.JTable tblPadres;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoMadre;
    private javax.swing.JTextField txtApellidoPadre;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaMadre;
    private javax.swing.JTextField txtCedulaPadre;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreMadre;
    private javax.swing.JTextField txtNombrePadre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    public JDateChooser getJdcFechaNacimiento() {
        return jdcFechaNacimiento;
    }

    public void setJdcFechaNacimiento(JDateChooser jdcFechaNacimiento) {
        this.jdcFechaNacimiento = jdcFechaNacimiento;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public JTextField getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(JTextField txtTipo) {
        this.txtTipo = txtTipo;
    }

    public void setTxtTipo(String tipoElegido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JTextField getTxtApellidoMadre() {
        return txtApellidoMadre;
    }

    public void setTxtApellidoMadre(JTextField txtApellidoMadre) {
        this.txtApellidoMadre = txtApellidoMadre;
    }

    public JTextField getTxtApellidoPadre() {
        return txtApellidoPadre;
    }

    public void setTxtApellidoPadre(JTextField txtApellidoPadre) {
        this.txtApellidoPadre = txtApellidoPadre;
    }

    public JTextField getTxtCedulaMadre() {
        return txtCedulaMadre;
    }

    public void setTxtCedulaMadre(JTextField txtCedulaMadre) {
        this.txtCedulaMadre = txtCedulaMadre;
    }

    public JTextField getTxtCedulaPadre() {
        return txtCedulaPadre;
    }

    public void setTxtCedulaPadre(JTextField txtCedulaPadre) {
        this.txtCedulaPadre = txtCedulaPadre;
    }

    public JTextField getTxtNombreMadre() {
        return txtNombreMadre;
    }

    public void setTxtNombreMadre(JTextField txtNombreMadre) {
        this.txtNombreMadre = txtNombreMadre;
    }

    public JTextField getTxtNombrePadre() {
        return txtNombrePadre;
    }

    public void setTxtNombrePadre(JTextField txtNombrePadre) {
        this.txtNombrePadre = txtNombrePadre;
    }
    
}
