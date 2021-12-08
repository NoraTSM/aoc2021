package aoc.eight;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class SevenSegment {

    public record Segment(ImmutableList<String> in, ImmutableList<String> out){}


    public int segment(String input) {

        MutableList<Segment> segments = Lists.mutable.with(input.split("\n")).collect(each -> {
            String[] split = each.split(" \\| ");
            return new Segment(Lists.immutable.with(split[0].split(" ")), Lists.immutable.with(split[1].split(" ")));
        });

        return segments.flatCollect(each -> each.out.collect(this::parse)).select(i -> i >= 0).size();

    }

    public int parse(String signal) {
        int length = signal.length();
        return switch (length) {
            case 2 -> 1;
            case 3 -> 7;
            case 4 -> 4;
            case 7 -> 8;
            default -> -1;
        };
    }
}
