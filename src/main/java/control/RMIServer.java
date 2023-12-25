package control;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public RMIServer() {
        try {
            IRemoteClient iRemoteClient = new IRemoteClientImp();
//            LocateRegistry.createRegistry(1099);
//            Naming.rebind("rmi://192.168.1.7:1099/IRemoteClient", IRemoteClient);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("rmi://192.168.1.7:1099/IRemoteClient", iRemoteClient);
            System.out.println("server is running");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new RMIServer();
        final String SERVER_IP = "192.168.1.7";
        final int SERVER_PORT = 11001;
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String maSV = "B20DCDT008";
        String hovaten = "Ha Viet Anh";
        String IP = "192.168.1.7";
        int group = 1;
        String rmiName = "IRemoteClient";
        int rmiPort = 1099;

        dos.writeUTF(IP);
        dos.writeInt(rmiPort);
        dos.writeUTF(rmiName);

        dos.writeUTF(maSV);
        dos.writeUTF(hovaten);
        dos.writeInt(group);

        System.out.println("success");
    }
}
