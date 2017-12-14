<%--
  Created by IntelliJ IDEA.
  User: wapzjn
  Date: 2017/12/14
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>员工列表</title>

    <%--引入jQuary--%>
    <script type="text/javascript" src="/static/js/jquery-3.2.1.min.js"></script>
    <%--引入bootstrap--%>
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <%--搭建显示页面--%>
    <div class="container">
        <%--标题行--%>
        <div class="row">
            <div class="col-md-12">
                <h1>员工列表</h1>
            </div>
        </div>
        <%--按钮--%>
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button class="btn btn-info">添加</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>
        <%--显示数据--%>
        <div class="row">
            <div class="col-md-12">
            <table class="table table-hover table-bordered">
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Time</th>
                    <th>Operate</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="employee">
                    <tr>
                        <th>${employee.id}</th>
                        <th>${employee.name}</th>
                        <th>${employee.gender=="m"?"男":"女"}</th>
                        <th>${employee.email}</th>
                        <th>${employee.department.name}</th>
                        <th>${employee.date}</th>
                        <th>
                            <button class="btn btn-info btn-sm">添加</button>
                            <button class="btn btn-danger btn-sm">删除</button>
                        </th>
                    </tr>
                </c:forEach>
            </table>
            </div>
        </div>
        <%--显示页码数据--%>
        <div class="row">
            <%--分页文字信息--%>
            <div class="col-md-6">
                当前第${pageInfo.pageNum}页，共${pageInfo.pages}页，${pageInfo.total}条记录
            </div>
            <%--分页条信息--%>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <c:if test="${pageInfo.pageNum == 1}">
                            <li><a href="#">首页</a> </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != 1}">
                            <li><a href="/emplist?pn=1">首页</a> </li>
                        </c:if>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="/emplist?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="!${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                            <c:if test="${page_num == pageInfo.pageNum}">
                                <li class="active"><a href="#">${pageInfo.pageNum}</a></li>
                            </c:if>
                            <c:if test="${page_num != pageInfo.pageNum}">
                                <li><a href="/emplist?pn=${page_num}">${page_num}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="emplist?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="!${pageInfo.hasNextPage}">
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum == pageInfo.lastPage}">
                            <li><a href="#">末页</a> </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != pageInfo.lastPage}">
                            <li><a href="/emplist?pn=${pageInfo.pages}">末页</a> </li>
                        </c:if>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
