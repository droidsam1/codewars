import java.util.*;

public class ObservedPin {

    private static final Map<String, List<String>> keypadAdjacentMap = buildKeypadAdjacentMap();

    public static List<String> getPINs(String entered) {

        if (entered.length() == 1) {
            return new ArrayList<>(keypadAdjacentMap.get(entered));
        }

        var numbers = entered.split("");
        List<List<String>> combinations = new ArrayList<>();
        for (String originalDigit : numbers) {
            combinations.add(keypadAdjacentMap.get(originalDigit));
        }


        return new ArrayList<>(permutations(combinations));
    }

    private static Set<String> permutations(List<List<String>> possibilities) {

        var results = new HashSet<String>();
        var possibilitiesForDigitAt0 = possibilities.get(0);
        for (var possibility : possibilitiesForDigitAt0) {
            for (var possibilityForDigitAt1 : possibilities.get(1)) {
                if (possibilities.size() > 2) {
                    for (var possibilityForDigitAt2 : possibilities.get(2)) {
                        results.add(possibility + possibilityForDigitAt1 + possibilityForDigitAt2);
                    }
                } else {
                    results.add(possibility + possibilityForDigitAt1);
                }
            }
        }
        return results;
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

    private static String replaceNumberAtPosition(String[] numbers, int position, String number) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (i != position) stringBuilder.append(numbers[i]);
            else stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
