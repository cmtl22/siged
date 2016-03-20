package vista;

import controlador.ControladorNotificacion;
import controlador.ControladorUsuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmRecuperarClave extends javax.swing.JDialog {

    TableRowSorter<TableModel> sorter;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String[] datosTemporales;
    private int contador;

    String[] nombresColmunas;

    public frmRecuperarClave(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        datosTemporales = new String[3];
        txtNombreUsuario.requestFocus();

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
        txtNombreUsuario = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RECUPERAR CONTRASEÑA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRecuperarClave.setBackground(new java.awt.Color(255, 255, 255));
        jpRecuperarClave.setPreferredSize(new java.awt.Dimension(900, 523));
        jpRecuperarClave.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel18.setText("Ingrese su Nombre de Usuario:");
        jpRecuperarClave.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 180, 30));

        txtNombreUsuario.setAlignmentY(0.0F);
        txtNombreUsuario.setPreferredSize(new java.awt.Dimension(6, 25));
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyReleased(evt);
            }
        });
        jpRecuperarClave.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 150, -1));

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_aceptar_48.png"))); // NOI18N
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setPreferredSize(new java.awt.Dimension(48, 48));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jpRecuperarClave.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        getContentPane().add(jpRecuperarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 69));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtNombreUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyReleased

    }//GEN-LAST:event_txtNombreUsuarioKeyReleased

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        enviarUsuario();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void enviarNotificacion() {
        Map<String, Object> map = new HashMap<>();
        String notificacion = "";
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", "crear");
        map.put("id", "1");
        map.put("referencia", "0");
        map.put("descripcion", notificacion);
        map.put("tipo", "RC");
        ControladorNotificacion controladorNotificacion = new ControladorNotificacion();
        //llama al metodo para crear o actualizar segun sea la accion
        controladorNotificacion.crearActualizar(map);

    }

    private void enviarUsuario() {
        enviarNotificacion();
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("nombreUsuario", txtNombreUsuario.getText());
        ControladorUsuario controladorUsuario = new ControladorUsuario();
        controladorUsuario.recuperarClave(map);
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
            java.util.logging.Logger.getLogger(frmRecuperarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRecuperarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRecuperarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRecuperarClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmRecuperarClave dialog = new frmRecuperarClave(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jpRecuperarClave;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
