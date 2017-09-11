package test.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonTest {

    @Test
    public void jsonTest() throws Exception {

        final Order order = new Order( "order_data" );
        order.setOrderId( "someId" );
        order.setHasUrgentDelivery( "Yes" );
        order.setOrderTypes( new String[] {
                "Cloths",
                "Home",
                "Grocery"
        } );
        order.setPaymentOptions( Arrays.asList( "VISA", "Paypal" ) );
        final List<BaseItem> items = new ArrayList<BaseItem>();
        items.add( new Cloths( "Trouser", 100l, "Men" ) );
        items.add( new Home( "Television", 101l, "Family Room" ) );
        order.setItems( items );

        final ObjectMapper mapper = new ObjectMapper();

        final String result = mapper.writeValueAsString( order );
        System.out.println( result );
        Assert.assertNotNull( result );

        final Order myorder = mapper.readValue( result, Order.class );
        System.out.println( myorder );
        Assert.assertNotNull( myorder );

    }

    @Test
    public void jsonTest_custom() throws Exception {

        final Order order = new Order( "order_data" );
        order.setOrderId( "some_new_id" );
        order.setHasUrgentDelivery( "no" );
        order.setOrderTypes( new String[] {
                "Cloths",
                "Home",
                "Grocery"
        } );

        final ObjectMapper mapper = new ObjectMapper();

        final SimpleModule mod = new SimpleModule( "Order Custom Module" );
        mod.addSerializer( new OrderCustomSerializer( Order.class ) );
        mod.addDeserializer( Order.class, new OrderCustomerDeserializer( Order.class ) );

        mapper.registerModule( mod );

        final String result = mapper.writeValueAsString( order );
        System.out.println( result );
        Assert.assertNotNull( result );

        final Order myOrder = mapper.readValue( result, Order.class );
        System.out.println( myOrder );
        Assert.assertNotNull( myOrder );

    }

    @Test
    public void jsonTest_list_Order() throws Exception {

        final Order order1 = new Order( "testXml" );
        order1.setOrderId( "1234" );
        order1.setHasUrgentDelivery( "Yes" );
        order1.setOrderTypes( new String[] {
                "Cloths",
                "Home",
                "Grocery"
        } );
        order1.setPaymentOptions( Arrays.asList( "VISA", "Paypal" ) );
        final List<BaseItem> items = new ArrayList<BaseItem>();
        items.add( new Cloths( "Trouser", 100l, "Men" ) );
        items.add( new Home( "Television", 101l, "Family Room" ) );
        order1.setItems( items );

        final Order order2 = new Order( "testXm 2l" );
        order2.setOrderId( "998" );
        order2.setHasUrgentDelivery( "NO" );
        order2.setOrderTypes( new String[] {
                "Cloths",
        } );
        order2.setPaymentOptions( Arrays.asList( "VISA", "Paypal" ) );
        final List<BaseItem> items2 = new ArrayList<BaseItem>();
        items.add( new Cloths( "Shorts", 200l, "Men" ) );
        order2.setItems( items2 );

        final List<Order> orders = Arrays.asList( order1, order2 );

        final ObjectMapper mapper = new ObjectMapper();

        final String result = mapper.writerWithType( new TypeReference<List<Order>>() {
        } ).writeValueAsString( orders );

        System.out.println( result );
        Assert.assertNotNull( result );

        final List<Order> orderResults = mapper.readValue( result, new TypeReference<List<Order>>() {
        } );
        System.out.println( orderResults );
        Assert.assertNotNull( orderResults );

    }

}
