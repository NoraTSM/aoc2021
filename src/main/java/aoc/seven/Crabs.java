package aoc.seven;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.Interval;

public class Crabs {

    public class Position {

        int pos;
        long fuel;

        Position(int pos, long fuel) {
            this.pos = pos;
            this.fuel = fuel;
        }
    }

    public long align(String input) {
        MutableIntList crabs = Lists.mutable.with(input.split(",")).collectInt(Integer::parseInt);
        ImmutableIntSet positions = crabs.toSet().toImmutable();
        ImmutableSet<Position> all = positions.collect(pos -> new Position(pos, IntLists.immutable.withAll(crabs.collect(crab -> Math.abs(pos - crab))).sum()));

        return all.collect(position -> position.fuel).min();
    }

    public long alignFactorial(String input) {
        MutableIntList crabs = Lists.mutable.with(input.split(",")).collectInt(Integer::parseInt);
        ImmutableIntList positions = IntLists.immutable.of(Interval.fromTo(0, crabs.max()).toIntArray());
        ImmutableList<Position> all = positions.collect(pos -> new Position(pos, LongLists.immutable.withAll(crabs.collect(crab -> factorial(Math.abs(pos - crab)))).sum()));

        return all.collect(position -> position.fuel).min();
    }

    public long factorial(long number) {
        if(number <= 1) {
            return number;
        }
        return IntLists.immutable.of(Interval.fromTo(1, (int) number).toIntArray()).sum();
    }



}
