 package main.java.com.action;
 
 import main.java.com.bean.Medicine;
 import main.java.com.bean.YaoBean;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.List;
 import javax.servlet.ServletException;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 
 public class YaoServlet extends HttpServlet
 {
   public void destroy()
   {
     super.destroy();
   }
 
   public void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException
   {
     doPost(request, response);
   }
 
   public void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException
   {
     response.setContentType("text/html;charset=gb2312");
     request.setCharacterEncoding("gb2312");


     YaoBean yb = new YaoBean();
     if (1 <= 2)
     {

       String method = request.getParameter("method").trim();
       if (method.equals("addmc")) {
           String mname =request.getParameter("mname");
         int flag = yb.addMc(mname);
         if (flag == 1) {
           request.setAttribute("message", "操作成功！");
           request.getRequestDispatcher("admin/yao/index.jsp").forward(request, response);
         } else {
           request.setAttribute("message", "系统维护中，请稍后再试！");
           request.getRequestDispatcher("admin/yao/index.jsp").forward(request, response);
         }
       }
       else if (method.equals("msearchmc")) {

           String ypjx = request.getParameter("ypjx");
           List<Medicine> mlist = new ArrayList<Medicine>();
           mlist= yb.mSearchMc(ypjx);
           request.setAttribute("mlist",mlist);
           request.getRequestDispatcher("admin/yao/mhczindex.jsp").forward(request, response);
       }
       else if (method.equals("jsearchmc")) {
           String ypph =request.getParameter("ypph");
           List<Medicine> mlist = new ArrayList<Medicine>();
           mlist= yb.jSearchMc(ypph);
           request.setAttribute("mlist",mlist);
           request.getRequestDispatcher("admin/yao/jqczindex.jsp").forward(request, response);
       }
       else if (method.equals("upmc")) {
         String id = request.getParameter("id");
           String mname =request.getParameter("mname");
         int flag = yb.upMc(Integer.parseInt(id), mname);
         if (flag == 1) {
           request.setAttribute("message", "操作成功！");
          request.getRequestDispatcher("admin/yao/index.jsp").forward(request, response);
         }else {
           request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/index.jsp").forward(request, response);
         }
       }
       else if (method.equals("delmc")) {
          String id = request.getParameter("id");
        int flag = yb.delMc(Integer.parseInt(id));
         if (flag == 1) {
          request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/yao/index.jsp").forward(request, response);
         } else {
           request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/index.jsp").forward(request, response);
         }
 
       }
       else if (method.equals("addleibie")) {
         String yplb = request.getParameter("yplb");
         int flag = yb.addClass(yplb);
         if (flag == 1) {
            request.setAttribute("message", "操作成功！");
           request.getRequestDispatcher("admin/yao/leibie.jsp").forward(request, response);
         } else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/leibie.jsp").forward(request, response);
         }
       }
       else if (method.equals("upleibie")) {
          String id = request.getParameter("id");
          String yplb = request.getParameter("yplb");
         int flag = yb.upClass(Integer.parseInt(id), yplb);
         if (flag == 1) {
           request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/yao/leibie.jsp").forward(request, response);
         } else {
           request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/leibie.jsp").forward(request, response);
         }
       }
       else if (method.equals("delleibie")) {
         String id = request.getParameter("id");
          int flag = yb.delClass(Integer.parseInt(id));
          if (flag == 1) {
            request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/yao/leibie.jsp").forward(request, response);
         } else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/leibie.jsp").forward(request, response);
         }
 
       }
       else if (method.equals("addjx")) {
          String ypjx = request.getParameter("ypjx");
          int flag = yb.addJx(ypjx);
         if (flag == 1) {
            request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/yao/jixing.jsp").forward(request, response);
         } else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/jixing.jsp").forward(request, response);
         }
       }
      else if (method.equals("upypjx")) {
         String id = request.getParameter("id");
         String ypjx = request.getParameter("ypjx");
          int flag = yb.upJx(Integer.parseInt(id), ypjx);
         if (flag == 1) {
            request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/yao/jixing.jsp").forward(request, response);
         }
         else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
           request.getRequestDispatcher("admin/yao/jixing.jsp").forward(request, response);
         }
       }
       else if (method.equals("delypjx")) {
         String id = request.getParameter("id");
         int flag = yb.delJx(Integer.parseInt(id));
          if (flag == 1) {
           request.setAttribute("message", "操作成功！");
           request.getRequestDispatcher("admin/yao/jixing.jsp").forward(request, response);
         }
         else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
           request.getRequestDispatcher("admin/yao/jixing.jsp").forward(request, response);
         }
 
       }
        else if (method.equals("adddanwei")) {
          String dwmc = request.getParameter("dwmc");
         int flag = yb.addDw(dwmc);
          if (flag == 1) {
            request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/yao/danwei.jsp").forward(request, response);
         }
         else {
           request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/danwei.jsp").forward(request, response);
         }
       }
        else if (method.equals("updw")) {
          String id = request.getParameter("id");
         String dwmc = request.getParameter("dwmc");
         int flag = yb.upDw(Integer.parseInt(id), dwmc);
          if (flag == 1) {
           request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/yao/danwei.jsp").forward(request, response);
         }
         else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/danwei.jsp").forward(request, response);
         }
       }
        else if (method.equals("deldw")) {
          String id = request.getParameter("id");
         int flag = yb.delDw(Integer.parseInt(id));
          if (flag == 1) {
           request.setAttribute("message", "操作成功！");
           request.getRequestDispatcher("admin/yao/danwei.jsp").forward(request, response);
         }
         else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/yao/danwei.jsp").forward(request, response);
         }
 
       }
        else if (method.equals("addjin")) {
          String ypmc = request.getParameter("ypmc");
         String yplb = request.getParameter("yplb");
          String ypjx = request.getParameter("ypjx");
          String ypdw = request.getParameter("ypdw");
          String ypjj = request.getParameter("ypjj");
         String ypsl = request.getParameter("ypsl");
         String jhrq = request.getParameter("jhrq");
          String ypph = request.getParameter("ypph");
          String ypcd = request.getParameter("ypcd");
        String yxq = request.getParameter("yxq");
         String dqrq = request.getParameter("dqrq");
         int flag = yb.addMedicine(ypmc, yplb, ypjx, ypdw, ypjj, ypsl, jhrq, ypph, ypcd, yxq, dqrq);
         if (flag == 1) {
            request.setAttribute("message", "操作成功！");
           request.getRequestDispatcher("admin/jin/index.jsp").forward(request, response);
         }
         else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
           request.getRequestDispatcher("admin/jin/index.jsp").forward(request, response);
         }
       }
       else if (method.equals("upjinhuo")) {
         String id = request.getParameter("id").trim();
         String ypmc = request.getParameter("ypmc");
          String yplb = request.getParameter("yplb");
         String ypjx = request.getParameter("ypjx");
         String ypdw = request.getParameter("ypdw");
         String ypjj = request.getParameter("ypjj");
          String ypsl = request.getParameter("ypsl");
         String jhrq = request.getParameter("jhrq");
         String ypph = request.getParameter("ypph");
         String ypcd = request.getParameter("ypcd");
         String yxq = request.getParameter("yxq");
         String dqrq = request.getParameter("dqrq");
         int flag = yb.upMedicine(Integer.parseInt(id), ypmc, yplb, ypjx, ypdw, ypjj, ypsl, jhrq, ypph, ypcd, yxq, dqrq);
          if (flag == 1) {
           request.setAttribute("message", "操作成功！");
          request.getRequestDispatcher("admin/jin/index.jsp").forward(request, response);
         }
         else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
            request.getRequestDispatcher("admin/jin/index.jsp").forward(request, response);
         }
       }
       else if (method.equals("deljin")) {
         String id = request.getParameter("id");
          int flag = yb.delMedicine(Integer.parseInt(id));
          if (flag == 1) {
           request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/jin/index.jsp").forward(request, response);
         }
         else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
           request.getRequestDispatcher("admin/jin/index.jsp").forward(request, response);
         }
 
       }
       else if (method.equals("addxiao")) {
         String ypmc = request.getParameter("ypmc");
         String ypsj = request.getParameter("ypsj");
         String ypsl = request.getParameter("ypsl");
         String xsrq = request.getParameter("xsrq");
          int j = yb.getIf(ypmc);
        int k = yb.getSale(ypmc);
         if (Integer.parseInt(ypsl) > j - k) {
         request.setAttribute("message", "该药品共进货" + j + ",累计出售" + k + ",剩余" + (j - k) + ",少于要出售的数量" + ypsl + "，操作失败！");
          request.getRequestDispatcher("admin/xiao/index.jsp").forward(request, response);
         }
         else {
            int flag = yb.saleMedicine(ypmc, ypsj, ypsl, xsrq);
           if (flag == 1) {
             request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/xiao/index.jsp").forward(request, response);
           }
           else {
             request.setAttribute("message", "系统维护中，请稍后再试！");
             request.getRequestDispatcher("admin/xiao/index.jsp").forward(request, response);
           }
         }
       }
       else if (method.equals("upxiao")) {
         String id = request.getParameter("id").trim();
         String ypmc = request.getParameter("ypmc");
          String ypsj = request.getParameter("ypsj");
         String ypsl = request.getParameter("ypsl");
         String xsrq = request.getParameter("xsrq");
          int j = yb.getIf(ypmc);
         int k = yb.getSale(ypmc);
          if (Integer.parseInt(ypsl) > j - k) {
            request.setAttribute("message", "该药品共进货" + j + ",累计出售" + k + ",剩余" + (j - k) + ",少于要出售的数量" + ypsl + "，操作失败！");
           request.getRequestDispatcher("admin/xiao/index.jsp").forward(request, response);
         }
         else {
            int flag = yb.upSaleMedicine(Integer.parseInt(id), ypmc, ypsj, ypsl, xsrq);
           if (flag == 1) {
              request.setAttribute("message", "操作成功！");
              request.getRequestDispatcher("admin/xiao/index.jsp").forward(request, response);
           }
           else {
              request.setAttribute("message", "系统维护中，请稍后再试！");
             request.getRequestDispatcher("admin/xiao/index.jsp").forward(request, response);
           }
         }
       }
       else if (method.equals("delxiao")) {
         String id = request.getParameter("id");
          int flag = yb.delSaleMedicine(Integer.parseInt(id));
          if (flag == 1) {
            request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/xiao/index.jsp").forward(request, response);
         }
         else {
            request.setAttribute("message", "系统维护中，请稍后再试！");
           request.getRequestDispatcher("admin/xiao/index.jsp").forward(request, response);
         }
       }
       else if (method.equals("low")) {
        String num = request.getParameter("num");
         int flag = yb.setLow(Integer.parseInt(num));
         if (flag == 1) {
           request.setAttribute("message", "操作成功！");
            request.getRequestDispatcher("admin/tong/low.jsp").forward(request, response);
         }
         else {
           request.setAttribute("message", "系统维护中，请稍后再试！");
          request.getRequestDispatcher("admin/tong/low.jsp").forward(request, response);
         }
       }
     }
   }
 
   public void init()
     throws ServletException
   {
   }
 }
