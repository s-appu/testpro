package test.json;

public class Cloths extends BaseItem {

    private String gender;

    public Cloths() {

    }

    public Cloths( final String itemDescription, final Long itemId, final String gender ) {
        this.setItemDescription( itemDescription );
        this.setItemId( itemId );
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender( final String gender ) {
        this.gender = gender;
    }

}
