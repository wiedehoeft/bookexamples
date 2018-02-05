export CLASSPATH=./fit.jar:../../../build/libs/bookexamples-1.0-SNAPSHOT.jar
javac Pricing.java
javac MovieAdministration.java
export CLASSPATH=./fit.jar:../fit:../../../build/libs/bookexamples-1.0-SNAPSHOT.jar
java fit.FileRunner alltests.html alltests-result.html