package xuanc.test;

/**
 * ClassName    Chapter15-ExampleTwo
 * Description  
 *
 * @author      xuanc
 * @date        19-5-8 下午2:55
 * @version     1.0
 */ 
public class ExampleTwo extends Example implements java.io.Serializable {

    private double two;

    public ExampleTwo(String name, int age, double two) {
        super(name, age);
        this.two = two;
    }

    public double getTwo() {
        return two;
    }

    public void setTwo(double two) {
        this.two = two;
    }
}
