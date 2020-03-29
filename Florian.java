import java.util.Scanner;

public class komandaNumerical{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int x=1;
        while(x==1) {
            try {
                System.out.println("Shenoni mesazhin:");
                String mesazhi = input.nextLine();
                String encrypted = encryptMessage(mesazhi);
                String decrypted = decryptMessage(encrypted);
                System.out.println("Teksti i enkriptuar eshte:"+encrypted);
                System.out.println("Teskti i dekriptuar eshte:"+decrypted);
                x=2;
            } catch (Exception e) {
                System.out.println("Keni vendosur nje tekst jo valid!Provoni perseri");

            }
        }
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
