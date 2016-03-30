package vista;

import controlador.ControladorNotificacion;
import controlador.ControladorUsuario;
import controlador.controladorConfiguraciones;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class frmLogin extends javax.swing.JDialog {

    private int tiempoRestante = 5;
    private Timer tiempoTotal;

    public frmLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(0);
        tiempoTotal = new Timer(1000, acciones);
        if (controladorConfiguraciones.getInstance().getContadorIntentosLogin() == 0) {
            btnIngresar.setEnabled(false);
            btnSalir.setEnabled(true);
            txtNombreUsuario.setEnabled(false);
            txtClave.setEnabled(false);
            txtNombreUsuario.setText(null);
            txtClave.setText(null);
            lblTituloIntentosRestantes.setVisible(true);
            lblIntentosRestantes.setText(String.valueOf(controladorConfiguraciones.getInstance().getContadorIntentosLogin()));
        } else {
            lblTituloIntentosRestantes.setVisible(false);
            lblTituloTiempoRestante.setVisible(false);
        }

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recursos/ico_sistema.jpg"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblClaveUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        btnRecuperarClave = new javax.swing.JLabel();
        lblIntentosRestantes = new javax.swing.JLabel();
        lblTituloIntentosRestantes = new javax.swing.JLabel();
        lblTituloTiempoRestante = new javax.swing.JLabel();
        lblTiempoRestante = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 625));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_Instituto.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 92));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_sistema.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, -1, 190));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 200));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_login_48.png"))); // NOI18N
        lblNombreUsuario.setText("Usuario:");
        lblNombreUsuario.setPreferredSize(new java.awt.Dimension(75, 35));
        jPanel2.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, -1));

        lblClaveUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClaveUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_clave_32.png"))); // NOI18N
        lblClaveUsuario.setText("Contraseña:");
        lblClaveUsuario.setPreferredSize(new java.awt.Dimension(68, 25));
        jPanel2.add(lblClaveUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 40));

        txtNombreUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombreUsuario.setPreferredSize(new java.awt.Dimension(95, 25));
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 200, -1));

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_aceptar_48.png"))); // NOI18N
        btnIngresar.setToolTipText("Ingresar");
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cerrar_40.png"))); // NOI18N
        btnSalir.setToolTipText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setPreferredSize(new java.awt.Dimension(50, 50));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        txtClave.setMinimumSize(new java.awt.Dimension(6, 25));
        txtClave.setPreferredSize(new java.awt.Dimension(6, 25));
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);
            }
        });
        jPanel2.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 200, -1));

        btnRecuperarClave.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnRecuperarClave.setForeground(new java.awt.Color(0, 51, 255));
        btnRecuperarClave.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnRecuperarClave.setText("¿Olvidó su contraseña?");
        btnRecuperarClave.setToolTipText("Haga clic para recuperar su contraseña");
        btnRecuperarClave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecuperarClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecuperarClaveMouseClicked(evt);
            }
        });
        jPanel2.add(btnRecuperarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 186, 118, -1));
        jPanel2.add(lblIntentosRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        lblTituloIntentosRestantes.setText("Intentos restantes:");
        jPanel2.add(lblTituloIntentosRestantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        lblTituloTiempoRestante.setText("Tiempo Restante:");
        jPanel2.add(lblTituloTiempoRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel2.add(lblTiempoRestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 330, 200));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("1.0.1");
        jLabel3.setPreferredSize(new java.awt.Dimension(35, 15));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 610, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Eventos">    
    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        validarCredenciales();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            btnIngresarActionPerformed(null);
        }
    }//GEN-LAST:event_txtClaveKeyPressed

    private void btnRecuperarClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecuperarClaveMouseClicked
        frmRecuperarClave frm = new frmRecuperarClave(null, true);
        frm.setVisible(true);
    }//GEN-LAST:event_btnRecuperarClaveMouseClicked
// </editor-fold >    

    // <editor-fold defaultstate="collapsed" desc="Metodos">    
    private ActionListener acciones = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            tiempoRestante--;
            lblTiempoRestante.setText(String.valueOf(tiempoRestante));

            if (tiempoRestante == 0) {
                habilitarControles();
                tiempoRestante = 5;
                tiempoTotal.stop();
            }
        }

    };

    private void habilitarControles() {
        btnIngresar.setEnabled(true);
        btnSalir.setEnabled(true);
        txtNombreUsuario.setEnabled(true);
        txtClave.setEnabled(true);
        txtNombreUsuario.setText(null);
        txtClave.setText(null);
        lblTituloIntentosRestantes.setVisible(false);
        lblTituloTiempoRestante.setVisible(false);
        lblIntentosRestantes.setText(null);
        lblTiempoRestante.setText(null);
    }

    private void validarCredenciales() {

        switch (validarUsuario()) {
            case "2"://Cuando el usuario ingresar por primera vez
                frmCambiarClave frm = new frmCambiarClave(null, true);
                frm.setVisible(true);
                this.dispose();
                break;
            case "1"://Cuando el usuario ingresa normalmente
                this.dispose();
                break;
            case "0"://Cuando el usuario existe pero la contraseña es incorrecta
                JOptionPane.showMessageDialog(rootPane, "La contraseña NO es correcta", "Acceso Denegado", 0);
                if (controladorConfiguraciones.getInstance().getContadorIntentosLogin() == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Si ingresa una contraseña NO válida una vez mas su usuario será bloqueado", "Bloqueo", 0);
                }
                lblTituloIntentosRestantes.setVisible(true);
                lblIntentosRestantes.setText(String.valueOf(controladorConfiguraciones.getInstance().getContadorIntentosLogin()));
                break;
            case "-1"://Cuando el usuario esta bloqueado
                JOptionPane.showMessageDialog(rootPane, "Su usuario se encuentra bloqueado", "Usuario Bloqueado", 2);
                break;
            case "-2"://Cuando el usuario ingresado no existe
                JOptionPane.showMessageDialog(rootPane, "Usuario NO existe", "Acceso Denegado", 2);
                break;
            case "-3"://Cuando el usuario esta en proceso de recuperación de contraseña
                JOptionPane.showMessageDialog(rootPane, "Usuario en proceso de recuperación \nde Contraseña", "Acceso Denegado", 2);
                break;
        }

        if (controladorConfiguraciones.getInstance().getContadorIntentosLogin() == 0) {
            lblTituloIntentosRestantes.setVisible(true);
            lblTituloTiempoRestante.setVisible(true);
            bloquearUsuario();
            enviarNotificacion();
            lblIntentosRestantes.setText(String.valueOf(controladorConfiguraciones.getInstance().getContadorIntentosLogin()));
            JOptionPane.showMessageDialog(rootPane, "Limite de intentos excedido", "Acceso Denegado", 2);
            btnIngresar.setEnabled(false);
            btnSalir.setEnabled(false);
            txtNombreUsuario.setEnabled(false);
            txtClave.setEnabled(false);
            txtNombreUsuario.setText(null);
            txtClave.setText(null);
            tiempoTotal.start();
        }
    }

    private String validarUsuario() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("nombreUsuario", txtNombreUsuario.getText());
        map.put("clave", txtClave.getText());

        ControladorUsuario controladorUsuario = new ControladorUsuario();

        return controladorUsuario.validarUsuario(map);
    }

    private void enviarNotificacion() {
        Map<String, Object> map = new HashMap<>();
        String notificacion = "Usuario bloqueado: " + txtNombreUsuario.getText() + "\n";
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", "crear");
        map.put("id", "1");
        map.put("referencia", "0");
        map.put("descripcion", notificacion);
        map.put("tipo", "BU");
        ControladorNotificacion controladorNotificacion = new ControladorNotificacion();
        //llama al metodo para crear o actualizar segun sea la accion
        controladorNotificacion.crearActualizar(map);

    }

    private String bloquearUsuario() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("nombreUsuario", txtNombreUsuario.getText());

        ControladorUsuario controladorUsuario = new ControladorUsuario();

        return controladorUsuario.bloquearUsuario(map);
    }

// </editor-fold>    
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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLogin dialog = new frmLogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify   ">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel btnRecuperarClave;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblClaveUsuario;
    private javax.swing.JLabel lblIntentosRestantes;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTiempoRestante;
    private javax.swing.JLabel lblTituloIntentosRestantes;
    private javax.swing.JLabel lblTituloTiempoRestante;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
// </editor-fold >    
}
