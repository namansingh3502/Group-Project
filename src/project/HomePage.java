package project;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {

   static Object[] donor = new Object[5];
   static DefaultTableModel model;

      static JPanel homePanel(DonorDetails[] donorList, int[] users ) {
         JPanel homePanel = new JPanel();

         homePanel.setBounds(0,0,600,680);
         homePanel.setBackground(Color.gray);

         /*JLabel city = new JLabel("City ");
         city.setBounds(20, 10,40,25);
         JTextField cityName = new JTextField();
         cityName.setBounds(65, 10,100,25);

         JLabel bloodgroupLabel = new JLabel("Blood-Group ");
         bloodgroupLabel.setBounds(200, 10,800,25);
         String[] country = { "India", "Aus", "U.S.A", "England", "Newzealand" };
         JComboBox<String> bloodGroupList = new JComboBox<>(country);
         bloodGroupList.setBounds(300, 10,100,25);

         JButton submit = new JButton("Submit");
         submit.setBounds(420, 10, 100, 25);

         homePanel.add(city);
         homePanel.add(cityName);

         homePanel.add(bloodgroupLabel);
         homePanel.add(bloodGroupList);
         homePanel.add(submit);

          */

         JButton refresh = new JButton("Refresh");
         refresh.setBounds(20,20,100,30);
         homePanel.add(refresh);

         JTable table = new JTable();

         String[] header = { "Name", "Age", "Blood-Type", "City", "Phone" };
         model = new DefaultTableModel();
         model.setColumnIdentifiers(header);
         table.setModel(model);

         updateRow( donorList, users);

         refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (model.getRowCount() > 0) {
                  for (int i = model.getRowCount() - 1; i > -1; i--) {
                     model.removeRow(i);
                  }
               }
               updateRow( donorList, users);
            }
         });

         table.setEnabled(false);
         JScrollPane sp = new JScrollPane(table);
         sp.setBounds(10,60,580, 500);

         table.revalidate();

         homePanel.add(sp);
         homePanel.setLayout( null );

         return homePanel;
    }

    static void updateRow(DonorDetails[] donorList, int[] users ){
       for( int i = 0; i < users[0]; i++ ) {
          donor[0] = donorList[i].Name;
          donor[1] = donorList[i].Age;
          donor[2] = donorList[i].BloodType;
          donor[3] = donorList[i].City;
          donor[4] = donorList[i].Phone;

          model.addRow(donor);
       }
    }
}