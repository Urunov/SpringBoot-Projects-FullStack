//package spring.boot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;
//
///**
// * @Author: apple
// * @created on 26/03/2020
// * @Project is boot
// */
////@Configuration
//public class DatabaseConfiguration {
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(dataSource());
//
//        em.setPackagesToScan(new String[] { "spring.boot.model" });
//        em.setPersistenceUnitName("org.hibernate.jpa.HibernatePersistenceProvider");
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(false);
//        em.setJpaVendorAdapter(vendorAdapter);
//
//        return em;
//    }
//
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/management?useSSL=false&serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("posilka2020");
//
//        return dataSource;
//    }
//}