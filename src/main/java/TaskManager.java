import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();

    protected TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskManager() {
    }

    public void manage(String operator, String attribute) {
        Operation operation = Arrays.stream(Operation.values())
                .filter(operation1 -> operation1.getOperator().equals(operator))
                .findFirst()
                .get();
        operation.setManager(this);

        operation.apply(operator, attribute);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
