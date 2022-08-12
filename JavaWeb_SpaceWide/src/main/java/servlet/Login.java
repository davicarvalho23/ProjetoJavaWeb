package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAdm;

/**
 *
 * @author 
 */

@WebServlet("/ServletLogin")/*Mapeamento da URL que vem da tela */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String email = request.getParameter("email");
    	String senha = request.getParameter("senha");
    	
    	if(email != null || !senha.isEmpty() || senha != null |senha.isEmpty())  {
    		RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
    		request.setAttribute("msg", "Informe o Login novamente!"); 
    	redirecionar.forward(request, response); 
    	}else{
    	
    	}
       	
        processRequest(request, response);
    
  	ModelAdm modelLogin = new ModelAdm();
    	modelLogin.setEmail(email);
    	modelLogin.setSenha(senha);
    	
 }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
 