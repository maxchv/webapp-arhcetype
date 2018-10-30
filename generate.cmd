set mvn=C:\Users\shaptala\Desktop\archtype\apache-maven-3.5.4\bin\mvn
%mvn% archetype:create-from-project
cd target\generated-sources\archetype
%mvn% clean install