package ejercicio2;

import com.ejercicio2.TwoSumV2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {

    @Test
    public void twoSumTest() {
        int[] array = new int[] {9, 2, 5, 6};
        TwoSumV2 twoSum = new TwoSumV2();
        int[] result = twoSum.twoSum(array, 7);
        assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));
        assertNull(twoSum.twoSum(array, 50));
    }
}