package org.itstep.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {
    private String viewPrefix;
    private String viewSuffix;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        viewPrefix = config.getServletContext().getInitParameter("viewPrefix");
        viewPrefix = viewPrefix == null ? "/WEB-INF/view/" : viewPrefix;
        viewSuffix = config.getServletContext().getInitParameter("viewSuffix");
        viewSuffix = viewPrefix == null ? "/WEB-INF/view/" : viewSuffix;
    }

    protected void forwardView(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(String.format("%s%s%s", viewPrefix, "index", viewSuffix)).forward(req, resp);
    }
}
