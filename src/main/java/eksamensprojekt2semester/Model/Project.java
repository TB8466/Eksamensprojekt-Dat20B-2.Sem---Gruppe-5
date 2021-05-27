package eksamensprojekt2semester.Model;

public class Project {
    //Main attributes of a project
    private int id;
    private String name;
    private String description;
    private double estimatedTime;


    //Constructor for building a standard project
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
    //Constructor needed to view a certain project
    public Project(int id, String name, String description, double estimatedTime) {
        this.id=id;
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
        this.description = description;
    }


    @Override
    public String toString() {
        return "Projects: " + name + "Description: " + description;
    }
}