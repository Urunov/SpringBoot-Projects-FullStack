package spring.mvc.config;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Created 08 / 04 / 2020 - 5:44 PM
 * @project SpringMultipleDataStructure
 * @Author Hamdamboy
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "spring.mvc.security.repository",
        entityManagerFactoryRef = "securityEntityManagerFactory",
        transactionManagerRef = "securityTransactionManager"
)
public class SecurityDataSoruceConfig {

    @Autowired
    private Environment environment;

    @Bean
    @ConfigurationProperties(prefix = "datasource.security")
    public DataSourceProperties securityDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource securityDataSource(){
        DataSourceProperties securityDataSourceProperties = securityDataSourceProperties();
        return DataSourceBuilder.create()
                .driverClassName(securityDataSourceProperties.getDriverClassName())
                .url(securityDataSourceProperties.getUrl())
                .username(securityDataSourceProperties.getUsername())
                .password(securityDataSourceProperties.getPassword())
                .build();
    }

    @Bean
    public PlatformTransactionManager securityTransactionManager(){
        EntityManagerFactory factory = securityEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean securityEntityManagerFactory(){

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
            factory.setDataSource(securityDataSource());
            factory.setPackagesToScan(new String[]{"spring.mvc.security.entity"});
            factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

            Properties jpaProperties = new Properties();
            jpaProperties.put("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
            jpaProperties.put("hibernate.show-sql", environment.getProperty("spring.jpa.show-sql"));
            factory.setJpaProperties(jpaProperties);

            return factory;
    }

    @Bean
    public DataSourceInitializer securityDataSourceInitializer() {
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(securityDataSource());
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("security-data-sql"));
        dataSourceInitializer.setDatabasePopulator(databasePopulator);
        dataSourceInitializer.setEnabled(environment.getProperty("datasource.security.initialize", Boolean.class, false));
        return dataSourceInitializer;
    }


}
