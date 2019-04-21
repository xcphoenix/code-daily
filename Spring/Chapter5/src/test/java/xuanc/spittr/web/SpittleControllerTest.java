package xuanc.spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import xuanc.spittr.Spittle;
import xuanc.spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * ClassName    Chapter5-SpittleControllerTest
 * Description  测试 SpittleController
 *
 * @author      xuanc
 * @date        19-4-21 下午9:56
 * @version     1.0
 */ 
public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        // 创建一个 List
        List<Spittle> expectedSpittles = createSpitteList(20);
        // Mock Repository
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        // 做测试桩
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);
        // 新建控制器
        SpittleController controller = new SpittleController(mockRepository);
        // 搭建 MockMvc
        MockMvc mockMvc = standaloneSetup(controller).
                setSingleView(new InternalResourceView("/views/spittles.jsp")).
                build();
        // 对 "/spittles" 模拟 GET 请求
        mockMvc.perform(get("/spittles"))
                // 预期得到的相关值
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpitteList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle" + i, new Date()));
        }
        return spittles;
    }

}
