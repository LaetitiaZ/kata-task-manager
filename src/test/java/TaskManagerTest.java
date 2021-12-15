import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() throws Exception {
        Field iteration = Task.class.getDeclaredField("iteration");
        iteration.setAccessible(true); //to overcome the visibility issue
        iteration.setInt(null, 1); //null since it's static
    }


    @Test
    void should_be_able_to_add_task_from_entry() {
        TaskManager manager = new TaskManager();
        manager.manage("+", "test test");
        List<Task> tasks = manager.getTasks();

        assertNotNull(tasks.get(0));
    }

    @Test
    void should_add_an_id_when_creating_a_task() {
        Task task = new Task("description");

        assertEquals(1, task.getId());
    }

    @Test
    void two_tasks_should_not_have_same_id() {
        Task task = new Task("description");
        Task task2 = new Task("description2");

        assertTrue(task.getId() != task2.getId());
    }

    @Test
    void should_remove_a_task_with_an_id_in_entry() {
        Task task = new Task("description");
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
}
