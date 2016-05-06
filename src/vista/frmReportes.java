package vista;

import controlador.controladorConsulta;
import controlador.controladorGrid;
import controlador.controladorReporte;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmReportes extends javax.swing.JFrame {

    String[] criterioBusqueda;
    ArrayList<String> codigoModulos = new ArrayList<>();

    public frmReportes() {
        initComponents();
        init();
    }

    private void init() {
        criterioBusqueda = new String[3];
        llenarComboModulos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblEmpresa = new javax.swing.JLabel();
        cmbModulos = new javax.swing.JComboBox<>();
        jpBusquedaAcercamiento = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtColumnas = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros3 = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmpresa.setText("Módulo:");
        lblEmpresa.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel1.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        cmbModulos.setBackground(new java.awt.Color(255, 255, 204));
        cmbModulos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbModulos.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbModulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbModulosActionPerformed(evt);
            }
        });
        jPanel1.add(cmbModulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 270, -1));

        jpBusquedaAcercamiento.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaAcercamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaAcercamiento.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaAcercamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtColumnas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Columnas", "Opción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtColumnas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtColumnas.setGridColor(new java.awt.Color(0, 102, 153));
        jtColumnas.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtColumnas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtColumnas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtColumnasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtColumnas);

        jpBusquedaAcercamiento.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 980, 370));

        cmbFiltro.setBackground(new java.awt.Color(255, 255, 204));
        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        jpBusquedaAcercamiento.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 210, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaAcercamiento.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 710, -1));

        lblRegistros3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros3.setText("Registros:");
        lblRegistros3.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaAcercamiento.add(lblRegistros3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaAcercamiento.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaAcercamiento.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jpBusquedaAcercamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1000, 440));

        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_reportes_32.png"))); // NOI18N
        btnGenerarReporte.setToolTipText("GUARDAR");
        btnGenerarReporte.setBorder(null);
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarReporte.setPreferredSize(new java.awt.Dimension(40, 40));
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbModulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbModulosActionPerformed
        cargarColumnas();
    }//GEN-LAST:event_cmbModulosActionPerformed

    private void jtColumnasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtColumnasMouseClicked
        int fila = jtColumnas.getSelectedRow();//guarda la fila seleccionada
        //accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            // llenarAcercamiento(consultarRegistroIndividual(jtAcercamiento.getValueAt(fila, 0).toString(), "acercamiento"));
        }
    }//GEN-LAST:event_jtColumnasMouseClicked

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        // convertirAmayusculas(txtCriterioBusqueda);
        //filtrar();
        //cargarTotalRegistros();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        //generarReporte(generarQuery());
        generarReporte("");
    }//GEN-LAST:event_btnGenerarReporteActionPerformed
    private void llenarComboModulos() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "modulo";//nombre de la tabla
        criterioBusqueda[1] = "tabla";//tipo de consulta
        cmbModulos.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoModulos = consulta.getCodigoCombo();
    }

    private void cargarColumnas() {
        String[] nombresColumnas = {"COLUMNA", "OPCIÓN"};

        DefaultTableModel modelo;
        DefaultTableModel modeloColumnas;

        modeloColumnas = (new DefaultTableModel(
                nombresColumnas, 0) {

                    Class[] types = new Class[]{
                        java.lang.Object.class, java.lang.Boolean.class
                    };

                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }
                });
        modelo = controladorGrid.getInstance().llenarGrid(codigoModulos.get(cmbModulos.getSelectedIndex()), "reporte", null, true);

        for (int i = 0; i < modelo.getColumnCount(); i++) {
            modeloColumnas.addRow(nombresColumnas);
            modeloColumnas.setValueAt(modelo.getColumnName(i), i, 0);
            modeloColumnas.setValueAt(false, i, 1);
        }

        jtColumnas.setModel(modeloColumnas);

    }

    private String generarQuery() {
        String sql = "select ";
        boolean flag = true;
        for (int i = 0; i < jtColumnas.getRowCount(); i++) {
            if (jtColumnas.getValueAt(i, 1).equals(true)) {
                if (flag) {
                    sql += "\"" + jtColumnas.getValueAt(i, 0).toString() + "\"";
                    flag = false;
                } else {
                    sql += ",\"" + jtColumnas.getValueAt(i, 0).toString() + "\"";
                }
            }

        }
        return sql += " from v_" + codigoModulos.get(cmbModulos.getSelectedIndex()) + "_rpt";

    }

    private void generarReporte(String query) {
        /* Map parametros = new HashMap();
         parametros.put("query", query);
         controladorReporte reporte = new controladorReporte();
         reporte.generarReporte("seguimiento_estudiante", parametros);*/

        controladorReporte reporte = new controladorReporte();
        reporte.generarReporte();

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
            java.util.logging.Logger.getLogger(frmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JComboBox<String> cmbModulos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpBusquedaAcercamiento;
    private javax.swing.JTable jtColumnas;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblRegistros3;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextField txtCriterioBusqueda;
    // End of variables declaration//GEN-END:variables
}
