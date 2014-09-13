package com.yumcouver.spoonie.generator;

import com.yumcouver.spoonie.conf.ApplicationConf;
import org.jooq.Constants;
import org.jooq.tools.JooqLogger;
import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.Configuration;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class SQLGenerator {
    private static final JooqLogger log = JooqLogger.getLogger(SQLGenerator.class);

    public static void main(String args[]) {
        if (args.length < 1) {
            log.error("Usage : SQLGenerator <environment>");
            System.exit(-1);
        }
        ApplicationConf appConf = new ApplicationConf(args[0]);
        String xml = appConf.toXML();
        xml = xml.replaceAll(
                "<(\\w+:)?configuration xmlns(:\\w+)?=\"http://www.jooq.org/xsd/jooq-codegen-\\d+\\.\\d+\\.\\d+.xsd\">",
                "<$1configuration xmlns$2=\"" + Constants.NS_CODEGEN + "\">");

        xml = xml.replace(
                "<configuration>",
                "<configuration xmlns=\"" + Constants.NS_CODEGEN + "\">");

        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            javax.xml.validation.Schema schema = sf.newSchema(
                    GenerationTool.class.getResource("/xsd/" + Constants.XSD_CODEGEN)
            );

            JAXBContext ctx = JAXBContext.newInstance(Configuration.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new ValidationEventHandler() {
                @Override
                public boolean handleEvent(ValidationEvent event) {
                    log.warn("Unmarshal warning", event.getMessage());
                    return true;
                }
            });
            Configuration configuration = (Configuration) unmarshaller.unmarshal(new StringReader(xml));
            new GenerationTool().run(configuration);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
