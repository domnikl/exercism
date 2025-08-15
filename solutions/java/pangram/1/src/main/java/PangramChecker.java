import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PangramChecker {
    public boolean isPangram(String input) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = input.toLowerCase(Locale.ROOT).toCharArray();

        List<Character> filtered = new ArrayList<>(chars.length);

        for (char c: chars) {
            if (alphabet.indexOf(c) >= 0 && !filtered.contains(c)) {
                filtered.add(c);
            }
        }

        return filtered.size() == alphabet.length();
    }
}
