package eksamensprojekt2semester.Model;

public class Task {
    //Main attributes of a project
    private int taskid;
    private String name;
    private String description;
    private double estimatedTime;

    //Constructor for creation of a task
    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }
    //Constructor for getting tasks connected to a specific project
    public Task(int taskid,String name, String description, double estimatedTime) {
        this.taskid   = taskid;
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
    }

    // Getter/Setter methods

    public double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}