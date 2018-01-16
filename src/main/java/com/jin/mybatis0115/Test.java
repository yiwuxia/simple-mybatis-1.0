package com.jin.mybatis0115;

import java.io.Reader;
import java.security.spec.ECFieldF2m;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yihaomen.mybatis.model.User;

public class Test {
	
	 private static SqlSessionFactory sqlSessionFactory;
	    private static Reader reader; 
	    
	    static{
	        try{
	            reader    = Resources.getResourceAsReader("mybatis-config.xml");
	            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }

	    public static SqlSessionFactory getSession(){
	        return sqlSessionFactory;
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    SqlSession session = sqlSessionFactory.openSession();
        try {
        User user = (User) session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1);
        User user2 = (User) session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1);
        System.out.println(user.getUserAddress());
        System.out.println(user.getUserName());
        
        
        
        } finally {
        session.close();
        }
	    /*SqlSession session = sqlSessionFactory.openSession(); // 打开会话，事务开始  
        
        try {  
            int affectedCount = session.update("com.yihaomen.mybatis.models.UserMapper.updateUser");  
          //  int i = 2 / 0; // 触发运行时异常  
            session.commit(); // 提交会话，即事务提交  
        }catch(Exception e){
        	e.printStackTrace();
        }finally {  
            session.close(); // 关闭会话，释放资源  
        } */
	}

}
