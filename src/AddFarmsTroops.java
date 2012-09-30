import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 9/30/12
 * Time: 7:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class AddFarmsTroops extends JPanel {

    public AddFarmsTroops() {

        //create size of the panel
        Dimension size = getPreferredSize();
        size.width = 290;
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

        //Set the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();



        //swing components
        JTextField spearLabelAddFarm = new JTextField(5);
        JTextField swordLabelAddFarm = new JTextField(5);
        JTextField axeLabelAddFarm = new JTextField(5);
        JTextField scoutLabelAddFarm = new JTextField(5);
        JTextField lightCalAddFarm = new JTextField(5);
        JTextField paladinAddFarm = new JTextField(5);

        JLabel spearIconAddFarm = new JLabel ("", TroopsDetailPanel.getSpearIcon(), JLabel.CENTER);
        spearIconAddFarm.setVerticalTextPosition(JLabel.TOP);
        spearIconAddFarm.setHorizontalTextPosition(JLabel.RIGHT);
        spearIconAddFarm.setBackground(bgColor);
        spearIconAddFarm.setOpaque(true);
        spearIconAddFarm.setBorder(null);

        JLabel swordIconAddFarm = new JLabel ("",TroopsDetailPanel.getSwordIcon(), JLabel.CENTER);
        swordIconAddFarm.setVerticalTextPosition(JLabel.TOP);
        swordIconAddFarm.setHorizontalTextPosition(JLabel.RIGHT);
        swordIconAddFarm.setBackground(bgColor);
        swordIconAddFarm.setOpaque(true);
        swordIconAddFarm.setBorder(null);

        JLabel axeIconAddFarm = new JLabel ("", TroopsDetailPanel.getAxeIcon(), JLabel.CENTER);
        axeIconAddFarm.setVerticalTextPosition(JLabel.TOP);
        axeIconAddFarm.setHorizontalTextPosition(JLabel.RIGHT);
        axeIconAddFarm.setBackground(bgColor);
        axeIconAddFarm.setOpaque(true);
        axeIconAddFarm.setBorder(null);

        JLabel scoutIconAddFarm = new JLabel ("", TroopsDetailPanel.getScoutIcon(), JLabel.CENTER);
        scoutIconAddFarm.setVerticalTextPosition(JLabel.TOP);
        scoutIconAddFarm.setHorizontalTextPosition(JLabel.RIGHT);
        scoutIconAddFarm.setBackground(bgColor);
        scoutIconAddFarm.setOpaque(true);
        scoutIconAddFarm.setBorder(null);

        JLabel lightCalIconAddFarm = new JLabel ("", TroopsDetailPanel.getLightCalIcon(), JLabel.CENTER);
        lightCalIconAddFarm.setVerticalTextPosition(JLabel.TOP);
        lightCalIconAddFarm.setHorizontalTextPosition(JLabel.RIGHT);
        lightCalIconAddFarm.setBackground(bgColor);
        lightCalIconAddFarm.setOpaque(true);
        lightCalIconAddFarm.setBorder(null);

        JLabel paladinIconAddFarm = new JLabel ("", TroopsDetailPanel.getPaladinIcon(), JLabel.CENTER);
        paladinIconAddFarm.setVerticalTextPosition(JLabel.TOP);
        paladinIconAddFarm.setHorizontalTextPosition(JLabel.RIGHT);
        paladinIconAddFarm.setBackground(bgColor);
        paladinIconAddFarm.setOpaque(true);
        paladinIconAddFarm.setBorder(null);

        ///////First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.gridy = 0;
        add(spearIconAddFarm, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(swordIconAddFarm, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(axeIconAddFarm, gc);



        /////// Second Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 1;
        gc.gridy = 0;
        add(spearLabelAddFarm, gc);

        gc.gridx= 1;
        gc.gridy=1;
        add(swordLabelAddFarm, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(axeLabelAddFarm, gc);

        gc.gridx= 1;
        gc.gridy=3;
        add(scoutLabelAddFarm, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        add(lightCalAddFarm, gc);

        gc.gridx= 1;
        gc.gridy=5;
        add(paladinAddFarm, gc);
    }

}
