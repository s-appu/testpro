package test.spring.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.aop.Performance;
import com.spring.aop.RockConcert;
import com.spring.configs.AspectConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        AspectConfig.class
})
public class AopTest {

    @Autowired
    Performance performance;

    @Autowired
    RockConcert concert;

    @Test
    public void testIfPerformanceBeanIsCreated() {
        Assert.assertNotNull( this.performance );
    }

    @Test
    public void testIfAspectInvokved() {
        this.performance.perform();
        this.concert.setup();
    }

    @Test
    public void testAroundAdviceWithArguments() {
        final String concertLocation = this.concert.location( "NY", "USA" );
        System.out.println( "Result -- " + concertLocation );
    }

}
