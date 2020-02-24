package service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.tms.dao.AdminDao;
import com.capgemini.tms.dao.AdminDaoImpl;
import com.capgemini.tms.dto.Admin;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao;
	HashMap<Integer, Admin> hashMap;
	Admin admin = null;
	Scanner sc = new Scanner(System.in);

	int testId;
	String userId;

	public AdminServiceImpl() throws SQLException {
		adminDao = new AdminDaoImpl();
	}

	@Override
	public void showAllTest() throws SQLException {
		hashMap = AdminDao.getallAdmin();

		Set<Integer> keyset = hashMap.keySet();
		for (Integer integer : keyset) {
			System.out.println(hashMap.get(integer));
		}

	}

}
