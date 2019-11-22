package com.team5.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
	}
//	 @Override
//	 public void run(String... args) throws Exception {
//
//	 addSampleData();
//	 
//	 }
//
//	private void addSampleData() {
//		
//		for(int i=14000;i<24001;i++)
//		{
//			user = new TwitterUser( "TwitterUser:"+i, "twitteruser"+i+"@xyz.com", "twitter"+i, "Hi I am twitteruser"+i, "San Jose Block:"+i, "@twitteruser"+i, "10/10/2000", "TestTwitterUser"+i+".jpg");
//			t1 = new Tweet("tweet"+i, "Hi, I am user tweeting from my account@@"+i, 1);
//			tweets[0]=t1;
//			user.setTweets(tweets); 
//			repository.save(user);
//			// addSampleinMySQl(user);
//		}
//		 
//		
//	}
//
//	private void addSampleinMySQl(TwitterUser save) {
//		
//		System.out.println("Object to be pushed to mysql"+save.toString());
//		mysql = new TwitterUserMysql(save.getName(), save.getId(), save.getEmail(), save.getPassword(), save.getBio(), save.getLocation(), save.getUserHandle(), save.getBirthDate(), save.getCoverImage());
//		 mysqlRepository.save(mysql);
//	}
}
	
