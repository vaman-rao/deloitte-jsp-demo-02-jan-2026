
# Servlet JSP MVC Application using Maven

## Step-by-Step Guide
Creating a **Servlet + JSP MVC Application** using **Maven** and **Apache Tomcat 9**.

---

## Target Stack
- Java 11 / 17
- Apache Tomcat 9.x
- Maven
- Servlet + JSP + JSTL (Classic)
- Eclipse IDE for Enterprise Java Developers

---

## Step 1: Verify Prerequisites
1. JDK 11 or 17
2. Apache Tomcat 9.x
3. Eclipse IDE for Enterprise Java Developers

---

## Step 2: Create New Maven Project in Eclipse
1. Open Eclipse  
2. File → New → Maven Project  
3. Check **Create a simple project (skip archetype selection)**  
4. Click **Next**  
5. Enter:
```
Group Id    : com.demo
Artifact Id : deloitte-jsp-demo
Version     : 1.0
Packaging   : war
```
6. Click **Finish**

---

## Step 3: Convert to Dynamic Web Project
1. Right-click project → Properties  
2. Project Facets  
3. Enable:
   - Dynamic Web Module (3.1)
   - Java  
4. Apply & Close

---

## Step 4: Configure pom.xml
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.demo</groupId>
    <artifactId>deloitte-jsp-demo</artifactId>
    <version>1.0</version>
    <packaging>war</packaging>

    <dependencies>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>org.apache.taglibs</groupId>
            <artifactId>taglibs-standard-impl</artifactId>
            <version>1.2.5</version>
        </dependency>

        <dependency>
            <groupId>org.apache.taglibs</groupId>
            <artifactId>taglibs-standard-spec</artifactId>
            <version>1.2.5</version>
        </dependency>
    </dependencies>
</project>
```

---

## Step 5: Create Packages & Classes
- `com.demo.model` → Employee.java  
- `com.demo.controller` → EmployeeServlet.java  

---

## Step 6: Employee.java
```java
package com.demo.model;

public class Employee {
    private int id;
    private String name;

    public Employee() {}
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

---

## Step 7: EmployeeServlet.java
```java
package com.demo.controller;

import com.demo.model.Employee;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(101, "Sonu"));
        list.add(new Employee(102, "Monu"));
        list.add(new Employee(103, "Tonu"));

        req.setAttribute("employees", list);
        req.getRequestDispatcher("/WEB-INF/views/employees.jsp")
           .forward(req, resp);
    }
}
```

---

## Step 8: JSP View
Create `WEB-INF/views/employees.jsp`

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Employee List</h2>
<ul>
    <c:forEach var="e" items="${employees}">
        <li>${e.id} - ${e.name}</li>
    </c:forEach>
</ul>
</body>
</html>
```

---

## Step 9: Add Tomcat 9 in Eclipse
Window → Show View → Servers → Add New Server → Apache → Tomcat 9

---

## Step 10: Run
Right-click project → Run As → Run on Server

---

## Step 11: Test
```
http://localhost:8080/deloitte-jsp-demo/employees
```

Expected Output:
```
Employee List
101 - Sonu
102 - Monu
103 - Tonu
```
