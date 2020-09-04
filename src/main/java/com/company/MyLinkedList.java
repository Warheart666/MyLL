package com.company;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;

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


    public T add(T elem) {
        Pair<T> pair;

        if (size == 0) {
            pair = new Pair<T>(null, null, elem);
            this.first = pair;
            this.last = pair;
        } else {
            pair = new Pair<T>(null, last, elem);
            last.setNextVal(pair);
            first.setNextVal(last);
            last = (pair);
        }
        size++;
        return pair.getValue();
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

        private int actualIndex = 0;

        public boolean hasNext() {
            return actualIndex < getSize();
        }

        public T next() {

            Pair<T> pair = first;

            actualIndex++;
            int i = 1;

            while (i < actualIndex) {
                pair = pair.getNextVal();
                i++;
            }

            return pair.getValue();
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
