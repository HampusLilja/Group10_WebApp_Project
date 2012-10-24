/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.group10.webapp_project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="UploadServlet", urlPatterns={"/upload"})     // specify urlPattern for servlet
@MultipartConfig(location="C:/Users/Hampus/Desktop/SugarSync/Chalmers/Webbapplikationer/GitHub/Group10_WebApp_Project/WebApp_Project/src/main/webapp/client/img/", fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)                                          // specifies servlet takes multipart/form-data
public class UploadServlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // get access to file that is uploaded from client
            Part p1 = request.getPart("file");
            InputStream is = p1.getInputStream();

            // read filename which is sent as a part
            Part p2  = request.getPart("photoname");
            Scanner s = new Scanner(p2.getInputStream());
            String filename = s.nextLine() + ".jpg";    // read filename from stream

            // get filename to use on the server
         //   String outputfile = this.getServletContext().getRealPath(filename);  // get path on the server
            FileOutputStream os = new FileOutputStream ("C:/Users/Hampus/Desktop/SugarSync/Chalmers/Webbapplikationer/GitHub/Group10_WebApp_Project/WebApp_Project/src/main/webapp/client/img/" + filename);
            
            // write bytes taken from uploaded file to target file
            int ch = is.read();
            while (ch != -1) {
                 os.write(ch);
                 ch = is.read();
            }
            os.close();
            out.println("<h3>File uploaded successfully!</h3>");
            //response.sendRedirect("faces/products.xhtml");
        }
        catch(Exception ex) {
           out.println("Exception -->" + ex.getMessage());
        }
        finally { 
            out.close();
        }
    } // end of doPost()
 } // end of UploadServlet