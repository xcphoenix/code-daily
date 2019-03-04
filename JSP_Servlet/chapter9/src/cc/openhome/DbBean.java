package cc.openhome;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ClassName    chapter9-DbBean
 * Description  TODO
 * @author      xuanc
 * @date        19-3-1 上午10:01
 * @version     1.0
 */
public class DbBean implements Serializable {
    private String jdbcUrl;
    private String username;
    private String password;

    /**
     * 加载驱动程序
     */
    public DbBean() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isConnectedOK() {
        boolean ok = false;
        Connection conn = null;
        SQLException ex = null;
        try {
            // 取得数据库连接对象
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            if (!conn.isClosed()) {
                ok = true;
            }
        } catch (SQLException e) {
            ok = true;
        } finally {
            // 自动回收资源
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
                // 抛出异常
            }
        }
        return ok;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

