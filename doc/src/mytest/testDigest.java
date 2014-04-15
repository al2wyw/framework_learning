package mytest;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.security.cert.X509Certificate;
public class testDigest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {             
            String username = "Vicky";  
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");  
            messageDigest.update(username.getBytes());  
            String usernameMD5 = messageDigest.digest().toString();  
            
            System.out.println(messageDigest.digest().length);
            System.out.println(usernameMD5);
            
            KeyStore ks=KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream fin;
            try{
            	fin=new FileInputStream("mykey");
            }catch(Exception e){
            	return;
            }
            String p="al2wyw";
            char[] pass=p.toCharArray();
            ks.load(fin,pass);
            KeyStore.PrivateKeyEntry pk=(KeyStore.PrivateKeyEntry)ks.getEntry("test", new KeyStore.PasswordProtection(pass));
            X509Certificate cer=(X509Certificate)pk.getCertificate();
            SimpleDateFormat df=new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
            
            System.out.println(df.format(cer.getNotBefore())+" "+df.format(cer.getNotAfter()));
        } catch (Exception e) {  
            e.printStackTrace();  
        }  

	}

}
