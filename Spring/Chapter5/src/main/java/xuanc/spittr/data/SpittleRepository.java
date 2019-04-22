package xuanc.spittr.data;

import xuanc.spittr.Spittle;
import java.util.List;

/**
 * ClassName    Chapter5-SpittleRepository
 * Description  定义数据访问的接口
 *
 * @author      xuanc
 * @date        19-4-20 下午9:56
 * @version     1.0
 */ 
public interface SpittleRepository {
    /**
     * 方法..
     * @param max 最大值
     * @param count 计数
     * @return Spittle List
     */
    List<Spittle> findSpittles(long max, int count);

    /**
     * 方法...
     * @param spittleId ...
     * @return Spittle
     */
    Spittle findOne(long spittleId);
}
