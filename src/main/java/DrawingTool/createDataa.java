package DrawingTool;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class createDataa {
    public static CategoryDataset dataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0,  "null", (Comparable) 0);
        dataset.addValue(18000000, "null",(Comparable) 1);
        dataset.addValue(10000000,  "null",(Comparable) 2);
        dataset.addValue(11551200,  "null", (Comparable) 3);
        dataset.addValue(12551200,  "null", (Comparable) 4);
        dataset.addValue(9551200,  "null", (Comparable) 5);
        dataset.addValue(20000000,  "null", (Comparable) 6);



        for (int i=0;i<500;i++)
        {
            dataset.addValue(9551200+i*5000,"null",  (Comparable) (6+i));
        }
        return dataset;//columnkey
    }
}
