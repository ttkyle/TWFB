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
        size.width = 190;
        size.height = 180;

        //set size of panel
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create the colors used for the background and border line
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //sets the border color and title of the JPanel
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Number of Troops"));

        //Set the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();



        //swing components
        JTextField spearTextFieldFarmAdder = new JTextField(5);
        JTextField swordTextFieldFarmAdder = new JTextField(5);
        JTextField axeTextFieldFarmAdder = new JTextField(5);
        JTextField scoutTextFieldFarmAdder = new JTextField(5);
        JTextField lightCalTextFieldFarmAdder = new JTextField(5);
        JTextField paladinTextFieldFarmAdder = new JTextField(5);
        JTextField catapultTextFieldFarmAdder = new JTextField(5);
        JTextField ramTextFieldFarmAdder = new JTextField(5);
        JTextField heavyCalTextFieldFarmAdder = new JTextField(5);
        JTextField mArcherTextFieldFarmAdder = new JTextField(5);
        JTextField archerTextFieldFarmAdder = new JTextField(5);
        JTextField nobleTextFieldFarmAdder = new JTextField(5);

        JLabel spearIconFarmAdder = new JLabel ("", TroopsDetailPanel.getSpearIcon(), JLabel.CENTER);
        spearIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        spearIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        spearIconFarmAdder.setBackground(bgColor);
        spearIconFarmAdder.setOpaque(true);
        spearIconFarmAdder.setBorder(null);

        JLabel swordIconFarmAdder = new JLabel ("",TroopsDetailPanel.getSwordIcon(), JLabel.CENTER);
        swordIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        swordIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        swordIconFarmAdder.setBackground(bgColor);
        swordIconFarmAdder.setOpaque(true);
        swordIconFarmAdder.setBorder(null);

        JLabel axeIconFarmAdder = new JLabel ("", TroopsDetailPanel.getAxeIcon(), JLabel.CENTER);
        axeIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        axeIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        axeIconFarmAdder.setBackground(bgColor);
        axeIconFarmAdder.setOpaque(true);
        axeIconFarmAdder.setBorder(null);

        JLabel scoutIconFarmAdder = new JLabel ("", TroopsDetailPanel.getScoutIcon(), JLabel.CENTER);
        scoutIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        scoutIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        scoutIconFarmAdder.setBackground(bgColor);
        scoutIconFarmAdder.setOpaque(true);
        scoutIconFarmAdder.setBorder(null);

        JLabel lightCalIconFarmAdder = new JLabel ("", TroopsDetailPanel.getLightCalIcon(), JLabel.CENTER);
        lightCalIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        lightCalIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        lightCalIconFarmAdder.setBackground(bgColor);
        lightCalIconFarmAdder.setOpaque(true);
        lightCalIconFarmAdder.setBorder(null);

        JLabel paladinIconFarmAdder = new JLabel ("", TroopsDetailPanel.getPaladinIcon(), JLabel.CENTER);
        paladinIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        paladinIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        paladinIconFarmAdder.setBackground(bgColor);
        paladinIconFarmAdder.setOpaque(true);
        paladinIconFarmAdder.setBorder(null);

        JLabel catapultIconFarmAdder = new JLabel ("", TroopsDetailPanel.getCatapultIcon(), JLabel.CENTER);
        catapultIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        catapultIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        catapultIconFarmAdder.setBackground(bgColor);
        catapultIconFarmAdder.setOpaque(true);
        catapultIconFarmAdder.setBorder(null);

        JLabel ramIconFarmAdder = new JLabel ("",TroopsDetailPanel.getRamIcon(), JLabel.CENTER);
        ramIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        ramIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        ramIconFarmAdder.setBackground(bgColor);
        ramIconFarmAdder.setOpaque(true);
        ramIconFarmAdder.setBorder(null);

        JLabel heavyCalIconFarmAdder = new JLabel ("", TroopsDetailPanel.getHeavyCalIcon(), JLabel.CENTER);
        heavyCalIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        heavyCalIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        heavyCalIconFarmAdder.setBackground(bgColor);
        heavyCalIconFarmAdder.setOpaque(true);
        heavyCalIconFarmAdder.setBorder(null);

        JLabel mArcherIconFarmAdder = new JLabel ("", TroopsDetailPanel.getMountedArcherIcon(), JLabel.CENTER);
        mArcherIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        mArcherIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        mArcherIconFarmAdder.setBackground(bgColor);
        mArcherIconFarmAdder.setOpaque(true);
        mArcherIconFarmAdder.setBorder(null);

        JLabel archerIconFarmAdder = new JLabel ("", TroopsDetailPanel.getArcherIcon(), JLabel.CENTER);
        archerIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        archerIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        archerIconFarmAdder.setBackground(bgColor);
        archerIconFarmAdder.setOpaque(true);
        archerIconFarmAdder.setBorder(null);

        JLabel nobleIconFarmAdder = new JLabel ("", TroopsDetailPanel.getNobleIcon(), JLabel.CENTER);
        nobleIconFarmAdder.setVerticalTextPosition(JLabel.TOP);
        nobleIconFarmAdder.setHorizontalTextPosition(JLabel.RIGHT);
        nobleIconFarmAdder.setBackground(bgColor);
        nobleIconFarmAdder.setOpaque(true);
        nobleIconFarmAdder.setBorder(null);

        ///////First Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.gridy = 0;
        add(spearIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(swordIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(axeIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        add(scoutIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        add(lightCalIconFarmAdder, gc);

        gc.gridx = 0;
        gc.gridy = 5;
        add(paladinIconFarmAdder, gc);



        /////// Second Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(spearTextFieldFarmAdder, gc);

        gc.gridx= 1;
        gc.gridy=1;
        add(swordTextFieldFarmAdder, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(axeTextFieldFarmAdder, gc);

        gc.gridx= 1;
        gc.gridy=3;
        add(scoutTextFieldFarmAdder, gc);

        gc.gridx = 1;
        gc.gridy = 4;
        add(lightCalTextFieldFarmAdder, gc);

        gc.gridx= 1;
        gc.gridy=5;
        add(paladinTextFieldFarmAdder, gc);

        ///////Third Column////////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 2;
        gc.gridy = 0;
        add(catapultIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(ramIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(heavyCalIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 3;
        add(mArcherIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 4;
        add(archerIconFarmAdder, gc);

        gc.gridx = 2;
        gc.gridy = 5;
        add(nobleIconFarmAdder, gc);


        ///////Fourth Column///////
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 0;
        gc.weighty = 0;

        gc.gridx = 3;
        gc.gridy = 0;
        add(catapultTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 1;
        add(ramTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 2;
        add(heavyCalTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 3;
        add(mArcherTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 4;
        add(archerTextFieldFarmAdder, gc);

        gc.gridx = 3;
        gc.gridy = 5;
        add(nobleTextFieldFarmAdder, gc);
    }

}
