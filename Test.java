import java.io.*;
import java.lang.String;
import java.lang.Character;
import java.util.Formatter;
import javax.swing.JOptionPane;
import java.util.Random;

//package troll;
//**juiced Soundex
//English text to IPA character translator
//by: john summers

public class Test extends brick {
  public static void main (String[] argv) throws UnsupportedEncodingException {
    Object[] options = {"Test me again?", "Done testing for now"};
    crank();
    int count = 0, macy = 1, ggtracy = 0, n = 0;
    String unicodeMessage = "";
    PrintStream out = new PrintStream(System.out, true, "UTF-8");
    phones coolio = new phones();
    Integer code = 0;
    char ch = 'a';
    Random jenny = new Random();
    ibby_brick(95);
    set_sound();
    quick();
    String ANSI_CLEAR_SEQ = "\u001b[2J";  
    System.out.println(ANSI_CLEAR_SEQ);
    String holdInputHere = "";
    while (n == 0) {
	count = 0;
	macy = 1;
	ggtracy = 0; 
	n = 0;
	holdInputHere = JOptionPane.showInputDialog(null, "So, what do you have to say for yourself?");
	if(holdInputHere.length() == 0) {holdInputHere = "I have nothing to say for myself at this moment";}
	for (int foo = 0x0250; foo <= 0x02AE; foo++) {
	    unicodeMessage = String.format("\\u%04x", foo);
	    code = Integer.parseInt(unicodeMessage.substring(2), 16);
	    ch = Character.toChars(code)[0];
	    //out.println("character: " + ch + " " + "unicodeMessage: " + unicodeMessage + " " + "code: " + code);
	    put_fooburger(count, ch);
	    macy++;
	    get_sounds();
	    count++;
	}
	
	unicodeMessage = String.format("\\u%04x", 0x50D8 );
	code = Integer.parseInt(unicodeMessage.substring(2), 16);

	//this is the insertion point for the set of Phones
	//use Integer from spreadsheet

	ch = Character.toChars(code)[0];
	//out.println();
	//out.println("character: " + ch + " " + "unicodeMessage: " + unicodeMessage + " " + "code: " + code);
	String toot = baka_gen(holdInputHere);
	set_comente(toot);
	say_phon();
	out.println("***>> " + toot + " <<***");
	coolio.crank();
	Integer beak = 0, creak = 0;
	for(int fii = 0; fii <= count; fii++) {
            beak = jenny.nextInt(5);
	    creak = coolio.spin(0);
	    if(creak != null) {
		ch = Character.toChars(creak)[0];
		out.print(ch);
	    }
	    if (creak != null && beak == 2) {out.print(" ");}
        }
	//out.println("***>" + coolio.hobnob() + "<***");
	out.println("");
	n = JOptionPane.showOptionDialog(null,"Test again?", "A good question",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
    }
  }
}