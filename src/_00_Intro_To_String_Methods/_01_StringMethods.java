package _00_Intro_To_String_Methods;

import java.util.ArrayList;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
        if(s1.length() > s2.length()) {
        	return s1;
        } else if(s2.length() > s1.length()) {
        	return s2;
        } else {
    	return "equal";
        }
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
        String substring = "underscores";
        boolean occurrence = false;
        int index = s.indexOf("underscores");
        while(index != -1) {
        	index = s.indexOf(substring, index + substring.length());
        	occurrence = true;
        }
        String replaceds = s;
        if(occurrence) {
        	replaceds = s.replace(' ', '_');
        }
    	return replaceds;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
        s1.trim(); s2.trim(); s3.trim();
        String s1last = s1.substring(s1.length() - 1);
        String s2last = s2.substring(s2.length() - 1);
        String s3last = s3.substring(s3.length() - 1);
        String tarStrr = "";
        System.out.println(s1last + "" + s2last + "" + s3last);
        if(s1last.compareTo(s2last) < 0 && s1last.compareTo(s3last) < 0) {
        	System.out.println(s1last.compareTo(s2last) < 0 && s1last.compareTo(s3last) < 0);	 
        	return s1;
        } 
        if(s2last.compareTo(s1last) < 0 && s2last.compareTo(s3last) < 0) {
        	System.out.println(s2last.compareTo(s1last) < 0 && s2last.compareTo(s3last) < 0);	 
        	return s2;
        	}
         if(s3last.compareTo(s2last) < 0 && s3last.compareTo(s1last) < 0) {
        	System.out.println(s3last.compareTo(s2last) < 0 && s3last.compareTo(s1last) < 0);	
        	System.out.println("test");
        	return s3;
        }
        return null;
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	for(int i = 0; i < s.length(); i++) {
        	if(!Character.isDigit(s.charAt(i))) {
        		
        	}
        }
    	return 0;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int numOccur = 0;
    	String str = s;
    	int index = str.indexOf(substring);
    	while(index != -1) {
    		numOccur++;
    		index = str.indexOf(substring, index + substring.length());
    	}
    	return numOccur;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	byte[] bytes = s.getBytes();
    	byte byte1 = (byte) key;
    	return Utilities.encrypt(bytes, byte1);
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        byte byte2 = (byte) key;
    	return Utilities.decrypt(s, byte2);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	int subwords = 0;
        String[] words = s.split(" ");
        for(int i = 0; i < words.length; i++) {
        if(words[i].endsWith(substring)) {
        	subwords++;
        }
        }
        return subwords;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
        int numOccur = 0;
        int index2 = s.indexOf(substring);
        while(index2 != -1) {
        	numOccur++;
        	index2 = s.indexOf(substring, index2 + substring.length());
        }
    	numOccur+=2;
        int index = s.indexOf(substring);
    	System.out.println(numOccur);
        int index3 = s.indexOf(substring, index+numOccur);
        System.out.println(index);
        System.out.println(index3);
    	return index3 - index;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
        return true;
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
