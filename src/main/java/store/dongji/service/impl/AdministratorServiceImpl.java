package store.dongji.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import store.dongji.mapper.AdministratorMapper;
import store.dongji.pojo.Administrator;
import store.dongji.service.AdministratorService;
import store.dongji.util.SqlSessionUtils;

public class AdministratorServiceImpl implements AdministratorService {
    SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSqlSessionFactory();
    //根据用户输入的名称密码查询数据库中的管理员对象
    public Administrator queryByAdministratorNameAndPassword(Administrator admin) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        Administrator result = mapper.queryByAdministratorNameAndPassword(admin);
        sqlSession.close();
        return result;
    }
}
