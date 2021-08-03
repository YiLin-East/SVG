
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.util.SVGConstants;
import org.jfree.chart.JFreeChart;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 保存为SVG格式
 */
public class SaveChartSVG {
    public static boolean save(String path,JFreeChart chart,int x,int y,int width,int height){
        try {
            // THE FOLLOWING CODE BASED ON THE EXAMPLE IN THE BATIK DOCUMENTATION...
            // Get a DOMImplementation
           // DOMImplementation domImpl = GenericDOMImplementation .getDOMImplementation();
            final String namespaceURI = SVGConstants.SVG_NAMESPACE_URI;
            // Create an instance of org.w3c.dom.Document创建 org.w3c.dom.Document 的实例
            //Document document = domImpl.createDocument(namespaceURI, "svg", null);
            final DOMImplementation impl = GenericDOMImplementation.getDOMImplementation();
          //final String namespaceURI = SVGConstants.SVG_NAMESPACE_URI;
            final Document domFactory = impl.createDocument(namespaceURI, "svg", null);
            // Create an instance of the SVG Generator 创建 SVG Generator 的实例
            SVGGraphics2D svgGenerator = new SVGGraphics2D(domFactory);
            svgGenerator.setSVGCanvasSize(new Dimension(width,height));
            // set the precision to avoid a null pointer exception in Batik
            svgGenerator.getGeneratorContext().setPrecision(6);
            // Ask the chart to render into the SVG Graphics2D implementation
            chart.draw(svgGenerator,new Rectangle2D.Double(x, y, width, height), null);
            // Finally, stream out SVG to a file using UTF-8 character to
            // byte encoding
            boolean useCSS = true;
            Writer out = new OutputStreamWriter(new FileOutputStream(new File(
                    path)), "UTF-8");
            svgGenerator.stream(out, useCSS);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}


