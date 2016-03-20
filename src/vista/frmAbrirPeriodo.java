package vista;

import controlador.ControladorCarrera;
import controlador.ControladorPeriodo;
import controlador.controladorConsulta;
import controlador.controladorVariablesSesion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmAbrirPeriodo extends javax.swing.JDialog {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    Date fechaActual;
    private String accion = "crear";
    private String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;

    ArrayList<String> codigoPeriodo = new ArrayList<>();
    ArrayList<String> codigoTarea = new ArrayList<>();
// </editor-fold > 

    public frmAbrirPeriodo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        criterioBusqueda = new String[3];
        llenarComboPeriodos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpRegistroCronograma = new javax.swing.JPanel();
        lblPeriodo = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox();
        dtFechaInicio = new com.toedter.calendar.JDateChooser();
        dtFechaFin = new com.toedter.calendar.JDateChooser();
        lblTitulo_Id4 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpRegistroCronograma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroCronograma.setPreferredSize(new java.awt.Dimension(450, 510));
        jpRegistroCronograma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPeriodo.setText("Período :");
        jpRegistroCronograma.add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        lblFechaInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaInicio.setText("Fecha de Inicio:");
        jpRegistroCronograma.add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lblFechaFin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaFin.setText("Fecha de Finalización:");
        jpRegistroCronograma.add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        cmbPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPeriodoActionPerformed(evt);
            }
        });
        jpRegistroCronograma.add(cmbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 240, 25));

        dtFechaInicio.setBackground(new java.awt.Color(255, 255, 255));
        dtFechaInicio.setDateFormatString("yyyy-MM-dd");
        dtFechaInicio.setEnabled(false);
        jpRegistroCronograma.add(dtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 120, 25));

        dtFechaFin.setBackground(new java.awt.Color(255, 255, 255));
        dtFechaFin.setDateFormatString("yyyy-MM-dd");
        dtFechaFin.setEnabled(false);
        jpRegistroCronograma.add(dtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 120, 25));

        lblTitulo_Id4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id4.setText("Id:");
        lblTitulo_Id4.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroCronograma.add(lblTitulo_Id4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroCronograma.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        btnEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_aceptar_48.png"))); // NOI18N
        btnEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEnviar.setPreferredSize(new java.awt.Dimension(48, 48));
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jpRegistroCronograma.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRegistroCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRegistroCronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPeriodoActionPerformed
        llenarPeriodo(consultarRegistroIndividual(codigoPeriodo.get(cmbPeriodo.getSelectedIndex()), "periodo"));
    }//GEN-LAST:event_cmbPeriodoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        if (cmbPeriodo.getSelectedIndex() != 0) {

            if (abrirPeriodo()) {
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Periodo", "Periodo", 2);
        }
    }//GEN-LAST:event_btnEnviarActionPerformed
    private boolean abrirPeriodo() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("id", lblId.getText());
        map.put("accion", accion);
        map.put("nombre", "0");
        map.put("fechaInicio", "0");
        map.put("fechaFin", "0");
        //instacia el controlador
        ControladorPeriodo controladorPeriodo = new ControladorPeriodo();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorPeriodo.abrirPeriodo(map);

    }

    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
    }

    private void llenarPeriodo(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        dtFechaInicio.setDate(stringToJDateChooser((String) datos.get(2)));
        dtFechaFin.setDate(stringToJDateChooser((String) datos.get(3)));
    }

    public Date stringToJDateChooser(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
            System.out.println(fechaDate.toString());
            return fechaDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return fechaDate;
        }
    }

    private void llenarComboPeriodos() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "periodo";
        criterioBusqueda[1] = "tabla";
        cmbPeriodo.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoPeriodo = consulta.getCodigoCombo();

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
            java.util.logging.Logger.getLogger(frmAbrirPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAbrirPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAbrirPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAbrirPeriodo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmAbrirPeriodo dialog = new frmAbrirPeriodo(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox cmbPeriodo;
    private com.toedter.calendar.JDateChooser dtFechaFin;
    private com.toedter.calendar.JDateChooser dtFechaInicio;
    private javax.swing.JPanel jpRegistroCronograma;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTitulo_Id4;
    // End of variables declaration//GEN-END:variables
}
