
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.io.IOException;




public class AttackTable extends JPanel {

    public static JTable table;
    public static MyTableModel model;

    public AttackTable() {

        super(new GridLayout(1, 0));

        Dimension size = getPreferredSize();
        size.width = 790;
        size.height = 145;
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);

        model = new MyTableModel();
        table = new JTable(model);

        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        table.setFillsViewportHeight(true);

        TableCellRenderer renderer = new JComponentTableCellRenderer();

        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);

        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(25);
        table.getColumnModel().getColumn(3).setPreferredWidth(25);
        table.getColumnModel().getColumn(15).setPreferredWidth(70);


        JLabel label0 = new JLabel(MyTableModel.columnNames[4], TroopsDetailPanel.getSpearIcon(), JLabel.CENTER);
        label0.setBorder(headerBorder);
        TableColumnModel columnModel = AttackTable.table.getColumnModel();
        TableColumn column0 = columnModel.getColumn(4);
        table.getColumnModel().getColumn(4).setPreferredWidth(30);
        column0.setHeaderRenderer(renderer);
        column0.setHeaderValue(label0);

        JLabel label1 = new JLabel(MyTableModel.columnNames[5], TroopsDetailPanel.getSwordIcon(), JLabel.CENTER);
        label1.setBorder(headerBorder);
        TableColumn column1 = columnModel.getColumn(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(30);
        column1.setHeaderRenderer(renderer);
        column1.setHeaderValue(label1);

        JLabel label2 = new JLabel(MyTableModel.columnNames[6], TroopsDetailPanel.getArcherIcon(), JLabel.CENTER);
        label2.setBorder(headerBorder);
        TableColumn column2 = columnModel.getColumn(6);
        table.getColumnModel().getColumn(6).setPreferredWidth(30);
        column2.setHeaderRenderer(renderer);
        column2.setHeaderValue(label2);

        JLabel label3 = new JLabel(MyTableModel.columnNames[7], TroopsDetailPanel.getAxeIcon(), JLabel.CENTER);
        label3.setBorder(headerBorder);
        TableColumn column3 = columnModel.getColumn(7);
        table.getColumnModel().getColumn(7).setPreferredWidth(30);
        column3.setHeaderRenderer(renderer);
        column3.setHeaderValue(label3);

        JLabel label4 = new JLabel(MyTableModel.columnNames[8], TroopsDetailPanel.getMountedArcherIcon(), JLabel.CENTER);
        label4.setBorder(headerBorder);
        TableColumn column4 = columnModel.getColumn(8);
        table.getColumnModel().getColumn(8).setPreferredWidth(30);
        column4.setHeaderRenderer(renderer);
        column4.setHeaderValue(label4);

        JLabel label5 = new JLabel(MyTableModel.columnNames[9], TroopsDetailPanel.getScoutIcon(), JLabel.CENTER);
        label5.setBorder(headerBorder);
        TableColumn column5 = columnModel.getColumn(9);
        table.getColumnModel().getColumn(9).setPreferredWidth(30);
        column5.setHeaderRenderer(renderer);
        column5.setHeaderValue(label5);

        JLabel label6 = new JLabel(MyTableModel.columnNames[10], TroopsDetailPanel.getLightCalIcon(), JLabel.CENTER);
        label6.setBorder(headerBorder);
        TableColumn column6 = columnModel.getColumn(10);
        table.getColumnModel().getColumn(10).setPreferredWidth(30);
        column6.setHeaderRenderer(renderer);
        column6.setHeaderValue(label6);

        JLabel label7 = new JLabel(MyTableModel.columnNames[11], TroopsDetailPanel.getHeavyCalIcon(), JLabel.CENTER);
        label7.setBorder(headerBorder);
        TableColumn column7 = columnModel.getColumn(11);
        table.getColumnModel().getColumn(11).setPreferredWidth(30);
        column7.setHeaderRenderer(renderer);
        column7.setHeaderValue(label7);

        JLabel label8 = new JLabel(MyTableModel.columnNames[12], TroopsDetailPanel.getCatapultIcon(), JLabel.CENTER);
        label8.setBorder(headerBorder);
        TableColumn column8 = columnModel.getColumn(12);
        table.getColumnModel().getColumn(12).setPreferredWidth(30);
        column8.setHeaderRenderer(renderer);
        column8.setHeaderValue(label8);

        JLabel label9 = new JLabel(MyTableModel.columnNames[13], TroopsDetailPanel.getRamIcon(), JLabel.CENTER);
        label9.setBorder(headerBorder);
        TableColumn column9 = columnModel.getColumn(13);
        table.getColumnModel().getColumn(13).setPreferredWidth(30);
        column9.setHeaderRenderer(renderer);
        column9.setHeaderValue(label9);

        JLabel label10 = new JLabel(MyTableModel.columnNames[14], TroopsDetailPanel.getNobleIcon(), JLabel.CENTER);
        label10.setBorder(headerBorder);
        TableColumn column10 = columnModel.getColumn(14);
        table.getColumnModel().getColumn(14).setPreferredWidth(30);
        column10.setHeaderRenderer(renderer);
        column10.setHeaderValue(label10);

        try {
            AddVillagePanel.find("15000.txt");
        }
        catch (IOException e) {
        }
    }

    public class JComponentTableCellRenderer implements TableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return (JComponent) value;
        }
    }

    static class MyTableModel extends AbstractTableModel {
        public static  String[] columnNames = {"Target ID",
                "Village",
                "X",
                "Y",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "Currently"};
        public  Object[][] data = {

                {"000000", "Village Village Village",
                        "000", "000", "00000", "000","000", "000", "000", "000", "000", "000", "000", "000",
                        "000", "Travel from"},


                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "","", "", "", "", "", "", "", "", "", ""},
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
            fireTableDataChanged();
        }
    }
}

