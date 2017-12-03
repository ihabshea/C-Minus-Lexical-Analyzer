/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivedescentcalculator;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import tokens.token;

/**
 *
 * @author ihab
 */
public class TokenModel extends AbstractTableModel {

    public static final String[] columnNames = {"Token"};
    private ArrayList<token> data;

    public TokenModel(ArrayList<token> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    public String getColumnName(int column) {
    return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        token Token = data.get(rowIndex);
        if (Token == null) {
            return null;
        }
        switch (columnIndex) {
            case 0:
                return Token.toString();
            default:
                return null;
        }
    }

}
