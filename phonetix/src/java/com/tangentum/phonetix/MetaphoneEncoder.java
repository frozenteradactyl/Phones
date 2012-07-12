
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
 * Abstract base class of "metaphone"-encoders.
 *
 * @author Claus Engel
 */
public abstract class MetaphoneEncoder extends PhoneticEncoder
{
    protected final int maxLength;

    /**
     * Constructs a phonetic encoder of type "metaphone".
     * @param maxLength the maximal length of the keys to generate by
     *                  this <code>MetaphoneEncoder</code>. If the given
     *                  length is lower than zero, the lengths of the generated
     *                  keys are only limited by the size of the words to encode.
     */
    public MetaphoneEncoder (int maxLength)
    {
        this.maxLength = maxLength;
    }

    protected static boolean isVowel (final String string, int pos)
    {
        if (pos < 0 || string.length() <= pos)
            return false;

        final char c = string.charAt(pos);
        return c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }

    protected static boolean match (final String string, int pos, final String[] strings)
    {
        if (0 <= pos && pos < string.length())
        {
            for (int n=strings.length-1; n >= 0; n--)
            {
                if (string.regionMatches(pos, strings[n], 0, strings[n].length()))
                    return true;
            }
        }
        return false;
    }

    protected static boolean match (final String string, int pos, char c)
    {
        return (0 <= pos && pos < string.length()) ? string.charAt(pos) == c : false;
    }
}

