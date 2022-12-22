import java.util.*;
import javax.swing.*;
import java.io.*;
public class Job
{
    private String work;
    private String customer;
    private String date;
    private double profit;
    private double cost;
    private double time;
    private double revenue;
    public Job (){
        work = "";
        customer = "";
        date = "";
        profit = 0;
        time = 0;
        cost = 0;
        revenue = 0;
    }
    public Job (String tempWork, String tempCustomer, String tempDate, double tempProfit, double tempTime, double tempCost){
        work = tempWork;
        customer = tempCustomer;
        date = tempDate;
        profit = tempProfit;
        time = tempTime;
        cost = tempCost;
        revenue = profit-cost; 
        try {
            FileWriter jobWriter = new FileWriter("jobs.txt",true);
            jobWriter.write(work + "|" + date + "|" + profit +"|" + cost + "|" + time + "|" + revenue + "| \n");
            jobWriter.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
