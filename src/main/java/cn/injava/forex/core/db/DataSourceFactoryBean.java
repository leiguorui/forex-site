package cn.injava.forex.core.db;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

/**
 * datasource 工厂
 *
 * Created by lei on 16-1-11.
 */
public class DataSourceFactoryBean extends AbstractFactoryBean<DataSource> {

    //This method will be called by container to create new instances
    @Override
    protected DataSource createInstance() throws Exception{
        SingleConnectionDataSource ds = new SingleConnectionDataSource();
        ClassPathResource cpr = new ClassPathResource("database.db");
        ds.setDriverClassName("org.sqlite.JDBC");
        ds.setUrl("jdbc:sqlite:"+cpr.getFile().getAbsolutePath());
        return ds;
    }

    //This method is required for autowiring to work correctly
    @Override
    public Class<DataSource> getObjectType() {
        return DataSource.class;
    }
}