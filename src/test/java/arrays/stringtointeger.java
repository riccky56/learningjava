package arrays;

import java.util.Arrays;

public class stringtointeger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String s ="1234";
 int result =0;
     for(char c : s.toCharArray()) {
	int digit = c - '0';
	 result = result * 10 + digit;
     }
    
System.out.println(Arrays.toString(result));
}
}