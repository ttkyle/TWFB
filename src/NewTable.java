import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class NewTable extends JPanel {
    public static JTable table;
    public static DefaultTableModel model;
    public static JPopupMenu farmMenu;
    public static String columnZero;
    public static String columnOne;
    public static String columnTwo;
    public static String columnThree;

    public NewTable() {
        super(new GridLayout(1, 0));
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 550;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        String[] columnNames = {"Target ID",
                "Village",
                "X",
                "Y",
                "Distance"};

        Object[][] data = {
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},

        };

        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        TableCellRenderer renderer = new JComponentTableCellRenderer();

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        table.setDefaultRenderer(String.class, centerRenderer);

        //Add the scroll pane to this panel.
        add(scrollPane);


        table.setRowSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(135);
        table.getColumnModel().getColumn(2).setPreferredWidth(5);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(15);

        farmMenu = new JPopupMenu();

        MouseListener popupListener = new PopupListener();
        table.addMouseListener(popupListener);
        table.getTableHeader().addMouseListener(popupListener);
        JMenuItem menuItem = new JMenuItem("Add Target to Farm List");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println(DataManipulation.getValueforCell());
                    DataManipulation.writeToVillage2(DataManipulation.createFile("15000.txt"));

                    if(AddFarmsTroops.getSpearTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setSpearTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getArcherTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setArcherTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getAxeTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setAxeTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getCatapultTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setCatapultTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getHeavyCalTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setHeavyCalTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getLightCalTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setLightCalTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getMountedArcherTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setMountedArcherTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getNobleTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setNobleTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getPaladinTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setPaladinTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getRamTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setRamTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getScoutTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setScoutTextFieldFarmAdder("0");
                    }
                    if(AddFarmsTroops.getSwordTextFieldFarmAdder().equals("")) {
                        AddFarmsTroops.setSwordTextFieldFarmAdder("0");
                    }


                }
                catch(ArrayIndexOutOfBoundsException e1) {
                    //do nothing
                }
            }
        });
        farmMenu.add(menuItem);

       try {
            AddVillagePanel.findFarms("village.txt");
            //AddVillagePanel.filterFarmsBlackList();
        }
        catch (IOException e) {
            //
        }




    }

     class JComponentTableCellRenderer implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return (JComponent) value;
        }
    }

    static class DataManipulation {

        public static String getValueforCell() {
            int selectedRowIndex = table.getSelectedRow();
            columnZero = (String) table.getModel().getValueAt(selectedRowIndex, 0);
            columnOne = (String) table.getModel().getValueAt(selectedRowIndex, 1);
            columnTwo = (String) table.getModel().getValueAt(selectedRowIndex, 2);
            columnThree = (String) table.getModel().getValueAt(selectedRowIndex, 3);
            return columnZero + " " + columnOne + " " +columnTwo + " " + columnThree;
        }

        public static void writeFarms(File village) {
            try {
                FileWriter writer = new FileWriter(village, true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(columnZero);
                bufferedWriter.write(",");

                if((AddFarmsTroops.getSpearTextFieldFarmAdder().equals("0")     &&
                        AddFarmsTroops.getSwordTextFieldFarmAdder().equals("0")         &&
                        AddFarmsTroops.getArcherTextFieldFarmAdder().equals("0")        &&
                        AddFarmsTroops.getAxeTextFieldFarmAdder().equals("0")           &&
                        AddFarmsTroops.getMountedArcherTextFieldFarmAdder().equals("0") &&
                        AddFarmsTroops.getScoutTextFieldFarmAdder().equals("0")         &&
                        AddFarmsTroops.getLightCalTextFieldFarmAdder().equals("0")      &&
                        AddFarmsTroops.getHeavyCalTextFieldFarmAdder().equals("0")      &&
                        AddFarmsTroops.getCatapultTextFieldFarmAdder().equals("0")      &&
                        AddFarmsTroops.getRamTextFieldFarmAdder().equals("0") )          &&
                        AddFarmsTroops.getNobleTextFieldFarmAdder().equals("0")) {
                    //do nothing
                }

                bufferedWriter.close();
            }
            catch (IOException e) {
            }
        }

        public static void writeToVillage2(File village) {
            try {
                FileWriter writer = new FileWriter(village, true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(columnZero);
                bufferedWriter.write(", ");
                bufferedWriter.write(columnOne);
                bufferedWriter.write(", ");
                bufferedWriter.write(columnTwo);
                bufferedWriter.write(", ");
                bufferedWriter.write(columnThree);
                bufferedWriter.write(", ");

                if((AddFarmsTroops.getSpearTextFieldFarmAdder().equals("0")     &&
                        AddFarmsTroops.getSwordTextFieldFarmAdder().equals("0")         &&
                        AddFarmsTroops.getArcherTextFieldFarmAdder().equals("0")        &&
                        AddFarmsTroops.getAxeTextFieldFarmAdder().equals("0")           &&
                        AddFarmsTroops.getMountedArcherTextFieldFarmAdder().equals("0") &&
                        AddFarmsTroops.getScoutTextFieldFarmAdder().equals("0")         &&
                        AddFarmsTroops.getLightCalTextFieldFarmAdder().equals("0")      &&
                        AddFarmsTroops.getHeavyCalTextFieldFarmAdder().equals("0")      &&
                        AddFarmsTroops.getCatapultTextFieldFarmAdder().equals("0")      &&
                        AddFarmsTroops.getRamTextFieldFarmAdder().equals("0") )          &&
                        AddFarmsTroops.getNobleTextFieldFarmAdder().equals("0")) {
                    //do nothing
                }

                else {
                    if(AddFarmsTroops.getSpearTextFieldFarmAdder().equals(""))
                    {
                        bufferedWriter.write("0");
                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getSpearTextFieldFarmAdder());
                    }

                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getSwordTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");
                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getSwordTextFieldFarmAdder());

                    }

                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getArcherTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");
                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getArcherTextFieldFarmAdder());

                    }

                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getAxeTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");
                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getAxeTextFieldFarmAdder());
                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getMountedArcherTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getMountedArcherTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getScoutTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getScoutTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getLightCalTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getLightCalTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getHeavyCalTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getHeavyCalTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getCatapultTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getCatapultTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getRamTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getRamTextFieldFarmAdder());

                    }
                    bufferedWriter.write(", ");

                    if(AddFarmsTroops.getNobleTextFieldFarmAdder().equals("")) {
                        bufferedWriter.write("0");

                    }
                    else {
                        bufferedWriter.write(AddFarmsTroops.getNobleTextFieldFarmAdder());
                    }
                    bufferedWriter.write(", ");
                    bufferedWriter.newLine();
                    bufferedWriter.close();

                    DataManipulation.writeFarms(DataManipulation.createFile("currentFarmList.txt"));
                    AddVillagePanel.filterFarmsBlackList();
                }
            }
            catch (IOException e) {
            }
            finally {
            }
        }

        public static File createFile(String name) {
            File file = new File(name);
            return file;
        }
    }

    class PopupListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            showPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            showPopup(e);
        }

        private void showPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                farmMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }


}








