package com.divino.hivetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCToHiveUtils {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver"; // ��Classλ��hive-jdbc��jar����
	private static String Url = "jdbc:hive2://192.168.142.131:10000/default"; // ��дhive��IP��֮ǰ�������ļ������õ�IP
	private static Connection conn;

	public static Connection getConnnection() {
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(Url, "", ""); // ֻ������hive, �û����ɲ���
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static PreparedStatement prepare(Connection conn, String sql) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
}