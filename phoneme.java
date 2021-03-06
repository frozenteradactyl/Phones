import java.io.*;
import java.lang.String;
/**
 * This class represents the 47 fundamental sounds of
 * the English language
 */

/**
 *
 * @author Drop
 */
public class phoneme {
    /**        These are the phonemes which define the English language    */
    
    private static int lastindex = 0;
    private static String [] phonemes = { "^","a:","@","\u00A8","e", "e:(r)","i","i:", "o","o:", "u","u:","ai","au","Ou","e..(r)","ei","i..(r)","oi","u..(r)","b","d", "f","g","h","j","k","l","m","n","N","p", "r","s","S","t","tS","th","TH","v","w","z", "Z","dZ","'","(r)","i(:)",".l",".n"};

    private static int soundcount = phonemes.length;
    /**
     * @param args the command line arguments
     */
    private static String emphasis, terminalsound, variablesound, shortvowelstart,
            consassyllable;
    private static String [] sounds = { "cup, luck","arm, father","cat, black", "away, cinema",
        "met, bed", "turn, learn",
        "hit, sitting","see, heat", "hot, rock","call, four",
        "put, could","blue, food","five, eye","now, out","go, home","where, air","say, eight","near, here","boy, join",
        "pure, tourist","bad, lab","did, lady","find, if","give, flag", "how, hello","yes, yellow","cat, back","leg, little","man, lemon",
        "no, ten","sing, finger","pet, map","red, try","sun, miss", "she, crash","tea, getting","check, church","think, both","this, mother",
        "voice, five","wet, window","zoo, lazy","pleasure, vision","just, large" };

    public static void printphonemes()    {
    int perline = 0;
    int pant = 0;
    int kk = 0;
    for ( int i = 0; i < soundcount; ++i ){
        System.out.print(i+1);
        System.out.print(": ");
        System.out.print(phonemes[i]);
        pant = phonemes[i].length();
	System.out.print(pant);
	if ( pant < 3){for ( kk = 0; kk <= 4; ++kk ){System.out.print('\t');}}
	    else { for ( kk = 0; kk <= 3; ++kk ){System.out.print('\t');}}
	if ((i+1) % 3 == 0) {System.out.print('\n');}
    }
    System.out.print('\n');
    }

    public static void phonemecount()  {
        System.out.println(soundcount);
    }
    
    public boolean inmatrixphonemes(String seed)   {
    boolean in = false;
    for (int i = 0; i < soundcount; ++i)    {
        if (seed.equals(phonemes[i])) {in = true; break;}
    }
    return in;
    }
    public int matrixindexphonemes(String seed)    {
    for (int i = 0; i < soundcount; ++i)    {
        if (seed.equals(phonemes[i])) {lastindex = i; break;}
    }
    return lastindex;
    }
    public String phonemesound(String seed)  {
        return sounds[matrixindexphonemes(seed)];
    }	

    public static void main( String[] args )	{
        /**phoneme gr = new phoneme();*/
        /**System.out.println("penguin");*/
	printphonemes();
	phonemecount();
    }
}