package dao;

import api.dao.IAdministratorDao;
import model.Administrator;

public class AdministratorDao implements IAdministratorDao {
    @Override
    public Administrator createAdministrator(String name) {
        Administrator administrator=new Administrator(name);
        return administrator;
    }
}
