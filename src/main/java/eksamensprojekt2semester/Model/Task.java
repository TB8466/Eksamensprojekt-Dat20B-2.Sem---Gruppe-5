package eksamensprojekt2semester.Model;

public class Task {
    private int id;
    private String name;
    private String desc;


    public Task(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public Task(int id,String name, String desc) {
        this.id   = id;
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}