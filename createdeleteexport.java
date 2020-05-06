package com.devglan.rsa;

import java.io.*;
import java.security.*;
import java.util.Scanner;

 class Rsa {

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
        f.getParentFile().mkdirs();
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
    public static void deletett(String path,String pa,String name){
        File f=new File(path);
        File d=new File(pa);
        if(f.exists()||d.exists()){
            if(f.delete()&&d.delete() ){
                System.out.println("Eshte larguar celesi privat:"+name);
                System.out.println("Eshte larguar celesi publik:"+name);
            }
            else if (d.delete()){
                System.out.println("Eshte larguar celesi privat:"+name);
            }
            else
                System.out.println("Eshte larguar celesi publik:"+name);
        }
        else {
            System.out.println("Gabim:Celesi " + name + " nuk ekziston");
            System.exit(1);
        }
    }
    public static void exportpr(String tipi,String emer,File pxml)throws IOException{
        if (tipi.equals("public") && pxml.exists()) {
            System.out.println("Shenoni filen");
            Scanner input=new Scanner(System.in);
            String emeri = input.next();
            File d = new File(emeri);
            if (!d.exists()) {
                d.mkdir();
            }
            System.out.println("u krijua");
            String a = d.getAbsolutePath();
            System.out.println(a);
            File npxml = new File(a + "\\" + emer + ".pub.xml");
            BufferedReader reader;
            PrintWriter writer;
            String line;
            if (npxml.createNewFile()) {
                reader = new BufferedReader(new FileReader(pxml));
                writer = new PrintWriter(new FileWriter(npxml));
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                }
                reader.close();
                writer.close();
            }
            System.out.println("Celesi publik u ruajt ne fajllin " + emeri);
            pxml.delete();
        } else {
            System.out.println("Gabim celesi " + emer + " nuk ekziston");
            System.exit(1);
        }
    }
    public static void export(String tipi,String emer,File xml)throws IOException{
        if (tipi.equals("private") && xml.exists()) {
            System.out.println("Shenoni filen");
            Scanner input=new Scanner(System.in);
            String emeri = input.next();
            File d = new File(emeri);
            if (!d.exists()) {
                d.mkdir();
            }
            System.out.println("u krijua");
            String a = d.getAbsolutePath();
            System.out.println(a);
            File npxml = new File(a + "\\" + emer + ".xml");
            BufferedReader reader;
            PrintWriter writer;
            String line;
            if (npxml.createNewFile()) {
                reader = new BufferedReader(new FileReader(xml));
                writer = new PrintWriter(new FileWriter(npxml));
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                }
                reader.close();
                writer.close();

            }
            System.out.println("Celesi privat u ruajt ne fajllin " + emeri);
            xml.delete();
        } else {
            System.out.println("Gabim celesi " + emer + " nuk ekziston");
            System.exit(1);
        }
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
        System.out.println("Delete-user:");
        String em=input.next();
        String pa=x+"\\"+ em + ".pub.xml\\";
        String paa=x +"\\"+ em + ".xml";
        deletett(pa,paa,em);
        System.out.println("export-keys:");
        String emerii = input.next();
        String tipi = input.next();
        File pxml = new File(x + "\\" + emerii + ".pub.xml");
        File xml = new File(x+ "\\" + emerii + ".xml");
        if(tipi.equals("public"))
            exportpr(tipi,emerii,pxml);
        else
            export(tipi,emerii,xml);
    }


}
