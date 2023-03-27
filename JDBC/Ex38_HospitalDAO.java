package day08.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Utils.MyUtil;

public class Ex38_HospitalDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pastmt =null;
	ResultSet rs = null;
	
	Ex38_HospitalDAO() {
		// Constructor 기본 생성자
		try {
		Class.forName("org.mariadb.jdbc.Driver");
		
		conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:포트번호/데이터베이스명",
				"이름",
				"패스워드"
				);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(conn != null) {
			System.out.println("Member Database OK!");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex38_HospitalDAO dao= new Ex38_HospitalDAO();
		Ex38_HospitalVO vo = dao.getHospitalInfo("분당서울대학교병원");
		System.out.println(vo.getAddr());
		System.out.println(vo); // toString으로 호출하지 않아도 toString이 호출됨.
	}
	
	public Ex38_HospitalVO getHospitalInfo(String hptl_nm) {
		Ex38_HospitalVO vo = new Ex38_HospitalVO();
		String sql = "select hptl_nm, sido_cd_nm, siggu_cd_nm, addr " + 
					"from hptl_mast " +
					"where hptl_nm = '" + hptl_nm + "'";
		System.out.println("[getHopitalInfo()]");
		System.out.println(MyUtil.ITALIC+MyUtil.MAGENTA + sql + MyUtil.END);
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// bind 변수를 활용하려면 preparedStatement를 활용한다.
			// sql을 완벽하게 string으로 만들어서 던지는 쿼리를 literal Query라고 하며,
			// 자주 사용할 경우 DBA와 만날 수 있다.
			if(rs.next()) {
				System.out.println("[getHospitalInfo()] There is data!!");
				vo.setHptlNm(hptl_nm);
				vo.setSidoCdNm(rs.getString("sido_cd_nm"));
				vo.setSigguCdNm(rs.getString("siggu_cd_nm"));
				vo.setAddr(rs.getString("addr"));
			} else {
				System.out.println("There is no data.");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}
