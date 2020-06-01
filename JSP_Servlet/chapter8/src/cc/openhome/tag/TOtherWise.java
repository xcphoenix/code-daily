/*
 * PageDemo - 与父标签沟通
 * ---------------------
 */

package cc.openhome.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagSupport;

public class TOtherWise extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspTag parent = getParent();
        if (!(parent instanceof TChooseTag)) {
            throw new JspException("必须置于 choose 标签中");
        }

        TChooseTag choose = (TChooseTag) parent;
        if (choose.isMatched()) {
            return SKIP_BODY;
        }

        return EVAL_BODY_INCLUDE;
    }
}