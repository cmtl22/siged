package vista;

import com.toedter.calendar.JDateChooser;
import controlador.ControladorAcercamiento;
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

public class frmAcercamiento extends javax.swing.JInternalFrame {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 
    Date fechaActual;
    private String accion;
    private String idEmpresaSucursal;
    ArrayList<String> codigoEstadoAcercamiento = new ArrayList<>();
    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmAcercamiento() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[3];
        idEmpresaSucursal = "-1";
        fechaActual = new Date();
        dtFechaAcercamiento.setDate(fechaActual);
        llenarGrid();
        llenarComboEstadoAcercamiento();
        cargarTotalRegistros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jpRegistroAcercamiento = new javax.swing.JPanel();
        lblTitulo_Id3 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        cmbEstadoAcercamiento = new javax.swing.JComboBox<>();
        lblEstadoAcercamiento = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        txtEmpresaSucursal = new javax.swing.JTextField();
        btnEmpresaSucursal = new javax.swing.JButton();
        dtFechaAcercamiento = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        jpBusquedaAcercamiento = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtAcercamiento = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros3 = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        lblBusqueda = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnNuevo3 = new javax.swing.JButton();
        btnCrearActualizar3 = new javax.swing.JButton();
        btnEliminar3 = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar3 = new javax.swing.JButton();
        btnNuevo1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("ACERCAMIENTO");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_acercamiento_32.jpg"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegistroAcercamiento.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroAcercamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroAcercamiento.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroAcercamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo_Id3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id3.setText("Id:");
        lblTitulo_Id3.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroAcercamiento.add(lblTitulo_Id3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroAcercamiento.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        cmbEstadoAcercamiento.setBackground(new java.awt.Color(255, 255, 204));
        cmbEstadoAcercamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbEstadoAcercamiento.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbEstadoAcercamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoAcercamientoActionPerformed(evt);
            }
        });
        jpRegistroAcercamiento.add(cmbEstadoAcercamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 260, -1));

        lblEstadoAcercamiento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEstadoAcercamiento.setText("Estado:");
        lblEstadoAcercamiento.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroAcercamiento.add(lblEstadoAcercamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFecha.setText("Fecha:");
        lblFecha.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroAcercamiento.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, -1));

        lblObservaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObservaciones.setText("Observaciones:");
        lblObservaciones.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroAcercamiento.add(lblObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtEmpresaSucursal.setEditable(false);
        txtEmpresaSucursal.setPreferredSize(new java.awt.Dimension(225, 25));
        jpRegistroAcercamiento.add(txtEmpresaSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 260, -1));

        btnEmpresaSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_buscar_40.png"))); // NOI18N
        btnEmpresaSucursal.setToolTipText("Buscar");
        btnEmpresaSucursal.setBorder(null);
        btnEmpresaSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpresaSucursal.setPreferredSize(new java.awt.Dimension(40, 40));
        btnEmpresaSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaSucursalActionPerformed(evt);
            }
        });
        jpRegistroAcercamiento.add(btnEmpresaSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        dtFechaAcercamiento.setDateFormatString("yyyy-MM-dd");
        dtFechaAcercamiento.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroAcercamiento.add(dtFechaAcercamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        txaObservaciones.setColumns(1);
        txaObservaciones.setLineWrap(true);
        txaObservaciones.setRows(3);
        txaObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txaObservaciones);

        jpRegistroAcercamiento.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 260, 100));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");
        jpRegistroAcercamiento.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 10, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");
        jpRegistroAcercamiento.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 10, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");
        jpRegistroAcercamiento.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 10, -1));

        lblEmpresa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmpresa.setText("Empresa:");
        lblEmpresa.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroAcercamiento.add(lblEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, -1));

        jPanel7.add(jpRegistroAcercamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        jpBusquedaAcercamiento.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaAcercamiento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaAcercamiento.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaAcercamiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtAcercamiento.setModel(new javax.swing.table.DefaultTableModel(
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
        jtAcercamiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtAcercamiento.setGridColor(new java.awt.Color(0, 102, 153));
        jtAcercamiento.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtAcercamiento.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtAcercamiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAcercamientoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtAcercamiento);

        jpBusquedaAcercamiento.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 440, 450));

        cmbFiltro.setBackground(new java.awt.Color(255, 255, 204));
        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        jpBusquedaAcercamiento.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaAcercamiento.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 290, -1));

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

        jPanel7.add(jpBusquedaAcercamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel7.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel7.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(230, 50));

        btnNuevo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_nuevo_40.png"))); // NOI18N
        btnNuevo3.setToolTipText("LIMPIAR");
        btnNuevo3.setBorder(null);
        btnNuevo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo3.setPreferredSize(new java.awt.Dimension(40, 40));
        btnNuevo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo3ActionPerformed(evt);
            }
        });
        jPanel8.add(btnNuevo3);

        btnCrearActualizar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_crear_actualizar_40.png"))); // NOI18N
        btnCrearActualizar3.setToolTipText("GUARDAR");
        btnCrearActualizar3.setBorder(null);
        btnCrearActualizar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearActualizar3.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCrearActualizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActualizar3ActionPerformed(evt);
            }
        });
        jPanel8.add(btnCrearActualizar3);

        btnEliminar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_eliminar_40.png"))); // NOI18N
        btnEliminar3.setToolTipText("ELIMINAR");
        btnEliminar3.setBorder(null);
        btnEliminar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar3.setPreferredSize(new java.awt.Dimension(40, 40));
        btnEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar3ActionPerformed(evt);
            }
        });
        jPanel8.add(btnEliminar3);

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
        jPanel8.add(btnAdjuntarAnexos);

        btnCerrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cerrar_40.png"))); // NOI18N
        btnCerrar3.setToolTipText("CERRAR");
        btnCerrar3.setBorder(null);
        btnCerrar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar3.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCerrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar3ActionPerformed(evt);
            }
        });
        jPanel8.add(btnCerrar3);

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

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
        jPanel7.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, -1));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // <editor-fold defaultstate="collapsed" desc="Eventos">     
    private void btnEmpresaSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaSucursalActionPerformed
        buscar("empresa_acercamiento");//abre una ventana de busqueda
        //consulta el registro seleccionado en la ventana de busqueda y llena las cajas de texto con la consulta a la base de datos
        if (!controladorVariablesSesion.getInstance().getDatosTemporalesConsulta().equals("")) {
            llenarEmpresaSucursal(consultarRegistroIndividual(controladorVariablesSesion.getInstance().getDatosTemporalesConsulta(), "empresa"));
        }
    }//GEN-LAST:event_btnEmpresaSucursalActionPerformed

    private void jtAcercamientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAcercamientoMouseClicked
        int fila = jtAcercamiento.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarAcercamiento(consultarRegistroIndividual(jtAcercamiento.getValueAt(fila, 0).toString(), "acercamiento"));
        }
    }//GEN-LAST:event_jtAcercamientoMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
        cargarTotalRegistros();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

    private void btnCerrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar3ActionPerformed
        controladorVariablesSesion.getInstance().setContadorVentanas(-1);
        if (controladorVariablesSesion.getInstance().getContadorVentanas() == 0) {
            frmPrincipal.jpEncabezado.setVisible(true);
        }
        this.dispose();//cierra el formulario
    }//GEN-LAST:event_btnCerrar3ActionPerformed

    private void btnEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar3ActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid();//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroAcercamiento);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminar3ActionPerformed
    }
    private void btnCrearActualizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizar3ActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroAcercamiento);
            llenarGrid();//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizar3ActionPerformed

    private void btnNuevo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo3ActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroAcercamiento);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevo3ActionPerformed

    private void cmbEstadoAcercamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoAcercamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoAcercamientoActionPerformed

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        int fila = jtAcercamiento.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtAcercamiento.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "A";//tipo de documento anexo
            criterioBusqueda[2] = "Acercamiento";//descripcion de los anexos
            frmDocumentoAnexos frm = new frmDocumentoAnexos(null, true, criterioBusqueda);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Documento", "Seleccionar", 2);
        }
    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void txaObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesKeyReleased
        convertirAmayusculas(txaObservaciones);
    }//GEN-LAST:event_txaObservacionesKeyReleased

    private void btnNuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo1ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel(rutaArchivo, controladorGrid.getInstance().filtrarGrid(jtAcercamiento));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFiltroActionPerformed

// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 
    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtAcercamiento.getRowCount();
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
        map.put("fecha_creacion_registro", idEmpresaSucursal);
        map.put("fecha", dateToString(dtFechaAcercamiento));
        map.put("estadoAcercamiento", codigoEstadoAcercamiento.get(cmbEstadoAcercamiento.getSelectedIndex()));
        map.put("observaciones", txaObservaciones.getText());

        //instacia el controlador
        ControladorAcercamiento controladorAcercamiento = new ControladorAcercamiento();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorAcercamiento.crearActualizar(map);

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
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorAcercamiento controladorAcercamiento = new ControladorAcercamiento();
        controladorAcercamiento.eliminar(map);
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
        jtAcercamiento.getColumnModel().getColumn(0).setMaxWidth(0);
        jtAcercamiento.getColumnModel().getColumn(0).setMinWidth(0);
        jtAcercamiento.getColumnModel().getColumn(0).setPreferredWidth(0);

    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        idEmpresaSucursal = "-1";
        cmbEstadoAcercamiento.setSelectedIndex(0);
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

    private void llenarComboEstadoAcercamiento() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "ESTADO ACERCAMIENTO";//nombre de la tabla
        criterioBusqueda[1] = "enumeracion";//tipo de consulta
        cmbEstadoAcercamiento.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoEstadoAcercamiento = consulta.getCodigoCombo();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid() {
        jtAcercamiento.setModel(controladorGrid.getInstance().llenarGrid("acercamiento", "grid", null, true));
        sorter = new TableRowSorter<>(jtAcercamiento.getModel());
        jtAcercamiento.setRowSorter(sorter);
        jtAcercamiento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
        llenarFiltro();
    }

    private void llenarEmpresaSucursal(ArrayList<Object> datos) {
        idEmpresaSucursal = (String.valueOf(datos.get(0)));
        txtEmpresaSucursal.setText((String) datos.get(2));

    }

    private void llenarAcercamiento(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        idEmpresaSucursal = (String.valueOf(datos.get(1)));
        txtEmpresaSucursal.setText((String) datos.get(2));
        cmbEstadoAcercamiento.setSelectedItem((String) datos.get(5));
        dtFechaAcercamiento.setDate(stringToJDateChooser((String) datos.get(3)));
        txaObservaciones.setText((String) datos.get(4));
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
    private javax.swing.JButton btnCerrar3;
    private javax.swing.JButton btnCrearActualizar3;
    private javax.swing.JButton btnEliminar3;
    private javax.swing.JButton btnEmpresaSucursal;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnNuevo3;
    private javax.swing.JComboBox<String> cmbEstadoAcercamiento;
    private javax.swing.JComboBox<String> cmbFiltro;
    private com.toedter.calendar.JDateChooser dtFechaAcercamiento;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpBusquedaAcercamiento;
    private javax.swing.JPanel jpRegistroAcercamiento;
    private javax.swing.JTable jtAcercamiento;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblEstadoAcercamiento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros3;
    private javax.swing.JLabel lblTitulo_Id3;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txtCriterioBusqueda;
    private javax.swing.JTextField txtEmpresaSucursal;
    // End of variables declaration//GEN-END:variables
// </editor-fold>  
}
