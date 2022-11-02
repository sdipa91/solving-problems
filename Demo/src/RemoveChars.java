import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class RemoveChars {
	public static void main(String[] args) throws IOException {
	    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line=in.readLine();
	    String sub=line.substring(0,line.indexOf(",")).trim();
	    String rmc=line.substring(line.indexOf(",")+1).trim();
	    
	    System.out.println(sub);
	    System.out.println(rmc);
	  // StringBuilder s= new StringBuilder(sub);
		/*
		 * for (int i=0; i< s.length(); i++){ if(sub.charAt(i)!= ' '){
		 * if(rmc.indexOf(sub.charAt(i))> 0){ s.deleteCharAt(i); } } }
		 */
	    
	    //System.out.println(s.toString());
	    //char[] c= new char[sub.length()];
	    int k=0, count=0;
	    char[] c= sub.toCharArray();
	    //for(int i=0; i< rmc.length(); i++) {
	    	for(int j= k=0; j< sub.length(); j++) {
	    		if(rmc.indexOf(sub.charAt(j)) == -1 ) {
	    			c[k++]= sub.charAt(j);
	    		} else {
	    			count++;
	    		}
	    			
	    	}
	    	
	   // }
	    
	    while(count>0) {
	    	c[k++]='\0';
	    	count--;
	    }
	    
	    System.out.println(c);
	    
	  }
}
