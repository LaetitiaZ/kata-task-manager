import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    private List<Task> tasks = new ArrayList<>();
    private Scanner scanner;

    private int iteration=1;

    public int getIteration() {
        return iteration;
    }

    public void incrementIteration() {
        this.iteration++;
    }

    protected TaskManager(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskManager(List<Task> tasks, InputStream inputStream) {
        this.tasks = tasks;
        this.scanner = new Scanner(inputStream);
    }

    public TaskManager() {
        this(System.in);
    }

    public TaskManager(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public void manage(String operator, String attribute) {
        Operation operation = Arrays.stream(Operation.values())
                .filter(operation1 -> operation1.getOperator().equals(operator))
                .findFirst()
                .get();
        operation.setManager(this);

        operation.apply(operator, attribute);
    }

    public void displayTasks(){
        for(Task task : this.getTasks()) {
            System.out.println(task);
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }


    public void run() {
        String input = scanner.nextLine();
        while(!input.equals("q")) {
            Parser parser = new Parser();
            manage(parser.parseOperation(input), parser.parseAttribute(input));

            displayTasks();
            if(!scanner.hasNextLine()) {
                break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Closing Task Manager");
    }

}
