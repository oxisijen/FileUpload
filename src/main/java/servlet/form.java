package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/form")
@MultipartConfig
public class form extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/form.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		
		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part=request.getPart("pict");
		
		//ファイル名を取得
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/upload");
		
		//実際にファイルが保存されるパス確認
		System.out.println(path);
		
		//書き込み
		part.write(path+File.separator+filename);
		request.setAttribute("name",name);
		request.setAttribute("filename", filename);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

}
