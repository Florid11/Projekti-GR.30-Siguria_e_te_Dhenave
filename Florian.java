import java.util.Scanner;

public class Florian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Sheno tekstin: ");
        String mesazhi = input.nextLine();

        String encrypted = encryptMessage(mesazhi);
        System.out.println(encrypted);


        String decrypted = decryptMessage(encrypted);
        System.out.println(decrypted);
    }

    private static String encryptMessage(String message) {
        String result = "";
        for (char ch: message.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                result += (ch - 96) + " ";
            }
        }
        return result;
    }

    private static String decryptMessage(String message) {
        String[] numbers = message.split(" ");
        String result = "";
        for (String num: numbers) {
            result += (char)(Integer.parseInt(num) + 96);
        }
        return result;
    }
}