
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
 * Encoder implementing the phonetic algorithm "DoubleMetaphone".
 * DoubleMetaphone was developed by Lawrence Philips
 * and published in the June 2000 issue of the C/C++ Users Journal.
 * DoubleMetaphone is an improvement
 * of Philips' original Metaphone algorithm.
 * <br><br>
 * DoubleMetaphone sometimes generates two encodings of a word,
 * instead of only one like Soundex and Metaphone.
 * The first encoding is usually based on the most commonly heard
 * pronounciation of the word in the U.S.A.
 * For more information on DoubleMetaphone, please see Philips' article
 * <a href="http://www.cuj.com/articles/2000/0006/0006d/0006d.htm">article</a>.
 * <br><br>
 * This implementation is based on the
 * <a href="ftp://ftp.cuj.com/pub/2000/1806/philips.zip">original Visual C++ implementation</a>
 * by Lawrence Philips with
 * <a href="http://aspell.sourceforge.net/metaphone/dmetaph.cpp">slight modifications and bug fixes</a>
 * by Kevin Atkinson.
 *
 * @see Metaphone
 * @see Soundex
 * @author Claus Engel
 */
public final class DoubleMetaphone extends MetaphoneEncoder
{
    private final static String[] GN_KN_PN_WR_PS                    = new String[] { "GN", "KN", "PN", "WR", "PS" };
    private final static String[] ACH                               = new String[] { "ACH" };
    private final static String[] BACHER_MACHER                     = new String[] { "BACHER", "MACHER" };
    private final static String[] CAESAR                            = new String[] { "CAESAR" };
    private final static String[] CHIA                              = new String[] { "CHIA" };
    private final static String[] CH                                = new String[] { "CH" };
    private final static String[] CHAE                              = new String[] { "CHAE" };
    private final static String[] HARAC_HARIS_HOR_HYM_HIA_HEM       = new String[] { "HARAC", "HARIS", "HOR", "HYM", "HIA", "HEM" };
    private final static String[] CHORE                             = new String[] { "CHORE" };
    private final static String[] SCH                               = new String[] { "SCH" };
    private final static String[] VAN__VON__SCH                     = new String[] { "VAN ", "VON ", "SCH" };
    private final static String[] ORCHES_ARCHIT_ORCHID              = new String[] { "ORCHES", "ARCHIT", "ORCHID" };
    private final static String[] T_S                               = new String[] { "T", "S" };
    private final static String[] A_O                               = new String[] { "A", "O" };
    private final static String[] A_O_U_E                           = new String[] { "A", "O", "U", "E" };
    private final static String[] L_R_N_M_B_H_F_V_W__               = new String[] { "L", "R", "N", "M", "B", "H", "F", "V", "W", " " };
    private final static String[] MC                                = new String[] { "MC" };
    private final static String[] CZ                                = new String[] { "CZ" };
    private final static String[] WICZ                              = new String[] { "WICZ" };
    private final static String[] CIA                               = new String[] { "CIA" };
    private final static String[] CC                                = new String[] { "CC" };
    private final static String[] I_E_H                             = new String[] { "I", "E", "H" };
    private final static String[] HU                                = new String[] { "HU" };
    private final static String[] UCCEE_UCCES                       = new String[] { "UCCEE", "UCCES" };
    private final static String[] CK_CG_CQ                          = new String[] { "CK", "CG", "CQ" };
    private final static String[] CI_CE_CY                          = new String[] { "CI", "CE", "CY" };
    private final static String[] CIO_CIE_CIA                       = new String[] { "CIO", "CIE", "CIA" };
    private final static String[] _C__Q__G                          = new String[] { " C", " Q", " G" };
    private final static String[] C_K_Q                             = new String[] { "C", "K", "Q" };
    private final static String[] CE_CI                             = new String[] { "CE", "CI" };
    private final static String[] DG                                = new String[] { "DG" };
    private final static String[] I_E_Y                             = new String[] { "I", "E", "Y" };
    private final static String[] DT_DD                             = new String[] { "DT", "DD" };
    private final static String[] B_H_D                             = new String[] { "B", "H", "D" };
    private final static String[] B_H                               = new String[] { "B", "H" };
    private final static String[] C_G_L_R_T                         = new String[] { "C", "G", "L", "R", "T" };
    private final static String[] EY                                = new String[] { "EY" };
    private final static String[] LI                                = new String[] { "LI" };
    private final static String[] Y_ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER= new String[] { "Y", "ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER" };
    private final static String[] Y_ER                              = new String[] { "Y", "ER" };
    private final static String[] DANGER_RANGER_MANGER              = new String[] { "DANGER", "RANGER", "MANGER" };
    private final static String[] E_I                               = new String[] { "E", "I" };
    private final static String[] RGY_OGY                           = new String[] { "RGY", "OGY" };
    private final static String[] E_I_Y                             = new String[] { "E", "I", "Y" };
    private final static String[] AGGI_OGGI                         = new String[] { "AGGI", "OGGI" };
    private final static String[] ET                                = new String[] { "ET" };
    private final static String[] IER_                              = new String[] { "IER " };
    private final static String[] JOSE                              = new String[] { "JOSE" };
    private final static String[] SAN_                              = new String[] { "SAN " };
    private final static String[] L_T_K_S_N_M_B_Z                   = new String[] { "L", "T", "K", "S", "N", "M", "B", "Z" };
    private final static String[] S_K_L                             = new String[] { "S", "K", "L" };
    private final static String[] ILLO_ILLA_ALLE                    = new String[] { "ILLO", "ILLA", "ALLE" };
    private final static String[] AS_OS                             = new String[] { "AS", "OS" };
    private final static String[] ALLE                              = new String[] { "ALLE" };
    private final static String[] UMB                               = new String[] { "UMB" };
    private final static String[] P_B                               = new String[] { "P", "B" };
    private final static String[] IE                                = new String[] { "IE" };
    private final static String[] IER                               = new String[] { "IER" };
    private final static String[] ER                                = new String[] { "ER" };
    private final static String[] ME_MA                             = new String[] { "ME", "MA" };
    private final static String[] ISL_YSL                           = new String[] { "ISL", "YSL" };
    private final static String[] SUGAR                             = new String[] { "SUGAR" };
    private final static String[] SH                                = new String[] { "SH" };
    private final static String[] HEIM_HOEK_HOLM_HOLZ               = new String[] { "HEIM", "HOEK", "HOLM", "HOLZ" };
    private final static String[] SIO_SIA                           = new String[] { "SIO", "SIA" };
    private final static String[] SIAN                              = new String[] { "SIAN" };
    private final static String[] M_N_L_W                           = new String[] { "M", "N", "L", "W" };
    private final static String[] Z                                 = new String[] { "Z" };
    private final static String[] SC                                = new String[] { "SC" };
    private final static String[] OO_ER_EN_UY_ED_EM                 = new String[] { "OO", "ER", "EN", "UY", "ED", "EM" };
    private final static String[] ER_EN                             = new String[] { "ER", "EN" };
    private final static String[] AI_OI                             = new String[] { "AI", "OI" };
    private final static String[] S_Z                               = new String[] { "S", "Z" };
    private final static String[] TION                              = new String[] { "TION" };
    private final static String[] TIA_TCH                           = new String[] { "TIA", "TCH" };
    private final static String[] TH_TTH                            = new String[] { "TH", "TTH" };
    private final static String[] OM_AM                             = new String[] { "OM", "AM" };
    private final static String[] T_D                               = new String[] { "T", "D" };
    private final static String[] WR                                = new String[] { "WR" };
    private final static String[] WH                                = new String[] { "WH" };
    private final static String[] EWSKI_EWSKY_OWSKI_OWSKY           = new String[] { "EWSKI", "EWSKY", "OWSKI", "OWSKY" };
    private final static String[] WICZ_WITZ                         = new String[] { "WICZ", "WITZ" };
    private final static String[] IAU_EAU                           = new String[] { "IAU", "EAU" };
    private final static String[] AU_OU                             = new String[] { "AU", "OU" };
    private final static String[] C_X                               = new String[] { "C", "X" };
    private final static String[] ZO_ZI_ZA                          = new String[] { "ZO", "ZI", "ZA" };

    private StringBuffer primaryBuffer;
    private StringBuffer secondaryBuffer;
    private boolean      hasAlternate;

    /**
     * Constructs a DoubleMetaphone encoder which generates keys of given
     * maximal length.
     * @param maxLength the maximal length of the generated keys. If negative,
     *                  the lengths of the keys returned are only limited
     *                  by the lengths of the words to encode.
     */
    public DoubleMetaphone (int maxLength)
    {
        super (maxLength);
    }

    /**
     * Constructs a DoubleMetaphone encoder which generates keys with
     * maximal length 4.
     */
    public DoubleMetaphone ()
    {
        super (4);
    }

    /**
     * Returns a <tt>String</tt> identifying the algorithm.
     */
    public String toString()
    {
        return "DoubleMetaphone_"+maxLength;
    }

    private void add (final String main)
    {
        primaryBuffer.append(main);
        secondaryBuffer.append(main);
    }

    private void add (final String main, final String alternate)
    {
        primaryBuffer.append(main);
        if (alternate.length() > 0)
        {
            hasAlternate = true;
            if (!alternate.equals(" "))
                secondaryBuffer.append(alternate);
        }
        else
        {
            if (main.length() > 0 && !main.equals(" "))
                secondaryBuffer.append(main);
        }
    }

    private static boolean isSlavoGermanic (final String string)
    {
        return (string.indexOf('W')    >= 0) ||
               (string.indexOf('K')    >= 0) ||
               (string.indexOf("CZ")   >= 0) ||
               (string.indexOf("WITZ") >= 0);
    }

    /**
     * Returns an encoding of the given word, that is based on the most
     * commonly heard pronounciation of the word in the U.S.A.
     * @param word the word to encode.
     * @return the encoding of the word. This is never <code>null</code>.
     */
    public String generateKey (final String word)
    {
        final String[] result = generateKeys(word);
        return (result.length > 0) ? result[0] : "";
    }

    /**
     * Returns the encodings of the given word. The first is based on the most
     * commonly heard pronounciation of the word in the U.S.A.
     * @param word the word to encode.
     * @return an array of the encodings of the word.
     *         This is never <code>null</code>.
     */
    public synchronized String[] generateKeys (String word)
    {
        if (word == null || word.length() == 0)
            return EMPTY_KEYS;

        primaryBuffer   = new StringBuffer(word.length());
        secondaryBuffer = new StringBuffer(word.length());
        hasAlternate    = false;

        word = word.toUpperCase();

        final int length = word.length();
        final int last   = length -1;

        final boolean isSlavoGermanic = isSlavoGermanic(word);

        int n = 0;

        // skip these when at start of word
        if (match(word,0,GN_KN_PN_WR_PS))
            n += 1;

        // initial 'X' is pronounced 'Z' e.g. 'Xavier'
        if (match(word,0,'X'))
        {
            add("S"); //'Z' maps to 'S'
            n += 1;
        }

        while (n < length && (maxLength < 0 || (primaryBuffer.length() < maxLength && secondaryBuffer.length() < maxLength)))
        {
            switch (word.charAt(n))
            {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
                if (n == 0)
                    //all init vowels now map to 'A'
                    add("A");
                n += 1;
                break;

            case 'B':
                //"-mb", e.g", "dumb", already skipped over...
                add("P");
                n += match(word,n+1,'B') ? 2 : 1;
                break;

            case 'Ç':
                add("S");
                n += 1;
                break;

            case 'C':
                // various germanic
                if ((n > 1) &&
                    !isVowel(word,n-2) &&
                    match(word,n-1,ACH) &&
                    !match(word,n+2,'I') &&
                    (!match(word,n+2,'E') || match(word,n-2,BACHER_MACHER)))
                {
                    add("K");
                    n += 2;
                    break;
                }

                // special case 'caesar'
                if ((n == 0) && match(word,n,CAESAR))
                {
                    add("S");
                    n += 2;
                    break;
                }

                // italian 'chianti'
                if (match(word,n,CHIA))
                {
                    add("K");
                    n += 2;
                    break;
                }

                if (match(word,n,CH))
                {
                    // find 'michael'
                    if ((n > 0) && match(word,n,CHAE))
                    {
                        add("K", "X");
                        n += 2;
                        break;
                    }

                    // greek roots e.g. 'chemistry', 'chorus'
                    if ((n == 0) &&
                        match(word,n+1,HARAC_HARIS_HOR_HYM_HIA_HEM) &&
                        !match(word,0,CHORE))
                    {
                        add("K");
                        n += 2;
                        break;
                    }

                    // germanic, greek, or otherwise 'ch' for 'kh' sound
                    if (match(word,0,VAN__VON__SCH)
                        // 'architect' but not 'arch', 'orchestra', 'orchid'
                        || match(word,n-2,ORCHES_ARCHIT_ORCHID)
                        || match(word,n+2,T_S)
                        || (  ((n==0) || match(word,n-1,A_O_U_E)) &&
                              //e.g., 'wachtler', 'wechsler', but not 'tichner'
                              match(word,n+2,L_R_N_M_B_H_F_V_W__)  ))
                    {
                        add("K");
                    }
                    else
                    {
                        if (n > 0)
                        {
                            if (match(word,0,MC))
                                // e.g., "McHugh"
                                add("K");
                            else
                                add("X", "K");
                        }
                        else
                            add("X");
                    }
                    n += 2;
                    break;
                }

                // e.g., 'czerny'
                if (match(word,n,CZ) && !match(word,n-2,WICZ))
                {
                    add("S", "X");
                    n += 2;
                    break;
                }

                // e.g., 'focaccia'
                if (match(word,n+1,CIA))
                {
                    add("X");
                    n += 3;
                    break;
                }

                // double 'C', but not if e.g. 'McClellan'
                if (match(word,n,CC) && !((n == 1) && match(word,0,'M')))
                {
                    // 'bellocchio' but not 'bacchus'
                    if (match(word,n+2,I_E_H) && !match(word,n+2,HU))
                    {
                        // 'accident', 'accede', 'succeed'
                        if (((n == 1) && match(word,n-1,'A'))
                            || match(word,n-1,UCCEE_UCCES))
                            add("KS");
                        // 'bacci', 'bertucci', other italian
                        else
                            add("X");
                        n += 3;
                        break;
                    }
                    else
                    {
                        // Pierce's rule
                        add("K");
                        n += 2;
                        break;
                    }
                }

                if (match(word,n,CK_CG_CQ))
                {
                    add("K");
                    n += 2;
                    break;
                }

                if (match(word,n,CI_CE_CY))
                {
                    // italian vs. english
                    if (match(word,n,CIO_CIE_CIA))
                        add("S", "X");
                    else
                        add("S");
                    n += 2;
                    break;
                }

                // else
                add("K");

                // name sent in 'mac caffrey', 'mac gregor'
                if (match(word,n+1,_C__Q__G))
                    n += 3;
                else
                    n += (match(word,n+1,C_K_Q) && !match(word,n+1,CE_CI)) ? 2 : 1;
                break;

            case 'D':
                if (match(word,n,DG))
                {
                    if (match(word,n+2,I_E_Y))
                    {
                        // e.g. 'edge'
                        add("J");
                        n += 3;
                        break;
                    }
                    else
                    {
                        // e.g. 'edgar'
                        add("TK");
                        n += 2;
                        break;
                    }
                }

                if (match(word,n,DT_DD))
                {
                    add("T");
                    n += 2;
                    break;
                }

                // else
                add("T");
                n += 1;
                break;

            case 'F':
                n += match(word,n+1,'F') ? 2 : 1;
                add("F");
                break;

            case 'G':
                if (match(word,n+1,'H'))
                {
                    if ((n > 0) && !isVowel(word,n-1))
                    {
                        add("K");
                        n += 2;
                        break;
                    }

                    if (n < 3)
                    {
                        // 'ghislane', 'ghiradelli'
                        if (n == 0)
                        {
                            if (match(word,n+2,'I'))
                                add("J");
                            else
                                add("K");
                            n += 2;
                            break;
                        }
                    }

                    // Parker's rule (with some further refinements) - e.g., 'hugh'
                    if(((n > 1) && match(word,n-2,B_H_D))
                        // e.g., 'bough'
                        || ((n > 2) && match(word,n-3,B_H_D))
                        // e.g., 'broughton'
                        || ((n > 3) && match(word,n-4,B_H)) )
                    {
                        n += 2;
                        break;
                    }
                    else
                    {
                        // e.g., 'laugh', 'McLaughlin', 'cough', 'gough', 'rough', 'tough'
                        if ((n > 2) && match(word,n-1,'U') && match(word,n-3,C_G_L_R_T))
                        {
                            add("F");
                        }
                        else if ((n > 0) && !match(word,n-1,'I'))
                        {
                            add("K");
                        }

                        n += 2;
                        break;
                    }
                }

                if (match(word,n+1,'N'))
                {
                    if ((n == 1) && isVowel(word,0) && !isSlavoGermanic)
                    {
                        add("KN", "N");
                    }
                    else
                    {
                        // not e.g. 'cagney'
                        if (!match(word,n+2,EY) && !match(word,n+1,'Y') && !isSlavoGermanic)
                        {
                            add("N", "KN");
                        }
                        else
                        {
                            add("KN");
                        }
                    }
                    n += 2;
                    break;
                }

                // 'tagliaro'
                if (match(word,n+1,LI) && !isSlavoGermanic)
                {
                    add("KL", "L");
                    n += 2;
                    break;
                }

                // -ges-,-gep-,-gel-, -gie- at beginning
                if ((n == 0) && match(word,n+1,Y_ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))
                {
                    add("K", "J");
                    n += 2;
                    break;
                }

                // -ger-,  -gy-
                if (match(word,n+1,Y_ER) &&
                    !match(word,0,DANGER_RANGER_MANGER) &&
                    !match(word,n-1,E_I) &&
                    !match(word,n-1,RGY_OGY))
                {
                    add("K", "J");
                    n += 2;
                    break;
                }

                // italian e.g, 'biaggi'
                if (match(word,n+1,E_I_Y) || match(word,n-1,AGGI_OGGI))
                {
                    // obvious germanic
                    if (match(word,0,VAN__VON__SCH) || match(word,n+1,ET))
                    {
                        add("K");
                    }
                    else
                    {
                        // always soft if french ending
                        if (match(word,n+1,IER))
                            add("J");
                        else
                            add("J", "K");
                    }
                    n += 2;
                    break;
                }

                add("K");
                n += match(word,n+1,'G') ? 2 : 1;
                break;

            case 'H':
                // only keep if first & before vowel or btw. 2 vowels
                if (((n == 0) || isVowel(word,n-1)) && isVowel(word,n+1))
                {
                    add("H");
                    n += 2;
                }
                else
                {
                    //also takes care of 'HH'
                    n += 1;
                }
                break;

            case 'J':
                // obvious spanish, 'jose', 'san jacinto'
                if (match(word,n,JOSE) || match(word,0,SAN_))
                {
                    if (((n == 0) && match(word,n+4,' ')) || match(word,0,SAN_))
                    {
                        add("H");
                    }
                    else
                    {
                        add("J", "H");
                    }
                    n += 1;
                    break;
                }

                if ((n == 0) && !match(word,n,JOSE))
                {
                    add("J", "A");//Yankelovich/Jankelowicz
                }
                else
                {
                    // spanish pron. of e.g. 'bajador'
                    if (isVowel(word,n-1) && !isSlavoGermanic && match(word,n+1,A_O))
                    {
                        add("J", "H");
                    }
                    else
                    {
                        if (n == last)
                        {
                            add("J", " ");
                        }
                        else
                        {
                            if (!match(word,n+1,L_T_K_S_N_M_B_Z) &&
                                !match(word,n-1,S_K_L))
                                add("J");
                        }
                    }
                }

                n += match(word,n+1,'J') ? 2 : 1;
                break;

            case 'K':
                n += match(word,n+1,'K') ? 2 : 1;
                add("K");
                break;

            case 'L':
                if (match(word,n+1,'L'))
                {
                    // spanish e.g. 'cabrillo', 'gallegos'
                    if (((n == length-3) && match(word,n-1,ILLO_ILLA_ALLE))
                        || ( (match(word,last-1,AS_OS) || match(word,last,A_O))
                             && match(word,n-1,ALLE) ))
                    {
                        add("L", " ");
                        n += 2;
                        break;
                    }
                    n += 2;
                }
                else
                {
                    n += 1;
                }
                add("L");
                break;

            case 'M':
                if ((match(word,n-1,UMB) && ((n+1 == last) || match(word,n+2,ER)))
                    //'dumb','thumb'
                    || match(word,n+1,'M'))
                {
                    n += 2;
                }
                else
                {
                    n += 1;
                }
                add("M");
                break;

            case 'N':
                n += match(word,n+1,'N') ? 2 : 1;
                add("N");
                break;

            case 'Ñ':
                n += 1;
                add("N");
                break;

            case 'P':
                if (match(word,n+1,'H'))
                {
                    add("F");
                    n += 2;
                    break;
                }

                // also account for "campbell", "raspberry"
                n += match(word,n+1,P_B) ? 2 : 1;
                add("P");
                break;

            case 'Q':
                n += match(word,n+1,'Q') ? 2 : 1;
                add("K");
                break;

            case 'R':
                // french e.g. 'rogier', but exclude 'hochmeier'
                if ((n == last) &&
                    !isSlavoGermanic &&
                    match(word,n-2,IE) &&
                    !match(word,n-4,ME_MA))
                {
                    add("", "R");
                }
                else
                {
                    add("R");
                }

                n += match(word,n+1,'R') ? 2 : 1;
                break;

            case 'S':
                // special cases 'island', 'isle', 'carlisle', 'carlysle'
                if (match(word,n-1,ISL_YSL))
                {
                    n += 1;
                    break;
                }

                // special case 'sugar-'
                if ((n == 0) && match(word,n,SUGAR))
                {
                    add("X", "S");
                    n += 1;
                    break;
                }

                if (match(word,n,SH))
                {
                    // germanic
                    if (match(word,n+1,HEIM_HOEK_HOLM_HOLZ))
                        add("S");
                    else
                        add("X");
                    n += 2;
                    break;
                }

                // italian & armenian
                if (match(word,n,SIO_SIA) || match(word,n,SIAN))
                {
                    if (!isSlavoGermanic)
                        add("S", "X");
                    else
                        add("S");
                    n += 3;
                    break;
                }

                // german & anglicisations, e.g. 'smith' match 'schmidt', 'snider' match 'schneider'
                // also, -sz- in slavic language altho in hungarian it is pronounced 's'
                if (((n == 0) && match(word,n+1,M_N_L_W)) || match(word,n+1,'Z'))
                {
                    add("S", "X");
                    n += match(word,n+1,'Z') ? 2 : 1;
                    break;
                }

                if (match(word,n,SC))
                {
                    // Schlesinger's rule
                    if (match(word,n+2,'H'))
                    {
                        // dutch origin, e.g. 'school', 'schooner'
                        if (match(word,n+3,OO_ER_EN_UY_ED_EM))
                        {
                            // 'schermerhorn', 'schenker'
                            if (match(word,n+3,ER_EN))
                                add("X", "SK");
                            else
                                add("SK");
                            n += 3;
                            break;
                        }
                        else
                        {
                            if((n == 0) && !isVowel(word,3) && !match(word,3,'W'))
                                add("X", "S");
                            else
                                add("X");
                            n += 3;
                            break;
                        }
                    }

                    if (match(word,n+2,I_E_Y))
                        add("S");
                    else
                        add("SK");
                    n += 3;
                    break;
                }

                // french e.g. 'resnais', 'artois'
                if ((n == last) && match(word,n-2,AI_OI))
                    add("", "S");
                else
                    add("S");

                n += match(word,n+1,S_Z) ? 2 : 1;
                break;

            case 'T':
                if (match(word,n,TION))
                {
                    add("X");
                    n += 3;
                    break;
                }

                if (match(word,n,TIA_TCH))
                {
                    add("X");
                    n += 3;
                    break;
                }

                if (match(word,n,TH_TTH))
                {
                    // special case 'thomas', 'thames' or germanic
                    if (match(word,n+2,OM_AM) || match(word,0,VAN__VON__SCH))
                        add("T");
                    else
                        add("0", "T");
                    n += 2;
                    break;
                }

                n += match(word,n+1,T_D) ? 2 : 1;
                add("T");
                break;

            case 'V':
                n += match(word,n+1,'V') ? 2 : 1;
                add("F");
                break;

            case 'W':
                // can also be in middle of word
                if (match(word,n,WR))
                {
                    add("R");
                    n += 2;
                    break;
                }

                if ((n == 0) && (isVowel(word,n+1) || match(word,n,WH)))
                {
                    // Wasserman should match Vasserman
                    if (isVowel(word,n+1))
                        add("A", "F");
                    else
                        //need Uomo to match Womo
                        add("A");
                }

                // Arnow should match Arnoff
                if (((n == last) && isVowel(word,n-1))
                    || match(word,n-1,EWSKI_EWSKY_OWSKI_OWSKY)
                    || match(word,0,SCH))
                {
                    add("", "F");
                    n += 1;
                    break;
                }

                // polish e.g. 'filipowicz'
                if (match(word,n,WICZ_WITZ))
                {
                    add("TS", "FX");
                    n += 4;
                    break;
                }

                // else skip it
                n += 1;
                break;

            case 'X':
                // french e.g. breaux
                if (!((n == last) && (match(word,n-3,IAU_EAU) || match(word,n-2,AU_OU))))
                    add("KS");

                n += match(word,n+1,C_X) ? 2 : 1;
                break;

            case 'Z':
                // chinese pinyin e.g. 'zhao'
                if (match(word,n+1,'H'))
                {
                    add("J");
                    n += 2;
                    break;
                }
                else
                {
                    if (match(word,n+1,ZO_ZI_ZA)
                        || (isSlavoGermanic && (n > 0) && !match(word,n-1,'T')))
                    {
                        add("S", "TS");
                    }
                    else
                        add("S");
                }

                n += match(word,n+1,'Z') ? 2 : 1;
                break;

            default:
                n += 1;
            }
        }

        if (maxLength < 0)
        {
            // result with unlimited length
            if (hasAlternate)
                return new String[] { primaryBuffer.toString(), secondaryBuffer.toString() };
            else
                return new String[] { primaryBuffer.toString() };
        }
        else
        {
            // limit the length of the resulting strings
            final int primaryLength = Math.min(maxLength, primaryBuffer.length());
            if (hasAlternate)
            {
                final int secondaryLength = Math.min(maxLength, secondaryBuffer.length());
                return new String[] { primaryBuffer.toString().substring(0,primaryLength),
                                      secondaryBuffer.toString().substring(0,secondaryLength) };
            }
            else
                return new String[] { primaryBuffer.toString().substring(0,primaryLength) };
        }
    }

    /**
     * Test of algorithm with default constructed encoder.
     * The encoded arguments are printed to <tt>System.out</tt>.
     */
    public static void main (String[] argv)
    {
        final DoubleMetaphone generator = new DoubleMetaphone();

        for (int n = 0; n < argv.length; n++)
        {
            String[] keys = generator.generateKeys(argv[n]);
            for (int m=0; m < keys.length; m++)
                System.out.print(keys[m] + " ");
            System.out.println();
        }
    }
}

