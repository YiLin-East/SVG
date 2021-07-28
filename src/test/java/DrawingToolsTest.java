//import java.math.BigDecimal;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class DrawingToolsTest {
//    public void testTools() {
//        int sum = 20;//随机生成20对数
//        Map<Double, Double> map1 = new HashMap<>();
//        double[] restX = RandomTools.getRadomDouble(1, 20, 1, sum);
//        double[] restY = RandomTools.getRadomDouble(1, 20, 1, sum);
//        for (int i = 0; i < sum; i++) {
//            map1.put(restX[i], restY[i]);
//        }
//
//        Map<Double, Double> map2 = new HashMap<>();
//        for (int i = 0; i < sum; i++) {
//            map2.put(restY[i], restX[i]);
//        }
//
//        Map<Double, Double>[] dataSet = new Map[]{map1, map2};
//        String[] types = new String[]{"A", "B"};
//        //调用绘图工具
//        DrawingTools.drawLineChart("axin", "测试", "这是X轴",
//                "这是y轴", dataSet, types);
//
//        Scanner in = new Scanner(System.in);
//        in.hasNext();
//    }
//}
//
///**
// * @author Axin
// */
//class RandomTools {
//    /**
//     * @param start
//     * @param end
//     * @param retain 保留几位小数
//     * @param sum    生成多少个数
//     * @return
//     */
//    public static double[] getRadomDouble(int start, int end, int retain, int sum) {
//        double[] res = new double[sum];
//
//        for (int i = 0; i < sum; i++) {
//            BigDecimal db = new BigDecimal(Math.random() * (end - start) + start);
//            //四舍五入
//            res[i] = db.setScale(retain, BigDecimal.ROUND_HALF_UP).doubleValue();
//        }
//        return res;
//    }
//}
//
