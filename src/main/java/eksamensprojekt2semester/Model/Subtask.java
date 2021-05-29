package eksamensprojekt2semester.Model;

public class Subtask {

    private int id;
    private String name;
    private String description;
    private double estimatedTime;
    private int connectedTask;

    public Subtask(String name, String description, double estimatedTime) {
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
    }

    public Subtask(int id, String name, String description, double estimatedTime) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
    }

    public Subtask(String name, double estimatedTime, int connectedTask) {
        this.name = name;
        this.estimatedTime=estimatedTime;
        this.connectedTask = connectedTask;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description; }

    public double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getConnectedTask() {
        return connectedTask;
    }

    public void setConnectedTask(int connectedTask) {
        this.connectedTask = connectedTask;
    }
}