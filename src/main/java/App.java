import java.util.function.Function;

public class App {

    public static void main(String[] args) {
        // Passing Behavior
        System.out.println( process("Hello World!", new Processor() {
            @Override
            public String process(String str) {
                return str.toUpperCase();
            }
        }));

        //Lambda Expression
        System.out.println( process("Hello World!", str -> str.toUpperCase()));

        System.out.println( process2("Hello World!", str -> str.toUpperCase()));

        System.out.println( process("Hello World!", String::toUpperCase));

        //String::toLowerCase == str -> str.toLowerCase()
        //String::substring  == (str,i) -> str.substring(i)
        //String::valueOf == number -> String.valueOf(number)
        //String::new == (original) -> new String(original)
        //someString::concat == (someOtherString) -> someString.concat(someOtherString)
    }

    private static String process(String str, Processor processor) {
        return processor.process(str);
    }

    private static String process2(String str, Function<String, String> processor) {
        return processor.apply(str);
    }

}

@FunctionalInterface
interface Processor{
    String process(String str);
}
