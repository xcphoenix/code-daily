package proxy.staticmode;

/**
 * proxy object
 *
 * @author      xuanc
 * @date        2020/2/14 下午4:42
 * @version     1.0
 */ 
public class Cinema implements Movie {

    private Movie realMovie;

    public Cinema(Movie realMovie) {
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        doSome(true);
        realMovie.play();
        doSome(false);
    }

    private void doSome(boolean isStart) {
        if (isStart) {
            System.out.println("电影马上开始，请各位就坐，为了电影的播放效果，请将手机关机或调至静音。");
        } else {
            System.out.println("请大家有序立场，携带好自己的随身物品，照顾好自己的小孩。");
        }
    }

}
