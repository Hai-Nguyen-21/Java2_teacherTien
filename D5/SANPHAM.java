/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D5;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ocean-tor
 */
public class SANPHAM extends javax.swing.JFrame {

    QLSP _qlsp = new QLSP();
    DefaultTableModel _table;
    Product _pd = new Product();
    
    /**
     * Creates new form SANPHAM
     */
    public SANPHAM() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        combobox();
        rdo_conHang.setSelected(true);
        _qlsp.addSP();
    }
    
    public void combobox(){
        String[] danhMuc = {
            "Laptop", "Smart Phone", "Tablet", "PC"
        };
        cbb_danhMuc.setModel(new DefaultComboBoxModel(danhMuc));
    }
    
    public void fillTable(){
        if (_qlsp.getList().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Dữ liệu trống");
            return;
        }
        
        int stt = 1;
        _table = (DefaultTableModel) tbl_product.getModel();
        _table.setRowCount(0);
        
        for (Product o : _qlsp.getList()) {
            _table.addRow(new Object[]{
                stt++, o.getNameProduct(), o.getCodeProduct(), o.getStatus()==1?"Còn hàng":"Hết hàng", o.getPrice(), o.getDanhMuc()
            });
        }
    }
    
    public void add(){
        Product pd = new Product();
        pd.setNameProduct(txt_name.getText());
        pd.setCodeProduct(txt_code.getText());
        if (rdo_conHang.isSelected()) {
            pd.setStatus(1);
        } else{
            pd.setStatus(0);
        }
        pd.setPrice(Double.parseDouble(txt_price.getText()));
        pd.setDanhMuc(cbb_danhMuc.getSelectedItem().toString());
        
        _qlsp.getList().add(pd);
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }
    
    public void update(){
        for (Product o : _qlsp.getList()) {
            if (o.getCodeProduct().equalsIgnoreCase(txt_code.getText())) {
                o.setNameProduct(txt_name.getText());
                if (rdo_conHang.isSelected()) {
                    o.setStatus(1);
                } else{
                    o.setStatus(0);
                }
                o.setPrice(Double.parseDouble(txt_price.getText()));
                o.setDanhMuc(cbb_danhMuc.getSelectedItem().toString());
            }
        }
    }
    
    public void remove(){
        int index = tbl_product.getSelectedRow();
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa bạn này khum?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            _qlsp.getList().remove(index);
        }
    }
    
    public void clear(){
        txt_code.setText("");
        txt_name.setText("");
        txt_price.setText("");
        cbb_danhMuc.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_code = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        cbb_danhMuc = new javax.swing.JComboBox<>();
        rdo_conHang = new javax.swing.JRadioButton();
        rdo_hetHang = new javax.swing.JRadioButton();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_product = new javax.swing.JTable();
        btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("TÊN SẢN PHẨM");

        jLabel2.setText("MÃ SẢN PHẨM");

        jLabel3.setText("ĐƠN GIÁ");

        jLabel4.setText("TÌNH TRẠNG");

        jLabel5.setText("DANH MỤC");

        buttonGroup1.add(rdo_conHang);
        rdo_conHang.setText("Còn hàng");

        buttonGroup1.add(rdo_hetHang);
        rdo_hetHang.setText("Hết hàng");

        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_remove.setText("REMOVE");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        tbl_product.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "TÊN SẢN PHẨM", "MÃ SẢN PHẨM", "TÌNH TRẠNG", "ĐƠN GIÁ", "DANH MỤC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_product);

        btn_exit.setText("EXIT");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_code, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(cbb_danhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update)
                        .addGap(18, 18, 18)
                        .addComponent(btn_remove)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(rdo_conHang)
                                .addGap(18, 18, 18)
                                .addComponent(rdo_hetHang))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_clear)))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_exit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_conHang)
                    .addComponent(rdo_hetHang))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbb_danhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_update)
                    .addComponent(btn_remove)
                    .addComponent(btn_clear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        add();
        fillTable();
        clear();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        update();
        fillTable();
        clear();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // TODO add your handling code here:
        remove();
        fillTable();
        clear();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void tbl_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productMouseClicked
        // TODO add your handling code here:
        _table = (DefaultTableModel) tbl_product.getModel();
        int index = tbl_product.getSelectedRow();
        _pd = _qlsp.getList().get(index);
        
        txt_code.setText(_pd.getCodeProduct());
        txt_name.setText(_pd.getNameProduct());
        if (_pd.getStatus() == 1) {
            rdo_conHang.setSelected(true);
        } else{
            rdo_hetHang.setSelected(true);
        } 
        txt_price.setText(_table.getValueAt(index, 4).toString());
        cbb_danhMuc.setSelectedItem(_pd.getDanhMuc().toString());
    }//GEN-LAST:event_tbl_productMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

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
            java.util.logging.Logger.getLogger(SANPHAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SANPHAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SANPHAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SANPHAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SANPHAM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbb_danhMuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_conHang;
    private javax.swing.JRadioButton rdo_hetHang;
    private javax.swing.JTable tbl_product;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables
}