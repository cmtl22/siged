package vista;

import controlador.ControladorEncuesta;
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
import static vista.frmCronograma.cmbPeriodo;
import static vista.frmSeguimientoEstudiante.cmbPeriodo;

public class frmEncuesta extends javax.swing.JInternalFrame {
    // <editor-fold defaultstate="collapsed" desc="Declaracion de Variables"> 

    private String accion;
    private String tipo_consulta;
    ArrayList<String> codigoPeriodo = new ArrayList<>();
    String[] criterioBusqueda;
    TableRowSorter<TableModel> sorter;
// </editor-fold > 

    public frmEncuesta() {
        initComponents();
        init();
    }

    private void init() {
        accion = "crear";
        criterioBusqueda = new String[3];
        tipo_consulta = "encuesta";
        llenarFiltro();
        llenarComboPeriodos();
        cargarTotalRegistros();
        if (controladorVariablesSesion.getInstance().getPerfilUsuario().equals("1")) {
            cmbPeriodo.setEnabled(true);
            tipo_consulta = "encuesta_admin";
            llenarGrid(tipo_consulta);
        } else {
            tipo_consulta = "encuesta";
            llenarGrid(tipo_consulta);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpRegistroEntrevista = new javax.swing.JPanel();
        lblTitulo_Id = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox();
        jpBusquedaEntrevista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEncuesta = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        txtCriterioBusqueda = new javax.swing.JTextField();
        lblRegistros = new javax.swing.JLabel();
        lblTotalRegistros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        btnNuevo3 = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        lblRegistro = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCrearActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAdjuntarAnexos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setTitle("ENCUESTA");
        setPreferredSize(new java.awt.Dimension(945, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(945, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpRegistroEntrevista.setBackground(new java.awt.Color(255, 255, 255));
        jpRegistroEntrevista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpRegistroEntrevista.setPreferredSize(new java.awt.Dimension(470, 520));
        jpRegistroEntrevista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo_Id.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo_Id.setText("Id:");
        lblTitulo_Id.setPreferredSize(new java.awt.Dimension(15, 20));
        jpRegistroEntrevista.add(lblTitulo_Id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lblId.setText("0");
        lblId.setPreferredSize(new java.awt.Dimension(100, 20));
        jpRegistroEntrevista.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        lblObservaciones.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblObservaciones.setText("Observaciones:");
        lblObservaciones.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, -1));

        lblPeriodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPeriodo.setText("Período:");
        lblPeriodo.setPreferredSize(new java.awt.Dimension(120, 25));
        jpRegistroEntrevista.add(lblPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, -1));

        txaObservaciones.setColumns(2);
        txaObservaciones.setLineWrap(true);
        txaObservaciones.setRows(3);
        txaObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txaObservacionesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txaObservaciones);

        jpRegistroEntrevista.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 260, 100));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jpRegistroEntrevista.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 10, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");
        jpRegistroEntrevista.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 10, -1));

        cmbPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbPeriodo.setEnabled(false);
        cmbPeriodo.setPreferredSize(new java.awt.Dimension(28, 25));
        jpRegistroEntrevista.add(cmbPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 260, -1));

        jPanel1.add(jpRegistroEntrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        jpBusquedaEntrevista.setBackground(new java.awt.Color(255, 255, 255));
        jpBusquedaEntrevista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpBusquedaEntrevista.setPreferredSize(new java.awt.Dimension(455, 520));
        jpBusquedaEntrevista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtEncuesta.setModel(new javax.swing.table.DefaultTableModel(
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
        jtEncuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtEncuesta.setGridColor(new java.awt.Color(0, 102, 153));
        jtEncuesta.setSelectionBackground(new java.awt.Color(255, 255, 0));
        jtEncuesta.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtEncuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEncuestaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtEncuesta);

        jpBusquedaEntrevista.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 440, 380));

        cmbFiltro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFiltro.setPreferredSize(new java.awt.Dimension(80, 25));
        jpBusquedaEntrevista.add(cmbFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 150, -1));

        txtCriterioBusqueda.setPreferredSize(new java.awt.Dimension(6, 25));
        txtCriterioBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioBusquedaKeyReleased(evt);
            }
        });
        jpBusquedaEntrevista.add(txtCriterioBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 170, -1));

        lblRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRegistros.setText("Registros:");
        lblRegistros.setPreferredSize(new java.awt.Dimension(60, 20));
        jpBusquedaEntrevista.add(lblRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        lblTotalRegistros.setText("0");
        lblTotalRegistros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTotalRegistros.setPreferredSize(new java.awt.Dimension(200, 20));
        jpBusquedaEntrevista.add(lblTotalRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        lblFiltro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFiltro.setText("Filtro:");
        lblFiltro.setPreferredSize(new java.awt.Dimension(35, 20));
        jpBusquedaEntrevista.add(lblFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        btnNuevo3.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_exportar_excel_32.png"))); // NOI18N
        btnNuevo3.setToolTipText("Exportar");
        btnNuevo3.setBorder(null);
        btnNuevo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo3.setPreferredSize(new java.awt.Dimension(48, 48));
        btnNuevo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo3ActionPerformed(evt);
            }
        });
        jpBusquedaEntrevista.add(btnNuevo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 40, 40));

        jPanel1.add(jpBusquedaEntrevista, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        lblBusqueda.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblBusqueda.setText("BÚSQUEDA");
        jPanel1.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, -1));

        lblRegistro.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 24)); // NOI18N
        lblRegistro.setText("REGISTRO");
        jPanel1.add(lblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 10, -1, -1));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 240, 50));

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
    private void jtEncuestaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEncuestaMouseClicked
        int fila = jtEncuesta.getSelectedRow();//guarda la fila seleccionada
        accion = "actualizar";
        if (fila != -1) {
            //consulta en la base de datos y llena las cajas de texto con la consulta realizada
            llenarEncuesta(consultarRegistroIndividual(jtEncuesta.getValueAt(fila, 0).toString(), "encuesta"));
        }
    }//GEN-LAST:event_jtEncuestaMouseClicked

    private void txtCriterioBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaKeyReleased
        convertirAmayusculas(txtCriterioBusqueda);
        filtrar();
    }//GEN-LAST:event_txtCriterioBusquedaKeyReleased

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
            llenarGrid(tipo_consulta);//vuelve a consultar a la base de datos para que cargue sin el registro eliminado
            limpiarCajasTexto(jpRegistroEntrevista);//limpia las cajas de texto
            cargarTotalRegistros();//carga el total de registros
    }//GEN-LAST:event_btnEliminarActionPerformed
    }
    private void btnCrearActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActualizarActionPerformed
        if (crearActualizar()) {//crea o actualiza segun la accion designada
            limpiarCajasTexto(jpRegistroEntrevista);
            llenarGrid(tipo_consulta);//consulta a la base de datos para que cargue el nuevo registro ingresado
            cargarTotalRegistros();//carga el total de registros
        }
    }//GEN-LAST:event_btnCrearActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "crear";
        limpiarCajasTexto(jpRegistroEntrevista);//limpia las cajas de texto
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAdjuntarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarAnexosActionPerformed
        int fila = jtEncuesta.getSelectedRow();
        if (fila != -1) {
            criterioBusqueda[0] = jtEncuesta.getValueAt(fila, 0).toString();
            criterioBusqueda[1] = "E";//tipo de documento anexo
            criterioBusqueda[2] = "Encuesta";//descripcion de los anexos
            frmDocumentoAnexos frm = new frmDocumentoAnexos(null, true, criterioBusqueda);
            frm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Documento", "Seleccionar", 2);
        }
    }//GEN-LAST:event_btnAdjuntarAnexosActionPerformed

    private void txaObservacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesKeyReleased
        convertirAmayusculas(txaObservaciones);
    }//GEN-LAST:event_txaObservacionesKeyReleased

    private void btnNuevo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo3ActionPerformed
        String[] rutaArchivo = controladorVariablesSesion.getInstance().obtenerRuta();
        if (rutaArchivo[0] != null) {
            controladorExcel.getInstance().generarExcel2(rutaArchivo, controladorGrid.getInstance().filtrarGrid(jtEncuesta));
        }
    }//GEN-LAST:event_btnNuevo3ActionPerformed
    private DefaultTableModel filtrarGrid() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] datos = new String[jtEncuesta.getColumnCount()];
        for (int i = 0; i < jtEncuesta.getRowCount(); i++) {
            for (int j = 0; j < jtEncuesta.getColumnCount(); j++) {
                datos[j] = jtEncuesta.getValueAt(i, j).toString();
            }
            modelo.addRow(datos);
        }
        return modelo;
    }
// </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Metodos"> 

    private void buscar(String tabla) {
        frmConsultas consulta = new frmConsultas(null, true);//instancia el formulario con la ventana de busqueda
        consulta.consultar(tabla, "grid", null);//llama al metodo que se encuentra en la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda
    }

    private void cargarTotalRegistros() {
        int total = jtEncuesta.getRowCount();
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
        map.put("idPeriodo", codigoPeriodo.get(cmbPeriodo.getSelectedIndex()));
        map.put("observaciones", txaObservaciones.getText());

        //instacia el controlador
        ControladorEncuesta controladorEncuesta = new ControladorEncuesta();
        //llama al metodo para crear o actualizar segun sea la accion
        return controladorEncuesta.crearActualizar(map);

    }

    private void eliminar() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", lblId.getText());
        ControladorEncuesta controladorEncuesta = new ControladorEncuesta();
        controladorEncuesta.eliminar(map);
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
        jtEncuesta.getColumnModel().getColumn(0).setMaxWidth(0);
        jtEncuesta.getColumnModel().getColumn(0).setMinWidth(0);
        jtEncuesta.getColumnModel().getColumn(0).setPreferredWidth(0);

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

    private void llenarComboPeriodos() {
        controladorConsulta consulta = new controladorConsulta();

        criterioBusqueda[0] = "periodo";
        criterioBusqueda[1] = "tabla";
        cmbPeriodo.setModel(consulta.consultarCombo(criterioBusqueda));
        cmbPeriodo.setSelectedIndex(1);
        codigoPeriodo = consulta.getCodigoCombo();
    }

    private void llenarFiltro() {
        controladorConsulta consulta = new controladorConsulta();
        cmbFiltro.removeAllItems();
        for (int i = 1; i < consulta.getNumColumnas(); i++) {
            cmbFiltro.addItem(consulta.getNombColumnas()[i]);
        }
    }

    private void llenarGrid(String tipo) {
        jtEncuesta.setModel(controladorGrid.getInstance().llenarGrid(tipo, "grid", null, true));
        sorter = new TableRowSorter<>(jtEncuesta.getModel());
        jtEncuesta.setRowSorter(sorter);
        jtEncuesta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formatearColumnas();
    }

    private void llenarEncuesta(ArrayList<Object> datos) {
        lblId.setText(String.valueOf(datos.get(0)));
        cmbPeriodo.setSelectedItem(datos.get(1));
        txaObservaciones.setText((String) datos.get(2));

    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Variables declaration - do not modify                     "> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntarAnexos;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevo3;
    private javax.swing.JComboBox<String> cmbFiltro;
    public static javax.swing.JComboBox cmbPeriodo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpBusquedaEntrevista;
    private javax.swing.JPanel jpRegistroEntrevista;
    private javax.swing.JTable jtEncuesta;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JLabel lblTitulo_Id;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txtCriterioBusqueda;
    // End of variables declaration//GEN-END:variables
// </editor-fold> 
}
