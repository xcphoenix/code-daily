package com.ssm.chapter14.controller;

import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName    Chapter14-RoleController
 * Description  
 *
 * @author      xuanc
 * @date        19-5-15 下午7:38
 * @version     1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    /**
     * 注入角色服务类
     */
    @Autowired
    private RoleService roleService = null;

    @RequestMapping(value = "/getRole", method = RequestMethod.GET)
    public ModelAndView getRole(@RequestParam("id") Long id) {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("roleDetails");
        mv.addObject("role", role);
        return mv;
    }

}
