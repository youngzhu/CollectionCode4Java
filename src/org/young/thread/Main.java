package org.young.thread;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Calendar calToday = Calendar.getInstance();
		calToday.setTime(new Date());
		calToday.add(Calendar.DAY_OF_MONTH, -1);
		ShowDate yesterday = new ShowDate("YESTERDAY", calToday.getTime());
		
		ShowDate today = new ShowDate("TODAY", new Date());
		
		Thread t1 = new Thread(yesterday);
		Thread t2 = new Thread(today);
		
		/*
		 * start() 
		 * 		它的作用是启动一个新线程，新线程会执行相应的run()方法。start()不能被重复调用。
		 * run() 
		 * 		就和普通的成员方法一样，可以被重复调用。单独调用s的话，会在当前线程中执行run()，而并不会启动新线程！
		 */
		t1.start();
		t2.start();
	}
}

class ShowDate implements Runnable {

	private String desc;
	private Date date;
	
	public ShowDate(String desc, Date date) {
		this.desc = desc;
		this.date = date;
	}

	@Override
	public void run() {

		for (int i = 0; i < 1000; i++) {
			if (i % 30 == 0) {
				try {
					Thread.sleep(500L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			System.out.println(desc + ": " + DateUtil.getFormattedDate(date));
//			System.out.println(desc + ": " + SyncDateUtil.getFormattedDate(date));
//			System.out.println(desc + ": " + ThreadLocalDateUtil.getFormattedDate(date));
			System.out.println(desc + ": " + ThreadLocalDateUtil2.getFormattedDate(date));
		}
	}
	
}