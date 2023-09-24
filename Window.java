import java.awt.*;

class Window extends Frame{
    Frame f ;
    Button b;
    void create(String a){
        f = new Frame(a);
        f.setSize(200, 200);
    }
    void visible(boolean x){
        f.setVisible(x);
    }
}
