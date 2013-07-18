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
    static ArrayList<Integer> myStringIntsMod = new ArrayList<Integer>();
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
	Integer k = 0, l = 0, m = 1, n = 2;
	String catcher = "", matcher = "";
	l = myStringInts.size();
	if (l == 0) return;
	if (l == 1) {catcher = (String) modifies.get(getPhoneNumber(myStringInts.get(k)));
	    if(catcher.equals("null")) {insert_into_myStringIntsMod(myStringInts.get(k));}
	}
	if (l == 2) {function_alpha(myStringInts.get(k), myStringInts.get(m)); function_phi(myStringInts.get(k), myStringInts.get(m));}
	if (l >= 3) {
	    function_alpha(myStringInts.get(k), myStringInts.get(m));
	    for (; k < l-2; k++) {
		function_beta(myStringInts.get(k), myStringInts.get(k+1), myStringInts.get(k+2));
	    }
	    function_phi(myStringInts.get(k), myStringInts.get(k+1));
	}
    }

    static void function_phi(Integer eel, Integer feel) {
	String catcher = (String) modifies.get(getPhoneNumber(eel));
        String matcher = (String) modifies.get(getPhoneNumber(feel));
	//System.out.println("** " + "catcher is " + catcher + " and matcher is " + matcher); 
	//System.out.println("** " + "first boolean is " + (matcher.equals("R") && catcher.equals("null")));
	//System.out.println("** " + "second boolean is " + (matcher.equals("null")));
	if(matcher.equals("R") && catcher.equals("null")) insert_into_myStringIntsMod(feel);
	if(matcher.equals("null")) insert_into_myStringIntsMod(feel);
    }

    static void function_beta(Integer eel, Integer feel, Integer teal) {
	String catcher = (String) modifies.get(getPhoneNumber(eel));
        String matcher = (String) modifies.get(getPhoneNumber(feel));
	String hatcher = (String) modifies.get(getPhoneNumber(teal));
	if(matcher.equals("L") && hatcher.equals("null")) insert_into_myStringIntsMod(feel);
	if(matcher.equals("R") && catcher.equals("null")) insert_into_myStringIntsMod(feel);
	if(matcher.equals("M") && catcher.equals("null") && hatcher.equals("null")) insert_into_myStringIntsMod(feel);
	if(matcher.equals("null")) insert_into_myStringIntsMod(feel);
    }

    static void function_alpha(Integer eel, Integer feel) {
	String catcher = (String) modifies.get(getPhoneNumber(eel));                                                                               
	String matcher = (String) modifies.get(getPhoneNumber(feel));
	//System.out.println("*** " + Integer.toString(getPhoneNumber(eel)));
	//System.out.println("catcher is " + catcher + " matcher is " + matcher + ", first boolean is " + Boolean.toString(catcher.equals("L") && matcher.equals("null")) + ",");
	//System.out.println("& second boolean is " + Boolean.toString(catcher.equals("null")));
	if(catcher.equals("L") && matcher.equals("null")) {insert_into_myStringIntsMod(eel);}
	if(catcher.equals("null")) {insert_into_myStringIntsMod(eel);}
    }
    
    static void insert_into_myStringIntsMod(Integer eel) {
	//System.out.println("Inserting into myStringIntsMod");
	myStringIntsMod.add(eel);
    }

    static Integer get_from_myStringIntsMod(Integer eel) {
	return myStringIntsMod.get(eel);
    }

    static Integer getmSIModlen() {
	return myStringIntsMod.size();
    }

    static int getmSIlen() {
	int owl = myStringInts.size();
	return owl;
    }
    static int getModLen() {
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
	int i = 0;
	for (Object o: indi.entrySet()) {
	    i = i + 1;
	    Map.Entry entry = (Map.Entry) o;
	    //System.out.println("this is the value of the entry in indi " + entry.getValue() + " and it is class type " + entry.getClass().getName());
	    if (entry.getValue().equals(int_val)) {
		//System.out.println("found entry " + int_val + " in indi at index " + i);
		return (Integer) entry.getKey();
	    }
	}
	//System.out.println("Did not find " + int_val + " in indi and indi contains " + i + " elements");
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