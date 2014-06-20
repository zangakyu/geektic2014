package com.ninja_squad.geektic.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Spring application configuration. Lacks some annotations.
 * @author JB Nizet
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.ninja_squad.geektic")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableAspectJAutoProxy
@Import(JacksonMapperConfig.class)
public class AppConfig extends WebMvcConfigurerAdapter {

    /**
     * Delegates to the default servlet in case the Dispatcher, which is mapped to /, hasn't found a mapping
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

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

    @Bean
    public PlatformTransactionManager txManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf().getObject());
        return txManager;
    }
}
