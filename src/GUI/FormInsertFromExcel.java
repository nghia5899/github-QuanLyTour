/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DataProvider;
import DAO.KhuyenMaiDAO;
import DTO.KhuyenMai;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author E7450
 */
public class FormInsertFromExcel extends javax.swing.JFrame {

    /**
     * Creates new form FormInsertFromExcel
     */
    public static FormKhuyenMai fkm = new FormKhuyenMai();
    DataProvider dataConn = new DataProvider();

    public FormInsertFromExcel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableImport = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnAddFileExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableImport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã khuyến mại", "Phần trăm", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        jScrollPane1.setViewportView(tableImport);

        btnAdd.setText("Thêm Nhiều");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClose.setText("Đóng");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnAddFileExcel.setText("Chọn File");
        btnAddFileExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFileExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(526, 526, 526)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(btnAddFileExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddFileExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkMaKm(String ma) throws SQLException {
//        DefaultTableModel tableModel = new DefaultTableModel();
        ResultSet rs = dataConn.GetData("select * from khuyenmai where makhuyenmai ='" + ma + "'");
        Integer countCheck = 0;
        while (rs.next()) {
            countCheck++;
        }
        if (countCheck == 0) {
            return true;
        } else {
            return false;
        }
    }

    String convertStringDate(String date) {
        String ArrStringDate[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String ArrNumberDate[] = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String newDateS = date;
        for (int i = 0; i < 12; i++) {
            newDateS = date.replaceAll(ArrStringDate[i], ArrNumberDate[i]);
            if (newDateS != date) {
                break;
            }
        }
        String newDate[] = newDateS.split("-");
        return newDate[2] + "-" + newDate[1] + "-" + newDate[0];
    }

    private void btnAddFileExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFileExcelActionPerformed
        // TODO add your handling code here:
        File excelFile;
        String defaultPath = "D:\\JAVA\\BTL\\github-QuanLyTour\\Ngocdata\\fileExcel";
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;
        JFileChooser jf = new JFileChooser(defaultPath);
        jf.setDialogTitle("Please select a excel file to import");
        int excelChooser = jf.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                //            String excelPath = jf.getSelectedFile().getAbsolutePath();
                excelFile = jf.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);

                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                DefaultTableModel tb = new DefaultTableModel();
                String colName[] = {"Check MaKM", "Mã khuyến mại", "Phần trăm", "Ngày bắt đầu", "Ngày kết thúc"};
                tb.setColumnIdentifiers(colName);
                tableImport.setModel(tb);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                for (int row = 1; row < excelSheet.getLastRowNum(); row++) {

                    Object rows[] = new Object[5];
                    XSSFRow excelRow = excelSheet.getRow(row);

                    XSSFCell excelMa = excelRow.getCell(0);
                    XSSFCell excelPhanTram = excelRow.getCell(1);
                    rows[1] = excelMa;
                    rows[2] = excelPhanTram;
                    rows[3] = convertStringDate(excelRow.getCell(2).toString());

                    rows[4] = convertStringDate(excelRow.getCell(3).toString());

                    try {
                        if (checkMaKm(excelMa.toString())) {
                            rows[0] = "Hợp lệ";
                        } else {
                            rows[0] = "Mã đã tồn tại";
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(FormInsertFromExcel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tb.addRow(rows);

//                    for (int column = 0; column < 10; column++) {
//                        XSSFCell excelCell = excelRow.getCell(column);
//                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FormInsertFromExcel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FormInsertFromExcel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnAddFileExcelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        tableImport.getModel();
        int coulmnTable = tableImport.getColumnCount();
        int rowTable = tableImport.getRowCount();
        int NumberAddSs = 0;
        for (int rows = 0; rows < rowTable; rows++) {
            String makhuyenmai, ngaybatdau, ngayketthuc;
            int phantram = 0;
            System.out.println(tableImport.getModel().getValueAt(rows, 1).toString());
            if (tableImport.getModel().getValueAt(rows, 0).toString().trim() == "Hợp lệ") {
                makhuyenmai = tableImport.getModel().getValueAt(rows, 1).toString();
                try {
                    phantram = Integer.parseInt(tableImport.getModel().getValueAt(rows, 2).toString());
                } catch (Exception e) {
                }
                ngaybatdau = tableImport.getModel().getValueAt(rows, 3).toString();
                ngayketthuc = tableImport.getModel().getValueAt(rows, 4).toString();
                KhuyenMai km = new KhuyenMai(makhuyenmai, phantram, ngaybatdau.toString(), ngayketthuc.toString());
                KhuyenMaiDAO kmdao = new KhuyenMaiDAO();
                kmdao.Insert(km);
                System.out.println(kmdao.Insert(km));
                NumberAddSs++;
            }
        }
        JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công " + NumberAddSs + " Mã khuyến mại!", "Thông báo", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        fkm.setVisible(true);
        this.setVisible(false);
        fkm.hienthiBang();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(FormInsertFromExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInsertFromExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInsertFromExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInsertFromExcel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInsertFromExcel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddFileExcel;
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableImport;
    // End of variables declaration//GEN-END:variables
}
