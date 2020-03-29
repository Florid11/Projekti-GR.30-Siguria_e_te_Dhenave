import java.util.Scanner;

public class Florian {
    public static void main(String[] args) {
        System.out.println("Shenoni mesazhin:");
        Scanner input=new Scanner(System.in);
        int x=1;
        do {
            try {


                String mesazhi = input.nextLine();


                String encrypted = encryptMessage(mesazhi);
                String decrypted = decryptMessage(encrypted);
                System.out.println("Teksti i enkriptuar eshte:"+encrypted);
                System.out.println("Teskti i dekriptuar eshte:"+decrypted);
                x=2;
            } catch (Exception e) {
                System.out.println("Keni vendosur nje tekst jo valid!Provoni perseri");
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
