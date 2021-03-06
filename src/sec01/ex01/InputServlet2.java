package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 방식 UTF-8로 설정하여 한글깨짐 방지 
		request.setCharacterEncoding("UTF-8");
		
		//Enumeration인터페이스의 자식배열객체에 담아....
		//Enumeration 인터페이스의 자식배열객체 자체를 반환함.
		Enumeration enu = request.getParameterNames();
		
		//이뉴얼레이션 반복기 역할을 하는 배열에 <input>태그의 name속성값이 하나라도 존재하는동안
		//반복 돌리겠다.
		while(enu.hasMoreElements()) {
			//이뉴멀레이션 반복기 연할을 하는 배열객체의 nextElement()메소드는?
			//배열의 0번째 인덱스 위치에 있는 <input>태그의 name속성값부터 자체로 얻어올때 사용
			//참고 : nextElement()메소드는 조상 Object 클래스타입으로 자식 String객체값을 반환함.
			String name = (String)enu.nextElement();
			
			//각 <input>태그의 name속성값을 하나씩 전달하여 그에 대응되는 전송(요청)되어오는 값을 얻어온다.
			String[] values = request.getParameterValues(name);
			
			for(String value : values) {
				System.out.println("name=" + name + ",value=" + value);
			}
		}
	}//doGet메소드 끝부분 
}//InputServlet2클래스 
