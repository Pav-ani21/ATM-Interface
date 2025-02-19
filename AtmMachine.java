import java.util.*;
import java.lang.*;
public class AtmMachine{
    public static String transfer(String recieverid,Double amount,Double balance,String history){
        if(amount <= balance){
         balance = balance - amount;
         history=history+"Rs."+amount +" tranfered to "+recieverid+" account \n";
         System.out.println("Successfully Rs."+amount +" tranfered from your account to "+recieverid);
         System.out.println("current balance: Rs."+balance); 
        }
        return history;
    }
    public static void functionalities(Scanner input, Double balance, String history, String userid){
        while(true){
            System.out.println("Menu:");
            System.out.println("1.Transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.println("choose one from above");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(history);                  
                    break;
                case 2: 
                    System.out.println("Enter amount to be withdraw :");
                    double withdrawAmount = input.nextDouble();
                    if( balance >= withdrawAmount){
                        balance = balance - withdrawAmount;
                        history=history+"Rs."+withdrawAmount +" withdrawed from your account \n";
                        System.out.println("Successfully Rs."+withdrawAmount +" withdrawed from your account:) !!!");
                        System.out.println("current balance: Rs."+balance);
                    }
                    else{
                        System.out.println("Insufficient balance !!!");
                    }
                    break;
                case 3: 
                    System.out.println("Enter amount to be deposited :");
                    double depositedAmount = input.nextDouble();
                    if(depositedAmount > 0){
                        balance = balance + depositedAmount;
                        history=history+"Rs."+depositedAmount +" depsoited to your account \n";
                        System.out.println("Successfully Rs."+depositedAmount +" deposited to your account :) !!!");
                        System.out.println("current balance: Rs."+balance);
                        break;
                    }
                case 4:
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Enter userid to whom you need to tranfer ammount:");
                    String userid2=sc.nextLine();
                    System.out.println("Enter amount:");
                    Double amount=sc.nextDouble();
                    history=transfer(userid2,amount,balance,history);
                    break;
                case 5:
                    return ;  // exit
                default:
                System.out.println("choose valid option from the given menu !!!");
                    break;
            }
        }
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        HashMap<String, String> map= new HashMap<>();
        HashMap<String, Double> balanceMap= new HashMap<>();
        map.put("8904","987654321");
        map.put("4321","324651780");
        balanceMap.put("8904",8000.00);
        balanceMap.put("4321",3000.00);
        System.out.println("Enter userid:");
        String enteredUserId= input.nextLine();
        System.out.println("Enter password:");
        String enteredpassword= input.nextLine();
        Double bal;
        String history="";
        try{
            if((map.get(enteredpassword)).equals(enteredUserId)){
                // credentials=true;
                bal=balanceMap.get(enteredpassword);
                functionalities(input,bal,history,enteredUserId);
                
            }
            else{
                System.out.println("incorrect credentials");
            }
        }
        catch(Exception NullPointerException){
            System.out.println("incorrect credentials");
        }
    }
}