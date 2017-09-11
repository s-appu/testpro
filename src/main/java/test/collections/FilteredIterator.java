package test.collections;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteredIterator<E> implements Iterator<E> {

    List<E> list;
    Predicate<E> condition;
    int size;
    int cursor;

    public FilteredIterator( final List<E> list, final Predicate<E> condition ) {
        this.list = list;
        this.condition = condition;
        this.size = list.size();
        this.figureOutMatchingElement();
    }

    @Override
    public E next() {
        if ( !this.hasNext() ) {
            throw new NoSuchElementException();
        }
        final E element = this.list.get( this.cursor );
        this.figureOutMatchingElement();
        return element;
    }

    @Override
    public boolean hasNext() {
        return this.cursor < this.size;
    }

    private void figureOutMatchingElement() {
        boolean didFind = false;
        for ( int i = this.cursor; i < this.size; i++ ) {
            if ( this.condition.test( this.list.get( i ) ) ) {
                this.cursor = i;
                didFind = true;
                break;
            }
        }
        if ( !didFind ) {
            this.cursor = this.size + 1;
        }
    }

}
