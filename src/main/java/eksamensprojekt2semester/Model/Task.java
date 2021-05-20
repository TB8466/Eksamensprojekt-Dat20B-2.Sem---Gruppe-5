package eksamensprojekt2semester.Model;

public class Task {
    private int id;
    private String name;
    private String description;


    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Task(int id,String name, String description) {
        this.id   = id;
        this.name = name;
        this.description = description;
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