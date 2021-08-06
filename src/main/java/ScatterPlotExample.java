import DrawingTool.ReadFid;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 散点图示例 导出通过swing GUI
 */
public class ScatterPlotExample extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;
    private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;

    public ScatterPlotExample(String title) {
        super(title);

        // Create dataset
        XYDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createScatterPlot(
                "散点图",
                "X",
                "Y",
                //dataset
                DataSet.xySeriesDataSet()
        );


        //Changes background color
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255, 228, 196));


        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        //数据集
        XYSeries series1 = new XYSeries("代表啥数据");
        series1.add(1, 72.9);
        series1.add(2, 81.6);
        series1.add(3, 88.9);
        series1.add(4, 96);
        series1.add(5, 102.1);
        series1.add(6, 108.5);
        series1.add(7, 113.9);
        series1.add(8, 119.3);
        series1.add(9, 123.8);
        series1.add(10, 124.4);
        for (int i=11;i<65526;i++){
            series1.add(i,100);
        }
        dataset.addSeries(series1);
        return dataset;
    }

    public static void main(String[] args) {

        System.out.println(
                Arrays.deepToString(ReadFid.readFidSpecFile("D:\\Azhuomian\\1r", 65536, 1, LITTLE_ENDIAN, "1"))
        );
        SwingUtilities.invokeLater(() -> {
            ScatterPlotExample example = new ScatterPlotExample("Example");
            example.setSize(1000, 500);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
