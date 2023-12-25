package control;

import model.Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClientImp extends UnicastRemoteObject implements RMIClient{
    protected RMIClientImp() throws RemoteException {
    }
    private static final long serialVersionUID = 1L;

    @Override
    public Student getStudent() {
        Student student = new Student("B20DCDT008", "Ha Viet Anh", "192.168.1.7", 5, "Owen", 1099);
        return student;
    }

    @Override
    public int getMax(int a, int b) {
        if(a >= b) return a;
        return b;
    }

    @Override
    public int getUSCLN(int a, int b) {
        while(a != 0) {
            int tmp = a % b;
            a = tmp;
            b = a;
        }
        return a;
    }

    @Override
    public int getBSCNN(int a, int b) {
        long c = a * b;
        int ans = (int) (c / getUSCLN(a, b));
        return ans;
    }

    @Override
    public String getReverse(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.reverse().toString();
    }


    @Override
    public String getNormalization(String str) {
        String []tmp = str.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(String st : tmp) {
            res.append(st.substring(0, 1).toUpperCase()).append(st.substring(1).toLowerCase());
        }
        return res.toString().trim();
    }
}
