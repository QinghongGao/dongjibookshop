package store.dongji.mapper;

import store.dongji.pojo.Administrator;

public interface AdminMapper {
    /**
     * 返回查询到的Admin
     * @param administrator
     * @return
     */
    Administrator queryByAdministratornameAndPassword(Administrator administrator);
}
