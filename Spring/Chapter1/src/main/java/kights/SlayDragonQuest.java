package kights;

import java.io.PrintStream;

/**
 * ClassName    Spring1-SlayDragonQuest
 * Description  TODO
 * @author      xuanc
 * @date        19-3-18 下午4:04
 * @version     1.0
 */ 
public class SlayDragonQuest implements Quest{

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }
}
