import java.util.*;
import java.io.*;
import java.lang.String;


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
    static Integer spin(Integer seedling) {
	if(seedling == 0) {
	    eel = (Integer) kiwi.nextInt(characters.size());
	    if((String) characters.get(eel) != null) {clink = clink + characters.get(eel); return (Integer) indi.get(eel);}
	    return 20696;
	}
	return 20696;
    }

    static String hobnob() {
	return clink;
    }
}