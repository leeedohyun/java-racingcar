package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(final String line) {
        if (line == null || line.isBlank()) {
            return 0;
        }

        final String[] tokens = split(line);
        return calculateSum(tokens);
    }

    private static String[] split(final String line) {
        final Matcher m = Pattern.compile("//(.)\n(.*)").matcher(line);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return line.split(",|:");
    }

    private static int calculateSum(final String[] tokens) {
        int sum = 0;
        for (final String value : tokens) {
            final int number = convertStringToInt(value);
            validatePositive(number);
            sum += number;
        }
        return sum;
    }

    private static int convertStringToInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static void validatePositive(final int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
    }
}
