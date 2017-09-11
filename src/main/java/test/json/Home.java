package test.json;

public class Home extends BaseItem {

    private String roomType;

    public Home() {

    }

    public Home( final String itemDescription, final Long itemId, final String roomType ) {
        this.setItemDescription( itemDescription );
        this.setItemId( itemId );
        this.roomType = roomType;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType( final String roomType ) {
        this.roomType = roomType;
    }
}
