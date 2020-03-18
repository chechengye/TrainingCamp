<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Jsp 3大指令
  1、page  ： contentType ： 设定此jsp页面的内容的编码格式 import : 导包的
  2、include ： 包含
  3、taglib ：导入，标签库时引用的(jstl 、sturts标签库)
  <%@ taglib uri = "标签库的地址" prefix="前缀" %>
  9大隐式对象，jsp会被tomcat引擎翻译成为servlet的一个类。会帮我们初始化一些对象
  buffer : out缓冲区大小
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="error.jsp" buffer="0kb" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <%--<%@ include file="head.jsp"%>--%>
 <%-- <%=request.getAttribute("name")%>--%>
  ccccccccccccccccccc
  <%
    List<String> list = new ArrayList<>();
    list.add("zhangfei");
    list.add("guanyu");
    for (String str : list){
        out.write(str);
    }
    pageContext.setAttribute("list",list);
    //int i = 1/0;
    out.write("aaaaaaaaaaaaaaaaaa");
    response.getWriter().write("bbbbbbbbbbbbbbbbb");
    pageContext.setAttribute("name","wangwu");
  %>
  <%=6+21%>
  <%="dddddddddddddddddddddddddddddddddd"%>
  这个是index页面
  <%--<%=pageContext.getAttribute("name")%>--%>
  <%=pageContext.findAttribute("name")%>
  <!--EL、JSTL讲解-->
  <hr/>
  ${name}
  <c:forEach items="${list}" var="str">
      ${str}<br/>
  </c:forEach>

  <c:forEach begin="0" end="5" var="i">

      <c:if test="${i == 3}">
          ${i+888}
      </c:if>
      <c:if test="${i != 3}">
          ${i}
      </c:if>
  </c:forEach>
  </body>
</html>
