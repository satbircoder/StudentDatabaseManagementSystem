@echo off
md app
jar --create --file=app/StudentScoreDB.jar --main-class=studentscoredb.StudentScoreDB -m Manifest.txt -C classes .
md app\lib
copy lib\mysql-connector-java.jar app\lib 
Pause