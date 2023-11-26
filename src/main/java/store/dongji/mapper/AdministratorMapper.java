package store.dongji.mapper;

import store.dongji.pojo.Administrator;

public interface AdministratorMapper {
    /**
     * 返回查询到的Administrator
     * @param administrator
     * @return
     */
    Administrator queryByAdministratorNameAndPassword(Administrator administrator);
}
