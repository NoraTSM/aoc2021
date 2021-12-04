package aoc.three;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.impl.factory.primitive.IntLists;

import static java.lang.Integer.parseInt;
import static org.eclipse.collections.impl.list.Interval.fromTo;


public class BinaryDiagnostic {


    public int power(String input) {
        MutableList<String> asStrings = Lists.mutable.with(input.split("\n"));
        ImmutableIntList intList = IntLists.immutable.of(fromTo(0, asStrings.getAny().length() - 1).toIntArray());

        ImmutableList<String> gamma = intList.collect(i -> mostCommonBit(asStrings.collect(each -> each.substring(i, i + 1))));
        ImmutableList<String> epsilon = intList.collect(i -> leastCommonBit(asStrings.collect(each -> each.substring(i, i + 1))));

        return parseInt(String.join("", gamma), 2) * parseInt(String.join("", epsilon), 2);
    }

    public int lifeSupportRating(String input) {
        MutableList<String> asStrings = Lists.mutable.with(input.split("\n"));
        ImmutableIntList intList = IntLists.immutable.of(fromTo(0, asStrings.getAny().length() - 1).toIntArray());

        MutableList<String> o2List = Lists.mutable.ofAll(asStrings);
        intList.forEach(i -> {
            if (o2List.size() > 1) {
                o2List.removeAll(o2List.reject(element -> element.substring(i, i + 1).equals(mostCommonBit(o2List.collect(each -> each.substring(i, i +1))))));
            }
        });

        MutableList<String> coList = Lists.mutable.ofAll(asStrings);
        intList.forEach(i -> {
            if (coList.size() > 1) {
                coList.removeAll(coList.reject(element -> element.substring(i, i + 1).equals(leastCommonBit(coList.collect(each -> each.substring(i, i + 1))))));
            }
        });

        return parseInt(String.join("", o2List.getAny()), 2) * parseInt(String.join("", coList.getAny()), 2);
    }

    private String mostCommonBit(MutableList<String> pos) {
        PartitionMutableList<String > partition = pos.partition("1"::equals);
        return partition.getSelected().size() >= partition.getRejected().select("0"::equals).size() ? "1" : "0";
    }

    private String leastCommonBit(MutableList<String> pos) {
        PartitionMutableList<String> partition = pos.partition("0"::equals);
        return partition.getSelected().size() <= partition.getRejected().select("1"::equals).size() ? "0" : "1";
    }



}
