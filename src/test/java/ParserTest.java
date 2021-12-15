import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    void should_be_able_to_parse_adding_task_entry() {
        String input = "+ test";
        Parser parser = new Parser();
        String operation = parser.parse(input);

        assertEquals(operation, "+");
    }

    @Test
    void should_be_able_to_parse_removing_task_entry() {
        String input = "- test";
        Parser parser = new Parser();
        String operation = parser.parse(input);

        assertEquals(operation, "-");
    }

    @Test
    void should_be_able_to_parse_done_task_entry() {
        String input = "x test";
        Parser parser = new Parser();
        String operation = parser.parse(input);

        assertEquals(operation, "x");
    }

    @Test
    void should_be_able_to_parse_todo_task_entry() {
        String input = "o test";
        Parser parser = new Parser();
        String operation = parser.parse(input);

        assertEquals(operation, "o");
    }

}
