public class DataBase {
    private String  path;
    public DataBase() {
        this.path = "jdbc:sqlite:C:\\Users\\ymoha\\IdeaProjects\\Uber\\src\\data.db";
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
