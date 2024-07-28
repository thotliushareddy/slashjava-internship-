import java.security.SecureRandom;

public class PasswordGenerator {
    
    // Alphabet class for defining character sets
    public static class Alphabet {
        public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        public static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        public static final String DIGITS = "0123456789";
        public static final String SPECIAL = "!@#$%^&*()_+";
    }

    // Password class to generate and store a password
    public static class Password {
        private String value;
        private int length;

        public Password(int length, String alphabet) {
            this.length = length;
            this.value = generatePassword(alphabet);
        }

        private String generatePassword(String alphabet) {
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(alphabet.length());
                password.append(alphabet.charAt(index));
            }

            return password.toString();
        }

        public String getValue() {
            return value;
        }
    }

    // Generator class to generate a password based on the selected character sets
    public static class Generator {
        public static Password generate(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
            StringBuilder alphabet = new StringBuilder();
            
            if (useUpper) {
                alphabet.append(Alphabet.UPPER);
            }
            if (useLower) {
                alphabet.append(Alphabet.LOWER);
            }
            if (useDigits) {
                alphabet.append(Alphabet.DIGITS);
            }
            if (useSpecial) {
                alphabet.append(Alphabet.SPECIAL);
            }

            return new Password(length, alphabet.toString());
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        int length = 12;
        boolean useUpper = true;
        boolean useLower = true;
        boolean useDigits = true;
        boolean useSpecial = true;

        Password password = Generator.generate(length, useUpper, useLower, useDigits, useSpecial);
        System.out.println("Generated Password: " + password.getValue());
    }
}
