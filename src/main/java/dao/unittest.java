package dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class unittest {

// CREATEDAO의 conect가 성공적으로 되었는가를 확인하려고 한다.
	@Test
	public void testconect(){
		CreateDAO dao = new CreateDAO();
		boolean check=false;
		try {
			check = dao.conect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(check, "false");
	}
// CreateDAO의 INSERT문이 제대로 작동하는지 확인
	@Test
	public void testinsert() {
		CreateDAO dao = new CreateDAO();
		Integer user_id=1;
		String title="Test title";
		String content="Test content";
		try {
			dao.Insert(user_id, title, content);
			assertTrue("Exception occured",true);
		} catch(Exception e) {
			assertTrue("Exception Not occured", false);
		}
	}
//INSERT의 USER_id에 잘못된 값 입력시 에러가 발생하는가
	@Test
	public void test_insert_invalid_value() {
		CreateDAO dao = new CreateDAO();
		Integer user_id=null;
		String title="Test title";
		String content="Test content";
		try {
			dao.Insert(user_id, title, content);
			assertTrue("Exception Not occured",false);
		} catch(Exception e) {
			assertTrue("Exception occured", true);
		}
	}
// DELETE의 user_id에 잘못된 값 입력시 에러가 발생하는지 확인
	@Test
	public void test_delete_invalid_value() {
		EditDAO dao=new EditDAO();
		Integer log_id=null;
		try {
			dao.Delete(log_id);
			assertTrue("Exception Not occured", false);
		} catch(Exception e) {
			assertTrue("Exception occured", true);
		}
	}
	@Test
	public void test_delete_valid_value() {
		EditDAO dao=new EditDAO();
		Integer log_id=10;
		try {
			dao.Delete(log_id);
			assertTrue("Exception occured", true);
		} catch(Exception e) {
			assertTrue("Exception Not occured", false);
		}
	}
}
