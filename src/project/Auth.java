package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Auth {

    static JDialog RegFrame = new JDialog();

    static JPanel AuthPanel(AuthData[] authData, DonorDetails[] donorDetails, int[] users){

        JPanel authPanel = new JPanel();
        authPanel.setBounds(0,0,600,700);
        authPanel.setBackground(Color.gray);
        authPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username ");
        JTextField usernameField = new JTextField();
        usernameLabel.setBounds(140, 80, 80, 25);
        usernameField.setBounds(230, 80, 180, 25);


        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        passwordLabel.setBounds(140, 130, 80, 25);
        passwordField.setBounds(230, 130, 180, 25);


        JButton loginButton = new JButton("Login");
        loginButton.setBounds(160, 180, 100, 30);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(280, 180, 100, 30);


        authPanel.add(usernameLabel);
        authPanel.add(usernameField);

        authPanel.add(passwordLabel);
        authPanel.add(passwordField);

        authPanel.add(loginButton);
        authPanel.add(registerButton);

        RegFrame.add( RegistrationPage.RegistrationPannel( donorDetails, users ) );
        RegFrame.setSize(600,700);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                String[] data = { usernameField.getText(), new String(passwordField.getPassword()) };
                Auth.checkAuth(authData, data, users);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                String[] data = { usernameField.getText(), new String(passwordField.getPassword()) };
                Auth.checkUser(authData, data, users);
            }
        });

        return authPanel;
    }

    static  void checkUser(AuthData[] authData, String[] data, int[] users){

        for( int i = 0; i < users[0]; i++ ){
            if( Objects.equals(authData[i].username, data[0])){
                System.out.println("User Already Exist");
                return;
            }
        }
        authData[users[0]] = new AuthData( data );
        users[0] = users[0] + 1;
        System.out.println("User Successfully Created.");
        RegFrame.setVisible(true);
    }

    static  void checkAuth(AuthData[] authData, String[] data, int[] users){

        for(int i = 0; i < users[0]; i++) {
            if(Objects.equals(authData[i].username, data[0])) {
                if(Objects.equals(authData[i].password, data[1])) {
                    System.out.println("USERNAME AND PASSWORD IS CORRECT");
                    RegFrame.setVisible(true);
                    return;
                }
                else {
                    System.out.println("USERNAME AND PASSWORD IS INCORRECT");
                    return;
                }
            }
        }

        System.out.println("User does not exist");
    }


}
