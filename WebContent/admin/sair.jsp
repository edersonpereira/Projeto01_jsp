<%
//Remover a sess�o
session.setAttribute("sessao_usuario", null);
//Redirecionar
response.sendRedirect("../index.jsp?mensagem=sair");
%>