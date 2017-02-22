package com.annimon.stream.operator;

import com.annimon.stream.PrimitiveExtIterator;
import com.annimon.stream.PrimitiveIterator;
import com.annimon.stream.function.DoubleBinaryOperator;

public class DoubleScan extends PrimitiveExtIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleBinaryOperator accumulator;

    public DoubleScan(PrimitiveIterator.OfDouble iterator, DoubleBinaryOperator accumulator) {
        this.iterator = iterator;
        this.accumulator = accumulator;
    }

    @Override
    protected void nextIteration() {
        hasNext = iterator.hasNext();
        if (hasNext) {
            // TODO nextDouble
            final double current = iterator.next();
            if (isInit) {
                next = accumulator.applyAsDouble(next, current);
            } else {
                next = current;
            }
        }
    }
}
