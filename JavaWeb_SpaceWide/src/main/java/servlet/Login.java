package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 
 */

@WebServlet("/ServletLogin")/*Mapeamento da URL que vem da tela */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String email = request.getParameter("email");
String senha = request.getParameter("senha");
HttpSession sessao = request.getSession();
if(email.equals("admin")&& senha.equals("123")){
    sessao.setAttribute("email", email);
    request.setAttribute("email", email);
    request.getRequestDispatcher("index.jsp").forward(request, response);
}else{
    request.setAttribute("falha", "Erro de Autenticação");
    request.getRequestDispatcher("login.jsp").forward(request, response);
}

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
 