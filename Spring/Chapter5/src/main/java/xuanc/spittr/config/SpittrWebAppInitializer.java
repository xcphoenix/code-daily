package xuanc.spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName    Chapter5-SpittrWebAppInitializer
 * Description  配置 DispatcherServlet
 *
 * @author      xuanc
 * @date        19-4-18 下午8:34
 * @version     1.0
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * description 将 DispatcherServlet 映射到 "/"
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    /**
     * 指定配置类
     * @return ...
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

}
