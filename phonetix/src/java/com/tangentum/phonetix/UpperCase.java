
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

import java.util.Locale;


/**
 * Encoder implementing upper-case copy of given words. Therefore
 * no phonetic encoding takes place here.
 *
 * @see Exact
 * @see LowerCase
 * @author Claus Engel
 */
public final class UpperCase extends PhoneticEncoder
{
    private final Locale locale;

    /**
     * Constructs an upper-case copier with locale.
     * @param locale the locale to use while generating upper-case characters.
     */
    public UpperCase (final Locale locale)
    {
        this.locale = locale;
    }

    /**
     * Constructs an upper-case copier without locale.
     */
    public UpperCase ()
    {
        this.locale = null;
    }

    /**
     * Returns the encoding of the given word.
     * @param word the word to encode.
     * @return an array with the encoding of the word.
     *         This is never <code>null</code>.
     */
    public String[] generateKeys (final String word)
    {
        if (locale != null)
            return (word!=null && word.length()>0) ? new String[] {word.toLowerCase(locale).toUpperCase(locale)} : EMPTY_KEYS;
        else
            return (word!=null && word.length()>0) ? new String[] {word.toLowerCase().toUpperCase()} : EMPTY_KEYS;
    }

    /**
     * Returns the encoding of the given word.
     * @param word the word to encode.
     * @return the encoding of the word. This is never <code>null</code>.
     */
    public String generateKey (final String word)
    {
        if (locale != null)
            return (word!=null && word.length()>0) ? word.toLowerCase(locale).toUpperCase(locale) : "";
        else
            return (word!=null && word.length()>0) ? word.toLowerCase().toUpperCase() : "";
    }

    /**
     * Returns a <tt>String</tt> identifying the algorithm.
     */
    public String toString()
    {
        return "UpperCase";
    }

    /**
     * Test of algorithm with default constructed encoder.
     * The encoded arguments are printed to <tt>System.out</tt>.
     */
    public static void main (final String[] argv)
    {
        final UpperCase generator = new UpperCase();

        for (int n = 0; n < argv.length; n++)
            System.out.println(generator.generateKey(argv[n]));
    }
}

