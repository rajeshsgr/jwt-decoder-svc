/*
 * Copyright 2022 Rajesh P
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.jwt.decodersvc.service.impl;

import com.jwt.decodersvc.dto.TokenDTO;
import com.jwt.decodersvc.service.TokenDecoderService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Contains the main logic to decode the token using Base 64 decoder method
 * Token contains header and payload information. This class extracts header, payload
 * decodes and maps it TokenDTO object and returns to the caller
 */
@Component
public class TokenDecoderServiceImpl implements TokenDecoderService {

    @Override
    public TokenDTO decodeToken(String jwt) throws UnsupportedEncodingException {

        String[] jwtSections = jwt.split("\\.");

        String b64payloadHeader = jwtSections[0];

        String b64payloadData = jwtSections[1];

        String header = new String(Base64.decodeBase64(b64payloadHeader), "UTF-8").translateEscapes();

        String payload = new String(Base64.decodeBase64(b64payloadData), "UTF-8");

        TokenDTO objJWT = new TokenDTO(header,payload);


        return objJWT;
    }
}
