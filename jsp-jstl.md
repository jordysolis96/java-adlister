JSP and JSTL

### What are JSPs? (Java Server Pages)
- Allows us to combine Java with HTML to create dynamic web pages
- Will live in a 'webapp' folder in main
- JSPs are processed server-side and an HTML response is returned to the browser. (Translated into servlets by Tomcat)
- JSPs have access to implicit objects created by Tomcat
- Tags <% %> are used to define the dynamic parts of the page.

### JSP Tags
- Directives <%@  %>
  - Instructions for the entire JSP file
- Define Instance Variables <%!  %>
- Evaluate expressions and print results <%=  %>
- Arbitrary Java code <%  %>
- JSP Comments <%--  --%>

### The 'include' Directive
- Allows us to split up our JSPs into partials
- Useful for separating parts of our page (NavBar,Footer, etc.)

### Implicit Objects (Review)
- request
- response
- out

** these are already defined for us by Tomcat

### Expression Language (Review)
- Simplifies access to request object attributes

### JSTL (JSP Standard Tag Library)
- Although JSP has the ability to create custom tags, for the scope of this lesson we'll be working with a set of pre-defined tags using JSTL
- Make sure to include the dependency in your pom.xml
- Add a 'taglib' directive on any page we use JSTL
- Choose, ForEach, If
