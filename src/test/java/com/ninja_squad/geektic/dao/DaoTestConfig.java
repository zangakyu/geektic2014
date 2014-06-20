package com.ninja_squad.geektic.dao;

import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.destination.Destination;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Spring configuration used for DAO tests
 * @author JB
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan("com.ninja_squad.geektic.dao")
public class DaoTestConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        result.setPersistenceUnitName("GEEKTIC");
        result.setDataSource(dataSource());
        result.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return result;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:hsqldb:hsql://localhost/GEEKTIC", "sa", "");
        dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        return dataSource;
    }

    /**
     * Creates a Spring transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf().getObject());
        return txManager;
    }

    /**
     * The singleton DbSetupTracker used to populate the database
     */
    @Bean
    public DbSetupTracker dbSetupTracker() {
        return new DbSetupTracker();
    }

    /**
     * The singleton DbSetup destination
     */
    @Bean
    public Destination destination() {
        return new DataSourceDestination(dataSource());
    }
}
