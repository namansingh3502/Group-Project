package project;

import javax.lang.model.element.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage {

    static JPanel RegistrationPannel(DonorDetails[] donorDetails, int[] users){

        JPanel RegPanel = new JPanel();
        RegPanel.setBounds(0,0,600,700);
        RegPanel.setBackground(Color.gray);
        RegPanel.setLayout(null);

        JLabel nameLabel = new JLabel("Name ");
        JTextField nameField = new JTextField();
        nameLabel.setBounds(60, 40, 50, 25 );
        nameField.setBounds(160, 40, 200, 25 );

        JLabel ageLabel = new JLabel("Age");
        JTextField ageField = new JTextField();
        ageLabel.setBounds(60, 80, 50, 25 );
        ageField.setBounds(160, 80, 200, 25 );


        JLabel bloodgroupLabel = new JLabel("Blood-Group ");
        JTextField bloodGroupField = new JTextField();
        bloodgroupLabel.setBounds(60, 120,100,25);
        bloodGroupField.setBounds(160, 120,200,25);

        JLabel mobileNoLabel = new JLabel("Mobile No. ");
        JTextField mobileNoField = new JTextField();
        mobileNoLabel.setBounds(60,160, 100, 25 );
        mobileNoField.setBounds(160,160, 200, 25 );

        JLabel cityLabel = new JLabel("City");
        JTextField cityField = new JTextField();
        cityLabel.setBounds(60, 200,100, 25 );
        cityField.setBounds(160, 200,200, 25 );

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(160, 250, 100, 25);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                String[] data = {
                        nameField.getText(),
                        ageField.getText(),
                        bloodGroupField.getText(),
                        cityField.getText(),
                        mobileNoField.getText(),
                };

                donorDetails[users[1]] = new DonorDetails( data );
                users[1] = users[1] + 1;
                System.out.println("Donor Successfully Created.");
            }
        });

        RegPanel.add(submitButton);

        RegPanel.add(nameLabel);
        RegPanel.add(nameField);

        RegPanel.add(ageLabel);
        RegPanel.add(ageField);

        RegPanel.add(bloodgroupLabel);
        RegPanel.add(bloodGroupField);

        RegPanel.add(mobileNoLabel);
        RegPanel.add(mobileNoField);

        RegPanel.add(cityLabel);
        RegPanel.add(cityField);

        return RegPanel;
    }


}
