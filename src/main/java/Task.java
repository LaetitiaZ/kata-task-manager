public class Task {

    private String description;
    private String status;
    private int id;

    private static int iteration=1;

    public Task(String description) {
        this.description = description;
        this.id = iteration;
        iteration++;
    }

    public int getId() {
        return id;
    }

}
