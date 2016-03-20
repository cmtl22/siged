package vista;

import controlador.ControladorSucursal;
import controlador.controladorConsulta;
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

public class frmSucursal extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String accion;
    private String idEmpresa;
    private String idUbicacion;
    ArrayList<String> codigoTipo = new ArrayList<>();
    private ArrayList<String> codigoPais = new ArrayList<>();

    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmSucursal() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[2];
        idEmpresa = "-1";
        idUbicacion = "-1";
        llenarGrid();
        llenarFiltro();
        cargarTotalRegistros();
        llenarComboTipos();
        llenarComboPais();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpRegistroUsuario = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        lblPersona = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtEmpresaMatriz = new javax.swing.JTextField();
        btnPersona = new javax.swing.JButton();
        lblClave3 = new javax.swing.JLabel();
        lblClave4 = new javax.swing.JLabel();
        txtNombreSucursal = new javax.swing.JTextField();
        lblClave5 = new javax.swing.JLabel();
        txtCanton = new javax.swing.JTextField();
        lblClave6 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        lblClave7 = new javax.swing.JLabel();
        txtSector = new javax.swing.JTextField();
        lblClave8 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        lblClave9 = new javax.swing.JLabel();
        txtCallePrincipal = new javax.swing.JTextField();
        txtCalleInterseccion = new javax.swing.JTextField();
        lblClave10 = new javax.swing.JLabel();
        lblClave11 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox();
        lblPersona5 = new javax.swing.JLabel();
        lblPersona6 = new javax.swing.JLabel();
        lblPersona7 = new javax.swing.JLabel();
        lblPersona8 = new javax.swing.JLabel();
        lblPersona9 = new javax.swing.JLabel();
        lblPersona10 = new javax.swing.JLabel();
        lblPersona11 = new javax.swing.JLabel();
        lblPersona12 = new javax.swing.JLabel();
        lblPersona13 = new javax.swing.JLabel();
        lblPersona14 = new javax.swing.JLabel();
        lblPersona15 = new javax.swing.JLabel();
        lblPersona16 = new javax.swing.JLabel();
        lblClave12 = new javax.swing.JLabel();
        cmbPais = new javax.swing.JComboBox<>();
        jpBusquedaUsuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSucursal = new javax.swing.JTable();
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
        setTitle("SUCURSAL");
        setPreferredSize(new java.awt.Dimension(945, 620));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(943, 565));
        jPanel1.setMinimumSize(new java.awt.Dimension(943, 565));
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

        txtProvincia.setPreferredSize(new java.awt.Dimension(225, 25));
        txtProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProvinciaKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        lblPersona.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona.setText("Empresa Matriz:");
        lblPersona.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, -1));

        lblClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave.setText("Provincia:");
        lblClave.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));

        txtEmpresaMatriz.setEditable(false);
        txtEmpresaMatriz.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroUsuario.add(txtEmpresaMatriz, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        btnPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnPersona.setToolTipText("BUSCAR");
        btnPersona.setBorder(null);
        btnPersona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        jpRegistroUsuario.add(btnPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        lblClave3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave3.setText("Nombre De Sucursal:");
        lblClave3.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, -1));

        lblClave4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave4.setText("País:");
        lblClave4.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, -1));

        txtNombreSucursal.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNombreSucursal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreSucursalKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNombreSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        lblClave5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave5.setText("Cantón:");
        lblClave5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 50, -1));

        txtCanton.setPreferredSize(new java.awt.Dimension(225, 25));
        txtCanton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantonKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtCanton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        lblClave6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave6.setText("Ciudad:");
        lblClave6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, -1));

        txtCiudad.setPreferredSize(new java.awt.Dimension(225, 25));
        txtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCiudadKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        lblClave7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave7.setText("Sector:");
        lblClave7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, -1));

        txtSector.setPreferredSize(new java.awt.Dimension(225, 25));
        txtSector.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSectorKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        lblClave8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave8.setText("Referencia:");
        lblClave8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 120, -1));

        txtReferencia.setPreferredSize(new java.awt.Dimension(225, 25));
        txtReferencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReferenciaKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        lblClave9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave9.setText("Calle Principal:");
        lblClave9.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 120, -1));

        txtCallePrincipal.setPreferredSize(new java.awt.Dimension(225, 25));
        txtCallePrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCallePrincipalKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtCallePrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, -1));

        txtCalleInterseccion.setPreferredSize(new java.awt.Dimension(225, 25));
        txtCalleInterseccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCalleInterseccionKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtCalleInterseccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, -1, -1));

        lblClave10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave10.setText("Calle Intersección:");
        lblClave10.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 120, -1));

        lblClave11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave11.setText("Tipo:");
        lblClave11.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 120, -1));

        txtNumero.setPreferredSize(new java.awt.Dimension(225, 25));
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroKeyReleased(evt);
            }
        });
        jpRegistroUsuario.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, -1, -1));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cmbTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegistroUsuario.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 220, -1));

        lblPersona5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona5.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona5.setText("*");
        lblPersona5.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 10, -1));

        lblPersona6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona6.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona6.setText("*");
        lblPersona6.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 10, -1));

        lblPersona7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona7.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona7.setText("*");
        lblPersona7.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 10, -1));

        lblPersona8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona8.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona8.setText("*");
        lblPersona8.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 10, -1));

        lblPersona9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona9.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona9.setText("*");
        lblPersona9.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 10, -1));

        lblPersona10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona10.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona10.setText("*");
        lblPersona10.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 10, -1));

        lblPersona11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona11.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona11.setText("*");
        lblPersona11.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 10, -1));

        lblPersona12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona12.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona12.setText("*");
        lblPersona12.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 10, -1));

        lblPersona13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona13.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona13.setText("*");
        lblPersona13.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 10, -1));

        lblPersona14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona14.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona14.setText("*");
        lblPersona14.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 10, -1));

        lblPersona15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona15.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona15.setText("*");
        lblPersona15.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 10, -1));

        lblPersona16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPersona16.setForeground(new java.awt.Color(255, 0, 0));
        lblPersona16.setText("*");
        lblPersona16.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblPersona16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 10, -1));

        lblClave12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblClave12.setText("Número:");
        lblClave12.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroUsuario.add(lblClave12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 120, -1));

        cmbPais.setBackground(new java.awt.Color(204, 204, 255));
        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPais.setToolTipText("");
        cmbPais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbPais.setPreferredSize(new java.awt.Dimension(150, 25));
        jpRegistroUsuario.add(cmbPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 230, -1));

        jPanel1.add(jpRegistroUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jpBusquedaUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaUsuario.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(430, 420));
        jScrollPane1.setRequestFocusEnabled(false);

        jtSucursal.setModel(new javax.swing.table.DefaultTableModel(
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
        jtSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtSucursal.setGridColor(new java.awt.Color(0, 102, 153));
        jtSucursal.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtSucursal.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtSucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtSucursalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtSucursal);

        jpBusquedaUsuario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

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
        jpBusquedaUsuario.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaUsuario.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(32, 20));
        jpBusquedaUsuario.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jpBusquedaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(185, 50));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos"> 
    private void jtSucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtSucursalMouseClicked
        int fila = jtSucursal.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarEmpresaSucursal(consultarRegistroIndividual(jtSucursal.getValueAt(fila, 0).toString(), "empresa_sucursales"));
        }
    }//GEN-LAST:event_jtSucursalMouseClicked

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

    private void btnPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonaActionPerformed
        buscar("empresa");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        llenarEmpresa(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "empresa"));
    }//GEN-LAST:event_btnPersonaActionPerformed

    private void txtProvinciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProvinciaKeyReleased
        convertirAmayusculas(txtProvincia);
    }//GEN-LAST:event_txtProvinciaKeyReleased

    private void txtNombreSucursalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreSucursalKeyReleased
        convertirAmayusculas(txtNombreSucursal);
        
    }//GEN-LAST:event_txtNombreSucursalKeyReleased

    private void txtCantonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantonKeyReleased
        convertirAmayusculas(txtCanton);
        txtCanton.setText(controladorVariablesSesion.validarLetrasConEspacios(txtCanton.getText()));
    }//GEN-LAST:event_txtCantonKeyReleased

    private void txtCiudadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadKeyReleased
        convertirAmayusculas(txtCiudad);
        txtCiudad.setText(controladorVariablesSesion.validarLetrasConEspacios(txtCiudad.getText()));
    }//GEN-LAST:event_txtCiudadKeyReleased

    private void txtSectorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSectorKeyReleased
        convertirAmayusculas(txtSector);
        
    }//GEN-LAST:event_txtSectorKeyReleased

    private void txtReferenciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReferenciaKeyReleased
        convertirAmayusculas(txtReferencia);
    }//GEN-LAST:event_txtReferenciaKeyReleased

    private void txtCallePrincipalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCallePrincipalKeyReleased
        convertirAmayusculas(txtCallePrincipal);
    }//GEN-LAST:event_txtCallePrincipalKeyReleased

    private void txtCalleInterseccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleInterseccionKeyReleased
        convertirAmayusculas(txtCalleInterseccion);
    }//GEN-LAST:event_txtCalleInterseccionKeyReleased

    private void txtNumeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyReleased
        convertirAmayusculas(txtNumero);
    }//GEN-LAST:event_txtNumeroKeyReleased
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtSucursal.getRowCount();
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
        map.put("idEmpresa", idEmpresa);
        map.put("idUbicacion", idUbicacion);
        map.put("nombreSucursal", txtNombreSucursal.getText());
        map.put("pais", codigoPais.get(cmbPais.getSelectedIndex()));
        map.put("provincia", txtProvincia.getText());
        map.put("canton", txtCanton.getText());
        map.put("ciudad", txtCiudad.getText());
        map.put("sector", txtSector.getText());
        map.put("referencia", txtReferencia.getText());
        map.put("callePrincipal", txtCallePrincipal.getText());
        map.put("calleInteresecion", txtCalleInterseccion.getText());
        map.put("numero", txtNumero.getText());
        map.put("idTipo", codigoTipo.get(cmbTipo.getSelectedIndex()));

        //instacia el controlador
        ControladorSucursal sucursal = new ControladorSucursal();
        //llama al metodo para crear o actualizar segun sea la accion
        return sucursal.crearActualizar(map);

    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorSucursal sucursal = new ControladorSucursal();
        sucursal.eliminar(map);
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
        jtSucursal.getColumnModel().getColumn(0).setMaxWidth(0);
        jtSucursal.getColumnModel().getColumn(0).setMinWidth(0);
        jtSucursal.getColumnModel().getColumn(0).setPreferredWidth(0);

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
    
    private void llenarComboPais() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "PAIS";//nombre de la tabla
        criterioBusqueda[1] = "enumeracion";//tipo de consulta
        cmbPais.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoPais = consulta.getCodigoCombo();
    }
    
    private void llenarComboTipos() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "TIPO EMPRESA";
        criterioBusqueda[1] = "enumeracion";
        cmbTipo.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoTipo = consulta.getCodigoCombo();
    }
    
    private void llenarEmpresa(ArrayList<Object> datos) {
        idEmpresa = (String.valueOf(datos.get(0)));
        txtEmpresaMatriz.setText((String) datos.get(2));

    }
    
    private void llenarEmpresaSucursal(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idEmpresa = (String.valueOf(datos.get(1)));
        idUbicacion = (String.valueOf(datos.get(2)));
        txtEmpresaMatriz.setText((String) datos.get(3));
        txtNombreSucursal.setText((String) datos.get(4));
        cmbTipo.setSelectedItem((String) datos.get(5));
        cmbPais.setSelectedItem((String) datos.get(6));        
        txtProvincia.setText((String) datos.get(7));
        txtCanton.setText((String) datos.get(8));
        txtCiudad.setText((String) datos.get(9));
        txtSector.setText((String) datos.get(10));
        txtReferencia.setText((String) datos.get(11));
        txtCallePrincipal.setText((String) datos.get(12));
        txtCalleInterseccion.setText((String) datos.get(13));
        txtNumero.setText((String) datos.get(14));

    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtSucursal.setModel(controladorGrid.getInstance().llenarGrid("empresa_sucursal", "grid", null, true));
        sorter = new TableRowSorter<>(jtSucursal.getModel());
        jtSucursal.setRowSorter(sorter);
        jtSucursal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify                     "> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPersona;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpBusquedaUsuario;
    private javax.swing.JPanel jpRegistroUsuario;
    private javax.swing.JTable jtSucursal;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblClave10;
    private javax.swing.JLabel lblClave11;
    private javax.swing.JLabel lblClave12;
    private javax.swing.JLabel lblClave3;
    private javax.swing.JLabel lblClave4;
    private javax.swing.JLabel lblClave5;
    private javax.swing.JLabel lblClave6;
    private javax.swing.JLabel lblClave7;
    private javax.swing.JLabel lblClave8;
    private javax.swing.JLabel lblClave9;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JLabel lblPersona10;
    private javax.swing.JLabel lblPersona11;
    private javax.swing.JLabel lblPersona12;
    private javax.swing.JLabel lblPersona13;
    private javax.swing.JLabel lblPersona14;
    private javax.swing.JLabel lblPersona15;
    private javax.swing.JLabel lblPersona16;
    private javax.swing.JLabel lblPersona5;
    private javax.swing.JLabel lblPersona6;
    private javax.swing.JLabel lblPersona7;
    private javax.swing.JLabel lblPersona8;
    private javax.swing.JLabel lblPersona9;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextField txtCalleInterseccion;
    private javax.swing.JTextField txtCallePrincipal;
    private javax.swing.JTextField txtCanton;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtEmpresaMatriz;
    private javax.swing.JTextField txtNombreSucursal;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtProvincia;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtSector;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
