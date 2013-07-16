import java.util.*;
import java.io.*;
import java.lang.String;
import java.lang.Integer;
import java.lang.Character;


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
    static ArrayList<Integer> whatsMyNumber = new ArrayList<Integer>();
    static FileInputStream fstream;
    static DataInputStream in;
    static BufferedReader br;
    static Enumeration e;
    static String strLine = "", wink = "", clink = "";
    static int yoyo = 0, eel = 0, bebe = 0, toto = 0, foi = 0;
    static Integer kapa = new Integer(0);
    static boolean mince = false;
    static char momo = '#';
    static void crank() {
	for(int i = 1; i < 8; i++) {
	    wink = "/Users/frozenteradactyl/Documents/Web_development/Programming/java/phone_data/" + Integer.toString(i) + ".txt";
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
    static Integer spin(int counter) {
	/** If counter were utilized it would range between 0 and one less than the cardinality of holdInputHere (i.e. replyThreshold)*/
	//*******************************
	//This function returns a random
	//character's Integer value from 
	//the respective Hashtable (indi)
	//*******************************
	foi = 0;
	foi = characters.size();
	//***************************************************************************************
	//This function creates the initial myStringInts as a random sequence of indi values
	//(contained in an ArrayList).
	//***************************************************************************************
	if(foi != 0) {
	    eel = (Integer) kiwi.nextInt(foi);
	    if((String) characters.get(eel) != null) {myStringInts.add((Integer) indi.get(eel)); return (Integer) indi.get(eel);}
	    else return null;
	}
	return null;
    }

    static void parsemSIforModifiers() {
	Integer k = 0, l = 0, m = 0;
	/**if (myStringInts.size() < 3) {
	    if (myStringInts.size() == 2) {

	    }
	    if (myStringInts.size() == 1) {
	    }
	    if (myStringInts.size() < 1) {
		return;
	    }
	}
	else {
	
	} */
    }

    //######################################################################
    //I guess I am confused about what I heard and what I really want to say
    //######################################################################

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
    static Integer getmSI(Integer fooey) throws IndexOutOfBoundsException, NullPointerException { 
	//*****************************************************
	//returns the Integer value of character at index fooey
	//or null if fooey does not index myStringInts
	//*****************************************************
	
	try {return myStringInts.get(fooey);}
	catch (IndexOutOfBoundsException e) {return null;}
	catch (NullPointerException e) {return null;}
    }
    static Integer getPhoneNumber(Integer int_val) {
	for (Object o: indi.entrySet() ) {
	    Map.Entry entry = (Map.Entry) o;
	    if (entry.getValue() == int_val) {
		return (Integer) entry.getKey();
	    }
	}
	return 0;
    }
    static String getPhoneSymbol(int int_val) {
	String ely = (String)unicode_values.get(int_val);
	//try
	//    {
	//	byte[] utf8s = ely.getBytes("UTF-16");
	//	ely = new String(utf8s, "UTF-16");
	//    } catch (UnsupportedEncodingException e)
	//    {
	//	e.printStackTrace();
	//	System.exit(-1);
	//    }
	//System.out.println("The character is: " + characters.get(int_val));
	//momo = 
	return ely;
    }
}