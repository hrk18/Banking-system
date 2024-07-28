
/**
 * Bank_card class is a parent class in which different variables has been created along with a constructor and five accessor method to return the value.Also,two different mutator is created 
  to assign new value,then there is a  display method to print the output.
 *
 * @ 22066727  Hrithik kumar chorwar
 * @20th jan,2023.
 */
public class Bank_card
{
    //A variable named card_id is created with datatype:int and private accessor modifier.
    private int card_id;
    
    //A variable named client_name is created with datatype:String and private accessor modifier.
    private String client_name;
    
    //A variable named issuer_bank is created with datatype:String and private accessor modifier.
    private String issuer_bank;
    
    //A variable named bank_account is created with datatype:String and private accessor modifier.
    private String bank_account;
    
    //A variable named balance_amount is created with datatype:double and private accessor modifier.
    private double balance_amount;
    
    
    /*
     * A constructor has been created with four parameters card_id,isuuer_bank,bank_account,balance_amount withdatatye:int,String,String,double repectively and public accessor modifier.
     */
    public Bank_card(int card_id,String issuer_bank,String bank_account,double balance_amount)
    {
        this.card_id = card_id;                                                 //Parameter value is assigned to instance variable 
        this.client_name = "";                                                  //instance variable client_name value is assigned empty
        this.issuer_bank = issuer_bank;                                         //Parameter value is assigned to instance variable
        this.bank_account = bank_account;                                       //Parameter value is assigned to instance variable
        this.balance_amount = balance_amount;                                   //Parameter value is assigned to instance variable
    }
    
     /*
      *An accessor method named Card_id with returntype:int is created. 
      */
    public int getCard_id()
    {
        return this.card_id;                                                 //returns the value
    }
    
     /*
      * An accessor method named Client_name with returntype:String is created.
      */
    public String getClient_name()
    {
        return this.client_name;                                                //returns the value
    }
    
     /*
      *An accessor method named Issuer_bank with returntype:String is created. 
      */
    public String getIssuer_bank()
    {
        return this.issuer_bank;                                                 //returns the value
    }
    
     /*
      * An accessor method named Bank_account with returntype:String is created.
      */
    public String getBank_account()
    {
        return this.bank_account;                                                  //returns the value
    }
    
     /*
      * An accessor method named Balance_amount with returntype:double is created.
      */
    public double getBalance_amount()
    {
        return this.balance_amount;                                                 //returns the value  
    }
    
     /*
      * A mutator method named Client_name with returntype:void and having a parameter is created.
      */
    public void setClient_name(String client_name)

    {
        this.client_name=client_name;                                                //sets new value
    }
    
     /*
      * A mutator method named Balance_amount with returntype:void and having a parameter is created
      */
    public void setBalance_amount(double balance_amount)
    {
        this.balance_amount=balance_amount;                                           //sets new value
    }
    
    /*
     * A Display method is created to print the suitable output.
     */
    public void Display()
    {
        
        System.out.println("This is your card id  " + card_id);
        System.out.println("This is your Issuerbank " + issuer_bank);
        System.out.println("This is your Bank account  " + bank_account);
        System.out.println("This is your Balance amount  " + balance_amount);
        
        //if will operate when the conditions meet ,if the condition is not matched else will operate
        if(this.client_name == "")
        {
            System.out.println("please, enter your client name");
        }

        else
        { 
            System.out.println("This is your Client name " + client_name);
        }
    }
}
