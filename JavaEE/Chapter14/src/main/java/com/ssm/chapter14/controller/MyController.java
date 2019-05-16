package com.ssm.chapter14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import 错包会出现问题...
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName    Chapter14-MyController
 * Description  简单的 Controller
 *
 * @author      xuanc
 * @date        19-5-14 下午11:07
 * @version     1.0
 */
@Controller("myController")
@RequestMapping("/my")
public class MyController {

    /**
     * 表明 URI 是 /index 的时候该方法才请求
     * @return 模型和视图
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        // 模型和视图
        ModelAndView mv = new ModelAndView();
        // 设置视图逻辑名称为 index
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public ModelAndView index2(@RequestParam(value = "id", required = false,
            defaultValue = "default") Long id) {
        System.out.println("param[id] = " + id);
        // 模型和视图
        ModelAndView mv = new ModelAndView();
        // 设置视图逻辑名称为 index
        mv.setViewName("index");
        return mv;
    }

}
