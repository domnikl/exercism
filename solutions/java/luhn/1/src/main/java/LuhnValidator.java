class LuhnValidator {
    boolean isValid(String candidate) {
        int sum = 0;
        int x = 0;
        String input = candidate.replaceAll(" ", "");

        if (input.length() <= 1) return false;

        for (int i = input.length() - 1; i >= 0; i--) {
            String substr = input.substring(i, i + 1);
            int n;

            try {
                n = Integer.parseInt(substr);
            } catch (NumberFormatException e) {
                return false;
            }

            if (x % 2 != 0) {
                n *= 2;

                if (n > 9) {
                    n -= 9;
                }
            }

            sum += n;
            x++;
        }

        return sum % 10 == 0;
    }
}
