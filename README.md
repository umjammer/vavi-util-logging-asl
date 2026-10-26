[![Release](https://jitpack.io/v/umjammer/vavi-util-logging-asl.svg)](https://jitpack.io/#umjammer/vavi-util-logging-asl)
[![Java CI](https://github.com/umjammer/vavi-util-logging-asl/actions/workflows/maven.yml/badge.svg)](https://github.com/umjammer/vavi-util-logging-asl/actions/workflows/maven.yml)
[![CodeQL](https://github.com/umjammer/vavi-util-logging-asl/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/umjammer/vavi-util-logging-asl/actions/workflows/codeql-analysis.yml)
![Java](https://img.shields.io/badge/Java-17-b07219)

# vavi-util-logging-asl

 redirection jul logging to syslog for mac app.

### Remarkable Points

 * you can see your app log using console.app.
 * jul levels are mapped to asl levels (SEVERE → ERR, WARNING → WARNING, INFO → NOTICE, CONFIG/FINE → INFO, FINER/FINEST → DEBUG).
   INFO and DEBUG of asl are hidden by default in console.app.
 * on non-macOS platforms the handler falls back to the console (`System.err`).

## Install

 * maven
   * https://jitpack.io/#umjammer/vavi-util-logging-asl

## Usage

* properties
    * create `logging.properties` [sample](src/test/resources/logging.properties)
    * add a system property `-Djava.util.logging.config.file=/yor/location/logging.properties`

### Tech Know

 * exception thrown by the main method is not shown in syslog.
   you need to catch exceptions in the main method and log it by yourself

## References

## TODO

 * ~~where is the asl library to link?~~ -> `libSystem` (`libsystem_asl`)
