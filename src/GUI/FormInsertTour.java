/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DataProvider;
import DAO.TourDAO;
import DTO.Tour;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author E7450
 */
public class FormInsertTour extends javax.swing.JFrame {

    /**
     * Creates new form FormInsertTour
     */
    public static FormQuanLyTour fqlt = new FormQuanLyTour();
    DataProvider dataConn = new DataProvider();

    public FormInsertTour() {
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

        btnAddExcel = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();
        btnfile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddExcel.setText("Thêm nhiều");
        btnAddExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExcelActionPerformed(evt);
            }
        });

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });

        btnfile.setText("Chọn FIle");
        btnfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfileActionPerformed(evt);
            }
        });

        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Tour", "Tên Tour", "Điểm xuất phát", "Địa điểm", "Dịch vụ", "Điểm du lịch", "Thời gian tour", "Giá Tour", "nul"
            }
        ));
        jScrollPane1.setViewportView(tbData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnfile)
                .addGap(503, 503, 503))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddExcel)
                        .addGap(894, 894, 894)
                        .addComponent(btnDong)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnfile)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDong)
                    .addComponent(btnAddExcel))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:

        fqlt.setVisible(true);
        this.setVisible(false);
        fqlt.hienThiBang();
    }//GEN-LAST:event_btnDongActionPerformed

    public boolean checkMaTour(String ma) throws SQLException {

        ResultSet rs = dataConn.GetData("select * from tour where matour ='" + ma + "'");
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

    public boolean checkMaKm(String ma) throws SQLException {

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

    private void btnfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfileActionPerformed
        // TODO add your handling code here:

        File excelFile;
        String defaultPath = "C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\QuanLyTour\\Ngocdata\\fileExcel";
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;
        JFileChooser jf = new JFileChooser(defaultPath);
        jf.setDialogTitle("Please select a excel file to import");
        int excelChooser = jf.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                String excelPath = jf.getSelectedFile().getAbsolutePath();
                excelFile = jf.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);

                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                DefaultTableModel tb = new DefaultTableModel();
                String colName[] = {"Kiểm tra", "Mã Tour", "Tên Tour", "Điểm xuất phát", "Địa điểm", "Dịch vụ", "Điểm du lịch", "Thời gian tour", "Giá tour", "Mã khuyến mại"};
                tb.setColumnIdentifiers(colName);
                tbData.setModel(tb);

                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {

                    Object rows[] = new Object[100];
                    XSSFRow excelRow = excelSheet.getRow(row);

                    XSSFCell excelMa = excelRow.getCell(0);
                    XSSFCell excelTentour = excelRow.getCell(1);
                    XSSFCell exceldiemxp = excelRow.getCell(2);
                    XSSFCell excelDiadiem = excelRow.getCell(3);
                    XSSFCell excelDichvu = excelRow.getCell(4);
                    XSSFCell excelDiemDL = excelRow.getCell(5);
                    XSSFCell excelTgTour = excelRow.getCell(6);
                    XSSFCell excelGia = excelRow.getCell(7);
                    XSSFCell excelMakm = excelRow.getCell(8);

                    rows[1] = excelMa;
                    rows[2] = excelTentour;
                    rows[3] = exceldiemxp;
                    rows[4] = excelDiadiem;
                    rows[5] = excelDichvu;
                    rows[6] = excelDiemDL;
                    rows[7] = excelTgTour;
                    rows[8] = excelGia;
                    rows[9] = excelMakm;

                    try {
                        if (checkMaTour(excelMa.toString())) {
                            if (!checkMaKm(excelMakm.toString())) {
                                rows[0] = "Hợp lệ";
                            } else {
                                rows[0] = "Mã KM không hợp lệ";
                            }
                        } else {
                            rows[0] = "Mã tour đã tồn tại";
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
    }//GEN-LAST:event_btnfileActionPerformed

    private void btnAddExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExcelActionPerformed
        // TODO add your handling code here:
        tbData.getModel();
        int coulmnTable = tbData.getColumnCount();
        int rowTable = tbData.getRowCount();
        int NumberAddSs = 0;
        for (int rows = 0; rows < rowTable; rows++) {
            String matour, tentour, diemxp, diadiem, dichvu, diemdl, tgtour, makm;
            int giatour = 0;
            System.out.println(tbData.getModel().getValueAt(rows, 1).toString());
            if (tbData.getModel().getValueAt(rows, 0).toString().trim() == "Hợp lệ") {
                matour = tbData.getModel().getValueAt(rows, 1).toString();
                try {
                    giatour = Integer.parseInt(tbData.getModel().getValueAt(rows, 8).toString());
                } catch (Exception e) {
                }
                tentour = tbData.getModel().getValueAt(rows, 2).toString();
                diemxp = tbData.getModel().getValueAt(rows, 3).toString();
                diadiem = tbData.getModel().getValueAt(rows, 4).toString();
                dichvu = tbData.getModel().getValueAt(rows, 5).toString();
                diemdl = tbData.getModel().getValueAt(rows, 6).toString();
                tgtour = tbData.getModel().getValueAt(rows, 7).toString();
                makm = tbData.getModel().getValueAt(rows, 9).toString();

                Tour t = new Tour(matour, tentour, diemxp, diadiem, dichvu, diemdl, tgtour, giatour,makm);
                TourDAO tourdao = new TourDAO();
                tourdao.Insert(t);
                System.out.println(tourdao.Insert(t));
                NumberAddSs++;
            }
        }
        JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công " + NumberAddSs + " Mã Tour!", "Thông báo", JOptionPane.OK_OPTION);
    }//GEN-LAST:event_btnAddExcelActionPerformed

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
            java.util.logging.Logger.getLogger(FormInsertTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInsertTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInsertTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInsertTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInsertTour().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddExcel;
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnfile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbData;
    // End of variables declaration//GEN-END:variables
}
