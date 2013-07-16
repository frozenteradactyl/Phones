import java.io.*;
import java.lang.String;
import java.util.*;
//import java.util.Random;
//import java.util.HashMap;
import java.text.DecimalFormat;
import java.lang.Integer;


//import phonetix.src.java.com.tangentum.phonetix.*;

//package troll;

//this class will form the data structure for
//phonetic symbols to attain a free voice in
//osx
//by: john summers, MS

public class brick {
  static String header = "********";
  static String strLine = "", vee = "";
  static String baka = "";
  static String acka = "feign";
  static char[] fooburger;
  static FileInputStream fstream;
  static DataInputStream in;
  static BufferedReader br;
  static HashMap gredo = new HashMap();
  static ArrayList<Integer> Three = new ArrayList<Integer>();
  static ArrayList<Integer> Little = new ArrayList<Integer>();
  static ArrayList<Integer> Pigs = new ArrayList<Integer>();
  static ArrayList<Integer> three = new ArrayList<Integer>();
  static ArrayList<Integer> little = new ArrayList<Integer>();
  static ArrayList<Integer> pigs = new ArrayList<Integer>();
  static String comente = "";
  static Soundex elf = new Soundex(true, 16);
  static int boo = 0, noo = 0, toto = 0, moto = 0, tiger = 0;
  static Random generator = new Random();
  static Random jeri = new Random();
  static char que = 'Q';    
  static DecimalFormat df = new DecimalFormat("+00;-00");
  static Process p;
  static Process q;
  

  static void quick() {
    baka = elf.generateKey(acka);
  }

  static String print_baka(String eek) {
      baka = elf.generateKey(eek);
      return baka;
  }

  static String baka_gen(String jaj) {
      baka = ""; 
      vee = "";
      toto = 0;
      moto = 0;
      //**************************************
      //this generates the Soundex code of jaj
      //**************************************
      baka = elf.generateKey(jaj);
      char[] panda = new char[baka.length()];
      int[] ant = new int[baka.length()];
      //****************************************
      //ant is an integer array containing the
      //digits of Soundex codes (one digit each)
      //contained in baka above
      //****************************************
      for (int tee = 0; tee < baka.length(); tee++) {
	  ant[tee] = Character.digit(baka.charAt(tee), /** radix */10);
      }
      //*************************************************************************
      //coo will hold a bit of the future - a random pick of the Soundex sequence
      //index
      //*************************************************************************
      int coo = 0;
      //***********************************************************************
      //gredo contains the fundamental sounds of English in no particular order
      //***********************************************************************
      //doo functions to help determine everything that surmounts what is worth
      //saying (for the moment) "conditioned randomness on top of randomness"
      //as with coo, selects the index
      //***********************************************************************
      int doo = 0;
      tiger = 0;
      System.out.println("******ArrayList[s]******");
      System.out.println("**Three, Little & Pigs**");
      System.out.println("****tiger***coo*****doo*");
      for (int y = 0; y < ant.length; y++) {
	  moto = 0; coo = 0; doo = 0;
	  coo = jeri.nextInt(ant.length);
	  doo = jeri.nextInt(gredo.size());
	  //************************************************************************************
	  //this is more randomness, used to derive the English phonetic approximation to select
	  //************************************************************************************
	  tiger = ant[y];
	  moto = coo + doo - tiger;
	  vee = vee + gredo.get(moto);
	  //*************************************
	  //These values are saved in six Integer
	  //ArrayList[s]. These values are used
	  //to condition and calculate the next
	  //phonetic symbol in the response
	  //*************************************
	  Three.add((Integer) tiger);
	  Little.add((Integer) coo);
	  Pigs.add((Integer) doo);
	  System.out.println("---->" + df.format(tiger) + "---->" + df.format(coo) + "---->" + df.format(doo));
      }
      System.out.println("");
      //******************************************
      //as soon as y hits the number of elements
      //in Three (same for Little & Pigs) this
      //for loop is over (good because if one were
      //to get it would be using the classic Obiwan
      //index). Adds the derived tiger,
      //coo and doo variables to match the same
      //sort of Integers collected above in Three,
      //Little and Pigs
      //******************************************
      System.out.println("******ArrayList[s]******");
      System.out.println("**three, little & pigs**");
      System.out.println("****tiger***coo*****doo*");
      for (int y = 0; y < Three.size(); y++) {
	  tiger = 0;
	  coo = 0;
	  doo = 0;
	  tiger = get_Three(true); three.add((Integer) tiger);
	  coo = get_Little(true); little.add((Integer) coo);
	  doo = get_Pigs(true); pigs.add((Integer) doo);
	  System.out.println("*--->" + df.format(tiger) + "*--->" + df.format(coo) + "*--->" + df.format(doo));
      }
      System.out.println("");
      vee = vee.replaceAll("null", "");
      //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      //vee contains a phonemic string
      //as a String
      //something like "thuhllluuhhahuhahyurhsuhuhfhuhhphehhhghuhtheheehhuhtheheehhuhahypheh"
      //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
      return vee;
  }
    //**********************************************************
    //After some searching Java class definitions, it looks like
    //.get(int) has an int between 0 and list_size - 1 (Obiwan).
    //nextInt(int) returns a value between 0 (inclusive) and int
    //(exclusive). So the gets end up with what is needed to
    //access each of the elements of these ArrayList[s]. size()
    //returns the number of Integers in the ArrayList.
    //**********************************************************

  static Integer get_Three(Boolean mio) {
      if (mio == true) return Three.get(generator.nextInt(Three.size()));      
      if (mio == false) return three.get(generator.nextInt(three.size()));
      return null;
  }
  static Integer get_Little(Boolean kio) {
      if (kio == true) return Little.get(generator.nextInt(Little.size()));
      if (kio == false) return little.get(generator.nextInt(little.size()));
      return null;
  }
  static Integer get_Pigs(Boolean tio) {
      if (tio == true) return Pigs.get(generator.nextInt(Pigs.size()));
      if (tio == false) return pigs.get(generator.nextInt(pigs.size()));
      return null;
  }
  static String get_header() {
    return header;
  }
  static char get_char(int ind) {
    if (ind > 0) {noo = generator.nextInt(ind);}
    else {noo = 0;}
    return fooburger[noo];
  }
  static void set_sound() {
      for (int k = 1; k < 44; k++) {
        if (k == 1) {gredo.put(k, "uh");}
        if (k == 2) {gredo.put(k, "ah");}
        if (k == 3) {gredo.put(k, "aheh");}
        if (k == 4) {gredo.put(k, "eh");}
        if (k == 5) {gredo.put(k, "uheh");}
        if (k == 6) {gredo.put(k, "urh");}     
        if (k == 7) {gredo.put(k, "ihuh");}
        if (k == 8) {gredo.put(k, "eehh");}    
        if (k == 9) {gredo.put(k, "ahuh");}
        if (k == 10) {gredo.put(k, "ahh");}      
        if (k == 11) {gredo.put(k, "uhh");}
        if (k == 12) {gredo.put(k, "oohh");}
        if (k == 13) {gredo.put(k, "ihh");}
        if (k == 14) {gredo.put(k, "owh");}
        if (k == 15) {gredo.put(k, "ahy");}
        if (k == 16) {gredo.put(k, "ohh");}
        if (k == 17) {gredo.put(k, "oi");}
        if (k == 18) {gredo.put(k, "erhh");}
        if (k == 19) {gredo.put(k, "ear");}
        if (k == 20) {gredo.put(k, "oorh");}
        if (k == 21) {gredo.put(k, "bhhuh");}
        if (k == 22) {gredo.put(k, "dihhuh");}
        if (k == 23) {gredo.put(k, "fhuhh");}
        if (k == 24) {gredo.put(k, "gihuh");}
        if (k == 25) {gredo.put(k, "huhh");}
        if (k == 26) {gredo.put(k, "yuhh");}
        if (k == 27) {gredo.put(k, "ckuhuh");}
        if (k == 28) {gredo.put(k, "llluuhh");}
        if (k == 29) {gredo.put(k, "mmhh");}
        if (k == 30) {gredo.put(k, "hhhhuh");}
        if (k == 31) {gredo.put(k, "hhghuh");}
        if (k == 32) {gredo.put(k, "pheh");}
        if (k == 33) {gredo.put(k, "rreh");}
        if (k == 34) {gredo.put(k, "suhuh");}
        if (k == 35) {gredo.put(k, "shuh");}
        if (k == 36) {gredo.put(k, "thuh");}
        if (k == 37) {gredo.put(k, "cheh");}
        if (k == 38) {gredo.put(k, "theheehhuh");}
        if (k == 39) {gredo.put(k, "thuhh");}
        if (k == 40) {gredo.put(k, "vvvhhuh");}
        if (k == 41) {gredo.put(k, "zzhuh");}
        if (k == 42) {gredo.put(k, "zzzhuh");}
        if (k == 43) {gredo.put(k, "ghuh");}
      }
    String oui = "";
  }

  static String get_comente() {
    return comente;
  }

  static int get_sounds() {
    boo = generator.nextInt(gredo.size());
    comente = comente + " " + (String)gredo.get(boo);
    return boo;
  }
  
  static void set_comente(String fefe) {
      comente = fefe;
  }

  static void clear_screen() {
    String bon = "clear";
    try {
      //System.out.println(bon);
      q=Runtime.getRuntime().exec(bon);  
      //System.out.println("In clear screen");
    }
    catch(IOException q) {}
  }

  static void say_phon() {
      String kee = "say -v Victoria " + comente;
    try {
      p=Runtime.getRuntime().exec(kee);
    }
    catch(IOException p) {}
  }

  static void ibby_brick(int i) {
    fooburger = new char[i];
    set_sound();
  }

  static void put_fooburger(int k, char kk) {
    fooburger[k] = kk;
  }

  static void crank() {
    try {
      fstream = new FileInputStream("/Users/frozenteradactyl/Documents/Web_development/Programming/java/beaker.txt");
      in = new DataInputStream(fstream);
      br = new BufferedReader(new InputStreamReader(in));
      while ((strLine = br.readLine()) != null) {
	  System.out.println (strLine);
      }
      System.out.println("");
      in.close();
    }
    catch (Exception e) {
	System.err.println("Error: " + e.getMessage());
    }
  }
  private static String make_phone(String r) {
  //takes String and makes String of phonetic symbols
  //corresponding to specific character sequences
  //having minimum length of one
  return r;
  }
}