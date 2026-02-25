public class Pre6 {

    static String input;
    static int index = 0;

    // Check current character
    static char current() {
        if (index < input.length())
            return input.charAt(index);
        return '\0';
    }

    // Match expected character
    static boolean match(char c) {
        if (current() == c) {
            index++;
            return true;
        }
        return false;
    }

    // S → ( L ) | a
    static boolean S() {
        if (match('a')) {
            return true;
        } 
        else if (match('(')) {
            if (L() && match(')')) {
                return true;
            }
        }
        return false;
    }

    // L → S L’
    static boolean L() {
        if (S()) {
            return Ldash();
        }
        return false;
    }

    // L’ → , S L’ | ε
    static boolean Ldash() {
        if (match(',')) {
            if (S()) {
                return Ldash();
            }
            return false;
        }
        return true; 
    }

    public static void main(String[] args) {
        String[] tests = {
            "a", "(a)", "(a,a)", "(a,(a,a),a)", "(a,a),(a,a)",
            "a)", "(a a", "(a,a a, (a,a),a"
        };

        for (String test : tests) {
            input = test;
            index = 0;

            boolean result = S() && index == input.length();

            if (result)
                System.out.println(test + " -> Valid string");
            else
                System.out.println(test + " -> Invalid string");
        }
    }
}