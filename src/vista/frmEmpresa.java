package vista;

import controlador.ControladorEmpresa;
import controlador.controladorConsulta;
import controlador.controladorExcel;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmEmpresa extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String accion;

    ArrayList<String> codigoEmpresa = new ArrayList<>();

    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmEmpresa() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[2];
        llenarGrid();
        llenarComboTipoEmpresa();
        cargarTotalRegistros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpRegistroUsuario = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        cmbTipoEmpresa = new javax.swing.JComboBox<>();
        lblRuc = new javax.swing.JLabel();
        lblActividadEconomica = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblNombreComercial = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        txtNombreComercial1 = new javax.swing.JTextField();
        txtRazonSocial1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaActividadEconomica = new javax.swing.JTextArea();
        lblPersona5 = new javax.swing.JLabel();
        lblPersona6 = new javax.swing.JLabel();
        lblPersona7 = new javax.swing.JLabel();
        lblPersona8 = new javax.swing.JLabel();
        lblPersona9 = new javax.swing.JLabel();
        lblNombreComercial1 = new javax.swing.JLabel();
        lblRazonSocial1 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        lblPersona10 = new javax.swing.JLabel();
        lblPersona11 = new javax.swing.JLabel();
        jpBusquedaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmpresa = new javax.swing.JTable();
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
        btnNuevo1 = new javax.swing.JButton();

        setTitle("EMPRESA");
        setPreferredSize(new java.awt.Dimension(945, 575));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegistroUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroUsuario.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroUsuario.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroUsuario.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        txtRuc.setPreferredSize(new java.awt.Dimension(225, 25));
        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRucKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        cmbTipoEmpresa.setBackground(new java.awt.Color(204, 204, 255));
        cmbTipoEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbTipoEmpresa.setPreferredSize(new java.awt.Dimension(150, 25));
        jpRegistroUsuario.add(cmbTipoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 220, -1));

        lblRuc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRuc.setText("Ruc:");
        lblRuc.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblActividadEconomica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblActividadEconomica.setText("Actividad Económica:");
        lblActividadEconomica.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblActividadEconomica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        lblTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTipo.setText("Tipo:");
        lblTipo.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblNombreComercial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreComercial.setText("Nombre Comercial:");
        lblNombreComercial.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblNombreComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblRazonSocial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRazonSocial.setText("Razón Social:");
        lblRazonSocial.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtNombreComercial1.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNombreComercial1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreComercial1KeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNombreComercial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        txtRazonSocial1.setPreferredSize(new java.awt.Dimension(225, 25));
        txtRazonSocial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSocial1ActionPerformed(evt);
            }
        });
        txtRazonSocial1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRazonSocial1KeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtRazonSocial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        txaActividadEconomica.setColumns(20);
        txaActividadEconomica.setRows(3);
        txaActividadEconomica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaActividadEconomicaKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaActividadEconomica);

        jpRegistroUsuario.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        lblPersona5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona5.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona5.setText("*");
        lblPersona5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 10, -1));

        lblPersona6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona6.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona6.setText("*");
        lblPersona6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 10, -1));

        lblPersona7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona7.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona7.setText("*");
        lblPersona7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 10, -1));

        lblPersona8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona8.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona8.setText("*");
        lblPersona8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 10, -1));

        lblPersona9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona9.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona9.setText("*");
        lblPersona9.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 10, -1));

        lblNombreComercial1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreComercial1.setText("Teléfono:");
        lblNombreComercial1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblNombreComercial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lblRazonSocial1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRazonSocial1.setText("Correo:");
        lblRazonSocial1.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblRazonSocial1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        txtTelefono.setPreferredSize(new java.awt.Dimension(225, 25));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        txtCorreo.setPreferredSize(new java.awt.Dimension(225, 25));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        lblPersona10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona10.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona10.setText("*");
        lblPersona10.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 10, -1));

        lblPersona11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona11.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona11.setText("*");
        lblPersona11.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 10, -1));

        jPanel1.add(jpRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jpBusquedaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaUsuario.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(430, 420));

        jtEmpresa.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtEmpresa.setGridColor(new java.awt.Color(0, 102, 153));
        jtEmpresa.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtEmpresa.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmpresaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEmpresa);

        jpBusquedaUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 460));

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaUsuario.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaUsuario.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 280, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaUsuario.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaUsuario.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(32, 25));
        jpBusquedaUsuario.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jpBusquedaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 5, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo.setToolTipText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnCrearActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_crear_actualizar_40.png"))); // NOI18N
        btnCrearActualizar.setToolTipText("GUARDAR");
        btnCrearActualizar.setBorder(null);
        btnCrearActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrearActualizar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_eliminar_40.png"))); // NOI18N
        btnEliminar.setToolTipText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cerrar_40.png"))); // NOI18N
        btnCerrar.setToolTipText("CERRAR");
        btnCerrar.setBorder(null);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 5, 190, 50));

        btnNuevo1.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_exportar_excel_32.png"))); // NOI18N
        btnNuevo1.setToolTipText("Exportar");
        btnNuevo1.setBorder(null);
        btnNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo1.setPreferredSize(new java.awt.Dimension(48, 48));
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void jtEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpresaMouseClicked
        int fila = jtEmpresa.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarEmpresa(consultarRegistroIndividual(jtEmpresa.getValueAt(fila, 0).toString(), "empresa"));
        }
    }//GEN-LAST:event_jtEmpresaMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        filtrar();
        convertirAmayusculas(txtCriterioBusqueda);
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroUsuario);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroUsuario);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroUsuario);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyReleased
        txtRuc.setText(controladorVariablesSesion.validarNumerosConEspacios(txtRuc.getText()));
    }//GEN-LAST:event_txtRucKeyReleased

    private void txtNombreComercial1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreComercial1KeyReleased
        convertirAmayusculas(txtNombreComercial1);
    }//GEN-LAST:event_txtNombreComercial1KeyReleased

    private void txtRazonSocial1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocial1KeyReleased
        convertirAmayusculas(txtRazonSocial1);
    }//GEN-LAST:event_txtRazonSocial1KeyReleased

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRucActionPerformed

    private void txtRazonSocial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSocial1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocial1ActionPerformed

    private void txaActividadEconomicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaActividadEconomicaKeyReleased
        convertirAmayusculas(txaActividadEconomica);
    }//GEN-LAST:event_txaActividadEconomicaKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        txtTelefono.setText(controladorVariablesSesion.validarNumerosConEspacios(txtTelefono.getText()));
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo,controladorGrid.getInstance().filtrarGrid(jtEmpresa));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtEmpresa.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
    }

    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {
        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();
        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);
    }

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

    private void convertirAminusculas(javax.swing.JTextField jTextfieldS) {
        String cadena = (jTextfieldS.getText()).toLowerCase();
        jTextfieldS.setText(cadena);
    }

    private boolean crearActualizar() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", accion);
        map.put("id", lblId.getText());
        map.put("ruc", txtRuc.getText());
        map.put("nombreComercial", txtNombreComercial1.getText());
        map.put("razonSocial", txtRazonSocial1.getText());
        map.put("tipo", codigoEmpresa.get(cmbTipoEmpresa.getSelectedIndex()));
        map.put("actividadEconomica", txaActividadEconomica.getText());
        map.put("telefono", txtTelefono.getText());
        map.put("correo", txtCorreo.getText());

        //instacia el controlador
        ControladorEmpresa empresa = new ControladorEmpresa();
        //llama al metodo para crear o actualizar segun sea la accion
        return empresa.crearActualizar(map);

    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorEmpresa empresa = new ControladorEmpresa();
        empresa.eliminar(map);
    }
    
    private void filtrar() {
        RowFilter<TableModel, Object> rf;
        try {
            rf = RowFilter.regexFilter(txtCriterioBusqueda.getText(), cmbFiltro.getSelectedIndex() + 1);
            sorter.setRowFilter(rf);

        } catch (java.util.regex.PatternSyntaxException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage(), "Error Filtrar", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void formatearColumnas() {
        //Oculta la primera columna que corresponde al ID de la tabla
        jtEmpresa.getColumnModel().getColumn(0).setMaxWidth(0);
        jtEmpresa.getColumnModel().getColumn(0).setMinWidth(0);
        jtEmpresa.getColumnModel().getColumn(0).setPreferredWidth(0);

    }
    
    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        cmbTipoEmpresa.setSelectedIndex(0);
        if (component instanceof JTextField) {

            JTextField text = (JTextField) component;
            text.setText("");

        } else if (component instanceof JTextArea) {
            JTextArea textArea = (JTextArea) component;
            textArea.setText("");
        } else if (component instanceof Container) {
            for (Component c : ((Container) component).getComponents()) {
                limpiarCajasTexto(c);
            }
        }
    }

    private void llenarComboTipoEmpresa() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "NATURALEZA EMPRESA";//nombre de la tabla
        criterioBusqueda[1] = "enumeracion";//tipo de consulta
        cmbTipoEmpresa.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoEmpresa = consulta.getCodigoCombo();
    }
    
    private void llenarEmpresa(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        txtRuc.setText(String.valueOf(datos.get(1)));
        txtNombreComercial1.setText(String.valueOf(datos.get(2)));
        txtRazonSocial1.setText((String) datos.get(3));
        cmbTipoEmpresa.setSelectedItem((String) datos.get(4));
        txaActividadEconomica.setText(String.valueOf(datos.get(5)));
        txtTelefono.setText(String.valueOf(datos.get(6)));
        txtCorreo.setText(String.valueOf(datos.get(7)));

    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtEmpresa.setModel(controladorGrid.getInstance().llenarGrid("empresa", "grid", null, true));
        sorter = new TableRowSorter<>(jtEmpresa.getModel());
        jtEmpresa.setRowSorter(sorter);
        jtEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
        
        llenarFiltro();
    }

    
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify                     "> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JComboBox<String> cmbTipoEmpresa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpBusquedaUsuario;
    private javax.swing.JPanel jpRegistroUsuario;
    private javax.swing.JTable jtEmpresa;
    private javax.swing.JLabel lblActividadEconomica;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombreComercial;
    private javax.swing.JLabel lblNombreComercial1;
    private javax.swing.JLabel lblPersona10;
    private javax.swing.JLabel lblPersona11;
    private javax.swing.JLabel lblPersona5;
    private javax.swing.JLabel lblPersona6;
    private javax.swing.JLabel lblPersona7;
    private javax.swing.JLabel lblPersona8;
    private javax.swing.JLabel lblPersona9;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRazonSocial1;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaActividadEconomica;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtNombreComercial1;
    private javax.swing.JTextField txtRazonSocial1;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
