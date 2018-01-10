package com.hrsys.shiro;

import java.security.NoSuchAlgorithmException;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;

import com.hrsys.common.Encrypt;
import com.hrsys.common.EncryptUtils;



public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	//密码比较的方法   token代表用户在界面输入的用户名和密码     info代表从数据库中得到加密数据
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		// 向下转型
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 获取用户界面输入的密码并加密
		Object clientPassword = new Md5Hash(new String(upToken.getPassword()), upToken.getUsername(),2);
	//	Object clientPassword = EncryptUtils.encript(upToken.getPassword());
		// 获取数据库密文
		Object dbPassword = info.getCredentials();
		System.out.println("进入密码比较器-------------------------输入的密码为:"+clientPassword+"   数据库密码:"+dbPassword);
		return this.equals(clientPassword, dbPassword);
	}

	
}
