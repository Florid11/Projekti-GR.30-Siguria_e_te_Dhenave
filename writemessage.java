package WriteMessage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class writemessage {
		public void base64(String emeri) throws UnsupportedEncodingException{
		        String TekstiEnkoduar= Base64.getEncoder().encodeToString(emeri.getBytes("UTF-8"));
		        System.out.println(TekstiEnkoduar);
					}
		public void iv() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
	    	KeyGenerator k = KeyGenerator.getInstance("DES");
	    	SecretKey sk = k.generateKey();
			SecureRandom sr = new SecureRandom();
			byte[] Iv = new byte[8];
			sr.nextBytes(Iv);
			IvParameterSpec IV = new IvParameterSpec(Iv);
			Cipher c = Cipher.getInstance("DES/CBC/NoPadding");
			c.init(Cipher.ENCRYPT_MODE,sk, IV);
			byte[] Encrypted = c.doFinal(Iv);
	    	String b64Des = Base64.getEncoder().encodeToString(Encrypted);
	    	System.out.println(Encrypted);
		}
	    private PublicKey publicKey;
	    public void Rsa() throws NoSuchAlgorithmException, IOException {
	    	  KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
	          key.initialize(1024);
	          KeyPair pair = key.generateKeyPair();
	          this.publicKey = pair.getPublic();
	          byte[] encodedPublicKey = publicKey.getEncoded();
	          String b64PublicKey = Base64.getEncoder().encodeToString(encodedPublicKey);
	          System.out.println("Ky eshte b64Publickey: " + b64PublicKey);
	    }
	    public PublicKey getPublicKey() {
	        return publicKey;
	    }
	    
	    public void Des(String m) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
	    	KeyGenerator k = KeyGenerator.getInstance("DES");
	    	SecretKey sk = k.generateKey();
	    	Cipher c = Cipher.getInstance("DES/ECB/PKCS5Padding");
	    	c.init(Cipher.ENCRYPT_MODE, sk);
	    	byte[] text = m.getBytes();
	    	byte[] textEncrypted = c.doFinal(text);
	    	String b64Des = Base64.getEncoder().encodeToString(textEncrypted);

	    }
	    public static void Save_Report(String file,String celesi) throws IOException {
	    	File f = new File(file);
	    	f.getParentFile().mkdirs();
	        BufferedWriter wr = new BufferedWriter(new FileWriter(f));
	        wr.write("Florid");
	        wr.write("Florian");
	        wr.write("Arbnor");
	        wr.write("Blerim");
	        wr.close();
		    	if(!f.exists())
		    	{
		    		System.out.println("Gabim: Celesi publik "+celesi+" nuk ekziston");
		            System.exit(1);
	
		    	}
		        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		        writer.write(celesi);
		        writer.close();
	    }
	    
	public static void main(String[] args) {
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
	        System.out.print("Emeri:");
	        String Emeri = input.next();
	        System.out.print("Mesazhi:");
	        String Message = input.next();
	        System.out.println("write-message "+Emeri+" \""+ Message+"\" \'ciphertext.txt\'");
		try {
writemessage w= new writemessage();
w.Save_Report(x+Emeri,Emeri);
w.Save_Report(x+"\\"+Message+"ciphertext.txt",Message);
w.base64(Emeri);
w.iv();
w.Rsa();
w.Des(Message);
System.out.println("Mesazhi i enkriputar u ruajt ne fajlin 'chihertext.txt'");

		} catch (Exception e) {
	        e.printStackTrace();
		}
	}
}