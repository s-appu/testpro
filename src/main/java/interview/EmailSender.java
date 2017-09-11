package interview;
// Extending the below Email implementation..
// 1. emails that leave the company internal server need to have a disclaimer added to the end
// 2. emails sent to "gmail" domain should be encrypted.

public class EmailSender {

    public void sendEmail( final IEmail email ) {

    }
}

interface IEmail {
    public String getContents();
}

// concrete component
class Email implements IEmail {
    private final String content;

    public Email( final String content ) {
        this.content = content;
    }

    @Override
    public String getContents() {
        // general email stuff
        return this.content;
    }
}