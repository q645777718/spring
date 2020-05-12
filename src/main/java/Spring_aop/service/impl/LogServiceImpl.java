package Spring_aop.service.impl;

import Spring_aop.dao.LogDao;
import Spring_aop.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 * @author shkstart
 * @create 2020-05-10 20:03
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    //事务传播行为
    @Transactional
    public void add() {
        logDao.add("log_"+System.currentTimeMillis());
    }
}
