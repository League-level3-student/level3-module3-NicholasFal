package _02_The_Wave;

import java.util.ArrayList;

public class _01_TheWave {
    /*
     * Background:
     * https://en.wikipedia.org/wiki/Wave_%28audience%29 
     * 
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    
    public static ArrayList<String> wave(String str) {
       ArrayList<String> strings = new ArrayList<String>();
    	for(int i = 0; i < str.length(); i++) {
    	   String Str2 = str;
    		if(Str2.substring(i, i+1).equalsIgnoreCase(" ")) {
    		   continue;
    	   } else {
    		   Str2 = Str2.substring(0, i) + Str2.substring(i, i+1).toUpperCase() + Str2.substring(i+1, str.length());
    		   strings.add(Str2);
    	   }
       }
    	System.out.println(strings);
        return strings;
    }
}
