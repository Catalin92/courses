import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaExamples {
    public static void main(String[] args) {
        //String::toLowerCase == str -> str.toLowerCase()
        //String::substring  == (str,i) -> str.substring(i)
        //String::valueOf == number -> String.valueOf(number)
        //String::new == (original) -> new String(original)
        //someString::concat == (someOtherString) -> someString.concat(someOtherString)

        String prefix = "Start ";

        System.out.println( process("Hello World!", String::toLowerCase));
        System.out.println( process2("Hello World!",5, String::substring));

        System.out.println( process("Hello World!", prefix::concat));

        String[] names ={"A A", "C C", "B B", "Z C"};

        Arrays.sort(names, Comparator.comparing(name -> name.split(" ")[1]));

        System.out.println(Arrays.toString(names));

    }

    private static String process(String str, Function<String, String> processor) {
        return processor.apply(str);
    }

    private static String process2(String str, int integer, BiFunction<String, Integer, String> processor) {
        return processor.apply(str,integer);
    }


}
