package test.spring.service;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.configs.JdbcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        JdbcConfig.class
})
public class OrderManagementTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testIsDataSourceAvailable() {
        Assert.assertNotNull( this.dataSource );
    }

}
