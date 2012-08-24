import java.util.*;
import java.io.*;
import java.lang.String;
import java.lang.Integer;


//Phone serves as an Oracle for the 166 Unicode characters
//which comprise the International Phonetic Alphabet

public class phones {
    static Random kiwi = new Random();
    static Hashtable inde = new Hashtable(); 
    static Hashtable characters = new Hashtable(); 
    static Hashtable unicode_values = new Hashtable(); 
    static Hashtable html_values = new Hashtable(); 
    static Hashtable indi = new Hashtable(); 
    static Hashtable position = new Hashtable(); 
    static Hashtable modifies = new Hashtable(); 
    static ArrayList<Integer> myStringInts = new ArrayList<Integer>();
    static FileInputStream fstream;
    static DataInputStream in;
    static BufferedReader br;
    static Enumeration e;
    static String strLine = "", wink = "", clink = "";
    static int yoyo = 0, eel = 0, bebe = 0, toto = 0;
    static Integer kapa = new Integer(0);
    static boolean mince = false;
    static void crank() {
	for(int i = 1; i < 8; i++) {
	    wink = "phone_data/" + Integer.toString(i) + ".txt";
	    try {
		fstream = new FileInputStream(wink);
		in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		while ((strLine = br.readLine()) != null) {
		    strLine = strLine.replaceAll(" ", "");
		    if(i==1 && strLine.length() > 0) {
		        inde.put(Integer.parseInt(strLine), new Integer(Integer.parseInt(strLine)));
		    }
		    if(i==2 && strLine.length() > 0) {
			toto = toto + 1;
			characters.put(toto, strLine);
                    }
		    if(i==3 && strLine.length() > 0) {
			toto = toto + 1;
			unicode_values.put(toto, strLine);
                    }
		    if(i==4 && strLine.length() > 0) {
			toto = toto + 1;
			html_values.put(toto, strLine);
                    }
		    if(i==5 && strLine.length() > 0) {
			toto = toto + 1;
			indi.put(toto, Integer.parseInt(strLine));
                    }
		    if(i==6 && strLine.length() > 0) {
			toto = toto + 1;
			position.put(toto, strLine);
                    }
		    if(i==7 && strLine.length() > 0) {
			toto = toto + 1;
			modifies.put(toto, strLine);
                    }
		}
		in.close();
		toto = 0;
	    }
	    catch (Exception e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
    }
    static Integer spin() {
	if(characters.size() != 0) {
	    eel = (Integer) kiwi.nextInt(characters.size());
	    if((String) characters.get(eel) != null) {myStringInts.add((Integer) indi.get(eel)); return (Integer) indi.get(eel);}
	    return 20696;
	}
	return 20696;
    }

    static Integer hobnob(Integer intValue, int cici, Integer fofo) {
	String dodo = " ";
	Integer nope = 0;
	int ice = 0;
	for(int i = 1; i < indi.size(); i++) {
	    if(indi.get(i) == intValue) {
		if(modifies.get(i).equals("L") || modifies.get(i).equals("R") || modifies.get(i).equals("M")) {
		    if(cici == 1) {return 20692;}
		    if(fofo < 4 && mince == true) {mince = false; return 0;}
		    if(fofo < 4 && mince == false) {mince = true; return 32;}
		    if(i == indi.size() - 1) {return 20691;}
		    nope = getmSI(cici-1);		    
		    if(modifies.get(i).equals("L")) {
			if(!modifies.get(i-1).equals("R")) {return intValue;}
			else {return 0;}
		    }
		    if(modifies.get(i).equals("R")) {
			if(!modifies.get(i+1).equals("L")) {return intValue;}
			else {return intValue;}
		    }
		    if(modifies.get(i).equals("M")) {
			if(!modifies.get(i-1).equals("R") && !modifies.get(i+1).equals("L")) return intValue;
			else {return 0;}
		    }
		}
	    }
	}
	return intValue;
    }
    static int getmSIlen() {
	int owl = myStringInts.size();
	return owl;
    }
    static int getmodlen() {
	int scowl = modifies.size();
	return scowl;
    }
    static String getMod(Integer indexe) {
        return (String) modifies.get(indexe);
    }
    static Integer getmSI(Integer fooey) {
        return myStringInts.get(fooey);
    }
}