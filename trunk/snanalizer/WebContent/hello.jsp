<%@page import="java.io.IOException"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileUpload"%>



<%

String uploadDir = pageContext.getServletContext().getRealPath("uploads");

File dir = new File(uploadDir);
if(!dir.exists()) {
dir.mkdir();
}

DiskFileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);

@SuppressWarnings("unchecked")
List<FileItem> items = upload.parseRequest(request);
int counter = 0;

for(FileItem item : items) {

File uploadedFile = new File(uploadDir + File.separator + item.getName());

try {
item.write(uploadedFile);

out.println("<file"+ counter +">"+ uploadedFile.getAbsolutePath() +"</file"+ counter +">");
}
catch(IOException ioe) {
System.out.println("Problem copying temp file. " + ioe);
}

InputStream is = null;

try {
MessageDigest md = MessageDigest.getInstance("MD5");

//byte[] message = item.getString().getBytes();
//md.update(message);

byte[] buffer = new byte[1024];
is = new FileInputStream(uploadedFile);
int read = 0;

while( (read = is.read(buffer)) > 0) {
md.update(buffer, 0, read);
}

byte[] messageDigest = md.digest();

StringBuffer sb = new StringBuffer();
for(int i=0; i<messageDigest.length; i++) {
sb.append(Integer.toHexString( (int)(messageDigest[i] & 0xff) ));
}

out.println("<md5hash"+ counter +">"+ sb.toString() +"</md5hash"+ counter +">");
}
catch(Exception e) {
System.out.println("Unknown hash algorithm " + e);
}
finally {
if(is != null) {
is.close();
}
}

counter++;
}

%>
