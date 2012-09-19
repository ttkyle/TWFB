import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import java.io.*;
import java.util.Scanner;

import static org.apache.commons.lang.StringUtils.substring;

/**
 * The village class holds most of the information for the village
 * and holds most of the methods that manipulate GUI elements
 *
 * The village class will update on the fly when a user selects a
 * village to manipulate.  test
 */
public class Village {

    //global variables
    static public String xLoc;
    static public String yLoc;
    static public FileOutputStream fout;
    static public String villageFileName;
    static public int numberOfFarms = 1;

    static public int villageHQWoodCost;
    static public int villageHQClayCost;
    static public int villageHQIronCost;
    static public boolean villageHQHasCost = true;


    static public int barracksWoodCost;
    static public int barracksClayCost;
    static public int barracksIronCost;
    static public boolean barracksHasCost = true;


    static public int stableWoodCost;
    static public int stableClayCost;
    static public int stableIronCost;
    static public boolean stableHasCost = true;

    static public int workShopWoodCost;
    static public int workShopClayCost;
    static public int workShopIronCost;
    static public boolean workShopHasCost = true;


    static public int smithyWoodCost;
    static public int smithyClayCost;
    static public int smithyIronCost;
    static public boolean smithyHasCost = true;


    static public int marketWoodCost;
    static public int marketClayCost;
    static public int marketIronCost;
    static public boolean marketHasCost = true;


    static public int timberWoodCost;
    static public int timberClayCost;
    static public int timberIronCost;
    static public boolean timberHasCost = true;


    static public int clayWoodCost;
    static public int clayClayCost;
    static public int clayIronCost;
    static public boolean clayHasCost = true;


    static public int ironWoodCost;
    static public int ironClayCost;
    static public int ironIronCost;
    static public boolean ironHasCost = true;


    static public int farmWoodCost;
    static public int farmClayCost;
    static public int farmIronCost;
    static public boolean farmHasCost = true;


    static public int wareHouseWoodCost;
    static public int wareHouseClayCost;
    static public int wareHouseIronCost;
    static public boolean wareHouseHasCost = true;


    static public int wallWoodCost;
    static public int wallClayCost;
    static public int wallIronCost;
    static public boolean wallHasCost = true;


    static public int academyWoodCost;
    static public int academyClayCost;
    static public int academyIronCost;
    static public boolean academyHasCost = true;


    static public int hidingPlaceWoodCost;
    static public int hidingPlaceClayCost;
    static public int hidingPlaceIronCost;
    static public boolean hidingPlaceHasCost = true;


    static public int currentWood;
    static public int currentClay;
    static public int currentIron;
    static public int currentPopulation;
    static public int maxPopulation;

    static public String durationOne;
    static public double totalOne = 0;
    static public double totalOneOne;
    static public double totalOneThird;
    static public double totalOneFourth;
    static public double totalOneSixth;
    static public double totalOneSeventh;

    static public double totalOneSecond;
    static public double totalOneEighth;


    //Constructor to set village name so that we know what to name text files
    //Also writes the x and y coords for the village to attack
    Village(String villageName) throws IOException {
        villageFileName = villageName;
        fout = new FileOutputStream("C:\\Users\\kyle\\Documents\\Tribalwars\\" + villageFileName + ".txt");
        this.writeX();
        this.writeY();
        numberOfFarms++;
    }



    //Reads the lines that you tell it to via startLine and endLine
    public void readFile(int startLine, int endLine)  {
        int currentLineNo = 0;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("C:\\Users\\kyle\\Documents\\Tribalwars\\" + villageFileName + ".txt"));
            //read to startLine
            while(currentLineNo < startLine) {
                if (in.readLine() == null) {
                    //early end
                    throw new IOException("File too small");
                }
                currentLineNo++;
            }
            //read until endLine
            while(currentLineNo <= endLine) {
                String line = in.readLine();
                if (line == null) {
                    return;
                }
                System.out.println(line);
                currentLineNo++;
            }
        }
        catch (IOException ex) {
            System.out.println("Problem reading file.\n" + ex.getMessage());
        } finally {
            try { if (in!=null) in.close(); } catch(IOException ignore) {}
        }
    }

    //Reads the x coord of a village file
    public String readX() {
        this.readFile(0, 0);
        return xLoc;
    }

    //Reads the y coord of a village file
    public String readY() {
        this.readFile(1, 1);
        return yLoc;
    }

    //Writes a specified message to the startLine through the endLine
    //I may need to work on this method so that it won't overwrite another x or y coord if the file is already made
    public String writeFile(int startLine, int endLine, String msg) throws IOException {
        int currentLineNo = 0;
        //Get to start line to start writing
        while(currentLineNo < startLine) {
            currentLineNo++;
        }
        // Print a line of text
        while(currentLineNo <= endLine) {
            new PrintStream(fout).println(msg);
            currentLineNo++;
        }
        return msg;
    }


    // Writes the X coord based on user input
    //This method needs to be made so that it won't overwrite an X coord that is already entered
    public void writeX() throws IOException {
        System.out.println("Type x coord, it can only be 3 numbers long.");
        Scanner userInputXLoc = new Scanner(System.in);
        xLoc = userInputXLoc.next();
        while(xLoc.length() != 3) {
            System.out.println("Please re-enter x coord.");
            xLoc = userInputXLoc.next();
        }
        System.out.println(xLoc);
        writeFile(0, 0, xLoc);
    }


    //Writes the Y coord based on user input
    //This method needs to be made so that it won't overwrite an Y coord that is already entered
    public void writeY() throws IOException {
        System.out.println("Type y coord, it can only be 3 numbers long.");
        Scanner userInputXLoc = new Scanner(System.in);
        yLoc = userInputXLoc.next();
        while(yLoc.length() != 3) {
            System.out.println("Please re-enter y coord.");
            yLoc = userInputXLoc.next();
        }
        writeFile(1, 1, yLoc);
        fout.close();
    }

    //Gets the file names in the tribalwars folder

    //Eventually need to make a method that goes through every file and pulls the X and Y coord data out
    //of the text files
    public void getFileName() {
        File folder = new File("C:\\Users\\kyle\\Documents\\Tribalwars");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            }
            else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    //Sends number of spears to the GUI
    public static void setSpears() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String spearLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(spearLabel, 2, 7).equals("Spear") || substring(spearLabel, 3, 8).equals("Spear") || substring(spearLabel, 4, 9).equals("Spear")
                || substring(spearLabel, 5, 10).equals("Spear") ||  substring(spearLabel, 6, 11).equals("Spear") ||  substring(spearLabel, 7, 12).equals("Spear")) {
                    TroopsDetailPanel.setSpearLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setSpearLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends number of Swords to the GUI
    public static void setSwords() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String swordLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(swordLabel, 2, 7).equals("Sword") || substring(swordLabel, 3, 8).equals("Sword") || substring(swordLabel, 4, 9).equals("Sword")
                || substring(swordLabel, 5, 10).equals("Sword") || substring(swordLabel, 6, 11).equals("Sword") || substring(swordLabel, 7, 12).equals("Sword")) {
                    TroopsDetailPanel.setSwordLabelLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setSwordLabelLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends number of axes to the GUI
    public static void setAxes() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String axeLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(axeLabel, 1, 4).equals("Axe") || substring(axeLabel, 2, 5).equals("Axe") || substring(axeLabel, 3, 6).equals("Axe")
                || substring(axeLabel, 4, 7).equals("Axe") || substring(axeLabel, 5, 8).equals("Axe") || substring(axeLabel, 6, 9).equals("Axe")
                || substring(axeLabel, 7, 10).equals("Axe")) {
                    TroopsDetailPanel.setAxeLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setAxeLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends number of scouts to the GUI
    public static void setSpies() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String spyLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(spyLabel, 2, 7).equals("Scout") || substring(spyLabel, 3, 8).equals("Scout") || substring(spyLabel, 4, 9).equals("Scout")
                || substring(spyLabel, 5, 10).equals("Scout") || substring(spyLabel, 6, 11).equals("Scout") || substring(spyLabel, 7, 12).equals("Scout")) {
                    TroopsDetailPanel.setSpyLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setSpyLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends number of light cal to the GUI
    public static void setLightCal() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String lightCalLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(lightCalLabel, 2, 7).equals("Light") || substring(lightCalLabel, 3, 8).equals("Light") || substring(lightCalLabel, 4, 9).equals("Light")
                || substring(lightCalLabel, 5, 10).equals("Light") || substring(lightCalLabel, 6, 11).equals("Light") || substring(lightCalLabel, 7, 12).equals("Light")) {
                    TroopsDetailPanel.setLightCalLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setLightCalLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends whether or not the village has a paladin
    public static void setPaladin() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String paladinLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(paladinLabel, 0, 7).equals("Paladin")) {
                    TroopsDetailPanel.setPaladinLabel("1");
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setPaladinLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends the number of catapults to the GUI
    public static void setCatapult() {

        //loop through all the show unit lines
        //if the unit name is found then display it on the GUI
        for(int i = 1; i < 15; i++) {
            try {
                String catapultLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_units\"]/div/table/tbody/tr[" + i + "]")).getText();
                if(substring(catapultLabel, 2, 10).equals("Catapult") || substring(catapultLabel, 3, 11).equals("Catapult") || substring(catapultLabel, 4, 12).equals("Catapult")
                || substring(catapultLabel, 5, 13).equals("Catapult") || substring(catapultLabel, 6, 14).equals("Catapult") || substring(catapultLabel, 7, 15).equals("Catapult")) {
                    TroopsDetailPanel.setCatapultLabel(WebAutomation.driver.findElement(By.xpath("//*[@id='show_units']/div/table/tbody/tr[" + i + "]/td/strong")).getText());
                    break;
                }
                //the troop was not found
                else {
                    TroopsDetailPanel.setCatapultLabel("0");
                }
            }
            catch(NoSuchElementException e) {
            }
        }
    }

    //Sends the level of villageHQ to the GUI
    public static void setVillageHQ() {

        //loop through the building rows
        for(int i = 2; i < 20; i++) {
            try {
                String villageHQLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();

                //if the building was found then set the name and level
                if(substring(villageHQLabel, 0, 7).equals("Village")) {
                    BuildPanel.setVillageHQLabel("Village HQ " + substring(villageHQLabel, 21, 31));

                    //if the building level is not present then make it level 0
                    if(substring(villageHQLabel, 21, 31).equals("")) {
                        BuildPanel.setVillageHQLabel("Village HQ (Level 0)");
                        BuildPanel.setVillageHQButtonTrueOrFalse(false);
                    }
                    break;
                }
                //if the building is not found at all make it level 0
                else {
                    BuildPanel.setVillageHQLabel("Village HQ (Level 0)");
                }
            }
            //if the element does not exist on the webpage then it's max level
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeVillageHQLabel("Cannot upgrade");
                BuildPanel.setVillageHQButtonTrueOrFalse(false);
                BuildPanel.setVillageHQLabel("Village max level");
            }
        }
    }

    //Sends the level of barracks to the GUI
    public static void setBarracks() {

        for(int i = 2; i < 20; i++) {
            try {
                String barracksLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(barracksLabel, 0, 8).equals("Barracks")) {
                    BuildPanel.setBarracksLabel("Barracks " + substring(barracksLabel, 9, 20));
                    if(substring(barracksLabel, 9, 20).equals("")) {
                        BuildPanel.setBarracksLabel("Barracks (Level 0)");
                        BuildPanel.setBarracksButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setBarracksLabel("Barracks (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeBarracksLabel("Cannot upgrade");
                BuildPanel.setBarracksButtonTrueOrFalse(false);
                BuildPanel.setBarracksLabel("Barracks max level");
            }
        }
    }

    //Sends the level of stable to the GUI
    public static void setStable() {

        for(int i = 2; i < 20; i++) {
            try {
                String stableLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(stableLabel, 0, 6).equals("Stable")) {
                    BuildPanel.setStableLabel("Stable " + substring(stableLabel, 7, 17));
                    if(substring(stableLabel, 7, 17).equals("")) {
                        BuildPanel.setStableLabel("Stable (Level 0)");
                        BuildPanel.setStableButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setStableLabel("Stable (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeStableLabel("Cannot upgrade");
                BuildPanel.setStableButtonTrueOrFalse(false);
                BuildPanel.setStableLabel("Stable max level");
            }
        }
    }

    //Sends the level of workshop to the GUI
    public static void setWorkShop() {

        for(int i = 2; i < 20; i++) {
            try {
                String workShopLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(workShopLabel, 0, 8).equals("Workshop")) {
                    BuildPanel.setWorkShopLabel("Workshop " + substring(workShopLabel, 9, 19));
                    if(substring(workShopLabel, 9, 19).equals("")) {
                        BuildPanel.setWorkShopLabel("Workshop (Level 0)");
                        BuildPanel.setWorkShopButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setWorkShopLabel("Workshop (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeWorkShopLabel("Cannot upgrade");
                BuildPanel.setWorkShopButtonTrueOrFalse(false);
                BuildPanel.setWorkShopLabel("Workshop max level");
            }
        }
    }

    //Sends the level of smithy to the GUI
    public static void setSmithy() {

        for(int i = 2; i < 20; i++) {
            try {
                String smithyLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(smithyLabel, 0, 6).equals("Smithy")) {
                    BuildPanel.setSmithyLabel("Smithy " + substring(smithyLabel, 7, 17));
                    if(substring(smithyLabel, 7, 17).equals("")) {
                        BuildPanel.setSmithyLabel("Smithy (Level 0)");
                        BuildPanel.setSmithyButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setSmithyLabel("Smithy (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeSmithyLabel("Cannot upgrade");
                BuildPanel.setSmithyButtonTrueOrFalse(false);
                BuildPanel.setSmithyLabel("Smithy max level");
            }
        }
    }

    //Sends the level of market to the GUI
    public static void setMarket() {

        for(int i = 2; i < 20; i++) {
            try {
                String marketLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(marketLabel, 0, 6).equals("Market")) {
                    BuildPanel.setMarketLabel("Market " + substring(marketLabel, 7, 17));
                    if(substring(marketLabel, 7, 17).equals("")) {
                        BuildPanel.setMarketLabel("Market (Level 0)");
                        BuildPanel.setMarketButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setMarketLabel("Market (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeMarketLabel("Cannot upgrade");
                BuildPanel.setMarketButtonTrueOrFalse(false);
                BuildPanel.setMarketLabel("Market max level");
            }
        }
    }

    //Sends the level of timber to the GUI
    public static void setTimber() {

        for(int i = 2; i < 20; i++) {
            try {
                String timberLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(timberLabel, 0, 6).equals("Timber")) {
                    BuildPanel.setTimberLabel("Timber " + substring(timberLabel, 12, 22));
                    if(substring(timberLabel, 12, 22).equals("")) {
                        BuildPanel.setTimberLabel("Timber (Level 0)");
                        BuildPanel.setTimberButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setTimberLabel("Timber (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeTimberLabel("Cannot upgrade");
                BuildPanel.setTimberButtonTrueOrFalse(false);
                BuildPanel.setTimberLabel("Timber max level");
            }
        }
    }

    //Sends the level of clay to the GUI
    public static void setClay() {

        for(int i = 2; i < 20; i++) {
            try {
                String clayLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(clayLabel, 0, 4).equals("Clay")) {
                    BuildPanel.setClayLabel("Clay " + substring(clayLabel, 5, 19));
                    if(substring(clayLabel, 9, 19).equals("")) {
                        BuildPanel.setClayLabel("Clay (Level 0)");
                        BuildPanel.setClayButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setClayLabel("Clay (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeClayLabel("Cannot upgrade");
                BuildPanel.setClayButtonTrueOrFalse(false);
                BuildPanel.setClayLabel("Clay max level");
            }
        }
    }

    //Sends the level of iron to the GUI
    public static void setIron() {

        for(int i = 2; i < 20; i++) {
            try {
                String ironLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(ironLabel, 0, 4).equals("Iron")) {
                    BuildPanel.setIronLabel("Iron " + substring(ironLabel, 5, 20));
                    if(substring(ironLabel, 10, 20).equals("")) {
                        BuildPanel.setIronLabel("Iron (Level 0)");
                        BuildPanel.setIronButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setIronLabel("Iron (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeIronLabel("Cannot upgrade");
                BuildPanel.setIronButtonTrueOrFalse(false);
                BuildPanel.setIronLabel("Iron max level");
            }
        }
    }

    //Sends the level of farm to the GUI
    public static void setFarm() {

        for(int i = 2; i < 20; i++) {
            try {
                String farmLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(farmLabel, 0, 4).equals("Farm")) {
                    BuildPanel.setFarmLabel("Farm " + substring(farmLabel, 5, 15));
                    if(substring(farmLabel, 5, 15).equals("")) {
                        BuildPanel.setFarmLabel("Farm (Level 0)");
                        BuildPanel.setFarmButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setFarmLabel("Farm (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeFarmLabel("Cannot upgrade");
                BuildPanel.setFarmButtonTrueOrFalse(false);
                BuildPanel.setFarmLabel("Farm max level");
            }
        }
    }

    //Sends the level of warehouse to the GUI
    public static void setWarehouse() {

        for(int i = 2; i < 20; i++) {
            try {
                String wareHouseLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(wareHouseLabel, 0, 9).equals("Warehouse")) {
                    BuildPanel.setWareHouseLabel("Warehouse " + substring(wareHouseLabel, 10, 20));
                    if(substring(wareHouseLabel, 10, 20).equals("")) {
                        BuildPanel.setWareHouseLabel("Warehouse (Level 0)");
                        BuildPanel.setWareHouseButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setWareHouseLabel("Warehouse (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeWareHouseLabel("Cannot upgrade");
                BuildPanel.setWareHouseButtonTrueOrFalse(false);
                BuildPanel.setWareHouseLabel("Warehouse max level");
            }
        }
    }

    //Sends the level of hiding place to the GUI
    public static void setHidingPlace() {

        for(int i = 2; i < 20; i++) {
            try {
                String hidingPlaceLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(hidingPlaceLabel, 0, 6).equals("Hiding")) {
                    BuildPanel.setHidingPlaceLabel("Hiding " + substring(hidingPlaceLabel, 7, 22));
                    if(substring(hidingPlaceLabel, 13, 22).equals("")) {
                        BuildPanel.setHidingPlaceLabel("Hiding place (Level 0)");
                        BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setHidingPlaceLabel("Hiding place (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeHidingPlaceLabel("Cannot upgrade");
                BuildPanel.setHidingPlaceButtonTrueOrFalse(false);
                BuildPanel.setHidingPlaceLabel("Hiding place max level");
            }
        }
    }

    //Sends the level of wall to the GUI
    public static void setWall() {

        for(int i = 2; i < 20; i++) {
            try {
                String wallLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(wallLabel, 0, 4).equals("Wall")) {
                    BuildPanel.setWallLabel("Wall " + substring(wallLabel, 5, 14));
                    if(substring(wallLabel, 5, 14).equals("")) {
                        BuildPanel.setWallLabel("Wall (Level 0)");
                        BuildPanel.setWallButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setWallLabel("Wall (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeWallLabel("Cannot upgrade");
                BuildPanel.setWallButtonTrueOrFalse(false);
                BuildPanel.setWallLabel("Wall max level");
            }
        }
    }

    //Sends the level of academy to the GUI
    public static void setAcademy() {

        for(int i = 2; i < 20; i++) {
            try {
                String academyLabel = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildings\"]/tbody/tr[" + i + "]/td[1]")).getText();
                if(substring(academyLabel, 0, 7).equals("Academy")) {
                    BuildPanel.setAcademyLabel("Academy " + substring(academyLabel, 8, 16));
                    if(substring(academyLabel, 8, 16).equals("")) {
                        BuildPanel.setAcademyLabel("Academy (Level 0)");
                        BuildPanel.setAcademyButtonTrueOrFalse(false);
                    }
                    break;
                }
                else {
                    BuildPanel.setAcademyLabel("Academy (Level 0)");
                }
            }
            catch(NoSuchElementException e) {
                BuildPanel.setUpgradeAcademyLabel("Cannot upgrade");
                BuildPanel.setAcademyButtonTrueOrFalse(false);
                BuildPanel.setAcademyLabel("Academy max level");
            }
        }
    }

    //update build queue one with building name
    public static void constructionOne() {

            try {
                String buildingName = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[2]/td[1]")).getText();
                BuildingConstructionPanel.setAssignmentOne(buildingName);

                durationOne = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[2]/td[2]/span")).getText();
                BuildingConstructionPanel.setDurationOne(durationOne);

                String completion = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[2]/td[3]")).getText();
                BuildingConstructionPanel.setCompletionOne(completion);
            }
            catch(NoSuchElementException e) {
            }
        }

    public static void constructionOneTimer() throws InterruptedException {

        for(int i = 0; i < 500; i++) {
            int hours = (int) (totalOne / (60 * 60 * 1000));
            int minutes = (int) ((totalOne /(60 * 1000)) % 60);
            int seconds = (int) ((totalOne / 1000) % 60);
            String sec = Integer.toString(seconds);
            String min = Integer.toString(minutes);
            System.out.println(min);
            System.out.println(substring(min, 0, 1));
            System.out.println(substring(min, 0, 2));


            //if(Integer.parseInt(durationOne.substring(6,7)) == 0) {
                //BuildingConstructionPanel.setDurationOne(hours + ":" + minutes + ":" + seconds + 0);
            //}

            if(substring(sec, 1, 2).equals("")) {
                BuildingConstructionPanel.setDurationOne(hours + ":" + minutes + ":" + 0 + seconds);
            }
            if(substring(min, 1, 2).equals("")) {
                BuildingConstructionPanel.setDurationOne(hours + ":" + 0 + minutes + ":" +  seconds);
            }
            if(substring(sec, 1, 2).equals("") && substring(min, 1, 2).equals("")) {
                BuildingConstructionPanel.setDurationOne(hours + ":" + 0 + minutes + ":" + "0" +  seconds);
            }


            else {
                BuildingConstructionPanel.setDurationOne(hours + ":" + minutes + ":" + seconds);
            }

            if(totalOne < 10000) {
                BuildingConstructionPanel.setDurationOne("0");
                break;
            }
            totalOne = totalOne - 10000;
            Thread.sleep(10000);
        }
    }

    public static void constructionOneGetTime() {
        try {
            if(substring(Village.durationOne, 1, 2).equals(":")) {
                if(totalOneOne == 0) {
                    totalOneOne = 0;
                }
                else {
                    totalOneOne = totalOneOne * 3600000;
                }

                if(totalOneThird == 0) {
                    totalOneThird = 0;
                }
                else {
                    totalOneThird *= 600000;
                }

                if(totalOneFourth == 0) {
                    totalOneFourth = 0;
                }
                else {
                    totalOneFourth *= 60000;
                }

                if(totalOneSixth == 0) {
                    totalOneSixth = 0;
                }
                else {
                    totalOneSixth *= 10000;
                }

                if(totalOneSeventh == 0) {
                    totalOneSeventh = 0;
                }
                else {
                    totalOneSeventh *= 1000;
                }
                totalOne = totalOneOne +  totalOneThird + totalOneFourth + totalOneSixth + totalOneSeventh;
            }
            else {

            }
        }
        catch(NullPointerException e) {
        }
    }

    public static void constructionOneGetNumbers() {
        try {
            Village.totalOneOne = Integer.parseInt(substring(Village.durationOne, 0, 1));
            // String second =  :
            Village.totalOneThird = Integer.parseInt(substring(Village.durationOne, 2, 3));
            Village.totalOneFourth = Integer.parseInt(substring(Village.durationOne, 3, 4));
            //int fifth =  :
            Village.totalOneSixth = Integer.parseInt(substring(Village.durationOne, 5, 6));
            Village.totalOneSeventh = Integer.parseInt(substring(Village.durationOne, 6, 7));
            }
            catch(NumberFormatException e) {

            }
            //int eight =  would be last number
    }


    //update build queue two with building name
    public static void constructionTwo() {

        try {
            String buildingName = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[3]/td[1]")).getText();
            BuildingConstructionPanel.setAssignmentOne(buildingName);

            String duration = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[3]/td[2]/span")).getText();
            BuildingConstructionPanel.setDurationOne(duration);

            String completion = WebAutomation.driver.findElement(By.xpath("//*[@id=\"buildqueue\"]/tr[3]/td[3]")).getText();
            BuildingConstructionPanel.setCompletionOne(completion);
        }
        catch(NoSuchElementException e) {
        }
    }


    //Sends the level of wood generation to the GUI
    public static void setWoodResource() {

        try {
            String wood;
            wood = WebAutomation.driver.findElement(By.xpath("//*[@id=\"wood\"]")).getText();
            BuildPanel.setVillageWoodAmountLabel(wood);
        }
        catch(NoSuchElementException e) {
        }
        catch(StaleElementReferenceException e) {
        }
    }

    //Sends the level of clay generation to the GUI
    public static void setClayResource() {

        try {
            String clay;
            clay = WebAutomation.driver.findElement(By.xpath("//*[@id=\"stone\"]")).getText();
            BuildPanel.setVillageClayAmountLabel(clay);
        }
        catch(NoSuchElementException e) {
        }
        catch(StaleElementReferenceException e) {
        }
    }

    ////Sends the level of iron generation to the GUI
    public static void setIronResource() {

        try {
            String iron;
            iron = WebAutomation.driver.findElement(By.xpath("//*[@id=\"iron\"]")).getText();
            BuildPanel.setVillageIronAmountLabel(iron);
        }
        catch(NoSuchElementException e) {
        }
        catch(StaleElementReferenceException e) {
        }
    }

    //Tells the user if they are being attacked
    public static void isAttacked() {

        try {

            String incoming;
            incoming = WebAutomation.driver.findElement(By.xpath("//*[@id=\"show_incoming_units\"]/h4")).getText();

            if(substring(incoming, 0, 8).equals("Incoming")) {
                BuildPanel.setVillageIncomingLabel(WebAutomation.driver.findElement(By.xpath("//*[@id=\"header_info\"]/tbody/tr/td[7]/table/tbody/tr[1]/td/table/tbody/tr/td[2]")).getText() + " Attacks incoming");
            }
        }
        catch(NoSuchElementException e) {
        }
    }

    //Sends the population to the GUI
    public static void setPopulation() {

        try {
            String setPopulaton;
            setPopulaton = WebAutomation.driver.findElement(By.xpath("//*[@id=\"pop_current_label\"]")).getText();

            String setPopulationMax;
            setPopulationMax = WebAutomation.driver.findElement(By.xpath("//*[@id=\"pop_max_label\"]")).getText();

            TroopsDetailPanel.setPopulationCountLabel(setPopulaton + "/" + setPopulationMax);
        }

        catch(NoSuchElementException e) {
        }
        catch(StaleElementReferenceException e) {
        }
    }

    //updates just the buildings
    public static void updateBuildings() {
        setVillageHQ();
        setBarracks();
        setStable();
        setWorkShop();
        setSmithy();
        setMarket();
        setTimber();
        setClay();
        setIron();
        setFarm();
        setWarehouse();
        setHidingPlace();
        setWall();
        setAcademy();
        constructionOne();
    }

    //contains all the troop update functions
    public static void updateTroops() {
        setSwords();
        setAxes();
        setSpears();
        setSpies();
        setLightCal();
        setPaladin();
        setCatapult();
    }

    //gets the village HQ cost
    public static void getVillageHQCost() {
        try {
            villageHQWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_main\"]/td[2]")).getText());
            villageHQClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_main\"]/td[3]")).getText());
            villageHQIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_main\"]/td[4]")).getText());
        }
        //if the costs arent found then it cant be built
        catch(NoSuchElementException e) {
            villageHQHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getBarracksCost() {
        try {
            barracksWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_barracks\"]/td[2]")).getText());
            barracksClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_barracks\"]/td[3]")).getText());
            barracksIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_barracks\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            barracksHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getStableCost() {
        try {
            stableWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stable\"]/td[2]")).getText());
            stableClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stable\"]/td[3]")).getText());
            stableIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stable\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            stableHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getWorkShopCost() {
        try {
            workShopWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_garage\"]/td[2]")).getText());
            workShopClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_garage\"]/td[3]")).getText());
            workShopIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_garage\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            workShopHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getSmithtyCost() {
        try {
            smithyWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_smith\"]/td[2]")).getText());
            smithyClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_smith\"]/td[3]")).getText());
            smithyIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_smith\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            smithyHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getMarketCost() {
        try {
            marketWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_market\"]/td[2]")).getText());
            marketClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_market\"]/td[3]")).getText());
            marketIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_market\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            marketHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getTimberCost() {
        try {
            timberWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wood\"]/td[2]")).getText());
            timberClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wood\"]/td[3]")).getText());
            timberIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wood\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            timberHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }

    }

    public static void getClayCost() {
        try {
            clayWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stone\"]/td[2]")).getText());
            clayClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stone\"]/td[3]")).getText());
            clayIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_stone\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            clayHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getIronCost() {
        try {
            ironWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_iron\"]/td[2]")).getText());
            ironClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_iron\"]/td[3]")).getText());
            ironIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_iron\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            ironHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getFarmCost() {
        try {
            farmWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_farm\"]/td[2]")).getText());
            farmClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_farm\"]/td[3]")).getText());
            farmIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_farm\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            farmHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getWareHouseCost() {
        try {
            wareHouseWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_storage\"]/td[2]")).getText());
            wareHouseClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_storage\"]/td[3]")).getText());
            wareHouseIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_storage\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            wareHouseHasCost = false;

        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getWallCost() {
        try {
            wallWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wall\"]/td[2]")).getText());
            wallClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wall\"]/td[3]")).getText());
            wallIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_wall\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            wallHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getAcademyCost() {
        try {
            academyWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_snob\"]/td[2]")).getText());
            academyClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_snob\"]/td[3]")).getText());
            academyIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_snob\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            academyHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    public static void getHidingPlaceCost() {
        try {
            hidingPlaceWoodCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_hide\"]/td[2]")).getText());
            hidingPlaceClayCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_hide\"]/td[3]")).getText());
            hidingPlaceIronCost = Integer.parseInt(WebAutomation.driver.findElement(By.xpath("//*[@id=\"main_buildrow_hide\"]/td[4]")).getText());
        }
        catch(NoSuchElementException e) {
            hidingPlaceHasCost = false;
        }
        catch(StaleElementReferenceException e) {
        }
    }

    //method to easily get all the building costs
    public static void getAllBuildingCosts() {
        getVillageHQCost();
        getBarracksCost();
        getStableCost();
        getWorkShopCost();
        getSmithtyCost();
        getMarketCost();
        getTimberCost();
        getClayCost();
        getIronCost();
        getFarmCost();
        getWareHouseCost();
        getWallCost();
        getAcademyCost();
        getHidingPlaceCost();
    }
}

