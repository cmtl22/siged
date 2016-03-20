package vista;

import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmConsultas extends javax.swing.JDialog {

    private TableRowSorter<TableModel> sorter;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String[] datosTemporales;

    String[] nombresColmunas;

    public frmConsultas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        datosTemporales = new String[3];
        txt_buscar.requestFocus();

        //Inahblita el boton cerrar
        this.setResizable(false);
        //setDefaultCloseOperation(0);
        this.setLocationRelativeTo(null);

    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recursos/ico_sistema.jpg"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_consulta3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtConsulta = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        txt_filtro = new javax.swing.JComboBox();
        lblFiltro = new javax.swing.JLabel();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta");

        jp_consulta3.setBackground(new java.awt.Color(255, 255, 255));
        jp_consulta3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jp_consulta3.setPreferredSize(new java.awt.Dimension(900, 523));
        jp_consulta3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"asd", "asd", "asd", "asd"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtConsulta.setSelectionBackground(new java.awt.Color(204, 255, 204));
        jtConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtConsultaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtConsulta);

        jp_consulta3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 59, 730, 320));

        txt_buscar.setAlignmentY(0.0F);
        txt_buscar.setMinimumSize(new java.awt.Dimension(0, 0));
        txt_buscar.setPreferredSize(new java.awt.Dimension(500, 25));
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        jp_consulta3.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 530, -1));

        txt_filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_filtro.setPreferredSize(new java.awt.Dimension(150, 25));
        jp_consulta3.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(32, 25));
        jp_consulta3.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jp_consulta3.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jp_consulta3.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jp_consulta3, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_consulta3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void consultar(String tabla, String tipo, String[] criterioBusqueda) {
        jtConsulta.setModel(controladorGrid.getInstance().llenarGrid(tabla, tipo, criterioBusqueda, true));
        sorter = new TableRowSorter<>(jtConsulta.getModel());
        jtConsulta.setRowSorter(sorter);
        jtConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        llenarFiltro(controladorGrid.getInstance().getNombresColmunas());
        formatearColumnas();
        cargarTotalRegistros();
    }

    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtConsulta.getColumnModel().getColumn(0).setMaxWidth(0);
        jtConsulta.getColumnModel().getColumn(0).setMinWidth(0);
        jtConsulta.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    private void jtConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtConsultaMouseClicked
        guardarConsulta();
    }//GEN-LAST:event_jtConsultaMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        convertirAmayusculas(txt_buscar);
        filtrar();
    }//GEN-LAST:event_txt_buscarKeyReleased
    private void guardarConsulta() {
        if (jtConsulta.getSelectedRow() != -1) {
            controladorVariablesSesion.getInstance().setDatosTemporalesConsulta(jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 0).toString());
            //datosTemporales[0] = jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 0).toString();
            //datosTemporales[1] = jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 1).toString();
            //datosTemporales[2] = jtConsulta.getValueAt(jtConsulta.getSelectedRow(), 2).toString();
            controladorVariablesSesion.getInstance().setDatosConsulta(datosTemporales);
        }
        this.dispose();
    }

    private void convertirAmayusculas(javax.swing.JTextField jTextfieldS) {
        String cadena = (jTextfieldS.getText()).toUpperCase();
        jTextfieldS.setText(cadena);
    }

    private void cargarTotalRegistros() {
        int total = jtConsulta.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
    }

    private void filtrar() {
        RowFilter<TableModel, Object> rf = null;
        int indiceColumnaTabla = txt_filtro.getSelectedIndex() + 1;

        try {
            rf = RowFilter.regexFilter(txt_buscar.getText(), indiceColumnaTabla);
        } catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter.setRowFilter(rf);

    }

    private void llenarFiltro(String[] datos) {
        for (int i = 1; i < datos.length; i++) {
            txt_filtro.addItem(datos[i]);
        }
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
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmConsultas dialog = new frmConsultas(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jp_consulta3;
    private javax.swing.JTable jtConsulta;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JComboBox txt_filtro;
    // End of variables declaration//GEN-END:variables
}
