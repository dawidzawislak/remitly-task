@echo off

echo Compiling and packing into jar file..
call mvn clean compile assembly:single
echo Program saved to target\task-1.0-jar-with-dependencies.jar
echo ------------------------------------------------------------
echo Running program..
echo.

java -jar target\task-1.0-jar-with-dependencies.jar

pause