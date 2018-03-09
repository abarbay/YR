

public class Project {

    private String name;

    public Project(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Project name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return name != null ? name.equals(project.name) : project.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
