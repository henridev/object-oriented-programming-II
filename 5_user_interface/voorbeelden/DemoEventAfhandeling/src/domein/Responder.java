package domein;

interface HelloListener {
    void someoneSaidHello();
}

public class Responder implements HelloListener {
    @Override
    public void someoneSaidHello() {
        System.out.println("Hello there...");
    }
}
