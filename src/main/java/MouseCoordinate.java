import java.io.Serializable;

public class MouseCoordinate implements Serializable {
    int x,y;

    public MouseCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String obtenerCoordenadas() {
        String x = String.valueOf(this.x);
        String y = String.valueOf(this.y);
        return x + ", " + y;
    }

    public String toString () {
        return obtenerCoordenadas();
    }
}