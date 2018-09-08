package sv.edu.unab.GuiaDos.Main;
import  sv.edu.unab.GuiaDos.Formularios.formularioClasico;
import sv.edu.unab.GuiaDos.Formularios.formularioStreamAPI;

import javax.swing.*;
import java.awt.*;

public class MainDos {
    public static void main(String[] args) {
        //Obteniendo resoluciones de pantalla
        Dimension resolucionPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //Ajustando tamaño del formulario
        Dimension ajusteTamaño = new Dimension(resolucionPantalla.width/2,resolucionPantalla.height - 100);
        JFrame frm = new JFrame("Gestio de Clientes Fashion mod con Stream API");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setContentPane(new formularioStreamAPI().pnlPrincipal);
        frm.setPreferredSize(ajusteTamaño);
        frm.setResizable(false);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }
}
