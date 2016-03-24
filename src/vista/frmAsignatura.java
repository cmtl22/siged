package vista;

import controlador.ControladorAsignatura;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class frmAsignatura extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 
    //id de las claves foraneas

    private String idCarrera;//Foreign Key

    private String accion;//para saber si estoy creando o actualizando (crear, actualizar)
    private String[] criterioBusqueda;
    private TableRowSorter<TableModel> sorter;
// </editor-fold> 

    public frmAsignatura() {
        initComponents();
        accion = "crear";
        idCarrera = "-1";
        criterioBusqueda = new String[2];
        llenarGrid();
        llenarFiltro();
        cargarTotalRegistros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBusqueda = new javax.swing.JLabel();
        jpBusquedaAsignatura = new javax.swing.JPanel();
        lblFiltro = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox();
        txtCriterioBusqueda = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtAsignatura = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        lblRegistros3 = new javax.swing.JLabel();
        btnNuevo1 = new javax.swing.JButton();
        lblRegistro = new javax.swing.JLabel();
        jpRegistroAsignatura = new javax.swing.JPanel();
        lblCarrera = new javax.swing.JLabel();
        lblNombreAsignatura = new javax.swing.JLabel();
        lblResultadoAprendizaje = new javax.swing.JLabel();
        lblEquipamiento = new javax.swing.JLabel();
        lblSimilitud = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txaSimilitud = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txaEquipamiento = new javax.swing.JTextArea();
        txtCarrera = new javax.swing.JTextField();
        txtNombreAsignatura = new javax.swing.JTextField();
        btnCarrera = new javax.swing.JButton();
        lblTitulo_Id3 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaResultadoAprendizaje = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("ASIGNATURA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_asignatura_32.jpg"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(945, 535));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        jpBusquedaAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaAsignatura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaAsignatura.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaAsignatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaAsignatura.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpBusquedaAsignatura.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, 23));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioBusquedaActionPerformed(evt);
            }
        });
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaAsignatura.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 10, 200, -1));

        jtAsignatura.setModel(new javax.swing.table.DefaultTableModel(
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
        jtAsignatura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtAsignatura.setGridColor(new java.awt.Color(0, 102, 153));
        jtAsignatura.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtAsignatura.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAsignaturaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtAsignatura);

        jpBusquedaAsignatura.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 410));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaAsignatura.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        lblRegistros3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros3.setText("Registros:");
        lblRegistros3.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaAsignatura.add(lblRegistros3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

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
        jpBusquedaAsignatura.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 40, 40));

        jPanel1.add(jpBusquedaAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jpRegistroAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroAsignatura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroAsignatura.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroAsignatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCarrera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCarrera.setText("Carrera :");
        jpRegistroAsignatura.add(lblCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblNombreAsignatura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNombreAsignatura.setText("Nombre Asignatura:");
        jpRegistroAsignatura.add(lblNombreAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblResultadoAprendizaje.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResultadoAprendizaje.setText("Resultado Aprendizaje:");
        jpRegistroAsignatura.add(lblResultadoAprendizaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, -1));

        lblEquipamiento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEquipamiento.setText("Equipamiento:");
        jpRegistroAsignatura.add(lblEquipamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lblSimilitud.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblSimilitud.setText("Similitud:");
        jpRegistroAsignatura.add(lblSimilitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        txaSimilitud.setColumns(2);
        txaSimilitud.setLineWrap(true);
        txaSimilitud.setRows(3);
        txaResultadoAprendizaje.setLineWrap(true);
        txaSimilitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaSimilitudKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(txaSimilitud);

        jpRegistroAsignatura.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 243, 70));

        txaEquipamiento.setColumns(2);
        txaEquipamiento.setLineWrap(true);
        txaEquipamiento.setRows(3);
        txaResultadoAprendizaje.setLineWrap(true);
        txaEquipamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaEquipamientoKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(txaEquipamiento);

        jpRegistroAsignatura.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 243, 70));

        txtCarrera.setEditable(false);
        txtCarrera.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarreraActionPerformed(evt);
            }
        });
        jpRegistroAsignatura.add(txtCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 240, -1));

        txtNombreAsignatura.setPreferredSize(new java.awt.Dimension(6, 25));
        txtNombreAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreAsignaturaActionPerformed(evt);
            }
        });
        txtNombreAsignatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreAsignaturaKeyReleased(evt);
            }
        });
        jpRegistroAsignatura.add(txtNombreAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 240, -1));

        btnCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnCarrera.setToolTipText("Buscar");
        btnCarrera.setBorder(null);
        btnCarrera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarrera.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarreraActionPerformed(evt);
            }
        });
        jpRegistroAsignatura.add(btnCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        lblTitulo_Id3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id3.setText("Id:");
        lblTitulo_Id3.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroAsignatura.add(lblTitulo_Id3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroAsignatura.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");
        jpRegistroAsignatura.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 10, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");
        jpRegistroAsignatura.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 10, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jpRegistroAsignatura.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 10, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");
        jpRegistroAsignatura.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 10, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");
        jpRegistroAsignatura.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 10, -1));

        txaResultadoAprendizaje.setColumns(2);
        txaResultadoAprendizaje.setLineWrap(true);
        txaResultadoAprendizaje.setRows(3);
        txaResultadoAprendizaje.setLineWrap(true);
        txaResultadoAprendizaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaResultadoAprendizajeKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaResultadoAprendizaje);

        jpRegistroAsignatura.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 243, 70));

        jPanel1.add(jpRegistroAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(225, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo.setToolTipText("LIMPIAR");
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setPreferredSize(new java.awt.Dimension(40, 40));
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
        btnCrearActualizar.setPreferredSize(new java.awt.Dimension(40, 40));
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
        btnEliminar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);

        btnAdjuntarAnexos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_adjuntar_40.jpg"))); // NOI18N
        btnAdjuntarAnexos.setToolTipText("ADJUNTAR");
        btnAdjuntarAnexos.setBorder(null);
        btnAdjuntarAnexos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdjuntarAnexos.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAdjuntarAnexos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjuntarAnexosActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdjuntarAnexos);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cerrar_40.png"))); // NOI18N
        btnCerrar.setToolTipText("CERRAR");
        btnCerrar.setBorder(null);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarreraActionPerformed
        buscar("carrera");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarCarrera(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "carrera"));
    }//GEN-LAST:event_btnCarreraActionPerformed

    private void txtNombreAsignaturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAsignaturaKeyReleased
        convertirAmayusculas(txtNombreAsignatura);
    }//GEN-LAST:event_txtNombreAsignaturaKeyReleased

    private void txtNombreAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreAsignaturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreAsignaturaActionPerformed

    private void txtCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarreraActionPerformed

    private void txaEquipamientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaEquipamientoKeyReleased
        convertirAmayusculas(txaEquipamiento);
    }//GEN-LAST:event_txaEquipamientoKeyReleased

    private void txaSimilitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaSimilitudKeyReleased
        convertirAmayusculas(txaSimilitud);
    }//GEN-LAST:event_txaSimilitudKeyReleased

    private void txaResultadoAprendizajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaResultadoAprendizajeKeyReleased
        convertirAmayusculas(txaResultadoAprendizaje);
    }//GEN-LAST:event_txaResultadoAprendizajeKeyReleased

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        int fila = jtAsignatura.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtAsignatura.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "";
            frmDocumentoAnexos frm = new frmDocumentoAnexos(null, true, criterioBusqueda);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroAsignatura);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed
    }
    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroAsignatura);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroAsignatura);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jtAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAsignaturaMouseClicked
        int fila = jtAsignatura.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarAsignatura(consultarRegistroIndividual(jtAsignatura.getValueAt(fila, 0).toString(), "asignatura"));
        }
    }//GEN-LAST:event_jtAsignaturaMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void txtCriterioBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaKeyPressed

    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void txtCriterioBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaActionPerformed

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo,controladorGrid.getInstance().filtrarGrid(jtAsignatura));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed
    
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtAsignatura.getRowCount();
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

    private boolean crearActualizar() {
        Map<String, Object> map = new HashMap<>();
        //llena las variables de tipo map con los valores de las cajas de texto
        map.put("accion", accion);
        map.put("id", lblId.getText());
        map.put("idCarrera", idCarrera);
        map.put("nombre", txtNombreAsignatura.getText());
        map.put("resultadoAprendizaje", txaResultadoAprendizaje.getText());
        map.put("equipamiento", txaEquipamiento.getText());
        map.put("similitud", txaSimilitud.getText());

        //instacia el controlador
        ControladorAsignatura controladorAsignatura = new ControladorAsignatura();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorAsignatura.crearActualizar(map);

    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorAsignatura controladorAsignatura = new ControladorAsignatura();
        controladorAsignatura.eliminar(map);

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
        jtAsignatura.getColumnModel().getColumn(0).setMaxWidth(0);
        jtAsignatura.getColumnModel().getColumn(0).setMinWidth(0);
        jtAsignatura.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
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

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtAsignatura.setModel(controladorGrid.getInstance().llenarGrid("asignatura", "grid", null, true));
        sorter = new TableRowSorter<>(jtAsignatura.getModel());
        jtAsignatura.setRowSorter(sorter);
        jtAsignatura.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarAsignatura(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idCarrera = (String.valueOf(datos.get(1)));
        txtCarrera.setText(String.valueOf(datos.get(2)));
        txtNombreAsignatura.setText((String) datos.get(3));
        txaResultadoAprendizaje.setText((String) datos.get(4));
        txaEquipamiento.setText((String) datos.get(5));
        txaSimilitud.setText((String) datos.get(6));
    }

    private void llenarCarrera(ArrayList<Object> datos) {
        idCarrera = (String.valueOf(datos.get(0)));
        txtCarrera.setText(String.valueOf(datos.get(3)));

    }

// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify "> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntarAnexos;
    private javax.swing.JButton btnCarrera;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JComboBox cmbFiltro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPanel jpBusquedaAsignatura;
    private javax.swing.JPanel jpRegistroAsignatura;
    private javax.swing.JTable jtAsignatura;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblEquipamiento;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombreAsignatura;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros3;
    private javax.swing.JLabel lblResultadoAprendizaje;
    private javax.swing.JLabel lblSimilitud;
    private javax.swing.JLabel lblTitulo_Id3;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaEquipamiento;
    private javax.swing.JTextArea txaResultadoAprendizaje;
    private javax.swing.JTextArea txaSimilitud;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtNombreAsignatura;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
