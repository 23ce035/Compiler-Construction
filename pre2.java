import java.util.*;

public class pre2 {
    public static void main(String[] args) {
        System.out.println("Number of input : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Input symbols : ");
        String symbols = sc.nextLine();
        String[] arr = symbols.split(" ");

        System.out.println("Enter number of states : ");
        int numberOfStates = sc.nextInt();

        System.out.println("Initial State : ");
        int initialState = sc.nextInt();

        System.out.println("Number of accepting states : ");
        int numberOfAcceptingStates = sc.nextInt();
        // sc.nextLine();
        System.out.println("Accepting states : ");
        Set<Integer> acceptingStates = new HashSet<>();
        for (int i = 0; i < numberOfAcceptingStates; i++) {
            acceptingStates.add(sc.nextInt());
        }

        // System.out.println("Number of transitions : ");
        // int numberOfTransitions = sc.nextInt();
        sc.nextLine();
        Map<Integer, Map<Character, Integer>> transitionFunction = new HashMap<>();
        System.out.println("Enter transitions in the format: currentState symbol nextState");

        for (int i = 0; i < numberOfStates * 2; i++) {
            String temp = sc.nextLine();
            String[] parts = temp.split(" ");

            int currentState = Integer.parseInt(parts[0]);
            char symbol = parts[2].charAt(0);
            int nextState = Integer.parseInt(parts[4]);

            transitionFunction.putIfAbsent(currentState, new HashMap<>());
            transitionFunction.get(currentState).put(symbol, nextState);
        }
        System.out.println("Enter input string : ");
        String inp = sc.nextLine();
        int crrStat = initialState;
        for (int i = 0; i < inp.length(); i++) {
            Map<Character, Integer> neMap = transitionFunction.get(crrStat);

            crrStat = neMap.get(inp.charAt(i));
        }

        if (acceptingStates.contains(crrStat)) {
            System.out.println("Valid string");
        } else {
            System.out.println("InValid string");
        }

    }
}