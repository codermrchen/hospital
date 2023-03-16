package com.wyu.web;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DownloadServlet", urlPatterns = "/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String path="D:/"+"医生信息表"+".xls";
        String xz ="成功下载至指定文件夹";

        HSSFWorkbook book=new HSSFWorkbook();
        HSSFSheet sheet=book.createSheet("表");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+"xsxk"+"?useUnicode=true&characterEncoding=utf-8","root","1234");
            Statement st=con.createStatement();
            String sql="select * from zyb ";
            ResultSet rs=st.executeQuery(sql);  //通过这个语句将查询的数据用resultset接收
            ResultSetMetaData rsmd=rs.getMetaData();//得到结果集的字段名
            int c=rsmd.getColumnCount();//得到数据表的结果集的字段的数量
            //生成表单的第一行，即表头
            HSSFRow row0=sheet.createRow(0);//创建第一行
            for(int i=0;i<c;i++){
                HSSFCell cel=row0.createCell(i);//创建第一行的第i列
                cel.setCellValue(rsmd.getColumnName(i+1));
//				cel.setCellStyle(style);
            }
            //将数据表中的数据按行导入进Excel表中
            int r=1;
            while(rs.next()){
                HSSFRow row=sheet.createRow(r++);//创建非第一行的其他行
                for(int i=0;i<c;i++){//仍然是c列，导入第r行的第i列
                    HSSFCell cel=row.createCell(i);
                    //以下两种写法均可
//					cel.setCellValue(rs.getString(rsmd.getColumnName(i+1)));
                    cel.setCellValue(rs.getString(i+1));
                }
            }
            //用文件输出流类创建名为table的Excel表格
            FileOutputStream out=new FileOutputStream(path);
            book.write(out);//将HSSFWorkBook中的表写入输出流中
            book.close();
            session.setAttribute("xz",xz);
            request.getRequestDispatcher("Success.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
