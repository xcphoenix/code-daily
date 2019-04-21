package xuanc.spittr;

import org.apache.commons.lang3.builder.*;
import java.util.Date;

/**
 * ClassName    Chapter5-Spittle
 * Description  包含消息内容、时间戳和位置信息
 *
 * @author      xuanc
 * @date        19-4-20 下午9:58
 * @version     1.0
 */ 
public class Spittle {

    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longtime;

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(String message, Date time, Double longtime, Double latitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.longtime = longtime;
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLongtime() {
        return longtime;
    }

    public Double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }

}
