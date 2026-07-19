# Dockefilr Explanation
---
```bash
FROM tomcat:10.1-jdk21
```
Here we are using tomcat and jdk as base image
```bash
RUN rm -rf /usr/local/tomcat/webapps/*
```
This command runs while the Docker image is being built.
It removes all the default web applications that come with Tomcat.
```bash
webapps/
│
├── ROOT
├── docs
├── examples
├── manager
└── host-manager
```
You usually want your application to be the only application running in the container.
It keeps the image smaller and avoids exposing unnecessary applications.
What happens if we don't remove them?
Tomcat will still work, but the default apps (docs, examples, etc.) will also be available.

```bash
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war
```
Why rename it to ROOT.war?
Suppose your WAR file is named:
Java-maven-code-with-test-cases.war

Without renaming, the URL would be:
http://EC2-IP:8081/Java-maven-code-with-test-cases

By renaming it to ROOT.war, Tomcat deploys it as the root application, so you can access it directly: http://EC2-IP:8081/

What happens if we keep the original name?
Your application still works, but you'll need to include the WAR name in the URL.

```bash
EXPOSE 8080
```
It documents that the application inside the container listens on port 8080.

```bash
CMD ["catalina.sh", "run"]
```
catalina.sh is Tomcat's startup script

Why use run instead of start?
run keeps Tomcat running in the foreground, so the Docker container stays alive.
start launches Tomcat in the background and exits. Docker would then think the main process has finished and stop the container.
