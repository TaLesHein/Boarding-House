package util;

import java.util.regex.Pattern;

/*
 * Class intended for handling and validating Strings
 */
public class StringUtils {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    // Validates if the registered email has the correct standards
    public static boolean isValidEmail(String email) {

        boolean isValidFormat = EMAIL_PATTERN.matcher(email).matches();
        boolean hasComExtension = email.endsWith(".com");

        return isValidFormat && hasComExtension;
    }

    public static String capitalizeFirstString(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }

        // Make the first letter of the String uppercase
        return str.substring(0, 1).toUpperCase()
                + str.substring(1).toLowerCase();

    }
}
