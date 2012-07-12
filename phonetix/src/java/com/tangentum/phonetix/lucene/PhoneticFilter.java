
/*
    Phonetix for Lucene: phonetic algorithms for the Lucene search-engine.
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
package com.tangentum.phonetix.lucene;

import com.tangentum.phonetix.PhoneticEncoder;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Token;
import java.io.IOException;


/**
 * A <tt>PhoneticFilter</tt> is a <tt>TokenFilter</tt>
 * according to the Lucene search-engine,
 * which uses a {@link PhoneticEncoder}.
 *
 * @see PhoneticAnalyzer
 * @author Claus Engel
 */
public class PhoneticFilter extends TokenFilter
{
    private final PhoneticEncoder[] encoder;
    private int actualIndex;
    private Token actualToken = null;

    /**
     * Constructs a filter which encodes words from the input
     * {@link TokenStream} using the given phonetic encoder.
     * If no encoder is given, i.e. if it is <code>null</code>,
     * no encoding takes place and the input TokenStream remains unchanged.
     */
    public PhoneticFilter (final TokenStream in, final PhoneticEncoder phoneticEncoder)
    {
        input = in;
        encoder = (phoneticEncoder != null) ? new PhoneticEncoder[] { phoneticEncoder } : null;
        actualIndex = encoder.length;
    }

    /**
     * Constructs a filter which encodes words from the input
     * {@link TokenStream} using the given phonetic encoder.
     * If no encoder is given, i.e. if it is <code>null</code>,
     * no encoding takes place and the input TokenStream remains unchanged.
     */
    public PhoneticFilter (final TokenStream in, final PhoneticEncoder[] phoneticEncoder)
    {
        input = in;
        encoder = phoneticEncoder;
        actualIndex = encoder.length;
    }

    /**
     * Returns the next token in the stream, or <code>null</code> at EOF.
     */
    public Token next() throws IOException
    {
        if (encoder == null)
        {
            return input.next();
        }
        else if (encoder.length == 1)   // optimize, if one encoder only
        {
            final Token t = input.next();
            if (t == null)
                return null;

            return (encoder[0] != null) ? new Token(encoder[0].generateKey(t.termText()),
                                                    t.startOffset(),t.endOffset(),t.type())
                                        : t;
        }
        else
        {
            ++actualIndex;

            // get next token, if necessary
            if (actualIndex >= encoder.length)
            {
                actualToken = input.next();
                if (actualToken == null)
                {
                    actualIndex = encoder.length;
                    return null;
                }
                actualIndex = 0;
            }

            if (encoder[actualIndex] == null)
                return actualToken;
            else
                return new Token(encoder[actualIndex].toString()+":"+
                                 encoder[actualIndex].generateKey(actualToken.termText()),
                                 actualToken.startOffset(),actualToken.endOffset(),
                                 actualToken.type());
        }
    }
}

