package com.Vcentry.tnstc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Vcentry.tnstc.initializer.Initializer;

public class RegPage extends Initializer{

	public static void enterUsername(String Username){
		getElementByName("REGPAGE_TYPE_USERNAME_NAME").sendKeys(Username);
		    }
	public static void enterPassword(String Password){
		getElementByName("REGPAGE_TYPE_PASSWORD_NAME").sendKeys(Password);
	}
	public static void enterConfirmPassword(String ConfirmPassword){
		getElementByName("REGPAGE_TYPE_CONFIRMPASSWORD_NAME").sendKeys(ConfirmPassword);		
	}
	public static void enterSecretQuestion(String SecretQuestion){
		WebElement dropdown= getElementByName("REGPAGE_SELECT_SECRETQUESTION_NAME");
		Select s=new Select(dropdown);
		s.selectByValue(SecretQuestion);
	}
	public static void enterAnswerSecretQuestion(String AnsSecretQuestion){
		getElementByName("REGPAGE_TYPE_ANSWERSECRETQUESTION_NAME").sendKeys(AnsSecretQuestion);
		
	}
 
}
