package com.learning;

public class BackspaceStringCompareOptimized {

	public static void main(String[] args) {
		String s= "ab#c";
		String t= "ad#c";
		BackspaceStringCompareOptimized v = new BackspaceStringCompareOptimized();
		System.out.println(v.backspaceString(s, t));
	}
	public boolean backspaceString(String s, String t) {
		int p1=s.length()-1;
		int p2=t.length()-1;
		int skipS=0;
		int skipT=0;
		System.out.println(s.charAt(p1));
		while(p1 >= 0 || p2>=0) {// While there may be chars in build(S) or build (T)
			while(p1>=0) {// Find position of next possible char in build(S)
				if(s.charAt(p1) == '#') {
					skipS+=1;
					p1--;
				} else if(skipS > 0) {
					skipS--;
					p1--;
				}else
					break;
			}
			while(p2>=0) {// Find position of next possible char in build(T)
				if(t.charAt(p2) == '#') {
					skipT++;
					p2--;
				} else if(skipT > 0) {
					skipT--;
					p2--;
				} else break;
			}
			 // If two actual characters are different
			if(p1>=0 && p2>=0 && s.charAt(p1) != t.charAt(p2))
				return false;
			// If expecting to compare char vs nothing
			 if ((p1 >= 0) != (p2 >= 0))
	                return false;
			p1--;
			p2--;
			
		}
		
		return true;
		
	}

}
