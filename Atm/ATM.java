import java.sql.SQLException;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ATM_Account atharva = new ATM_Account();
    }
}

class ATM_Account{
    private int balance;
    final private int pin =9356;
    private int tempPin;
    Scanner sc= new Scanner(System.in);

    ATM_Account(){
        this.TakePinInput();
    }

    private void TakePinInput(){
        System.out.println("enter your pin");
        tempPin = sc.nextInt();
//        RemoteConnection.sendData(tempPin);
        this.checkPin(tempPin);
    }

    private void checkPin(int tempPin){
        if(tempPin == pin){
            System.out.println("welcome to the system");
            openServices();
        }
        else {
            System.out.println("Pin is wrong...try again");
            this.TakePinInput();
        }
    }

    private void openServices() {
        System.out.println("Select the Service you want...");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4.Exit");
        int serviceID = sc.nextInt();

        switch(serviceID){
            case 1:
                checkBalance();
                break;
            case 2:
                Deposit();
                break;
            case 3:
                Withdraw();
                break;
            case 4:
                return;
            default:
                System.out.println("Please enter valid choice");
                openServices();
        }
    }

    private void Withdraw() {
        int withdrawAmount;
        System.out.println("enter the money you want to withdraw");
        withdrawAmount = sc.nextInt();
        if(withdrawAmount < 0){
            System.out.println("Enter the valid amount");
            openServices();
            return;
        }
        if(balance < withdrawAmount){
            System.out.println("Available balance is less than money entered");
        }
        else{
            balance = balance - withdrawAmount;
            System.out.println(withdrawAmount + " money has been debited");
        }
        openServices();
    }

    private void Deposit() {
        int depositAmount;
        System.out.println("enter amount to be deposited");
        depositAmount = sc.nextInt();

        if(depositAmount > 0)
        {
            balance = balance + depositAmount;
            System.out.println(depositAmount + " money deposited");
        }
        else
            System.out.println("Enter valid amount");
        openServices();
    }

    private void checkBalance() {
        System.out.println("Avalable balance is " + balance);
        openServices();
    }

}