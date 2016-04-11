package vista;

import com.toedter.calendar.JDateChooser;
import controlador.ControladorCarrera;
import controlador.controladorConsulta;
import controlador.controladorExcel;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class frmCarrera extends javax.swing.JInternalFrame {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 
    //id de las claves foraneas
    Date fechaActual;
    private String idInstituto;//Foreign Key
    private String idPersona;
    private String idCoordinador;
    private String accion;//para saber si estoy creando o actualizando (crear, actualizar)
    private String[] criterioBusqueda;
    private TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmCarrera() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        idInstituto = "-1";
        idPersona = "-1";
        criterioBusqueda = new String[3];
        fechaActual = new Date();
        dtFecha.setDate(fechaActual);
        llenarGrid();
        cargarTotalRegistros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBusquedaCarrera = new javax.swing.JLabel();
        lblRegistroCarrera = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jpBusquedaAsignatura = new javax.swing.JPanel();
        lblFiltro = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros3 = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtCarrera = new javax.swing.JTable();
        jpRegistroCarrera = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        dtFecha = new com.toedter.calendar.JDateChooser();
        lblDescripcion = new javax.swing.JLabel();
        txtNumeroResolucion = new javax.swing.JTextField();
        txaInstituto = new javax.swing.JLabel();
        lblCarrera = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblTitulo_Id3 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnInstituto = new javax.swing.JButton();
        lblInstituto1 = new javax.swing.JLabel();
        txtCoordinador = new javax.swing.JTextField();
        btnCoordinador = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        lblInstituto2 = new javax.swing.JLabel();
        btnNuevo1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("CARRERA");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_carrera_24.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(950, 605));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBusquedaCarrera.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusquedaCarrera.setText("BÚSQUEDA");
        jPanel1.add(lblBusquedaCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        lblRegistroCarrera.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistroCarrera.setText("REGISTRO");
        jPanel1.add(lblRegistroCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 50));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo");
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
        btnCrearActualizar.setToolTipText("Guardar");
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
        btnEliminar.setToolTipText("Eliminar");
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
        btnAdjuntarAnexos.setToolTipText("Nuevo");
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
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBorder(null);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

        jpBusquedaAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaAsignatura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaAsignatura.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaAsignatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaAsignatura.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
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
        jpBusquedaAsignatura.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 270, -1));

        lblRegistros3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros3.setText("Registros:");
        lblRegistros3.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaAsignatura.add(lblRegistros3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaAsignatura.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        jtCarrera.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCarrera.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtCarrera.setGridColor(new java.awt.Color(0, 102, 153));
        jtCarrera.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtCarrera.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCarreraMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtCarrera);

        jpBusquedaAsignatura.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 440, 460));

        jPanel1.add(jpBusquedaAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        jpRegistroCarrera.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroCarrera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroCarrera.setMinimumSize(new java.awt.Dimension(0, 0));
        jpRegistroCarrera.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroCarrera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNumero.setText("Número de Resolución:");
        jpRegistroCarrera.add(lblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        dtFecha.setBackground(new java.awt.Color(225, 240, 225));
        dtFecha.setDateFormatString("yyyy-MM-dd");
        dtFecha.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroCarrera.add(dtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDescripcion.setText("Descripción Carrera:");
        jpRegistroCarrera.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, -1));

        txtNumeroResolucion.setPreferredSize(new java.awt.Dimension(250, 25));
        txtNumeroResolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroResolucionActionPerformed(evt);
            }
        });
        txtNumeroResolucion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroResolucionKeyReleased(evt);
            }
        });
        jpRegistroCarrera.add(txtNumeroResolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        txaInstituto.setForeground(new java.awt.Color(51, 51, 51));
        txaInstituto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txaInstituto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txaInstituto.setMaximumSize(new java.awt.Dimension(250, 60));
        txaInstituto.setMinimumSize(new java.awt.Dimension(0, 0));
        txaInstituto.setPreferredSize(new java.awt.Dimension(250, 60));
        jpRegistroCarrera.add(txaInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        lblCarrera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCarrera.setText("Nombre de Carrera:");
        jpRegistroCarrera.add(lblCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtNombre.setPreferredSize(new java.awt.Dimension(250, 25));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        jpRegistroCarrera.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFecha.setText("Fecha de Aprobación:");
        jpRegistroCarrera.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 10));

        lblTitulo_Id3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id3.setText("Id:");
        lblTitulo_Id3.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroCarrera.add(lblTitulo_Id3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroCarrera.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        btnInstituto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnInstituto.setToolTipText("Buscar");
        btnInstituto.setBorder(null);
        btnInstituto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInstituto.setPreferredSize(new java.awt.Dimension(40, 40));
        btnInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstitutoActionPerformed(evt);
            }
        });
        jpRegistroCarrera.add(btnInstituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        lblInstituto1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblInstituto1.setText("Instituto:");
        jpRegistroCarrera.add(lblInstituto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        txtCoordinador.setEditable(false);
        txtCoordinador.setPreferredSize(new java.awt.Dimension(250, 25));
        txtCoordinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoordinadorActionPerformed(evt);
            }
        });
        jpRegistroCarrera.add(txtCoordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        btnCoordinador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnCoordinador.setToolTipText("Buscar");
        btnCoordinador.setBorder(null);
        btnCoordinador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCoordinador.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCoordinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoordinadorActionPerformed(evt);
            }
        });
        jpRegistroCarrera.add(btnCoordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");
        jpRegistroCarrera.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 10, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jpRegistroCarrera.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 10, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("*");
        jpRegistroCarrera.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 10, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*");
        jpRegistroCarrera.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 10, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("*");
        jpRegistroCarrera.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 10, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jpRegistroCarrera.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 10, -1));

        txaDescripcion.setColumns(20);
        txaDescripcion.setLineWrap(true);
        txaDescripcion.setRows(3);
        txaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaDescripcionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txaDescripcion);

        jpRegistroCarrera.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 250, 60));

        lblInstituto2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblInstituto2.setText("Coordinador:");
        jpRegistroCarrera.add(lblInstituto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jPanel1.add(jpRegistroCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        btnNuevo1.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_exportar_excel_32.png"))); // NOI18N
        btnNuevo1.setToolTipText("Exportar");
        btnNuevo1.setBorder(null);
        btnNuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo1.setPreferredSize(new java.awt.Dimension(40, 40));
        btnNuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 // <editor-fold defaultstate="collapsed" desc="Eventos">     
    private void txtNumeroResolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroResolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroResolucionActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstitutoActionPerformed
        buscar("instituto");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarInstituto(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "instituto"));
    }//GEN-LAST:event_btnInstitutoActionPerformed

    private void txtCriterioBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaActionPerformed

    private void txtCriterioBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaKeyPressed

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void jtCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCarreraMouseClicked
        int fila = jtCarrera.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarCarrera(consultarRegistroIndividual(jtCarrera.getValueAt(fila, 0).toString(), "carrera"));
        }
    }//GEN-LAST:event_jtCarreraMouseClicked

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroCarrera);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed
    }
    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroCarrera);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroCarrera);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        txtNombre.setText(controladorVariablesSesion.validarLetrasConEspacios(txtNombre.getText()));
        convertirAmayusculas(txtNombre);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        int fila = jtCarrera.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtCarrera.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "C";//tipo de documento anexo
            criterioBusqueda[2] = "Resolucion Carrera";//descripcion de los anexos
            frmDocumentoAnexos frm = new frmDocumentoAnexos(null, true, criterioBusqueda);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Documento", "Seleccionar", 2);
        }
    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void txtNumeroResolucionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroResolucionKeyReleased
        convertirAmayusculas(txtNumeroResolucion);
    }//GEN-LAST:event_txtNumeroResolucionKeyReleased

    private void txtCoordinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoordinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoordinadorActionPerformed

    private void btnCoordinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoordinadorActionPerformed
        buscar("coordinador");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarCoordinador(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona"));
    }//GEN-LAST:event_btnCoordinadorActionPerformed

    private void txaDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaDescripcionKeyReleased
        convertirAmayusculas(txaDescripcion);
    }//GEN-LAST:event_txaDescripcionKeyReleased

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo,controladorGrid.getInstance().filtrarGrid(jtCarrera));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    // </editor-fold>     
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tipo) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar(tipo, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtCarrera.getRowCount();
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
        map.put("idInstituto", idInstituto);
        map.put("idPersona", idPersona);
        map.put("nombre", txtNombre.getText());
        map.put("descripcion", txaDescripcion.getText());
        map.put("fecha", dateToString(dtFecha));
        map.put("numeroResolucion", txtNumeroResolucion.getText());

        //instacia el controlador
        ControladorCarrera controladorCarrera = new ControladorCarrera();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorCarrera.crearActualizar(map);

    }

    private String dateToString(JDateChooser fecha) {
        Date fechaNacimiento;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        if (fecha.getDate() != null) {
            fechaNacimiento = fecha.getDate();
        } else {
            Date fechActual = new Date();
            fechaNacimiento = fechActual;
        }
        return formatoFecha.format(fechaNacimiento);
    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", lblId.getText());

        ControladorCarrera controladorAsignatura = new ControladorCarrera();
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
        jtCarrera.getColumnModel().getColumn(0).setMaxWidth(0);
        jtCarrera.getColumnModel().getColumn(0).setMinWidth(0);
        jtCarrera.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        idCoordinador="-1";
        idInstituto="-1";
        txaInstituto.setText("");
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

    private void llenarCarrera(ArrayList<Object> datos) {
        txaInstituto.setText("<html>" + String.valueOf(datos.get(2) + "</html>"));
        lblId.setText(String.valueOf(datos.get(0)));
        idInstituto = (String.valueOf(datos.get(1)));
        txaInstituto.setText("<html>" + String.valueOf(datos.get(2) + "</html>"));
        txtCoordinador.setText(String.valueOf(datos.get(3) + " " + String.valueOf(datos.get(4))));
        txtNombre.setText((String) datos.get(5));
        txaDescripcion.setText((String) datos.get(6));
        dtFecha.setDate(stringToJDateChooser((String) datos.get(7)));
        txtNumeroResolucion.setText((String) datos.get(8));
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtCarrera.setModel(controladorGrid.getInstance().llenarGrid("carrera", "grid", null, true));
        sorter = new TableRowSorter<>(jtCarrera.getModel());
        jtCarrera.setRowSorter(sorter);
        jtCarrera.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
        llenarFiltro();
    }

    private void llenarInstituto(ArrayList<Object> datos) {
        idInstituto = (String.valueOf(datos.get(0)));
        txaInstituto.setText(String.valueOf("<html>"+datos.get(4)+"</html>"));

    }

    private void llenarCoordinador(ArrayList<Object> datos) {
        idPersona = (String.valueOf(datos.get(0)));
        txtCoordinador.setText(String.valueOf(datos.get(2)) + " " + String.valueOf(datos.get(1)));
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

    //</editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Variables declaration"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntarAnexos;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCoordinador;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInstituto;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JComboBox cmbFiltro;
    private com.toedter.calendar.JDateChooser dtFecha;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpBusquedaAsignatura;
    private javax.swing.JPanel jpRegistroCarrera;
    private javax.swing.JTable jtCarrera;
    private javax.swing.JLabel lblBusquedaCarrera;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblInstituto1;
    private javax.swing.JLabel lblInstituto2;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRegistroCarrera;
    private javax.swing.JLabel lblRegistros3;
    private javax.swing.JLabel lblTitulo_Id3;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaDescripcion;
    private javax.swing.JLabel txaInstituto;
    private javax.swing.JTextField txtCoordinador;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroResolucion;
    // End of variables declaration//GEN-END:variables
//</editor-fold> 
}
