package interview;

// concrete decorator
public class SecureEmailDecorator extends EmailDecorator {
    private String content;

    public SecureEmailDecorator( final IEmail basicEmail ) {
        this.originalEmail = basicEmail;

    }

    @Override
    public String getContents() {
        // secure original
        this.content = this.encrypt( this.originalEmail.getContents() );
        return this.content;
    }

    private String encrypt( final String message ) {
        // encrypt the string
        final String encryptedMessage = "EXN" + message;
        return encryptedMessage;
    }
}
