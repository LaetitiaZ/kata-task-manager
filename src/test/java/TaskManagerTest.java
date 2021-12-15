import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskManagerTest {

    @Test
    void should_be_able_to_add_task_from_entry() {
        TaskManager manager = new TaskManager();
        manager.manage("+","test test");
        List<Task> tasks = manager.getTasks();

        assertNotNull(tasks.get(0));
    }

}
