package project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Home extends JFrame implements ActionListener{
    boolean isAtHome=true, isLoggedIn=false;
    JPanel mainPanel = new JPanel();
    CardLayout layout = new CardLayout();
    JMenuItem crud, home;
    JPanel HomePanel, AuthPanel;

    AuthData[] authData = new AuthData[10];
    DonorDetails[] donorDetails = new DonorDetails[10];
    int[] users = {5, 5};

    public Home(){
        createDonor();
        createUser();

        setTitle("Blood Bank Management System");

        setSize(600, 700 );

        JMenuBar menuBar = new JMenuBar();

        home = new JMenuItem("Home");
        crud = new JMenuItem("Login/Register");

        menuBar.add(home);
        menuBar.add(crud);

        home.addActionListener(this);
        crud.addActionListener(this);

        setJMenuBar(menuBar);

        mainPanel.setLayout( layout ) ;

        HomePanel = HomePage.homePanel( donorDetails, users );
        AuthPanel = Auth.AuthPanel(authData, donorDetails, users);

        mainPanel.add(HomePanel, "1");
        mainPanel.add(AuthPanel, "2");
        layout.show(mainPanel, "1");

        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void createDonor(){

        String[][] data = {
                {"user1","12","b","city1","32435" },
                {"user2","1243","b","city1","32435" },
                {"user3","342","b","city1","32435" },
                {"user4","131","b","city1","32435" },
                {"user5","121","b","city1","32435" },
        };

        for( int i = 0; i < 5; i++ ){
            donorDetails[i] = new DonorDetails(data[i]);
        }
    }
    void createUser(){

        String[][] data = {
                {"user1","password" },
                {"user2","password" },
                {"user3","password" },
                {"user4","password" },
                {"user5","password" },
        };

        for( int i = 0; i < 5; i++ ){
            authData[i] = new AuthData(data[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if( source == home ){
            showSpecifiedPanel( HomePanel  );
        }
        else if( source == crud ){
            showSpecifiedPanel( AuthPanel );
        }
    }

    public void showSpecifiedPanel( JPanel showPanel) {
        mainPanel.removeAll();
        mainPanel.add(showPanel);
        mainPanel.validate();
        mainPanel.repaint();
    }
}


public class BloodBank {

    public static void main( String[] args ) {
        new Home();
    }
}
