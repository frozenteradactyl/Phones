import java.io.*;
import java.lang.String;
import java.lang.Character;
import java.util.Formatter;
import javax.swing.JOptionPane;
import java.util.Random;
import java.lang.Integer;
import java.text.DecimalFormat;


//package troll;
//**juiced Soundex
//English text to IPA character translator
//by: john summers

public class Test extends brick {
  public static void main (String[] argv) throws UnsupportedEncodingException {
    Object[] options = {"Test me again?", "Done testing for now"};
    crank();
    int count = 0, macy = 1, ggtracy = 0, n = 0, sound_index = 0, taste = 0, pop = 0, mop = 0;
    String unicodeMessage = "", jumper = "", thumper = "", trumper = "";
    PrintStream out = new PrintStream(System.out, true, "UTF-8");
    phones coolio = new phones();
    Integer code = 0;
    char ch = 'a';
    Random jenny = new Random();
    ibby_brick(95);
    set_sound();
    quick();
    String ANSI_CLEAR_SEQ = "\u001b[2J";  
    //System.out.println(ANSI_CLEAR_SEQ);
    String holdInputHere = "";
    DecimalFormat df = new DecimalFormat("+00000;-00000");
    while (n == 0) {
	sound_index = 0;
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
	    sound_index = get_sounds();
	    jumper = jumper + String.valueOf(sound_index) + " ";
	    count++;
	}

	out.println(jumper);
	jumper = "";
	
	unicodeMessage = String.format("\\u%04x", 0x50D8 );
	code = Integer.parseInt(unicodeMessage.substring(2), 16);

	//this is the insertion point for the set of Phones
	//use Integer from spreadsheet

	ch = Character.toChars(code)[0];
	//out.println();
	//out.println("character: " + ch + " " + "unicodeMessage: " + unicodeMessage + " " + "code: " + code);
	String toot = baka_gen(holdInputHere);
	String moot = "";
	set_comente(toot);
	say_phon();
	out.println("***>> " + toot + " <<***");
	coolio.crank();
	Integer beak = 0, creak = 0, sneak = 0;
	for(int fii = 0; fii <= count; fii++) {
            beak = jenny.nextInt(3);
	    creak = coolio.spin();
	    if(creak != null) {
		ch = Character.toChars(creak)[0];
		//out.print(ch);
	    }
	    //if (beak == 2) {out.print(" ");}
        }
	for(int bebe = 1; bebe < coolio.getmSIlen(); bebe++) {
	    creak = jenny.nextInt(6);
	    beak = (coolio.getmSI((Integer) bebe));
	    String elven = Integer.toString(beak);
	    //System.out.println("****elven: " + elven + " elven****");
	    //System.out.println("****beak: " + beak + " beak****");
	    sneak = coolio.hobnob(beak, bebe, creak);
	    //out.println("****sneak: " + sneak + " sneak****");
	    ch = Character.toChars(sneak)[0];
	    out.print(ch);
	    //if(creak == 2) out.print(" ");
	}
	out.println("");
	out.println("****************PHONMAP******************");
	out.println("  Integer         Index         Character");
	for(int ooh = 0; ooh < coolio.getmSIlen(); ooh++) {
	    jumper = Integer.toString(coolio.getmSI(ooh));
	    pop = coolio.getmSI(ooh);
	    //out.println("Getting the Integer of the response phoneme: " + jumper);
	    trumper = Integer.toString(coolio.getPhoneNumber(coolio.getmSI(ooh)));
	    mop = coolio.getPhoneNumber(coolio.getmSI(ooh));
	    taste = coolio.getPhoneNumber(coolio.getmSI(ooh));
	    //out.println("Getting the index number of the phoneme (1-166): " + trumper);
	    thumper = coolio.getPhoneSymbol(taste);
	    thumper = thumper.replace("\\u", "");
	    //out.println("This is the respective phonetic symbol: " + (char)Integer.parseInt(thumper, 16));
	    //System.out.println("---->" + df.format(tiger) + "---->" + df.format(coo) + "---->" + df.format(doo));
	    out.println("  " + df.format(pop) + "         " + df.format(mop) + "              " + (char)Integer.parseInt(thumper, 16));
	}
	out.println("");
	n = JOptionPane.showOptionDialog(null,"Test again?", "A good question",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
    }
  }
}