package me.viitor.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetAPI {
	
	public static void update(String msg) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("GkOfrz8VGtAYdBBOMqeyFJuMx");
		cb.setOAuthConsumerSecret("dWUWhRbwrhJ0zlB0uOqBkomjOW1fy7Uw672bcdJy3aLKbx4wbk");
		cb.setOAuthAccessToken("802248250128560128-8oRj9a1ObrYyRzbHz0hZZqefCEnGZCS");
		cb.setOAuthAccessTokenSecret("JktlZYtqUZkdyhrcpLNNMUcWFvkW9Qh7wBTwGuEYuu8u3");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus(msg);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updatePrincipal(String msg) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("4drHxbmKXv3pYeDuRzTEQmktP");
		cb.setOAuthConsumerSecret("JRLuHNCZPxhaXKXsHlOlBgdacJYotTr1zivYXe27qvlw8ecXRs");
		cb.setOAuthAccessToken("803149381901910016-pmvfOSbTYNcDcM6BlUJO2FXRlU7R9uC");
		cb.setOAuthAccessTokenSecret("Y4Y659UQhc0F3gnD8Q8Psxt4AequjowPvBY4clZ6oJjMT");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus(msg);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updateStaffEntrou(String jogador, String cargo, String twitter) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("iApaVrv1AQ6hxEiTDFTKTIXBu");
		cb.setOAuthConsumerSecret("L4osqwcP5Mn7kJPZ9h0sQtpq2vkXh1wNmB0L0DltGJB8IF6WcZ");
		cb.setOAuthAccessToken("802253945959759872-1347NurFiUUrvQ3YkDcKhvZrP1Rp9dx");
		cb.setOAuthAccessTokenSecret("W5IbwJBemUXw3dQpxivsr2u2XaYn25FVHKPN6SZTCYQ0m");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus("Staff » " + jogador + " é o novo " + cargo + " - " + twitter);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updateStaffSaiu(String jogador, String twitter) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("iApaVrv1AQ6hxEiTDFTKTIXBu");
		cb.setOAuthConsumerSecret("L4osqwcP5Mn7kJPZ9h0sQtpq2vkXh1wNmB0L0DltGJB8IF6WcZ");
		cb.setOAuthAccessToken("802253945959759872-1347NurFiUUrvQ3YkDcKhvZrP1Rp9dx");
		cb.setOAuthAccessTokenSecret("W5IbwJBemUXw3dQpxivsr2u2XaYn25FVHKPN6SZTCYQ0m");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus("Staff » O staffer " + jogador + " não integra mais a equipe - Saiu - " + twitter);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updateStaffRetirado(String jogador, String twitter) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("iApaVrv1AQ6hxEiTDFTKTIXBu");
		cb.setOAuthConsumerSecret("L4osqwcP5Mn7kJPZ9h0sQtpq2vkXh1wNmB0L0DltGJB8IF6WcZ");
		cb.setOAuthAccessToken("802253945959759872-1347NurFiUUrvQ3YkDcKhvZrP1Rp9dx");
		cb.setOAuthAccessTokenSecret("W5IbwJBemUXw3dQpxivsr2u2XaYn25FVHKPN6SZTCYQ0m");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus("Staff » O staffer " + jogador + " não integra mais a equipe - Retirado - " + twitter);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updateBans(String msg) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("GkOfrz8VGtAYdBBOMqeyFJuMx");
		cb.setOAuthConsumerSecret("dWUWhRbwrhJ0zlB0uOqBkomjOW1fy7Uw672bcdJy3aLKbx4wbk");
		cb.setOAuthAccessToken("802248250128560128-8oRj9a1ObrYyRzbHz0hZZqefCEnGZCS");
		cb.setOAuthAccessTokenSecret("JktlZYtqUZkdyhrcpLNNMUcWFvkW9Qh7wBTwGuEYuu8u3");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus(msg);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updateStaffPromovido(String jogador, String cargo, String twitter) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("iApaVrv1AQ6hxEiTDFTKTIXBu");
		cb.setOAuthConsumerSecret("L4osqwcP5Mn7kJPZ9h0sQtpq2vkXh1wNmB0L0DltGJB8IF6WcZ");
		cb.setOAuthAccessToken("802253945959759872-1347NurFiUUrvQ3YkDcKhvZrP1Rp9dx");
		cb.setOAuthAccessTokenSecret("W5IbwJBemUXw3dQpxivsr2u2XaYn25FVHKPN6SZTCYQ0m");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus("Staff » " + jogador + " promovido a " + cargo + " - " + twitter);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updateStaffRebaixado(String jogador, String cargo, String twitter) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("iApaVrv1AQ6hxEiTDFTKTIXBu");
		cb.setOAuthConsumerSecret("L4osqwcP5Mn7kJPZ9h0sQtpq2vkXh1wNmB0L0DltGJB8IF6WcZ");
		cb.setOAuthAccessToken("802253945959759872-1347NurFiUUrvQ3YkDcKhvZrP1Rp9dx");
		cb.setOAuthAccessTokenSecret("W5IbwJBemUXw3dQpxivsr2u2XaYn25FVHKPN6SZTCYQ0m");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus("Staff » " + jogador + " rebaixado a " + cargo + " - " + twitter);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updateStaffRetorna(String jogador, String cargo, String twitter) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("iApaVrv1AQ6hxEiTDFTKTIXBu");
		cb.setOAuthConsumerSecret("L4osqwcP5Mn7kJPZ9h0sQtpq2vkXh1wNmB0L0DltGJB8IF6WcZ");
		cb.setOAuthAccessToken("802253945959759872-1347NurFiUUrvQ3YkDcKhvZrP1Rp9dx");
		cb.setOAuthAccessTokenSecret("W5IbwJBemUXw3dQpxivsr2u2XaYn25FVHKPN6SZTCYQ0m");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus("Staff » " + jogador + " retorna a equipe como " + cargo + " - " + twitter);
		} catch (Exception e) {
			
		}
		
	}
	
	public static void updateStaffAfastou(String jogador, String twitter) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("iApaVrv1AQ6hxEiTDFTKTIXBu");
		cb.setOAuthConsumerSecret("L4osqwcP5Mn7kJPZ9h0sQtpq2vkXh1wNmB0L0DltGJB8IF6WcZ");
		cb.setOAuthAccessToken("802253945959759872-1347NurFiUUrvQ3YkDcKhvZrP1Rp9dx");
		cb.setOAuthAccessTokenSecret("W5IbwJBemUXw3dQpxivsr2u2XaYn25FVHKPN6SZTCYQ0m");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus("Staff » O staffer " + jogador + " se afastou temporariamente da equipe - " + twitter);
		} catch (Exception e) {
			
		}
		
	}
	public static void updateStaffAfastado(String jogador, String twitter) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey("iApaVrv1AQ6hxEiTDFTKTIXBu");
		cb.setOAuthConsumerSecret("L4osqwcP5Mn7kJPZ9h0sQtpq2vkXh1wNmB0L0DltGJB8IF6WcZ");
		cb.setOAuthAccessToken("802253945959759872-1347NurFiUUrvQ3YkDcKhvZrP1Rp9dx");
		cb.setOAuthAccessTokenSecret("W5IbwJBemUXw3dQpxivsr2u2XaYn25FVHKPN6SZTCYQ0m");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter tt = tf.getInstance();
		
		try {
			tt.updateStatus("Staff » O staffer " + jogador + " foi afastado temporariamente da equipe - " + twitter);
		} catch (Exception e) {
			
		}
		
	}

}
