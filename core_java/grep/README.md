# Introduction

The Java Grep Application facilitates recursive text-searching based on regular expressions. Given a
root directory, the application searches through all files and subdirectories for matches to a
specific pattern. The application is deployed through a docker image to ensure consistent runtime
environments as well as implements core Java file I/O Stream APIs and Lambda functions, managed with
Apache Maven. The following include some of the key technologies used in this implementation:

- Java 8
- IntelliJ IDEA
- Maven
- Docker

# Quick Start

1. Run the program with Jar file

```bash
# Clean build with Maven
mvn clean compile package

# Run application with jar file
java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp [regex] [rootPath] [outFile]
```

2. Run the program with Docker

```bash
# Pull Docker image
docker pull williamyll/grep

# Run Docker container
docker run --rm -v `pwd`/data:/data -v `pwd`/out:/out williamyll/grep [regex] [rootPath] [outFile]
```

# Implementation

## Pseudocode

The following is pseudocode for the `process` method:

```bash
matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
      if containsPattern(line)
        matchedLines.add(line)
writeToFile(matchedLines)
```

## Performance Issue

The Java Grep application throws an `OutOfMemoryError` exception when it attempts to read a file
that is larger than the allocated heap memory in its entirety. This issue is resolved using Stream
APIs and Lambda functions, processing file lines disjointly instead of en masse.

# Test

Manual testing was done using sample data and IDE debugger. The content of the output files was
examined and compared to the expected results.

# Deployment

The application was deployed as a Docker image named williamyll/grep. The image is available in a
public repository on Docker Hub. The following commands can be used to obtain and run the
application:

```bash
# Pull Docker image
docker pull williamyll/grep

# Run Docker container
docker run --rm -v `pwd`/data:/data -v `pwd`/out:/out williamyll/grep [regex] [rootPath] [outFile]
```

# Improvement

- Display more detailed results, including file name and line number.
- Further extend functionalities, such as ignoring case, selecting non-matched lines
- More user feedback, displaying lines as they are matched
