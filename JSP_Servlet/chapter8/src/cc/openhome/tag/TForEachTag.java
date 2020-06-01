/*
 *  TagDemo - 利用 doStatTag() 和 doAfterBody() 来实现 forEach
 */

package cc.openhome.tag;

import java.util.Collection;
import java.util.Iterator;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TForEachTag extends TagSupport{
    private String var;
    private Iterator iterator;

    public void setVar(String var) {
        this.var = var;
    }

    public void setItems(Collection items) {
        this.iterator = items.iterator();
    }

    @Override
    public int doStartTag() throws JspException {
        if (iterator.hasNext()) {
            this.pageContext.setAttribute(var, iterator.next());    // 设置属性，执行第一次处理
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    @Override
    public int doAfterBody() throws JspException {
        if (iterator.hasNext()) {
            this.pageContext.setAttribute(var, iterator.next());
            return EVAL_BODY_AGAIN;                                 // 再次调用
        }
        this.pageContext.removeAttribute(var);  // 移除属性
        return SKIP_BODY;
    }
}
