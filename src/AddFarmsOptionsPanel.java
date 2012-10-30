import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kyle
 * Date: 10/29/12
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddFarmsOptionsPanel extends JPanel{

    public AddFarmsOptionsPanel() {

        //create and set the size of the panel
        Dimension size = getPreferredSize();
        size.width = 190;
        size.height = 180;
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);

        //create and set the background color of the panel
        Color bgColor = new Color(247, 245, 233);
        Color outLineColor = new Color(125, 80, 15);
        setBackground(bgColor);

        //sets the layout manager of the panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //sets the border color and title
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(outLineColor), "Village Filter Options"));
    }
}
