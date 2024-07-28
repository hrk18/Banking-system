
/**
 * BankGUI is a class in different JFrames, JPanels,JTextField,JButton are made which work with the help of ActionListener. Any action perfored here is done
 * with the help of GUI. There are four different method in this class, they are form, debitInterface, credit interface  and a main method
 *
 * @Hrithik Kumar Chorwar
 * @May 10,2023
 */
// Importing java GUI packages that are required
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class BankGUI implements ActionListener
{  
    //instace variables of Jframe are declared
    private JFrame frame,frame1,frame2;
    //instace variables of JPanel are declared
    private JPanel panel,panel1, panel2;
    //instace variables of JLabel are declared
    private JLabel title1, title2;
    private JLabel dc_cardID, dc_balanceAmount, dc_bankAccount, dc_withdrawalAmount, dc_issuerBank, dc_clientName, dc_pinNumber, dc_DOW;
    private JLabel cc_cardID, cc_balanceAmount, cc_bankAccount, cc_interestRate, cc_expirationDate, cc_issuerBank, cc_clientName, cc_cvcNumber
            , cc_creditLimit, cc_gracePeriod;
    //instace variables of JButton are declared
    private JButton debitCard, creditCard;
    private JButton btn_switch, btn_add, btn_clear, btn_back, btn_withdraw, btn_display;
    private JButton ccbtn_switch, ccbtn_add, ccbtn_clear, ccbtn_back, ccbtn_SCL, ccbtn_display, ccbtn_cancelCC;
    //instace variables of JTextField are declared
    private JTextField dcfield_cardID, dcfield_balanceAmount, dcfield_bankAccount, dcfield_withdrawalAmount, dcfield_issuerBank
            , dcfield_clientName, dcfield_pinNumber;
    private JTextField ccfield_cardID, ccfield_balanceAmount, ccfield_bankAccount, ccfield_interestRate, ccfield_issuerBank,
            ccfield_cvcNumber, ccfield_creditLimit, ccfield_clientName, ccfield_gracePeriod;
    //instace variables of JComboBox are declared
    private JComboBox dateList, yearList, monthList, dateList1, yearList1, monthList1;
    
    //creating the object of Debit_card class 
    private static Debit_card var,newDebitCard;
    //creating the object of Credit_card class 
    private static Credit_card var1,newCreditCard;
    //instance variables of debit card interface is created
    private String addbank_account;
    private String addissuer_bank;
    private String addclient_name,addpin_number;
    private String addcard_id1;
    private String addbalance_amount;
    private String addwithdraw_Amount1;
    private String withdraw_date;
    //instace variables of Credit card are declared
    private String ccbank_account,ccissuer_bank,ccclient_name;
    private String ccadd_cvc,ccaddcard_id,ccaddbalance_amount;
    private String addcard_idSCL,gracePeriod_SCL,creditLimit_SCL;
    private String addcardID_CCC;
    //Concept of generics
    public ArrayList <Bank_card> ArrayList = new ArrayList<Bank_card>();
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()== debitCard)
        {
            debitInterface();//debitInterface is called
        }
        
        if(e.getSource()==creditCard)
        {
           creditInterface();//creditInterface is called
        }
        
        
        //  Clear button for debit card
        // adding actionListener which clears the entered values of the debit card when clear button is pressed
        if(e.getSource() == btn_clear )
        {
        //textfield.setText is used to clear the text field
        dcfield_cardID.setText("");
        dcfield_balanceAmount.setText("");
        dcfield_bankAccount.setText("");
        dcfield_withdrawalAmount.setText("");
        dcfield_issuerBank.setText("");
        dcfield_clientName.setText("");
        dcfield_pinNumber.setText("");
        }

        //add button --> debit card
        if(e.getSource() == btn_add)
        {
            if(( dcfield_bankAccount.getText().equals("") || dcfield_cardID.getText().equals("") || dcfield_balanceAmount.getText().equals("") 
            || dcfield_issuerBank.getText().equals("") || dcfield_clientName.getText().equals("") || dcfield_pinNumber.getText().equals("")))
            {
            
            JOptionPane.showMessageDialog(panel1,"Please enter all the fields.");
            
            
            }
            else
            {   
                //variablName = textfried.getText();
                addbank_account = dcfield_bankAccount.getText();
                addissuer_bank = dcfield_issuerBank.getText();
                addclient_name = dcfield_clientName.getText(); 
                boolean ISCARDID = true;
                try
                {
                    addpin_number = dcfield_pinNumber.getText();
                    int addpinNumber = Integer.parseInt(addpin_number);//string value is converted to int
                    try{
                            addcard_id1 = dcfield_cardID.getText();
                            int addcardId = Integer.parseInt(addcard_id1);//string value is converted to int
                            try{
                            
                                addbalance_amount = dcfield_balanceAmount.getText();
                                double addbalanceAmount = Double.parseDouble(addbalance_amount);//string value is converted to double
                                //creating a for loop to check wheather entered BankAccount tp existing array list
                                for(Bank_card id1 : ArrayList)
                                {  
                                    if(id1.getCard_id() == (addcardId))
                                    { 
                                        ISCARDID = false;
                                        JOptionPane.showMessageDialog(panel1,"A Debit Card has already been issue with this Card Id","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                
                                if(ISCARDID == true)
                                {
                                    //debit card constructor is called
                                    newDebitCard = new Debit_card(addcardId,addissuer_bank,addbank_account,addbalanceAmount,addpinNumber,addclient_name);
                                    ArrayList.add(newDebitCard);
                                    String dcMsg = "\nCard ID: " + addcard_id1 + "\nBank Name: " + addissuer_bank + "\n Client Name: "+addclient_name +"\nAccount Number: "+addbank_account + "\nBankBalance: " + addbalanceAmount + "\nPin Number: ****" ; 
                                    JOptionPane.showMessageDialog(panel1,"Debit card hass been created successfully" + dcMsg,"Congratulation",JOptionPane.INFORMATION_MESSAGE );
                                    
                                }
                            }
                            catch(NumberFormatException h)
                            {
                                JOptionPane.showMessageDialog(panel1,"please enter the balance amount in double.","error",JOptionPane.INFORMATION_MESSAGE);
                            
                            }
                    }
                    catch(NumberFormatException h)
                    {
                     JOptionPane.showMessageDialog(panel1,"Please,Enter Card id in number","error",JOptionPane.INFORMATION_MESSAGE);   
                    }
                }
                catch(NumberFormatException h)
                {
                    JOptionPane.showMessageDialog(panel1,"Please, Enter Valid pin number only","error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        //credit card add button
        if(e.getSource() == ccbtn_add)
        {
            if(( ccfield_bankAccount.getText().equals("") || ccfield_cardID.getText().equals("") || ccfield_balanceAmount.getText().equals("") 
            || ccfield_issuerBank.getText().equals("") || ccfield_clientName.getText().equals("") || ccfield_cvcNumber.getText().equals("") || ccfield_interestRate.getText().equals("") ))
            {
            
                JOptionPane.showMessageDialog(panel2,"Please, Enter Bank Account, Card ID, Balance Amount, Issuer Bank, Client Name, CVC number");
             
            
            }
            else
            {   
                //variablName = textfried.getText();
                ccbank_account = ccfield_bankAccount.getText();
                ccissuer_bank = ccfield_issuerBank.getText();
                ccclient_name = ccfield_clientName.getText(); 
                boolean ISCARDID1 = true;
                String month1 = monthList1.getSelectedItem().toString();
                String year1 = yearList1.getSelectedItem().toString();
                String day1 = dateList1.getSelectedItem().toString();
            
                String Expiry_date = year1+"-"+month1+"-"+day1;
            
                try
                {
                    ccadd_cvc = ccfield_cvcNumber.getText();
                    int ccaddCvc = Integer.parseInt(ccadd_cvc);//string value is converted to int
                    try{
                            ccaddcard_id = ccfield_cardID.getText();
                            int ccaddcardId = Integer.parseInt(ccaddcard_id);//string value is converted to int
                            try{
                            
                                ccaddbalance_amount = ccfield_balanceAmount.getText();
                                double ccaddbalanceAmount = Double.parseDouble(ccaddbalance_amount);//string value is converted to double
                                String ccaddinterest_rate = ccfield_interestRate.getText();
                                double ccaddinterestRate = Double.parseDouble(ccaddinterest_rate);//string value is converted to double
                                //creating a for loop to check wheather entered value of cardID is existing in the array list
                                for(Bank_card id3 : ArrayList)
                                {   
                                    if(id3.getCard_id() == (ccaddcardId))
                                    { 
                                        ISCARDID1 = false;
                                        JOptionPane.showMessageDialog(panel2,"A credit card has already been issue with this Card Id","Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                if(ISCARDID1 == true)
                                {
                                    //debit card constructor is called
                                    newCreditCard=new Credit_card(ccaddcardId,ccissuer_bank,ccbank_account,ccaddbalanceAmount,ccclient_name,ccaddCvc,ccaddinterestRate,Expiry_date);
                                    ArrayList.add(newCreditCard);
                                    String dcMsg1 = "\nCard ID: " + ccaddcard_id + "\nBank Name: " + ccissuer_bank + "\nClient Name: "+ccclient_name +"\nAccount Number: "+ccbank_account +
                                                    "\nBankBalance: " + ccaddbalanceAmount + "\nCVC Number: " +ccaddCvc +"\nInterest Rate: " + ccaddinterest_rate+ "\nExpiration Date: " + Expiry_date; 
                                    JOptionPane.showMessageDialog(panel2,"Credit card card hass been issued successfully" + dcMsg1,"Congratulation",JOptionPane.INFORMATION_MESSAGE );
                                    
                                }
                            }
                            catch(NumberFormatException h)
                            {
                                JOptionPane.showMessageDialog(panel2,"please enter the balance amount and interset rate in double","error",JOptionPane.INFORMATION_MESSAGE);
                            
                            }
                    }
                    catch(NumberFormatException h)
                    {
                     JOptionPane.showMessageDialog(panel2,"Please,Enter Card id in number","error",JOptionPane.INFORMATION_MESSAGE);   
                    }
                }catch(NumberFormatException h)
                {
                    JOptionPane.showMessageDialog(panel2,"Please, Enter Valid cvc number","error",JOptionPane.INFORMATION_MESSAGE);
                }
            }

        
        }
        
        
     
        //withdraw button debitcard
        if(e.getSource() == btn_withdraw)
        { 
            if((  dcfield_cardID.getText().equals("") || dcfield_withdrawalAmount.getText().equals("") || dcfield_pinNumber.getText().equals("") ))
            {
            
                JOptionPane.showMessageDialog(panel1,"Please, Enter Card id, date of withddrawal and pin number","Error",JOptionPane.ERROR_MESSAGE);
            
            
            }
            
            else
            {
               //variablName = textfried.getText();
                String month = monthList.getSelectedItem().toString();
                String year = yearList.getSelectedItem().toString();
                String day = dateList.getSelectedItem().toString();
                withdraw_date = year+"-"+month+"-"+day;
                int addwithdrawAmount1 = 0;//value of addwithdrawAmount is assugned to 0
            try
            {
                addpin_number = dcfield_pinNumber.getText();
                int addpinNumber1 = Integer.parseInt(addpin_number);//string value is converted to int
                try
                {
                            addcard_id1 = dcfield_cardID.getText();
                            int addcardId1 = Integer.parseInt(addcard_id1);//string value is converted to int
                            try
                            {
                        
                                addwithdraw_Amount1 = dcfield_withdrawalAmount.getText();
                                addwithdrawAmount1 = Integer.parseInt(addwithdraw_Amount1);//string value is converted to int
                                //creating a for loop to check wheather entered value does exist in the array list
                                for(Bank_card id2: ArrayList)
                                {
                                        if(id2 instanceof Debit_card)
                                        {   
                                            var= (Debit_card) id2; //casting of the object
                        
                                            if(var.getCard_id() == addcardId1 )  
                                            {
                                                
                                                if(addpinNumber1 == var.getPin_Number() && addwithdrawAmount1 <= var.getBalance_amount())
                                                {
                                                    //setWithdraw method is called 
                                                    var.setWithdraw(addwithdrawAmount1,withdraw_date,addpinNumber1);
                                                     String dcMsg1 = "\nCard ID: " + addcard_id1 + "\nPin Number: *****" + "\nDate Of Withdrawal: " +
                                                     withdraw_date + "\n Withdrawal Amount:" + addwithdraw_Amount1;
                        
                                                    JOptionPane.showMessageDialog(panel1,"Amount has been withrawan succesfully" +
                                                    dcMsg1,"Successfull",JOptionPane.INFORMATION_MESSAGE );
                                                
                                                    break;
                                                }
                                                else 
                                                {
                                               JOptionPane.showMessageDialog(panel1,"Amount can not be withdrawan" ,"error",JOptionPane.INFORMATION_MESSAGE ); 
                                               break;
                                                }
                                            }
                                            else
                                            {
                                             JOptionPane.showMessageDialog(panel1,"Invalid Card Id" ,"error",JOptionPane.INFORMATION_MESSAGE ); 
                                            break;   
                                            }
                                        }           
                                }
                            }
                            catch(NumberFormatException h)
                            {
                                JOptionPane.showMessageDialog(panel1,"Please, Enter withdrawal amount in number only","error",JOptionPane.INFORMATION_MESSAGE);
                            }
                }
                catch(NumberFormatException h)
                {
                     JOptionPane.showMessageDialog(panel1,"Please, Enter cardid in number only","error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(NumberFormatException h)
            {
                     JOptionPane.showMessageDialog(panel1,"Please, Enter Valid pin number only","error",JOptionPane.INFORMATION_MESSAGE);
            }
            
         }
        }
        
       //display button for debit card
        if(e.getSource()== btn_display)
        {
            if(ArrayList.isEmpty())
            {
                JOptionPane.showMessageDialog(panel1,"The Fields are left empty, please enter the field");   
            }
            else
            {   //creating a for loop to check wheather entered value is existing in the array list
                for(Bank_card newDebitCard: ArrayList)
                    {
                    if(newDebitCard instanceof Debit_card)
                    {
                        System.out.println("\n");
                        Bank_card bc = (Debit_card) newDebitCard;//downcasting of an object
                        bc.Display();//Display method is called
                        double balanceAmntDsply = bc.getBalance_amount();
                        String Balance_display = String.valueOf(balanceAmntDsply);
                        //information dialoge 
                        String display_msg = "\nCard ID: " + addcard_id1 + "\nWithdrawal Amount: " + addwithdraw_Amount1 + "\nDate of Withdrawal: "+withdraw_date
                                                + "\nPin Number: " +addpin_number + "\nBalance Amount: " + Balance_display;
                        JOptionPane.showMessageDialog(panel1,"Debit Card Details" + display_msg);
                    }
                }
            }
        }
        
        //display button for credit card
        if(e.getSource()== ccbtn_display)
        {
            if(ArrayList.isEmpty())
            {
                JOptionPane.showMessageDialog(panel2,"The Fields are left empty, please enter the field");   
            }
            else
            {
                for(Bank_card newCreditCard: ArrayList)
                {
                    if(newCreditCard instanceof Credit_card)
                    {
                        System.out.println("\n");
                        Bank_card cc = (Credit_card) newCreditCard;
                        cc.Display();
                        //information dialogue left to do
                        String display_cc = "\nCard ID: "+ccaddcard_id+ "\nIssuerBank: " +ccissuer_bank + "\nBank Account" +ccbank_account+ "\nCredit Limit: " +creditLimit_SCL+
                    
                        "\nGrace Period: "+gracePeriod_SCL+"\nCvc Number:"+ccadd_cvc+ "\nBalance Amount: " + ccaddbalance_amount;
                        JOptionPane.showMessageDialog(panel2,"Credit Card Details" + display_cc );
                    }
                }
            }
        }
        // button for credit card
       
        //clear button for credit card
        if(e.getSource() == ccbtn_clear )
        {
            ccfield_cardID.setText("");
            ccfield_balanceAmount.setText("");
            ccfield_bankAccount.setText("");
            ccfield_interestRate.setText("");
            ccfield_issuerBank.setText("");
            ccfield_cvcNumber.setText("");
            ccfield_creditLimit.setText("");
            ccfield_clientName.setText("");
            ccfield_gracePeriod.setText("");
        }
         //set credit limit 
         if(e.getSource() == ccbtn_SCL)
         {
            if(ccfield_cardID.getText().equals("") || ccfield_creditLimit.equals("") || ccfield_gracePeriod.equals(""))
            {
             
                JOptionPane.showMessageDialog(panel2,"Please, Enter Card id, Credit limit and Grace Period","Error",JOptionPane.ERROR_MESSAGE);
            
            }
            else
            {
                try
                {
                    addcard_idSCL = ccfield_cardID.getText();
                    int addcardId1SCL = Integer.parseInt(addcard_idSCL);//String value is converted to int
                    gracePeriod_SCL = ccfield_gracePeriod.getText();
                    int gracePeriodSCL = Integer.parseInt(gracePeriod_SCL);//String value is converted to int
                    try
                    {
                         creditLimit_SCL = ccfield_creditLimit.getText();
                         double creditLimitSCl = Double.parseDouble(creditLimit_SCL);//String value is converted to double
                        for(Bank_card id4: ArrayList)
                        {
                                        if(id4 instanceof Credit_card)
                                        {   
                                            Credit_card SCL= (Credit_card) id4; 
                        
                                            if(SCL.getCard_id() == addcardId1SCL )  
                                            {
                                                if(creditLimitSCl<= (SCL.getBalance_amount()*2.5))
                                                {
                                                    SCL.setCredit_Limit(creditLimitSCl,gracePeriodSCL);
                                                    String SCLmsg = "\nCard ID: " + addcard_idSCL + "\nGrace Period: "+ gracePeriod_SCL + "\nCredit Limit: " +  creditLimit_SCL;
                                                    JOptionPane.showMessageDialog(panel2,"Congratulations, Credit limit is set"+SCLmsg ,"Successful",JOptionPane.INFORMATION_MESSAGE);
                                                    break;
                                                }
                                                else 
                                                {
                                                   JOptionPane.showMessageDialog(panel2,"Credit Limit can not be set" ,"error",JOptionPane.ERROR_MESSAGE ); 
                                                   break;
                                                }
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(panel2,"Card Id is invalid" ,"error",JOptionPane.ERROR_MESSAGE ); 
                                                break;
                                                
                                            }
                                        }           
                        }
                        
                    }
                    catch(NumberFormatException h)
                    {
                        JOptionPane.showMessageDialog(panel2,"Please, Enter credit limit in double","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException h)
                {
                     JOptionPane.showMessageDialog(panel2,"Please, Enter card Id, credit limit and grace period ","Error",JOptionPane.ERROR_MESSAGE);
                }            
            }
         }
         //cancel credit card
         if(e.getSource() == ccbtn_cancelCC)
         {
            if(ccfield_cardID.getText().equals("") )
            {
                JOptionPane.showMessageDialog(panel2,"Please, Enter Card id, Credit limit and Grace Period","Error",JOptionPane.ERROR_MESSAGE);
            
            }
            else
            {
                try
                {
                     addcardID_CCC = ccfield_cardID.getText();
                     int addcardIDCCC = Integer.parseInt(addcardID_CCC);////String value is converted to int
                     for(Bank_card id5 : ArrayList)
                     {
                        if(id5 instanceof Credit_card)
                        {
                            Credit_card ccc = (Credit_card) id5; 
                            if(id5.getCard_id() == addcardIDCCC )
                            {
                                ccc.cancelCreditCard();
                                JOptionPane.showMessageDialog(panel2,"Credit card is succesfully cancelled","Successful",JOptionPane.INFORMATION_MESSAGE);
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(panel2,"Card id is invalid","Error",JOptionPane.ERROR_MESSAGE);
                            
                            }
                        
                        }
                        
                     }
                }
                catch(NumberFormatException h)
                {
                    JOptionPane.showMessageDialog(panel2,"Please, Enter Card id","Error",JOptionPane.ERROR_MESSAGE);
                }
            
            
            }
         }
         //go back button of debit card
         if(e.getSource() == btn_back)
         {
             this.form();
             frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame1.dispose();
         }
         
         //switch to debit card
         if(e.getSource() == btn_switch )
         {
             creditInterface();
             frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame1.dispose();
         }
         
         //go back button of credit card
         if(e.getSource() == ccbtn_back)
         {
             this.form();
             frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame2.dispose();
         }
         
         //swith to credit card
         if(e.getSource() == ccbtn_switch )
         {
             debitInterface();
             frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame2.dispose();
         }
         
    } 
    
    public void form()
    {
        //JFrame for Bank GUI
       frame = new JFrame("Bank Of America");
       frame.setBounds(380, 150, 670, 550);
       frame.setResizable(false);
       frame.setLayout(null);
       
       //JPanel for Bank GUI
       panel = new JPanel();
       panel.setBounds(0, 0,670, 530);
       Color fcolor =new Color(195,234,236);
       panel.setBackground(fcolor);
       panel.setLayout(null);
       //Jlabel
       JLabel title0 = new JLabel("Bank of America");
       title0.setBounds(210,60,400,30);
       title0.setFont(new Font("Monospaced", Font.BOLD,30));
       panel.add(title0);
       
       //JButton for Debit Card
       debitCard = new JButton("DEBIT CARD");
       debitCard.setBounds(230,150,200,75);
       debitCard.setFont(new Font("Monospaced", Font.BOLD,22));
       Color dbc = new Color(247,62,100);
       
       debitCard.setBackground(dbc);
       panel.add(debitCard);
       debitCard.addActionListener(this);
        
       //JButton for Credit Card
       creditCard = new JButton("CREDIT CARD");
       creditCard.setBounds(230,240,200,75);
       creditCard.setFont(new Font("Monospaced", Font.BOLD,22));
       Color ccd = new Color(247,80,52);
       creditCard.setBackground(ccd);
       panel.add(creditCard);
       creditCard.addActionListener(this);
       
       //adding to the panel 
       frame.add(panel);
       frame.setVisible(true);
    
    }
        
        
        
        
    public void debitInterface() {
             
        frame1 = new JFrame("Debit Card");
        frame1.setBounds(380, 150, 870, 650);
        frame1.setResizable( false);
        frame1.setLayout( null);
        
        //panel
        panel1 = new JPanel();
        panel1.setBounds(0, 0,870, 630);
        Color debin = new Color(176,218,235);
        panel1.setBackground(debin);
        panel1.setLayout(null);
        //jLabel
        title1 = new JLabel("Debit Card");
        title1.setBounds(350,60,400,30);
        title1.setFont(new Font("Monospaced", Font.BOLD,30));
        panel1.add(title1);

        //Jlabel of card id
        dc_cardID = new JLabel("Card ID");
        dc_cardID.setBounds(40,250,80,30);
        dc_cardID.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel1.add(dc_cardID);
        // TextField of CardID
        dcfield_cardID = new JTextField();
        dcfield_cardID.setBounds(200,250,170,30);
        panel1.add(dcfield_cardID);
        //jlebal for balance amount
        dc_balanceAmount = new JLabel("Balance Amount");
        dc_balanceAmount.setBounds(40,290,150,30);
        dc_balanceAmount.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel1.add(dc_balanceAmount);
        // TextField of balance amount
        dcfield_balanceAmount = new JTextField();
        dcfield_balanceAmount.setBounds(200,290,170,30);
        panel1.add(dcfield_balanceAmount);
        //jlebal for bank account
        dc_bankAccount = new JLabel("Bank Account");
        dc_bankAccount.setBounds(40,330,140,30);
        dc_bankAccount.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel1.add(dc_bankAccount);
        // TextField of bank account
        dcfield_bankAccount = new JTextField();
        dcfield_bankAccount.setBounds(200,330,170,30);
        panel1.add(dcfield_bankAccount);
        //jlebal for withdrawal amount
        dc_withdrawalAmount = new JLabel("Withdrawal Amount");
        dc_withdrawalAmount.setBounds(490,425,150,30);
        dc_withdrawalAmount.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel1.add(dc_withdrawalAmount);
        // TextField of withdrawalAmount
        dcfield_withdrawalAmount = new JTextField();
        dcfield_withdrawalAmount.setBounds(640,430,170,30);
        panel1.add(dcfield_withdrawalAmount);
        //jlebal for Issuer bank
        dc_issuerBank = new JLabel("Issuer Bank");
        dc_issuerBank.setBounds(490,250,140,30);
        dc_issuerBank.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel1.add(dc_issuerBank);
        // TextField of issuer bank
        dcfield_issuerBank = new JTextField();
        dcfield_issuerBank.setBounds(640,250,170,30);
        panel1.add(dcfield_issuerBank);
        //jlebal for client name
        dc_clientName = new JLabel("Client Name");
        dc_clientName.setBounds(490,290,140,30);
        dc_clientName.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel1.add(dc_clientName);
        // TextField client name
        dcfield_clientName = new JTextField();
        dcfield_clientName.setBounds(640,290,170,30);
        panel1.add(dcfield_clientName);
        //jLebal for pin number
        dc_pinNumber = new JLabel("Pin Number");
        dc_pinNumber.setBounds(490,330,140,30);
        dc_pinNumber.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel1.add(dc_pinNumber);
        // TextField pin number
        dcfield_pinNumber = new JTextField();
        dcfield_pinNumber.setBounds(640,330,170,30);
        panel1.add(dcfield_pinNumber);
        //Jlabel for date of withdrawal
        dc_DOW = new JLabel("Date Of Withdrawal");
        dc_DOW.setBounds(40,425,150,30);
        dc_DOW.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel1.add(dc_DOW);
        //combobox for date of withdrawal
        //---------Date-------->>
        String[] date ={"1","2","3","4","5","6","7","8","9","10","12","13","14","15","16"
        ,"17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};
        dateList = new JComboBox(date);
        dateList.setBounds(200,430,50,30);
        panel1.add(dateList);
       
        //---------Month--------->>[
        String[] month ={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct",
           "Nov","Dec"};
        monthList = new JComboBox(month);
        monthList.setBounds(270,430,80,30);
        panel1.add(monthList);
       
        //-------Year---------->>
        String[] year={"2022","2023"};
        yearList = new JComboBox(year);
        yearList.setBounds(370,430,100,30);
        panel1.add(yearList);
        //button to switch to credit card
        btn_switch = new JButton("Switch to Credit Card");
        btn_switch.setBounds(510,150,300,40);
        btn_switch.setFont(new Font("Monospaced", Font.BOLD,20));        
        Color btn1 = new Color(190,240,203);
        btn_switch.setBackground(btn1);
        btn_switch.setForeground(Color.black);
        panel1.add(btn_switch);
        //button add debit card
        btn_add = new JButton("Add Debit Card");
        btn_add.setBounds(300,380,300,40);
        btn_add.setFont(new Font("Monospaced", Font.BOLD,26));
        Color btn22 = new Color(132,210,197);
        btn_add.setBackground(btn22);
        btn_add.setForeground(Color.black);
        panel1.add(btn_add);
        //button go back
        btn_back = new JButton("Go Back");
        btn_back.setBounds(40,150,250,40);
        btn_back.setFont(new Font("Monospaced", Font.BOLD,26));
        btn_back.setBackground(btn1);
        panel1.add(btn_back);
        //button to withdraw
        btn_withdraw = new JButton("Withdraw");
        btn_withdraw.setBounds(40,520,200,40);
        btn_withdraw.setFont(new Font("Monospaced", Font.BOLD,26));
        Color with = new Color(227,172,249);
        btn_withdraw.setBackground(with);
        panel1.add(btn_withdraw);
        //button to display
        btn_display = new JButton("Display");
        btn_display.setBounds(320,520,200,40);
        btn_display.setFont(new Font("Monospaced", Font.BOLD,26));
        btn_display.setBackground(with);
        panel1.add(btn_display);
        //button to clear
        btn_clear = new JButton("Clear");
        btn_clear.setBounds(600,520,200,40);
        btn_clear.setFont(new Font("Monospaced", Font.BOLD,26));
        btn_clear.setBackground(with);
        panel1.add(btn_clear);
        //registering the button 
        btn_clear.addActionListener(this);
        btn_switch.addActionListener(this);
        btn_add.addActionListener(this);
        
        btn_back.addActionListener(this);
        btn_withdraw.addActionListener(this);
        btn_display.addActionListener(this);
        //adding
        frame1.add(panel1);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.dispose();

 
    }
    
    public void creditInterface() {
            
         frame2 = new JFrame("Credit Card");
        frame2.setBounds(380, 150, 870, 650);
        frame2.setResizable( false);
        frame2.setLayout( null);
        
        //panel
        panel2 = new JPanel();
        panel2.setBounds(0, 0,870, 630);
        Color cit = new Color(176,218,235);
        panel2.setBackground(cit);
        panel2.setLayout(null);
        //jLabel
        title2 = new JLabel("Credit Card");
        title2.setBounds(350,60,400,35);
        title2.setFont(new Font("Monospaced", Font.BOLD,30));
        panel2.add(title2);
        //Jlabel of card id
        cc_cardID = new JLabel("Card ID");
        cc_cardID.setBounds(40,210,80,30);
        cc_cardID.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_cardID);
        // TextField of CardID
        ccfield_cardID = new JTextField();
        ccfield_cardID.setBounds(200,210,170,30);
        panel2.add(ccfield_cardID);
        //jlebal for balance amount
        cc_balanceAmount = new JLabel("Balance Amount");
        cc_balanceAmount.setBounds(40,250,150,30);
        cc_balanceAmount.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_balanceAmount);
        // TextField of balance amount
        ccfield_balanceAmount = new JTextField();
        ccfield_balanceAmount.setBounds(200,250,170,30);
        panel2.add(ccfield_balanceAmount);
        //jlebal for bank account
        cc_bankAccount = new JLabel("Bank Account");
        cc_bankAccount.setBounds(40,290,140,30);
        cc_bankAccount.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_bankAccount);
        // TextField of bank account
        ccfield_bankAccount = new JTextField();
        ccfield_bankAccount.setBounds(200,290,170,30);
        panel2.add(ccfield_bankAccount);
        
        //jlebal for Interest Rate
        cc_interestRate = new JLabel("Interest Rate");
        cc_interestRate.setBounds(40,330,150,30);
        cc_interestRate.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_interestRate);
        // TextField of withdrawalAmount
        ccfield_interestRate = new JTextField();
        ccfield_interestRate.setBounds(200,330,170,30);
        panel2.add(ccfield_interestRate);
        //jlebal for credit limit
        cc_creditLimit = new JLabel("Credit Limit");
        cc_creditLimit.setBounds(490,420,150,30);
        cc_creditLimit.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_creditLimit);
        // TextField of creditLimit
        ccfield_creditLimit = new JTextField();
        ccfield_creditLimit.setBounds(640,420,170,30);
        panel2.add(ccfield_creditLimit);
        //jlebal for Issuer bank
        cc_issuerBank = new JLabel("Issuer Bank");
        cc_issuerBank.setBounds(490,210,140,30);
        cc_issuerBank.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_issuerBank);
        // TextField of issuer bank
        ccfield_issuerBank = new JTextField();
        ccfield_issuerBank.setBounds(640,210,170,30);
        panel2.add(ccfield_issuerBank);
        //jlebal for client name
        cc_clientName = new JLabel("Client Name");
        cc_clientName.setBounds(490,250,140,30);
        cc_clientName.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_clientName);
        // TextField client name
        ccfield_clientName = new JTextField();
        ccfield_clientName.setBounds(640,250,170,30);
        panel2.add(ccfield_clientName);
        //jLebal for CVC number
        cc_cvcNumber = new JLabel("CVC Number");
        cc_cvcNumber.setBounds(490,290,140,30);
        cc_cvcNumber.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_cvcNumber);
        // TextField cvc number
        ccfield_cvcNumber = new JTextField();
        ccfield_cvcNumber.setBounds(640,290,170,30);
        panel2.add(ccfield_cvcNumber);
        //jLebal for grace Period
        cc_gracePeriod = new JLabel("Grace period");
        cc_gracePeriod.setBounds(40,420,150,30);
        cc_gracePeriod.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_gracePeriod);
        // TextField grace Period
        ccfield_gracePeriod = new JTextField();
        ccfield_gracePeriod.setBounds(200,420,170,30);
        panel2.add(ccfield_gracePeriod);
         //Jlabel for date of withdrawal
        cc_expirationDate = new JLabel("Date Of Expiry");
        cc_expirationDate.setBounds(490,330,140,30); 
        cc_expirationDate.setFont(new Font("TimesRoman", Font.BOLD,16));
        panel2.add(cc_expirationDate);
        //combobox for date of withdrawal
        //---------Date-------->>
        String[] date1 ={"1","2","3","4","5","6","7","8","9","10","12","13","14","15","16"
        ,"17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};
        dateList1 = new JComboBox(date1);
        dateList1.setBounds(640,330,40,30);
        panel2.add(dateList1);
       
        //---------Month--------->>[
        String[] month1 ={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct",
           "Nov","Dec"};
        monthList1 = new JComboBox(month1);
        monthList1.setBounds(690,330,50,30);
        panel2.add(monthList1);
       
        //-------Year---------->>
        String[] year1={"2022","2023"};
        yearList1 = new JComboBox(year1);
        yearList1.setBounds(750,330,60,30);
        panel2.add(yearList1);
        //button to switch to credit card
        ccbtn_switch = new JButton("Switch to Debit Card");
        ccbtn_switch.setBounds(510,150,300,40);
        ccbtn_switch.setFont(new Font("Monospaced", Font.BOLD,20));        
        Color sic = new Color(190,240,203);
        ccbtn_switch.setBackground(sic);
        ccbtn_switch.setForeground(Color.black);
        panel2.add(ccbtn_switch);
        //button add creditcard
        ccbtn_add = new JButton("Add Credit Card");
        ccbtn_add.setBounds(270,370,300,40);
        ccbtn_add.setFont(new Font("Monospaced", Font.BOLD,20));
        Color btn222 = new Color(56,229,77);
        ccbtn_add.setBackground(btn222);
        ccbtn_add.setForeground(Color.black);
        panel2.add(ccbtn_add);
        //button go back
        ccbtn_back = new JButton("Go Back");
        ccbtn_back.setBounds(40,150,250,40);
        ccbtn_back.setFont(new Font("Monospaced", Font.BOLD,26));
        ccbtn_back.setBackground(sic);
        panel2.add(ccbtn_back);
        //button to set credit limit
        ccbtn_SCL = new JButton("Set Credit Limit");
        ccbtn_SCL.setBounds(40,550,200,40);
        ccbtn_SCL.setFont(new Font("Monospaced", Font.BOLD,16));
        Color scl = new Color(234,4,126);
        ccbtn_SCL.setBackground(scl);
        panel2.add(ccbtn_SCL);
        //button to display
        ccbtn_display = new JButton("Display");
        ccbtn_display.setBounds(320,550,200,40);
        ccbtn_display.setFont(new Font("Monospaced", Font.BOLD,26));
        ccbtn_display.setBackground(scl);
        panel2.add(ccbtn_display);
        //button to clear
        ccbtn_clear = new JButton("Clear");
        ccbtn_clear.setBounds(600,550,200,40);
        ccbtn_clear.setFont(new Font("Monospaced", Font.BOLD,26));
        ccbtn_clear.setBackground(scl);
        panel2.add(ccbtn_clear);
        //button to cancel credit card
        
        ccbtn_cancelCC = new JButton("Cancel Credit Card");
        ccbtn_cancelCC.setBounds(270,475,300,40);
        ccbtn_cancelCC.setFont(new Font("Monospaced", Font.BOLD,20));
        Color icc = new Color(255,30,30);
        ccbtn_cancelCC.setBackground(icc);
        panel2.add(ccbtn_cancelCC);
        //registering the button 
        ccbtn_clear.addActionListener(this);
        ccbtn_switch.addActionListener(this);
        ccbtn_add.addActionListener(this);
        ccbtn_back.addActionListener(this);
        ccbtn_SCL.addActionListener(this);
        ccbtn_display.addActionListener(this);
        ccbtn_cancelCC.addActionListener(this);
        
            //adding
        frame2.add(panel2);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.dispose();
    }
    //main method
    public static void main(String[] args)
    {
    
        BankGUI hrk = new BankGUI();//object of BankGUI class is made
        hrk.form();
    }
}
