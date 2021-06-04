package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {
	
	private final Items DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Items created = new Items(1L, "shoe", 89.99);
		assertEquals(created, ((Dao<Items>) DAO).create(created));
	}

	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "shoe", 89.99));
		expected.add(new Items(2L, "magazine", 12.99));
		expected.add(new Items(3L, "toy truck", 1.99));
		assertEquals(expected, ((Dao<Items>) DAO).readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Items(3L, "toy truck", 0.99), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Items(ID, "shoe", 89.99), ((Object) DAO).readItems(ID));
	}

	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "tv", 449.99);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, ((Dao<Items>) DAO).delete(3));
	}
}