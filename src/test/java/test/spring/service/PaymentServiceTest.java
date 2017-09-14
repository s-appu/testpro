package test.spring.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.configs.MainConfig;
import com.spring.services.PaymentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        MainConfig.class
})
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testAutowiringInAbstractClass() {
        final int cost = this.paymentService.getCurrentOrderCost();
        Assert.assertNotNull( cost );
        Assert.assertEquals( 1000, cost );
    }

    @Test
    public void testAspects() {
        final double cost = this.paymentService.totalCost();
        Assert.assertNotNull( cost );
    }
}
