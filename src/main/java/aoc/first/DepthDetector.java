package aoc.first;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.primitive.IntList;

public class DepthDetector {

    public int depth(String input) {
        IntList data = Lists.immutable.with(input.split("\n")).collectInt(Integer::parseInt);
        final int[] result = {0};
        data.forEachWithIndex((each, index) -> {
            if(index < data.size() - 1 && each < data.get(index + 1)) {
                result[0]++;
            }
        });
        return result[0];
    }
    public int depth_windowed(String input) {
        IntList data = Lists.immutable.with(input.split("\n")).collectInt(Integer::parseInt);
        final int[] result = {0};
        final int[] previous = {0};
        data.forEachWithIndex((each, index) -> {
            if(index < data.size() - 2) {
                int current = data.get(index) + data.get(index +1) +  data.get(index +2);
                if (index != 0 && previous[0] < current) {
                    result[0]++;
                }
                previous[0] = current;
            }
        });
        return result[0];
    }
}
