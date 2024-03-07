import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
    public boolean checkString(String s) {
        return s.equalsIgnoreCase("moon");
    }
}

public class TestListExamples {

    @Test(timeout = 500)
    public void testMergeRightEnd() {
        List<String> left = Arrays.asList("a", "b", "c");
        List<String> right = Arrays.asList("a", "d");
        List<String> merged = ListExamples.merge(left, right);
        List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
        assertEquals(expected, merged);
    }

    @Test
    public void testMerge() {
        List<String> list1 = Arrays.asList("apple", "banana", "cherry");
        List<String> list2 = Arrays.asList("blueberry", "grape", "orange");

        List<String> result = ListExamples.merge(list1, list2);

        List<String> expected = Arrays.asList("apple", "banana", "blueberry", "cherry", "grape", "orange");
        assertEquals(expected, result);
    }

    @Test
    public void testMergeEmptyLists() {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        List<String> result = ListExamples.merge(list1, list2);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testMergeEqualStringsInBothLists() {
        List<String> list1 = Arrays.asList("apple", "banana", "cherry");
        List<String> list2 = Arrays.asList("banana", "cherry", "date");

        List<String> result = ListExamples.merge(list1, list2);

        List<String> expected = Arrays.asList("apple", "banana", "banana", "cherry", "cherry", "date");
        assertEquals(expected, result);
    }

    @Test
    public void testFilter() {
        List<String> inputList = Arrays.asList("apple", "banana", "cherry", "date", "kiwi");
        StringChecker checker = new IsMoon(); // Use a concrete implementation of StringChecker

        List<String> result = ListExamples.filter(checker, inputList);

        List<String> expected = Arrays.asList("date");
        assertEquals(expected, result);
    }

    @Test
    public void testFilterEmptyList() {
        List<String> inputList = new ArrayList<>();
        StringChecker checker = new IsMoon(); // Use a concrete implementation of StringChecker

        List<String> result = ListExamples.filter(checker, inputList);

        assertTrue(result.isEmpty());
    }
}
