import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {System.setOut(new PrintStream(outputStreamCaptor));}

    @Test
    void should_be_able_to_add_task_from_entry() {
        TaskManager manager = new TaskManager();
        manager.manage("+", "test test");
        List<Task> tasks = manager.getTasks();

        assertNotNull(tasks.get(0));
    }

    @Test
    void should_add_an_id_when_creating_a_task() {
        TaskManager manager = new TaskManager();
        manager.manage("+", "test");

        assertEquals(1, manager.getTasks().get(0).getId());
    }

    @Test
    void two_tasks_should_not_have_same_id() {
        TaskManager manager = new TaskManager();
        manager.manage("+", "test1");
        manager.manage("+", "test2");

        assertTrue(manager.getTasks().get(0).getId() != manager.getTasks().get(1).getId());
    }

    @Test
    void should_remove_a_task_with_an_id_in_entry() {
        Task task = new Task(1, "description");
        TaskManager manager = new TaskManager(new ArrayList<Task>() {{
            add(task);
        }});
        manager.manage("-", "1");

        assertTrue(manager.getTasks().isEmpty());
    }

    @Test
    void should_set_status_of_a_task_to_done_when_x_operator() {
        Task task = new Task("description");
        TaskManager manager = new TaskManager(new ArrayList<Task>() {{
            add(task);
        }});
        manager.manage("x", "1");

        assertEquals("done", manager.getTasks().get(0).getStatus());
    }

    @Test
    void should_set_status_of_a_task_to_todo_when_o_operator() {
        Task task = new Task("description");
        TaskManager manager = new TaskManager(new ArrayList<Task>() {{
            add(task);
        }});
        manager.manage("o", "1");

        assertEquals("to do", manager.getTasks().get(0).getStatus());
    }

    @Test
    void should_display_task_when_added() {
        TaskManager manager = new TaskManager(IOUtils.toInputStream("+ test"));

        manager.run();
        assertTrue(outputStreamCaptor.toString().contains("1 [ ] test"));
    }

}
