package edu.esprit.pidev.GUI.Admin.outils;

import edu.esprit.pidev.adapters.adapterStat.StatCoursTableModel;
import edu.esprit.pidev.adapters.adapterStat.StatNombreTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;

public class StatNombrePanel extends JPanel {

    private static JFXPanel chartFxPanel;
    private static StatNombreTableModel tableModel;
    private Chart chart;

    public StatNombrePanel() {
        revalidate();
        repaint();
        tableModel = new StatNombreTableModel();
        // create javafx panel for charts
        chartFxPanel = new JFXPanel();

        JPanel panel = new JPanel();
        this.setLayout(new BorderLayout());

        //JTable
        JTable table = new JTable(tableModel);
        JScrollPane tablePanel = new JScrollPane(table);

        this.add(chartFxPanel, BorderLayout.CENTER);
        tablePanel.setPreferredSize(new Dimension(200, 120));
        this.add(tablePanel, BorderLayout.SOUTH);
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            public void run() {
                chart = createBarChart();

                chartFxPanel.setScene(new Scene(chart));
            }
        });

    }

    //**************************************  BARCHART
    private BarChart createBarChart() {

        /*NumberAxis xAxis = new NumberAxis();
        CategoryAxis yAxis = new CategoryAxis();

        System.out.println(tableModel.getBarChartData());
        final BarChart<Number, String> localChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series s = new XYChart.Series<>();
        for (String columnName : tableModel.getColumnNames()) {
            s.getData().add(new XYChart.Data(50, columnName));
        }

        localChart.getData().add(s);

        return localChart;*/
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(tableModel.getColumnNames()));
        xAxis.setLabel("Les Statuts des utilisateurs");

        double tickUnit = tableModel.getTickUnit();

        NumberAxis yAxis = new NumberAxis();
        yAxis.setTickUnit(1);
        yAxis.setLabel("Nombre d'utilisateur par statut");

        final BarChart chart = new BarChart(xAxis, yAxis, tableModel.getBarChartData());
        
        return chart;
    }

    //**************************************        DECIMAL FORMAT 
    private static class DecimalFormatRenderer extends DefaultTableCellRenderer {

        private static final DecimalFormat formatter = new DecimalFormat("#.0");//au moins une place pour un nombre puis poiny puis zero

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            value = formatter.format((Number) value);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

}
