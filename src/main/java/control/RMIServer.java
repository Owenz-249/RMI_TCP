package control;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public RMIServer() {
        try {
            RMIClient rmiClient = new RMIClientImp();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://192.168.1.7:1099/RMIClient", rmiClient);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new RMIServer();
        final String SERVER_IP = "192.168.1.7";
        final int SERVER_PORT = 11001;
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);


        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


        String maSV = "B20DCDT008";
        String hovaten = "Ha Viet Anh";
        String IP = "192.168.1.7";
        int group = 1;
        String rmiName = "RMIClient";
        int rmiPort = 1099;

        dos.writeUTF(maSV);
        dos.writeUTF(hovaten);
        dos.writeUTF(IP);
        dos.writeInt(group);
        dos.writeUTF(rmiName);
        dos.writeInt(rmiPort);
    }
}
