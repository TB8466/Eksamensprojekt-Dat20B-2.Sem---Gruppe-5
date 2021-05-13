package eksamensprojekt2semester.Model;

public class Project {
    //Main attributes. Will be used in a resultset in ProjectManager.java
    private int id;
    private String name;
    private String description;

    //Constructor used for building a project object
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getter/Setter methods

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


}
