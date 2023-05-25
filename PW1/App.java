import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

   public static Predicate<String> testPin = pin -> {
      Pattern pattern = Pattern.compile("^(([0-9]{4})|([0-9]{6}))$");
      Matcher matcher = pattern.matcher(pin);

      return matcher.find(0);
   };

   public static void main(String[] args) {
      System.out.println(testPin.test("Hello"));
      System.out.println(testPin.test("1234667"));
      System.out.println(testPin.test("123466"));
      System.out.println(testPin.test("1234"));
   }
}
