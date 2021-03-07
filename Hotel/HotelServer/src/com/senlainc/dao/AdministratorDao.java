package com.senlainc.dao;

import com.senlainc.api.dao.IAdministratorDao;
import com.senlainc.model.Administrator;

public class AdministratorDao implements IAdministratorDao {
    @Override
    public Administrator createAdministrator(String name) {
        Administrator administrator=new Administrator(name);
        return administrator;
    }
}
