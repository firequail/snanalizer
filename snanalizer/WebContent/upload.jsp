<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>


<html>
<head>
<title>Document de UPLOAD</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>

<%
  String cale = request.getRealPath("/sna/resourcespics") + "/";
  String deScris = "";
  DataInputStream in = null;  
  DataOutputStream output = null;
  
  try
  {
    in = new DataInputStream(request.getInputStream());
    
    int contor = 0;
    //preluam boundary
    String linie = in.readLine();
    String boundary = linie;
    contor+=2*boundary.length();
    out.println("BOUNDARY: " + linie + "<br>");
    
    //se obtine numele fisierului
    linie = in.readLine();
    contor+=linie.length();
    String numeFisier = linie.substring(linie.indexOf("filename=") + 10);
    String numeFisier_ok = numeFisier.substring(0, numeFisier.length() - 1);
        
    out.println("NUMELE FISIERULUI ESTE: " + numeFisier_ok + "<br>");
    deScris = cale + numeFisier_ok;
    out.println("SE SCRIE FISIERUL: " + deScris);
    output = new DataOutputStream(new FileOutputStream(deScris));
        
    //se citeste linia pe care se afla tipul continutului
    linie = in.readLine();
    contor+=linie.length();
    
    //se citeste o linie goala
    linie = in.readLine();
    contor+=linie.length();
        
    //aici citim octetii de continut
    int lungimeFisier = request.getContentLength() - contor;
    out.println("LUNGIMEA FISIERULUI ESTE: " + lungimeFisier + "<br>");
    
    byte[] continut = new byte[request.getContentLength() - contor];
    in.readFully(continut);
    
    output.write(continut);
    output.flush();
  }
  
  catch(IOException e)
  {
    out.println("EROARE FATALA: " + e + "<br>");
  }
  
  finally
  {
    if(in != null)
     in.close();
     
    if(output != null)
     output.close();
  }
%>

</body>

</html>
