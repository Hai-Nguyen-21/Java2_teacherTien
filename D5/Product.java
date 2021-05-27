/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D5;

/**
 *
 * @author ocean-tor
 */

/*Xây dựng giao diện như hình trên (1đ)
Khi click vào button Xóa Form, thực hiện xóa trắng form (1đ)
Khi click vào button Thêm, thực hiện đọc dữ liệu trên form & lưu xuống JTable. (2đ)
Click vào 1 dòng trên JTable, hiển thị dữ liệu dòng đó lên form (1đ).
Click vào button Xóa, xóa dòng đang được chọn trên JTable (1.5đ)
Click button Sửa, cập nhật dữ liệu từ form vào dòng đang được chọn trên JTable (1.5đ)
Khi click button Thêm hoặc Sửa, thực hiện kiểm tra form không được để trống (1đ)
Sử dụng interface cho lớp QuanLySanPham(1đ).*/

public class Product {
    private String nameProduct;
    private String codeProduct;
    private String danhMuc;
    private int status;
    private double price;
    
    public Product(){
        
    }

    public Product(String nameProduct, String codeProduct, String danhMuc, int status, double price) {
        this.nameProduct = nameProduct;
        this.codeProduct = codeProduct;
        this.danhMuc = danhMuc;
        this.status = status;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
