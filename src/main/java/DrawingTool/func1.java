//package DrawingTools;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.axis.CategoryAxis;
//import org.jfree.chart.axis.NumberAxis;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
//import org.jfree.chart.ui.ApplicationFrame;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.ui.RefineryUtilities;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//
//public class func1 extends ApplicationFrame {
//    private static int length;
//
//    public func1(String string) {
//        super(string);
//        JPanel jpanel = createDemoPanel();
//        jpanel.setPreferredSize(new Dimension(500, 270));
//        setContentPane(jpanel);
//    }
//
//    public static void main(String[] args) throws IOException {
//        func1 linechartdemo1 = new func1("");
//        linechartdemo1.pack();
//        RefineryUtilities.centerFrameOnScreen(linechartdemo1);
//        linechartdemo1.setVisible(true);
//    }
//
//    /**
//     *
//     * @Description 创建面板
//     * @author 冯月
//     * @date Feb 27, 2017 4:03:02 PM
//     * @action createDemoPanel
//     * @return JPanel
//     */
//    public static JPanel createDemoPanel() {
//        JFreeChart jfreechart = createChart(createDataset());
//        try {
//
//            ChartUtilities.saveChartAsJPEG(new File("D:/ecg.png"), // 文件保存物理路径包括路径和文件名
//                    // 1.0f, //图片质量 ，0.0f~1.0f
//                    jfreechart, // 图表对象
//                    1920, // 图像宽度 ，这个将决定图表的横坐标值是否能完全显示还是显示省略号
//                    1080);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new ChartPanel(jfreechart);
//    }
//
//    /**
//     *
//     * @Description 配置
//     * @author 冯月
//     * @date Feb 25, 2017 2:15:10 PM
//     * @action createChart
//     * @return JFreeChart
//     */
//    private static JFreeChart createChart(CategoryDataset categorydataset) {
//        JFreeChart jfreechart = ChartFactory.createLineChart("", // 图表标题
//                "", // 主轴标签（x轴）
//                "", // 范围轴标签（y轴）
//                categorydataset, // 数据集
//                PlotOrientation.VERTICAL, // 方向
//                false, // 是否包含图例
//                false, // 提示信息是否显示
//                false);// 是否使用urls
//        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
//        categoryplot.setBackgroundPaint(Color.WHITE);
//
//        // 获取显示线条的对象
//        LineAndShapeRenderer lasp = (LineAndShapeRenderer) categoryplot.getRenderer();
//        // 设置线条颜色
//        lasp.setSeriesPaint(0, Color.BLUE);
//        categoryplot.setRangeGridlinePaint(Color.RED); // 设置纵向网格线红色
//        categoryplot.setDomainGridlinePaint(Color.RED); // 设置横向网格线红色
//
//        CategoryAxis domainAxis = categoryplot.getDomainAxis();
//
//        domainAxis.setMaximumCategoryLabelLines(1000);
//        domainAxis.setLowerMargin(0.0); // 设置距离图片左端距离
//        domainAxis.setUpperMargin(0.0); // 设置距离图片右端距离
//
//        // 设置背景线为实线
//        categoryplot.setDomainGridlineStroke(new BasicStroke(1.0f));
//        categoryplot.setRangeGridlineStroke(new BasicStroke(1.0f));
//
//        // 去除Y轴标注
//        NumberAxis numAxis = (NumberAxis) categoryplot.getRangeAxis();
//        numAxis.setVisible(false);
//
//        return jfreechart;
//    }
//
//    /**
//     *
//     * @Description 获取数据源
//     * @author 冯月
//     * @date Feb 25, 2017 2:15:03 PM
//     * @action createDataset
//     * @return DefaultCategoryDataset
//     */
//    public static DefaultCategoryDataset createDataset() {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        byte[] array2;
//        try {
//            array2 = toByteArray2("C:/Users/joker/Desktop/ecg.txt");
//            short[] convertRawData = utils.convertRawData(array2);
//            length = convertRawData.length;
//            System.out.println(length);
//            for (int i = 0; i < length; i++) {
//                dataset.addValue(convertRawData[i], "", String.valueOf(i));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return dataset;
//    }
//
//    /**
//     *
//     * @Description 数据转换
//     * @author 冯月
//     * @date Feb 25, 2017 2:14:44 PM
//     * @action toByteArray2
//     * @return byte[]
//     */
//    public static byte[] toByteArray2(String filename) throws IOException {
//        File f = new File(filename);
//        if (!f.exists()) {
//            throw new FileNotFoundException(filename);
//        }
//        FileChannel channel = null;
//        FileInputStream fs = null;
//        try {
//            fs = new FileInputStream(f);
//            channel = fs.getChannel();
//            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
//            while ((channel.read(byteBuffer)) > 0) {
//                // do nothing
//                // System.out.println("reading");
//            }
//            return byteBuffer.array();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            try {
//                channel.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                fs.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
//
