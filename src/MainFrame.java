import javax.swing.*;
import java.awt.*;

/**
 * The main frame that you see for the GUI
 */
public class MainFrame extends JFrame {


    public TroopsDetailPanel troopsDetailPanel;
    //

    public MainFrame(String title) {
        super(title);



        //Create Swing components
        DetailsPanel detailsPanel = new DetailsPanel();
        troopsDetailPanel = new TroopsDetailPanel();
        BuildPanel buildPanel = new BuildPanel();
        CurrentVillagePanel currentVillagePanel = new CurrentVillagePanel();
        AddVillagePanel addVillagePanel = new AddVillagePanel();
        BuildingConstructionPanel buildingConstructionPanel = new BuildingConstructionPanel();
        ServerTimePanel serverTimePanel = new ServerTimePanel();

        //Disables frames on GUI creation
        disableButtons();


        //Details panel listener
        detailsPanel.addDetailListener(new DetailListener() {
            public void detailEventOccurred(DetailEvent event) {
            }
        });

        //Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();



        ////////////First Column/////////////////////
        gc.anchor = GridBagConstraints.NORTHWEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 0, 350, 595);
        gc.gridx =  0;
        gc.gridy = 0;
        add(detailsPanel, gc);

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = .5;
        gc.weighty = .5;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-352, 0, 0, 595);
        gc.gridx = 0;
        gc.gridy = 1;
        add(troopsDetailPanel, gc);

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = .5;
        gc.weighty = .5;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-126, 0, 0, 595);
        gc.gridx = 0;
        gc.gridy = 2;
        add(currentVillagePanel, gc);

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-152, 0, -50, 595);
        gc.gridx = 0;
        gc.gridy = 3;
        add(addVillagePanel, gc);

        gc.anchor = GridBagConstraints.NORTH;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, 2, 0, 597);
        gc.gridx = 0;
        gc.gridy = 4;
        add(serverTimePanel, gc);


        ////////////Second Column////////////////
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(0, -595 , 188, -1);
        gc.gridx = 1;
        gc.gridy = 0;
        add(buildPanel, gc);

        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = .0;
        gc.weighty = .0;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(-460, -595 , 0, -1);
        gc.gridx = 1;
        gc.gridy = 1;
        add(buildingConstructionPanel, gc);


    }

    //used to disable all the buttons once ui created
    public static void disableButtons() {
        BuildPanel.setVillageHQButtonTrueOrFalse(false);
        BuildPanel.setBarracksButtonTrueOrFalse(false);
        BuildPanel.setStableButtonTrueOrFalse(false);
        BuildPanel.setWorkShopButtonTrueOrFalse(false);
        BuildPanel.setSmithyButtonTrueOrFalse(false);
        BuildPanel.setMarketButtonTrueOrFalse(false);
        BuildPanel.setFarmButtonTrueOrFalse(false);
        BuildPanel.setWallButtonTrueOrFalse(false);
        BuildPanel.setClayButtonTrueOrFalse(false);
        BuildPanel.setTimberButtonTrueOrFalse(false);
        BuildPanel.setWareHouseButtonTrueOrFalse(false);
        BuildPanel.setAcademyButtonTrueOrFalse(false);
        BuildPanel.setIronButtonTrueOrFalse(false);
        BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
    }

    //used to enable all the buttons once user is logged in
    public static void enableButtons () {
        BuildPanel.setVillageHQButtonTrueOrFalse(true);
        BuildPanel.setBarracksButtonTrueOrFalse(true);
        BuildPanel.setStableButtonTrueOrFalse(true);
        BuildPanel.setWorkShopButtonTrueOrFalse(true);
        BuildPanel.setSmithyButtonTrueOrFalse(true);
        BuildPanel.setMarketButtonTrueOrFalse(true);
        BuildPanel.setFarmButtonTrueOrFalse(true);
        BuildPanel.setWallButtonTrueOrFalse(true);
        BuildPanel.setClayButtonTrueOrFalse(true);
        BuildPanel.setTimberButtonTrueOrFalse(true);
        BuildPanel.setWareHouseButtonTrueOrFalse(true);
        BuildPanel.setAcademyButtonTrueOrFalse(true);
        BuildPanel.setIronButtonTrueOrFalse(true);
        BuildPanel.setHidingPlaceButtonTrueOrFalse(true);
    }

}