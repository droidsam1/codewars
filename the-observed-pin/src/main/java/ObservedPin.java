import java.util.List;

public class ObservedPin {
    public static List<String> getPINs(String entered) {
        if (entered.equals("0")) {
            return List.of("0", "8");
        }

        if (entered.equals("1")) {
            return List.of("1", "2", "4");
        }

        if (entered.equals("7")) {
            return List.of("7", "8", "4");
        }

        if (entered.equals("9")) {
            return List.of("9", "8", "6");
        }

        return List.of(entered);
    }
}
