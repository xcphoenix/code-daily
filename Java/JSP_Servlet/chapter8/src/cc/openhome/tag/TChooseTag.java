/*
 * TagDemo - 与父标签沟通
 * --------------------
 * 伪标签系列 - choose
 */

package cc.openhome.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TChooseTag extends TagSupport {
    private boolean matched;

    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    @Override
    public int doStartTag() throws JspException{
        matched = false;                    // 状态重置
        return EVAL_BODY_INCLUDE;           // 默认返回 SKIP_BODY 会忽略 Body 内容
    }
}