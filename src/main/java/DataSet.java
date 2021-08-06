import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DataSet {
    public static XYSeriesCollection xySeriesDataSet() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries datasetSeries = new XYSeries("");
        datasetSeries.add(0, 0);
        datasetSeries.add(1, 1);
        for (int i=0;i<19998;i++)
        {
            datasetSeries.add(1+i, (i*100+1));
        }
        dataset.addSeries(datasetSeries);
        return dataset;
    }
}
