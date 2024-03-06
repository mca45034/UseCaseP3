package com.rays.laptop.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.laptop.model.LaptopModel;
import com.rays.laptopdto.LaptopDTO;

public class LaptopTest {

	public static void main(String[] args) throws Exception {

		//testAdd();
		 //testUpdate();
		// testDelete();
		// testfindByPk();
		 //testSearch();
	}


		private static void testSearch() {
			LaptopDTO dto = new LaptopDTO();
			dto.setName("hp");
			LaptopModel model = new LaptopModel();
			 List  list= model.search(dto, 0, 0);
			 Iterator it=list.iterator();
			 while (it.hasNext()) {
				 LaptopDTO dto1=(LaptopDTO) it.next();
				 System.out.println(dto1.getId());
				 System.out.println(dto1.getName());
					System.out.println(dto1.getAmount());
					System.out.println(dto1.getModel());
					System.out.println(dto1.getRom());
					System.out.println(dto1.getRam());
					System.out.println(dto1.getDate());
					
				} 

		}
		
	


		private static void testfindByPk() {
			LaptopModel model = new LaptopModel();
			LaptopDTO dto = model.findByPk(2);
			System.out.println(dto.getName());
			System.out.println(dto.getAmount());
			System.out.println(dto.getModel());
			System.out.println(dto.getRom());
			System.out.println(dto.getRam());
			System.out.println(dto.getDate());
			
		
	}

//
	private static void testDelete() throws Exception {
		
		LaptopDTO dto = new LaptopDTO();
		
		dto.setId(3);
		
		LaptopModel model = new LaptopModel();
		model.delete(dto);

		
	}

	private static void testUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LaptopDTO dto = new LaptopDTO();
		dto.setId(2);
		dto.setName("dell");
		dto.setAmount(48000);
		dto.setModel("gammer");
		dto.setRom(10);
		dto.setRam(256);
		dto.setDate(sdf.parse("2022-07-18"));
		LaptopModel model = new LaptopModel();
		model.update(dto);

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LaptopDTO dto = new LaptopDTO();
		// dto.setId(2);
		dto.setName("hp");
		dto.setAmount(45000);
		dto.setModel("paveliyan");
		dto.setRom(10);
		dto.setRam(256);
		dto.setDate(sdf.parse("2022-03-10"));
		LaptopModel model = new LaptopModel();
		model.add(dto);

	}

}
