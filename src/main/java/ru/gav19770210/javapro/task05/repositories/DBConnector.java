package ru.gav19770210.javapro.task05.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
@Scope("singleton")
public class DBConnector {
    private static final HikariDataSource dataSource;
    private static final HikariConfig config = new HikariConfig("src/main/resources/datasource.properties");

    static {
        config.setConnectionTimeout(10000);
        dataSource = new HikariDataSource(config);
    }

    @SneakyThrows
    public Connection getConnection() {
        Class.forName(config.getDriverClassName());
        Connection connection = dataSource.getConnection();
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        return connection;
    }
}
