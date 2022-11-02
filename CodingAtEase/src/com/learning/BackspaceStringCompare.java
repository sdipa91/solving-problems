package com.learning;

import java.util.Stack;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		String s= "ab#z";
		String t= "acd#z";
		boolean b = backspaceCompare(s,t);
		System.out.println(b);

	}

	private static boolean backspaceCompare(String s, String t) {
		return modifyString(s).equals(modifyString(t));
	}

	private static String modifyString(String s) {
		Stack<Character> ch = new Stack();
		for(char c : s.toCharArray()) {
			if(c != '#')
				ch.push(c);
			else if(!ch.empty())
				ch.pop();
		}
		return String.valueOf(ch);
	}

}
