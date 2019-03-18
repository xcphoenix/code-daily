package xuanc;

import javax.xml.crypto.Data;

/**
 * ClassName    Chapter5-ReferenceTransferTest
 * Description  TODO
 * @author      xuanc
 * @date        19-3-16 下午5:09
 * @version     1.0
 */

class DataWrap {
    int a;
    int b;
}

public class ReferenceTransferTest {
    public static void swap(DataWrap dw) {
        int temp = dw.a;
        dw.a = dw.b;
        dw.b = temp;
        System.out.println("a = " + dw.a + ", b = " + dw.b);
    }
    public static void main(String[] args) {
        DataWrap dw = new DataWrap();
        dw.a = 6;
        dw.b = 9;
        swap(dw);
        System.out.println("a = " + dw.a + ", b = " + dw.b);
    }
}
