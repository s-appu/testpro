package test.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class OrderCustomSerializer extends StdSerializer<Order> {

    private static final long serialVersionUID = 1L;

    public OrderCustomSerializer( final Class<Order> clazz ) {
        super( clazz );
    }

    @Override
    public void serialize( final Order value, final JsonGenerator jgen, final SerializerProvider provider ) throws IOException, JsonGenerationException {

        jgen.writeStartObject();

        jgen.writeStringField( "orderDetails", value.getOrderDetails() );
        jgen.writeStringField( "orderId", value.getOrderId() );
        jgen.writeStringField( "hasUrgentDelivery", value.getHasUrgentDelivery() );

        final StringBuilder builder = new StringBuilder();
        for ( final String s : value.getOrderTypes() ) {
            builder.append( s ).append( ";" );
        }
        jgen.writeStringField( "orderTypes", builder.toString() );

        jgen.writeEndObject();

    }

}
