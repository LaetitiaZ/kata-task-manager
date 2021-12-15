public class Parser {

    public String parseOperation(String input) {
        String[] split = input.split("");
        return split[0];
    }

    public Object parseAttribute(String input) {
        return input.substring(2);
    }
}
