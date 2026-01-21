import java.util.*;

public class pre3 {

    static Set<String> keywords = new HashSet<>(Arrays.asList(
            "int", "float", "char", "void", "return",
            "long", "struct", "scanf", "printf"
    ));

    static Set<String> operators = new HashSet<>(Arrays.asList(
            "+", "-", "*", "/", "=", "==", "<", ">", "<=", ">=", "!="
    ));

    static Set<String> punctuations = new HashSet<>(Arrays.asList(
            "(", ")", "{", "}", "[", "]", ";", ",", "&"
    ));

    static Set<String> symbolTable = new LinkedHashSet<>();
    static List<String> tokens = new ArrayList<>();
    static List<String> lexicalErrors = new ArrayList<>();


    static boolean isIdentifier(String s) {
        return s.matches("[A-Za-z_][A-Za-z0-9_]*");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
    }
}
