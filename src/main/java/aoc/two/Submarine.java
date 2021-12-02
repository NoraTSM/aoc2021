package aoc.two;


import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;

import static java.lang.Integer.parseInt;

public class Submarine {

    public int cruise(String input){
        ImmutableList<String[]> collect = Lists.immutable.of(input.split("\n")).collect(x -> x.split(" "));
        final int[] horizontal = {0};
        final int[] depth = {0};

        collect.forEach(each -> {
            switch(each[0]) {
                case "forward" -> horizontal[0] += parseInt(each[1]);
                case "up" -> depth[0] -= parseInt(each[1]);
                case "down" -> depth[0] += parseInt(each[1]);
            }
        });
        return horizontal[0]*depth[0];
    }

    public int cruiseWithAim(String input){
        ImmutableList<String[]> collect = Lists.immutable.of(input.split("\n")).collect(x -> x.split(" "));
        final int[] horizontal = {0};
        final int[] depth = {0};
        final int[] aim = {0};

        collect.forEach(each -> {
            switch(each[0]) {
                case "forward" -> {
                    horizontal[0] += parseInt(each[1]);
                    depth[0] += (aim[0] * parseInt(each[1]));
                }
                case "up" -> aim[0] -= parseInt(each[1]);
                case "down" -> aim[0] += parseInt(each[1]);
            }
        });
        return horizontal[0]*depth[0];
    }
}
