package web;

import models.view.ProductViewModel;
import org.modelmapper.ModelMapper;
import services.ProductsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/products/all")
public class ProductsAllServlet extends HttpServlet{
    private final ProductsService productsService;
    private final ModelMapper mapper;

    @Inject
    public ProductsAllServlet(ProductsService productsService,
                          ModelMapper mapper){
        this.productsService = productsService;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductViewModel> products = productsService.getAll()
                .stream()
                .map(product -> mapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());

        req.setAttribute("viewModel",products);
        req.getRequestDispatcher("/products-all.jsp")
                .forward(req,resp);
    }
}
