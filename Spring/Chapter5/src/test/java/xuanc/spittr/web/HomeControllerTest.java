package xuanc.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * ClassName    Chapter5-HomeControllerTest
 * Description  测试控制器
 *
 * @author      xuanc
 * @date        19-4-18 下午10:13
 * @version     1.0
 */ 
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();

        // 搭建 MockMvc
        MockMvc mockMvc = standaloneSetup(controller).build();

        // 执行 GET 请求
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));
    }

}
