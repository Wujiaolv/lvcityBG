package com.neuedu.lvcity.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.lvcity.common.FileUtils;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Scenictype;
import com.neuedu.lvcity.service.BanarService;
import com.neuedu.lvcity.service.ScenictypeService;
import com.neuedu.lvcity.service.impl.BanarServiceImpl;
import com.neuedu.lvcity.service.impl.ScenictypeServiceImpl;

/**
 * Servlet implementation class ScenictypeServlet
 */

public class ScenictypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScenictypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ("findAllScenictype".equals(action)) {
			doFindAllScenictype(request, response);
		} else if ("addScenictype".equals(action)) {
			doAddScenictype(request, response);
		} else if ("deleteScenictype".equals(action)) {
			doDeleteScenictype(request, response);
		}else if("updateScenictype".equals(action)){
			doUpdateScenictype(request, response);
		}
	}

	private void doUpdateScenictype(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ScenictypeService scenictypeService = ScenictypeServiceImpl.getInStance();
		int stid = Integer.parseInt(request.getParameter("stid"));
		//���۲�
		try {
			String st = request.getParameter("st");
			Scenictype scenictype = new Scenictype();
			scenictype.setSt(st);
			scenictype.setStid(stid);
			int result = scenictypeService.updateScenictype(scenictype);
			//���ɷ��ؽ����map
			Map<String, Object> map = new HashMap<String, Object>();
			if (result > 0) {
				map.put("success", true);
			} else {
				map.put("success", false);
				map.put("errorMsg", "Save user fail !");
			}
           //��mapת��JSON����
			String str = JSONObject.toJSONString(map);
			//���ؽ��
			response.getWriter().write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doDeleteScenictype(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ScenictypeService scenictypeService = ScenictypeServiceImpl.getInStance();
		int stid = Integer.parseInt(request.getParameter("stid"));
		Scenictype scenictype = new Scenictype();
		scenictype.setStid(stid);
		int res =scenictypeService.deleteScenictype(scenictype);
		System.out.println(res);
		Map<String, Object> map = new HashMap<String, Object>();
		if (res > 0) {
			map.put("success", true);
		} else {
			map.put("success", false);
			map.put("errorMsg", "delete contact fail !!!");
		}

		String str = JSONObject.toJSONString(map);
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doAddScenictype(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// ����Service����
		ScenictypeService scenictypeService = ScenictypeServiceImpl.getInStance();
		Scenictype Scenictype = new Scenictype();
		try {
			String st = request.getParameter("st");

			int result = scenictypeService.addScenictype(st);
			//���ɷ��ؽ����map
			Map<String, Object> map = new HashMap<String, Object>();
			if (result > 0) {
				map.put("success", true);
			} else {
				map.put("success", false);
				map.put("errorMsg", "Save user fail !");
			}
           //��mapת��JSON����
			String str = JSONObject.toJSONString(map);
			//���ؽ��
			response.getWriter().write(str);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doFindAllScenictype(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// page��ҳ�룬��ʼֵ 1�� rows��ÿҳ��ʾ�С� pageΪǰ̨Ҫ��ѯ��ҳ��rowsΪǰ̨��ÿҳ��¼��
		int rows = Integer.parseInt(request.getParameter("rows"));
		// System.out.println(rows);
		int page = Integer.parseInt(request.getParameter("page"));

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("startPage", (page - 1) * rows);
		pageMap.put("endPage", rows);

		// ����Service����
		ScenictypeService scenictypeService = ScenictypeServiceImpl.getInStance();
		//����ָ��ҳ�ļ�¼
		List<Scenictype> list = scenictypeService.findAllScenictype(pageMap);
		// System.out.println(list.size());
		//�����ܼ�¼��
		int total = scenictypeService.scenictypeCount();

		// JSON�У�total��¼������rows��¼��totalΪ��̨���صģ����ݿ�ģ��ܼ�¼�������ڶ�����rowsΪ��̨���ص�json�������顣
		map.put("rows", list);
		map.put("total", total);
		String str = JSONObject.toJSONString(map);
		// System.out.println(map.toString());
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
