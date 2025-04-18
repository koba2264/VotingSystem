import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Question;
import dao.ResultDAO;
import tool.Action;

public class ResultAction extends Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	request.setCharacterEncoding("UTF-8");
    	
    	ResultDAO dao = new ResultDAO();
        Question question = dao.search();
        

        request.setAttribute("question", question);
        
        return "WEB-INF/ans.jsp";
    }
}
