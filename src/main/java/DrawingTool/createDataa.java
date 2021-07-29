package DrawingTool;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class createDataa {
    public static CategoryDataset dataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0,  "null", (Comparable) 0);
        dataset.addValue(18000000, "null",(Comparable) 100);
        dataset.addValue(10000000,  "null",(Comparable) 200);
        dataset.addValue(11551200,  "null", (Comparable) 300);
        dataset.addValue(12551200,  "null", (Comparable) 400);
        dataset.addValue(9551200,  "null", (Comparable) 500);
        dataset.addValue(20000000,  "null", (Comparable) 600);
        dataset.addValue(0,  "null", (Comparable) 700);
        dataset.addValue(18000000, "null",(Comparable) 800);
        dataset.addValue(10000000,  "null",(Comparable) 900);
        dataset.addValue(11551200,  "null", (Comparable) 1000);
        dataset.addValue(12551200,  "null", (Comparable) 1100);
        dataset.addValue(9551200,  "null", (Comparable) 1200);
        dataset.addValue(20000000,  "null", (Comparable) 1300);
        dataset.addValue(0,  "null", (Comparable) 1400);
        dataset.addValue(18000000, "null",(Comparable) 1500);


        for (int i=0;i<500;i++)
        {
            dataset.addValue(9551200+i*5000,"null",  (Comparable) (1500+i*100));
        }
        return dataset;//columnkey
    }
}
