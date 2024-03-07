CPATH='.:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


if [ -f "student-submission/ListExamples.java" ]; then 
    echo "File Found"
else 
    echo "File ListExamples.java not found!"
    exit 1
fi

cp student-submission/ListExamples.java grading-area/
cp TestListExamples.java grading-area/
cp -r lib/ grading-area/

cd grading-area
javac -cp $CPATH *.java

if [[ $? -ne 0 ]]; then
    echo "Complilation Error"
    exit 1
fi

echo "Program compiled successfully!"

set +e

test_output=$(java -cp $CPATH org.junit.runner.JUnitCore TestListExamples 2>&1)

set -e

echo "$test_output"

echo "Grading..."
if grep -q "OK (" <<< "$test_output"; then
    echo "Full marks!"
elif grep -q "Tests run: 6,  Failures: 1" <<< "$test_output"; then
    echo "Partial marks. Check the output for details."
else
    echo "Tests failed. Check the output for details."
    exit 1
fi

echo "Finished grading."

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
