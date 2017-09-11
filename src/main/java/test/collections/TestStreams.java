package test.collections;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TestStreams {

    public static void main( final String args[] ) {
        testForEachReturn();
    }

    public static void testForEachReturn() {

        final List<String> l1 = Arrays.asList( "A", "B", "1", "2", "C", "D" );

        l1.stream().forEach( p -> {

            if ( p == "1" ) {
                System.out.println( "Is 1" );
                return;
            }

            if ( p == "2" ) {
                System.out.println( "Is 2" );
                return;
            }

            if ( p != "1" && p != "2" ) {
                System.out.println( "Other - " + p );
                return;
            }

        } );
    }

    @Test
    public void testStreamFilter() {
        final String s = null;
        final List<String> l1 = Arrays.asList( "A", "B", "1", "2", "C", "D" );

        System.out.println( l1.stream().filter( p -> p.equals( "A" ) ).filter( p -> s.equals( p ) ).collect( Collectors.toList() ) );
    }

    @Test
    public void testStreamMap() {
        final List<String> list = new ArrayList<String>();
        list.stream().findFirst().map( p -> p.length() );
    }

    @Test
    public void testFlatMapHappCase() {

        final List<Rendition> myRenditions = new ArrayList<>();
        final Captions cpt1 = new Captions( URI.create( "my_ttml" ), "ttml" );
        final Captions cpt2 = new Captions( URI.create( "my_vtt" ), "vtt" );

        myRenditions.add( new Rendition( "mp4Renditions", Arrays.asList( cpt1, cpt2 ) ) );

        final Set<RenditionAndCaption> test = myRenditions.stream().map( p -> p.captions ).flatMap( c -> c.stream() ).map( p -> new RenditionAndCaption( p.type, p.name.toString() ) ).collect( Collectors.toSet() );

        System.out.println( test );

    }

    @Test
    public void testFlatMapSadCase1() {

        final List<Rendition> myRenditions = new ArrayList<>();

        myRenditions.add( new Rendition( "mp4Renditions", null ) );

        final Set<RenditionAndCaption> test = myRenditions.stream().filter( p -> Objects.nonNull( p.captions ) ).map( p -> p.captions ).flatMap( c -> c.stream() ).map( p -> new RenditionAndCaption( p.type, p.name.toString() ) ).collect( Collectors.toSet() );

        System.out.println( test );

    }

    @Test
    public void testFlatMapSadCase2() {

        final List<Rendition> myRenditions = new ArrayList<>();

        myRenditions.add( new Rendition( "mp4Renditions", new ArrayList<>() ) );

        final Set<RenditionAndCaption> test = myRenditions.stream().map( p -> p.captions ).flatMap( c -> c.stream() ).map( p -> new RenditionAndCaption( p.type, p.name.toString() ) ).collect( Collectors.toSet() );

        System.out.println( test );

    }

    @Test
    public void testFlatMapSadCase3() {

        final List<Rendition> myRenditions = new ArrayList<>();

        final Captions cpt1 = new Captions( null, "ttml" );
        myRenditions.add( new Rendition( "mp4Renditions", Arrays.asList( cpt1 ) ) );

        final Set<RenditionAndCaption> test = myRenditions.stream().map( p -> p.captions ).flatMap( c -> c.stream() ).filter( l -> Objects.nonNull( l.name ) ).map( p -> new RenditionAndCaption( p.type, p.name.toString() ) ).collect( Collectors.toSet() );

        System.out.println( test );

    }

    @Test
    public void testGroupingCase() {

        final List<Rendition> myRenditions = new ArrayList<>();
        final Captions cpt1 = new Captions( URI.create( "my_ttml" ), "ttml" );
        final Captions cpt2 = new Captions( URI.create( "my_vtt" ), "vtt" );

        myRenditions.add( new Rendition( "mp4Renditions", Arrays.asList( cpt1, cpt2 ) ) );

        final Set<RenditionAndCaption> test = myRenditions.stream().map( p -> p.captions ).flatMap( c -> c.stream() ).map( p -> new RenditionAndCaption( p.type, p.name.toString() ) ).collect( Collectors.toSet() );

        System.out.println( test );

    }

    @Test
    public void testStreamConcatenation() {
        final Captions cpt1 = new Captions( URI.create( "my_ttml" ), "ttml" );
        final Captions cpt2 = new Captions( URI.create( "my_vtt" ), "vtt" );
        final List<Captions> captions1 = Arrays.asList( cpt1, cpt2 );

        final Captions cpt3 = new Captions( URI.create( "my_xyz" ), "xyz" );
        final Captions cpt4 = new Captions( URI.create( "my_abc" ), "abc" );
        final List<Captions> captions2 = Arrays.asList( cpt3, cpt4 );

        final Stream<Captions> s = Stream.concat( captions1.stream(), captions2.stream() );

    }

    class Rendition {

        String name;
        List<Captions> captions;

        public Rendition( final String name, final List<Captions> captions ) {
            this.name = name;
            this.captions = captions;
        }

    }

    class Captions {
        URI name;
        String type;

        public Captions( final URI name, final String type ) {
            this.name = name;
            this.type = type;
        }

    }

    class RenditionAndCaption {
        String captionType;
        String captionName;

        RenditionAndCaption( final String captionType, final String captionName ) {
            this.captionType = captionType;
            this.captionName = captionName;
        }

    }
}
