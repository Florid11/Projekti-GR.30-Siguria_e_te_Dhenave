import java.util.Scanner;

public class komandaCaesar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x=1;
        while(x==1) {
            try {
                System.out.println("Sheno tekstin qe deshironi ti enkriptoni:");
                String teb = input.nextLine();
                System.out.println("Per sa deshironi ti zhvendosni shkronjat:");
                int shty = input.nextInt();
                if (teb.isEmpty()) {
                    System.out.println("Teksti qe keni shenuar nuk eshte valid!Provoni perseri:");

                } else {
                    String cesarTeksti = enkriptimiMesazhit(shty, teb);
                    System.out.println("Teksti i enkriptuar: "+cesarTeksti);
                    String dekript = dekriptimiMesazhit(shty, cesarTeksti);
                    System.out.println("Teksti i dekriptuar: "+dekript);
                    bruteForce(cesarTeksti);
                    x = 2;
                }
            }
            catch(Exception e ){
                System.out.println("Teksti nuk pershtatet");
        }

        }
    }


    public static void bruteForce(String cesar) {
        String text = "";
        String c = cesar;
        char chCesar[] = c.toCharArray();
        int index = 0;
        char e;
        for (int j = 1; j < 26; j++) {
            text = "";
            for (int i = 0; i < chCesar.length; i++) {
                index = chCesar[i] - 97;

                index = (index - j + 26) % 26;
                e = (char) (index + 97);
                text += e;
            }
            System.out.println("nese k=" + j + "plain texti eshte:" + text);
        }
    }

    public static String dekriptimiMesazhit(int shtyje, String teksti) {
        if (shtyje < 0) {
            shtyje = (shtyje % 26) + 26;
        } else if (shtyje > 26) {
            shtyje = shtyje % 26;
        }
        String text = "";
        int gjatsia = teksti.length();
        for (int i = 0; i < gjatsia; i++) {
            char k = teksti.charAt(i);
            if (Character.isLetter(k)) {
                if (Character.isLowerCase(k)) {
                    char e = (char) (k - shtyje);
                    if (e < 'a') {
                        text += (char) (k - (26 - shtyje));
                    } else {
                        text += e;
                    }
                } else if (Character.isUpperCase(k)) {
                    char e = (char) (k - shtyje);
                    if (e < 'A') {
                        text += (char) (k + (26 - shtyje));
                    } else {
                        text += e;
                    }
                }
            } else {
                text += k;
            }
        }
        return text;
    }

    public static String enkriptimiMesazhit(int shtyje, String teksti) {

        if (shtyje < 0) {
            shtyje = (shtyje % 26) + 26;
        } else if (shtyje > 26) {
            shtyje = shtyje % 26;
        }
        String text = "";
        int gjatsia = teksti.length();
        for (int i = 0; i < gjatsia; i++) {
            char k = teksti.charAt(i);
            if (Character.isLetter(k)) {
                if (Character.isLowerCase(k)) {
                    char e = (char) (k + shtyje);
                    if (e > 'z') {
                        text += (char) (k - (26 - shtyje));
                    } else {
                        text += e;
                    }
                } else if (Character.isUpperCase(k)) {
                    char e = (char) (k + shtyje);
                    if (e > 'Z') {
                        text += (char) (k - (26 - shtyje));
                    } else {
                        text += e;
                    }
                }
            } else {
                text += k;
            }
        }
        return text;
    }
}

