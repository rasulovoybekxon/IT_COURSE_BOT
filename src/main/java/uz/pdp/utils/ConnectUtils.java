package uz.pdp.utils;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectUtils {
    private static Connection connection;

    @SneakyThrows
    public static Connection getConnection() {
        if (connection == null) {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:/5432/sololearn_telegram_bot",
                    "postgres",
                    "al_rasull"
            );
        }
        return connection;
    }
}
