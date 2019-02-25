/*
 * SimpleTagDemo ToUpperCaseTag.java
 * 将运行结果全部转换为大写
 * -------------------
 * 自定义 Writer 对象
 * > 如果标签 Body 中还有内层标签，通过getOut()取得的就是设置的 Writer 对象（除非内层标签也设置了自己的 Writer 对象）
 */

package cc.openhome.tag;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ToUpperCaseTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        StringWriter writer = new StringWriter();
        this.getJspBody().invoke(writer);
        // 将结果输出到 StringWriter 对象
        String upper = writer.toString().toUpperCase();
        // 转换成大写
        this.getJspContext().getOut().print(upper);
    }
}