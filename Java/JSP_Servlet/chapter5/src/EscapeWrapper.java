/*
 * EscapeWrapper.java
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.lang.StringEscapeUtils;

public class EscapeWrapper extends HttpServletRequestWrapper {
    public EscapeWrapper(HttpServletRequest request) {
        super(request); // 调用父类构造器
    }

    @Override
    public String getParameter(String name) {
        String value = getRequest().getParameter(name);
        // javax.servlet.ServletRequestWrapper public javax.servlet.ServletRequest getRequest()
        // 获取 ServletRequest
        return StringEscapeUtils.escapeHtml(value);
        // 将取得的请求参数值进行字符替换
    }
}