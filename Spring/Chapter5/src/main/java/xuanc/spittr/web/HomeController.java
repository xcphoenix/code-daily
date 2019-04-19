package xuanc.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName    Chapter5-HomeController
 * Description  使用 @Controller 声明一个超级简单的控制器
 *
 * @author      xuanc
 * @date        19-4-18 下午9:48
 * @version     1.0
 */
@Controller
public class HomeController {

    /**
     * 处理对 "/" 的 GET 请求
     * @return 名为"home"的视图
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }
}
