# JWT Decoder Service

## Decode a token

This service is used to decode JWT. 
API takes JWT as input , decoded the encoded JWT and returns header and payload information as String

Please do star the repository if you find this code useful.

### Request

` POST /v1/api/jwtDecode `

### Response

```
    DecodedToken {
    header : '{
    "alg": "HS256",
    "typ": "JWT"
    }',
    payload : '{
    "sub": "1234567890",
    "name": "John Doe",
    "iat": 1516239022
    }',
    } 
```

## Steps to run this application

* Clone the repository
* cd into the folder
* Run the command 
` mvn spring-boot:run `
* Access the api 
```
  curl --location --request POST 'http://localhost:8080/v1/api/jwtDecode' \
  --header 'Content-Type: text/plain' \
  --data-raw 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c' 
  ```

## Steps to run this application as docker container

* ``` docker build -t raje/jwt-decoder-svc . ```


* ``` docker run -p 8080:8080 raje/jwt-decoder-svc ```


* Access the api
```
  curl --location --request POST 'http://localhost:8080/v1/api/jwtDecode' \
  --header 'Content-Type: text/plain' \
  --data-raw 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c' 
  ```

## Steps to run the application without setting up locally

* ```docker run -p 8080:8080 raje/jwt-decoder-svc```


* Access the api
```
  curl --location --request POST 'http://localhost:8080/v1/api/jwtDecode' \
  --header 'Content-Type: text/plain' \
  --data-raw 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c' 
  ```
