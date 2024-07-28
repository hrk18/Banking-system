/**
 * The last subclass of superclass Bank_card is Credit_card which consist of six attributes. They are cvc_Number, credit_Limit, interest_Rate ,expiration_Date , grace_Period , is_Granted.
    They use integer, double, double, String, integer and Boolean datatype subsequently.  It too has a constructor with eight parameters, six accessor method and a pair of mutator method.
 * 
 * @22066727 Hrithik kumar chorwar
 * @20thjan, 2023.
 */

public class Credit_card extends Bank_card
{  
    //A variable named cvc_Number is created with datatype:int and private accessor modifier.
    private int cvc_Number;
    
    //A variable named credit_Limit is created with datatype:double and private accessor modifier.
    private double credit_Limit;
    
    //A variable named interest_Rate is created with datatype:double and private accessor modifier.
    private double interest_Rate;
    
    //A variable named expiration_Date is created with datatype:String and private accessor modifier.
    private String expiration_Date;
    
    //A variable named grace_Period is created with datatype:int and private accessor modifier.
    private int grace_Period;
    
    //A variable named is_Granted is created with datatype:boolean and private accessor modifier.
    private boolean is_Granted;
    
    /*
     * A constructor has been created with eight parameters card_id,isuuer_bank,bank_account,balance_amount,client_name,cvc_Number,interesr_rate,expiration_Date
      withdatatye:int,String,String,double,String,int,double,string repectively and public accessor modifier.
     */
    public Credit_card(int card_id,String issuer_bank,String bank_account,double balance_amount,String client_name,int cvc_Number,double interest_Rate,String expiration_Date)
    {
        super(card_id,issuer_bank,bank_account,balance_amount);                                 //Superclass constructor is being called with its four parameters.
        super.setClient_name(client_name);                                                      //Supperclass accesor method is being called with its parameter.
        this.cvc_Number = cvc_Number;                                                           //Parameter value is assigned to instance variable
        this.interest_Rate = interest_Rate;                                                    //Parameter value is assigned to instance variable
        this.expiration_Date = expiration_Date;                                               //Parameter value is assigned to instance variable
        this.is_Granted = false;                                                                //value of instance method is set to false
    
    }
    
     /*
      *A accessor method named Cvc_Number with returntype:int is created. 
      */
    public int getCvc_Number()
    {
        return this.cvc_Number;                                         //returns the value
    }
    
     /*
      *An accessor method named Credit_Limit with returntype:double is created. 
      */
    public double getCredit_Limit()
    {
         return this.credit_Limit;                                      //returns the value
    }
    
     /*
      *An accessor method named Interest_Rate with returntype:double is created. 
      */
    public double getInterest_Rate()
    {
        return this.interest_Rate;                                       //returns the value
    }
    
     /*
      *An accessor method named Expiration_Date with returntype:String is created. 
      */
    public String getExpiration_Date()
    {
        return this.expiration_Date;                                    //returns the value
    }
    
     /*
      *An accessor method named Grace_Period with returntype:int is created. 
      */
    public int getGrace_Period()
    {
        return this.grace_Period;                                       //returns the value
    }
    
     /*
      *An accessor method named Is_Granted with returntype:boolean is created. 
      */
    public boolean getIs_Granted()
    {
        return this.is_Granted;                                         //returns the value
    }
     
    /*
      * A mutator method named Credit_Limit with returntype:void and having two parameter is created
      */
    public void setCredit_Limit(double credit_Limit, int grace_Period )
    {
         //if will operate when the conditions meet ,if the condition is not matched else will operate
        if(this.credit_Limit <= 2*super.getBalance_amount())
         { 
            this.credit_Limit = credit_Limit;
            this.grace_Period = grace_Period;
            this.is_Granted = true;
            System.out.println(" congrats ,sir/madam ,Your credit card has been issued sucessfully ");
            
         }
         else
         {
            System.out.println("Sorry sir/madam,we cannot issue your credit card");
         }
    }    
    
    /*
      * A  method named cancelCreditCard with returntype:void is created
      */
    public void cancelCreditCard()
    {
        this.cvc_Number = 0;
        this.credit_Limit = 0;
        this.grace_Period = 0;
        this.is_Granted = false;
    
    }
    
    /*
     * A Display method is created to print the suitable output.
     */
    public void Display()
    {
            super.Display();                                 //A call is being made to superclass Display method

         if (is_Granted == true)
         {
            System.out.println("Your Credit limit is : " + credit_Limit);
            System.out.println("Your grace period is : " + grace_Period);
         }
         else
         {
            System.out.println("Your CVC number is : " + cvc_Number);
            System.out.println("Your interest rate is :"+ interest_Rate);
            System.out.println("Your card expiry date is : "+ expiration_Date);
            System.out.println("Your card is granted : "+ is_Granted);
        
         }
    
    
    }
}
