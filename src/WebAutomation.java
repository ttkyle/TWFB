import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;



/**
 * Web automation class.  This class is used to automate the web browser.
 * This class also gets certain webElements that are used in the GUI.
 * The elements this class sends to the GUI are Troops and resources thus far.
 */

public class WebAutomation  {
    static WebDriver driver;
    static String userName;
    static String password;

    //String serverName = "en64";
    //String logonPage = "http://www.tribalwars.net";
    //String overViewPage = "http://" + serverName + ".tribalwars.net/game.php?screen=overview&intro";
    //String pageRally = "http://" + serverName + ".tribalwars.net/game.php?village=60018&screen=place";

    public static void login(String user, String pass) throws InterruptedException {

        driver = new FirefoxDriver();
        userName = user;
        password = pass;


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
        js.executeScript("Index.submit_login('server_en64')");

        //the main screen is loading so wait 4 seconds for it to load

        //display units in village to the GUI
        Village.updateTroops();
        Village.isAttacked();
        Village.setWoodResource();
        Village.setClayResource();
        Village.setIronResource();

        //Waits for the VillageHQ to load then gets the building levels and resource generation
        //driver.get("http://en63.tribalwars.net/game.php?village=119799&screen=main");
        driver.get("http://en64.tribalwars.net/game.php?village=60018&screen=main");
        Village.getAllBuildingCosts();

        //updates all the buildings and resources on load
        Village.updateBuildings();

        Thread.sleep(500);
        Village.constructionOne();
        Village.constructionTwo();
        Village.constructionOneGetNumbers();
        Village.constructionOneGetTime();
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
        driver.get("http://en64.tribalwars.net/game.php?screen=overview&intro");

    }

    public void openRally() throws InterruptedException {
        driver.get("http://en64.tribalwars.net/game.php?village=60018&screen=place");
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


