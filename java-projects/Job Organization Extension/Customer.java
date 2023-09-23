import java.util.*;
import javax.swing.*;
import java.io.*;
public class Customer
{
    private String name;
    private String address;
    private String phone;
    public Customer (){
        name = "";
        address = "";
        phone = "";
    }
    public Customer (String tempName, String tempAddress, String tempPhone)throws IOException{
        name = tempName;
        address = tempAddress;
        phone = tempPhone;
        try {
            FileWriter customerWriter = new FileWriter("customers.txt",true);
            customerWriter.write(name + "|" + address + "|" + phone +"|");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
