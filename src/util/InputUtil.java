package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String lerString(String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextLine();
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem + ": ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static LocalDate lerData(String mensagem) {
        System.out.print(mensagem + " (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        return LocalDate.parse(dataStr, dateFormatter);
    }

    public static void aguardarEnter() {
        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }
}

