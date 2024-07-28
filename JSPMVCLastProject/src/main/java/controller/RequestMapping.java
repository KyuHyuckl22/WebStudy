package controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) // 객체 저장 기간 => Runtime 을 사용하게되면 프로그램 종료시 까지 유지하게 만들어줌
@Target(METHOD) // target => 구분자
/*
 *  TYPE		: 클래스 구분자	
 *  METHOD		: 메소드 구분자
 *  PARAMETER	: 매개변수 구분자
 *  FIELD		: 멤버변수, 멤버객체 구분자
 *  
 *  사용 위치 (위에 달려 있어야 함) 
 *  @ ==> TYPE
 *  public class ClassName
 *  {
 *  	@==> Field
 *  	A a;
 *  	
 *  	@==> METHOD
 *  	public void display()
 *  	{
 *  	}
 *  	public void set A(@==>PARAMETER A a)
 *  	{
 *  	}
 *  
 *  }
 *  
 *  
 *  
 */
public @interface RequestMapping {
	public String value();
}















