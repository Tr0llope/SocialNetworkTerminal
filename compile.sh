find src/socialNetwork/* -name "*.java" > source.txt

javac -d bin/ @source.txt

rm source.txt
