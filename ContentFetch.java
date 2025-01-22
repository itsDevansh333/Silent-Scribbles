import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class ContentFetch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to get all the data");
		System.out.println("Enter 2 to get data of single day");
		int ch = sc.nextInt();
		ContentFetch fetch = new ContentFetch();
		switch (ch) {
		case 2:
			fetch.singleDay();
			break;
		case 1:
			fetch.completeData();
			break;
		}
	}

	private void singleDay() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date in yyyy-mm-dd formate");
		String date = sc.nextLine();
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try {
			dt = date_format.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("URL", "USERNAME","PASSWORD");
			String query = "select *from diary";
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			while (set.next()) {
				if (set.getDate(1).equals(dt)) {
					String text = set.getString(2);
					int key = set.getInt(3);
					Encryption encrpt = new Encryption();
					encrpt.decryption(key, text);
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void completeData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("URL", "USERNAME","PASSWORD");
			String query = "select *from diary";
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(query);
			System.out.println("    DATE     |"+"       Text       ");
			while (set.next()) {
				Encryption e1=new Encryption();
				String text=set.getString(2);
				int key=set.getInt(3);
				System.out.println(set.getDate(1)+" | "+e1.decryption(key,text));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
