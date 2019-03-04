package cc.opnehome;

/*
 * JSPDemo - 编写 EL 函数
 */

import java.util.Collection;

public class Util {
    public static int length(Collection collection) {
        return collection.size();
    }
}