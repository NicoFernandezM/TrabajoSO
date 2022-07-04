import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            ServerSocket server = new ServerSocket(1234);
            Socket s = server.accept();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());


            while(true) {
                try {
                    MouseCoordinate coord = (MouseCoordinate) in.readObject();

                    System.out.println(coord);
                } catch (IOException e) {
                    System.out.println("Programa finalizado");
                    s.close();
                    in.close();
                    break;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
