package codewars;

import java.util.*;


public class AWScode {
    //Minimum days required to deliver all parcels from each delivery center, a min of 1 parcel needs to be present in order for it to be delivered
    public static int getMinimumDays(List<Integer> parcels) {
        // convert integer list into a set in order to remove duplicate number of parcels
        Set<Integer> minimumDays = new HashSet<>(parcels);

        // removing '0' from the set, we don't want to account for this value in the result
        // since a min of 1 parcel needs to be present in order for it to be delivered
        minimumDays.remove(0);

        return minimumDays.size();
    }

//  Given an array ranks of ranks of students in a school. All students need to be split into groups k.
//  Find the total 'imbalance' of all groups. An imabalance of a group can be found as :
//  Sorting each group in the order of their ranks.
//  A group contributes to imbalance if any 2 students in the sorted array have a rank difference of more than 1.
//  Find the total sum of imbalance of all such groups.
    public static long findTotalImbalance(List<Integer> rank) {
        TreeSet<Integer> ts = new TreeSet<>();
        long totalImbalance = 0;

        // iterate through rank list
        for (int i = 0; i < rank.size(); i++) {
            long currentImbalance = 0;

            ts.clear();
            ts.add(rank.get(i));

            for (int j = i + 1; j < rank.size(); j++) {
                Integer e = rank.get(j);
                ts.add(e);
                Integer floor = ts.lower(e);
                Integer ceiling = ts.higher(e);

                // add at beggining
                if (floor == null) {
                    currentImbalance += (((ceiling - e) > 1) ? 1 : 0);
                }
                // add at end
                else if (ceiling == null) {
                    currentImbalance += (((e - floor) > 1) ? 1 : 0);
                }
                else {
                    currentImbalance += (ceiling - floor) > 1 ? -1 : 0;
                    currentImbalance += (ceiling - e) > 1 ? 1 : 0;
                    currentImbalance += (e - floor) > 1 ? 1 : 0;
                }

                totalImbalance += currentImbalance;
            }
        }

        return totalImbalance;
    }
}
