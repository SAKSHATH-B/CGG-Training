<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
isELIgnored="false" %> <%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>JSTL Core Tags</title>
  </head>
  <body>
    <!-- 1.out-tag
    2.set-tag -->

    <x:set var="count" value="15" scope="application"></x:set>
    <x:set var="num" value="0"></x:set>
    <x:out value="${count}"></x:out>

    <!-- 3.remove-tag -->
    <!-- <x:remove var="count"></x:remove> -->
    <h1><x:out value="${count}">this is default value</x:out></h1>

    <!-- 4.if-tag : condition:true->print -->
    <x:if test="${count==15}">
      <h1>Yes count is 15 condition:true</h1>
    </x:if>

    <!-- 5.choose,when,otherwise - java.switch case -->
    <x:choose>
      <x:when test="${num>0}">
        <h1>This is my first case</h1>
        <h2>Number is positive</h2>
      </x:when>
      <x:when test="${num<0}">
        <h1>This is my Second case</h1>
        <h2>Number is negative</h2>
      </x:when>
      <x:otherwise>
        <h1>This is my default case</h1>
        <h2>Number is equal to zero</h2>
      </x:otherwise>
    </x:choose>

    <!-- 6.forEach-tag  -  for looping and traversing -->
    <!-- for individual elements -->
    <x:forEach var="j" begin="1" end="10">
      <h1>value of j is <x:out value="${j}"></x:out></h1>
    </x:forEach>

    <!-- 7.redirect-tag, url-tag -->
    <x:url var="myurl" value="https://www.facebook.com/login/identify">
      <x:param name="q" value="sakshathkuamr64@gmail.com"></x:param>
    </x:url>
    <x:out value="${myurl}"></x:out>
    <x:redirect url="${myurl}"></x:redirect>
  </body>
</html>
