package com.attila.shopping_list.data

import io.github.cdimascio.dotenv.dotenv
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfig {
    private val dotenv = dotenv()

    @Bean
    fun dataSource(): DataSource {
        return DataSourceBuilder.create()
            .url(dotenv["DB_URL"])
            .username(dotenv["DB_USER"])
            .password(dotenv["DB_PASSWORD"])
            .driverClassName("org.postgresql.Driver")
            .build()
    }
}