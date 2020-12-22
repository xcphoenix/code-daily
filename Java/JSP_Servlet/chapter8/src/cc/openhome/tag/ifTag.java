/*
 * 伪 JSTL 标签 <f:if>
 */

package cc.openhome.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

// 需要继承 SimpleTagSupport
// 不用有很耗资源的行为
public class ifTag extends SimpleTagSupport {
    // <f:if> 中的 test 属性
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (test) {
            getJspBody().invoke(null);
            // protected javax.servlet.jsp.tagext.JspFragment getJspBody()
            // JspFragment: 表示JSP页面的片段内容
            // Body 内容在 invoke() 中处理，传入null表示用默认的JspWriter来作输出相应
        }
    }
}
