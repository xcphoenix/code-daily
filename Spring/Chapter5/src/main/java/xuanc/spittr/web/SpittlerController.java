package xuanc.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xuanc.spittr.Spitter;
import xuanc.spittr.data.SpitterRepository;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * ClassName    Chapter5-SpittlerController
 * Description  展现表单，允许用户注册该应用
 *
 * @author      xuanc
 * @date        19-4-22 下午3:11
 * @version     1.0
 */
@Controller
@RequestMapping("/spittler")
public class SpittlerController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpittlerController (SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationFrom() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @Valid Spitter spitter, Errors errors) {
        // 如果校验出现错误，重新返回表单
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        // 重定向
        return "redirect:/spittler/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile (
            @PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}
