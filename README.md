# sortingviz
![Merge Sort Screenshot](https://raw.githubusercontent.com/j0hax/sortingviz/master/screenshot2.png "Merge Sort")

A simple sorting visualizer written in Java.

## General Overview
The `ArrayPanel.java` class is a modified JPanel which stores a public integer array `bits[]` with the length of `UNITS`.
Upon initialization it populates the array with integers ranging from 0 to `UNITS`.

The `Utils.java` class only contains simple methods to prevent repetetive code, such as `swap()` and `delay()` functions.

The `SimpleSorts.java` class contains simple sorts which do not need to call other methods outside of their scope.

Other sorting algorithms will be found with a relevant class name.
