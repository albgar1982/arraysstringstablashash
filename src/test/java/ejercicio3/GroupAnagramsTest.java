package ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import com.ejercicio3.GroupAnagramsSolution;
import org.junit.jupiter.api.Test;

public class GroupAnagramsTest {

    @Test
    public void groupAnagramsTest() {
        GroupAnagramsSolution groupAnagrams = new GroupAnagramsSolution();
        List<List<String>> empty = groupAnagrams.groupAnagrams(new String[] {}); //Para el caso de una lista vacía...
        assertTrue(empty.isEmpty()); //...devuelve una lista vacía

        List<List<String>> anagrams =
                groupAnagrams.groupAnagrams(
                        new String[] {"saco", "arresto", "programa", "rastreo", "caso"});
        assertEquals(3, anagrams.size()); //Se esperan 3 listas dentro de la lista a devolver
        assertTrue(containsAll(anagrams, List.of("programa")));
        assertTrue(containsAll(anagrams, List.of("caso", "saco")));
        assertTrue(containsAll(anagrams, List.of("arresto", "rastreo")));
    }

    private boolean containsAll(List<List<String>> anagrams, List<String> group) {
        for (List<String> g : anagrams) { //Para cada lista en anagrams
            if (g.containsAll(group)) return true; //Si esa lista contiene todos los miembros de group, devuelve true
        }
        return false;
    }
}