<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>

<%
// Create a factory for disk-based file items
FileItemFactory factory = new DiskFileItemFactory();
// Create a new file upload handler
ServletFileUpload upload = new ServletFileUpload(factory);
// Parse the request


List /* FileItem */ items = upload.parseRequest(request); 

// Process the uploaded items
Iterator iter = items.iterator();

// iterate over the list of uploaded files, normally in our case there will be just one
// but with modifications could be used for multiple uploads.
// handle items one by one
while (iter.hasNext()) {
   FileItem item = (FileItem) iter.next();
   
   // if we are in fact dealing with a file
// if (!item.isFormField()) {

      byte[] data = item.get();
      
      // where the file will be written to
      //File f = new File("file:///c:/" + item.getName());
      String uploadDir = pageContext.getServletContext().getRealPath("uploads");
      File dir = new File(uploadDir);
      if(!dir.exists()) {
      dir.mkdir();
      }
      
      File f = new File(uploadDir + item.getName());
      
      if(!f.exists()) {
      f.mkdir();
      }
      
      FileOutputStream fileOutSt = null;
      
      try{
        fileOutSt = new FileOutputStream(f);      
        fileOutSt.write(data);
      } catch (Exception e){
         e.printStackTrace(); 
         fileOutSt.close();
      }
      
      // dont forget to close the stream
      fileOutSt.close();
 //  }
}
%>


