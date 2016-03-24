package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import controlador.ControladorCronograma;
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

public class frmCronograma extends javax.swing.JInternalFrame {

    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 
    Date fechaActual;
    private String accion = "crear";
    private String tipo_consulta;
    private String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;

    ArrayList<String> codigoPeriodo = new ArrayList<>();
    ArrayList<String> codigoTarea = new ArrayList<>();
// </editor-fold > 

    public frmCronograma() {
        initComponents();
        init();

    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[2];
        fechaActual = new Date();
        dtFechaInicio.setDate(fechaActual);
        dtFechaFin.setDate(fechaActual);
        tipo_consulta = "cronograma";
        llenarFiltro();
        llenarComboPeriodos();
        llenarComboTareas();
        cargarTotalRegistros();
        if (controladorVariablesSesion.getInstance().getPerfilUsuario().equals("1")) {
            cmbPeriodo.setEnabled(true);
            tipo_consulta = "cronograma_admin";
            llenarGrid(tipo_consulta);
        } else {
            tipo_consulta = "cronograma";
            llenarGrid(tipo_consulta);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBusqueda = new javax.swing.JLabel();
        jpBusquedaCronograma = new javax.swing.JPanel();
        lblFiltro = new javax.swing.JLabel();
        cmbFiltro = new javax.swing.JComboBox();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros3 = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtCronograma = new javax.swing.JTable();
        btnNuevo1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblRegistro = new javax.swing.JLabel();
        jpRegistroCronograma = new javax.swing.JPanel();
        lblPeriodo = new javax.swing.JLabel();
        lblTarea = new javax.swing.JLabel();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        cmbTarea = new javax.swing.JComboBox();
        dtFechaInicio = new com.toedter.calendar.JDateChooser();
        dtFechaFin = new com.toedter.calendar.JDateChooser();
        lblTitulo_Id4 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox();

        setTitle("CRONOGRAMA");
        setPreferredSize(new java.awt.Dimension(945, 535));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        jpBusquedaCronograma.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaCronograma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaCronograma.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaCronograma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaCronograma.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        jpBusquedaCronograma.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 118, 23));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(129, 25));
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
        jpBusquedaCronograma.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 210, -1));

        lblRegistros3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros3.setText("Registros:");
        lblRegistros3.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaCronograma.add(lblRegistros3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaCronograma.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        jtCronograma.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCronograma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtCronograma.setGridColor(new java.awt.Color(0, 102, 153));
        jtCronograma.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtCronograma.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtCronograma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCronogramaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtCronograma);

        jpBusquedaCronograma.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 430, 410));

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
        jpBusquedaCronograma.add(btnNuevo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 40, 40));

        jPanel1.add(jpBusquedaCronograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 50));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 180, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

        jpRegistroCronograma.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroCronograma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroCronograma.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroCronograma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPeriodo.setText("Período :");
        jpRegistroCronograma.add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblTarea.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTarea.setText("Tarea:");
        jpRegistroCronograma.add(lblTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 10));

        lblFechaInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaInicio.setText("Fecha de Inicio:");
        jpRegistroCronograma.add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblFechaFin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFechaFin.setText("Fecha de Finalización:");
        jpRegistroCronograma.add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        cmbTarea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRegistroCronograma.add(cmbTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 240, 25));

        dtFechaInicio.setDateFormatString("yyyy-MM-dd");
        dtFechaInicio.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroCronograma.add(dtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        dtFechaFin.setDateFormatString("yyyy-MM-dd");
        dtFechaFin.setPreferredSize(new java.awt.Dimension(100, 25));
        jpRegistroCronograma.add(dtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        lblTitulo_Id4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id4.setText("Id:");
        lblTitulo_Id4.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroCronograma.add(lblTitulo_Id4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroCronograma.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jpRegistroCronograma.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 10, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");
        jpRegistroCronograma.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 10, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");
        jpRegistroCronograma.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 10, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");
        jpRegistroCronograma.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 10, -1));

        cmbPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbPeriodo.setEnabled(false);
        jpRegistroCronograma.add(cmbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 240, 25));

        jPanel1.add(jpRegistroCronograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
// <editor-fold defaultstate="collapsed" desc="Eventos">  
    private void txtCriterioBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCriterioBusquedaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroCronograma);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroCronograma);
            llenarGrid(tipo_consulta);//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (controladorVariablesSesion.getInstance().eliminar(lblId.getText()) == 0) {
            accion = "crear";
            eliminar();//elimina el registro seleccionado
            llenarGrid(tipo_consulta);//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroCronograma);//limpia las cajas de texto
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

    private void jtCronogramaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCronogramaMouseClicked
        int fila = jtCronograma.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarCronograma(consultarRegistroIndividual(jtCronograma.getValueAt(fila, 0).toString(), "cronograma"));
        }
    }//GEN-LAST:event_jtCronogramaMouseClicked

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
            controladorExcel.getInstance().generarExcel(rutaArchivo,controladorGrid.getInstance().filtrarGrid(jtCronograma));
        }
    }//GEN-LAST:event_btnNuevo1ActionPerformed
    
// </editor-fold>  
// <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar() {
        frmConsultas consulta = new frmConsultas(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.consultar("persona", "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtCronograma.getRowCount();
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
        map.put("idPeriodo", codigoPeriodo.get(cmbPeriodo.getSelectedIndex()));
        map.put("tarea", codigoTarea.get(cmbTarea.getSelectedIndex()));
        map.put("fechaInicio", dateToString(dtFechaInicio));
        map.put("fechaFin", dateToString(dtFechaFin));

        //instacia el controlador
        ControladorCronograma controladorCronograma = new ControladorCronograma();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorCronograma.crearActualizar(map);

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
        ControladorCronograma controladorCronograma = new ControladorCronograma();
        controladorCronograma.eliminar(map);

    }

    protected void limpiarCajasTexto(Component component) {
        lblId.setText("0");
        cmbTarea.setSelectedIndex(0);
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

    private void llenarGrid(String tipo) {
        jtCronograma.setModel(controladorGrid.getInstance().llenarGrid(tipo, "grid", null, true));
        sorter = new TableRowSorter<>(jtCronograma.getModel());
        jtCronograma.setRowSorter(sorter);
        jtCronograma.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
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

    private void llenarComboTareas() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "TAREA";
        criterioBusqueda[1] = "enumeracion";
        cmbTarea.setModel(consulta.consultarCombo(criterioBusqueda));
        codigoTarea = consulta.getCodigoCombo();

    }

    private void llenarCronograma(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        cmbTarea.setSelectedItem(datos.get(4));
        cmbPeriodo.setSelectedItem(datos.get(2));
        dtFechaInicio.setDate(stringToJDateChooser((String) datos.get(5)));
        dtFechaFin.setDate(stringToJDateChooser((String) datos.get(6)));

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
        jtCronograma.getColumnModel().getColumn(0).setMaxWidth(0);
        jtCronograma.getColumnModel().getColumn(0).setMinWidth(0);
        jtCronograma.getColumnModel().getColumn(0).setPreferredWidth(0);

        jtCronograma.getColumnModel().getColumn(1).setMaxWidth(0);
        jtCronograma.getColumnModel().getColumn(1).setMinWidth(0);
        jtCronograma.getColumnModel().getColumn(1).setPreferredWidth(0);

        jtCronograma.getColumnModel().getColumn(2).setMaxWidth(150);
        jtCronograma.getColumnModel().getColumn(2).setMinWidth(0);
        jtCronograma.getColumnModel().getColumn(2).setPreferredWidth(150);

        jtCronograma.getColumnModel().getColumn(3).setMaxWidth(0);
        jtCronograma.getColumnModel().getColumn(3).setMinWidth(0);
        jtCronograma.getColumnModel().getColumn(3).setPreferredWidth(0);
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
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JComboBox cmbFiltro;
    public static javax.swing.JComboBox cmbPeriodo;
    private javax.swing.JComboBox cmbTarea;
    private com.toedter.calendar.JDateChooser dtFechaFin;
    private com.toedter.calendar.JDateChooser dtFechaInicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpBusquedaCronograma;
    private javax.swing.JPanel jpRegistroCronograma;
    private javax.swing.JTable jtCronograma;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros3;
    private javax.swing.JLabel lblTarea;
    private javax.swing.JLabel lblTitulo_Id4;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextField txtCriterioBusqueda;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
