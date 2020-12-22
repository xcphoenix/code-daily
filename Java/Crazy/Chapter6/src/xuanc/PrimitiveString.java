package xuanc;

/**
 * ClassName    Chapter6-PrimitiveString
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-21 下午8:09
 */
public class PrimitiveString {

    public static void main(String[] args) {
        Integer inObj = 5;
        int it = inObj;

        String intStr = "123";
        int it1 = Integer.parseInt(intStr);
        int it2 = Integer.valueOf(intStr);

        String ftStr = String.valueOf(2.345);
    }
}
