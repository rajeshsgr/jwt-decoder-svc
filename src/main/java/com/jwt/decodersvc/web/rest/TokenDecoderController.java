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

package com.jwt.decodersvc.web.rest;

import com.jwt.decodersvc.dto.TokenDTO;
import com.jwt.decodersvc.service.TokenDecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

/**
 * The {@code TokenDecoderController} class contains the method
 * to invoke the jwtDecode API endpoint
 */
@RestController
@RequestMapping("/v1/api")
public class TokenDecoderController {
    private static final Logger log = LoggerFactory.getLogger(TokenDecoderController.class);

    @Autowired
    TokenDecoderService tokenDecoderService;

    /**
     * Takes a  token as input and returns the decoded token with header and payload information
     * @param jwt
     * @return
     * @throws UnsupportedEncodingException
     */
    @PostMapping(value="/jwtDecode",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> listSpecificHeaders(@Valid @RequestBody String jwt) throws UnsupportedEncodingException {

        log.info("Recieved JWT Token Input: {}",jwt);

        TokenDTO tokenDTO=tokenDecoderService.decodeToken(jwt);

        return new ResponseEntity<>(tokenDTO.toString(), HttpStatus.OK);
    }



}
