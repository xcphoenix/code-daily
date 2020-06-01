/*
 * SimpleTagDemo OtherwiseTag.java
 * ----------------------------
 * 与父标签沟通
 */

package cc.openhome.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspTag parent = getParent();
        if (!(parent instanceof ChooseTag)) {
            throw new JspTagException("必须置于 choose 标签中");
        }

        ChooseTag choose = (ChooseTag) parent;
        if (!choose.isMatched()) {
            this.getJspBody().invoke(null);
        }
    }
}