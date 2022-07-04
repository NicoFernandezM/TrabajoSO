import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {


    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Socket s = new Socket("localhost",1234);

            ObjectOutputStream out;

            out = new ObjectOutputStream(s.getOutputStream());
            int segundos = 0;

            while (true) {
                System.out.println("Por favor ingrese los segundos que desea monitorear el mouse.");

                try {
                    String entrada = scanner.nextLine();
                    segundos = Integer.parseInt(entrada);
                }catch (NumberFormatException e) {
                    System.out.println("Por favor ingrese un número");
                    continue;
                }

                if(segundos >= 0) {
                    break;
                }
            }

            segundos *= 18000;

            while(segundos > 0) {
                Point punto= MouseInfo.getPointerInfo().getLocation();
                int x = punto.x;
                int y = punto.y;
                out.writeObject(new MouseCoordinate(x, y));
                segundos--;
            }
            s.close();
            out.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
