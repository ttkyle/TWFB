import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JLabel villageIDLabel = new JLabel("ID");
        JLabel villageXCoord = new JLabel("X");
        JLabel villageYCoord = new JLabel("Y");
        JLabel villageNameLabel = new JLabel("Name");


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
}
