package school;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class StudentServlet extends HttpServlet {
    private List<Student> productList;

    @Override
    public void init() throws ServletException {
        super.init();
        productList = new ArrayList<>();
        productList.add(new Student(1,"Nguyen Van A", 9, "A"));
        productList.add(new Student(2,"Nguyen Van B", 8.5, "A"));
        productList.add(new Student(3,"Tran Thi C", 7, "B"));
        productList.add(new Student(4,"Pham Tuan D", 6, "C"));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showProductList(request, response);
        }else {
            switch (action) {
                case "new":
                    showCreateForm(request,response);
                    break;
                case "create":
                    createProduct(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateProduct(request,response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                default:
                    showProductList(request, response);
                    break;
            }

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }





    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hiển thị trang tạo sản phẩm
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = productList.size() + 1;
        String name = request.getParameter("name");
        double scores = Double.parseDouble(request.getParameter("scores"));
        String grade = request.getParameter("grade");

        Student newProduct = new Student(id, name, scores, grade);
        productList.add(newProduct);

        response.sendRedirect("products");

    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID sản phẩm cần chỉnh sửa từ request
        int productId = Integer.parseInt(request.getParameter("id"));

        // Tìm sản phẩm trong danh sách theo ID
        Student product = getProductById(productId);

        if (product == null) {
            // Nếu không tìm thấy sản phẩm, chuyển hướng về trang danh sách sản phẩm
            response.sendRedirect("products");
            System.out.println("khong thay san pham");
            return;
        }
        // Đặt sản phẩm vào attribute của request để hiển thị trên trang chỉnh sửa
        request.setAttribute("product", product);

        // Hiển thị trang chỉnh sửa sản phẩm
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);

    }
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin sản phẩm từ request
        int productId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double scores = Double.parseDouble(request.getParameter("scores"));
        String grade = request.getParameter("grade");

        // Tìm sản phẩm trong danh sách theo ID
        Student product = getProductById(productId);

        if (product == null){
            // Nếu không tìm thấy sản phẩm, chuyển hướng về trang danh sách sản phẩm
            response.sendRedirect("products");
        }
        // Cập nhật thông tin sản phẩm
        product.setName(name);
        product.setScores(scores);
        product.setGrade(grade);

        // Chuyển hướng về trang danh sách sản phẩm

        response.sendRedirect("products");
    }


    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy ID sản phẩm cần xóa từ request
        int productId = Integer.parseInt(request.getParameter("id"));

        // Tìm sản phẩm trong danh sách theo ID
        Student product = getProductById(productId);

        if (product == null) {
            // Nếu không tìm thấy sản phẩm, chuyển hướng về trang danh sách sản phẩm
            response.sendRedirect("products");
        }
        // Xóa sản phẩm khỏi danh sách
        productList.remove(product);

        // Chuyển hướng về trang danh sách sản phẩm
        response.sendRedirect("products");

    }

    private Student getProductById(int productId) {
        for (Student product : productList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}