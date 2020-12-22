package xuanc;

public enum GenderImp implements GenderDesc{
    /**
     * 性别
     * --------------
     * 此处的枚举值必须调用对应的构造器来创建
     * ------------------------------
     * 花括号实际上是一个类体部分，匿名内部子类
     * 抽象枚举类系统会用 abstract 修饰而不是 final，所以可以有子类
     */
    MALE("男") {
        @Override
        public void info() {
            System.out.println("嚯哟！我是 MALE");
        }
    },
    FEMALE("女") {
        @Override
        public void info() {
            System.out.println("嚯哟！我是 FEMALE");
        }

    };

    private String name;

    private GenderImp(String name) {
        this.name = name;
    }

    public void setName(String name) {
        final String male = "男", female = "女";

        switch (this) {
            case MALE: {
                if (male.equals(name)) {
                    this.name = name;
                } else {
                    System.out.println("参数错误");
                    return;
                }
                break;
            }

            case FEMALE: {
                if (female.equals(name)) {
                    this.name = "女";
                } else {
                    System.out.println("参数错误");
                    return;
                }
                break;
            }
            default:
                break;
        }
    }

    public String getName() {
        return name;
    }

    /**
     * 每个枚举值在调用该方法时的行为一样
     * ---------------------------
     * 如果需要每个枚举值在调用该方法时呈现不同的行为，可以让每个枚举值分别来实现该方法
     */
    @Override
    public void info() {
        System.out.println("这是一个用于定义性别的枚举类");
    }
}
