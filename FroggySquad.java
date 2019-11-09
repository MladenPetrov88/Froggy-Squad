import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FroggySquad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<String> frogs = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            frogs.add(input[i]);
        }

        String command = scanner.nextLine();

        while (!command.contains("Print")) {
            String[] temp = command.split("\\s+");
            String action = temp[0];

            if (action.equals("Join")) {
                frogs.add(temp[1]);
            }

            if (action.equals("Jump")) {
                if (Integer.parseInt(temp[2]) >= 0 && Integer.parseInt(temp[2]) < frogs.size()) {
                    frogs.add(Integer.parseInt(temp[2]), temp[1]);
                }
            }

            if (action.equals("Dive")) {
                if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < frogs.size()) {
                    frogs.remove(Integer.parseInt(temp[1]));
                }
            }

            if (action.equals("First")) {
                if (Integer.parseInt(temp[1]) > frogs.size()) {
                    for (String frog : frogs) {
                        System.out.print(frog + " ");
                    }
                } else if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < frogs.size()){
                    for (int i = 0; i < Integer.parseInt(temp[1]); i++) {
                        System.out.print(frogs.get(i) + " ");
                    }
                }
            }

            if (action.equals("Last")) {
                if (Integer.parseInt(temp[1]) > frogs.size()) {
                    for (int i = 0; i < frogs.size(); i++) {
                        System.out.print(frogs.get(i) + " ");
                    }
                } else if (Integer.parseInt(temp[1]) >= 0 && Integer.parseInt(temp[1]) < frogs.size()){
                    for (int i = frogs.size() - Integer.parseInt(temp[1]); i < frogs.size(); i++) {
                        System.out.print(frogs.get(i) + " ");
                    }
                }
            }

            command = scanner.nextLine();
        }

        String[] a = command.split(" ");
        System.out.println();

        if (a[0].equals("Print")) {
            System.out.print("Frogs: ");
            if (a[1].equals("Normal")) {
                for (String frog : frogs) {
                    System.out.print(frog + " ");
                }
            } else if (a[1].equals("Reversed")) {
                for (int i = frogs.size() - 1; i >= 0; i--) {
                    System.out.print(frogs.get(i) + " ");
                }
            }
        }
    }
}
