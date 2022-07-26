import codewars.AWScode;
import org.junit.jupiter.api.Test;
import java.util.*;


public class AWScodeTests {
    @Test
    public void getMinimumDaysTest() {
        List<Integer> parcels = new ArrayList<>();
        parcels.add(4);
        parcels.add(6);
        parcels.add(4);
        parcels.add(7);
        parcels.add(3);
        parcels.add(6);
        parcels.add(5);
        parcels.add(6);
        System.out.println("Minimum days: " + AWScode.getMinimumDays(parcels));
    }

    @Test
    public void findTotalImbalanceTest() {
        List<Integer> rank = new ArrayList<>();
        rank.add(4);
        rank.add(1);
        rank.add(3);
        rank.add(2);
        System.out.println("Total Imbalance: " + AWScode.findTotalImbalance(rank));
    }
}
