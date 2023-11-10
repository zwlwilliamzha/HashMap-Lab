public class State {
    private String name;
    private String abb;
    public State(String name, String abb) {
        this.name = name;
        this.abb = abb;
    }

    public boolean equals(String input) {
        if(input.equals(abb)) {
            return true;
        }
        else{
            return false;
        }
    }
    public String abbreviation() {
        return abb;
    }
    public String toString() {
        return name + " " + abb;
    }
}
