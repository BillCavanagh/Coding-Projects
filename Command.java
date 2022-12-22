import java.util.*;
import javax.swing.*;
import java.io.*;
public class Command
{
    private File customers;
    private File jobs;
    public Command()throws IOException{
        try {
            customers = File.createTempFile("customers",".txt");
            if (!customers.exists()){
                customers = new File("customers.txt");
            }
            jobs = File.createTempFile("jobs.txt",".txt");
            if (!jobs.exists()){
                jobs = new File("jobs.txt");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public boolean addCustomers(String tempName, String tempAddress, String tempPhone)throws IOException{
        Customer customer = new Customer(tempName, tempAddress, tempPhone);
        if ("NO".equals(JOptionPane.showInputDialog("Would you like to add another customer? (Type 'no' to exit and anything else to continue)").toUpperCase())){
                return false;
        }
        else {
            return true;
        }
    }
    public boolean removeCustomers(String wantedCustomer) throws IOException{
        try {
            boolean doneTF = false;
            boolean doneRC = false;
            boolean customerFlag = false;
            
            String currentCustomer="";
            String currentCustomerLine;
            String currentTempLine;
            
            File tempFile = new File("tempfile.txt");
            
            FileWriter tempFileWriter = new FileWriter("tempfile.txt",false);
            BufferedReader customerReader = new BufferedReader(new FileReader("customers.txt"));
            
            currentCustomerLine = customerReader.readLine();
            
            while (!doneTF){
                if (currentCustomerLine == null){
                    doneTF = true;
                    continue;
                }
                currentCustomer = currentCustomerLine.substring(0,currentCustomerLine.indexOf("|"));
                if (!((currentCustomer.toUpperCase()).equals((wantedCustomer.toUpperCase())))){
                    tempFileWriter.write(currentCustomerLine + "\n");
                    tempFileWriter.flush();
                }
                currentCustomerLine = customerReader.readLine();
            }
            FileWriter customerFileWriter = new FileWriter("customers.txt",false);
            BufferedReader tempFileReader = new BufferedReader(new FileReader("tempfile.txt"));
            while (!doneRC){
                currentTempLine = tempFileReader.readLine();
                if (currentTempLine == null){
                    doneRC = true;
                    continue;
                }
                customerFileWriter.write(currentTempLine + "\n");
                customerFileWriter.flush();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if ("NO".equals(JOptionPane.showInputDialog("Would you like to remove another customer? (Type 'no' to exit and anything else to continue)").toUpperCase())){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean editCustomer(String wantedCustomer, String change, String newText){
        try {
            boolean doneTF = false;
            boolean doneEC = false;
            boolean customerFlag = false;
            
            String currentCustomer="";
            String currentCustomerLine;
            String currentTempLine;
            String updatedLine;
            File tempFile = new File("tempfile.txt");
            
            FileWriter tempFileWriter = new FileWriter("tempfile.txt",false);
            BufferedReader customerReader = new BufferedReader(new FileReader("customers.txt"));
            
            currentCustomerLine = customerReader.readLine();
            
            while (!doneTF){
                if (currentCustomerLine == null){
                    doneTF = true;
                    continue;
                }
                currentCustomer = currentCustomerLine.substring(0,currentCustomerLine.indexOf("|"));
                if (!((currentCustomer.toUpperCase())).equals((wantedCustomer.toUpperCase()))){
                    tempFileWriter.write(currentCustomerLine + "\n");
                    tempFileWriter.flush();
                }
                else {
                    int first = currentCustomerLine.indexOf("|");
                    int second = currentCustomerLine.substring(first+1).indexOf("|")+first+1;
                    int third = currentCustomerLine.substring(second+1).indexOf("|")+second+1;
                    if ((change.toUpperCase()).equals(("NAME"))){
                        tempFileWriter.write(newText + currentCustomerLine.substring(first) +"\n");
                        tempFileWriter.flush();
                    }
                    else if ((change.toUpperCase()).equals(("ADDRESS"))){
                        updatedLine = currentCustomerLine.substring(0,first+1) + newText;
                        tempFileWriter.write(updatedLine + currentCustomerLine.substring(updatedLine.length())+"\n");
                        tempFileWriter.flush();
                    }
                    else if ((change.toUpperCase()).equals(("PHONE NUMBER"))){
                        updatedLine = currentCustomerLine.substring(0,second+1) + newText;
                        tempFileWriter.write(updatedLine + currentCustomerLine.substring(updatedLine.length())+"\n");
                        tempFileWriter.flush();
                    }
                }
                currentCustomerLine = customerReader.readLine();
            }
            FileWriter customerFileWriter = new FileWriter("customers.txt",false);
            BufferedReader tempFileReader = new BufferedReader(new FileReader("tempfile.txt"));
            while (!doneEC){
                currentTempLine = tempFileReader.readLine();
                if (currentTempLine == null){
                    doneEC = true;
                    continue;
                }
                customerFileWriter.write(currentTempLine + "\n");
                customerFileWriter.flush();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if ("NO".equals(JOptionPane.showInputDialog("Would you like to edit another customer? (Type 'no' to exit and anything else to continue)").toUpperCase())){
            return false;
        }
        else {
            return true;
        }
    }
    public void viewCustomers() throws IOException{
        Boolean doneVC = false;
        int length = 0;
        int count = 0;
        
        BufferedReader customerReaderCheck = new BufferedReader(new FileReader("customers.txt"));
        BufferedReader customerReader = new BufferedReader(new FileReader("customers.txt"));
        String currentCustomerLine = customerReader.readLine();
        
        while (customerReaderCheck.readLine()!=null){
            length++;
        }
        String [][] fullTable = new String[length][3];
        while (!doneVC){
                if (currentCustomerLine == null){
                    doneVC = true;
                    continue;
                }
                
                int first = currentCustomerLine.indexOf("|");
                int second = currentCustomerLine.substring(first+1).indexOf("|")+first+1;
                int third = currentCustomerLine.substring(second+1).indexOf("|")+second+1;
                String [] currentCustomer = new String[3];
                currentCustomer[0] = currentCustomerLine.substring(0,first);
                currentCustomer[1] = currentCustomerLine.substring(first+1,second);
                currentCustomer[2] = currentCustomerLine.substring(second+1,third);
                fullTable [count] = currentCustomer;
                count++;
                currentCustomerLine = customerReader.readLine();
        }
        
        JTable table = new JTable(fullTable, new String[] {"Name", "Address", "Phone Number"});
        JFrame frame = new JFrame("Customers");
        JPanel panel = new JPanel();
        JScrollPane tableContainer = new JScrollPane(table);
        panel.add(tableContainer);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public boolean addJobs(String tempWork, String tempCustomer, String tempDate, double tempProfit, double tempCost, double tempTime){
        Job job = new Job(tempWork, tempCustomer, tempDate, tempProfit, tempCost, tempTime);
        if ("NO".equals(JOptionPane.showInputDialog("Would you like to add another job? (Type 'no' to exit and anything else to continue)").toUpperCase())){
                return false;
        }
        else {
            return true;
        }
    }
    public boolean removeJobs(String wantedJob){
        try {
            boolean doneTF = false;
            boolean doneRJ = false;
            boolean customerFlag = false;
            
            String currentJob="";
            String currentJobLine;
            String currentTempLine;
            
            File tempFile = new File("tempfile.txt");
            
            FileWriter tempFileWriter = new FileWriter("tempfile.txt",false);
            BufferedReader jobReader = new BufferedReader(new FileReader("jobs.txt"));
            
            currentJobLine = jobReader.readLine();
            
            while (!doneTF){
                if (currentJobLine == null){
                    doneTF = true;
                    continue;
                }
                currentJob = currentJobLine.substring(0,currentJobLine.indexOf("|"));
                if (!((currentJob.toUpperCase()).equals((wantedJob.toUpperCase())))){
                    tempFileWriter.write(currentJobLine + "\n");
                    tempFileWriter.flush();
                }
                currentJobLine = jobReader.readLine();
            }
            FileWriter jobsFileWriter = new FileWriter("jobs.txt",false);
            BufferedReader tempFileReader = new BufferedReader(new FileReader("tempfile.txt"));
            while (!doneRJ){
                currentTempLine = tempFileReader.readLine();
                if (currentTempLine == null){
                    doneRJ = true;
                    continue;
                }
                jobsFileWriter.write(currentTempLine + "\n");
                jobsFileWriter.flush();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if ("NO".equals(JOptionPane.showInputDialog("Would you like to remove another job? (Type 'no' to exit and anything else to continue)").toUpperCase())){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean editJob(String wantedJob, String change, String newText){
        try {
            boolean doneTF = false;
            boolean doneEJ = false;
            boolean customerFlag = false;
            
            String currentJob="";
            String currentJobLine;
            String currentTempLine;
            String updatedLine;
            double updatedRevenue;
            File tempFile = new File("tempfile.txt");
            
            FileWriter tempFileWriter = new FileWriter("tempfile.txt",false);
            BufferedReader customerReader = new BufferedReader(new FileReader("jobs.txt"));
            
            currentJobLine = customerReader.readLine();
            
            while (!doneTF){
                if (currentJobLine == null){
                    doneTF = true;
                    continue;
                }
                currentJob = currentJobLine.substring(0,currentJobLine.indexOf("|"));
                if (!((currentJob.toUpperCase())).equals((wantedJob.toUpperCase()))){
                    tempFileWriter.write(currentJobLine + "\n");
                    tempFileWriter.flush();
                }
                else {
                    int first = currentJobLine.indexOf("|");
                    int second = currentJobLine.substring(first+1).indexOf("|")+first+1;
                    int third = currentJobLine.substring(second+1).indexOf("|")+second+1;
                    int fourth = currentJobLine.substring(third+1).indexOf("|")+third+1;
                    int fifth = currentJobLine.substring(fourth+1).indexOf("|")+fourth+1;
                    int sixth = currentJobLine.substring(fifth+1).indexOf("|")+fifth+1;
                    if ((change.toUpperCase()).equals(("WORK"))){
                        tempFileWriter.write(newText + currentJobLine.substring(first) +"\n");
                        tempFileWriter.flush();
                    }
                    else if ((change.toUpperCase()).equals(("CUSTOMER"))){
                        updatedLine = currentJobLine.substring(0,first+1) + newText;
                        tempFileWriter.write(updatedLine + currentJobLine.substring(updatedLine.length())+"\n");
                        tempFileWriter.flush();
                    }
                    else if ((change.toUpperCase()).equals(("DATE"))){
                        updatedLine = currentJobLine.substring(0,second+1) + newText;
                        tempFileWriter.write(updatedLine + currentJobLine.substring(updatedLine.length())+"\n");
                        tempFileWriter.flush();
                    }
                    else if ((change.toUpperCase()).equals(("PROFIT"))){
                        updatedLine = currentJobLine.substring(0,third+1) + newText;
                        updatedRevenue = (Double.parseDouble(newText))-Double.parseDouble(currentJobLine.substring(fourth+1,fifth));
                        tempFileWriter.write(updatedLine + currentJobLine.substring(updatedLine.length(),sixth+1)+ + updatedRevenue + "\n");
                        tempFileWriter.flush();
                    }
                    else if ((change.toUpperCase()).equals(("COST"))){
                        updatedLine = currentJobLine.substring(0,fourth+1) + newText;
                        updatedRevenue = Double.parseDouble(currentJobLine.substring(third+1,fourth))-(Double.parseDouble(newText));
                        tempFileWriter.write(updatedLine + currentJobLine.substring(updatedLine.length(),sixth+1)+ updatedRevenue + "\n");
                        tempFileWriter.flush();
                    }
                    else if ((change.toUpperCase()).equals(("TIME"))){
                        updatedLine = currentJobLine.substring(0,fifth+1) + newText;
                        tempFileWriter.write(updatedLine + currentJobLine.substring(updatedLine.length())+"\n");
                        tempFileWriter.flush();
                    }
                }
                currentJobLine = customerReader.readLine();
            }
            FileWriter customerFileWriter = new FileWriter("jobs.txt",false);
            BufferedReader tempFileReader = new BufferedReader(new FileReader("tempfile.txt"));
            while (!doneEJ){
                currentTempLine = tempFileReader.readLine();
                if (currentTempLine == null){
                    doneEJ = true;
                    continue;
                }
                customerFileWriter.write(currentTempLine + "\n");
                customerFileWriter.flush();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if ("NO".equals(JOptionPane.showInputDialog("Would you like to edit another job? (Type 'no' to exit and anything else to continue)").toUpperCase())){
            return false;
        }
        else {
            return true;
        }
    }
    public void viewJobs() throws IOException{
        Boolean doneVJ = false;
        int length = 0;
        int count = 0;
        
        BufferedReader jobReaderCheck = new BufferedReader(new FileReader("jobs.txt"));
        BufferedReader jobReader = new BufferedReader(new FileReader("jobs.txt"));
        String currentJobLine = jobReader.readLine();
        
        while (jobReaderCheck.readLine()!=null){
            length++;
        }
        String [][] fullTable = new String[length][6];
        while (!doneVJ){
                if (currentJobLine == null){
                    doneVJ = true;
                    continue;
                }
                
                int first = currentJobLine.indexOf("|");
                int second = currentJobLine.substring(first+1).indexOf("|")+first+1;
                int third = currentJobLine.substring(second+1).indexOf("|")+second+1;
                int fourth = currentJobLine.substring(third+1).indexOf("|")+third+1;
                int fifth = currentJobLine.substring(fourth+1).indexOf("|")+fourth+1;
                int sixth = currentJobLine.substring(fifth+1).indexOf("|")+fifth+1;
                int seventh = currentJobLine.substring(sixth+1).indexOf("|")+sixth+1;
                String [] currentCustomer = new String[7];
                currentCustomer[0] = currentJobLine.substring(0,first);
                currentCustomer[1] = currentJobLine.substring(first+1,second);
                currentCustomer[2] = currentJobLine.substring(second+1,third);
                currentCustomer[3] = currentJobLine.substring(third+1,fourth);
                currentCustomer[4] = currentJobLine.substring(fourth+1,fifth);
                currentCustomer[5] = currentJobLine.substring(sixth+1,seventh);
                currentCustomer[6] = currentJobLine.substring(fifth+1,sixth);
                fullTable [count] = currentCustomer;
                count++;
                currentJobLine = jobReader.readLine();
        }
        
        JTable table2 = new JTable(fullTable, new String[] {"Job Title", "Customer", "Date", "Profit", "Cost", "Revenue", "Time"});
        JFrame frame2 = new JFrame("Jobs");
        JPanel panel2 = new JPanel();
        JScrollPane tableContainer2 = new JScrollPane(table2);
        panel2.add(tableContainer2);
        frame2.getContentPane().add(panel2);
        frame2.pack();
        frame2.setVisible(true);
    }
}