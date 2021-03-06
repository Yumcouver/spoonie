```
   _____                         _    
  / ___/____  ____  ____  ____  (_)__ 
  \__ \/ __ \/ __ \/ __ \/ __ \/ / _ \
 ___/ / /_/ / /_/ / /_/ / / / / /  __/
/____/ .___/\____/\____/_/ /_/_/\___/  v0.0.0
    /_/                               
```

The crawler for Yumcouver

---

## Quickstart

### Requirements

The following software components are required to be pre-installed in order to develop for this project:

* [maven](http://maven.apache.org/) `v2.0.8+`
* [python](https://www.python.org) `v2.7.5+`
* [java](http://www.oracle.com/technetwork/java/javase/overview/index.html)

### Installing Dependencies

Here is one method of installing all the necessary dependencies on a Mac via Homebrew:

    $ brew update
    $ brew install maven

    # test #
    $ mvn -v
    
### Packaging code

    $ cd /path/to/spoonie
    $ mvn clean install -P <environment> # where <environment> is one of the options listed below
    
    # example #
    $ mvn clean install -P test
    $ mvn clean install -P staging

## Technology Stack

* [Java](http://docs.oracle.com/javase/7/docs/api/): The primary development language of this project.
* [jOOQ](http://www.jooq.org/): jOOQ generates Java code from your database and lets you build typesafe SQL queries through its fluent API.
* [Maven](http://maven.apache.org/): Apache Maven is a software project management and comprehension tool.
* [HtmlUnit](http://htmlunit.sourceforge.net/): HtmlUnit is a "GUI-Less browser for Java programs".
* [Derby](http://db.apache.org/derby/): Java-based embedded SQL database engine for unit testing.
* [Java Architecture for XML Binding](http://www.oracle.com/technetwork/articles/javase/index-140168.html): XML and Java technology are recognized as ideal building blocks for developing Web services and applications that access Web services.
