package store.dongji.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import store.dongji.mapper.AdminMapper;
import store.dongji.pojo.Administrator;
import store.dongji.service.AdministratorService;
import store.dongji.util.SqlSessionUtils;

public class AdministratorServiceImpl implements AdministratorService {
    SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSqlSessionFactory();
    public Administrator queryByAdminnameAndPassword(Administrator admin) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Administrator result = mapper.queryByAdministratornameAndPassword(admin);
        sqlSession.close();
        return result;
    }
}
