// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            authorize("4234_+ewewWE", "342rfds_+", "342rfds_+");
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void authorize(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        final String validPattern = "[A-Za-z0-9_]+";

        boolean isValidLogin = login.matches(validPattern) || login.length() > 20;
        boolean isValidPass = password.matches(validPattern) || password.length() > 20;

        if(!isValidLogin) {
            throw new WrongLoginException("Логин содежрит больше 20 символоы или не валидные символы ");
        }
        if(!isValidPass || !confirmPassword.equals(password)) {
            throw new WrongPasswordException("Не верный пароль или пароль содержит не валидные символы");
        }
    }
}