import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.ui.RectangleEdge;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * x轴刻度
 */
public class IntervalValueAxis extends ValueAxis {


    public IntervalValueAxis(String label, TickUnitSource standardTickUnits) {
        super(label, standardTickUnits);
    }

    @Override
    public double valueToJava2D(double v, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        return 0;
    }

    @Override
    public double java2DToValue(double v, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        return 0;
    }

    @Override
    protected void autoAdjustRange() {

    }

    @Override
    public void configure() {

    }

    @Override
    public AxisState draw(Graphics2D graphics2D, double v, Rectangle2D rectangle2D, Rectangle2D rectangle2D1, RectangleEdge rectangleEdge, PlotRenderingInfo plotRenderingInfo) {
        return null;
    }

    @Override
    public List refreshTicks(Graphics2D graphics2D, AxisState axisState, Rectangle2D rectangle2D, RectangleEdge rectangleEdge) {
        return null;
    }
}
