package com.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptop.model.LaptopModel;
import com.rays.laptopdto.LaptopDTO;

@WebServlet("/LaptopCtl")
public class LaptopCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LaptopDTO dto = null;
		LaptopModel model = new LaptopModel();
		String id = req.getParameter("id");
		if (id != null) {
			dto = model.findByPk(Integer.parseInt(id));
			req.setAttribute("dto", dto);
		}
		RequestDispatcher rd = req.getRequestDispatcher("LaptopView.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String id = req.getParameter("id");
		LaptopModel model = new LaptopModel();
		LaptopDTO dto = new LaptopDTO();
		
		dto.setName(req.getParameter("name"));
		dto.setAmount(Integer.parseInt(req.getParameter("amount")));
		dto.setModel(req.getParameter("model"));
		dto.setRom(Integer.parseInt(req.getParameter("rom")));
		dto.setRam(Integer.parseInt(req.getParameter("ram")));
		try {
			dto.setDate(sdf.parse(req.getParameter("dates")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String op = req.getParameter("operation");
		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("msg", "laptop Updated Successfully...!!");
			req.setAttribute("dto", dto);
			System.out.println("............................");
			RequestDispatcher rd = req.getRequestDispatcher("LaptopView.jsp");
			rd.forward(req, resp);
		} else if (op.equalsIgnoreCase("save")) {
			model.add(dto);
			req.setAttribute("msg","laptop Order Added" );
			RequestDispatcher rd = req.getRequestDispatcher("LaptopView.jsp");
			rd.forward(req, resp);
		}else if (op.equalsIgnoreCase("AddUser")) {
			resp.sendRedirect("LaptopView.jsp");
			
		}else if (op.equalsIgnoreCase("cancel")) {
			resp.sendRedirect("welcome.jsp");
          
		}

	}
	}

