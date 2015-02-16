<%
try{
    String contextPath = request.getContextPath();
    } catch (FileNotFoundException e) {
    e.printStackTrace(); // esto es opcional, obviamente
    throw new RuntimeException(e);
}
%>
var contextPath="<%=contextPath%>";
