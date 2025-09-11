package utils;

import java.util.Random;

public class Utilities {
	
	 public static String randomEmail() {
	    
	 String chr = "abcdefghijklmnopqrstuvwxyz123456789";  
     String username = "";
     Random random = new Random();

     for (int i = 0; i < 6; i++) {
         int index = random.nextInt(chr.length()); 
         username = username + chr.charAt(index);  
     }
    return username + "@gmail.com";
	}
	
}
