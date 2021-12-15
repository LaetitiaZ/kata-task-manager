import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    public void manage(String operation, String attribute) {
        if(operation.equals("+")) {
            tasks.add(new Task(attribute));
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
