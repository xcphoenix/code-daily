package soundsystem;

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

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
        for (String track : tracks) {
            System.out.println("-Track: " + track);
        }
    }

    public void playTrack(int trackNumber) {
        System.out.println("Playing " + title + " by " + artist);
        if (trackNumber <= tracks.size()) {
            System.out.println("-Track" + tracks.get(trackNumber));
        }
        else {
            System.out.println(" Sorry, not found!");
        }
    }
}
