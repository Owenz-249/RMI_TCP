package control;

import model.Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IRemoteClientImp extends UnicastRemoteObject implements IRemoteClient {

    private static final long serialVersionUID = 1L;

    protected IRemoteClientImp() throws RemoteException {
    }

    @Override
    public Student getStudent() {
        Student student = new Student("B20DCDT008", "Ha Viet Anh", "192.168.1.7", 5);
        return student;
    }

    @Override
    public int getMax(int a, int b) {
        if(a >= b) return a;
        return b;
    }

    @Override
    public int getUSCLN(int a, int b) {
      while(b != 0) {
          int tmp = a%b;
          a = b;
          b = tmp;
      }
      return a;
    }

    @Override
    public int getBSCNN(int a, int b) {
       return (a * b) / getUSCLN(a, b);
    }

    @Override
    public String getReverse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }


    @Override
    public String getNormalization(String str) {
        String[] st = str.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(String s : st) {
            res.append(s.substring(0, 1).toUpperCase()).append(s.substring(1).toLowerCase()).append(" ");
        }
        return res.toString().trim();
    }
}
