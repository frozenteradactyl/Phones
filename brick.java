import java.io.*;
import java.lang.String;
import java.util.Random;
import java.util.HashMap;
import java.text.DecimalFormat;

//import phonetix.src.java.com.tangentum.phonetix.*;

//package troll;

//this class will form the data structure for
//phonetic symbols to attain a free voice in
//osx
//by: john summers

public class brick {
  static String header = "********";
  static String strLine = "";
  static String baka = "";
  static String acka = "feign";
  static char[] fooburger;
  static FileInputStream fstream;
  static DataInputStream in;
  static BufferedReader br;
  static HashMap gredo = new HashMap();
  static String comente = "";
  static Soundex elf = new Soundex(true, 16);
  static int boo = 0, noo = 0;
  static Random generator = new Random();
  static Random jeri = new Random();
  static char que = 'Q';    
  static DecimalFormat df = new DecimalFormat("+00;-00");
  static Process p;
  static Process q;
  

  static void quick() {
    baka = elf.generateKey(acka);
  }

  static void print_baka(String eek) {
      baka = elf.generateKey(eek);
      System.out.println("***what you entered in Soundex***> " + baka + " <***what you entered in Soundex***");
  }

  static String baka_gen(String jaj) {
      baka = elf.generateKey(jaj);
      int toto = 0, moto = 0;
      String vee = "";
      char[] panda = new char[baka.length()];
      int[] ant = new int[baka.length()];
      //System.out.println("The smoothing values are: ");
      for (int tee = 0; tee < baka.length(); tee++) {
	ant[tee] = Character.digit(baka.charAt(tee), 10);
      }
      int coo = jeri.nextInt(ant.length);
      int doo = jeri.nextInt(gredo.size()-ant.length);
      int tiger = 0;
      System.out.println();
      for (int y = 0; y < ant.length; y++) {
	  tiger = (ant[y] <= 5) ? 2 * ant[y]:-2 * ant[y];
	  moto = coo + doo - tiger;
	  vee = vee + gredo.get(moto);
	  coo = jeri.nextInt(ant.length);
	  doo =jeri.nextInt(gredo.size()-ant.length);
	  System.out.println("---->" + df.format(tiger) + "---->" + df.format(coo) + "---->" + df.format(doo));
      }
      vee = vee.replaceAll("null", "");
      return vee;
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
      for (int k = 0; k < 43; k++) {
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

  static void get_sounds() {
    boo = generator.nextInt(gredo.size());
    comente = comente + " " + (String)gredo.get(boo);
  }
  
  static void set_comente(String fefe) {
      comente = fefe;
  }

  static void clear_screen() {
    String bon = "clear";
    try {
      //System.out.println(bon);
      q=Runtime.getRuntime().exec(bon);  
      System.out.println("In clear screen");
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
      fstream = new FileInputStream("beaker.txt");
      in = new DataInputStream(fstream);
      br = new BufferedReader(new InputStreamReader(in));
      while ((strLine = br.readLine()) != null) {
	System.out.println (strLine);
      }
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