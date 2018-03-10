# Ragnarok Reader
Text-Based Game Reader


[![License](https://img.shields.io/badge/license-GPL%20v3-brightgreen.svg)](https://www.gnu.org/licenses/gpl-3.0.txt) [![Build](https://travis-ci.org/sshookman/ragnarok-reader.svg?branch=master)](https://travis-ci.org/sshookman/ragnarok-reader) [![Coverage](https://codecov.io/gh/sshookman/ragnarok-reader/branch/master/graph/badge.svg)](https://codecov.io/gh/sshookman/ragnarok-reader)

---

## Table of Contents

- [About](#about)
  - [Purpose](#purpose)
  - [Plans](#plans)
- [Getting Started](#getting-started)
  - [Building](#building)
  - [Running](#running)
- [Contributing](#contributing)

---

## About

The Ragnarok Reader is java-based text based adventure game reader.

#### Purpose

The purpose is to create a reader for text-based games that are stored in SQLite database files.

#### Plans

Use the OpenNLP library to construct a simple command parser algorithm for interpretting user commands based on the part of speach tagger.


## Getting Started


#### Building

```
$ ./gradlew clean build
```

#### Running

```
$ java -jar build/libs/ragnarok-reader-all.jar
```

## Contributing

Feel free to dive in and contribute! [Open an issue](https://github.com/sshookman/ProjectRead/issues/new) or submit PRs.
This project follows the [Contributor Covenant](http://contributor-covenant.org/version/1/3/0/) Code of Conduct.
