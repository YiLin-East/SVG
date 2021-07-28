//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.data.xy.XYDataset;
//import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RefineryUtilities;
//
///**
// * A simple line chart using data from an {@link XYDataset}.
// *原版实例
// */
//public class LineChartDemo4 extends ApplicationFrame {
//
//    /**
//     * Creates a new demo.
//     *
//     * @param title  the frame title.
//     */
//    public LineChartDemo4(final String title) {
//
//        super(title);
//
//        // create a dataset...
//        final XYDataset dataset = new SampleXYDataset();
//
//        // create the chart...
//        final JFreeChart chart = ChartFactory.createXYLineChart("Line Chart Demo 4", // chart title
//                "X", // x axis label
//                "Y", // y axis label
//                dataset, // data
//                PlotOrientation.VERTICAL, true, // include legend
//                true, // tooltips
//                false // urls
//        );
//
//        final XYPlot plot = chart.getXYPlot();
//        plot.getDomainAxis().setLowerMargin(0.0);
//        plot.getDomainAxis().setUpperMargin(0.0);
//
//        // add the chart to a panel...
//        final ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//        setContentPane(chartPanel);
//
//    }
//
//    // ****************************************************************************
//    // * JFREECHART DEVELOPER GUIDE                                               *
//    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
//    // * to purchase from Object Refinery Limited:                                *
//    // *                                                                          *
//    // * http://www.object-refinery.com/jfreechart/guide.html                     *
//    // *                                                                          *
//    // * Sales are used to provide funding for the JFreeChart project - please    *
//    // * support us so that we can continue developing free software.             *
//    // ****************************************************************************
//
//    /**
//     * Starting point for the demonstration application.
//     *
//     * @param args  ignored.
//     */
//    public static void main(final String[] args) {
//
//        final LineChartDemo4 demo = new LineChartDemo4("Line Chart Demo 4");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//
//    }
//
//}
//
