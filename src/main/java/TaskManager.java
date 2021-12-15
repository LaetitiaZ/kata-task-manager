import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    protected TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskManager() {
    }

    public void manage(String operation, String attribute) {
        if(operation.equals("+")) {
            tasks.add(new Task(attribute));
        }
        else if(operation.equals("-")) {
            int id = Integer.parseInt(attribute);
            tasks.remove(id-1);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
