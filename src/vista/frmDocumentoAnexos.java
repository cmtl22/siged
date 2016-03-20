package vista;

import controlador.controladorArchivo;
import controlador.controladorConsulta;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public final class frmDocumentoAnexos extends javax.swing.JDialog {
    // <editor-fold defaultstate="collapsed" desc="Declaración de Variables">                          

    private String id;
    private FileInputStream[] archivos;
    private int[] tamanioArchivos;
    private TableRowSorter<TableModel> sorter;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String[] nombresArchivos;
    private int[] idArchivos;
    private String[] descripcionArchivos;

    private ResultSet resultado;
    int indice = 0;
    private int fila;
    private String[] criterioBusqueda;
// </editor-fold >                          

    public frmDocumentoAnexos(java.awt.Frame parent, boolean modal, String[] criterio) {
        super(parent, modal);
        initComponents();
        criterioBusqueda = criterio;//guarda la referencia y el tipo para consultar en la tabla documento_anexos
        init();

    }

    private void init() {
        txt_buscar.requestFocus();
        llenarGrid(criterioBusqueda);
        llenarFiltro(controladorGrid.getInstance().getNombresColmunas());
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_consulta3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtConsulta = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        txt_filtro = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        btnAbrirAnexo = new javax.swing.JButton();
        btnGuardarDescripcion = new javax.swing.JButton();
        btnAgregarAnexos = new javax.swing.JButton();
        btnDescargarAnexo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta");

        jp_consulta3.setBackground(new java.awt.Color(255, 255, 255));
        jp_consulta3.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta"));
        jp_consulta3.setPreferredSize(new java.awt.Dimension(900, 523));

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel18.setText("Buscar:");

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

        txt_buscar.setAlignmentY(0.0F);
        txt_buscar.setPreferredSize(new java.awt.Dimension(250, 25));
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        txt_filtro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnAbrirAnexo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_abrir_40.png"))); // NOI18N
        btnAbrirAnexo.setToolTipText("Visualizar");
        btnAbrirAnexo.setBorder(null);
        btnAbrirAnexo.setBorderPainted(false);
        btnAbrirAnexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrirAnexo.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAbrirAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirAnexoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrirAnexo);

        btnGuardarDescripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_crear_actualizar_40.png"))); // NOI18N
        btnGuardarDescripcion.setToolTipText("Guardar");
        btnGuardarDescripcion.setBorder(null);
        btnGuardarDescripcion.setBorderPainted(false);
        btnGuardarDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarDescripcion.setPreferredSize(new java.awt.Dimension(40, 40));
        btnGuardarDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDescripcionActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarDescripcion);

        btnAgregarAnexos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cargar_40.png"))); // NOI18N
        btnAgregarAnexos.setToolTipText("Cargar");
        btnAgregarAnexos.setBorder(null);
        btnAgregarAnexos.setBorderPainted(false);
        btnAgregarAnexos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarAnexos.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAgregarAnexos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAnexosActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarAnexos);

        btnDescargarAnexo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_descargar_40.png"))); // NOI18N
        btnDescargarAnexo.setToolTipText("Descargar");
        btnDescargarAnexo.setBorder(null);
        btnDescargarAnexo.setBorderPainted(false);
        btnDescargarAnexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescargarAnexo.setPreferredSize(new java.awt.Dimension(40, 40));
        btnDescargarAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarAnexoActionPerformed(evt);
            }
        });
        jPanel1.add(btnDescargarAnexo);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_eliminar_40.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar);

        javax.swing.GroupLayout jp_consulta3Layout = new javax.swing.GroupLayout(jp_consulta3);
        jp_consulta3.setLayout(jp_consulta3Layout);
        jp_consulta3Layout.setHorizontalGroup(
            jp_consulta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_consulta3Layout.createSequentialGroup()
                .addGroup(jp_consulta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jp_consulta3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_consulta3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jp_consulta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_consulta3Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_filtro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_consulta3Layout.setVerticalGroup(
            jp_consulta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_consulta3Layout.createSequentialGroup()
                .addGroup(jp_consulta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp_consulta3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_filtro, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_consulta3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp_consulta3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Generated Code">     
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (fila != -1) {
            if (controladorVariablesSesion.getInstance().eliminar(jtConsulta.getValueAt(fila, 0).toString()) == 0) {
               eliminar();//elimina el registro seleccionado
               llenarGrid(criterioBusqueda);
            }
                
            } else {

                JOptionPane.showMessageDialog(rootPane, "seleccione un documento");

            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAnexosActionPerformed
        cargarArchivos();
        crear();
        llenarGrid(criterioBusqueda);
    }//GEN-LAST:event_btnAgregarAnexosActionPerformed

    private void btnDescargarAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarAnexoActionPerformed

        if (fila != -1) {
            descargarArchivo();
        }
    }//GEN-LAST:event_btnDescargarAnexoActionPerformed

    private void btnAbrirAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirAnexoActionPerformed
        //visualizarArchivo();
        if (fila != -1) {
            abrirArchivo(fila);
        }
    }//GEN-LAST:event_btnAbrirAnexoActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        filtrar();
        convertirAmayusculas(txt_buscar);
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void jtConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtConsultaMouseClicked

        if (jtConsulta.getSelectedRow() != -1) {
            fila = jtConsulta.getSelectedRow();
        }
    }//GEN-LAST:event_jtConsultaMouseClicked

    private void btnGuardarDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDescripcionActionPerformed
        modificarDescripcionAnexos();
        llenarGrid(criterioBusqueda);
    }//GEN-LAST:event_btnGuardarDescripcionActionPerformed
    private void convertirAmayusculas(Component componente) {

        if (componente instanceof JTextField) {
            JTextField text = (JTextField) componente;
            String cadena = (text.getText()).toUpperCase();
            text.setText(cadena);

        } else if (componente instanceof JTextArea) {
            JTextArea textArea = (JTextArea) componente;
            String cadena = (textArea.getText()).toUpperCase();
            textArea.setText(cadena);
        }

    }
// </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">    

    public void llenarGrid(String[] criterioBusqueda) {

        jtConsulta.setModel(controladorGrid.getInstance().llenarGridAnexos("documento_anexos", "documento_anexos", criterioBusqueda));
        sorter = new TableRowSorter<>(jtConsulta.getModel());
        jtConsulta.setRowSorter(sorter);
        jtConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtConsulta.getColumnModel().getColumn(0).setMaxWidth(0);
        jtConsulta.getColumnModel().getColumn(0).setMinWidth(0);
        jtConsulta.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    private void descargarArchivo() {
        controladorArchivo controladorArchivo = new controladorArchivo();
        criterioBusqueda[0] = jtConsulta.getValueAt(fila, 0).toString();
        controladorArchivo.descargarArchivo(criterioBusqueda, "pdf");
    }

    private void crear() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", "crear");
        map.put("id", "0");
        map.put("referencia", criterioBusqueda[0]);
        map.put("descripcion", criterioBusqueda[2]);
        map.put("tipo", criterioBusqueda[1]);

        //instacia el controlador
        controladorArchivo controladorArchivo = new controladorArchivo();
        //llama al metodo para crear o actualizar segun sea la accion
        controladorArchivo.crearActualizar(map, archivos, tamanioArchivos, nombresArchivos);

    }

    private boolean modificarDescripcionAnexos() {
        idArchivos = new int[jtConsulta.getRowCount()];
        descripcionArchivos = new String[jtConsulta.getRowCount()];
        nombresArchivos = new String[jtConsulta.getRowCount()];
        for (int i = 0; i < jtConsulta.getRowCount(); i++) {
            idArchivos[i] = Integer.parseInt(jtConsulta.getValueAt(i, 0).toString());
            nombresArchivos[i] = jtConsulta.getValueAt(i, 1).toString();
            descripcionArchivos[i] = jtConsulta.getValueAt(i, 2).toString();
        }
        //instacia el controlador
        controladorArchivo controladorArchivo = new controladorArchivo();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorArchivo.modificarDescripcionAnexos(idArchivos, nombresArchivos, descripcionArchivos);

    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", jtConsulta.getValueAt(fila, 0).toString());

        controladorArchivo controladorArchivo = new controladorArchivo();
        controladorArchivo.eliminar(map);

    }

    private void abrirArchivo(int fila) {
        try {
            controladorConsulta consulta = new controladorConsulta();

            criterioBusqueda[0] = jtConsulta.getValueAt(fila, 0).toString();
            resultado = consulta.consultarDatos("documento_anexos", "filtroIndividual", criterioBusqueda);
            resultado.next();

            File file = new File("prueba.pdf");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(resultado.getBytes("docu_archivo"));
            Desktop.getDesktop().open(file);
            fos.close();

        } catch (IOException ex) {
            Logger.getLogger(frmDocumentoAnexos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmDocumentoAnexos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarArchivos() {
        controladorArchivo controladorArchivo = new controladorArchivo();
        archivos = controladorArchivo.cargarArchivos();
        if (archivos != null) {
            tamanioArchivos = controladorArchivo.getTamanioArchivos();
            nombresArchivos = controladorArchivo.getNombresArchivos();
        }
    }

    public final void cargarDatos(String[] datos) {
        try {
            modelo = controladorGrid.getInstance().llenarGrid("documento_anexos", "disponibles", null, true);
            jtConsulta.setModel(modelo);
            sorter = new TableRowSorter<>(jtConsulta.getModel());
            jtConsulta.setRowSorter(sorter);
            jtConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (HeadlessException ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error al cargar información", JOptionPane.ERROR_MESSAGE);
        }

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
// </editor-fold >    

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
            java.util.logging.Logger.getLogger(frmDocumentoAnexos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDocumentoAnexos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDocumentoAnexos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDocumentoAnexos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmDocumentoAnexos dialog = new frmDocumentoAnexos(new javax.swing.JFrame(), true, null);
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
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirAnexo;
    private javax.swing.JButton btnAgregarAnexos;
    private javax.swing.JButton btnDescargarAnexo;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarDescripcion;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jp_consulta3;
    private javax.swing.JTable jtConsulta;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JComboBox txt_filtro;
    // End of variables declaration//GEN-END:variables
// </editor-fold >    
}
