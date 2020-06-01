package xuanc.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import xuanc.spittr.Spitter;
import xuanc.spittr.data.SpitterRepository;
import xuanc.spittr.data.SpittleRepository;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * ClassName    Chapter5-SpittlerControllerTest
 * Description  测试展现表单控制器方法
 *
 * @author      xuanc
 * @date        19-4-22 下午3:16
 * @version     1.0
 */ 
public class SpittlerControllerTest {

    /**
     * 测试展现表单的控制器方法
     * @throws Exception ...
     */
    @Test
    public void shouldShowRegistration() throws Exception {
        SpittlerController controller = new SpittlerController(mock(SpitterRepository.class));
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittler/register"))
                .andExpect(view().name("registerForm"));
    }

    /**
     * 测试处理表单的控制器方法
     */
    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        when(mockRepository.save(unsaved)).thenReturn(saved);
        SpittlerController controller = new SpittlerController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spittler/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/spittler/jbauer"));

        // 验证测试函数是否执行了至少一次
        verify(mockRepository, atLeastOnce()).save(unsaved);

    }

}
