package xuanc.spittr.Spittle;

import xuanc.Spittle;
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
    List<Spittle> findSpittles(long max, int count);
}
