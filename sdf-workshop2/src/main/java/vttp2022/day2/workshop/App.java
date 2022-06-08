package vttp2022.day2.workshop;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My ATM Machine - POSSBank" );
        BankAccount bkAcc = new BankAccount("Abdul Hakim Account");
        
        bkAcc.deposit("1000");
        System.out.println("My new account balance >" +bkAcc.getBalance());
        
        bkAcc.withdraw("100");
        System.out.println("My new account balance >" +bkAcc.getBalance());

        bkAcc.withdraw("500");
        System.out.println("My new account balance >" +bkAcc.getBalance());
    }
}
