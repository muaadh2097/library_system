/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author muaadh
 */
public class MangeBooks extends javax.swing.JFrame {

    
    
         String bookName,author;
        int bookId,quantity;
        DefaultTableModel model;
    /**
     * Creates new form MangeBooks
     */
    public MangeBooks() {
        initComponents();
        setBookDetailToTable();
    }
    
    //To Set book detail inot table
    public void setBookDetailToTable(){
   
        try {
              Class.forName("com.mysql.jdbc.Driver");
                             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
                             Statement st = con.createStatement();

                     ResultSet rs = st.executeQuery("select * from book_details");
                      while (rs.next()) {
                          String bookId = rs.getString("book_id");
                          String bookName = rs.getString("book_name");
                          String author = rs.getString("author");
                          int quanitiy = rs.getInt("quantity");
                          
                          Object[] obj = {bookId,bookName,author,quanitiy};
                          model = (DefaultTableModel)tbl_bookDetails.getModel();
                          model.addRow(obj);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
    // to add a book to book_details
    public boolean addStudent(){
        boolean isAdded = false;
        bookId = Integer.parseInt(txt_BookId.getText());
        bookName = txt_BookName.getText();
        author = txt_AuthorName.getText();
        quantity = Integer.parseInt(txt_Quntity.getText());

            try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into book_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,bookName);
            pst.setString(3,author);
            pst.setInt(4,quantity);
                    
            int rowCout = pst.executeUpdate();
            
            if(rowCout>0){
                isAdded = true;
            }else{
                isAdded = false;
            }
                    ;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return isAdded;
    }
    
    public boolean updateStudent(){
          boolean isUpdated = false;
        bookId = Integer.parseInt(txt_BookId.getText());
        bookName = txt_BookName.getText();
        author = txt_AuthorName.getText();
        quantity = Integer.parseInt(txt_Quntity.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set book_name = ?,author = ?,quantity = ? where book_id = ? ";
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setString(1,bookName);
            pst.setString(2,author);
            pst.setInt(3,quantity);
            pst.setInt(4,bookId);
            
           int rowCout=pst.executeUpdate();
           if(rowCout>0){
                isUpdated = true;
            }else{
                isUpdated = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
                        return isUpdated;

    }
    
        // method to delete book details
        public boolean deleteStudent(){
            boolean isDeleted = false;
                    bookId = Integer.parseInt(txt_BookId.getText());
try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from book_details where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql); 
            pst.setInt(1,bookId);
            
           int rowCout=pst.executeUpdate();
           if(rowCout>0){
                isDeleted = true;
            }else{
                isDeleted = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
            return isDeleted;
        }

    
      // method to clear table 
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) tbl_bookDetails.getModel();
        model.setRowCount(0);
    }   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_BookId = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_BookName = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_AuthorName = new app.bolivia.swing.JCTextField();
        txt_Quntity = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojerusan.RSTableMetro();
        jLabel168 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 60));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 70, 50));

        txt_BookId.setBackground(new java.awt.Color(204, 204, 204));
        txt_BookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_BookId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_BookId.setPlaceholder("Enter Book Id");
        txt_BookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookIdFocusLost(evt);
            }
        });
        txt_BookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_BookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 300, 30));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Book Id");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 300, 50));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 70, 50));

        txt_BookName.setBackground(new java.awt.Color(204, 204, 204));
        txt_BookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_BookName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_BookName.setPlaceholder("Enter Book Name");
        txt_BookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_BookNameFocusLost(evt);
            }
        });
        txt_BookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 360, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Entter Book Name:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 300, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 70, 50));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Author Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 300, 50));

        txt_AuthorName.setBackground(new java.awt.Color(204, 204, 204));
        txt_AuthorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_AuthorName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_AuthorName.setPlaceholder("Enter Author Name");
        txt_AuthorName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_AuthorNameFocusLost(evt);
            }
        });
        txt_AuthorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AuthorNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_AuthorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 360, 30));

        txt_Quntity.setBackground(new java.awt.Color(204, 204, 204));
        txt_Quntity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_Quntity.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_Quntity.setPlaceholder("Enter Qauntity");
        txt_Quntity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_QuntityFocusLost(evt);
            }
        });
        txt_Quntity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_QuntityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_Quntity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 370, 30));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Qauntity");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 300, 50));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 70, 50));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Delete");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 620, 150, 80));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Add");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 150, 80));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle4.setText("Update");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 620, 150, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 110, 50));

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(0, 102, 153));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_bookDetails.setRowHeight(40);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_bookDetails);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 800, 250));

        jLabel168.setBackground(new java.awt.Color(255, 255, 255));
        jLabel168.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 51, 0));
        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel168.setText("  Manage Books");
        jPanel3.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 270, 50));

        jPanel5.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 410, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1150, 830));

        setSize(new java.awt.Dimension(1742, 871));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

                                new HomePage().setVisible(true);
                                this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_BookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookIdFocusLost

    private void txt_BookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookIdActionPerformed

    private void txt_BookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_BookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookNameFocusLost

    private void txt_BookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookNameActionPerformed

    private void txt_AuthorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_AuthorNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AuthorNameFocusLost

    private void txt_AuthorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AuthorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AuthorNameActionPerformed

    private void txt_QuntityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_QuntityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_QuntityFocusLost

    private void txt_QuntityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_QuntityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_QuntityActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
     if (deleteStudent()== true) {
            JOptionPane.showMessageDialog(this,"Book Deleted");
            clearTable();
            setBookDetailToTable();
        }else{
             JOptionPane.showMessageDialog(this,"Book Deleation Failed");

        }        // TODO add your handling code here:

    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (addStudent()== true) {
            JOptionPane.showMessageDialog(this,"Book Added");
            clearTable();
            setBookDetailToTable();
        }else{
             JOptionPane.showMessageDialog(this,"Book Addiation Failed");

        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
  if (updateStudent()== true) {
            JOptionPane.showMessageDialog(this,"Book Updated");
            clearTable();
            setBookDetailToTable();
        }else{
             JOptionPane.showMessageDialog(this,"Book Updation Failed");

            }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed
    }
    
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
                        System.exit(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        int rowNo = tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();
        
        txt_BookId.setText(model.getValueAt(rowNo,0).toString());
        txt_BookName.setText(model.getValueAt(rowNo,1).toString());
        txt_AuthorName.setText(model.getValueAt(rowNo,2).toString());
        txt_Quntity.setText(model.getValueAt(rowNo,3).toString());

        
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(MangeBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MangeBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MangeBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MangeBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MangeBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_AuthorName;
    private app.bolivia.swing.JCTextField txt_BookId;
    private app.bolivia.swing.JCTextField txt_BookName;
    private app.bolivia.swing.JCTextField txt_Quntity;
    // End of variables declaration//GEN-END:variables
}
