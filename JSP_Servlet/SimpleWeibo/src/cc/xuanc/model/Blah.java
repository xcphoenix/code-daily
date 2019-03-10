package cc.xuanc.model;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.Serializable;
import java.util.*;

/**
 * ClassName    SimpleWeibo-Blah
 * Description  JavaBean - 封装微博等信息
 * @author      xuanc
 * @date        19-3-4 下午9:37
 * @version     1.0
 */
public class Blah implements Serializable {
    private String username;
    private Date date;
    private String message;

    public Blah() {
    }

    public Blah(String username, Date date, String message) {
        this.username = username;
        this.date = date;
        this.message = message;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return this.username;
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    public String getEscapeMessage() {
        String value = StringEscapeUtils.escapeHtml(this.message);
        return value.replace(" ", "&nbsp;").
                replace(" ", "&emsp;").
                replace(" ", "&ensp;").
                replace("\n", "<br/>");
    }
}

