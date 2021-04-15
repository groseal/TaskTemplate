package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao user = new UserDaoHibernateImpl();
//    UserDao user = new UserDaoJDBCImpl();

    public void createUsersTable() {
        this.user.createUsersTable();
    }

    public void dropUsersTable() {
        this.user.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        this.user.saveUser(name, lastName, age);
        System.out.println("User с именем – "+name+" добавлен в базу данных");
    }

    public void removeUserById(long id) {
        this.user.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return this.user.getAllUsers();
    }

    public void cleanUsersTable() {
        this.user.cleanUsersTable();
    }
}
