import java.util.*;

public class ObservedPin {

    private static final Map<String, List<String>> keypadAdjacentMap = buildKeypadAdjacentMap();

    public static List<String> getPINs(String entered) {

        if (entered.length() == 1) {
            return new ArrayList<>(keypadAdjacentMap.get(entered));
        }

        var numbers = entered.split("");

        var stack = new LinkedList<List<String>>();
        for (String originalDigit : numbers) {
            stack.push(keypadAdjacentMap.get(originalDigit));
        }

        while (stack.size() > 1) {
            var units = stack.pop();
            var tens = stack.pop();
            stack.push(permutationOf(units, tens));
        }
        return stack.pop();
    }


    private static List<String> permutationOf(List<String> units, List<String> tens) {
        Set<String> results = new HashSet<>();
        for (String numberInTens : tens) {
            for (String numberInUnits : units) {
                results.add(numberInTens + numberInUnits);
            }
        }
        return new ArrayList<>(results);
    }

    private static Map<String, List<String>> buildKeypadAdjacentMap() {
        Map<String, List<String>> keypadAdjacentMap = new HashMap<>();
        keypadAdjacentMap.put("0", List.of("0", "8"));
        keypadAdjacentMap.put("1", List.of("1", "2", "4"));
        keypadAdjacentMap.put("2", List.of("1", "2", "3", "5"));
        keypadAdjacentMap.put("3", List.of("3", "2", "6"));
        keypadAdjacentMap.put("4", List.of("1", "4", "5", "7"));
        keypadAdjacentMap.put("5", List.of("2", "4", "5", "6", "8"));
        keypadAdjacentMap.put("6", List.of("3", "5", "6", "9"));
        keypadAdjacentMap.put("7", List.of("7", "8", "4"));
        keypadAdjacentMap.put("8", List.of("5", "7", "8", "9", "0"));
        keypadAdjacentMap.put("9", List.of("9", "8", "6"));
        return keypadAdjacentMap;
    }
}
