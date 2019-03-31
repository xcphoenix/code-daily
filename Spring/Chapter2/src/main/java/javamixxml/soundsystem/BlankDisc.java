package javamixxml.soundsystem;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName    Chapter2-BlankDisc
 * @author xuanc
 * @version 1.0
 * @date 19-3-30 下午7:48
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }

}
