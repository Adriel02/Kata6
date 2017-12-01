package view;

import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class HistogramDisplay <T> extends ApplicationFrame{

    private final Histogram<T> histogram;
    private final String nameEjeX;

    public HistogramDisplay(Histogram<T> histogram, String nameEjeX) {
        super("HISTOGRAM");
        this.histogram = histogram;
        this.nameEjeX = nameEjeX;
        setContentPane(createPanel());
        pack();
    }


    public void execute(){
        setVisible(true);
    }

    private JPanel createPanel(){
        ChartPanel chartPanel= new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart",
                nameEjeX,
                "Nº emails",dataSet, PlotOrientation.VERTICAL,rootPaneCheckingEnabled,
                rootPaneCheckingEnabled,rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T key: histogram.keySet()){
            dataset.addValue(histogram.get(key),"",(Comparable) key);
        }
        return dataset;
    }
}
