package xuanc;

class Creature {
    public Creature() {
        System.out.println("Creature 无参数的构造器");
    }
}

class Animals extends Creature{
    public Animals(String name) {
        System.out.println("Animal 带一个参数的构造器");
    }
    public Animals(String name, int age) {
        this(name);
        System.out.println("Animal 带两个参数的构造器");
    }
}

/**
 * ClassName    Chapter5-Wolf
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-17 下午5:10
 */
public class Wolf extends Animals{
    public Wolf() {
        super("灰太狼", 3);
    }
    public static void main(String[] args) {
        new Wolf();
    }
}
