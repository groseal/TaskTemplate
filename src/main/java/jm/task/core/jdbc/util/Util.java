package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/jm_base";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "159159";

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.connection.url", URL);
                configuration.setProperty("hibernate.connection.username", USERNAME);
                configuration.setProperty("hibernate.connection.password", PASSWORD);
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
                System.out.println("Создан sessionFactory");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Connection getConnectBD() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Ошибка соединения с БД");
            e.printStackTrace();
        }
        return connection;
    }
}
