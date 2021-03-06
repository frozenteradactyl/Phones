
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
 * <code>PhoneticEncoder</code>s generate one or more keys for a given word
 * using a phonetic algorithm. The goal of each phonetic algorithm is to
 * generate the same keys for words which have a similar pronunciation.
 *
 * @author Claus Engel
 */
public abstract class PhoneticEncoder
{
    /**
     * Generates an array of keys.
     *
     * @param word the word for which the keys have to be generated.
     * @return an array of keys. The keys of more importance are found
     *         at the smaller indices, i.e. the most important key is found
     *         at index zero. The array is never <code>null</code>, but of length
     *         zero, if the given word is <code>null</code> or the empty-string.
     */
    public abstract String[] generateKeys (String word);

    /**
     * Generates a key. If the underlying algorithm creates more
     * than one key, the default key, i.e. the most important key, is returned.
     *
     * @param word the word for which the key has to be generated.
     * @return a key. The result is never <code>null</code>, i.e. if
     *         the given word is <code>null</code> or the empty-string,
     *         then the empty-string is returned.
     */
    public abstract String generateKey (String word);

    public static final String[] EMPTY_KEYS = new String[0];
}

