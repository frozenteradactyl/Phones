
/*
    Phonetix: a class-library of phonetic algorithms.
    Copyright (C) 2001-2003  Claus Engel

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
package com.tangentum.phonetix;

/**
 * Encoder implementing the phonetic algorithm "Metaphone".
 * Metaphone was originally developed by Lawrence Philips.
 * This implementation is based on his original BASIC implementation.
 *
 * @see DoubleMetaphone
 * @see Soundex
 * @author Claus Engel
 */
public final class Metaphone extends MetaphoneEncoder
{
    private final static String[] GN_KN_PN_WR_AE    = new String[] { "GN", "KN", "PN", "WR", "AE" };
    private final static String[] WH                = new String[] { "WH" };
    private final static String[] IA                = new String[] { "IA" };
    private final static String[] SCE_SCI_SCY       = new String[] { "SCE", "SCI", "SCY" };
    private final static String[] E_I_Y             = new String[] { "E", "I", "Y" };
    private final static String[] SCH               = new String[] { "SCH" };
    private final static String[] GE_GI_GY          = new String[] { "GE", "GI", "GY" };
    private final static String[] NED               = new String[] { "NED" };
    private final static String[] DGE_DGI_DGY       = new String[] { "DGE", "DGI", "DGY" };
    private final static String[] C_S_P_T_G         = new String[] { "C", "S", "P", "T", "G" };
    private final static String[] IO_IA             = new String[] { "IO", "IA" };
    private final static String[] CH                = new String[] { "CH" };

    /**
     * Constructs a Metaphone encoder which generates keys of given
     * maximal length.
     * @param maxLength the maximal length of the generated keys. If negative,
     *                  the lengths of the keys returned are only limited
     *                  by the lengths of the words to encode.
     */
    public Metaphone (int maxLength)
    {
        super (maxLength);
    }

    /**
     * Constructs a Metaphone encoder which generates keys with
     * maximal length 4.
     */
    public Metaphone ()
    {
        super (4);
    }

    /**
     * Returns a <tt>String</tt> identifying the algorithm.
     */
    public String toString()
    {
        return "Metaphone_"+maxLength;
    }

    /**
     * Returns the encoding of the given word.
     * @param word the word to encode.
     * @return an array with the encoding of the word.
     *         This is never <code>null</code>.
     */
    public String[] generateKeys (final String word)
    {
        return (word!=null && word.length()>0) ? new String[] {generateKey(word)} : EMPTY_KEYS;
    }

    /**
     * Returns the encoding of the given word.
     * @param word the word to encode.
     * @return the encoding of the word. This is never <code>null</code>.
     */
    public String generateKey (String word)
    {
        if (word == null || word.length() == 0)
            return "";

        final StringBuffer buffer = new StringBuffer(word.length());

        word = word.toUpperCase();

        if (match(word,0,GN_KN_PN_WR_AE))
            word = word.substring(1);

        if (match(word,0,'X'))
            word = "S" + word.substring(1);

        if (match(word,0,WH))
            word = "W" + word.substring(2);

        final int length = word.length();
        final int last   = length -1;

        for (int n=0; n < length && (maxLength < 0 || (buffer.length() < maxLength)); n++)
        {
            char c = word.charAt(n);
            if (c != 'C' && n > 0 && match(word,n-1,c))
                continue;

            switch (c)
            {
            case 'A':
                if (n == 0)
                    buffer.append('A');
                break;

            case 'B':
                if ((n != last) || !match(word,n-1,'M'))
                    buffer.append('B');
                break;

            case 'C':
                if (!match(word,n-1,SCE_SCI_SCY))
                {
                    if (match(word,n+1,IA))
                        buffer.append('X');
                    else if (match(word,n+1,E_I_Y))
                        buffer.append('S');
                    else if (match(word,n-1,SCH))
                        buffer.append('K');
                    else if (match(word,n+1,'H'))
                        buffer.append( (n==0 && !isVowel(word,n+2)) ? 'K' : 'X' );
                    else
                        buffer.append('K');
                }
                break;

            case 'D':
                buffer.append( match(word,n+1,GE_GI_GY) ? 'J' : 'T' );
                break;

            case 'E':
                if (n == 0)
                    buffer.append('E');
                break;

            case 'F':
                buffer.append('F');
                break;

            case 'G':
                boolean silent = match(word,n+1,'H') && !isVowel(word,n+2);

                if (n > 0)
                {
                    if ( (n+1 == last && match(word,n+1,'N')) ||  // -GN
                         (n+3 == last && match(word,n+1,NED)) )   // -GNED
                        silent = true;

                    if (match(word,n-1,DGE_DGI_DGY)) // -DGE- -DGI- -DGY-
                        silent = true;
                }

                if (!silent)
                    buffer.append( (match(word,n+1,E_I_Y) && !match(word,n-1,'G')) ? 'J' : 'K' );
                break;

            case 'H':
                if (n < last && !match(word,n-1,C_S_P_T_G) && isVowel(word,n+1))
                    buffer.append('H');
                break;

            case 'I':
                if (n == 0)
                    buffer.append('I');
                break;

            case 'J':
                buffer.append('J');
                break;

            case 'K':
                if ((n==0) || !match(word,n-1,'C'))
                    buffer.append('K');
                break;

            case 'L':
                buffer.append('L');
                break;

            case 'M':
                buffer.append('M');
                break;

            case 'N':
                buffer.append('N');
                break;

            case 'O':
                if (n == 0)
                    buffer.append('O');
                break;

            case 'P':
                buffer.append( match(word,n+1,'H') ? 'F' : 'P' );
                break;

            case 'Q':
                buffer.append('K');
                break;

            case 'R':
                buffer.append('R');
                break;

            case 'S':
                if (match(word,n+1,IO_IA))
                    buffer.append('X');
                else
                    buffer.append( match(word,n+1,'H') ? 'X' : 'S' );
                break;

            case 'T':
                if (match(word,n+1,IO_IA))
                    buffer.append('X');
                else if (match(word,n+1,'H'))
                {
                    if (!match(word,n-1,'T'))
                        buffer.append('0');
                }
                else
                {
                    if (!match(word,n+1,CH))
                        buffer.append('T');
                }
                break;

            case 'U':
                if (n == 0)
                    buffer.append('U');
                break;

            case 'V':
                buffer.append('F');
                break;

            case 'W':
                if (isVowel(word,n+1))
                    buffer.append('W');
                break;

            case 'X':
                buffer.append("KS");
                break;

            case 'Y':
                if (isVowel(word,n+1))
                    buffer.append('Y');
                break;

            case 'Z':
                buffer.append('S');
                break;
            }
        }

        if (maxLength < 0)
        {
            // result with unlimited length
            return buffer.toString();
        }
        else
        {
            // limit the length of the resulting strings
            final int bufferLength = Math.min(maxLength, buffer.length());
            return buffer.toString().substring(0,bufferLength);
        }
    }

    /**
     * Test of algorithm with default constructed encoder.
     * The encoded arguments are printed to <tt>System.out</tt>.
     */
    public static void main (String[] argv)
    {
        final Metaphone generator = new Metaphone();

        for (int n = 0; n < argv.length; n++)
            System.out.println(generator.generateKeys(argv[n])[0]);
    }
}

