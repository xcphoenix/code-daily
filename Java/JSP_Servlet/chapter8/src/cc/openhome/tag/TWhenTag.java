/*
 * TagDemo - 与父标签沟通
 * --------------------
 * 伪标签系列 - when
 */

package cc.openhome.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.TagSupport;

public class TWhenTag extends TagSupport {
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    @Override
    public int doStartTag() throws JspException {
        JspTag parent = getParent();
        if (!(parent instanceof TChooseTag)) {
            throw new JspException("必须置于choose标签之中");
        }

        TChooseTag choose = (TChooseTag) parent;
        // 如果不满足条件，跳过 Body
        if (choose.isMatched() || !test) {
            return SKIP_BODY;
        }
        // 满足条件，设值并执行 Bodyn
        choose.setMatched(true);
        return EVAL_BODY_INCLUDE;
    }
}