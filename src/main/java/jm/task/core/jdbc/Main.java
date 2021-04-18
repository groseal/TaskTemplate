package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("1", "01", (byte) 11);
        userService.saveUser("2", "02", (byte) 12);
        userService.saveUser("3", "03", (byte) 13);
        userService.saveUser("4", "04", (byte) 14);
        userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
