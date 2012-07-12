import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
//\u0250 (decimal equivalent 592) - \u02AD are the IPA symbols
//Property of John Summers

public class up  {
    static String up = "";
    static char upper = 'a';
    static int i = 592;
    static int j = 685;
    public static void main (String args[]) throws UnsupportedEncodingException {
	for ( ; i<=j; i++ ) {
	    up = "0" + java.lang.Integer.toHexString(i);
	    upper = (char) java.lang.Integer.parseInt(up, 16);
	    PrintStream out = new PrintStream(System.out, true, "UTF-8");
	    String line = "{" + up + "," + upper + "}";  
	    out.println(line);
	}
    }
}