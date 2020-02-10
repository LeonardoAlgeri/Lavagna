package com.lavagna.lavagna;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://db4free.net:3306/lavagna?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSourceBuilder.username(System.getenv("SQL_USER"));
        dataSourceBuilder.password("pinguino01");
        return dataSourceBuilder.build();
    }
}