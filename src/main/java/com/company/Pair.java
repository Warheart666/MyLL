package com.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by WarhearT on 02.09.2020.
 */

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Pair<T> {

    T value;

    @ToString.Exclude
    Pair<T> nextVal;

    @ToString.Exclude
    Pair<T> prevVal;

    public Pair(Pair<T> nextVal, Pair<T> prevVal, T value) {
        this.value = value;
        this.nextVal = nextVal;
        this.prevVal = prevVal;
    }

}
