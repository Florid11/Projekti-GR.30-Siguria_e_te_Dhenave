import java.util.Scanner;

public class Florian {
    public static void main(String[] args) {
        int x=1;
        Scanner input = new Scanner(System.in);

        System.out.print("Sheno tekstin: ");
        do {
            try {


                String mesazhi = input.nextLine();

                String encrypted = encryptMessage(mesazhi);
                System.out.println(encrypted);


                String decrypted = decryptMessage(encrypted);
                System.out.println(decrypted);
                x=2;
            } catch (Exception e) {
                System.out.println("Gabim ne tekst shenojeni tekstin perseri");
            }
        }while (x==1);
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
