package bandeau;

import java.util.LinkedList;
import java.util.List;

class MonThread extends Thread {

    private List<ScenarioElement> myElements = new LinkedList<>();
    private Bandeau b; 

    public MonThread (Bandeau b , List<ScenarioElement> myElements) {
            this.b = b ; 
            this.myElements = myElements; 
    }
    
    public void run(){
        synchronized(b) { 
        for (ScenarioElement element : myElements) {
            for (int repeats = 0; repeats < element.repeats; repeats++) {
                element.effect.playOn(b);
            }
        }
        }
    }
}
