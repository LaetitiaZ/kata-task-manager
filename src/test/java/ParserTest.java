import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    void should_be_able_to_parse_adding_task_entry() {
        String input = "+ test";
        Parser parser = new Parser();
        String operation = parser.parseOperation(input);

        assertEquals("+", operation);
    }

    @Test
    void should_be_able_to_parse_removing_task_entry() {
        String input = "- test";
        Parser parser = new Parser();
        String operation = parser.parseOperation(input);

        assertEquals("-", operation);
    }

    @Test
    void should_be_able_to_parse_done_task_entry() {
        String input = "x test";
        Parser parser = new Parser();
        String operation = parser.parseOperation(input);

        assertEquals(operation, "x");
    }

    @Test
    void should_be_able_to_parse_todo_task_entry() {
        String input = "o test";
        Parser parser = new Parser();
        String operation = parser.parseOperation(input);

        assertEquals("o", operation);
    }

    @Test
    void should_be_able_to_parse_attribute_from_entry() {
        String input = "+ test test";
        Parser parser = new Parser();
        String attribute = parser.parseAttribute(input);

        assertEquals("test test", attribute);
    }

}
