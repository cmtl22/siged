package vista;

import controlador.ControladorRol;
import controlador.controladorConsulta;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmAsignarPermisos extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String accion;
    private String[] criterioBusqueda;
    private ArrayList<Object> modulos;
    private ArrayList<Object> permisos;
    private TableRowSorter<TableModel> sorterRol;
    private TableRowSorter<TableModel> sorterPermisos;
// </editor-fold > 

    public frmAsignarPermisos() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[2];
        modulos = new ArrayList<>();
        llenarGrid();
        llenarFiltro();
        llenarGridModulos();

        cargarTotalRegistros();
        vaciarModulos();

    }

    private void vaciarModulos() {
        for (int i = 0; i < jtModulos.getRowCount(); i++) {
            jtModulos.setValueAt(false, i, 2);
        }
    }

    private void seleccionarTodos() {
        for (int i = 0; i < jtModulos.getRowCount(); i++) {
            if (chbSeleccionarTodos.isSelected()) {
                chbSeleccionarTodos.setText("Deseleccionar todos");
                jtModulos.setValueAt(true, i, 2);
            } else {
                jtModulos.setValueAt(false, i, 2);
                chbSeleccionarTodos.setText("Seleccionar todos");
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpRegistroPermisos = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNombreRol = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtModulos = new javax.swing.JTable();
        chbSeleccionarTodos = new javax.swing.JCheckBox();
        jpBusquedaRol = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRol = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        lblBusqueda = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("ASIGNAR PERMISOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_permisos_32 (2).png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(945, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegistroPermisos.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroPermisos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroPermisos.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroPermisos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroPermisos.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroPermisos.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        lblNombreRol.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreRol.setText("Ingrese Rol:");
        lblNombreRol.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroPermisos.add(lblNombreRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, -1));

        txtRol.setPreferredSize(new java.awt.Dimension(225, 25));
        txtRol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRolKeyReleased(evt);
            }
        });
        jpRegistroPermisos.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, -1));

        jtModulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtModulos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtModulos.setGridColor(new java.awt.Color(0, 102, 153));
        jtModulos.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtModulos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtModulos.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jtModulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtModulosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtModulos);

        jpRegistroPermisos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 450, 420));

        chbSeleccionarTodos.setText("Seleccionar Todos");
        chbSeleccionarTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chbSeleccionarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbSeleccionarTodosActionPerformed(evt);
            }
        });
        jpRegistroPermisos.add(chbSeleccionarTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 150, -1));

        jPanel1.add(jpRegistroPermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jpBusquedaRol.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaRol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaRol.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaRol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtRol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtRol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtRol.setGridColor(new java.awt.Color(0, 102, 153));
        jtRol.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtRol.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtRolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtRol);

        jpBusquedaRol.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 440, 440));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaRol.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 120, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaRol.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 240, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaRol.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaRol.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(32, 25));
        jpBusquedaRol.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jpBusquedaRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BUSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnCrearActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_crear_actualizar_40.png"))); // NOI18N
        btnCrearActualizar.setToolTipText("Guardar");
        btnCrearActualizar.setBorder(null);
        btnCrearActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrearActualizar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_eliminar_40.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cerrar_40.png"))); // NOI18N
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBorder(null);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 5, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void jtRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtRolMouseClicked
        int fila = jtRol.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        lblNombreRol.setText("Rol:");
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarRol(consultarRegistroIndividual(jtRol.getValueAt(fila, 0).toString(), "rol"));
        }
    }//GEN-LAST:event_jtRolMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAMayusculas(txtCriterioBusqueda);
        filtrar();
        cargarTotalRegistros();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        lblNombreRol.setText("Ingrese Rol:");
        limpiarCajasTexto(jpRegistroPermisos);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed

        if (almacenarPermisos()) {
            if (crearActualizar()) {
                limpiarCajasTexto(jpRegistroPermisos);
                llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
                cargarTotalRegistros();//carga el total de registros
            }
            //crea o actualiza segun la accion designada
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un módluo al menos");
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        accion = "crear";
        eliminar();//elimina el registro seleccionado
        llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
        limpiarCajasTexto(jpRegistroPermisos);//limpia las cajas de texto
        cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void jtModulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtModulosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtModulosMouseClicked

    private void txtRolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRolKeyReleased
        convertirAMayusculas(txtRol);
    }//GEN-LAST:event_txtRolKeyReleased

    private void chbSeleccionarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbSeleccionarTodosActionPerformed
        seleccionarTodos();
    }//GEN-LAST:event_chbSeleccionarTodosActionPerformed
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private boolean almacenarPermisos() {
        boolean bandera = false;
        modulos.removeAll(modulos);

        for (int i = 0; i < jtModulos.getRowCount(); i++) {
            if (jtModulos.getValueAt(i, 2).equals(true)) {
                modulos.add(jtModulos.getValueAt(i, 0));
                bandera = true;
            }
        }
        return bandera;

    }

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtRol.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
    }

    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
    }

    private void convertirAMayusculas(javax.swing.JTextField jTextfieldS) {
        String cadena = (jTextfieldS.getText()).toUpperCase();
        jTextfieldS.setText(cadena);
    }

    private boolean crearActualizar() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", accion);
        map.put("id", lblId.getText());
        map.put("nombreRol", txtRol.getText());

        //instacia el controlador
        ControladorRol controladorRol = new ControladorRol();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorRol.crearActualizar(map, modulos);

    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorRol controladorRol = new ControladorRol();
        controladorRol.eliminar(map);
    }

    private void filtrar() {
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(txtCriterioBusqueda.getText(), cmbFiltro.getSelectedIndex() + 1);
            sorterRol.setRowFilter(rf);

        } catch (java.util.regex.PatternSyntaxException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Error Filtrar", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtRol.getColumnModel().getColumn(0).setMaxWidth(0);
        jtRol.getColumnModel().getColumn(0).setMinWidth(0);
        jtRol.getColumnModel().getColumn(0).setPreferredWidth(0);

        jtModulos.getColumnModel().getColumn(0).setMaxWidth(0);
        jtModulos.getColumnModel().getColumn(0).setMinWidth(0);
        jtModulos.getColumnModel().getColumn(0).setPreferredWidth(0);

        jtModulos.getColumnModel().getColumn(3).setMaxWidth(0);
        jtModulos.getColumnModel().getColumn(3).setMinWidth(0);
        jtModulos.getColumnModel().getColumn(3).setPreferredWidth(0);

    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        vaciarModulos();
        chbSeleccionarTodos.setSelected(false);
        chbSeleccionarTodos.setText("Selecionar Todos");
        if (component instanceof JTextField) {

            JTextField text = (JTextField) component;
            text.setText("");

        } else if (component instanceof Container) {
            for (Component c : ((Container) component).getComponents()) {
                limpiarCajasTexto(c);
            }
        }
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtRol.setModel(controladorGrid.getInstance().llenarGrid("rol", "grid", null, true));
        sorterRol = new TableRowSorter<>(jtRol.getModel());
        jtRol.setRowSorter(sorterRol);
        jtRol.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarGridModulos() {
        criterioBusqueda[0] = "0";
        jtModulos.setModel(controladorGrid.getInstance().llenarGridPermisos("modulo", "grid", criterioBusqueda));
        sorterPermisos = new TableRowSorter<>(jtModulos.getModel());
        jtModulos.setRowSorter(sorterPermisos);
        jtModulos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarRol(ArrayList<Object> datos) {
        vaciarModulos();
        lblId.setText(String.valueOf(datos.get(0)));
        txtRol.setText((String) datos.get(1));
        criterioBusqueda[0] = datos.get(0).toString();
        controladorConsulta consulta = new controladorConsulta();
        permisos = consulta.obtenerConsultaVarios("permisos", controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);

        for (int i = 0; i < jtModulos.getRowCount(); i++) {
            for (int j = 0; j < permisos.size(); j++) {
                if (jtModulos.getValueAt(i, 0).equals(permisos.get(j))) {
                    jtModulos.setValueAt(true, i, 2);
                }
            }

        }

    }
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify                     "> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JCheckBox chbSeleccionarTodos;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpBusquedaRol;
    private javax.swing.JPanel jpRegistroPermisos;
    private javax.swing.JTable jtModulos;
    private javax.swing.JTable jtRol;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombreRol;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtRol;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
