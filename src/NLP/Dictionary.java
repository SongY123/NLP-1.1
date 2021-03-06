package NLP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dictionary {
	private ArrayList<Word> dictionary = new ArrayList<>();
	
	public Dictionary(){
		
	}
	
	public Dictionary(String filePath){
		File f = new File(filePath);
		try {
			InputStreamReader r = new InputStreamReader(new FileInputStream(f),"UTF-8");
			BufferedReader br = new BufferedReader(r);
			String line = null;
			while((line = br.readLine())!=null){
				String []result = line.split("[a-zA-Z]*\\.");
				String word = result[0];
				Pattern p = Pattern.compile("[a-zA-Z]*\\.");
				Matcher mat = p.matcher(line);
				ArrayList<String> nominal = new ArrayList<String>();
				while(mat.find()){
					nominal.add(mat.group(0));
				}
				Word w = new Word();
				w.content = word.trim();
				char useless = 65279;
				while(w.content.startsWith("")||w.content.startsWith(useless+""))
					w.content = w.content.substring(1,w.content.length()).trim();
				while(w.content.endsWith("")||w.content.endsWith(useless+""))
					w.content = w.content.substring(0,w.content.length()-1).trim();
				/*for(int i = 0;i<w.content.length();i++)
					System.out.println((int)w.content.charAt(i));
				*/
				w.nominal = new String[nominal.size()];
				for(int i = 0;i<nominal.size();i++)
					w.nominal[i] = nominal.get(i).trim();
				w.explain = new String[result.length-1];
				for(int i = 0;i<result.length-1;i++)
					w.explain[i] = result[i+1].trim();
				dictionary.add(w);
				//w.print();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public Word findWord(String w){
		Word result = null;
		for(int i = 0;i<dictionary.size();i++)
		{
			if((dictionary.get(i).content.compareTo(w.trim()))==0){
				result = dictionary.get(i);
				break;
			}
		}
		return result;
	}
	
	public Word findCandidateWord(String w){
		ArrayList<String>result = new Reduction().getAllReductionWord(w);
		Word word = null;
		for(int i = 0;i<result.size();i++)
			if((word = findWord(result.get(i)))!=null)return word;
		return word;
	}
}
