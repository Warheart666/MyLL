package com.company;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by WarhearT on 02.09.2020.
 */

@Getter
@Setter
public class MyLinkedList<T> implements Iterable<T> {

    int size = 0;
    //    Pair<T> value;
    Pair<T> first;
    Pair<T> last;


    public void add(T elem) {
        Pair<T> pair;

        if (size == 0) {
            pair = new Pair<T>(null, null, elem);
            this.first = pair;
            this.last = pair;
        } else {
            pair = new Pair<T>(null, last, elem);
            last.setNextVal(pair);
            first.setNextVal(last);
            last = pair;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        Iterator<T> iterator = iterator();

        while (iterator.hasNext()) {
            builder.append(iterator.next());
            if (iterator.hasNext())
                builder.append(", ");
        }

        builder.append("]");
        return builder.toString();
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }


    private class MyIterator implements Iterator<T> {

        private int actualIndex = -1;
        private Pair<T> actualPair = first;


        public boolean hasNext() {
            return actualIndex < getSize() - 1;
        }

        public T next() {


            if (!hasNext())
                throw new NoSuchElementException();

            if (actualIndex == -1) {
                actualIndex++;
                return actualPair.getValue();
            }

            actualPair = actualPair.getNextVal();
            actualIndex++;
            return actualPair.getValue();

        }


        public void remove() {

            Pair<T> pair = first;
            Pair<T> prev = pair;
            actualIndex++;
            int i = 1;

            while (i < actualIndex) {
                prev = pair.getPrevVal();
                pair = pair.getNextVal();
                i++;
            }

            prev.setNextVal(pair);
            pair.setPrevVal(prev);
            size--;

        }
    }

//
////    public MyLinkedList() {
////        this.value = new Pair<T>(null, null, null);
////    }
//
//    public T add(T value) {
//        Pair<T> lastPair = getLastPair(this.value);
//        Last new Pair<T>(null, lastPair, value)
//        lastPair.setNextVal();
//        lastPair.setPrevVal(lastPair);
//
//        size++;
//
//
//    }
//
//    private Pair<T> getLastPair(Pair<T> value) {
//        return value.getNextVal() == null ? value : getLastPair(value.getNextVal());
//    }


}
