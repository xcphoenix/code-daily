package xml.soundsystem;

import org.springframework.stereotype.Component;

import javax.inject.Named;

/**
 * ClassName    Chapter2-SgtPeppers
 * Description  创建 CompactDisc 的一个实现
 * @author      xuanc
 * @date        19-3-18 下午9:59
 * @version     1.0
 */

public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
