package org.young.wiki;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * User: Young
 * Date: 2018/7/9 0009
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
public class YWikiApplication {

    @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){
        return hemf.getSessionFactory();
    }

    public static void main(String[] args) {
        SpringApplication.run(YWikiApplication.class, args);
    }

}
