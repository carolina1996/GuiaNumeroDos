package sv.edu.unab.GuiaDos.Formularios;
import sv.edu.unab.GuiaDos.Dominio.Cliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class formularioClasico {
    public JPanel pnlPrincipal;
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtMaterno;
    private JTextArea atxtDireccion;
    private JButton btnAgregar;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JTable tblCliente;
    private JTextField txtTelefono;
    private JComboBox cboTipo;
    private JTextField txtBusqueda;
    private JButton btnGuardarEdicion;

    ArrayList<Cliente> listado=new ArrayList<>();
    ArrayList<Cliente> Filtrado=new ArrayList();
    String Codigo;
    String Nombre;
    String ApellidoPaterno;
    String ApellidoMaterno;
    String Direccion;
    Integer Telefono;
    Character Tipo;

    public formularioClasico(){
        initcomponents();
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


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente c=new Cliente();
                c.setCodigo(String.valueOf(new Random().nextInt()));
                c.setNombre(txtNombre.getText());
                c.setApellidoPaterno(txtPaterno.getText());
                c.setApellidoMaterno(txtMaterno.getText());
                c.setDireccion(atxtDireccion.getText());
                c.setTelefono(Integer.parseInt(txtTelefono.getText()));
                c.setTipoCliente(cboTipo.getSelectedItem().toString().charAt(0));
                listado.add(c);
                Actualizar(listado);
                limpiarcomponentes();
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText(Nombre);
                txtPaterno.setText(ApellidoPaterno);
                txtMaterno.setText(ApellidoMaterno);
                txtTelefono.setText(String.valueOf(Telefono));

                if (Tipo.equals('V')){
                    cboTipo.setSelectedItem(0);
                }
                else if(Tipo.equals('C')){
                    cboTipo.setSelectedItem(1);
                }
                else{
                    cboTipo.setSelectedItem(2);
                }
            }
        });
        btnGuardarEdicion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<listado.size();i++){
                    if (Codigo.equals(listado.get(i).getCodigo())){
                        listado.get(i).setNombre(txtNombre.getText());
                        listado.get(i).setApellidoPaterno(txtPaterno.getText());
                        listado.get(i).setApellidoMaterno(txtMaterno.getText());
                        listado.get(i).setDireccion(atxtDireccion.getText());
                        listado.get(i).setTelefono(Integer.valueOf(txtTelefono.getText()));
                        listado.get(i).setTipoCliente(cboTipo.getSelectedItem().toString().charAt(0));
                    }
                }
                Actualizar(listado);
                limpiarcomponentes();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0; i<listado.size(); i++){
                    if(Codigo==listado.get(i).getCodigo()){
                        listado.remove(i);
                    }
                    Actualizar(listado);
                    limpiarcomponentes();
                }
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String parametroNombre=txtBusqueda.getText();
                Filtrado.clear();
                for (int i=0;i<listado.size();i++){
                    if (parametroNombre.equals(listado.get(i).getNombre())){
                        Cliente cli=new Cliente();
                        cli.setCodigo(listado.get(i).getCodigo());
                        cli.setNombre(listado.get(i).getNombre());
                        cli.setApellidoPaterno(listado.get(i).getApellidoPaterno());
                        cli.setApellidoMaterno(listado.get(i).getApellidoMaterno());
                        cli.setDireccion(listado.get(i).getDireccion());
                        cli.setTelefono(listado.get(i).getTelefono());
                        cli.setTipoCliente(listado.get(i).getTipoCliente());
                        Filtrado.add(cli);
                    }
                }
                Actualizar(Filtrado);
            }
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

    private void initcomponents() {
        listado.add(new Cliente(String.valueOf(new Random().nextInt()), "Karla Michelle", "Rivera", "Aleman", "Sierpe",78674563, 'V'));
        listado.add(new Cliente(String.valueOf(new Random().nextInt()), "Reina Carolina", "Serrano", "Luna", "Angostura",23674563, 'E'));
        listado.add(new Cliente(String.valueOf(new Random().nextInt()), "Kevin Ricardo", "Serrano", "Luna", "Luna",79974563, 'V'));

        Actualizar(listado);
    }

    public void Actualizar(ArrayList<Cliente> listado){
        String matriz[][] = new String[listado.size()][8];
        for(int i = 0; i<listado.size(); i++){
            matriz[i][0]= listado.get(i).getCodigo();
            matriz[i][1]= listado.get(i).getNombre();
            matriz[i][2]= listado.get(i).getApellidoPaterno();
            matriz[i][3]= listado.get(i).getApellidoMaterno();
            matriz[i][4]= listado.get(i).getDireccion();
            matriz[i][5]= Integer.toString(listado.get(i).getTelefono());
            matriz[i][6]= String.valueOf(listado.get(i).getTipoCliente().toString().charAt(0));
        }
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[]
                {"Codigo","Nombre","Apellido Paterno","Apellido Materno", "Direccion","Telefono","Tipo"}));

        //EdadPromedio();

    }


    public void limpiarcomponentes(){
        txtNombre.setText(null);
        txtPaterno.setText(null);
        txtMaterno.setText(null);
        atxtDireccion.setText(null);
        txtTelefono.setText(null);
        cboTipo.setSelectedItem(0);
    }


}

