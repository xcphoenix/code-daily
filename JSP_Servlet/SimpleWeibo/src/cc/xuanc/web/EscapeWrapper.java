package cc.xuanc.web;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * ClassName    SimpleWeibo-EscapeWrapper
 * Description  处理特殊字符
 * @author      xuanc
 * @date        19-3-6 下午6:19
 * @version     1.0
 */ 
public class EscapeWrapper extends HttpServletRequestWrapper {
    public EscapeWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String string) {
        String value = getRequest().getParameter(string);
        // 过滤html字符并返回
        return StringEscapeUtils.escapeHtml(value);
    }
}
