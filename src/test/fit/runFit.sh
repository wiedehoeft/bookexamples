export CLASSPATH=./fit.jar
javac -cp fit.jar Pricing.java
export CLASSPATH=./fit.jar:../fit
java fit.FileRunner alltests.html alltests-result.html