package com.devglan.rsa;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Rsa {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        File f=new File("keys");
        String d=f.getAbsolutePath();
        System.out.println("Delete-user:");
        Scanner input=new Scanner(System.in);
        String em=input.next();
        String pa=d+"\\"+ em + ".pub.xml\\";
        String paa=d +"\\"+ em + ".xml";
        deletett(pa,paa,em);
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
}