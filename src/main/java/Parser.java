public class Parser {

    public String parseOperation(String input) {
        String[] split = input.split("");
        return split[0];
    }

    public String parseAttribute(String input) {
        return input.substring(2);
    }


}
