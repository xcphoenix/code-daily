package soundsystem;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName    Spring4-TrackCounter
 * Description  切面：记录每个磁道所播放的次数
 *              ------------------------
 *              移除 @AspectJ 注解，使用 XML 配合
 *
 * @author      xuanc
 * @date        19-4-14 上午11:19
 * @version     1.0
 */
public class TrackCounter {

    private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();

    public void trackPlayed(int trackNumber) {}

    public void countTrack(int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }
}
