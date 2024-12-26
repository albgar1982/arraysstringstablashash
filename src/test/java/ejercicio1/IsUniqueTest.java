package ejercicio1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ejercicio1.IsUnique;
import org.junit.jupiter.api.Test;

public class IsUniqueTest {

    @Test
    public void isUniqueTest() {
        IsUnique isUnique = new IsUnique();
        assertTrue(isUnique.isUnique("abcde"));
        assertTrue(isUnique.isUnique("aAbBcCdDeE"));
        assertFalse(isUnique.isUnique("abcded"));
    }
}
