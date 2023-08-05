/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CheckBoxTableCellRenderer extends DefaultTableCellRenderer {
    private JCheckBox checkBox;

    public CheckBoxTableCellRenderer() {
        checkBox = new JCheckBox();
        checkBox.setHorizontalAlignment(JCheckBox.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Obtener el valor actual de la celda (debe ser un booleano)
        boolean selected = (value != null) && (Boolean) value;
        
        // Configurar el estado del checkbox según el valor de la celda
        checkBox.setSelected(selected);
        
        // Establecer el color de fondo y la selección según corresponda
        if (isSelected) {
            checkBox.setBackground(table.getSelectionBackground());
            checkBox.setForeground(table.getSelectionForeground());
        } else {
            checkBox.setBackground(table.getBackground());
            checkBox.setForeground(table.getForeground());
        }
        
        return checkBox;
    }
}
