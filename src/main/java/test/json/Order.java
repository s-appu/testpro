package test.json;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    private String orderId;
    private String orderDetails;
    private String hasUrgentDelivery;
    private String[] orderTypes;
    private List<String> paymentOptions;
    private List<BaseItem> items;

    public Order() {
    }

    @JsonCreator
    public Order( @JsonProperty("orderDetails") final String orderDetails ) {
        this.orderDetails = orderDetails;
    }

    public String getOrderDetails() {
        return this.orderDetails;
    }

    public void setOrderDetails( final String orderDetails ) {
        this.orderDetails = orderDetails;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId( final String orderId ) {
        this.orderId = orderId;
    }

    public String getHasUrgentDelivery() {
        return this.hasUrgentDelivery;
    }

    public void setHasUrgentDelivery( final String hasUrgentDelivery ) {
        this.hasUrgentDelivery = hasUrgentDelivery;
    }

    public String[] getOrderTypes() {
        return this.orderTypes;
    }

    public void setOrderTypes( final String[] orderTypes ) {
        this.orderTypes = orderTypes;
    }

    public List<String> getPaymentOptions() {
        return this.paymentOptions;
    }

    public void setPaymentOptions( final List<String> payments ) {
        this.paymentOptions = payments;
    }

    public List<BaseItem> getItems() {
        return this.items;
    }

    public void setItems( final List<BaseItem> items ) {
        this.items = items;
    }

    @Override
    public String toString() {
        return new ToStringBuilder( this ).append( "orderId", this.orderId ).append( "orderDetails", this.orderDetails ).append( "hasUrgentDelivery", this.hasUrgentDelivery ).append( "namespaces", this.paymentOptions ).append( "items", this.items ).build();
    }
}
