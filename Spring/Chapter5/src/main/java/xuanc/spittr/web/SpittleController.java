package xuanc.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xuanc.spittr.data.SpittleRepository;

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

    /**
     * 注入 SpittleRepository bean
     * @param spittleRepository 要注入的 bean
     */
    @Autowired
    public SpittleController (SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        // 将 spittle 添加到模型中
        model.addAttribute(
                spittleRepository.findSpittles(Long.MAX_VALUE, 20)
        );
        // 返回视图名
        return "spittles";
    }

}
