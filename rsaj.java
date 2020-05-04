
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.Scanner;

public class Rsa {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public Rsa() throws NoSuchAlgorithmException {
        KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
        key.initialize(1024);
        KeyPair pair = key.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public void shkruajFile(String path, byte[] key,String cel) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();
        if (f.exists()){
            System.out.println("Gabim: Celesi "+cel+" ekziston paraprakisht");
            System.exit(1);
        }
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(key);
        fos.flush();
        fos.close();


    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        File f = new File("keys");
        try {
            if (!f.exists()) {
                if (f.mkdir()) {
                    System.out.println("File eshte krijuar");
                } else {
                    System.out.println("File nuk mund te krijohet");
                }
            } else {
                System.out.println("File ekziston");

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String x=f.getAbsolutePath();
        System.out.println(x);
        Scanner input = new Scanner(System.in);
        System.out.println("Create-user:");
        String emer = input.next();
        try {

            Rsa keyPairGenerator = new Rsa();
            keyPairGenerator.shkruajFile(x+"\\"+ emer + ".pub.xml\\", keyPairGenerator.getPublicKey().getEncoded(),emer);
            keyPairGenerator.shkruajFile(x +"\\"+ emer + ".xml", keyPairGenerator.getPrivateKey().getEncoded(),emer);
            System.out.println("Eshte krijuar celesi privat:keys/" + emer + ".xml");
            System.out.println("Eshte krijuar celesi publik:keys/" + emer + ".pub.xml");

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
