import java.util.Scanner;

public class cesar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Sheno tekstin qe deshironi ti enkriptoni:");
        String teb= input.nextLine();
        System.out.println("Per sa deshironi ti zhvendosni shkronjat:");
        int shty = input.nextInt();
        String cesarTeksti = enkriptimiMesazhit(shty,teb);
        System.out.println(cesarTeksti);
    }

    public static String enkriptimiMesazhit( int shtyje,String teksti) {
        if (shtyje < 0) {
            shtyje = (shtyje%26)+26;
        } else if (shtyje > 26) {
            shtyje=shtyje%26;
        }
        String text = "";
        int gjatsia = teksti.length();
        for (int i = 0;i<gjatsia;i++) {
            char k = teksti.charAt(i);
            if (Character.isLetter(k)){
                if (Character.isLowerCase(k)) {
                    char e = (char)(k + shtyje);
                    if (e > 'z') {
                        text += (char)(k - (26 - shtyje));
                    }
                    else {
                        text += e;
                    }
                } else if (Character.isUpperCase(k)) {
                    char e= (char)(k + shtyje);
                    if (e > 'Z') {
                        text += (char) (k - (26 - shtyje));
                    } else {
                        text +=e;
                    }
                }
            } else {
                text += k;
            }
        }
        return text;
    }
}
