package Logic;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class Client {
    private final static Scanner scanner = new Scanner(System.in);

    public static void requestData() {
        String parsingString = "";
        while (!parsingString.equals("exit")) {
            System.out.println("Please input user's params separated by a space(to exit input 'exit'): ");
            parsingString = scanner.nextLine();
            if (parsingString.equalsIgnoreCase("exit")) {
                System.out.println("Have a good day!");
                return;
            }
            try {
                UserParser userParser = new UserParser();
                User user = userParser.parseString(parsingString);
                if (UserSaver.saveUserToFile(user)) {
                    System.out.println("User was saved to file successful!");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void closeClient() {
        scanner.close();
    }
}
