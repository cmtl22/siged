package vista;

import controlador.ControladorNotificacion;
import controlador.ControladorUsuario;
import controlador.controladorVariablesSesion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmCambiarClave extends javax.swing.JDialog {

    TableRowSorter<TableModel> sorter;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String[] datosTemporales;
    private int contador;

    String[] nombresColmunas;

    public frmCambiarClave(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        datosTemporales = new String[3];
        txtClave.requestFocus();

        //Inahblita el boton cerrar
        // this.setResizable(false);
        // setDefaultCloseOperation(0);
        this.setLocationRelativeTo(null);
//        cargarDatos(VariablesSesion.getInstance().getDatosConsulta());
        // llenarFiltro(Objeto.getInstance().getNombresColmunas());
        // listenerFiltro();
        //  listenerJtable();
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recursos/ico_sistema.jpg"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpRecuperarClave = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        txtRepetirClave = new javax.swing.JPasswordField();
        btnCambiarClave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAMBIAR CONTRASEÑA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRecuperarClave.setBackground(new java.awt.Color(255, 255, 255));
        jpRecuperarClave.setPreferredSize(new java.awt.Dimension(900, 523));
        jpRecuperarClave.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel18.setText("Ingrese su nueva contraseña:");
        jpRecuperarClave.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 170, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel19.setText("Repita su contraseña:");
        jpRecuperarClave.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 30));

        txtClave.setMinimumSize(new java.awt.Dimension(6, 25));
        txtClave.setPreferredSize(new java.awt.Dimension(6, 25));
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);
            }
        });
        jpRecuperarClave.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 150, -1));

        txtRepetirClave.setMinimumSize(new java.awt.Dimension(6, 25));
        txtRepetirClave.setPreferredSize(new java.awt.Dimension(6, 25));
        txtRepetirClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRepetirClaveKeyPressed(evt);
            }
        });
        jpRecuperarClave.add(txtRepetirClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 150, -1));

        btnCambiarClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_aceptar_48.png"))); // NOI18N
        btnCambiarClave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCambiarClave.setPreferredSize(new java.awt.Dimension(48, 48));
        btnCambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClaveActionPerformed(evt);
            }
        });
        jpRecuperarClave.add(btnCambiarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));

        getContentPane().add(jpRecuperarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnCambiarClaveActionPerformed(null);
        }
    }//GEN-LAST:event_txtClaveKeyPressed

    private void txtRepetirClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepetirClaveKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepetirClaveKeyPressed

    private void btnCambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClaveActionPerformed
        if (cambiarClave()) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCambiarClaveActionPerformed

    private boolean cambiarClave() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("id", controladorVariablesSesion.getInstance().getCodigoUsuario());
        map.put("clave", txtClave.getText());
        map.put("nombreUsuario", controladorVariablesSesion.getInstance().getNombreUsuario());
        map.put("correo", controladorVariablesSesion.getInstance().getCorreoUsuario());
        map.put("repetirClave", txtRepetirClave.getText());
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        return controladorUsuario.cambiarClave(map);

    }

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
            java.util.logging.Logger.getLogger(frmCambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCambiarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCambiarClave dialog = new frmCambiarClave(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarClave;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jpRecuperarClave;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtRepetirClave;
    // End of variables declaration//GEN-END:variables
}
