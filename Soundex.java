
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
//package troll;

/**
 * Encoder implementing the phonetic algorithm "Soundex".
 * Soundex is described in Donald Knuth's
 * <i>The Art of Computer Programming</i>, Vol.3.
 *
 * @see DoubleMetaphone
 * @see Metaphone
 * @author Claus Engel
 */

public final class Soundex extends PhoneticEncoder
{
    private final boolean full;
    private final int     length;

    /**
     * Constructs a Soundex encoder which generates keys of given length.
     * @param full a flag which specifies, whether the first character has to
     *             to be encoded, or not. If <code>false</code>, then this encoder works
     *             like the original soundex described by Knuth, i.e. 'Knuth'
     *             will become 'K530'. If <code>true</code>, then this encoder will encode
     *             the first character too, i.e. 'Knuth' will become '2530'.
     * @param length the length of the keys to generate.
     */
    public Soundex (boolean full, int length)
    {
        this.full   = full;
        this.length = length;
    }

    /**
     * Constructs a Soundex encoder which generates keys of length 4.
     * @param full a flag which specifies, whether the first character has to
     *             to be encoded, or not. If <code>false</code>, this encoder works
     *             like the original soundex described by Knuth, i.e. 'Knuth'
     *             will become 'K530'. If <code>true</code>, this encoder will encode
     *             the first character too, i.e. 'Knuth' will become '2530'.
     */
    public Soundex (boolean full)
    {
        this (full, 4);
    }

    /**
     * Constructs an original Soundex encoder which generates keys of given length.
     * @param length the length of the keys to generate.
     */
    public Soundex (int length)
    {
        this (false, length);
    }

    /**
     * Constructs an original Soundex encoder which generates keys of length 4.
     */
    public Soundex ()
    {
        this(false, 4);
    }

    /**
     * Returns a <tt>String</tt> identifying the algorithm.
     */
    public String toString()
    {
        return "Soundex_"+full+"_"+length;
    }

    private static char getCode (final char c)
    {
        switch (Character.toLowerCase(c))
        {
        case 'b':
        case 'p':
        case 'f':
        case 'v': return '1';
        case 'c':
        case 's':
        case 'k':
        case 'g':
        case 'j':
        case 'q':
        case 'x':
        case 'z': return '2';
        case 'd':
        case 't': return '3';
        case 'l': return '4';
        case 'm':
        case 'n': return '5';
        case 'r': return '6';
        }
        return '*';
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
    public String generateKey (final String word)
    {
        if (length <= 0)
            return "";

        if (word == null || word.length() == 0)
            return "";

        final char[] chars = word.toCharArray();
        final StringBuffer result = new StringBuffer(length);

        int inIdx, outIdx;
        char prevDigit;
        if (full)
        {
            inIdx = outIdx = 0;
            prevDigit = '*';
        }
        else
        {
            inIdx = outIdx = 1;
            result.append(Character.toUpperCase(chars[0]));
            prevDigit = getCode(chars[0]);
        }

        while (inIdx < chars.length && outIdx < length)
        {
            char c = getCode(chars[inIdx]);

            if (c!='*' && c!=prevDigit)
            {
                result.append(c);
                outIdx++;
            }

            prevDigit = c;
            inIdx++;
        }

        for (; outIdx < length; outIdx++)
            result.append('0');

        return result.toString();
    }

    /**
     * Test of algorithm with default constructed encoder.
     * The encoded arguments are printed to <tt>System.out</tt>.
     */
    public static void main (String[] argv)
    {
        final Soundex generator = new Soundex();

        for (int n = 0; n < argv.length; n++)
            System.out.println(generator.generateKey(argv[n]));
    }
}

