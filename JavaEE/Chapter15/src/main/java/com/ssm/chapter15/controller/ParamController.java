package com.ssm.chapter15.controller;

import com.ssm.chapter15.pojo.RoleParams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName    Chapter15-ParamController
 * Description  接受参数的控制器
 *
 * @author      xuanc
 * @date        19-5-26 上午9:14
 * @version     1.0
 */
@Controller
@RequestMapping("/params")
public class ParamController {

    /**
     * 无注解获取 HTTP 请求参数，使用 MVC 智能匹配
     * @param roleName 名字
     * @param note 备注
     * @return ModelAndView
     */
    @RequestMapping("/commonParams")
    public ModelAndView commonParams(String roleName, String note) {
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    /**
     * Spring MVC 默认也有映射 POJO 的能力
     * @param  roleParams 请求的数据
     * @return ModelAndView
     */
    @RequestMapping("/commonParamPojo")
    public ModelAndView commonParamPojo(RoleParams roleParams) {
        System.out.println("roleName => " + roleParams.getRoleName());
        System.out.println("note => " + roleParams.getNote());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/requestParam")
    public ModelAndView requestParam(
            @RequestParam(value = "role_name", required = false) String roleName,
            String note) {
        System.out.println("roleName => " + roleName);
        System.out.println("note => " + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
