/*
 * TagDemo - 处理标签 Body 运行结果
 */

package cc.openhome.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TToUpperCaseTag extends BodyTagSupport{
    @Override
    public int doEndTag() throws JspException {
        // getBodyContent() 取得 BodyContent 对象（Writer 的子对象)，包括 Body 内容执行的结果
        String upper = this.getBodyContent().getString().toUpperCase();
        try {
            // pageContext.getOut() 取得 JspWriter 对象，可以利用这个对象输出到浏览器
            pageContext.getOut().write(upper);
        } catch (IOException e) {
            throw new JspException(e);
        }
        return super.doEndTag();
    }
}
