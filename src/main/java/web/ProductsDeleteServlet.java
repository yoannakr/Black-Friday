package web;

import org.modelmapper.ModelMapper;
import services.ProductsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/delete")
public class ProductsDeleteServlet extends HttpServlet {
    private final ProductsService productsService;
    private final ModelMapper mapper;
    int id;

    @Inject
    public ProductsDeleteServlet(ProductsService productsService,
                                 ModelMapper mapper){
        this.productsService = productsService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        id = Integer.parseInt(req.getParameter("id"));

        req.getRequestDispatcher("/products-delete.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            productsService.deleteProduct(id);
            resp.sendRedirect("/home");
        } catch (Exception e) {
            resp.sendRedirect("/users/register");
        }
    }
}
