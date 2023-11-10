import javax.swing.DefaultListModel;

public class StateInfo {
    private String StateCapital;
    private int StatePopulation;
    private int StateSize;
    private DLList<String> urls;

    public StateInfo(String StateCapital, int StatePopulation, int StateSize, DLList<String> urls) {
        this.StateCapital = StateCapital;
        this.StatePopulation = StatePopulation;
        this.StateSize = StateSize;
        urls = new DLList<String>();
    } 
    public int getSize() {
        return StateSize;
    }
    public int getPopulation() {
        return StatePopulation;
    }
    public String toString() {
        return StateCapital + " " + getPopulation() + " " + getSize();
    }
    public void addImage(String url){
        urls.add(url);
    }

    public DLList<String> images() {
        return urls;
    }
    
}
