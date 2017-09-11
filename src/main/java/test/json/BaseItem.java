package test.json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property = "@class")
@JsonSubTypes({
        @Type(value = Cloths.class, name = "cloths"),
        @Type(value = Home.class, name = "home")
})
public class BaseItem {

    private Long itemId;
    private String itemDescription;

    public String getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription( final String itemDescription ) {
        this.itemDescription = itemDescription;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId( final Long itemId ) {
        this.itemId = itemId;
    }

}
