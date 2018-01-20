/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.adapters.adapterStat;

import edu.esprit.pidev.dao.classes.StatCoursDAO;
import edu.esprit.pidev.dao.classes.statcommentaireDAO;
import edu.esprit.pidev.entities.CoursApprenant;
import edu.esprit.pidev.entities.StatCours;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rihab
 */
public class StatForumTableModel extends AbstractTableModel {

    private static ObservableList<BarChart.Series> bcData;

    private List<String> names;
    private List<Integer> data;

    public StatForumTableModel() {

        statcommentaireDAO sdao = new statcommentaireDAO();
        data = sdao.GetNombreCommentaire();
        names = sdao.Getsujet();
    }

    public List<String> getNames() {
        return names;
    }

    public double getTickUnit() {
        return 1000;
    }

    public List<String> getColumnNames() {
        return names;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data.get(column);
    }

    @Override
    public String getColumnName(int column) {
        return names.get(column);
    }

    @Override
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        if (value instanceof Integer) {
            data.set(column, (Integer) value);
        }

        fireTableCellUpdated(row, column);
    }

    public ObservableList<BarChart.Series> getBarChartData() {
        if (bcData == null) {
            bcData = FXCollections.<BarChart.Series>observableArrayList();
            for (int row = 0; row < getRowCount(); row++) {
                ObservableList<BarChart.Data> series = FXCollections.<BarChart.Data>observableArrayList();
                for (int column = 0; column < getColumnCount(); column++) {
                    series.add(new BarChart.Data(getColumnName(column), getValueAt(row, column)));
                }

                bcData.add(new BarChart.Series(series));
            }
        }
        return bcData;
    }
}
