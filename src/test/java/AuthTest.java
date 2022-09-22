import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.Key;
import java.util.Map;



@ExtendWith(MockitoExtension.class)
public class AuthTest {
    private Auth auth;
    //Given
    @BeforeEach
    public void setUp(){
        auth = new Auth();

}
    @ParameterizedTest
    @CsvSource(value = {"Anna, losen, true", "Berit, 123456, false", "Kalle, password, true"})

    public void User(String username, String password, boolean expected) throws WrongPasswordException {

        //When
        boolean result = auth.auth(username, password);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void authThrowException(){
        //Given
        String username = "Berit";
        String errorPassword = "12346";

        //When
         WrongPasswordException error =
                Assertions.assertThrows(WrongPasswordException.class,
                        ()-> auth.auth(username, errorPassword));
        //Then
        Assertions.assertEquals("Error! wrong Password", error.getMessage());
    }
//VG delen ej komplett då jag nöjer mig med G
   /* @Test
    public void JWT(){
        String username = "Berit";
        Key key = Keys.hmacShaKeyFor("aaabbbcccdddNntxmHtekkkkkkAAABBBCCCDDDEEEFFFGGG".getBytes());
        String Token = Jwts.builder()
                .setSubject(username)
                .addClaims(Map.of("Anna", "losen", "Berit", "123456", "Kalle", "password"))
                .signWith(key)
                .compact();
        System.out.println(Token);

    }
    @Test
    public void parseJWT(){
        String Token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCZXJpdCIsIkFubmEiOiJsb3NlbiIsIkJlcml0IjoiMTIzNDU2IiwiS2FsbGUiOiJwYXNzd29yZCJ9.u4zFhvKvou25z-ckETiVlbcZJtNYVB3xmgimt-doRQ4";
        Key key = Keys.hmacShaKeyFor("aaabbbcccdddNntxmHtekkkkkkAAABBBCCCDDDEEEFFFGGG".getBytes());
        String password = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(Token)
                .getBody()
                .get("password", String.class);

        System.out.println(password);
    }*/
}



