package cc.xuanc.model;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * ClassName    SimpleWeibo-UserService
 * Description  用户的登录验证、注册初始化、获取用户微博、新增微博和删除微博
 * @author      xuanc
 * @date        19-3-4 下午4:03
 * @version     1.0
 */
public class UserService {

    private String jdbcUser;
    private String jdbcPassword;
    private String jdbcUrl;

    /**
     * description  获取数据库配置信息并连接数据库
     * @author      xuanc
     * @date        下午4:41 19-3-4
     * @throws      RuntimeException　(ClassNotFoundException)
     */
    public UserService(String user, String password, String url) {
        jdbcUser = user;
        jdbcPassword = password;
        jdbcUrl = url;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * description  从数据库中查找用户名是否已注册
     * @author      xuanc
     * @date        下午4:52 19-3-4
     * @param		username 用户名
     * @return      boolean　返回用户名注册情况
     * @throws      RuntimeException SQLException
     */
    public boolean isExisted(String username) {
        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;
        boolean exist = false;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            // 创建 Statement 对象
            statement = conn.createStatement();
            ResultSet result =  statement.executeQuery(
                    "SELECT * from `_users_` WHERE username = '" + username + "';");
            if (result.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }

        return exist;
    }

    /**
     * description  新建用户
     * @author      xuanc
     * @date        下午5:15 19-3-4
     * @param		username 用户名
     * @param		password 密码
     * @param		email    邮箱
     */
    public void createUser(String username, String password, String email) {
        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = conn.createStatement();
            // 添加用户信息
            statement.executeUpdate(
                    "INSERT INTO `_users_` VALUES('" + username + "','" + password + "', '" + email + "')");
            // 为用户创建表存储微博
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `" + username + "` (" +
                          "`time` INT NOT NULL," +
                          "`message` VARCHAR(256) NOT NULL);"
            );
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }
    }

    /**
     * description  验证登录
     * @author      xuanc
     * @date        下午5:53 19-3-4
     * @param		username 用户名
     * @param		password 密码
     * @return      boolean  是否匹配
     */
    public boolean checkLogin(String username, String password) {
        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;
        boolean success = false;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = conn.createStatement();
            ResultSet result =  statement.executeQuery(
                    "SELECT * from `_users_` WHERE username = '" + username + "' AND password = '" + password + "';");
            if (result.next()) {
                success = true;
            }
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }

        return success;
    }

    /**
     * description  新增微博
     * @author      xuanc
     * @date        下午9:51 19-3-4
     * @param		blah 要新增的信息
     */
    public void addMessage(Blah blah) {
        String username = blah.getUsername();
        String message = blah.getMessage();

        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = conn.createStatement();
            String sqlString = "INSERT INTO `" + username + "` VALUES (UNIX_TIMESTAMP(), '" + escapeSpecialChar(message) + "');";
            System.out.println("sql: " + sqlString);
            int tmp = statement.executeUpdate(sqlString);
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }
    }

    /**
     * description  删除信息
     * @author      xuanc
     * @date        下午6:04 19-3-5
     * @param		blah 要删除的消息
     */
    public void deleteMessage(Blah blah) {
        String username = blah.getUsername();
        String message = blah.getMessage();
        Date date = blah.getDate();

        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = conn.createStatement();
            // 时间戳转换为UNIX时间戳
            String sqlString = "DELETE FROM `" + username + "` WHERE time = '" + date.getTime() / 1000 + "';";
            System.out.println("sql: " + sqlString);
            statement.executeUpdate(sqlString);
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }
    }

    /**
     * description  获取用户发送的微博
     * @author      xuanc
     * @date        下午9:09 19-3-5
     * @param		username 用户名
     * @return      java.util.List<cc.xuanc.model.Blah>
     */
    public List<Blah> getBlahs(String username) {
        List<Blah> lists = new ArrayList<Blah>();

        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = conn.createStatement();
            // 获取微博消息-按时间逆序获取
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `" + username + "` ORDER BY `time` DESC; ");
            while (resultSet.next()) {
                // UNIX时间戳转换为时间戳
                Blah temp = new Blah(username, new Date(1000 * Long.parseLong(resultSet.getString("time")) ),
                        resultSet.getString("message"));
                lists.add(temp);
            }
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }

        return lists;
    }

    /**
     * 关闭资源
     */
    private void dataClose(SQLException ex, Statement statement, Connection conn) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                if (ex == null) {
                    ex = e;
                }
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                if (ex == null) {
                    ex = e;
                }
            }
        }

        if (ex != null) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * description  Mysql 语句转义
     * @author      xuanc
     * @date        下午5:54 19-3-5
     * @param		keyword sql 语句
     * @return      java.lang.String 转义后的字符串
     */
    private static String escapeSpecialChar(String keyword){
        // // 判断某字符串是否不为空且长度不为0且不由空白符(whitespace) 构成
        // if (StringUtils.isNotBlank(keyword)) {
        //     String[] fbsArr = { "\\", "$", "|","%","_" , "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "'"};
        //     for (String key : fbsArr) {
        //         // 方法返回true，当且仅当此字符串包含指定的char值序列
        //         if (keyword.contains(key)) {
        //             // 方法替换此字符串相匹配的文字目标序列与指定的文字替换序列中的每个子字符串
        //             // String 继承于CharSequence，也就是说String也是CharSequence类型。
        //             keyword = keyword.replace(key, "\\" + key);
        //         }
        //     }
        // }
        // return keyword;
        return StringEscapeUtils.escapeSql(keyword);
    }
}
