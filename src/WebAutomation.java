import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.*;
import java.io.File;
import java.sql.Driver;


/**
 * Web automation class.  This class is used to automate the web browser.
 * This class also gets certain webElements that are used in the GUI.
 * The elements this class sends to the GUI are Troops and resources thus far.
 */

public class WebAutomation  {
    static WebDriver driver;
    static String userName;
    static String password;

    private static String currentlySelectedServer;

    //String serverName = "en64";
    //String logonPage = "http://www.tribalwars.net";
    //String overViewPage = "http://" + serverName + ".tribalwars.net/game.php?screen=overview&intro";
    //String pageRally = "http://" + serverName + ".tribalwars.net/game.php?village=60018&screen=place";

    public static void login(String user, String pass) throws InterruptedException {

        driver = new FirefoxDriver();
        userName = user;
        password = pass;

        String convertServerToString = DetailsPanel.getServerListComboBox().getSelectedItem().toString();
        currentlySelectedServer = convertServerToString.substring(6, 10);
        System.out.println(currentlySelectedServer);

        //Get the logon page
        driver.get("http://www.tribalwars.net");

        //Find the user text input by name and type it
        WebElement elementUser = driver.findElement(By.name("user"));
        elementUser.sendKeys(userName);
        Thread.sleep(250);

        //Wait to enter password
        Thread.sleep(500);

        //Find the password text input and type it
        WebElement elementPassword = driver.findElement(By.name("password"));
        elementPassword.sendKeys(password);
        Thread.sleep(250);
        elementPassword.submit();
        Thread.sleep(500);

        //Choose which server to login and wait
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("Index.submit_login('server_" + currentlySelectedServer +"')");

        driver.get(currentlySelectedServer + ".tribalwars.net/game.php?screen=overview&intro");
        Thread.sleep(1000);


        String currentUrl = null;
        try {
             currentUrl = driver.getCurrentUrl().substring(7, 57);
        }
        catch(StringIndexOutOfBoundsException e) {
            System.out.println("NO ACCOUNT ON SERVER");
            JOptionPane.showMessageDialog(MainFrame.serverNotOnAccountDialog,
                    "THERE IS NO VILLAGE CREATED IN THIS WORLD!!!!!",
                    "NO VILLAGE IN THIS WORLD",
                    JOptionPane.ERROR_MESSAGE);

            driver.close();
            driver = null;
        }

        System.out.println(currentUrl);
        Thread.sleep(1000);
        if(currentUrl.equals(currentlySelectedServer + ".tribalwars.net/game.php?screen=overview&intro")) {
            System.out.println("SERVER EXISTS ON ACCOUNT");


            //display units in village to the GUI
            Village.updateTroops();
            Village.isAttacked();
            Village.setWoodResource();
            Village.setClayResource();
            Village.setIronResource();

            //Waits for the VillageHQ to load then gets the building levels and resource generation
            //driver.get("http://en63.tribalwars.net/game.php?village=119799&screen=main");
            System.out.println(currentlySelectedServer + ".tribalwars.net/game.php?village=34634&screen=main");
            driver.get( currentlySelectedServer + ".tribalwars.net/game.php?village=34634&screen=main");
            Village.getAllBuildingCosts();

            //updates all the buildings and resources on load
            Village.updateBuildings();

            Thread.sleep(500);
            Village.constructionOne();
            Village.constructionTwo();
            Village.constructionOneGetNumbers();
            Village.constructionOneGetTime();
            Village.constructionTwoGetNumbers();
            Village.constructionTwoGetTime();
            Thread.sleep(500);

            //two new thread to keep updating resources on any page and keeping watch for incoming attacks
            TroopThread troops = new TroopThread();
            ResourceUpdateThread resources = new ResourceUpdateThread();
            IsAttackedThread attack = new IsAttackedThread();
            BuildingResourceCostThread buildingCosts = new BuildingResourceCostThread();
            ConstructOneThread constructOneThread = new ConstructOneThread();

            if(Village.getTotalOne() > 0) {
                ConstructOneThread.constructionFlagOne = true;
            }

            //takes user back to the main page
            //driver.get("http://en63.tribalwars.net/game.php?village=119799&screen=overview");
            driver.get(currentlySelectedServer + ".tribalwars.net/game.php?screen=overview&intro");
        }

        else {
            System.out.println("NO ACCOUNT ON SERVER NOT IN CATCH");
            JOptionPane.showMessageDialog(MainFrame.serverNotOnAccountDialog,
                    "THERE IS NO VILLAGE CREATED IN THIS WORLD!!!!!",
                    "NO VILLAGE IN THIS WORLD",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openRally() throws InterruptedException {
        driver.get(currentlySelectedServer + ".tribalwars.net/game.php?village=34634&screen=place");
        Thread.sleep(1000);
    }

    public void getFileNameAndRead() {
        File folder = new File("C:\\Users\\kyle\\Documents\\Tribalwars");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            }
            //else if (listOfFiles[i].isDirectory()) {
            //System.out.println("Directory " + listOfFiles[i].getName());
            //}
        }
    }
}


