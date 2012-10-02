import org.eclipse.swt.events.MouseTrackListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class AddFarmsTargetJTable extends JPanel {

    public static JTable addFarmsTable;
    public static MyTableModel addFarmsModel;
    public static String columnZero;
    public static String columnOne;
    public static String columnTwo;
    public static String columnThree;
    public static JPopupMenu farmMenu;

    public AddFarmsTargetJTable() {
        super(new GridLayout(1, 0));
        Dimension size = getPreferredSize();
        size.width = 400;
        size.height = 550;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);



        addFarmsModel = new MyTableModel();
        addFarmsTable = new JTable(addFarmsModel);
        addFarmsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addFarmsTable.setPreferredScrollableViewportSize(new Dimension(400, 400));
        addFarmsTable.setFillsViewportHeight(true);


        TableCellRenderer renderer = new JComponentTableCellRenderer();

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        addFarmsTable.setDefaultRenderer(String.class, centerRenderer);



        farmMenu = new JPopupMenu();
        MouseListener popupListener = new PopupListener();
        addFarmsTable.addMouseListener(popupListener);
        addFarmsTable.getTableHeader().addMouseListener(popupListener);
        JMenuItem menuItem = new JMenuItem("Add Target to Farm List");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(MyTableModel.getValueforCell());
                MyTableModel.writeToVillage2(MyTableModel.createFile("15000.txt"));

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

                MyTableModel.writeToVillage2(MyTableModel.createFile("currentFarmList.txt"));

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
        });
        farmMenu.add(menuItem);


        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(addFarmsTable);

        //Add the scroll pane to this panel.
        add(scrollPane);

        addFarmsTable.setRowSelectionAllowed(true);
        addFarmsTable.getTableHeader().setReorderingAllowed(false);
        addFarmsTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        addFarmsTable.getColumnModel().getColumn(1).setPreferredWidth(135);
        addFarmsTable.getColumnModel().getColumn(2).setPreferredWidth(5);
        addFarmsTable.getColumnModel().getColumn(3).setPreferredWidth(5);
        addFarmsTable.getColumnModel().getColumn(4).setPreferredWidth(15);

        try {
            AddVillagePanel.findFarms("Village.txt");
        }
        catch (IOException e) {
        }

        TableRowSorter tableRowSorter = new TableRowSorter<AbstractTableModel>(addFarmsModel);
        addFarmsTable.setRowSorter(tableRowSorter);
        tableRowSorter.setSortsOnUpdates(true);
    }

    public class JComponentTableCellRenderer implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return (JComponent) value;
        }
    }

    static class MyTableModel extends AbstractTableModel {
        public   String[] columnNames = {"Target ID",
                "Village",
                "X",
                "Y",
                "Distance"};
        public  Object[][] data = {


                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
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

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
        public static String getValueforCell()
        {
            int selectedRowIndex = addFarmsTable.getSelectedRow();
            columnZero = (String) addFarmsTable.getModel().getValueAt(selectedRowIndex, 0);
            columnOne = (String) addFarmsTable.getModel().getValueAt(selectedRowIndex, 1);
            columnTwo = (String) addFarmsTable.getModel().getValueAt(selectedRowIndex, 2);
            columnThree = (String) addFarmsTable.getModel().getValueAt(selectedRowIndex, 3);
            return columnZero + " " + columnOne + " " +columnTwo + " " + columnThree;
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

                /*
                AddFarmsTroops.getSwordTextFieldFarmAdder().equals("")          ||
                        AddFarmsTroops.getSpearTextFieldFarmAdder().equals("")          ||
                        AddFarmsTroops.getArcherTextFieldFarmAdder().equals("")         ||
                        AddFarmsTroops.getAxeTextFieldFarmAdder().equals("")            ||
                        AddFarmsTroops.getMountedArcherTextFieldFarmAdder().equals("")  ||
                        AddFarmsTroops.getScoutTextFieldFarmAdder().equals("")          ||
                        AddFarmsTroops.getLightCalTextFieldFarmAdder().equals("")       ||
                        AddFarmsTroops.getHeavyCalTextFieldFarmAdder().equals("")       ||
                        AddFarmsTroops.getCatapultTextFieldFarmAdder().equals("")       ||
                        AddFarmsTroops.getRamTextFieldFarmAdder().equals("")            ||
                        AddFarmsTroops.getNobleTextFieldFarmAdder().equals("")
                */

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
                }
            }
            catch (IOException e) {
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