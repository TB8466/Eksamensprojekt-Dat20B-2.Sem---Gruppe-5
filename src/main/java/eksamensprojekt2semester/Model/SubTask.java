package eksamensprojekt2semester.Model;

public class SubTask {

    private String name;
    private String desc;
    private double estimatedTime;

    public SubTask(String name, String desc, double estimatedTime) {
        this.name = name;
        this.desc = desc;
        this.estimatedTime = estimatedTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}