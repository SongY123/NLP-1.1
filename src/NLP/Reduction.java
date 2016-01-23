package NLP;

import java.util.ArrayList;

public class Reduction {
	//*s -> * (SINGULAR3)
	private String SINGULAR3s(String w){
		if(w.length()>=2&&w.charAt(w.length()-1)=='s')return w.substring(0,w.length()-1);
		else return null;
	}
	
	//*es -> * (SINGULAR3)
	private String SINGULAR3es(String w){
		if(w.length()>=3&&w.charAt(w.length()-2)=='e'&&w.charAt(w.length()-1)=='s')
			return w.substring(0,w.length()-2);
		else return null;
	}
	
	//*ies -> *y (SINGULAR3)
	private String SINGULAR3ies(String w){
		if(w.length()>=4&&w.charAt(w.length()-3)=='i'&&w.charAt(w.length()-2)=='e'&&w.charAt(w.length()-1)=='s')
			return w.substring(0,w.length()-3);
		else return null;
	}
	
	//*ing -> * (VING)
	private String VINGing(String w){
		if(w.length()>=4&&w.charAt(w.length()-3)=='i'&&w.charAt(w.length()-2)=='n'&&w.charAt(w.length()-1)=='g')
			return w.substring(0,w.length()-3);
		else return null;
	}
	
	//*ing -> *e (VING)
	private String VINGing_e(String w){
		if(w.length()>=4&&w.charAt(w.length()-3)=='i'&&w.charAt(w.length()-2)=='n'&&w.charAt(w.length()-1)=='g')
			return w.substring(0,w.length()-3)+'e';
		else return null;
	}
	
	//*ying -> *ie (VING)
	private String VINGing_ie(String w){
		if(w.length()>=5&&w.charAt(w.length()-4)=='y'&&w.charAt(w.length()-3)=='i'&&w.charAt(w.length()-2)=='n'&&w.charAt(w.length()-1)=='g')
			return w.substring(0,w.length()-4)+"ie";
		else return null;
	}
	
	//*??ing -> *? (VING)
	private String VINGing_(String w){
		if(w.length()>=6&&w.charAt(w.length()-5)==w.charAt(w.length()-4)&&w.charAt(w.length()-3)=='i'&&w.charAt(w.length()-2)=='n'&&w.charAt(w.length()-1)=='g')
			return w.substring(0,w.length()-4);
		else return null;
	}
	
	//*ed -> * (PAST)(VEN)
	private String PASTVENed(String w){
		if(w.length()>=3&&w.charAt(w.length()-2)=='e'&&w.charAt(w.length()-1)=='d')
			return w.substring(0,w.length()-2);
		else return null;
	}
	
	//*ed -> *e (PAST)(VEN)
	private String PASTVENed_e(String w){
		if(w.length()>=3&&w.charAt(w.length()-2)=='e'&&w.charAt(w.length()-1)=='d')
			return w.substring(0,w.length()-2)+'e';
		else return null;
	}
	
	//*ied -> *y (PAST)(VEN)
	private String PASTVENied_y(String w){
		if(w.length()>=4&&w.charAt(w.length()-3)=='i'&&w.charAt(w.length()-2)=='e'&&w.charAt(w.length()-1)=='d')
			return w.substring(0,w.length()-3)+'y';
		else return null;
	}
	
	//*??ed -> *? (PAST)(VEN)
	private String PASTVENed_(String w){
		if(w.length()>=5&&w.charAt(w.length()-4)==w.charAt(w.length()-3)&&w.charAt(w.length()-2)=='e'&&w.charAt(w.length()-1)=='d')
			return w.substring(0,w.length()-3);
		else return null;
	}
	
	//went -> go (PAST)
	private String PASTwent_go(String w){
		if(w.compareTo("went")==0)return "go";
		else return null;
	}
	
	//gone -> go (VEN)
	private String VENgone_go(String w){
		if(w.compareTo("gone")==0)return "go";
		else return null;
	}
	
	//sat -> sit (PAST) (VEN)
	private String PASTVENsat_sit(String w){
		if(w.compareTo("sat")==0)return "sit";
		else return null;
	}

	public ArrayList<String> getAllReductionWord(String w){
		ArrayList<String>result = new ArrayList<String>();
		if(SINGULAR3s(w)!=null)result.add(SINGULAR3s(w));
		if(SINGULAR3es(w)!=null)result.add(SINGULAR3es(w));
		if(SINGULAR3ies(w)!=null)result.add(SINGULAR3ies(w));
		if(VINGing(w)!=null)result.add(VINGing(w));
		if(VINGing_e(w)!=null)result.add(VINGing_e(w));
		if(VINGing_ie(w)!=null)result.add(VINGing_ie(w));
		if(VINGing_(w)!=null)result.add(VINGing_(w));
		if(PASTVENed(w)!=null)result.add(PASTVENed(w));
		if(PASTVENed_e(w)!=null)result.add(PASTVENed_e(w));
		if(PASTVENied_y(w)!=null)result.add(PASTVENied_y(w));
		if(PASTVENed_(w)!=null)result.add(PASTVENed_(w));
		if(PASTwent_go(w)!=null)result.add(PASTwent_go(w));
		if(VENgone_go(w)!=null)result.add(VENgone_go(w));
		if(PASTVENsat_sit(w)!=null)result.add(PASTVENsat_sit(w));
		return result;
	}
}
