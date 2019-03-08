/*
 * JDBCDemo - GuestBookBean.java
 * -----------------------------
 * 留言板
 */

package cc.openhome;

import java.sql.*;
import java.util.*;
import java.io.*;

public class GuestBookBean implements Serializable {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/Jsp9Demo";
    private String username = "root";
    private String password = "mysqlpass";
    
    public GuestBookBean() {
        // 加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * description  新增留言到数据库
     * @author      xuanc
     * @date        上午10:03 19-3-1
     * @param		message 要新增的留言
     * @return      void
     * @throws      SQLException 数据库运行异常
     * @throws      RuntimeException 数据库发生错误抛出运行时异常
     */
    public void setMessage(Message message) throws SQLException{
        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            // 获取SQL语言的代表对象
            // statement = conn.createStatement();
            // // 执行数据库操作
            // statement.executeUpdate(
            //         "INSERT INTO t_message(name, email, msg) VALUES (" +
            //                 "'" + message.getName() + "'," +
            //                 "'" + message.getEmail() + "'," +
            //                 "'" + message.getMsg() + "')"
            // );
            // 使用预编译 sql 语句，'?' 为占位符
            PreparedStatement stmt = conn.prepareStatement("" +
                    "INSERT INTO t_message(name, email, msg) VALUES (?, ?, ?)");
            // 设置参数
            stmt.setString(1, message.getName());
            stmt.setString(2, message.getEmail());
            stmt.setString(3, message.getMsg());
            // 执行
            stmt.executeUpdate();
            // 清除参数
            stmt.clearParameters();
        } catch (SQLException e) {
            ex = e;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
        }

        if (ex != null) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Description  从数据库中查询所有的留言
     * @author      xuanc
     * @date        下午12:17 19-2-28
     * @return      java.util.List<cc.openhome.Message>
     */
    public List<Message> getMessages() {
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;
        SQLException ex = null;
        List<Message> messages = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM t_message");
            messages = new ArrayList<Message>();
            while (result.next()) {
                Message message = new Message();
                // 获取值
                message.setId(result.getLong(1));
                message.setName(result.getString(2));
                message.setEmail(result.getString(3));
                message.setMsg(result.getString(4));
                messages.add(message);
            }
        } catch(SQLException e) {
            ex = e;
        } finally {
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

        return messages;
    }

}
