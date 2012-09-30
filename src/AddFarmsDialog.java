import javax.swing.*;
import java.awt.*;


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

        setVisible(false);

        ////////////First Column/////////////////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 0, 215, 595);
        gc.gridx =  0;
        gc.gridy = 0;
        add(addFarmsTroops, gc);
    }
}
