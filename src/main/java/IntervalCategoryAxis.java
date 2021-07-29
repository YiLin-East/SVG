import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.text.TextBlock;
import org.jfree.chart.ui.RectangleEdge;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * X轴坐标数据量过多
 * 方法重写
 * 解决
 * https://www.cnblogs.com/lovling/p/14583853.html
 */
public class IntervalCategoryAxis extends CategoryAxis {

    private final int Num;  // 间隔数

    public IntervalCategoryAxis(int Num) {
        this.Num = Num;
    }

    /**
     * 重写获取横坐标的方法，根据num踩点展示，防止横坐标密密麻麻
     */
    @Override
    public List<Tick> refreshTicks(Graphics2D g2, AxisState state, Rectangle2D dataArea, RectangleEdge edge) {
        List<Tick> ticks = new ArrayList<>();
        if (dataArea.getHeight() <= 0.0 || dataArea.getWidth() < 0.0) {
            return ticks;
        }
        CategoryPlot plot = (CategoryPlot) getPlot();
        List<?> categories = plot.getCategoriesForAxis(this);
        double max = 0.0;
        if (categories != null) {
            CategoryLabelPosition position = super.getCategoryLabelPositions().getLabelPosition(edge);
            int categoryIndex = 0;
            for (Object o : categories) {
                Comparable<?> category = (Comparable<?>) o;
                g2.setFont(getTickLabelFont(category));
                TextBlock label = new TextBlock();
                label.addLine(category.toString(), getTickLabelFont(category), getTickLabelPaint(category));
                if (edge == RectangleEdge.TOP || edge == RectangleEdge.BOTTOM) {
                    max = Math.max(max, calculateTextBlockHeight(label, position, g2));
                } else if (edge == RectangleEdge.LEFT || edge == RectangleEdge.RIGHT) {
                    max = Math.max(max, calculateTextBlockWidth(label, position, g2));
                }
                if (categoryIndex % Num == 0) {
                    Tick tick = new CategoryTick(category, label, position.getLabelAnchor(), position.getRotationAnchor(), position.getAngle());
                    ticks.add(tick);
                }
                categoryIndex = categoryIndex + 1;
            }
        }
        state.setMax(max);
        return ticks;
    }

}
