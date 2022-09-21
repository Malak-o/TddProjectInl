import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest {
    private Auth auth;
    //Given
    @BeforeEach
    public void serUp(){
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
        String password = "12346";

        //When
        ArithmeticException error =
                Assertions.assertThrows(ArithmeticException.class,
                        ()-> auth.auth(username, password));
        //Then
        Assertions.assertEquals("Error! Wrong Password", error.getMessage());
    }
}



