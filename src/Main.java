import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert password: ");

        String pwd = scanner.nextLine();
        boolean valid = true;

        if (pwd.length()<6) {
            System.out.println("Parola trebuie sa aiba cel putin 6 caractere");
            valid = false;
        }


/*
        if (!Pattern.matches(".*[a-z].*", pwd)) {
            System.out.println("Parola trebuie sa aiba cel putin o litera mica");
            valid=false;
        }
        if (!Pattern.matches(".*[A-Z].*", pwd)) {
            System.out.println("Parola trebuie sa aiba cel putin o litera mare");
            valid=false;
        }
        if (!Pattern.matches(".*\\d.*", pwd)) {
            System.out.println("Parola trebuie sa aiba cel putin o cifra");
            valid=false;
        }

 */

        boolean hasLowerCase = isValid(".*[a-z].*",pwd,"Parola trebuie sa aiba cel putin o litera mica");
        boolean hasUpperCase = isValid(".*[A-Z].*",pwd,"Parola trebuie sa aiba cel putin o litera mare");
        boolean hasDigit = isValid(".*\\d.*",pwd,"Parola trebuie sa aiba cel putin o cifra");

        valid = valid && hasLowerCase && hasUpperCase && hasDigit;

        System.out.println(valid ? "Parola a fost acceptata" : "Parola incorecta. Incercati din nou.");


        /*
        for (String a:pwd){
            if (Pattern.matches("^(?=.{10,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?\W).*$", a) && pwd.length<=6)
                System.out.println("OK");
        } else System.out.println("Not OK");
         */


    }

    private static boolean isValid (String regex, String pwd, String message) {
        if (Pattern.matches(regex, pwd)) {
            return true;
        }
        System.out.println(message);
        return false;
    }
}
