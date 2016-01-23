package NLP;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
public static void main(String []args){
	Dictionary dict = new Dictionary("src//dic_ec.txt");
	while(true){
		System.out.println("Please input a word:");
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		Word result = dict.findWord(word);
		if(result != null)
			result.print();
		else{
			result = dict.findCandidateWord(word);
			if(result==null){
				System.out.println("Cannot find the word and the candidate words,exit.");
				break;
			}
			else result.print();
		}
		System.out.println("");
	}
	
}
}
