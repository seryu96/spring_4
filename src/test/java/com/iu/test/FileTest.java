package com.iu.test;

// import static org.junit.Assert.*;

import javax.inject.Inject;

import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.notice.NoticeDTO;
import com.iu.s4.AbstractTest;

public class FileTest extends AbstractTest {

	@Inject
	FileDAO fileDAO;
	
	@org.junit.Test
	public void test() {
		NoticeDTO dto = null;
		try {
			dto = fileDAO.test3();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(dto.getNum());
		System.out.println(dto.getWriter());
		System.out.println(dto.getContents());
		
		for(FileDTO f : dto.getFileNames()) {
			System.out.println("=============================================");
			System.out.println(f.getFnum());
			System.out.println(f.getNum());
			System.out.println(f.getFname());
			System.out.println(f.getOname());
		}
	}

}
