/**
 *The Debit_card class is subclass of Bank_card class.It has four attributes named as pin_Number, withdrawal_Amount, date_Of_Withdrawal,has_Withdrawn and they are represented as integral number,
     number, String of text,Boolean correspondingly. There is a constructor as well with six parameters.It has a total of four accessor method, a couple of mutator method and a display method.
 * 
 * @22066727 Hrithik kumar chorwar 
 * @20th jan,2023
 */
public class Debit_card extends Bank_card
{
    //A variable named pin_number is created with datatype:int and private accessor modifier.
    private int pin_Number;
    
    //A variable named withdrawal_Amount is created with datatype:int and private accessor modifier.
    private int withdrawal_Amount;
    
    //A variable named date_Of_Withdrawal is created with datatype:String and private accessor modifier.
    private String date_Of_Withdrawal;
    
    //A variable named has_Withdrawn is created with datatype:boolean and private accessor modifier.
    private boolean has_Withdrawn;
    
    /*
     * A constructor has been created with six parameters card_id,isuuer_bank,bank_account,balance_amount,pin_number,client_name withdatatye:int,String,String,double,int,String
         repectively and public accessor modifier.
     */
    public Debit_card(int card_id,String issuer_bank,String bank_account,double balance_amount,int pin_number,String client_name)
    {
        super(card_id,issuer_bank,bank_account,balance_amount);                  //Superclass constructor is being called with its four parameters.
        super.setClient_name(client_name);                                       //Supperclass accesor method is being called with its parameter.
        this.pin_Number = pin_number;                                           //Parameter value is assigned to instance variable
        this.has_Withdrawn = false;                                             //Parameter value is assigned to instance variable
    }
        
    /*
     * An accessor method named Pin_number with returntype:int is created.
     */
    public int getPin_Number()
    {
        return this.pin_Number;                                                 //returns the value
    }
    
    
    /*
     * An accessor method named Withdrawal_Amount with returntype:int is created.
     */
    public int getWithdrawal_Amount()
    {
        return this.withdrawal_Amount;                                             //returns the value
    }
    
    /*
     * An accessor method named Date_Of_Withdrawal with returntype:String is created.
     */
    public String getDate_Of_Withdrawal()
    {
        return this.date_Of_Withdrawal;                                             //returns the value
    }
    
    /*
     * An accessor method named Has_Withdrawn with returntype:boolean is created.
     */
    public boolean getHas_Withdrawn()
    {
        return this.has_Withdrawn;                                                  //returns the value
    }
    
     /*
      * A mutator method named Withdrawal_Amount with returntype:void and having a parameter is created
      */
    public void setWithdrawal_Amount(int withdrawal_Amount)
    {
        this.withdrawal_Amount=withdrawal_Amount;                                   //sets new value
    }
    
     /*
      * A mutator method named Withdraw with returntype:void and having three parameter is created
      */
    public void setWithdraw(int withdrawal_Amount,String date_Of_Withdrawal,int pin_Number)
    {
        ////if will operate when the conditions meet ,if the condition is not matched else will operate
        if (this.pin_Number == pin_Number && withdrawal_Amount <= getBalance_amount())
        { 
         this.has_Withdrawn = true;
         this.setBalance_amount(this.getBalance_amount()- withdrawal_Amount);
         this.withdrawal_Amount = withdrawal_Amount;
         this.date_Of_Withdrawal = date_Of_Withdrawal;
         
         
         System.out.println("Your transcation is completed !");
         System.out.println(withdrawal_Amount + " has been withdrawan from your account !");
         System.out.println("Your current balance is : " + super.getBalance_amount());                          //super class accessor method is called
         System.out.println("Date of transcation :" + this.getDate_Of_Withdrawal());
         
          
         
        }
     
        else
        {
            System.out.println("Either your pin number is incorrect or withdrawal amount is insufficient");
        }
    
    }
    
    /*
     * A Display method is created to print the suitable output.
     */
    public void Display()
    {
        super.Display();                                        //A call is being made to superclass Display method
        if(has_Withdrawn == true)
        {
        System.out.println("This is your pin number " + pin_Number );
        System.out.println("This is your Withdrawal amount " + withdrawal_Amount );
        System.out.println("Date of withdrawal : " + date_Of_Withdrawal );
        }
        else
        {
            System.out.println("your balance amount is " + getBalance_amount());
        }
    
    }
}
