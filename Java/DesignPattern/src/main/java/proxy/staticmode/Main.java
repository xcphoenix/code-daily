package proxy.staticmode;

/**
 * @author      xuanc
 * @date        2020/2/14 下午4:48
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {

        TwelveMonkeysMovie monkeysMovie = new TwelveMonkeysMovie();
        Movie movie = new Cinema(monkeysMovie);
        movie.play();

    }

}
