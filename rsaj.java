package com.devglan.rsa;

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
        if (f.isFile()){
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

        Scanner input = new Scanner(System.in);
        System.out.println("Create-user:");
        String emer = input.next();
        try {

            Rsa keyPairGenerator = new Rsa();
            keyPairGenerator.shkruajFile("C:\\Users\\PC\\Desktop\\celesat\\" + emer + ".pub.xml\\", keyPairGenerator.getPublicKey().getEncoded(),emer);
            keyPairGenerator.shkruajFile("C:\\Users\\PC\\Desktop\\celesat\\" + emer + ".xml", keyPairGenerator.getPrivateKey().getEncoded(),emer);
            System.out.println("Eshte krijuar celesi privat:celesat/" + emer + ".xml");
            System.out.println("Eshte krijuar celesi publik:celesat/" + emer + ".pub.xml");
        } catch(Exception e) {
            System.out.println("gabim");
        }
    }
}