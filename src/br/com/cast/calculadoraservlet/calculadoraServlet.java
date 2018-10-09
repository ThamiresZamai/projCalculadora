package br.com.cast.calculadoraservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Cal")
public class calculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		principal(writer);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		String operacao = req.getParameter("operacao");

		double valor1 = Double.parseDouble(req.getParameter("valor1"));
		double valor2 = Double.parseDouble(req.getParameter("valor2"));
		double result = 0;

		if (operacao.equals("somar")) {
			result = valor1 + valor2;
			principalResult(writer, result);

		}
		if (operacao.equals("multiplicar")) {
			result = valor1 * valor2;
			principalResult(writer, result);
		}
		if (operacao.equals("dividir")) {
			result = valor1 / valor2;
			if (valor1 == 0 || valor2 == 0) {
				principal(writer);
				writer.append("Não tem divisão por zero");
			} else {
				principalResult(writer, result);
			}
		}
		if (operacao.equals("subtrair")) {
			result = valor1 - valor2;
			if (valor1 < valor2) {
				principal(writer);
				writer.append("Conta inválida");
			} else {
				principalResult(writer, result);
			}
		}
		if(operacao.equals("limpar")) {
			
			principal(writer);
		}

	}

	public void principalResult(PrintWriter writer, double result) {

		writer.append("<html>");
		writer.append("<body>");

		writer.append("<form action='/Calculadora/Cal' method='post'>");
		writer.append("<laber>valor1</laber><br/>");
		writer.append("<input name='valor1' type='text'> <br/><br/>");
		writer.append("<laber>valor2</laber><br/>");
		writer.append("<input name='valor2' type='text'><br/><br/>");
		
	
		writer.append("<laber>resultado</laber><br/>");
		writer.append("<input name='resultado' type='text' value=" + result + "><br/><br/>");
		
		writer.append("<input name='operacao' type='submit' value='somar'>&nbsp;");
		writer.append("<input name='operacao' type='submit' value='multiplicar'>&nbsp;");
		writer.append("<input name='operacao' type='submit' value='dividir'>&nbsp;");
		writer.append("<input name='operacao' type='submit' value='subtrair'><br/><br/>");
		writer.append("<input name='operacao' type='submit' value='limpar'>");

		writer.append("</form>");
		writer.append("</body>");
		writer.append("</html>");
	}

	public void principal(PrintWriter writer) {

		writer.append("<html>");
		writer.append("<body>");

		writer.append("<form action='/Calculadora/Cal' method='post'>");
		writer.append("<laber>valor1</laber><br/>");
		writer.append("<input name='valor1' type='text'> <br/><br/>");
		writer.append("<laber>valor2</laber><br/>");
		writer.append("<input name='valor2' type='text'><br/><br/>");
		
	
		writer.append("<laber>resultado</laber><br/>");
		writer.append("<input name='resultado' type='text'><br/><br/>");
		
		writer.append("<input name='operacao' type='submit' value='somar'>&nbsp;");
		writer.append("<input name='operacao' type='submit' value='multiplicar'>&nbsp;");
		writer.append("<input name='operacao' type='submit' value='dividir'>&nbsp;");
		writer.append("<input name='operacao' type='submit' value='subtrair'><br/><br/>");
		writer.append("<input name='operacao' type='submit' value='limpar'>");

		writer.append("</form>");
		writer.append("</body>");
		writer.append("</html>");
	}
	
}
