package member;

import java.util.Scanner;

public class account_service {

public void Sign_IN() { //회원가입
	
	
	
	
	
}

public void  login() {//로그인
	
	Scanner input = new Scanner(System.in);
	account_entity md = new account_entity();
	account_DAO ad = new account_DAO();
	System.out.println("아이디입력");
	String id = input.next();
	System.out.println("비번입력");
	String pwd = input.next();	

	ad.mapping_member(id);
	
	
	
}
	
public void modify() {//멤버수정 
	
	
}

}
