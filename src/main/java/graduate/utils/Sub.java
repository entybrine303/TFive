package graduate.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Sub {
//	Dùng để kiểm tra xem username đã được khởi tạo trong session hay chưa, chưa thì khởi tạo và gán giá trị bằng null
	public void checkUsername(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
		    username = null; // Gán giá trị null nếu chưa được khởi tạo
		    session.setAttribute("username", username);
		}

	}
	
}
