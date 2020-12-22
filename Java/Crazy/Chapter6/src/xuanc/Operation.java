package xuanc;

/**
 * @author xuanc
 */
public enum Operation {
    /**
     * 加减乘除
     */
    PLUS {
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };

    /**
     *     为枚举类定义一个抽象方法
     *     这个方法由不同的枚举值来提供不同的实现
     */
    public abstract double eval(double x, double y);

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.eval(3, 4));
        System.out.println(Operation.MINUS.eval(3, 4));
        System.out.println(Operation.TIMES.eval(3, 4));
        System.out.println(Operation.DIVIDE.eval(3, 4));
    }
}
