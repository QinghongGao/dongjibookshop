package store.dongji.service;

import store.dongji.pojo.Administrator;

public interface AdministratorService {
    public Administrator queryByAdminnameAndPassword(Administrator admin);
}
