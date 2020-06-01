import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName    chapter4-MyTypeHandler
 * Description  
 *
 * @author      xuanc
 * @date        19-5-1 下午3:49
 * @version     1.0
 */ 
public class MyTypeHandler implements TypeHandler<String> {

    Logger logger = Logger.getLogger(MyTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        logger.info("设置string参数【" + s + "】");
        preparedStatement.setString(i, s);
    }

    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
