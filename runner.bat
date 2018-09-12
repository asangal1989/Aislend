set projectLocation=C:\Program Files (x86)\Jenkins\workspace\sample1
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
