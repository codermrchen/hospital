package com.wyu.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UploadServlet",urlPatterns ="/UploadServlet" )
@MultipartConfig(location = "D:\\img",fileSizeThreshold = 1024*100)
public class UploadServlet extends HttpServlet {
    //返回上传的文件名
    private String getFilename(Part part){
        String fname = null;
        String header = part.getHeader("content-disposition");
        fname = header.substring(header.lastIndexOf("=")+2,header.length()-1);
        return fname;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String path = request.getServletContext().getRealPath("/picture");
        String ysname = request.getParameter("ysname");
        String name = request.getParameter("name");
        Part p = request.getPart("myfile");
        String message = "";
        if(p.getSize()>1024*1024){
            p.delete();
            message = "文件太大，不能上传";
        }else {
            path = path+"\\member\\";
            File f =new File(path);
            if(!f.exists()){
                f.mkdirs();
            }
            String fname = getFilename(p);
            p.write(path+fname);
            message = "文件上传成功";
            session.setAttribute("ysname",ysname);
            session.setAttribute("name",name);
            session.setAttribute("pname",fname);

        }

        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/MessageHandle.jsp");
        rd.forward(request,response);



    }

}
