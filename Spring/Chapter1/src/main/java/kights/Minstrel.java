package kights;

import java.io.PrintStream;

/**
 * ClassName    Spring1-Minstrel
 * Description  TODO
 * @author      xuanc
 * @date        19-3-18 下午4:42
 * @version     1.0
 */ 
public class Minstrel {

    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    /**
     * 探险前
     */
    public void singBeforeQuest() {
        stream.println("Fa la la, the knight is so brave!");
    }

    /**
     * 探险后
     */
    public void singAfterQuest() {
        stream.println("Tee hee hee, the brave knight did embark on a quest!");
    }
}
