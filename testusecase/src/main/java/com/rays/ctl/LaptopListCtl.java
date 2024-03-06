package com.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptop.model.LaptopModel;
import com.rays.laptopdto.LaptopDTO;
@WebServlet("/LaptopListCtl")
public class LaptopListCtl extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pageNo=1;
		int pageSize=10;
		String op=req.getParameter("operation");
		LaptopDTO	dto=null;
		LaptopModel model=new LaptopModel();
		List list=model.search(dto,0,0);
		
		RequestDispatcher rd=req.getRequestDispatcher("LaptopListView.jsp");
		req.setAttribute("List", list);
		rd.forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int pageNo=1;
		int pageSize=10;
		String op=req.getParameter("operation");
		System.out.println(op+"   mila...!!!!!!");
		
		LaptopDTO dto=null;
		LaptopModel model= new LaptopModel();
		System.out.println("rahul..");
		
		if (op!=null && op.equalsIgnoreCase("search")) {
			System.out.println("search method chalii.....");
		        dto=new LaptopDTO();
		     
				dto.setName(req.getParameter("name"));
//				dto.setAmount(Integer.parseInt("amount"));
				//dto.setModel(req.getParameter("model"));
//				dto.setRom(Integer.parseInt("rom"));
//				dto.setRam(Integer.parseInt("ram"));
//				try {
//					dto.setDate(sdf.parse(req.getParameter("date")));
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				List list=model.search(dto,0,0);
				System.out.println("yes222.");
				req.setAttribute("List", list);
				RequestDispatcher rd=req.getRequestDispatcher("LaptopListView.jsp");
				rd.forward(req, resp);
				
		}
		if (op.equalsIgnoreCase("delete")) {
			System.out.println("pahuch gya hu");
			String[] ids=req.getParameterValues("ids");
			for (String id : ids) {
				LaptopDTO dto1=new LaptopDTO();
				dto1.setId(Integer.parseInt(id));
				model.delete(dto1);
			}
			
		}
			List list=model.search(dto,0,0);
			System.out.println("yes222.");
			req.setAttribute("List", list);
			RequestDispatcher rd=req.getRequestDispatcher("LaptopListView.jsp");
			rd.forward(req, resp);
			


		}
	}

