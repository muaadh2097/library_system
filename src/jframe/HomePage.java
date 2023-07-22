/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author muaadh
 */
public class HomePage extends javax.swing.JFrame {

    Color mouseEntereColor = new Color(0, 0, 0);
    Color mouseExitColor = new Color(51, 51, 51);

    /**
     * Creates new form HomePage
     */
    DefaultTableModel model;

    public HomePage() {
        initComponents();
        showPieChart();
        setStudentDetailToTable();
        setBookDetailToTable();
        setDataToCards();
    }

    //To Set student detail inot table
    public void setStudentDetailToTable() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from student_details");
            while (rs.next()) {
                String StudentId = rs.getString("student_matric");
                String StudentName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");

                Object[] obj = {StudentId, StudentName, course, branch};
                model = (DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBookDetailToTable() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms", "root", "");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from book_details");
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                int quanitiy = rs.getInt("quantity");

                Object[] obj = {bookId, bookName, author, quanitiy};
                model = (DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDataToCards() {

        Statement st = null;
        ResultSet rs = null;
        long l = System.currentTimeMillis();

        Date todayDate = new Date(l);

        try {
            Connection con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from book_details");
            rs.last();
            lbl_numberOfBooks.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from student_details");
            rs.last();
            lbl_numberOfStudents.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from issue_book_details where status = '" + "pending" + "'");
            rs.last();
            lbl_IssueBooks.setText(Integer.toString(rs.getRow()));

            rs = st.executeQuery("select * from issue_book_details where due_date < '" + todayDate + "' and status = '" + "pending" + "' ");
            rs.last();
            lbl_defaulterList.setText(Integer.toString(rs.getRow()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
       
        try {
            Connection con = DBConnection.getConnection();
        String sql ="select book_name,count(*) as issue_count from issue_book_details group by book_id ";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         while(rs.next()){
         barDataset.setValue(rs.getString("book_name"),new Double(rs.getDouble("issue_count")));
             
         }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details", barDataset, true, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
//        piePlot.setSectionPaint("IPhone 5s", new Color(255, 255, 102));
//        piePlot.setSectionPaint("SamSung Grand", new Color(102, 255, 102));
//        piePlot.setSectionPaint("MotoG", new Color(255, 102, 153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0, 204, 204));

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        PanelPieChart.removeAll();
        PanelPieChart.add(barChartPanel, BorderLayout.CENTER);
        PanelPieChart.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jPanel89 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jPanel90 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jPanel91 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jPanel92 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jPanel93 = new javax.swing.JPanel();
        jPanel94 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jPanel95 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jPanel96 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jPanel97 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jPanel98 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jPanel100 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jPanel101 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jPanel102 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jPanel103 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jPanel104 = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jPanel105 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jPanel106 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jPanel107 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jPanel108 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jPanel109 = new javax.swing.JPanel();
        jPanel110 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jPanel111 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jPanel112 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jPanel113 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jPanel114 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jPanel115 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jPanel116 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jPanel117 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jPanel118 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jPanel119 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jPanel120 = new javax.swing.JPanel();
        jLabel122 = new javax.swing.JLabel();
        jPanel121 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jPanel122 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jPanel123 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jPanel124 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jPanel125 = new javax.swing.JPanel();
        jPanel126 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jPanel127 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jPanel128 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jPanel129 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jPanel130 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jPanel131 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jPanel132 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jPanel133 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jPanel134 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        jPanel135 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jPanel136 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        jPanel137 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jPanel138 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jPanel139 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jPanel140 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jPanel141 = new javax.swing.JPanel();
        jPanel142 = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jPanel143 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jPanel144 = new javax.swing.JPanel();
        jLabel146 = new javax.swing.JLabel();
        jPanel145 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jPanel146 = new javax.swing.JPanel();
        jLabel148 = new javax.swing.JLabel();
        jPanel147 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jPanel148 = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        jPanel149 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jPanel150 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jPanel151 = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jPanel152 = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jPanel153 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jPanel154 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jPanel155 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jPanel156 = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel157 = new javax.swing.JPanel();
        lbl_numberOfBooks = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jPanel158 = new javax.swing.JPanel();
        lbl_numberOfStudents = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jPanel159 = new javax.swing.JPanel();
        lbl_IssueBooks = new javax.swing.JLabel();
        jPanel160 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojerusan.RSTableMetro();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojerusan.RSTableMetro();
        PanelPieChart = new javax.swing.JPanel();

        jLabel1.setBackground(new java.awt.Color(255, 0, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libra.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("UTHM Mangment System");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 300, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel5.setText("Welcome, Admin");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 10, 300, 50));

        jLabel7.setFont(new java.awt.Font("Sitka Small", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1850, 20, 30, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 70));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel2.setText("  Home Page");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("  Home Page");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel8.setText("  Home Page");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel9.setText("  Home Page");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel10.setText("  Home Page");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel11.setText("  Home Page");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel10.setBackground(new java.awt.Color(255, 51, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel12.setText("  Home Page");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 51, 51));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel13.setText("  Home Page");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 60));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Features");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(255, 51, 51));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel32.setText("  Home Page");
        jPanel30.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel31.setBackground(new java.awt.Color(255, 51, 51));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel33.setText("  Home Page");
        jPanel31.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel32.setBackground(new java.awt.Color(255, 51, 51));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel34.setText("  Home Page");
        jPanel32.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel31.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel29.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel33.setBackground(new java.awt.Color(255, 51, 51));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel35.setText("  Home Page");
        jPanel33.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel34.setBackground(new java.awt.Color(255, 51, 51));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel36.setText("  Home Page");
        jPanel34.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel35.setBackground(new java.awt.Color(255, 51, 51));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel37.setText("  Home Page");
        jPanel35.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel36.setBackground(new java.awt.Color(255, 51, 51));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel38.setText("  Home Page");
        jPanel36.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel35.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel33.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel29.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel37.setBackground(new java.awt.Color(51, 51, 51));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel39.setText("  Dashboard");
        jPanel37.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel38.setBackground(new java.awt.Color(255, 51, 51));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel40.setText("  Home Page");
        jPanel38.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel37.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel39.setBackground(new java.awt.Color(255, 51, 51));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel41.setText("  Home Page");
        jPanel39.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel40.setBackground(new java.awt.Color(255, 51, 51));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel42.setText("  Home Page");
        jPanel40.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel37.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel41.setBackground(new java.awt.Color(255, 51, 51));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel43.setText("  Home Page");
        jPanel41.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel42.setBackground(new java.awt.Color(255, 51, 51));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel44.setText("  Home Page");
        jPanel42.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel41.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel43.setBackground(new java.awt.Color(255, 51, 51));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel45.setText("  Home Page");
        jPanel43.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel44.setBackground(new java.awt.Color(255, 51, 51));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel46.setText("  Home Page");
        jPanel44.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel43.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel41.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel37.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel29.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(153, 153, 153));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel47.setText("  Dashboard");
        jPanel29.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
        });
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(255, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel15.setText("  Home Page");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel15.setBackground(new java.awt.Color(255, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel16.setText("  Home Page");
        jPanel15.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel16.setBackground(new java.awt.Color(255, 51, 51));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel17.setText("  Home Page");
        jPanel16.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel17.setBackground(new java.awt.Color(255, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel18.setText("  Home Page");
        jPanel17.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel18.setBackground(new java.awt.Color(255, 51, 51));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel19.setText("  Home Page");
        jPanel18.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel19.setBackground(new java.awt.Color(255, 51, 51));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel20.setText("  Home Page");
        jPanel19.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel20.setBackground(new java.awt.Color(255, 51, 51));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel21.setText("  Home Page");
        jPanel20.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel17.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel13.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel22.setText("  Dashboard");
        jPanel21.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel22.setBackground(new java.awt.Color(255, 51, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel23.setText("  Home Page");
        jPanel22.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel23.setBackground(new java.awt.Color(255, 51, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel24.setText("  Home Page");
        jPanel23.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel24.setBackground(new java.awt.Color(255, 51, 51));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel25.setText("  Home Page");
        jPanel24.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel21.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel25.setBackground(new java.awt.Color(255, 51, 51));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel26.setText("  Home Page");
        jPanel25.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel26.setBackground(new java.awt.Color(255, 51, 51));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel27.setText("  Home Page");
        jPanel26.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel25.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel27.setBackground(new java.awt.Color(255, 51, 51));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel28.setText("  Home Page");
        jPanel27.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel28.setBackground(new java.awt.Color(255, 51, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel29.setText("  Home Page");
        jPanel28.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel25.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel21.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel13.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel31.setText("  Mange Book");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel31MouseExited(evt);
            }
        });
        jPanel13.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel4.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, 60));

        jPanel45.setBackground(new java.awt.Color(51, 51, 51));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel46.setBackground(new java.awt.Color(255, 51, 51));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel48.setText("  Home Page");
        jPanel46.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel45.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel47.setBackground(new java.awt.Color(255, 51, 51));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel49.setText("  Home Page");
        jPanel47.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel48.setBackground(new java.awt.Color(255, 51, 51));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel50.setText("  Home Page");
        jPanel48.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel47.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel45.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel49.setBackground(new java.awt.Color(255, 51, 51));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel51.setText("  Home Page");
        jPanel49.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel50.setBackground(new java.awt.Color(255, 51, 51));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel52.setText("  Home Page");
        jPanel50.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel49.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel51.setBackground(new java.awt.Color(255, 51, 51));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel53.setText("  Home Page");
        jPanel51.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel52.setBackground(new java.awt.Color(255, 51, 51));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel54.setText("  Home Page");
        jPanel52.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel51.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel49.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel45.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel53.setBackground(new java.awt.Color(51, 51, 51));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel55.setText("  Dashboard");
        jPanel53.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel54.setBackground(new java.awt.Color(255, 51, 51));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel56.setText("  Home Page");
        jPanel54.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel53.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel55.setBackground(new java.awt.Color(255, 51, 51));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel57.setText("  Home Page");
        jPanel55.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel56.setBackground(new java.awt.Color(255, 51, 51));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel58.setText("  Home Page");
        jPanel56.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel55.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel53.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel57.setBackground(new java.awt.Color(255, 51, 51));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel59.setText("  Home Page");
        jPanel57.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel58.setBackground(new java.awt.Color(255, 51, 51));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel60.setText("  Home Page");
        jPanel58.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel57.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel59.setBackground(new java.awt.Color(255, 51, 51));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel61.setText("  Home Page");
        jPanel59.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel60.setBackground(new java.awt.Color(255, 51, 51));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel62.setText("  Home Page");
        jPanel60.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel59.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel57.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel53.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel45.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel63.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(153, 153, 153));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel63.setText("  Mange Students");
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel63MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel63MouseExited(evt);
            }
        });
        jPanel45.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, 60));

        jPanel61.setBackground(new java.awt.Color(51, 51, 51));
        jPanel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel61MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel61MouseEntered(evt);
            }
        });
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel62.setBackground(new java.awt.Color(255, 51, 51));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel64.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel64.setText("  Home Page");
        jPanel62.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel61.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel63.setBackground(new java.awt.Color(255, 51, 51));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel65.setText("  Home Page");
        jPanel63.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel64.setBackground(new java.awt.Color(255, 51, 51));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel66.setText("  Home Page");
        jPanel64.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel63.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel61.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel65.setBackground(new java.awt.Color(255, 51, 51));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel67.setText("  Home Page");
        jPanel65.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel66.setBackground(new java.awt.Color(255, 51, 51));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel68.setText("  Home Page");
        jPanel66.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel65.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel67.setBackground(new java.awt.Color(255, 51, 51));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel69.setText("  Home Page");
        jPanel67.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel68.setBackground(new java.awt.Color(255, 51, 51));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel70.setText("  Home Page");
        jPanel68.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel67.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel65.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel61.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel69.setBackground(new java.awt.Color(51, 51, 51));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel71.setText("  Dashboard");
        jPanel69.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel70.setBackground(new java.awt.Color(255, 51, 51));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel72.setText("  Home Page");
        jPanel70.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel69.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel71.setBackground(new java.awt.Color(255, 51, 51));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel73.setText("  Home Page");
        jPanel71.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel72.setBackground(new java.awt.Color(255, 51, 51));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel74.setText("  Home Page");
        jPanel72.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel71.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel69.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel73.setBackground(new java.awt.Color(255, 51, 51));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel75.setText("  Home Page");
        jPanel73.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel74.setBackground(new java.awt.Color(255, 51, 51));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel76.setText("  Home Page");
        jPanel74.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel73.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel75.setBackground(new java.awt.Color(255, 51, 51));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel77.setText("  Home Page");
        jPanel75.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel76.setBackground(new java.awt.Color(255, 51, 51));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel78.setText("  Home Page");
        jPanel76.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel75.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel73.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel69.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel61.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel79.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(153, 153, 153));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel79.setText("  Issue Book");
        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel79MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel79MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel79MouseExited(evt);
            }
        });
        jPanel61.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, 60));

        jPanel77.setBackground(new java.awt.Color(51, 51, 51));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel78.setBackground(new java.awt.Color(255, 51, 51));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel80.setText("  Home Page");
        jPanel78.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel77.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel79.setBackground(new java.awt.Color(255, 51, 51));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel81.setText("  Home Page");
        jPanel79.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel80.setBackground(new java.awt.Color(255, 51, 51));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel82.setText("  Home Page");
        jPanel80.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel79.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel77.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel81.setBackground(new java.awt.Color(255, 51, 51));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel83.setText("  Home Page");
        jPanel81.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel82.setBackground(new java.awt.Color(255, 51, 51));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel84.setText("  Home Page");
        jPanel82.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel81.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel83.setBackground(new java.awt.Color(255, 51, 51));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel85.setText("  Home Page");
        jPanel83.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel84.setBackground(new java.awt.Color(255, 51, 51));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel86.setText("  Home Page");
        jPanel84.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel83.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel81.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel77.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel85.setBackground(new java.awt.Color(51, 51, 51));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel87.setText("  Dashboard");
        jPanel85.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel86.setBackground(new java.awt.Color(255, 51, 51));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel88.setText("  Home Page");
        jPanel86.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel85.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel87.setBackground(new java.awt.Color(255, 51, 51));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel89.setText("  Home Page");
        jPanel87.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel88.setBackground(new java.awt.Color(255, 51, 51));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel90.setText("  Home Page");
        jPanel88.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel87.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel85.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel89.setBackground(new java.awt.Color(255, 51, 51));
        jPanel89.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel91.setText("  Home Page");
        jPanel89.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel90.setBackground(new java.awt.Color(255, 51, 51));
        jPanel90.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel92.setText("  Home Page");
        jPanel90.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel89.add(jPanel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel91.setBackground(new java.awt.Color(255, 51, 51));
        jPanel91.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel93.setText("  Home Page");
        jPanel91.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel92.setBackground(new java.awt.Color(255, 51, 51));
        jPanel92.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel94.setText("  Home Page");
        jPanel92.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel91.add(jPanel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel89.add(jPanel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel85.add(jPanel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel77.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel95.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(153, 153, 153));
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel95.setText("  Return Book");
        jLabel95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel95MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel95MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel95MouseExited(evt);
            }
        });
        jPanel77.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, -1, 60));

        jPanel93.setBackground(new java.awt.Color(51, 51, 51));
        jPanel93.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel94.setBackground(new java.awt.Color(255, 51, 51));
        jPanel94.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel96.setText("  Home Page");
        jPanel94.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel93.add(jPanel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel95.setBackground(new java.awt.Color(255, 51, 51));
        jPanel95.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel97.setText("  Home Page");
        jPanel95.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel96.setBackground(new java.awt.Color(255, 51, 51));
        jPanel96.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel98.setText("  Home Page");
        jPanel96.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel95.add(jPanel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel93.add(jPanel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel97.setBackground(new java.awt.Color(255, 51, 51));
        jPanel97.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel99.setText("  Home Page");
        jPanel97.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel98.setBackground(new java.awt.Color(255, 51, 51));
        jPanel98.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel100.setText("  Home Page");
        jPanel98.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel97.add(jPanel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel99.setBackground(new java.awt.Color(255, 51, 51));
        jPanel99.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel101.setText("  Home Page");
        jPanel99.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel100.setBackground(new java.awt.Color(255, 51, 51));
        jPanel100.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel102.setText("  Home Page");
        jPanel100.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel99.add(jPanel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel97.add(jPanel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel93.add(jPanel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel101.setBackground(new java.awt.Color(51, 51, 51));
        jPanel101.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel103.setText("  Dashboard");
        jPanel101.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel102.setBackground(new java.awt.Color(255, 51, 51));
        jPanel102.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel104.setText("  Home Page");
        jPanel102.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel101.add(jPanel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel103.setBackground(new java.awt.Color(255, 51, 51));
        jPanel103.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel105.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel105.setText("  Home Page");
        jPanel103.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel104.setBackground(new java.awt.Color(255, 51, 51));
        jPanel104.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel106.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel106.setText("  Home Page");
        jPanel104.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel103.add(jPanel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel101.add(jPanel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel105.setBackground(new java.awt.Color(255, 51, 51));
        jPanel105.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel107.setText("  Home Page");
        jPanel105.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel106.setBackground(new java.awt.Color(255, 51, 51));
        jPanel106.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel108.setText("  Home Page");
        jPanel106.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel105.add(jPanel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel107.setBackground(new java.awt.Color(255, 51, 51));
        jPanel107.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel109.setText("  Home Page");
        jPanel107.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel108.setBackground(new java.awt.Color(255, 51, 51));
        jPanel108.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel110.setText("  Home Page");
        jPanel108.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel107.add(jPanel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel105.add(jPanel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel101.add(jPanel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel93.add(jPanel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel111.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(153, 153, 153));
        jLabel111.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel111.setText("  View Record");
        jLabel111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel111MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel111MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel111MouseExited(evt);
            }
        });
        jPanel93.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(jPanel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, 60));

        jPanel109.setBackground(new java.awt.Color(51, 51, 51));
        jPanel109.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel110.setBackground(new java.awt.Color(255, 51, 51));
        jPanel110.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(255, 255, 255));
        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel112.setText("  Home Page");
        jPanel110.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel109.add(jPanel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel111.setBackground(new java.awt.Color(255, 51, 51));
        jPanel111.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel113.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel113.setText("  Home Page");
        jPanel111.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel112.setBackground(new java.awt.Color(255, 51, 51));
        jPanel112.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel114.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(255, 255, 255));
        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel114.setText("  Home Page");
        jPanel112.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel111.add(jPanel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel109.add(jPanel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel113.setBackground(new java.awt.Color(255, 51, 51));
        jPanel113.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel115.setText("  Home Page");
        jPanel113.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel114.setBackground(new java.awt.Color(255, 51, 51));
        jPanel114.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(255, 255, 255));
        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel116.setText("  Home Page");
        jPanel114.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel113.add(jPanel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel115.setBackground(new java.awt.Color(255, 51, 51));
        jPanel115.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel117.setText("  Home Page");
        jPanel115.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel116.setBackground(new java.awt.Color(255, 51, 51));
        jPanel116.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel118.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel118.setText("  Home Page");
        jPanel116.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel115.add(jPanel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel113.add(jPanel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel109.add(jPanel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel117.setBackground(new java.awt.Color(51, 51, 51));
        jPanel117.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel119.setText("  Dashboard");
        jPanel117.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel118.setBackground(new java.awt.Color(255, 51, 51));
        jPanel118.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel120.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel120.setText("  Home Page");
        jPanel118.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel117.add(jPanel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel119.setBackground(new java.awt.Color(255, 51, 51));
        jPanel119.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel121.setText("  Home Page");
        jPanel119.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel120.setBackground(new java.awt.Color(255, 51, 51));
        jPanel120.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel122.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel122.setText("  Home Page");
        jPanel120.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel119.add(jPanel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel117.add(jPanel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel121.setBackground(new java.awt.Color(255, 51, 51));
        jPanel121.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel123.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel123.setText("  Home Page");
        jPanel121.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel122.setBackground(new java.awt.Color(255, 51, 51));
        jPanel122.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel124.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 255, 255));
        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel124.setText("  Home Page");
        jPanel122.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel121.add(jPanel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel123.setBackground(new java.awt.Color(255, 51, 51));
        jPanel123.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel125.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel125.setText("  Home Page");
        jPanel123.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel124.setBackground(new java.awt.Color(255, 51, 51));
        jPanel124.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(255, 255, 255));
        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel126.setText("  Home Page");
        jPanel124.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel123.add(jPanel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel121.add(jPanel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel117.add(jPanel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel109.add(jPanel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel127.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(153, 153, 153));
        jLabel127.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel127.setText("  View Issued Books");
        jLabel127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel127MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel127MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel127MouseExited(evt);
            }
        });
        jPanel109.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(jPanel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, -1, 60));

        jPanel125.setBackground(new java.awt.Color(51, 51, 51));
        jPanel125.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel126.setBackground(new java.awt.Color(255, 51, 51));
        jPanel126.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(255, 255, 255));
        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel128.setText("  Home Page");
        jPanel126.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel125.add(jPanel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel127.setBackground(new java.awt.Color(255, 51, 51));
        jPanel127.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel129.setText("  Home Page");
        jPanel127.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel128.setBackground(new java.awt.Color(255, 51, 51));
        jPanel128.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel130.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(255, 255, 255));
        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel130.setText("  Home Page");
        jPanel128.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel127.add(jPanel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel125.add(jPanel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel129.setBackground(new java.awt.Color(255, 51, 51));
        jPanel129.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel131.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(255, 255, 255));
        jLabel131.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel131.setText("  Home Page");
        jPanel129.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel130.setBackground(new java.awt.Color(255, 51, 51));
        jPanel130.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel132.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(255, 255, 255));
        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel132.setText("  Home Page");
        jPanel130.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel129.add(jPanel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel131.setBackground(new java.awt.Color(255, 51, 51));
        jPanel131.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel133.setText("  Home Page");
        jPanel131.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel132.setBackground(new java.awt.Color(255, 51, 51));
        jPanel132.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel134.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(255, 255, 255));
        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel134.setText("  Home Page");
        jPanel132.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel131.add(jPanel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel129.add(jPanel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel125.add(jPanel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel133.setBackground(new java.awt.Color(51, 51, 51));
        jPanel133.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel135.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel135.setText("  Dashboard");
        jPanel133.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel134.setBackground(new java.awt.Color(255, 51, 51));
        jPanel134.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel136.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(255, 255, 255));
        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel136.setText("  Home Page");
        jPanel134.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel133.add(jPanel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel135.setBackground(new java.awt.Color(255, 51, 51));
        jPanel135.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel137.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel137.setText("  Home Page");
        jPanel135.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel136.setBackground(new java.awt.Color(255, 51, 51));
        jPanel136.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel138.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(255, 255, 255));
        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel138.setText("  Home Page");
        jPanel136.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel135.add(jPanel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel133.add(jPanel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel137.setBackground(new java.awt.Color(255, 51, 51));
        jPanel137.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel139.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel139.setText("  Home Page");
        jPanel137.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel138.setBackground(new java.awt.Color(255, 51, 51));
        jPanel138.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel140.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 255, 255));
        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel140.setText("  Home Page");
        jPanel138.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel137.add(jPanel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel139.setBackground(new java.awt.Color(255, 51, 51));
        jPanel139.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 255, 255));
        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel141.setText("  Home Page");
        jPanel139.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel140.setBackground(new java.awt.Color(255, 51, 51));
        jPanel140.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel142.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel142.setText("  Home Page");
        jPanel140.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel139.add(jPanel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel137.add(jPanel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel133.add(jPanel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel125.add(jPanel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel143.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(153, 153, 153));
        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel143.setText("  Defaulter List");
        jLabel143.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel143MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel143MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel143MouseExited(evt);
            }
        });
        jPanel125.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(jPanel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, -1, 60));

        jPanel141.setBackground(new java.awt.Color(255, 0, 0));
        jPanel141.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel142.setBackground(new java.awt.Color(255, 51, 51));
        jPanel142.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel144.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(255, 255, 255));
        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel144.setText("  Home Page");
        jPanel142.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel141.add(jPanel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel143.setBackground(new java.awt.Color(255, 51, 51));
        jPanel143.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel145.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(255, 255, 255));
        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel145.setText("  Home Page");
        jPanel143.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel144.setBackground(new java.awt.Color(255, 51, 51));
        jPanel144.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel146.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(255, 255, 255));
        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel146.setText("  Home Page");
        jPanel144.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel143.add(jPanel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel141.add(jPanel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel145.setBackground(new java.awt.Color(255, 51, 51));
        jPanel145.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel147.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(255, 255, 255));
        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel147.setText("  Home Page");
        jPanel145.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel146.setBackground(new java.awt.Color(255, 51, 51));
        jPanel146.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel148.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(255, 255, 255));
        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel148.setText("  Home Page");
        jPanel146.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel145.add(jPanel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel147.setBackground(new java.awt.Color(255, 51, 51));
        jPanel147.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel149.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 255, 255));
        jLabel149.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel149.setText("  Home Page");
        jPanel147.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel148.setBackground(new java.awt.Color(255, 51, 51));
        jPanel148.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel150.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(255, 255, 255));
        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel150.setText("  Home Page");
        jPanel148.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel147.add(jPanel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel145.add(jPanel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel141.add(jPanel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel149.setBackground(new java.awt.Color(51, 51, 51));
        jPanel149.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel151.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel151.setText("  Dashboard");
        jPanel149.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel150.setBackground(new java.awt.Color(255, 51, 51));
        jPanel150.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel152.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(255, 255, 255));
        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel152.setText("  Home Page");
        jPanel150.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel149.add(jPanel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel151.setBackground(new java.awt.Color(255, 51, 51));
        jPanel151.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel153.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel153.setText("  Home Page");
        jPanel151.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel152.setBackground(new java.awt.Color(255, 51, 51));
        jPanel152.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(255, 255, 255));
        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel154.setText("  Home Page");
        jPanel152.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel151.add(jPanel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel149.add(jPanel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel153.setBackground(new java.awt.Color(255, 51, 51));
        jPanel153.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel155.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 255, 255));
        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel155.setText("  Home Page");
        jPanel153.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel154.setBackground(new java.awt.Color(255, 51, 51));
        jPanel154.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel156.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(255, 255, 255));
        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel156.setText("  Home Page");
        jPanel154.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel153.add(jPanel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel155.setBackground(new java.awt.Color(255, 51, 51));
        jPanel155.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(255, 255, 255));
        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel157.setText("  Home Page");
        jPanel155.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel156.setBackground(new java.awt.Color(255, 51, 51));
        jPanel156.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel158.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(255, 255, 255));
        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel158.setText("  Home Page");
        jPanel156.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jPanel155.add(jPanel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel153.add(jPanel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel149.add(jPanel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 340, 60));

        jPanel141.add(jPanel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 340, 60));

        jLabel159.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(255, 255, 255));
        jLabel159.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel159.setText("  Logout");
        jLabel159.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel159MouseClicked(evt);
            }
        });
        jPanel141.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel4.add(jPanel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, -1, 60));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 960));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel157.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel157.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numberOfBooks.setBackground(new java.awt.Color(102, 102, 102));
        lbl_numberOfBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_numberOfBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_numberOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_numberOfBooks.setText("10");
        jPanel157.add(lbl_numberOfBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 180, 60));

        jPanel12.add(jPanel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 260, 140));

        jLabel160.setBackground(new java.awt.Color(102, 102, 102));
        jLabel160.setFont(new java.awt.Font("Myanmar Text", 1, 20)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(102, 102, 102));
        jLabel160.setText("Student Details");
        jPanel12.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 270, 30));

        jPanel158.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel158.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_numberOfStudents.setBackground(new java.awt.Color(102, 102, 102));
        lbl_numberOfStudents.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_numberOfStudents.setForeground(new java.awt.Color(102, 102, 102));
        lbl_numberOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_numberOfStudents.setText("10");
        jPanel158.add(lbl_numberOfStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 180, 60));

        jPanel12.add(jPanel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 260, 140));

        jLabel162.setBackground(new java.awt.Color(102, 102, 102));
        jLabel162.setFont(new java.awt.Font("Myanmar Text", 1, 20)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(102, 102, 102));
        jLabel162.setText("No Of Students");
        jPanel12.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 270, 30));

        jLabel164.setBackground(new java.awt.Color(102, 102, 102));
        jLabel164.setFont(new java.awt.Font("Myanmar Text", 1, 20)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(102, 102, 102));
        jLabel164.setText("Issued Book");
        jPanel12.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 90, 270, 30));

        jPanel159.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel159.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_IssueBooks.setBackground(new java.awt.Color(102, 102, 102));
        lbl_IssueBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_IssueBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_IssueBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_IssueBooks.setText("10");
        jPanel159.add(lbl_IssueBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 180, 60));

        jPanel12.add(jPanel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, 260, 140));

        jPanel160.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel160.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_defaulterList.setBackground(new java.awt.Color(102, 102, 102));
        lbl_defaulterList.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_defaulterList.setForeground(new java.awt.Color(102, 102, 102));
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterList.setText("10");
        jPanel160.add(lbl_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 180, 60));

        jPanel12.add(jPanel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 120, 260, 140));

        jLabel166.setBackground(new java.awt.Color(102, 102, 102));
        jLabel166.setFont(new java.awt.Font("Myanmar Text", 1, 20)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(102, 102, 102));
        jLabel166.setText("Defaulter List");
        jPanel12.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 90, 270, 30));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name ", "Matric No", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(0, 102, 153));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(0, 102, 153));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_studentDetails);
        if (tbl_studentDetails.getColumnModel().getColumnCount() > 0) {
            tbl_studentDetails.getColumnModel().getColumn(0).setResizable(false);
            tbl_studentDetails.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 800, 250));

        jLabel167.setBackground(new java.awt.Color(102, 102, 102));
        jLabel167.setFont(new java.awt.Font("Myanmar Text", 1, 20)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(102, 102, 102));
        jLabel167.setText("No Of Book");
        jPanel12.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 270, 30));

        jLabel168.setBackground(new java.awt.Color(102, 102, 102));
        jLabel168.setFont(new java.awt.Font("Myanmar Text", 1, 20)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(102, 102, 102));
        jLabel168.setText("Book Details");
        jPanel12.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, 270, 30));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(0, 102, 153));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(0, 102, 153));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(40);
        jScrollPane3.setViewportView(tbl_bookDetails);
        if (tbl_bookDetails.getColumnModel().getColumnCount() > 0) {
            tbl_bookDetails.getColumnModel().getColumn(0).setResizable(false);
            tbl_bookDetails.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 670, 800, 250));

        PanelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel12.add(PanelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 390, 540, 450));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1570, 960));

        setSize(new java.awt.Dimension(1905, 1023));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked

        new MangeBooks().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jLabel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseEntered
        jPanel13.setBackground(mouseEntereColor);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseEntered

    private void jLabel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseExited
        jPanel13.setBackground(mouseExitColor);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseExited

    private void jLabel63MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseEntered
        jPanel45.setBackground(mouseEntereColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel63MouseEntered

    private void jLabel63MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseExited
        jPanel45.setBackground(mouseExitColor);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel63MouseExited

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked

        new MangeStudents().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel63MouseClicked

    private void jPanel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel61MouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel61MouseClicked

    private void jPanel61MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel61MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel61MouseEntered

    private void jLabel79MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseEntered
        jPanel61.setBackground(mouseEntereColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel79MouseEntered

    private void jLabel79MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseExited

        jPanel61.setBackground(mouseExitColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel79MouseExited

    private void jLabel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseClicked
        new IssueBook().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel79MouseClicked

    private void jLabel95MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseEntered

        jPanel77.setBackground(mouseEntereColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel95MouseEntered

    private void jLabel95MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseExited
        // TODO add your handling code here:
        jPanel77.setBackground(mouseExitColor);

    }//GEN-LAST:event_jLabel95MouseExited

    private void jLabel95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel95MouseClicked

        new ReturnBook().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel95MouseClicked

    private void jLabel111MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseEntered

        jPanel93.setBackground(mouseEntereColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel111MouseEntered

    private void jLabel111MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseExited
        jPanel93.setBackground(mouseExitColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel111MouseExited

    private void jLabel111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel111MouseClicked

        new ViewAllRecords().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel111MouseClicked

    private void jLabel127MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel127MouseEntered
        jPanel109.setBackground(mouseEntereColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel127MouseEntered

    private void jLabel127MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel127MouseExited
        jPanel109.setBackground(mouseExitColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel127MouseExited

    private void jLabel127MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel127MouseClicked
        new IssueBookDetails().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel127MouseClicked

    private void jLabel143MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel143MouseEntered
        jPanel125.setBackground(mouseEntereColor);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel143MouseEntered

    private void jLabel143MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel143MouseExited
        jPanel125.setBackground(mouseExitColor);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel143MouseExited

    private void jLabel143MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel143MouseClicked
        new DefualterList().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel143MouseClicked

    private void jLabel159MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel159MouseClicked
        new LoginPage().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel159MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPieChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel148;
    private javax.swing.JPanel jPanel149;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel150;
    private javax.swing.JPanel jPanel151;
    private javax.swing.JPanel jPanel152;
    private javax.swing.JPanel jPanel153;
    private javax.swing.JPanel jPanel154;
    private javax.swing.JPanel jPanel155;
    private javax.swing.JPanel jPanel156;
    private javax.swing.JPanel jPanel157;
    private javax.swing.JPanel jPanel158;
    private javax.swing.JPanel jPanel159;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel160;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_IssueBooks;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_numberOfBooks;
    private javax.swing.JLabel lbl_numberOfStudents;
    private rojerusan.RSTableMetro tbl_bookDetails;
    private rojerusan.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
