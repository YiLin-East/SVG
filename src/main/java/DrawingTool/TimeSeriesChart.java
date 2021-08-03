//package DrawingTool;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtils;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.DateAxis;
//import org.jfree.chart.axis.ValueAxis;
//import org.jfree.chart.plot.XYPlot;
//import org.jfree.data.time.Month;
//import org.jfree.data.time.TimeSeries;
//import org.jfree.data.time.TimeSeriesCollection;
//import org.jfree.data.xy.XYDataset;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//
///**
// * 非平滑曲线
// * 曲线图
// *
// * @author wzx
// * @date 2018-04-09
// */
//public class TimeSeriesChart {
//
//    public static void main(String[] args) throws IOException {
//        XYDataset xyDataset = createDataset();
//        JFreeChart chart = ChartFactory.createTimeSeriesChart("小时/点击数", "小时", "点击数",
//                xyDataset, true, true, true);
//        XYPlot plot = (XYPlot) chart.getPlot();
//        DateAxis dateaxis = (DateAxis) plot.getDomainAxis();
//        dateaxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
//        //dateaxis.setLabelFont(new java.awt.Font("黑体", Font., 14));         //水平底部标题
//        //dateaxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));  //垂直标题
//        ValueAxis rangeAxis = plot.getRangeAxis();//获取柱状
//        //rangeAxis.setLabelFont(new Font("黑体", Font.PLAIN, 15));
//        //chart.getLegend().setItemFont(new Font("黑体", , 15));
//        //chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));//设置标题字体
//
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream("D://Azhuomian//SVG//2.jpg");
//            ChartUtils.writeChartAsJPEG(out, 0.5f, chart, 400, 300, null);
//        } finally {
//            try {
//                out.close();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    private static XYDataset createDataset() {
//        TimeSeries timeseries = new TimeSeries("点击数");
//        timeseries.add(new Month(2, 2001), 181.80000000000001D);
//        timeseries.add(new Month(3, 2001), 167.30000000000001D);
//        timeseries.add(new Month(4, 2001), 153.80000000000001D);
//        timeseries.add(new Month(5, 2001), 167.59999999999999D);
//        timeseries.add(new Month(6, 2001), 158.80000000000001D);
//        timeseries.add(new Month(7, 2001), 148.30000000000001D);
//        timeseries.add(new Month(8, 2001), 153.90000000000001D);
//        timeseries.add(new Month(9, 2001), 142.69999999999999D);
//        timeseries.add(new Month(10, 2001), 123.2D);
//        timeseries.add(new Month(11, 2001), 131.80000000000001D);
//        timeseries.add(new Month(12, 2001), 139.59999999999999D);
//        timeseries.add(new Month(1, 2002), 142.90000000000001D);
//        timeseries.add(new Month(2, 2002), 138.69999999999999D);
//        timeseries.add(new Month(3, 2002), 137.30000000000001D);
//        timeseries.add(new Month(4, 2002), 143.90000000000001D);
//        timeseries.add(new Month(5, 2002), 139.80000000000001D);
//        timeseries.add(new Month(6, 2002), 137D);
//        timeseries.add(new Month(7, 2002), 132.80000000000001D);
//        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
//        timeseriescollection.addSeries(timeseries);
//        return timeseriescollection;
//    }
//}
