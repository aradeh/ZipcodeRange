# ZipcodeRange
- To preprocess given zipcode ranges, if the ranges are in same bounds eliminate the middle bounds and keep the ranges from lower zip code range to upper zip code range.

### Assumptions
- Input from the user is string and is seperated by spaces between two zip code ranges.
- For Example: "[94133,94133] [94200,94299] [94600,94699]"

### Class Description
* `App.java` - Driver class to accept input and generate output with all functionality.
* `Zipcode.java` - Data class to store the lower zip code range and upper zip code range.
* `ZipcodeSort.java` - As input ranges is not in specific order, this class sorts the input zipcodes in ascending order.
* `ZipcodeProcess.java` - Validate the given input zip code ranges and create a List of the input.
* `ZipcodeMerge.java` - Logic to check the zip code ranges and create new range if required.

### Execution

Following are the commands to execute the project
```sh
$ mvn clean install
$ mvn build
$ java -jar ZipcodeRanges-1.0-SNAPSHOT.jar
```

* Input : "[94133,94133] [94200,94299] [94600,94699]"
=======
* Input : "[94133,94133] [94200,94299] [94600,94699]"
>>>>>>> Stashed changes
