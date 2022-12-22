import java.util.*;
import javax.swing.*;
import java.io.*;
public class Main 
{
    public static void main(String[] args)throws IOException{ 
        String command;
        Command commandsList = new Command();
        boolean done = false;
            while (!done){
                command = (JOptionPane.showInputDialog("List of commands: \n" +
                    "Customer: Show all customer related commands \n" + "Jobs: Show all job related commands \n" + 
                    "Home: Return to this page \n" + "Done: Exit the program \n").toUpperCase());
                switch (command) {
                    case "HOME": break;
                    case "DONE": done = true; break;
                    case "CUSTOMER": 
                        boolean doneCustomers = false;
                        while (!doneCustomers){
                        command = JOptionPane.showInputDialog(
                        "Available Commands: \n" + "AddCustomers: Add customers \n" + "RemoveCustomers: Remove customers \n" + 
                        "EditCustomer: Edit the details of a customer \n" + "ViewCustomers: View all customer data \n").toUpperCase();
                        
                        switch (command){
                                case "HOME": doneCustomers = true; break;
                                case "DONE": done = true; doneCustomers = true; break;
                                
                                case "ADDCUSTOMERS": 
                                String tempName = JOptionPane.showInputDialog("Name?");
                                String tempAddress = JOptionPane.showInputDialog("Address?");
                                String tempPhone = JOptionPane.showInputDialog("Phone Number?");
                                while (commandsList.addCustomers(tempName, tempAddress, tempPhone)){
                                    tempName = JOptionPane.showInputDialog("Name?");
                                    tempAddress = JOptionPane.showInputDialog("Address?");
                                    tempPhone = JOptionPane.showInputDialog("Phone Number?");
                                }
                                break;
                                
                                case "REMOVECUSTOMERS": 
                                while (commandsList.removeCustomers(JOptionPane.showInputDialog("Name of customer?"))){}
                                break;
                                
                                case "EDITCUSTOMER": 
                                while (commandsList.editCustomer(JOptionPane.showInputDialog("Name of customer?"), JOptionPane.showInputDialog("What detail will be changed? \n Name \n Address \n Phone Number"), JOptionPane.showInputDialog("What will it be changed to?"))){}
                                break;
                                
                                case "VIEWCUSTOMERS": 
                                commandsList.viewCustomers();
                                break;
                                
                                
                        }
                    }
                        break;
                    case "JOBS": 
                        boolean doneJobs = false; 
                        while (!doneJobs){
                        command = JOptionPane.showInputDialog(
                        "Available Commands: \n" + "AddJobs: Add jobs \n" + "DeleteJobs: Delete jobs \n" + "EditJob: Edit the details of a job \n" + "ViewJobs: View all job data \n").toUpperCase();
                        switch (command){
                                case "HOME": doneJobs = true; break;
                                case "DONE": done = true; doneJobs = true; break;
                                
                                case "ADDJOBS": 
                                String tempWork = JOptionPane.showInputDialog("Job Title?");
                                String tempCustomer = JOptionPane.showInputDialog("Who was this job done for?");
                                String tempDate = JOptionPane.showInputDialog("Date preformed? (M/D/YY)");
                                double tempProfit = Integer.parseInt(JOptionPane.showInputDialog("Total profit of the job"));
                                double tempCost = Integer.parseInt(JOptionPane.showInputDialog("Total cost of materials"));
                                double tempTime = Integer.parseInt(JOptionPane.showInputDialog("Time in which the job took (Minutes)"));
                                while (commandsList.addJobs(tempWork, tempCustomer, tempDate, tempProfit, tempCost, tempTime)){}
                                break;
                                
                                case "DELETEJOBS": 
                                while (commandsList.removeJobs(JOptionPane.showInputDialog("Name of job?"))){}
                                break;
                                
                                case "EDITJOB": 
                                while (commandsList.editJob(JOptionPane.showInputDialog("Name of job?"), JOptionPane.showInputDialog("What detail will be changed? \n Job Title \n Customer \n Date \n Profit \n Cost \n Time Taken")
                                ,JOptionPane.showInputDialog("What will it be changed to?"))){}
                                break;
                                
                                case "VIEWJOBS" : 
                                commandsList.viewJobs();
                                break;
                                
                        }
                    }
                    break;
                }
            }
        }
    }