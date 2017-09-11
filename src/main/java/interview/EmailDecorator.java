package interview;

public abstract class EmailDecorator implements IEmail {
    // wrapped component
    IEmail originalEmail;
}