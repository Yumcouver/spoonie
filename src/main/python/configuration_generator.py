#!/usr/bin/env python2.7
import yaml
import os
import sys
import subprocess

def generate(environment):
    os.chdir(os.path.dirname(__file__))
    with open("../resources/application.yaml") as fp:
        conf = yaml.load(fp)
    str_to_write = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" \
                "<configuration>\n" \
                "  <!-- Configure the database connection here -->\n" \
                "  <jdbc>\n" \
                "    <driver>" + conf[environment]["db"]["driver"]+ "</driver>\n" \
                "    <url>" + conf[environment]["db"]["url"] + "</url>\n" \
                "    <user>" + conf[environment]["db"]["username"] + "</user>\n" \
                "    <password>" + conf[environment]["db"]["password"] + "</password>\n" \
                "    \n" \
                "  </jdbc>\n" \
                "  <generator>\n" \
                "    <database>\n" \
                "      <name>" + conf[environment]["db"]["typename"] + "</name>\n" \
                "\n" \
                "      <includes>.*</includes>\n" \
                "\n" \
                "      <excludes></excludes>\n" \
                "\n" \
                "      <inputSchema>" + conf[environment]["db"]["database"] + "</inputSchema>\n" \
                "    </database>\n" \
                "\n" \
                "    <target>\n" \
                "      <!-- The destination package of your generated classes (within the\n" \
                "           destination directory) -->\n" \
                "      <packageName>com.yumcouver.spoonie.database</packageName>\n" \
                "\n" \
                "      <!-- The destination directory of your generated classes -->\n" \
                "      <directory>src/main/java</directory>\n" \
                "    </target>\n" \
                "  </generator>\n" \
                "</configuration>"
    if not os.path.isdir("../resources/generated"):
        os.mkdir("../resources/generated")
    with open("../resources/generated/jooq-config.xml", "w") as fp:
        fp.write(str_to_write)

if __name__ == "__main__":
    generate(sys.argv[1])
