import java.util.List;

public enum Operation {

    ADD("+") {
        @Override
        public void apply(String description, String attribute) {
            getTasks().add(new Task(getManager().getIteration(), attribute));
            getManager().incrementIteration();
        }
    },
    REMOVE("-") {
        @Override
        public void apply(String description, String attribute) {
            int id = Integer.parseInt(attribute);
            getTasks().remove(id-1);
        }
    },
    TODO("o") {
        @Override
        public void apply(String description, String attribute) {
            int id = Integer.parseInt(attribute);
            getTasks().get(id-1).setStatus("to do");
        }
    },
    DONE("x") {
        @Override
        public void apply(String description, String attribute) {
            int id = Integer.parseInt(attribute);
            getTasks().get(id-1).setStatus("done");
        }
    };

    private String operator;
    private TaskManager manager;

    Operation(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setManager(TaskManager manager) {
        this.manager = manager;
    }

    public List<Task> getTasks() {
        return manager.getTasks();
    }

    public TaskManager getManager() {
        return manager;
    }

    public abstract void apply(String description, String attribute);
}
