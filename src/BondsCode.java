import java.util.Scanner;

public class BondsCode {
    static String getBondCode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bond code to MI6:");
        String code = scanner.nextLine();
        scanner.close();
        return code;
    }
}
