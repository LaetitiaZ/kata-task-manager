import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

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

        assertEquals(task.getId(), 1);
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
        List<Task> initialTasks = new ArrayList<>();
        initialTasks.add(task);
        TaskManager manager = new TaskManager( initialTasks);
        manager.manage("-", "1");

        assertTrue(manager.getTasks().isEmpty());
    }
}
