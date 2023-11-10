public class State {
    private String name;
    private String abb;
    public State(String name, String abb) {
        this.name = name;
        this.abb = abb;
    }

//    public boolean equals(String input) {
//        if(input.equals(abb)) {
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
    public String abbreviation() {
        return abb;
    }
    public String toString() {
        return name + " " + abb;
    }

    private int toInteger(char letter)
    {
        return (int) letter - 97;
    }

    @Override
    public int hashCode()
    {
        char firstLetter = abb.charAt( 0 );
        char secondLetter = abb.charAt( 1 );
        return this.toInteger( firstLetter ) * 26 + this.toInteger( secondLetter );
    }

    @Override
    public boolean equals( Object o)
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        State state = (State) o;
        return hashCode() == o.hashCode();
    }
}
