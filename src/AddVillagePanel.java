import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

import static java.awt.geom.Point2D.distance;

/**
 * The GUI element that will eventually allow the user to add
 * the villages they currently own.
 *
 * This class is still a work in progress!!
 */
public class AddVillagePanel extends JPanel {

    public AddVillagePanel() {

        //create size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 150;

        //set size of panel
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create the colors used for the background and border line
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //sets the border color and title of the JPanel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Add New Village"));


        //labels to describe what to put in textfields
        final JLabel villageIDLabel = new JLabel("ID");
        final JLabel villageXCoord = new JLabel("X");
        final JLabel villageYCoord = new JLabel("Y");
        final JLabel villageNameLabel = new JLabel("Name");


        //JTextFields for various village elements that will add info
        //to a text file and will be loaded when GUI is created
        final JTextField villageIDTextField = new JTextField(12);
        final JTextField villageXCoordTextField = new JTextField(12);
        final JTextField villageYCoordTextField = new JTextField(12);
        final JTextField villageNameTextField = new JTextField(12);


        //a button that will eventually write the data from the textfields
        //to a textfile
        JButton addVillageButton = new JButton("     Add Village        ");
        addVillageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String villageID = villageIDTextField.getText();
                String villageX = villageXCoordTextField.getText();
                String villageY = villageYCoordTextField.getText();
                String villageName = villageNameTextField.getText();

                writeToVillage(createFile(villageID + ".txt"), villageID, villageName, villageX, villageY);

                /*(
                writeToVillage2(createFile("15000.txt"));
                try {
                    displayFarmVillages("15000.txt");

                } catch (IOException e1) {

                }
                */
            }
        });

        //Set the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        ////// First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx =  0;
        gc.gridy = 0;
        add(villageIDLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(villageXCoord, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(villageYCoord, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(villageNameLabel, gc);

        ////// Second column /////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(villageIDTextField, gc);

        gc.gridx= 1;
        gc.gridy=1;
        add(villageXCoordTextField, gc);

        gc.gridx= 1;
        gc.gridy=2;
        add(villageYCoordTextField, gc);

        gc.gridx= 1;
        gc.gridy=3;
        add(villageNameTextField, gc);

        ///final row
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = .0;
        gc.weighty = .0;

        gc.gridx = 1;
        gc.gridy = 4;
        add(addVillageButton, gc);
    }

    static public File createFile(String name) {
        File file = new File(name);
        return file;
    }

    static public void writeToVillageList(File village, String ID) {
        try {
            FileWriter writer = new FileWriter(village, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(ID);
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException e) {
        }
    }

    static public void writeToVillage(File village,String villageID, String name,  String xCoord, String yCoord) {
        try {
            FileWriter writer = new FileWriter(village, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(villageID);
            bufferedWriter.write(", ");
            bufferedWriter.write(name);
            bufferedWriter.write(", ");
            bufferedWriter.write(xCoord);
            bufferedWriter.write(", ");
            bufferedWriter.write(yCoord);
            bufferedWriter.write(", ");
            bufferedWriter.newLine();
            bufferedWriter.close();
        }
        catch (IOException e) {
        }
    }

    static public void writeToVillage2(File village) {
    try {
        FileWriter writer = new FileWriter(village, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("lol");
        bufferedWriter.write(", ");
        bufferedWriter.write("500");
        bufferedWriter.write(", ");
        bufferedWriter.write("600");
        bufferedWriter.write(", ");
        bufferedWriter.write("10");
        bufferedWriter.write(", ");
        bufferedWriter.write("11 ");
        bufferedWriter.write(", ");
        bufferedWriter.write("12 ");
        bufferedWriter.write(", ");
        bufferedWriter.write("13");
        bufferedWriter.write(", ");
        bufferedWriter.write("14");
        bufferedWriter.write(", ");
        bufferedWriter.write("15");
        bufferedWriter.write(", ");
        bufferedWriter.write("16");
        bufferedWriter.write(", ");
        bufferedWriter.write("17");
        bufferedWriter.write(", ");
        bufferedWriter.write("18");
        bufferedWriter.write(", ");
        bufferedWriter.write("19");
        bufferedWriter.write(", ");
        bufferedWriter.write("20");
        bufferedWriter.write(", ");
        bufferedWriter.write("21");
        bufferedWriter.write(", ");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
    catch (IOException e) {
    }
}

    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);

            for(int i = 0; i < lines.size() ; i++) {
                AttackTable.table.setValueAt(lines.get(i), 0, i);
            }
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    public static void find(String fileName) throws IOException{
        FileReader fr = new FileReader(fileName);
        LineNumberReader ln = new LineNumberReader(fr);
        String s;

        int number = 0;
        int number2 = 0;
        int count = 0;
        String[] values = new String[1];

        if((s = ln.readLine()) != null) {
            for (int i = 0; i < values.length; i++) {
                try {
                    values = s.split(",");
                }
                catch(NullPointerException e) {
                    //do nothing but load
                }

                if(i >= 0 && i < 15) {
                    AttackTable.table.setValueAt(values[i], 0, i);
                }
                if(i >= number && i < number2 ) {
                    AttackTable.table.setValueAt(values[i], count, i - (15 * count));
                }

                if(i > 0 && i % 15 == 14) {
                    number = number + 15;
                    number2 = number + 15;
                    count++;
                }
                //System.out.println("i is " + i);
                //System.out.println("number " + number);
            }
        }
        fr.close();
        ln.close();
    }

    public static void findFarms(String fileName) throws IOException{
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String farms;
        int count = 0;
        String[] values = new String[1];

        while((farms = br.readLine()) != null) {
            for (int i = 0; i < values.length; i++) {
                try {
                    values = farms.split(",");
                }
                catch(NullPointerException e) {
                    //do nothing but load
                }

                if(i >= 0  && i < 1 ) {
                    if(distanceMethod(Double.parseDouble(values[2]), 346.0, Double.parseDouble(values[3]), 243.0) <= 10 &&
                    distanceMethod(Double.parseDouble(values[2]), 346.0, Double.parseDouble(values[3]), 243.0) != 0.0) {
                        Double newValue = distanceMethod(Double.parseDouble(values[2]), 346.0, Double.parseDouble(values[3]), 243.0);
                        AddFarmsTargetJTable.addFarmsTable.setValueAt(values[0], count, 0);
                        AddFarmsTargetJTable.addFarmsTable.setValueAt(values[1], count, 1);
                        AddFarmsTargetJTable.addFarmsTable.setValueAt(values[2], count, 2);
                        AddFarmsTargetJTable.addFarmsTable.setValueAt(values[3], count, 3);
                        AddFarmsTargetJTable.addFarmsTable.setValueAt(newValue.toString(), count, 4);
                        count++;
                    }
                }
            }
        }
        fr.close();
        br.close();
    }

    public static void displayFarmVillages(String fileName) throws IOException{
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String s;
        int count = 0;
        String[] values = new String[1];

        while((s = br.readLine()) != null) {
            for (int i = 0; i < values.length; i++) {
                try {
                    values = s.split(",");
                }
                catch(NullPointerException e) {
                    //do nothing but load
                }

                if(i >= 0  && i < 1 ) {
                    AttackTable.table.setValueAt(values[0], count, 0);
                    AttackTable.table.setValueAt(values[1], count, 1);
                    AttackTable.table.setValueAt(values[2], count, 2);
                    AttackTable.table.setValueAt(values[3], count, 3);
                    AttackTable.table.setValueAt(values[4], count, 4);
                    AttackTable.table.setValueAt(values[5], count, 5);
                    AttackTable.table.setValueAt(values[6], count, 6);
                    AttackTable.table.setValueAt(values[7], count, 7);
                    AttackTable.table.setValueAt(values[8], count, 8);
                    AttackTable.table.setValueAt(values[9], count, 9);
                    AttackTable.table.setValueAt(values[10], count, 10);
                    AttackTable.table.setValueAt(values[11], count, 11);
                    AttackTable.table.setValueAt(values[12], count, 12);
                    AttackTable.table.setValueAt(values[13], count, 13);
                    AttackTable.table.setValueAt(values[14], count, 14);
                    AttackTable.table.setValueAt(values[15], count, 15);
                    count++;
                    System.out.println(count);
                }
            }
        }
        fr.close();
        br.close();
    }

    public static Double distanceMethod(Double x2, Double x1, Double y2, Double y1) {
        Double distance = Math.round(((distance(x1, y1, x2, y2)) * 100.0)) / 100.0;
        return distance;
    }
}
