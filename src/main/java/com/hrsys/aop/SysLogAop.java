package com.hrsys.aop;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hrsys.annotation.SysControllerLog;
import com.hrsys.annotation.SysLog;
import com.hrsys.system.entity.Log;
import com.hrsys.system.service.ILogService;
import com.hrsys.user.entity.User;
import com.hrsys.user.service.ILoginService;
import com.hrsys.user.service.IUserRoleService;
import com.hrsys.user.service.IUserService;
import com.hrsys.user.service.impl.UserServiceImpl;


@Component
@Aspect

public class SysLogAop{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
	@Autowired
	private ILogService logService;
	@Autowired
	private IUserService userService;
	@Autowired
	private ILoginService loginService;
	
	/*@Pointcut("execution(public * *(..))")
	private void anyPublicOperation() {}
	
	@Pointcut("within(com.hrsys.*.service..*)")
	public void inServiceLayer() {}*/
	
	@Pointcut("@annotation(com.hrsys.annotation.SysLog)")
	public void LogAspect() {
	}
	@Pointcut("@annotation(com.hrsys.annotation.SysControllerLog)")
	public void LogControllerAspect() {
	}	
	@AfterThrowing(pointcut = "LogAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint point, Throwable e) throws Exception {
	
	}	
	@SuppressWarnings("deprecation")
	@Before("LogControllerAspect()")	
	public void doAroundAtController(JoinPoint point) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        HttpSession session = request.getSession();
        
       /* Object value = session.getAttribute("user");
		System.out.println("value:"+value);*/
		try {			
			if(user!=null) {
				
				Log log = new Log();
				Map<String, Object> map = this.getControllerMethodDescription(point);
				log.setModule(map.get("module").toString());
				log.setMethod(map.get("methods").toString());
				log.setOperationTime(new Date());
				
				//log.setUser(user);
				log.setUserName(user.getUserName());
				//log.setUser(user);
			
				//user.getLogs().add(log);	
				//logService.saveOrUpdate(log);
				logService.saveOrUpdate(log);
			}			
		} catch (Throwable e) {
			logger.error("异常信息:{}", e.getMessage());
			throw new RuntimeException(e);
		}
	
	}
	 @AfterThrowing("LogAspect()")
	public void doAround(JoinPoint point) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes)ra;
		HttpServletRequest request = sra.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		
		try {
			
			Log log = new Log();
			Map<String, Object> map = this.getControllerMethodDescription(point);
			log.setModule(map.get("module").toString());
			log.setMethod(map.get("methods").toString());
			log.setOperationTime(new Date());
			//log.setUser(user);
			log.setUserName(user.getUserName());
			//user.getLogs().add(log);				
			//logService.saveOrUpdate(log);
			logService.saveOrUpdate(log);
			
		} catch (Exception e) {
			//logger.error("异常信息:{}", e.getMessage());
			//throw new RuntimeException(e);
			e.printStackTrace();
		}
	
		
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Object> getMethodDescription(JoinPoint joinPoint) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					map.put("module", method.getAnnotation(SysLog.class).module());
					map.put("methods", method.getAnnotation(SysLog.class).methods());
					map.put("args", this.getArgs(method, arguments));
					String desc = method.getAnnotation(SysLog.class).description();
					if (StringUtils.isEmpty(desc))
						desc = "执行成功!";
					map.put("description", desc);
					break;
				}
			}
		}
		return map;
	}
	
	
    public  Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint)  throws Exception { 
    	Map<String, Object> map = new HashMap<String, Object>();
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
       
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                	 map.put("module", method.getAnnotation(SysControllerLog.class).module());
 					map.put("methods", method.getAnnotation(SysControllerLog.class).methods());
 					map.put("args", this.getArgs(method, arguments));
 					String desc = method.getAnnotation(SysControllerLog. class).description();  
                    
                }    
            }    
        }    
         return map;
    }
    private String getArgs(Method method, Object[] arguments) {
		StringBuilder builder = new StringBuilder("{");
		String params[] = parameterNameDiscoverer.getParameterNames(method);
		for (int i = 0; i < params.length; i++) {
			if(!StringUtils.equals("password", params[i])) {
				if(arguments[i].getClass().isArray()) {
					arguments[i] = Arrays.toString(makeArrayObject(arguments[i]).toArray());
				}
				builder.append(params[i]).append(":").append(arguments[i]);
				if(i != params.length - 1) {
					builder.append("; ");
				}
			}
        }
        return builder.append("}").toString();
    }
	
    private List<Object> makeArrayObject(Object array) {  
        List<Object> tem = new ArrayList<Object>();  
        for (int i = 0; i < Array.getLength(array); i++) {  
            tem.add(Array.get(array, i));  
        }  
        return tem;  
    } 
    
  
}