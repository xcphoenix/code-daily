package xuanc.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xuanc.spittr.Spittle;
import xuanc.spittr.data.SpittleRepository;

import java.util.List;

/**
 * ClassName    Chapter5-SpittleController
 * Description  在模型中放入最新的 spittle 列表
 *
 * @author      xuanc
 * @date        19-4-21 下午8:39
 * @version     1.0
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    /**
     * 注入 SpittleRepository bean
     * @param spittleRepository 要注入的 bean
     */
    @Autowired
    public SpittleController (SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * 处理有参数和没有参数的场景
     * @param max 最大值
     * @param count 总计
     * @return List
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles (
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    /**
     * 通过路径参数接受输入
     * @param spittleId some...
     * @param model some...
     * @return 视图 spittle
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId,
            Model model ) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    /**
     * 使用占位符，将 Spittle ID 来作为路径的一部分
     * 如果 @PathVariable 没有 value 属性的话，会假设占位符的名称与方法的参数名相同
     */
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model ) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

}
