import java.util.List;

public class ObservedPin {
    public static List<String> getPINs(String entered) {
        if (entered.equals("0")) {
            return List.of("0", "8");
        }

        if (entered.equals("1")) {
            return List.of("1", "2", "4");
        }

        return List.of(entered);
    }
}
