import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

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

                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader("VillageList.txt"));
                }
                catch (FileNotFoundException e1) {
                    //
                }
                writeToVillageList(createFile("VillageList.txt"), villageID);
                writeToVillage(createFile(villageID + ".txt"), villageX, villageY);

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

    static public void writeToVillage(File village, String xCoord, String yCoord) {
        try {
            FileWriter writer = new FileWriter(village, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(xCoord);
            bufferedWriter.write(" ");
            bufferedWriter.write(yCoord);
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

    public static void find() throws IOException, NullPointerException {


        FileReader fr = new FileReader("17000.txt");
        LineNumberReader ln = new LineNumberReader(fr);
        String s;
        s = ln.readLine();

        String[] values = new String[1];
        for (int i = 0; i < values.length; i++) {
           // for(int i = 0; i <)
            values = s.split(",");
            System.out.println(values[i]);
            //System.out.println(i);
            if( i < 15)     {
                AttackTable.table.setValueAt(values[i], 0, i);
            }
            if(i >= 15 && i < 30) {
                AttackTable.table.setValueAt(values[i], 1, i-15);
            }

            if(i >= 30 && i < 45) {
                AttackTable.table.setValueAt(values[i], 2, i-30);
            }

            if(i >= 45 && i < 60) {
                AttackTable.table.setValueAt(values[i], 3, i-45);
            }

            if(i >= 60 && i < 75) {
                AttackTable.table.setValueAt(values[i], 4, i-60);
            }

            if(i >= 75 && i < 90) {
                AttackTable.table.setValueAt(values[i], 5, i-75);
            }

            if(i >= 90 && i < 105) {
                AttackTable.table.setValueAt(values[i], 6, i-90);
            }

            if(i >= 105 && i < 120) {
                AttackTable.table.setValueAt(values[i], 7, i-105);
            }

            if(i >= 120 && i < 135) {
                AttackTable.table.setValueAt(values[i], 8, i-120);
            }

            if(i >= 135 && i < 150) {
                AttackTable.table.setValueAt(values[i], 9, i-135);
            }

            if(i >= 150 && i < 165) {
                AttackTable.table.setValueAt(values[i], 10, i-150);
            }

            if(i >= 165 && i < 180) {
                AttackTable.table.setValueAt(values[i], 11, i-165);
            }
        }
    }


    static public void readFile() {

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader("17000.txt"));
            String line = null;

            int t = 0;
            while((line = br.readLine()) != null && t < line.length()) {
            t++;
                String[] values = line.split(",");

                for(int i = 0; i < values.length ; i++) {
                    AttackTable.table.setValueAt(values[i], 0, i);

                    AttackTable.table.setValueAt(values[i], 1, i);

                }
                line = br.readLine();

                //Do necessary work with the values, here we just print them out



                System.out.println();


            }
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
