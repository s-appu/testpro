package test.some;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OptionalTest {

    private Optional<String> noText = Optional.ofNullable( null );

    @Before
    public void setup() {

    }

    @Test
    public void optionalTest_addIfPresent() {
        final List<String> allTexts = new ArrayList<>();

        final Optional<String> someText = Optional.of( "Ok there is some text here" );

        someText.ifPresent( s -> allTexts.add( s ) );
        this.noText.ifPresent( allTexts::add );

        Assert.assertEquals( 1, allTexts.size() );
        Assert.assertEquals( "Ok there is some text here", allTexts.get( 0 ) );

    }

    @Test
    public void optionalTest_mapMethod() {
        final Optional<String> theBigText = Optional.of( "this is my big text" );

        final Optional<String> subStringedOutput = theBigText.map( s -> s.substring( 0, 4 ) );
        final Optional<String> noTextSubStringedOutput = this.noText.map( s -> s.substring( 0, 4 ) );

        Assert.assertThat( subStringedOutput.get(), Is.is( "this" ) );
        Assert.assertThat( noTextSubStringedOutput.isPresent(), Is.is( false ) );
    }

    /**
     * Optional.flatMap is used when we have an existing Optional and want to apply a function that also returns a type of Optional.
     */
    @Test
    public void optionalTest_withFlatMap() {
        final Function<String, Optional<String>> upperCaseOptionalString = s -> ( s == null ? Optional.empty() : Optional.of( s.toUpperCase() ) );

        final Optional<String> text = Optional.of( "textual scripts" );

        final Optional<Optional<String>> optionalOfOptionalResult = text.map( upperCaseOptionalString );
        final Optional<String> optionalResult = text.flatMap( upperCaseOptionalString );

        Assert.assertThat( optionalOfOptionalResult.get().get(), Is.is( "textual scripts".toUpperCase() ) );
        Assert.assertThat( optionalResult.get(), Is.is( "textual scripts".toUpperCase() ) );

    }

    @Test
    public void optionalTest_withFilter() {
        final Optional<Integer> number = Optional.ofNullable( 10 );

        final Optional<Integer> numberGreaterThan100 = number.filter( n -> n > 100 );
        final Optional<Integer> numberLessThan100 = number.filter( n -> n < 100 );

        Assert.assertThat( numberGreaterThan100.isPresent(), Is.is( false ) );
        Assert.assertThat( numberLessThan100.isPresent(), Is.is( true ) );
    }

}
