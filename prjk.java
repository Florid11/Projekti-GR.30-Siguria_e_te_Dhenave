import java.util.HashMap;
import java.util.Scanner;

public class prjk {
    public static void main(String[] args) {
        Kodi();
    }

    public static void Kodi(){
        HashMap<String, String>enkript=new HashMap<>();
        enkript.put("  ","  ");
        enkript.put("A","1");
        enkript.put("B","2");
        enkript.put("C","3");
        enkript.put("D","4");
        enkript.put("E","5");
        enkript.put("F","6");
        enkript.put("G","7");
        enkript.put("H","8");
        enkript.put("I","9");
        enkript.put("J","10");
        enkript.put("K","11");
        enkript.put("L","12");
        enkript.put("M","13");
        enkript.put("N","14");
        enkript.put("O","15");
        enkript.put("P","16");
        enkript.put("Q","17");
        enkript.put("R","18");
        enkript.put("S","19");
        enkript.put("T","20");
        enkript.put("U","21");
        enkript.put("V","22");
        enkript.put("X","23");
        enkript.put("Y","24");
        enkript.put("Z","25");
        Scanner input = new Scanner(System.in);
        System.out.println("Sheno tekstin:     ");
        String teksti=input.nextLine();
        System.out.println("teksti eshte:  "+teksti);
        String txt= " ";
        for(char c :teksti.toCharArray()){
        txt+=enkript.get((c+"").toUpperCase ()) +"";
        }
        System.out.print("Teksti i koduar"+txt);
        HashMap<String, String>dekript=new HashMap<>();
        dekript.put("  ","  ");
        dekript.put("1","A");
        dekript.put("2","B");
        dekript.put("3","C");
        dekript.put("4","D");
        dekript.put("5","E");
        dekript.put("6","F");
        dekript.put("7","G");
        dekript.put("8","H");
        dekript.put("9","I");
        dekript.put("10","J");
        dekript.put("11","K");
        dekript.put("12","L");
        dekript.put("13","M");
        dekript.put("14","N");
        dekript.put("15","O");
        dekript.put("16","P");
        dekript.put("17","Q");
        dekript.put("18","R");
        dekript.put("19","S");
        dekript.put("20","T");
        dekript.put("21","U");
        dekript.put("22","V");
        dekript.put("23","X");
        dekript.put("24","Y");
        dekript.put("25","Z");
        String te="";
        for(char e :txt.toCharArray()){
            te+=dekript.get((e+"").toUpperCase ()) +" ";
            System.out.print(te);
        }

    }
}
