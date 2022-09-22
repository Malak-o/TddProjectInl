import java.util.HashMap;
import java.util.Map;

public class Auth {

    Map<String, String> userMap = new HashMap<>(Map.of(
            "Anna", "losen",
            "Berit", "123456",
            "Kalle", "password"
            ));

    public boolean auth(String username, String password) throws WrongPasswordException {
        if (password == "12346"){
            throw new WrongPasswordException("Error! wrong Password");
        }
        return userMap
                .get(username)
                .equals(password);

    }
}
