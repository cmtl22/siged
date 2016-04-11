package vista;

import com.toedter.calendar.JDateChooser;
import controlador.ControladorSeguimientoReunion;
import controlador.controladorConsulta;
import controlador.controladorExcel;
import controlador.controladorGrid;
import controlador.controladorVariablesSesion;
import java.awt.Component;
import java.awt.Container;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static vista.frmCronograma.cmbPeriodo;

public class frmSeguimientoReunion extends javax.swing.JInternalFrame {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 
    //id de las claves foraneas//Foreign Key
    Date fechaActual;
    private String idTutorEmpresarial = "-1";
    private String accion = "crear";//para saber si estoy creando o actualizando (crear, actualizar)
    private String[] criterioBusqueda;
    private String tipo_consulta;
    TableRowSorter<TableModel> sorter;

    ArrayList<String> codigoPeriodo = new ArrayList<>();

    DefaultListModel modelo = new DefaultListModel();
    FileInputStream[] archivos;
    int[] tamanioArchivos;
    // </editor-fold > 

    public frmSeguimientoReunion() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[3];
        fechaActual = new Date();
        dtFechaReunion.setDate(fechaActual);
        tipo_consulta = "seguimiento_reunion";
        llenarComboPeriodos();
        cargarTotalRegistros();
        if (controladorVariablesSesion.getInstance().getPerfilUsuario().equals("1")) {
            cmbPeriodo.setEnabled(true);
            tipo_consulta = "seguimiento_reunion_admin";
            llenarGrid(tipo_consulta);
        } else {
            tipo_consulta="seguimiento_reunion";
            llenarGrid(tipo_consulta);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpRegistroSeguimientoReunion3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpRegistroSeguimientoReunion = new javax.swing.JPanel();
        lblPeriodo = new javax.swing.JLabel();
        lblParticipante = new javax.swing.JLabel();
        lblFechaReunion = new javax.swing.JLabel();
        lblMotivoReunion = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaMotivoReunion = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        dtFechaReunion = new com.toedter.calendar.JDateChooser();
        lblTutorEmpresarial = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox();
        txtCedula = new javax.swing.JTextField();
        txtParticipante = new javax.swing.JTextField();
        txtNombresApellidos = new javax.swing.JTextField();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnTutorEmpresarial = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jpBusquedaSeguimientoReunion = new javax.swing.JPanel();
        lblFiltro = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistrosActuales = new javax.swing.JLabel();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSeguimientoReunion = new javax.swing.JTable();
        lblBusqueda = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();

        setTitle("SEGUIMIENTO REUNIÓN");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_reunion_32.jpg"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(945, 535));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegistroSeguimientoReunion3.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroSeguimientoReunion3.setForeground(new java.awt.Color(255, 255, 255));
        jpRegistroSeguimientoReunion3.setAutoscrolls(true);
        jpRegistroSeguimientoReunion3.setPreferredSize(new java.awt.Dimension(945, 575));
        jpRegistroSeguimientoReunion3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpRegistroSeguimientoReunion3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 476, -1, -1));

        jpRegistroSeguimientoReunion.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroSeguimientoReunion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroSeguimientoReunion.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroSeguimientoReunion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPeriodo.setText("Período :");
        jpRegistroSeguimientoReunion.add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblParticipante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblParticipante.setText("Participante:");
        jpRegistroSeguimientoReunion.add(lblParticipante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblFechaReunion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaReunion.setText("Fecha Reunión:");
        jpRegistroSeguimientoReunion.add(lblFechaReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        lblMotivoReunion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMotivoReunion.setText("Motivo Reunión:");
        jpRegistroSeguimientoReunion.add(lblMotivoReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        lblObservaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObservaciones.setText("Observaciones:");
        jpRegistroSeguimientoReunion.add(lblObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        txaMotivoReunion.setColumns(1);
        txaMotivoReunion.setLineWrap(true);
        txaMotivoReunion.setRows(3);
        txaMotivoReunion.setLineWrap(true);
        txaMotivoReunion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaMotivoReunionKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaMotivoReunion);

        jpRegistroSeguimientoReunion.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 305, 70));

        txaObservaciones.setColumns(2);
        txaObservaciones.setLineWrap(true);
        txaObservaciones.setRows(3);
        txaObservaciones.setLineWrap(true);
        txaObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txaObservaciones);

        jpRegistroSeguimientoReunion.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 305, 72));

        dtFechaReunion.setDateFormatString("yyyy-MM-dd");
        dtFechaReunion.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroSeguimientoReunion.add(dtFechaReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        lblTutorEmpresarial.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTutorEmpresarial.setText("Tutor Empresarial:");
        jpRegistroSeguimientoReunion.add(lblTutorEmpresarial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        cmbPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbPeriodo.setEnabled(false);
        jpRegistroSeguimientoReunion.add(cmbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, 25));

        txtCedula.setEditable(false);
        txtCedula.setPreferredSize(new java.awt.Dimension(120, 25));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoReunion.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 240, -1));

        txtParticipante.setPreferredSize(new java.awt.Dimension(250, 25));
        txtParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParticipanteActionPerformed(evt);
            }
        });
        txtParticipante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtParticipanteKeyReleased(evt);
            }
        });
        jpRegistroSeguimientoReunion.add(txtParticipante, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 300, -1));

        txtNombresApellidos.setEditable(false);
        txtNombresApellidos.setPreferredSize(new java.awt.Dimension(120, 25));
        txtNombresApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresApellidosActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoReunion.add(txtNombresApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 300, -1));

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroSeguimientoReunion.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroSeguimientoReunion.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        btnTutorEmpresarial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnTutorEmpresarial.setToolTipText("Buscar");
        btnTutorEmpresarial.setBorder(null);
        btnTutorEmpresarial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTutorEmpresarial.setPreferredSize(new java.awt.Dimension(40, 40));
        btnTutorEmpresarial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorEmpresarialActionPerformed(evt);
            }
        });
        jpRegistroSeguimientoReunion.add(btnTutorEmpresarial, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jpRegistroSeguimientoReunion.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 10, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");
        jpRegistroSeguimientoReunion.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 10, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");
        jpRegistroSeguimientoReunion.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 10, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        jpRegistroSeguimientoReunion.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 10, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");
        jpRegistroSeguimientoReunion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 10, -1));

        jpRegistroSeguimientoReunion3.add(jpRegistroSeguimientoReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, 470, -1));

        lblRegistro.setBackground(new java.awt.Color(255, 255, 255));
        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jpRegistroSeguimientoReunion3.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jpBusquedaSeguimientoReunion.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaSeguimientoReunion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaSeguimientoReunion.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaSeguimientoReunion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaSeguimientoReunion.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        jpBusquedaSeguimientoReunion.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, 23));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioBusquedaActionPerformed(evt);
            }
        });
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaSeguimientoReunion.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 260, -1));

        lblRegistrosActuales.setForeground(new java.awt.Color(102, 102, 102));
        jpBusquedaSeguimientoReunion.add(lblRegistrosActuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 391, -1, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaSeguimientoReunion.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaSeguimientoReunion.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        jtSeguimientoReunion.setModel(new javax.swing.table.DefaultTableModel(
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
        jtSeguimientoReunion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtSeguimientoReunion.setGridColor(new java.awt.Color(0, 102, 153));
        jtSeguimientoReunion.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtSeguimientoReunion.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtSeguimientoReunion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtSeguimientoReunionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtSeguimientoReunion);

        jpBusquedaSeguimientoReunion.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 430, 450));

        jpRegistroSeguimientoReunion3.add(jpBusquedaSeguimientoReunion, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jpRegistroSeguimientoReunion3.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

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

        jpRegistroSeguimientoReunion3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

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
        jpRegistroSeguimientoReunion3.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 40, 40));

        getContentPane().add(jpRegistroSeguimientoReunion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents
// <editor-fold defaultstate="collapsed" desc="Eventos">    
    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParticipanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParticipanteActionPerformed

    private void txtNombresApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresApellidosActionPerformed

    private void txtCriterioBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroSeguimientoReunion);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroSeguimientoReunion);
            llenarGrid(tipo_consulta);//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid(tipo_consulta);//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroSeguimientoReunion);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed
    }
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnTutorEmpresarialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorEmpresarialActionPerformed
        buscar("tutor_empresarial");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarTutorEmpresarial(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "persona"));
    }//GEN-LAST:event_btnTutorEmpresarialActionPerformed

    private void jtSeguimientoReunionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtSeguimientoReunionMouseClicked
        int fila = jtSeguimientoReunion.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarSeguimientoReunion(consultarRegistroIndividual(jtSeguimientoReunion.getValueAt(fila, 0).toString(), "seguimiento_reunion"));
        }
    }//GEN-LAST:event_jtSeguimientoReunionMouseClicked

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        int fila = jtSeguimientoReunion.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtSeguimientoReunion.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "R";//tipo de documento anexo
            criterioBusqueda[2] = "Reunion Seguimiento";//descripcion de los anexos
            frmDocumentoAnexos frm = new frmDocumentoAnexos(null, true, criterioBusqueda);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Documento", "Seleccionar", 2);
        }

    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void txtParticipanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParticipanteKeyReleased
        txtParticipante.setText(controladorVariablesSesion.validarLetrasConEspacios(txtParticipante.getText()));
        convertirAmayusculas(txtParticipante);    }//GEN-LAST:event_txtParticipanteKeyReleased

    private void txaMotivoReunionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaMotivoReunionKeyReleased
        convertirAmayusculas(txaMotivoReunion);
    }//GEN-LAST:event_txaMotivoReunionKeyReleased

    private void txaObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesKeyReleased
        convertirAmayusculas(txaObservaciones);    }//GEN-LAST:event_txaObservacionesKeyReleased

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo,controladorGrid.getInstance().filtrarGrid(jtSeguimientoReunion));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    // </editor-fold>  
// <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void buscar() {
        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar("seguimientoReunion", "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtSeguimientoReunion.getRowCount();
        lblTotalRegistros.setText(String.valueOf(total));
    }

    private ArrayList<Object> consultarRegistroIndividual(String id, String tabla) {

        criterioBusqueda[0] = id;
        controladorConsulta consulta = new controladorConsulta();

        return consulta.obtenerConsulta(tabla, controladorVariablesSesion.getInstance().getFiltrar(), criterioBusqueda);

    }

    private void consultarDocumentoAnexos() {
        int fila = jtSeguimientoReunion.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtSeguimientoReunion.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "S";
            consultarDocumentoAnexos(criterioBusqueda);
        } else {
            JOptionPane.showMessageDialog(rootPane, "seleccione un registro");
        }
    }

    private void consultarDocumentoAnexos(String[] criterioBusqueda) {
        try {
            frmDocumentoAnexos documentoAnexos = new frmDocumentoAnexos(null, true, criterioBusqueda);

            documentoAnexos.setVisible(true);

        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error Buscar Subgrupos", JOptionPane.ERROR_MESSAGE);
        }
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
        map.put("idPeriodo", codigoPeriodo.get(cmbPeriodo.getSelectedIndex()));
        map.put("idTutorEmpresarial", idTutorEmpresarial);
        map.put("participante", txtParticipante.getText());
        map.put("fechaReunion", dateToString(dtFechaReunion));
        map.put("motivoReunion", txaMotivoReunion.getText());
        map.put("observaciones", txaObservaciones.getText());

        //instacia el controlador
        ControladorSeguimientoReunion controladorSeguimientoReunion = new ControladorSeguimientoReunion();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorSeguimientoReunion.crearActualizar(map, archivos, tamanioArchivos);

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
        ControladorSeguimientoReunion controladorSeguimientoReunion = new ControladorSeguimientoReunion();
        controladorSeguimientoReunion.eliminar(map);

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
        jtSeguimientoReunion.getColumnModel().getColumn(0).setMaxWidth(0);
        jtSeguimientoReunion.getColumnModel().getColumn(0).setMinWidth(0);
        jtSeguimientoReunion.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void llenarGrid(String tipo) {
        jtSeguimientoReunion.setModel(controladorGrid.getInstance().llenarGrid(tipo, "grid", null, true));
        sorter = new TableRowSorter<>(jtSeguimientoReunion.getModel());
        jtSeguimientoReunion.setRowSorter(sorter);
        jtSeguimientoReunion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
        llenarFiltro();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarComboPeriodos() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "periodo";
        criterioBusqueda[1] = "tabla";
        cmbPeriodo.setModel(consulta.consultarCombo(criterioBusqueda));
        cmbPeriodo.setSelectedIndex(1);
        codigoPeriodo = consulta.getCodigoCombo();
    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        idTutorEmpresarial="-1";
        //cmbPeriodo.setSelectedIndex(0);
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

    private void llenarSeguimientoReunion(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idTutorEmpresarial = (String.valueOf(datos.get(2)));
        cmbPeriodo.setSelectedItem(datos.get(3));
        txtCedula.setText((String) datos.get(4));
        txtNombresApellidos.setText((String) datos.get(6) + " " + (String) datos.get(5));
        txtParticipante.setText((String) datos.get(7));
        dtFechaReunion.setDate(stringToJDateChooser((String) datos.get(8)));
        txaMotivoReunion.setText((String) datos.get(9));
        txaObservaciones.setText((String) datos.get(10));

    }

    private void llenarTutorEmpresarial(ArrayList<Object> datos) {
        idTutorEmpresarial = (String.valueOf(datos.get(0)));
        txtCedula.setText(String.valueOf(datos.get(4)));
        txtNombresApellidos.setText(String.valueOf(datos.get(2)) + " " + String.valueOf(datos.get(1)));
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
// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="Variables declaration"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntarAnexos;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnTutorEmpresarial;
    private javax.swing.JComboBox cmbFiltro;
    public static javax.swing.JComboBox cmbPeriodo;
    private com.toedter.calendar.JDateChooser dtFechaReunion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpBusquedaSeguimientoReunion;
    private javax.swing.JPanel jpRegistroSeguimientoReunion;
    private javax.swing.JPanel jpRegistroSeguimientoReunion3;
    private javax.swing.JTable jtSeguimientoReunion;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblFechaReunion;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMotivoReunion;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblParticipante;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblRegistrosActuales;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JLabel lblTutorEmpresarial;
    private javax.swing.JTextArea txaMotivoReunion;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtNombresApellidos;
    private javax.swing.JTextField txtParticipante;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
