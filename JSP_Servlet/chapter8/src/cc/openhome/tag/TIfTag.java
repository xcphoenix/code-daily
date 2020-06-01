/*
 * TagDemo - Tag 自定义标签
 */

package cc.openhome.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class TIfTag extends TagSupport{
    private boolean test;

    public void setTest(boolean test) {
        this.test = test;
    }

    // Tag 实例可以重复使用
    // 重新定义 doXXXTag() 方法
    @Override
    public int doStartTag() throws JspException {
        if (test) {
            return EVAL_BODY_INCLUDE;       // 测试通过会执行标签 Body 内容
        }
        return SKIP_BODY;                   // 测试失败，忽略 Body 内容
    }
}
