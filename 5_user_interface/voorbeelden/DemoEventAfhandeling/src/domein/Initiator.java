package domein;

import java.util.ArrayList;
import java.util.List;

public class Initiator {
    private List<HelloListener> listeners = new ArrayList<HelloListener>();

    public void addListener(HelloListener listener) {
        listeners.add(listener);
        for (HelloListener hl : listeners){
            hl.someoneSaidHello();
        }
    }

    public void sayHello() {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (HelloListener hl : listeners)
            hl.someoneSaidHello();
    }
}
