package test.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class OrderCustomerDeserializer extends StdDeserializer<Order> {

    private static final long serialVersionUID = 1L;

    public OrderCustomerDeserializer( final Class<Order> clazz ) {
        super( clazz );
    }

    @Override
    public Order deserialize( final JsonParser jp, final DeserializationContext ctxt ) throws IOException, JsonProcessingException {

        final Order order = new Order();

        JsonToken currentToken = null;
        while ( ( currentToken = jp.nextValue() ) != null ) {

            switch ( currentToken ) {
                case VALUE_STRING:
                    switch ( jp.getCurrentName() ) {
                        case "orderDetails":
                            order.setOrderDetails( jp.getText() );
                            break;
                        case "orderId":
                            order.setOrderId( jp.getText() );
                            break;
                        case "hasUrgentDelivery":
                            order.setHasUrgentDelivery( jp.getText() );
                            break;
                        case "orderTypes":
                            order.setOrderTypes( jp.getText().split( ";" ) );
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }

        }
        return order;

    }

}
