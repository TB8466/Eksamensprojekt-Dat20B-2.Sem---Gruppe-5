package eksamensprojekt2semester.Model;

public class Task {
    private int taskid;
    private String name;
    private String description;
    private double estimatedTime;


    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Task(int taskid,String name, String description, double estimatedTime) {
        this.taskid   = taskid;
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
    }

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