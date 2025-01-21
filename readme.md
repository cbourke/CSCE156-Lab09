# Computer Science II
## Lab 9.0 - Java Database Connectivity API I
[School of Computing](https://computing.unl.edu)  
[College of Engineering](https://engineering.unl.edu/)  
[University of Nebraska-Lincoln](https://unl.edu)  
[University of Nebraska-Omaha](https://unomaha.edu)  

An introduction the Java Database Connectivity (JDBC) API in the context 
of a web application using the albums database.


## Overview

### Resources

Prior to lab you should read/review the following resources.

*   Make sure that the Albums database is installed and available in
    your MySQL database

*   Review a JDBC tutorial from Oracle:  
    <http://download.oracle.com/javase/tutorial/jdbc/>

### Lab Objectives & Topics

Following the lab, you should be able to:        

-   Write SQL queries for use in JDBC

-   Make a JDBC connection, query and process a result set from a
    database

-   Have some exposure to a multi-tiered application and a web
    application server

### Peer Programming Pair-Up

To encourage collaboration and a team environment, labs will be
structured in a *pair programming* setup.  At the start of
each lab, you may be randomly paired up with another student by
a lab instructor.  One of you will be designated the *driver* 
and the other the *navigator*.  

The navigator will be responsible for reading the instructions 
and telling the driver what is to be done.  The driver will be 
in charge of the keyboard and workstation.  Both driver and 
navigator are responsible for suggesting fixes and solutions 
*together*.  Neither the navigator nor the driver is "in charge."  
Beyond your immediate pairing, you are encouraged to help and 
interact and with other pairs in the lab.

Each week you should try to alternate: if you were a driver 
last week, be a navigator next, etc.  Resolve any issues (you 
were both drivers last week) within your pair.  Ask the lab 
instructor to resolve issues only when you cannot come to a 
consensus.  

Because of the peer programming setup of labs, it is absolutely 
essential that you complete any pre-lab activities and familiarize
yourself with the handouts prior to coming to lab.  Failure to do
so will negatively impact your ability to collaborate and work with 
others which may mean that you will not be able to complete the
lab.  

## 1. Getting Started

Clone the project code for this lab from GitHub using the URL,
<https://github.com/cbourke/CSCE156-Lab09>. Refer to Lab 1.0 for
instructions on how to clone a project from GitHub.

***Note*** Be sure that the Albums database is installed and includes
the data from the SQL scripts from prior labs.

## 2. Overview 

In this lab you will familiarize yourself with the Java Database
Connectivity API (JDBC) by finishing a simple, nearly complete
retrieve-and-display web application. The design of the webapp is 
simple: it consists of an index page that loads album data via 
Ajax (Asynchronous JavaScript and XML) and displays it in a table.

It is not necessary to understand the details of the application (the
HTML, JavaScript, Servlets, or application server). The main goal of
this lab is to give you some familiarity with JDBC and exposure to a
multi-tiered application and web application server environment.

## 3. Activities

### 3.1 Modifying Your Application

1.  Open the `unl.soc.database.DatabaseInfo` source file and change 
    the login and password information to your MySQL credentials. 

2.  The HTML, JavaScript, etc. has been provided for you. Feel free to
    make modifications these files, but you should know what you are
    doing as changes can break functionality in other parts of the
    application.

3.  The application will not display any album data until you have
    completed the methods in the `DataLoader` class.

    -   `public static List<Album> getAlbumSummaries()` - This method 
        will query the database and get a complete list of
        all albums in the database. It will create and populate objects
        and put them in a list which will then be returned. This method
        will be used to generate the album table, so it doesn't need all
        information, just a subset (see the documentation as to what is
        required). You should optimize your queries to only select the
        relevant columns.

    -   `public static Album getDetailedAlbum(int albumId)` - this 
        method will query the database for the specific album
        with the given primary key and return an `Album` instance with *all*
        relevant data (band and its members, songs, etc.) specified.

    -   Important: do not forget to close your database resources
        (especially connections) after you are finished using them.

    -   A `Demo` class has been provided for you to test your 
        `getAlbumSummaries()` method which you can also adapt to 
        test your `getDetailedAlbum()` method.  A more substantial
        JUnit testing suite has also been provided but assumes that 
        your database contains data from our database script.  You 
        should use these to debug and troubleshoot before "deploying" 
        your application.

### 3.2 Running Your Application

Web applications are generally *deployed* to an application server. 
This is usually done by exporting your project to a Web Archive (WAR) 
file and then deploying this file to an application server (such as
Tomcat, JBoss or Glassfish).  However, for this lab it will be enough
to *preview* your webapp on your own local computer.  To do this, 
take the following steps.

1.  Make sure to select your project (not any folders or files in it) 
    in the project explorer.
    
2.  Click "play" button like normal, but a "Run As" dialog box should 
    popup.  Select "Run on Server" and "OK".  Alternatively, select the
    dropdown in the play button and select "Run As", "Run on Server"
    
3.  Under "Basic" select "J2EE Preview" and click "Finish"

This process will launch a local (but bare bones) web server and should
launch a basic web browser in Eclipse.  You can interact with your 
webapp through eclipse or you can open your favorite web browser and 
go to <http://localhost:8080/CSCE156-Lab09/> to do so.

*   If your code is correct, the contents of your database should be
    displayed (after loading) in a table.  Clicking on an album title
    should take you to a page displaying the details of that album 
    (a full track listing).  If not, there may be something wrong with
    your code.
    
*   Clicking on a band will likely not work with the J2EE Preview as it
    is a Java Servlet Page (JSP) and requires a full Java webapp server.     

## 4. Testing, Submitting & Grading

* Test your programs using the provided JUnit test suite(s).  Fix any
errors and completely debug your programs.
* Submit the following files through webhandin:
  * `DataLoader.java`
* Run the grader and verify the output to complete your lab.

## Advanced Activities (Optional)

1.  The album listing page utilizes a web framework called Bootstrap
    (see <http://getbootstrap.com/>). However, the album detail and band
    detail pages do not. Take this opportunity to learn about Bootstrap
    and use it to add stylistic elements to these pages.

2.  Many JavaScript plugins are available to add additional
    functionality to a plain HTML table (the ability to sort,
    pagination, column rearrangement, searching, filtering, etc.). One
    of the best plugins is datatables, a jQuery plugin available at
    <http://datatables.net/>. Download and incorporate datatable's code
    into your project and add the appropriate JavaScript code to make
    your Album table more dynamic.

