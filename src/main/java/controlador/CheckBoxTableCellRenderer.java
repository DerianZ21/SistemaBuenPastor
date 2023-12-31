/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JCheckBox;

public class CheckBoxTableCellRenderer extends DefaultTableCellRenderer {
    private final JCheckBox checkBox;

    public CheckBoxTableCellRenderer() {
        checkBox = new JCheckBox();
        checkBox.setHorizontalAlignment(JCheckBox.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        checkBox.setSelected((boolean) value);
        return checkBox;
    }
}
