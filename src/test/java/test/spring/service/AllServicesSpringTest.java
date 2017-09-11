package test.spring.service;

import java.util.Arrays;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.configs.MainConfig;
import com.spring.services.ManagementService;
import com.spring.services.MySingleton;
import com.spring.services.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        MainConfig.class

})
public class AllServicesSpringTest {

    // @Autowired
    private OrderService orderService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private ManagementService mgmtService;

    @Test
    public void orderServiceShouldNotBeNull() {
        Assert.assertNotNull( this.orderService );
    }

    @Test
    public void testAllBeans() {
        System.out.println( Arrays.asList( this.applicationContext.getBeanDefinitionNames() ) );
        this.printBeanNamesOfTypes( new Class[] {
                OrderService.class,
                MySingleton.class
        } );
    }

    @Test
    public void testPrototypeOnTheRegularNewOrderServiceBean() {
        final OrderService s1 = (OrderService) this.applicationContext.getBean( "newOrderService" );
        final OrderService s2 = (OrderService) this.applicationContext.getBean( "newOrderService" );

        Assert.assertNotEquals( s1, s2 );

    }

    @Test
    public void testPrototypeOnSingleTonClassBean() {
        final MySingleton s1 = (MySingleton) this.applicationContext.getBean( "mySecondSingleton" );
        final MySingleton s2 = (MySingleton) this.applicationContext.getBean( "mySecondSingleton" );
        final MySingleton s3 = (MySingleton) this.applicationContext.getBean( "mySingleton" );

        Assert.assertEquals( s1, s2 );
        Assert.assertNotEquals( s2, s3 );

    }

    @Test
    public void getOrderServiceBeansByQualifier() {
        this.findBeansUsingQualifiersForAType( OrderService.class, new String[] {
                "orderService"
        } );
    }

    private <T> void findBeansUsingQualifiersForAType( final Class<T> clz, final String... qualifiers ) {
        for ( final String qualifier : qualifiers ) {
            final T bean = BeanFactoryAnnotationUtils.qualifiedBeanOfType( this.applicationContext.getAutowireCapableBeanFactory(), clz, qualifier );
            System.out.println( bean );
        }
    }

    private void printBeanNamesOfTypes( final Class... beanClasses ) {
        for ( final Class beanClass : beanClasses ) {
            this.applicationContext.getBeansOfType( beanClass );
            final Map<String, Object> orderServiceBeans = this.applicationContext.getBeansOfType( beanClass );
            orderServiceBeans.entrySet().forEach( p -> {
                String msg = String.format( " Key - %s , Value - %s", p.getKey(), p.getValue() );
                if ( p.getValue() instanceof OrderService ) {
                    msg = String.format( msg + " , Service - %s", ( (OrderService) p.getValue() ).getServiceName() );
                }
                System.out.println( msg );
            } );
        }
    }

    @Test
    public void testManagementServiceDependencies() {
        Assert.assertNotNull( this.mgmtService.getService() );
    }
}
