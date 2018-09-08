package sv.edu.unab.GuiaDos.Formularios;

import sv.edu.unab.GuiaDos.Dominio.Cliente;

import javax.swing.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class formularioStreamAPI {
    public JPanel pnlPrincipal;
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtMaterno;
    private JTextArea atxtDireccion;
    private JTextField txtTelefono;
    private JComboBox cboTipo;
    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnGuardarEdicion;
    private JButton btnBuscar;
    private JTable tblCliente;
    private JTextField txtBusqueda;


    List<Cliente> listadoModel, filtradoModel;
    String Codigo;
    String Nombre;
    String ApellidoPaterno;
    String ApellidoMaterno;
    String Direccion;
    Integer Telefono;
    Character Tipo;

    public formularioStreamAPI() {
        initcomponents();
    }

    public void initcomponents(){
        tblCliente.setFillsViewportHeight(true);
        if (listadoModel==null){
            listadoModel=new ArrayList<>();
        }
        listadoModel.add(new Cliente(String.valueOf(new Random().nextInt()), "Karla Michelle", "Rivera", "Aleman", "Sierpe",78674563, 'V'));
        listadoModel.add(new Cliente(String.valueOf(new Random().nextInt()), "Reina Carolina", "Serrano", "Luna", "Angostura",23674563, 'E'));
        listadoModel.add(new Cliente(String.valueOf(new Random().nextInt()), "Kevin Ricardo", "Serrano", "Luna", "Luna",79974563, 'V'));
        ActualizarDatos(listadoModel);

        btnAgregar.addActionListener(e->{
            Cliente c=new Cliente();
            c.setCodigo(String.valueOf(new Random().nextInt()));
            c.setNombre(txtNombre.getText());
            c.setApellidoPaterno(txtPaterno.getText());
            c.setApellidoMaterno(txtMaterno.getText());
            c.setDireccion(atxtDireccion.getText());
            c.setTelefono(Integer.parseInt(txtTelefono.getText()));
            c.setTipoCliente(cboTipo.getSelectedItem().toString().toUpperCase().charAt(0));
            listadoModel.add(c);
            ActualizarDatos(listadoModel);
            limpiar();
        });

        btnEditar.addActionListener(e->{
            txtNombre.setText(Nombre);
            txtPaterno.setText(ApellidoPaterno);
            txtMaterno.setText(ApellidoMaterno);
            atxtDireccion.setText(Direccion);
            txtTelefono.setText(String.valueOf(Telefono));

        });

        btnGuardarEdicion.addActionListener(e->{
            listadoModel.stream().forEach(c->{
                if (c.getCodigo().equals(Codigo))
                {
                    c.setNombre(txtNombre.getText());
                    c.setApellidoPaterno(txtPaterno.getText());
                    c.setApellidoMaterno(txtMaterno.getText());
                    c.setDireccion(atxtDireccion.getText());
                    c.setTelefono(Integer.valueOf(txtTelefono.getText()));
                    c.setTipoCliente(cboTipo.getSelectedItem().toString().charAt(0));
                }
                limpiar();
                ActualizarDatos(listadoModel);
            });
        });

        btnEliminar.addActionListener(e->{
            listadoModel.removeIf(c->c.getCodigo().equals(Codigo));
            ActualizarDatos(listadoModel);
        });

        btnBuscar.addActionListener(e->{
            List<Cliente> busqueda=listadoModel.stream().filter(m->{
                boolean respuesta=false;
                if (m.getNombre().equals(txtNombre.getText())){
                    respuesta=true;
                }
                return  respuesta;
            }).collect(Collectors.toList());
            ActualizarDatos(busqueda);

        });




        tblCliente.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                int i=tblCliente.getSelectedRow();
                Codigo =(tblCliente.getValueAt(i,0).toString());
                Nombre=(tblCliente.getValueAt(i,1).toString());
                ApellidoPaterno=(tblCliente.getValueAt(i,2).toString());
                ApellidoMaterno=(tblCliente.getValueAt(i,3).toString());
                Direccion=(tblCliente.getValueAt(i,4).toString());
                Telefono=Integer.parseInt(tblCliente.getValueAt(i,5).toString());
                Tipo=(tblCliente.getValueAt(i,6).toString().charAt(0));

            }
        });



    }
    private void ActualizarDatos(List<Cliente> listado){
        DefaultTableModel modelo=new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Direccion");
        modelo.addColumn("telefono");
        modelo.addColumn("Tipo");

        listado.stream().forEach(c->{
            modelo.addRow(new Object[]{
                    c.getCodigo(),
                    c.getNombre(),
                    c.getApellidoPaterno(),
                    c.getApellidoMaterno(),
                    c.getDireccion(),
                    c.getTelefono(),
                    c.getTipoCliente()

            });
        });
        tblCliente.setModel(modelo);
    }
    public void limpiar(){
        txtNombre.setText(null);
        txtPaterno.setText(null);
        txtMaterno.setText(null);
        atxtDireccion.setText(null);
        txtTelefono.setText(null);
        cboTipo.setSelectedItem(1);
    }



}
