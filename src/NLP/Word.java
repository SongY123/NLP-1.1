package NLP;
public class Word {
	public String content;
	//A word may have multiple nominals and explains
	public String []nominal;
	public String []explain;

	public void print(){
		System.out.println(content);
		for(int i = 0;i<nominal.length;i++)
			System.out.println(nominal[i]+"   "+explain[i]);
	}
}
