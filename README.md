# JAX-RS-rest-example
A simple JAX-RS web service demo from scratch
---------------------------------------------

Sometime ago an interviewer asked me to create a simple web service from scratch on a whiteboard. Being used to the modern IDEs, like Eclipse that does all the structural plumbing for us, I was stumped and could not answer correctly. So I figured why not I create a simple one.

In simple terms, A REST web service exposes a resource over a representation. So to make the demo quick, I am assuming a simple hello service that is called via a 'GET' method and it returns the supplied param.

This uses Jersey for JAX-RS implementation and following technologies as I had handy in my laptop's maven repository. 
1. JDK 1.7
2. Tomcat 6.0/7.0, I used 7.0
3. Jersey-1.8
4. Eclipse 3.7, not necessary, you can use a text editor or Eclipse

You need just one resource/service file to respond to a request. You may create other files that work on the request in a real project, but not required for now.
You also need the Jersey libraries, (jersey-server & jersey-core & asm.jar) for this resource class besides java JEE support.
Then you need the deployment descriptor, aka web.xml to pass the URL pattern to pass on to a Jersey servlet to our class.
Finally you need some way to build this, package this to a WAR and deploy under Tomcat. 

STEPS:
------
Create following directory structure:
JAX-RS-rest-example
---dist              ->Holds resulting WAR file
---classes           ->Holds compiled class files

---src
    ---main
        ---java      ->Holds JAVA files
        
---WebContent
      ---META-INF    ->Manifest, can be empty
      ---WEB-INF     ->Web content
      ------lib      ->Jersey library and other libraries.

Also create com.deepak.rest package under src/main/java folder and put the HelloWorldService.java below it.

Downlod and put both jersey libraries under WebContent/WEB-INF/lib folders.

Compile the sources:
Use Eclipse to build it (Menu->project->build) OR use java commandline:
javac -d classes 
      -sourcepath src/main/java 
      -cp WebContent/WEB-INF/lib/jersey-core-1.8.jar;WebContent/WEB-INF/lib/jersey-server-1.8.jar 
      src/main/java/com/deepak/rest/HelloWorldService.java
It will compile nicely and class files will be stored in classes folder.

Now create the web.xml under WebContent/WEB-INF folder.

Generate the war:
Copy the classes folder under WebContent/WEB-INF folder.
CD to current project root/WebContent & run:
jar cvf ./../dist/RESTExample.war .
This generates the WAR file under project root.

Deploy it.
Copy this war to TOMCAT webapps folder. Usually most servers would auto deploy if you drop it in, otherwise just reload tomcat.

Open your browser and point to 
http://localhost:8080/RESTExample/rest/hello/yourname and you will get your name as response in the browser.

Done.

More reading: 
https://jersey.java.net/nonav/
https://jersey.java.net/nonav/documentation/1.17/chapter_deps.html