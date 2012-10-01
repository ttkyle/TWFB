import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;


/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/30/12
 * Time: 7:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddFarmsDialog extends JDialog {

    public AddFarmsDialog() {
        setModal(true);

        setLocation(400, 0);
        Dimension size = getPreferredSize();
        size.width = 800;
        size.height = 400;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        //create the background color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //set the border color and title of the panel
        setTitle("Tribal Wars Bot Farm Adder");
        //Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Create Swing components
        AddFarmsTroops addFarmsTroops = new AddFarmsTroops();
        AddFarmsTargetJTable addFarmsTargetJTable = new AddFarmsTargetJTable();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    AddVillagePanel.displayFarmVillages("15000.txt");
                    AddFarmsTroops.setSpearTextFieldFarmAdder("0");
                    AddFarmsTroops.setArcherTextFieldFarmAdder("0");
                    AddFarmsTroops.setAxeTextFieldFarmAdder("0");
                    AddFarmsTroops.setCatapultTextFieldFarmAdder("0");
                    AddFarmsTroops.setHeavyCalTextFieldFarmAdder("0");
                    AddFarmsTroops.setLightCalTextFieldFarmAdder("0");
                    AddFarmsTroops.setMountedArcherTextFieldFarmAdder("0");
                    AddFarmsTroops.setNobleTextFieldFarmAdder("0");
                    AddFarmsTroops.setPaladinTextFieldFarmAdder("0");
                    AddFarmsTroops.setRamTextFieldFarmAdder("0");
                    AddFarmsTroops.setScoutTextFieldFarmAdder("0");
                    AddFarmsTroops.setSwordTextFieldFarmAdder("0");

                }
                catch (IOException e1) {
                    //
                }
            }
        });

        setVisible(false);

        ////////////First Column/////////////////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 0, 190, 0);
        gc.gridx =  0;
        gc.gridy = 0;
        add(addFarmsTroops, gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-560, 0, 0, 200);
        gc.gridx =  1;
        gc.gridy = 1;
        add(addFarmsTargetJTable, gc);
    }
}
