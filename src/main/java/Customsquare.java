import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Customsquare extends Rectangle {

    private boolean flag;
    private boolean previous;

    public boolean isPrevious() {
        return previous;
    }

    public void setPrevious(boolean previous) {
        this.previous = previous;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
        if (isFlag())
            this.setFill(Color.YELLOW);
        else
            this.setFill(Color.DARKBLUE);
    }

    public Customsquare(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.setOnMouseEntered(e -> {

            this.setFlag(true);
//            System.out.println(this.isFlag());
        });


    }


    public static Customsquare makesquares(double x, double y, double len) {
        Customsquare cs = new Customsquare(x, y, len, len);
        cs.setFlag(false);
        cs.setPrevious(false);

        return cs;
    }
}
