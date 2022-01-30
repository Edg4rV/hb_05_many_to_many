package io.hibernate.config

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.orm.hibernate5.LocalSessionFactoryBean

import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages="io.hibernate")
class HibernateConfig {

    @Bean
    LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"io.hibernate.entity"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    @Bean
    DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setMaxTotal(1)
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("hbstudent");
        dataSource.setPassword("hbstudent");
        return dataSource;
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.connection.pool_size", "1")
                setProperty("hibernate.current_session_context_class", "thread")
                setProperty("hibernate.hbm2ddl.auto", "update");
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                setProperty("hibernate.show_sql", "true");
            }
        };
    }
}
