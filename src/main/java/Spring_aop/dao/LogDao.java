package Spring_aop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author shkstart
 * @create 2020-05-10 20:01
 */
@Repository
public class LogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  void add(String name){
        String sql = "INSERT INTO t_log(log_name) values(?)";
        int updateResult = jdbcTemplate.update(sql, name);
        System.out.println("updateResult:" + updateResult);
    }
}
