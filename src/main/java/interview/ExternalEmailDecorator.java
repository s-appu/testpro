package interview;

// concrete decoratorpublic
public class ExternalEmailDecorator extends EmailDecorator {

    private String content;

    public ExternalEmailDecorator( final IEmail basicEmail ) {
        this.originalEmail = basicEmail;
    }

    @Override
    public String getContents() {
        // secure original
        this.content = this.addDisclaimer( this.originalEmail.getContents() );
        return this.content;
    }

    private String addDisclaimer( final String message ) {
        // append company disclaimer to message
        return message + "\n Company Disclaimer";
    }
}