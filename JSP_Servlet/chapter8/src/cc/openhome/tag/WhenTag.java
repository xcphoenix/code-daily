/*
 * SimpleTagDemo WhenTag.java
 * ----------------------------
 * 与父标签沟通
 */

package cc.openhome.tag;

import java.io.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspTag parent = getParent();
        // instanceof 是 Java 的保留关键字。它的作用是测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型。
        // 如果外层标签不存在或不是 <f:choose>，抛出异常
        if (!(parent instanceof ChooseTag)) {
            throw new JspTagException("必须置于 choose 标签中");
        }

        ChooseTag choose = (ChooseTag) parent;
        if (!choose.isMatched() && test) {
            choose.setMatched(true);    // 设置为 true，后面的 when 不执行
            this.getJspBody().invoke(null); // 执行标签 Body
        }
    }
}
