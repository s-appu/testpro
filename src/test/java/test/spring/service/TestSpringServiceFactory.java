package test.spring.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.configs.MainConfig;
import com.spring.services.OrderService;
import com.spring.services.PaymentService;
import com.spring.services.factory.ServiceFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        MainConfig.class
})
public class TestSpringServiceFactory {

    @Autowired
    private ServiceFactory serviceFactory;

    @Test
    public void testPaymentServiceForFactory() {
        Assert.assertEquals( OrderService.class, this.serviceFactory.getMyService( "order2Service" ).getClass() );
        Assert.assertEquals( PaymentService.class, this.serviceFactory.getMyService( "paymentService" ).getClass() );

        System.out.println( TestSpringServiceFactory.class.getName() );
    }

}
