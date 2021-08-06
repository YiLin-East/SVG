
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 渲染合成
 */
public class LineChart {
    private static TickUnitSource CeilingTickUnit;

    //XY数据集 支持多条折线
    private static XYDataset xyDataset(){
        XYSeries xySeries=new XYSeries("1");
        xySeries.add(1,10);
        XYSeriesCollection xySeriesCollection=new XYSeriesCollection();
        xySeriesCollection.addSeries(xySeries);
        return xySeriesCollection;
    }

    //创建图片
    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(
                "Earth",
                "时间",
                "熵值",
                dataset,//数据来源
                PlotOrientation.VERTICAL,//纵横方向
                false, // 是否包含图例
                true, // 提示信息是否显示
                false);// 是否使用urls


        //边框
        chart.setBorderStroke(new BasicStroke(0.3f));            //设置边框宽度
        chart.setBorderVisible(true);                            //设置边框是否可见
        chart.setBorderPaint(Color.black);                       //设置边框着色
        ChartUtils.applyCurrentTheme(chart);

        // 设置主题样式
        // StandardChartTheme standardChartTheme=new StandardChartTheme("CN");//中文主题
        // standardChartTheme.setAxisOffset(new RectangleInsets(5,12,5,12));
        // ChartFactory.setChartTheme(standardChartTheme);

        //背景、网格线
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);   //背景颜色
        plot.setRangeGridlinePaint(Color.gray);//设置网格横线颜色
        plot.setRangeGridlinesVisible(true);       //网格横线是否显示

        plot.setDomainGridlinePaint(Color.gray);  //纵向网格线颜色
        plot.setDomainGridlinesVisible(true);    //显示纵向网格线
        plot.setDomainGridlinesVisible(true);
        //
        plot.setRangeGridlineStroke(new BasicStroke(0.2f));//数据轴网格线条笔触
        plot.setDomainGridlineStroke(new BasicStroke(0.2f));//
        //plot.setDomainAxis(set);
        plot.setAxisOffset(new RectangleInsets(5D,0D,5D,0D));//设置坐标轴与图表显示部分距离
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);//设置范围轴右对齐(Y轴的数字在右边)
        //边框可见
        plot.setOutlineVisible(true);

        //设置字体避免乱码
        Font xfont = new Font("宋体", Font.PLAIN, 12);
        Font yfont = new Font("宋体", Font.PLAIN, 12);
        Font zfont = new Font("宋体", Font.PLAIN, 12);

        // X轴//刻度线
        CategoryAxis domainAxis=new IntervalCategoryAxis(10);//10组数据/为一间隔
       // CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(xfont);
        domainAxis.setTickLabelFont(xfont);
        domainAxis.setTickLabelPaint(Color.black);//标签颜色
        domainAxis.setTickMarkOutsideLength(3);//x轴刻度线向下延申部分
        domainAxis.setAxisLineVisible(true);
        domainAxis.setTickMarksVisible(true);//刻度线


        //domainAxis.setTickLabelInsets(new RectangleInsets(0.0,0.5,1.0,2.2));
        // x轴 label斜显示
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        plot.setDomainAxis(domainAxis);

        // Y轴
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.15d);
        // rangeAxis.setLowerMargin(0.01d);//下边距
        rangeAxis.setAutoTickUnitSelection(false);
        //设置纵坐标值的间距为
        rangeAxis.setTickUnit(new NumberTickUnit(1000000));
        //纵坐标值范围
        rangeAxis.setRangeWithMargins(-2000000, 18000000);
        rangeAxis.setLabelFont(yfont);
        rangeAxis.setTickLabelPaint(Color.blue);
        rangeAxis.setTickLabelFont(yfont);
        rangeAxis.setAxisLineVisible(true);//y轴坐标线
        rangeAxis.setTickMarksVisible(true);//y轴标线

        //创建整数刻度单位
        //rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        //走势线
        // DecimalFormat format = new DecimalFormat("#%");//设置数字格式
        // rangeAxis.setNumberFormatOverride(format);

        //渲染器
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        //设置形状
        renderer.setDefaultShapesVisible(false);//是否又圆点
        renderer.setDefaultShapesFilled(true);
        //轮廓
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setSeriesShape(0, new Ellipse2D.Double(-5d, -5d, 10d, 10d));
        renderer.setSeriesPaint(0, new Color(49,133,156));   //设置每个分组的线的颜色
        //折线的粗细
        renderer.setSeriesStroke(0,new BasicStroke(0.6f));
        renderer.setDefaultFillPaint(Color.black);//折线颜色
        //折线带数字否
        //renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00%")));
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelFont(zfont);//折线label字体
        return chart;
    }

    /**
     * 二次修改
     * @param dataset
     */
    private static JFreeChart createModifiedChart(XYSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart("Earth", "时间", "熵值",dataset);

        XYPlot xyPlot = chart.getXYPlot();
        xyPlot.setBackgroundPaint(Color.white);
        xyPlot.setDomainGridlinePaint(Color.gray);
        xyPlot.setRangeGridlinePaint(Color.gray);

        // set up font, still some issue occurs
        Font xFont = new Font("宋体", Font.PLAIN, 12);
        Font yFont = new Font("宋体", Font.PLAIN, 12);

        // x axis
       //重写valueAxis
        //ValueAxis domainAxis =new IntervalValueAxis("",CeilingTickUnit);
        ValueAxis domainAxis = chart.getXYPlot().getDomainAxis();
        domainAxis.setLabelFont(xFont);
        domainAxis.setTickLabelFont(xFont);
        domainAxis.setTickLabelPaint(Color.black);
        //xyPlot.setDomainAxis(domainAxis);

        // Y axis
        ValueAxis valueAxis = chart.getXYPlot().getRangeAxis();
        valueAxis.setUpperMargin(0.15d);
        // set the range of the Y axis
       // valueAxis.setStandardTickUnits((TickUnitSource) new NumberTickUnit(1000000));
        valueAxis.setRangeWithMargins(-2000000, 18000000);
        valueAxis.setLabelFont(yFont);
        valueAxis.setTickLabelFont(yFont);
        valueAxis.setTickLabelPaint(Color.blue);


        // 绘制自定义网格线 draw custom gridlines
        for(double i=0;i<20000;i+=1000) {
            ValueMarker marker = new ValueMarker(i, new Color(192, 192, 192), new BasicStroke(0.5f));
            xyPlot.addDomainMarker(marker);
        }

        //渲染折线
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) xyPlot.getRenderer();
        //设置形状
        renderer.setDefaultShapesVisible(false);//是否又圆点
        renderer.setDefaultShapesFilled(true);
        //轮廓
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setSeriesShape(0, new Ellipse2D.Double(-5d, -5d, 10d, 10d));
        renderer.setSeriesPaint(0, new Color(49,133,156));   //设置每个分组的线的颜色
        //折线的粗细
        renderer.setSeriesStroke(0,new BasicStroke(0.3f));
        renderer.setDefaultFillPaint(Color.black);//折线颜色
        renderer.setDefaultItemLabelsVisible(true);
        return chart;
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(currentTime);
    }

    public static void main(String[] args) {
        JFreeChart jFreeChart;
        // jFreeChart = createChart(createData.dataset());
        jFreeChart = createModifiedChart(DataSet.xySeriesDataSet());
        String path = "D:\\Azhuomian\\SVG\\"+getStringDate()+".svg";
        //String path = getStringDate()+".svg";
        System.out.println(path);
        //根据width或者height自动生成合适间隔
        try {
            SaveChartSVG.save(path,jFreeChart,0,0,1000,500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
