public class Task {

    private String description;
    private String status;
    private int id;

    public Task(int id, String description) {
        this.description = description;
        this.id = id;
    }

    public Task(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
