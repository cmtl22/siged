package vista;

import controlador.controladorConfiguraciones;
import controlador.controladorConsulta;
import controlador.controladorVariablesSesion;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class frmPrincipal extends javax.swing.JFrame {

    private ImageIcon icon;

    public frmPrincipal() {
        initComponents();
        frmLogin frm = new frmLogin(null, true);
        frm.setVisible(true);
        //this.setDefaultCloseOperation(0);
        init();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("recursos/ico_sistema.jpg"));

        return retValue;
    }

    private void init() {
        if (controladorVariablesSesion.getInstance().getNombreUsuario() == null) {
            icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_sesion_iniciar_48.png"));
            btnCerrarSesion.setIcon(icon);
            btnCerrarSesion.setToolTipText("Iniciar Sesión");
        } else {
            icon = new ImageIcon(ClassLoader.getSystemResource("recursos/ico_sesion_cerrar_48.png"));
            btnCerrarSesion.setIcon(icon);
            btnCerrarSesion.setToolTipText("Cerrar Sesión");
            cargarPermisos();
        }

    }

    private void cargarPermisos() {
        dpContenedor.setSize(this.getSize());
        jpFondo.setSize(dpContenedor.getSize());
        lblNombreUsuario.setText(controladorVariablesSesion.getInstance().getNombresPersona());
        this.setTitle("SIGED 1.0.1 - " + controladorVariablesSesion.getInstance().getNombresPersona());
        String[] criterioBusqueda = new String[3];
        ArrayList permisos = new ArrayList();

        criterioBusqueda[0] = "permisos";//nombre de la tabla
        criterioBusqueda[1] = "filtrar";//tipo de consulta
        criterioBusqueda[2] = controladorVariablesSesion.getInstance().getPerfilUsuario();//id del perfil
        controladorConsulta consulta = new controladorConsulta();
        consulta.consultarCombo(criterioBusqueda);
        permisos = consulta.getCodigoCombo();

        for (Object permiso : permisos) {
            switch (permiso.toString()) {
                case "frmAcercamiento":
                    frmPrincipal.btnAcercamientos.setEnabled(true);
                    break;
                case "frmAgenda":
                    frmPrincipal.btnAgenda.setEnabled(true);
                    break;
                case "frmAsignatura":
                    frmPrincipal.btnAsignaturas.setEnabled(true);
                    break;
                case "frmAutoridades":
                    frmPrincipal.btnAutoridades.setEnabled(true);
                    break;
                case "frmBackup":
                    frmPrincipal.btnBackup.setEnabled(true);
                    break;
                case "frmCarrera":
                    frmPrincipal.btnCarreras.setEnabled(true);
                    break;
                case "frmConfiguraciones":
                    frmPrincipal.btnConfiguraciones.setEnabled(true);
                    break;
                case "frmConvenio":
                    frmPrincipal.btnConvenio.setEnabled(true);
                    break;
                case "frmCronograma":
                    frmPrincipal.btnCronograma.setEnabled(true);
                    break;
                case "frmDirectivos":
                    frmPrincipal.btnDirectivosContactos.setEnabled(true);
                    break;
                case "frmEmpresa":
                    frmPrincipal.btnEmpresa.setEnabled(true);

                    break;
                case "frmEncuesta":
                    frmPrincipal.btnEncuesta.setEnabled(true);

                    break;
                case "frmEntrevista":
                    frmPrincipal.btnEntrevista.setEnabled(true);

                    break;
                case "frmEstudiante":
                    frmPrincipal.btnEstudiante.setEnabled(true);

                    break;
                case "frmInstituto":
                    frmPrincipal.btnInstitutos.setEnabled(true);

                    break;
                case "frmParametrizacion":
                    frmPrincipal.btnParametrizacion.setEnabled(true);
                    break;
                case "frmPeriodoAcademico":
                    frmPrincipal.btnPeriodoAcademico.setEnabled(true);
                    break;
                case "frmPermisos":
                    frmPrincipal.btnPermisos.setEnabled(true);
                    break;
                case "frmReportes":
                    frmPrincipal.mnReportes.setEnabled(true);
                    break;
                case "frmReuniones":
                    frmPrincipal.btnReuniones.setEnabled(true);
                    break;
                case "frmSeguimientoEstudiantes":
                    frmPrincipal.btnSeguimientoEstudiantes.setEnabled(true);
                    break;
                case "frmSucursal":
                    frmPrincipal.btnSucursal.setEnabled(true);
                    break;
                case "frmTutorAcademico":
                    frmPrincipal.btnTutorAcademico.setEnabled(true);
                    break;
                case "frmTutorEmpresarial":
                    frmPrincipal.btnTutorEmpresarial.setEnabled(true);
                    break;
                case "frmUsuarios":
                    frmPrincipal.btnUsuarios.setEnabled(true);
                    break;
                case "frmViabilidad":
                    frmPrincipal.btnViabilidad.setEnabled(true);
                    break;
                default:
                    frmPrincipal.btnAcercamientos.setEnabled(false);
                    frmPrincipal.btnAsignaturas.setEnabled(false);
                    frmPrincipal.btnAutoridades.setEnabled(false);
                    frmPrincipal.btnBackup.setEnabled(false);
                    frmPrincipal.btnCarreras.setEnabled(false);
                    frmPrincipal.btnConfiguraciones.setEnabled(false);
                    frmPrincipal.btnConvenio.setEnabled(false);
                    frmPrincipal.btnCronograma.setEnabled(false);
                    frmPrincipal.btnDirectivosContactos.setEnabled(false);
                    frmPrincipal.btnEmpresa.setEnabled(false);
                    frmPrincipal.btnEncuesta.setEnabled(false);
                    frmPrincipal.btnEntrevista.setEnabled(false);
                    frmPrincipal.btnEstudiante.setEnabled(false);
                    frmPrincipal.btnInstitutos.setEnabled(false);
                    frmPrincipal.btnParametrizacion.setEnabled(false);
                    frmPrincipal.btnPeriodoAcademico.setEnabled(false);
                    frmPrincipal.btnPermisos.setEnabled(false);
                    frmPrincipal.mnReportes.setEnabled(false);
                    frmPrincipal.btnReuniones.setEnabled(false);
                    frmPrincipal.btnSeguimientoEstudiantes.setEnabled(false);
                    frmPrincipal.btnSucursal.setEnabled(false);
                    frmPrincipal.btnTutorAcademico.setEnabled(false);
                    frmPrincipal.btnTutorEmpresarial.setEnabled(false);
                    frmPrincipal.btnUsuarios.setEnabled(false);
                    frmPrincipal.btnViabilidad.setEnabled(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEncabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        dpContenedor = new javax.swing.JDesktopPane();
        jpFondo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        mnAdministracion = new javax.swing.JMenu();
        btnFormacionAcademica = new javax.swing.JMenu();
        btnInstitutos = new javax.swing.JMenuItem();
        btnCarreras = new javax.swing.JMenuItem();
        btnAsignaturas = new javax.swing.JMenuItem();
        btnEstudiante = new javax.swing.JMenuItem();
        btnTutorAcademico = new javax.swing.JMenuItem();
        btnPeriodoAcademico = new javax.swing.JMenu();
        btnAbrirPeriodo = new javax.swing.JMenuItem();
        btnAutoridades = new javax.swing.JMenuItem();
        btnFormacionEmpresarial = new javax.swing.JMenu();
        btnEmpresa = new javax.swing.JMenuItem();
        btnSucursal = new javax.swing.JMenuItem();
        btnTutorEmpresarial = new javax.swing.JMenuItem();
        btnDirectivosContactos = new javax.swing.JMenuItem();
        mnSeguimiento = new javax.swing.JMenu();
        btnCronograma = new javax.swing.JMenuItem();
        btnReuniones = new javax.swing.JMenuItem();
        btnSeguimientoEstudiantes = new javax.swing.JMenuItem();
        btnAcercamientos = new javax.swing.JMenuItem();
        btnEncuesta = new javax.swing.JMenuItem();
        mnLegalizacion = new javax.swing.JMenu();
        btnViabilidad = new javax.swing.JMenuItem();
        btnConvenio = new javax.swing.JMenuItem();
        btnEntrevista = new javax.swing.JMenuItem();
        mnReportes = new javax.swing.JMenu();
        btnReportes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnConfiguracion = new javax.swing.JMenu();
        btnUsuarios = new javax.swing.JMenuItem();
        btnPermisos = new javax.swing.JMenuItem();
        btnParametrizacion = new javax.swing.JMenuItem();
        btnConfiguraciones = new javax.swing.JMenuItem();
        btnBackup = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnAgenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpEncabezado.setPreferredSize(new java.awt.Dimension(945, 70));
        jpEncabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIENVENIDO");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 25));
        jpEncabezado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        lblNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreUsuario.setText("Nombre del usuario");
        lblNombreUsuario.setPreferredSize(new java.awt.Dimension(109, 25));
        jpEncabezado.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 890, -1));

        btnCerrarSesion.setToolTipText("Cerrar Sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setOpaque(false);
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(48, 48));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jpEncabezado.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, -1));

        getContentPane().add(jpEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        dpContenedor.setPreferredSize(new java.awt.Dimension(950, 605));

        jpFondo.setBackground(new java.awt.Color(255, 255, 255));
        jpFondo.setPreferredSize(new java.awt.Dimension(945, 535));
        jpFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_sistema.jpg"))); // NOI18N
        jpFondo.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 930, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("1.0.1");
        jLabel1.setPreferredSize(new java.awt.Dimension(35, 15));
        jpFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 535, -1, -1));

        dpContenedor.add(jpFondo);
        jpFondo.setBounds(0, 50, 945, 550);

        getContentPane().add(dpContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        jMenuBar2.setPreferredSize(new java.awt.Dimension(377, 20));

        mnAdministracion.setText("Administración");
        mnAdministracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnAdministracion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N

        btnFormacionAcademica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_institutos_32.png"))); // NOI18N
        btnFormacionAcademica.setText("Instituto");
        btnFormacionAcademica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormacionAcademica.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N

        btnInstitutos.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnInstitutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_institutos_32.png"))); // NOI18N
        btnInstitutos.setText("Instituto");
        btnInstitutos.setContentAreaFilled(false);
        btnInstitutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInstitutos.setEnabled(false);
        btnInstitutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstitutosActionPerformed(evt);
            }
        });
        btnFormacionAcademica.add(btnInstitutos);

        btnCarreras.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnCarreras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_carrera_24.png"))); // NOI18N
        btnCarreras.setText("Carrera");
        btnCarreras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarreras.setEnabled(false);
        btnCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarrerasActionPerformed(evt);
            }
        });
        btnFormacionAcademica.add(btnCarreras);

        btnAsignaturas.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnAsignaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_asignatura_32.jpg"))); // NOI18N
        btnAsignaturas.setText("Asignatura");
        btnAsignaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsignaturas.setEnabled(false);
        btnAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignaturasActionPerformed(evt);
            }
        });
        btnFormacionAcademica.add(btnAsignaturas);

        btnEstudiante.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_estudiante_32.png"))); // NOI18N
        btnEstudiante.setText("Estudiante");
        btnEstudiante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstudiante.setEnabled(false);
        btnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudianteActionPerformed(evt);
            }
        });
        btnFormacionAcademica.add(btnEstudiante);

        btnTutorAcademico.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnTutorAcademico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_tutorA_32.png"))); // NOI18N
        btnTutorAcademico.setText("Tutor Académico");
        btnTutorAcademico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTutorAcademico.setEnabled(false);
        btnTutorAcademico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorAcademicoActionPerformed(evt);
            }
        });
        btnFormacionAcademica.add(btnTutorAcademico);

        btnPeriodoAcademico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_periodo_academico_32.png"))); // NOI18N
        btnPeriodoAcademico.setText("Periodo Académico");
        btnPeriodoAcademico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPeriodoAcademico.setEnabled(false);
        btnPeriodoAcademico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPeriodoAcademicoMouseClicked(evt);
            }
        });

        btnAbrirPeriodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_abrir_periodo_32.png"))); // NOI18N
        btnAbrirPeriodo.setText("Abrir Periodo");
        btnAbrirPeriodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbrirPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirPeriodoActionPerformed(evt);
            }
        });
        btnPeriodoAcademico.add(btnAbrirPeriodo);

        btnFormacionAcademica.add(btnPeriodoAcademico);

        btnAutoridades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_autoridades_32.png"))); // NOI18N
        btnAutoridades.setText("Autoridades");
        btnAutoridades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAutoridades.setEnabled(false);
        btnAutoridades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoridadesActionPerformed(evt);
            }
        });
        btnFormacionAcademica.add(btnAutoridades);

        mnAdministracion.add(btnFormacionAcademica);

        btnFormacionEmpresarial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_empresa_32.gif"))); // NOI18N
        btnFormacionEmpresarial.setText("Empresa");
        btnFormacionEmpresarial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormacionEmpresarial.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N

        btnEmpresa.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_empresa_32.gif"))); // NOI18N
        btnEmpresa.setText("Empresa");
        btnEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpresa.setEnabled(false);
        btnEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpresaActionPerformed(evt);
            }
        });
        btnFormacionEmpresarial.add(btnEmpresa);

        btnSucursal.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_sucursal_32.jpg"))); // NOI18N
        btnSucursal.setText("Sucursal");
        btnSucursal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSucursal.setEnabled(false);
        btnSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSucursalActionPerformed(evt);
            }
        });
        btnFormacionEmpresarial.add(btnSucursal);

        btnTutorEmpresarial.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnTutorEmpresarial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_tutorE_32.png"))); // NOI18N
        btnTutorEmpresarial.setText("Tutor Empresarial");
        btnTutorEmpresarial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTutorEmpresarial.setEnabled(false);
        btnTutorEmpresarial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorEmpresarialActionPerformed(evt);
            }
        });
        btnFormacionEmpresarial.add(btnTutorEmpresarial);

        btnDirectivosContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_directivos_32.png"))); // NOI18N
        btnDirectivosContactos.setText("Directivos y Contactos");
        btnDirectivosContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDirectivosContactos.setEnabled(false);
        btnDirectivosContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectivosContactosActionPerformed(evt);
            }
        });
        btnFormacionEmpresarial.add(btnDirectivosContactos);

        mnAdministracion.add(btnFormacionEmpresarial);

        jMenuBar2.add(mnAdministracion);

        mnSeguimiento.setText("Seguimiento");
        mnSeguimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnSeguimiento.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N

        btnCronograma.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnCronograma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_cronograma_32.png"))); // NOI18N
        btnCronograma.setText("Planificación");
        btnCronograma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCronograma.setEnabled(false);
        btnCronograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCronogramaActionPerformed(evt);
            }
        });
        mnSeguimiento.add(btnCronograma);

        btnReuniones.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnReuniones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_reunion_32.jpg"))); // NOI18N
        btnReuniones.setText("Reuniones");
        btnReuniones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReuniones.setEnabled(false);
        btnReuniones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReunionesActionPerformed(evt);
            }
        });
        mnSeguimiento.add(btnReuniones);

        btnSeguimientoEstudiantes.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnSeguimientoEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_seguimiento_estudiante_32.png"))); // NOI18N
        btnSeguimientoEstudiantes.setText("Seguimiento Estudiantes");
        btnSeguimientoEstudiantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSeguimientoEstudiantes.setEnabled(false);
        btnSeguimientoEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguimientoEstudiantesActionPerformed(evt);
            }
        });
        mnSeguimiento.add(btnSeguimientoEstudiantes);

        btnAcercamientos.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnAcercamientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_acercamiento_32.jpg"))); // NOI18N
        btnAcercamientos.setText("Acercamientos");
        btnAcercamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcercamientos.setEnabled(false);
        btnAcercamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercamientosActionPerformed(evt);
            }
        });
        mnSeguimiento.add(btnAcercamientos);

        btnEncuesta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_encuesta_32.png"))); // NOI18N
        btnEncuesta.setText("Encuesta");
        btnEncuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEncuesta.setEnabled(false);
        btnEncuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncuestaActionPerformed(evt);
            }
        });
        mnSeguimiento.add(btnEncuesta);

        jMenuBar2.add(mnSeguimiento);

        mnLegalizacion.setText("Legalización");
        mnLegalizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnLegalizacion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N

        btnViabilidad.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnViabilidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_informe_32.png"))); // NOI18N
        btnViabilidad.setText("Informe Viabilidad");
        btnViabilidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViabilidad.setEnabled(false);
        btnViabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViabilidadActionPerformed(evt);
            }
        });
        mnLegalizacion.add(btnViabilidad);

        btnConvenio.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnConvenio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_convenio_32.png"))); // NOI18N
        btnConvenio.setText("Convenio");
        btnConvenio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConvenio.setEnabled(false);
        btnConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvenioActionPerformed(evt);
            }
        });
        mnLegalizacion.add(btnConvenio);

        btnEntrevista.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnEntrevista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_entrevista_32.png"))); // NOI18N
        btnEntrevista.setText("Entrevista");
        btnEntrevista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrevista.setEnabled(false);
        btnEntrevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrevistaActionPerformed(evt);
            }
        });
        mnLegalizacion.add(btnEntrevista);

        jMenuBar2.add(mnLegalizacion);

        mnReportes.setText("Reportes");
        mnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnReportes.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N

        btnReportes.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_reportes_32.png"))); // NOI18N
        btnReportes.setText("Reportes Dinamicos");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setEnabled(false);
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });
        mnReportes.add(btnReportes);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_informe_32.png"))); // NOI18N
        jMenuItem1.setText("Informe Viabilidad");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnReportes.add(jMenuItem1);

        jMenuItem2.setText("Seguimiento Estudiante");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnReportes.add(jMenuItem2);

        jMenuItem4.setText("Historial Seguimiento Academico Individual");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnReportes.add(jMenuItem4);

        jMenuBar2.add(mnReportes);

        mnConfiguracion.setText("Configuración");
        mnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnConfiguracion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N

        btnUsuarios.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_usuarios_32.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setEnabled(false);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        mnConfiguracion.add(btnUsuarios);

        btnPermisos.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnPermisos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_permisos_32 (2).png"))); // NOI18N
        btnPermisos.setText("Permisos");
        btnPermisos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPermisos.setEnabled(false);
        btnPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermisosActionPerformed(evt);
            }
        });
        mnConfiguracion.add(btnPermisos);

        btnParametrizacion.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12)); // NOI18N
        btnParametrizacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_parametrizacion_32.png"))); // NOI18N
        btnParametrizacion.setText("Parametrización");
        btnParametrizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnParametrizacion.setEnabled(false);
        btnParametrizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametrizacionActionPerformed(evt);
            }
        });
        mnConfiguracion.add(btnParametrizacion);

        btnConfiguraciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_configuraciones_32.png"))); // NOI18N
        btnConfiguraciones.setText("Configuraciones");
        btnConfiguraciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguraciones.setEnabled(false);
        btnConfiguraciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionesActionPerformed(evt);
            }
        });
        mnConfiguracion.add(btnConfiguraciones);

        btnBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_backup_32.png"))); // NOI18N
        btnBackup.setText("Backup");
        btnBackup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackup.setEnabled(false);
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });
        mnConfiguracion.add(btnBackup);

        jMenuBar2.add(mnConfiguracion);

        jMenu1.setText("Agenda");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        btnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/ico_agenda_32.jpg"))); // NOI18N
        btnAgenda.setText("Contactos");
        btnAgenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgenda.setEnabled(false);
        btnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaActionPerformed(evt);
            }
        });
        jMenu1.add(btnAgenda);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        setSize(new java.awt.Dimension(966, 662));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Eventos">    
    private void btnConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvenioActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmConvenio frm = new frmConvenio();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnConvenioActionPerformed

    private void btnPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermisosActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmAsignarPermisos frm = new frmAsignarPermisos();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnPermisosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            jpEncabezado.setVisible(false);
            frmUsuario frmusu = new frmUsuario();
            dpContenedor.add(frmusu);
            frmusu.setSize(dpContenedor.getSize());
            frmusu.setVisible(true);
            frmusu.setResizable(false);
        }
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignaturasActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmAsignatura frm = new frmAsignatura();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnAsignaturasActionPerformed

    private void btnSeguimientoEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguimientoEstudiantesActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmSeguimientoEstudiante frm = new frmSeguimientoEstudiante();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnSeguimientoEstudiantesActionPerformed

    private void btnReunionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReunionesActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmSeguimientoReunion frm = new frmSeguimientoReunion();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnReunionesActionPerformed

    private void btnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpresaActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmEmpresa frm = new frmEmpresa();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnEmpresaActionPerformed

    private void btnAcercamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercamientosActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmAcercamiento frm = new frmAcercamiento();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnAcercamientosActionPerformed

    private void btnInstitutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstitutosActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmInstituto frm = new frmInstituto();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnInstitutosActionPerformed

    private void btnEntrevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrevistaActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmEntrevista frm = new frmEntrevista();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnEntrevistaActionPerformed

    private void btnSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSucursalActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmSucursal frm = new frmSucursal();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }

    }//GEN-LAST:event_btnSucursalActionPerformed

    private void btnTutorEmpresarialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorEmpresarialActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmTutorEmpresarial frm = new frmTutorEmpresarial();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnTutorEmpresarialActionPerformed

    private void btnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudianteActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmEstudiante frm = new frmEstudiante();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnEstudianteActionPerformed

    private void btnTutorAcademicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorAcademicoActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmTutorAcademico frm = new frmTutorAcademico();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnTutorAcademicoActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        controladorVariablesSesion.getInstance().setPerfilUsuario(null);
        controladorVariablesSesion.getInstance().setNombreUsuario(null);
        frmLogin frmslog = new frmLogin(null, true);
        frmslog.setVisible(true);
        init();

    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnViabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViabilidadActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmViabilidad frm = new frmViabilidad();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnViabilidadActionPerformed

    private void btnCronogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCronogramaActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmCronograma frm = new frmCronograma();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnCronogramaActionPerformed

    private void btnParametrizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametrizacionActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmParametrizacion frm = new frmParametrizacion();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnParametrizacionActionPerformed

    private void btnCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarrerasActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmCarrera frm = new frmCarrera();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnCarrerasActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        frmReportes reportes = new frmReportes();
        reportes.setVisible(true);

    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnEncuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncuestaActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmEncuesta frm = new frmEncuesta();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnEncuestaActionPerformed

    private void btnConfiguracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionesActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmConfiguraciones frm = new frmConfiguraciones();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnConfiguracionesActionPerformed

    private void btnPeriodoAcademicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPeriodoAcademicoMouseClicked
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmPeriodo frm = new frmPeriodo();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnPeriodoAcademicoMouseClicked

    private void btnAbrirPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirPeriodoActionPerformed
        frmAbrirPeriodo consulta = new frmAbrirPeriodo(null, true);//instancia la el formulario con la ventana de busqueda
        consulta.setVisible(true);//hace visible la ventan de busqueda

    }//GEN-LAST:event_btnAbrirPeriodoActionPerformed

    private void btnAutoridadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoridadesActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmAutoridadesInstituto frm = new frmAutoridadesInstituto();
            //frmPersonaInstituto frm = new frmPersonaInstituto();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnAutoridadesActionPerformed

    private void btnDirectivosContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectivosContactosActionPerformed
        if (!validarFormularios()) {
            controladorVariablesSesion.getInstance().setContadorVentanas(1);
            frmPrincipal.jpEncabezado.setVisible(false);
            frmDirectivosYContactos frm = new frmDirectivosYContactos();
            dpContenedor.add(frm);
            frm.setSize(dpContenedor.getSize());
            frm.setVisible(true);
            frm.setResizable(false);
        }
    }//GEN-LAST:event_btnDirectivosContactosActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        controladorConfiguraciones.getInstance().generarBackup();
    }//GEN-LAST:event_btnBackupActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        /*        Map parametros = new HashMap();
         parametros.put("p_numero_informe_principal", "SENESCYT-SFTT-001-2016");
         controladorReporte reporte = new controladorReporte();
         reporte.generarReporte("viabilidad", parametros);*/
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        try {
            File informe = new File("c:/seguimiento_estudiante.pdf");
            Desktop.getDesktop().open(informe);

            /*Map parametros = new HashMap();
             parametros.put("p_titulo", "REPORTE SEGUIMIENTO ESTUDIANTE");
             parametros.put("p_cabecera", "SEGUIMIENTO ESTUDIANTE INDIVIDUAL");
             parametros.put("p_condicion", "");
             controladorReporte reporte = new controladorReporte();
             reporte.generarReporte("segumiento_estudiantes", parametros);*/
        } catch (IOException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            File informe = new File("c:/seguimiento_estudiante_historial.pdf");
            Desktop.getDesktop().open(informe);

            /*        Map parametros = new HashMap();
             parametros.put("p_titulo", "REPORTE SEGUIMIENTO ESTUDIANTE");
             parametros.put("p_cabecera", "SEGUIMIENTO ESTUDIANTE INDIVIDUAL");
             parametros.put("p_id_estudiante", 4);
             controladorReporte reporte = new controladorReporte();
             reporte.generarReporte("historial_segumiento_estudiantes_individual", parametros);*/
        } catch (IOException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaActionPerformed
        frmAgenda agenda = new frmAgenda();
        agenda.setVisible(true);
    }//GEN-LAST:event_btnAgendaActionPerformed
// </editor-fold >  

    // <editor-fold defaultstate="collapsed" desc="Metodos">    
    private boolean validarFormularios() {
        if (controladorVariablesSesion.getInstance().getContadorVentanas() >= controladorVariablesSesion.getInstance().getLimiteVentanas()) {
            return true;
        } else {
            return false;
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
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAbrirPeriodo;
    public static javax.swing.JMenuItem btnAcercamientos;
    public static javax.swing.JMenuItem btnAgenda;
    public static javax.swing.JMenuItem btnAsignaturas;
    public static javax.swing.JMenuItem btnAutoridades;
    public static javax.swing.JMenuItem btnBackup;
    public static javax.swing.JMenuItem btnCarreras;
    private javax.swing.JButton btnCerrarSesion;
    public static javax.swing.JMenuItem btnConfiguraciones;
    public static javax.swing.JMenuItem btnConvenio;
    public static javax.swing.JMenuItem btnCronograma;
    public static javax.swing.JMenuItem btnDirectivosContactos;
    public static javax.swing.JMenuItem btnEmpresa;
    public static javax.swing.JMenuItem btnEncuesta;
    public static javax.swing.JMenuItem btnEntrevista;
    public static javax.swing.JMenuItem btnEstudiante;
    private javax.swing.JMenu btnFormacionAcademica;
    private javax.swing.JMenu btnFormacionEmpresarial;
    public static javax.swing.JMenuItem btnInstitutos;
    public static javax.swing.JMenuItem btnParametrizacion;
    public static javax.swing.JMenu btnPeriodoAcademico;
    public static javax.swing.JMenuItem btnPermisos;
    public static javax.swing.JMenuItem btnReportes;
    public static javax.swing.JMenuItem btnReuniones;
    public static javax.swing.JMenuItem btnSeguimientoEstudiantes;
    public static javax.swing.JMenuItem btnSucursal;
    public static javax.swing.JMenuItem btnTutorAcademico;
    public static javax.swing.JMenuItem btnTutorEmpresarial;
    public static javax.swing.JMenuItem btnUsuarios;
    public static javax.swing.JMenuItem btnViabilidad;
    private javax.swing.JDesktopPane dpContenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    public static javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JMenu mnAdministracion;
    private javax.swing.JMenu mnConfiguracion;
    private javax.swing.JMenu mnLegalizacion;
    public static javax.swing.JMenu mnReportes;
    private javax.swing.JMenu mnSeguimiento;
    // End of variables declaration//GEN-END:variables
// </editor-fold >    
}
