package cc.openhome;

import java.io.Serializable;
import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

/**
 * ClassName    chapter9-DatabaseBean
 * Description  JDBCDemo DatabaseBean
 * @author      xuanc
 * @date        19-3-7 下午9:46
 * @version     1.0
 */ 
public class DatabaseBean implements Serializable {
    private DataSource dataSource;

    public DatabaseBean() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/demo");
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void
}
