<h1 align="center">
  <br>
  Separate Chaining Hash Table Spell Checker
  <br>
</h1>

<h4 align="center">A pure java based spell checker utilizing separate chaining hash tables</h4>

<p align="center">
<a href="#overview">Overview</a> •
  <a href="#how-to-use">How To Use</a> •
  <a href="#download">Download</a> •
  <a href="#credits">Credits</a> •
  <a href="#license">License</a>
</p>

## Overview

This program takes a command-line argument specifying the name of the file containing common misspellings (a line-oriented file with each comma-separated line containing a misspelled word and the correct spelling), then reads text from standard input and prints out the misspelled words in the text along with the line numbers where they occurred and their correct spellings.

## How To Use

Requires installation of [Java](https://java.com/en/download/help/download_options.xml). To compile and run this application from your command line:

```bash
# To compile program.
$ javac Spell.java
```

```bash
# The first command-line argument specifies a file with commonly
# mis-spelled words, the second argument specifies the file to check
# against.

$ java Spell misspellings.txt < war_and_peace.txt

```

## Download

You can [download](https://github.com//wajeehanwar/Separate-Chaining-Hash-Table-Spell-Checker) here.

## Credits

- Swami Iyer
- Robert Sedgewick
- Kevin Wayne

This software was developed using the following:

- Java

## License

MIT

---

> GitHub [@wajeehanwar](https://github.com/wajeehanwar)
