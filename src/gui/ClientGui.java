package gui;


import java.awt.Color;

import javax.swing.*;

import DataBase.Currencies;
import DataBase.DataBase;


public class ClientGui{

    //Frames
    public static JFrame jfr = new JFrame("asdas");
    
    //Panels
    public static JPanel mainPanel = new JPanel();
    public static JPanel userInfoPanel = new JPanel();
    public static JPanel pageSelectionPanel = new JPanel();
    public static JPanel homePagePanel = new JPanel();
    public static JPanel converterPagePanel = new JPanel();
    public static JPanel authPanel = new JPanel();
    public static JPanel moneyTranferPanel = new JPanel();


    //Labels
    public static JLabel userIconLabel = new JLabel(new ImageIcon("icons/userIcon.png")); //Label using for display profile icon                  
    public static JLabel userNameLabel = new JLabel("Username"); //Label using for display username
    public static JLabel balanceWordLabel = new JLabel("Balance"); //Word "Current Balance"
    public static JLabel currentBalance = new JLabel("Balance");
    public static JLabel authUsernameLabel = new JLabel("Username");
    public static JLabel authPasswordLabel = new JLabel("Password");
    public static JLabel usernameToTransferLabel = new JLabel("Username");
    public static JLabel sumToTransferLabel = new JLabel("Sum");
    public static JLabel authorizationWordLabel = new JLabel("Sign in");
    public static JLabel registrationWordLabel = new JLabel("Sign up");
    public static JLabel currencyConverterWordLabel = new JLabel("Currency converter");
    public static JLabel rubleSymbolLabel = new JLabel("₽");
    public static JLabel dollarSymbolLabel = new JLabel("$");
    public static JLabel euroSymbolLabel = new JLabel("€");



    //Buttons
    public static JButton homePageButton = new JButton(new ImageIcon("icons/homePageIcon.png"));
    public static JButton converterPageButton = new JButton("Converter");
    public static JButton getAuthButton = new JButton("Sign in");
    public static JButton moneyTransferButton = new JButton("Transfer");
    public static JButton moneyTransferConfirmationButton = new JButton("Transfer");
    public static JButton changeSignINToSignUPButton = new JButton("Sign up?");
    public static JButton accountExitButton = new JButton("Exit");
    public static JButton convertCurrencyButton = new JButton("Convert");

    //Text areas
    public static JTextField authUsername = new JTextField(16);
    public static JTextField authPassword = new JTextField(16);
    public static JTextField transferUserToName = new JTextField(16);
    public static JTextField transferMoneyToTransfer = new JTextField(16);
    public static JTextField rublesConverterField = new JTextField(16);
    public static JTextField dollarConverterField = new JTextField(16);
    public static JTextField euroConverterField = new JTextField(16);

    //CheckBoxes
    public static JCheckBox rubleCheckBox = new JCheckBox();
    public static JCheckBox dollarCheckBox = new JCheckBox();
    public static JCheckBox euroCheckBox = new JCheckBox();



    //ActionListeners
    private ButtonsListener ButtonsListener = new ButtonsListener();
    private CloseListener CloseListener = new CloseListener();
    


    //Auth status
    public static Boolean isAuthorized = false;
    public static String authButtonAction = "Get auth";
    
    
    
    


    

    

    public void start(){
        //Frame settings
        jfr.setSize(650,400);
        jfr.setVisible(true);
        DataBase.db.connect();
        DataBase.db.getActualExRate();
        
        jfr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jfr.addWindowListener(CloseListener);
        jfr.setResizable(false);
        jfr.add(mainPanel);

        
        //User panel setting
        mainPanel.setLayout(null);
        mainPanel.add(userInfoPanel);
        mainPanel.add(pageSelectionPanel);
        mainPanel.add(homePagePanel);
        mainPanel.add(converterPagePanel);
        mainPanel.add(authPanel);
        mainPanel.add(moneyTranferPanel);


        //User info panel
        userInfoPanel.setLayout(null);
        userInfoPanel.setBounds(0,0,60,57);
        userInfoPanel.add(userNameLabel);
        userNameLabel.setVisible(true);
        userNameLabel.setBounds(60,18,100,52);
        userNameLabel.setFont(utils.setArialFontSize(15));
        userInfoPanel.add(userIconLabel);
        userIconLabel.setBounds(5,5,48,48);

        //Page selection panel
        pageSelectionPanel.setBounds(0,57,60,340);
        pageSelectionPanel.setLayout(null);
        pageSelectionPanel.add(homePageButton);
        pageSelectionPanel.add(converterPageButton);
        homePageButton.setBounds(5,5,50,50);
        homePageButton.addActionListener(ButtonsListener);
        homePageButton.setActionCommand("Select home page");
        converterPageButton.setBounds(5,65,50,50);
        converterPageButton.addActionListener(ButtonsListener);
        converterPageButton.setActionCommand("Select converter page");



        //Home page panel
        homePagePanel.setLayout(null);
        homePagePanel.setBounds(60,0,590,400);
        homePagePanel.add(balanceWordLabel);
        homePagePanel.add(currentBalance);
        homePagePanel.add(moneyTransferButton);
        homePagePanel.add(accountExitButton);
        homePagePanel.setVisible(false);
        balanceWordLabel.setFont(utils.setArialFontSize(20));
        balanceWordLabel.setBounds(5,10,200,50);
        currentBalance.setBounds(5,50,450,50);
        currentBalance.setFont(utils.setArialFontSize(35));
        currentBalance.setText("2111312312312123123111$");
        moneyTransferButton.setVisible(true);
        moneyTransferButton.setBounds(0,200,100,30);
        moneyTransferButton.setFont(utils.setArialFontSize(15));
        moneyTransferButton.addActionListener(ButtonsListener);
        moneyTransferButton.setActionCommand("MoneyTransfer");
        accountExitButton.setBounds(450,300,100,30);
        accountExitButton.addActionListener(ButtonsListener);
        accountExitButton.setActionCommand("ExitAccount");



        //Converter page panel
        converterPagePanel.setLayout(null);
        converterPagePanel.setBounds(60,0,590,400);
        converterPagePanel.setVisible(false);
        converterPagePanel.add(currencyConverterWordLabel);
        converterPagePanel.add(rublesConverterField);
        converterPagePanel.add(dollarConverterField);
        converterPagePanel.add(euroConverterField);
        converterPagePanel.add(convertCurrencyButton);
        converterPagePanel.add(rubleSymbolLabel);
        converterPagePanel.add(dollarSymbolLabel);
        converterPagePanel.add(euroSymbolLabel);
        converterPagePanel.add(rubleCheckBox);
        converterPagePanel.add(dollarCheckBox);
        converterPagePanel.add(euroCheckBox);
        currencyConverterWordLabel.setBounds(10,10,250,50);
        currencyConverterWordLabel.setFont(utils.setArialFontSize(25));
        rublesConverterField.setBounds(10,100,150,30);
        rublesConverterField.setFont(utils.setArialFontSize(15));
        rublesConverterField.setText("1");
        dollarConverterField.setBounds(10,150,150,30);
        dollarConverterField.setFont(utils.setArialFontSize(15));
        dollarConverterField.setText("" + Currencies.USD);
        euroConverterField.setBounds(10,200,150,30);
        euroConverterField.setFont(utils.setArialFontSize(15));
        euroConverterField.setText("" + Currencies.EUR);
        rubleSymbolLabel.setBounds(170,100,50,30);
        rubleSymbolLabel.setFont(utils.setArialFontSize(20));
        dollarSymbolLabel.setBounds(170,150,50,30);
        dollarSymbolLabel.setFont(utils.setArialFontSize(20));
        euroSymbolLabel.setBounds(170,200,50,30);
        euroSymbolLabel.setFont(utils.setArialFontSize(20));
        convertCurrencyButton.setBounds(10,300,150,60);
        convertCurrencyButton.addActionListener(ButtonsListener);
        convertCurrencyButton.setActionCommand("ConvertCurrencies");
        rubleCheckBox.setBounds(185,105,20,20);




        //Money transfer sub-panel
        moneyTranferPanel.setBounds(60,0,590,400);
        moneyTranferPanel.setVisible(false);
        moneyTranferPanel.setLayout(null);
        moneyTranferPanel.add(transferUserToName);
        moneyTranferPanel.add(transferMoneyToTransfer);
        moneyTranferPanel.add(usernameToTransferLabel);
        moneyTranferPanel.add(sumToTransferLabel);
        moneyTranferPanel.add(moneyTransferConfirmationButton);
        transferUserToName.setBounds(25,25,150,30);
        transferUserToName.setFont(utils.setArialFontSize(15));
        transferMoneyToTransfer.setBounds(25,95,150,30);
        transferMoneyToTransfer.setFont(utils.setArialFontSize(15));
        usernameToTransferLabel.setBounds(25,0,100,30);
        usernameToTransferLabel.setFont(utils.setArialFontSize(15));
        sumToTransferLabel.setBounds(25,70,100,30);
        sumToTransferLabel.setFont(utils.setArialFontSize(15));
        moneyTransferConfirmationButton.setBounds(25,145,100,30);
        moneyTransferConfirmationButton.addActionListener(ButtonsListener);
        moneyTransferConfirmationButton.setActionCommand("MTransferCon");



        //Auth panel
        authPanel.setLayout(null);
        authPanel.setBounds(60,0,590,400);
        authPanel.setVisible(true);
        authPanel.add(authUsername);
        authPanel.add(authUsernameLabel);
        authPanel.add(authPassword);
        authPanel.add(authPasswordLabel);
        authPanel.add(getAuthButton);
        authPanel.add(authorizationWordLabel);
        authPanel.add(registrationWordLabel);
        authPanel.add(changeSignINToSignUPButton);
        authUsernameLabel.setBounds(200,90,100,30);
        authUsernameLabel.setFont(utils.setArialFontSize(15));
        authUsername.setBounds(200,115,150,30);
        authUsername.setFont(utils.setArialFontSize(15));
        authPassword.setBounds(200,185,150,30);
        authPassword.setFont(utils.setArialFontSize(15));
        authPasswordLabel.setBounds(200,160,100,30);
        authPasswordLabel.setFont(utils.setArialFontSize(15));
        getAuthButton.setBounds(200,235,100,30);
        getAuthButton.addActionListener(ButtonsListener);
        getAuthButton.setActionCommand(authButtonAction);
        registrationWordLabel.setVisible(false);
        registrationWordLabel.setBounds(40,20,200,50);
        registrationWordLabel.setFont(utils.setArialFontSize(30));
        authorizationWordLabel.setBounds(40,20,200,50);
        authorizationWordLabel.setFont(utils.setArialFontSize(30));
        changeSignINToSignUPButton.setBounds(400,235,100,30);
        changeSignINToSignUPButton.addActionListener(ButtonsListener);
        changeSignINToSignUPButton.setActionCommand("ChangeAuthButton");





        
        
        

        

        
        
        
        
        
        
        

        




















        //TEMP !!!!!!!!!!!!!!!!!!!!   DELETE AFTER COMPLETION   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        pageSelectionPanel.setBackground(Color.black);
        userInfoPanel.setBackground(Color.red);
        homePagePanel.setBackground(Color.CYAN);
        converterPagePanel.setBackground(Color.CYAN);
        authPanel.setBackground(Color.cyan);


        
    }
    

    public static void main(String[] args) {
        ClientGui gui = new ClientGui();
        gui.start();
        
    }

}
