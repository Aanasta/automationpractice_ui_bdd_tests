package utils;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;

public class ParsePomManager {

    public static String getStringPropertyFromPom(String propertyName) {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = null;
        try {
            model = reader.read(new FileReader("pom.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return model.getProperties().getProperty(propertyName);
    }

    public static int getIntPropertyFromPom(String propertyName) {
        String property = getStringPropertyFromPom(propertyName);
        return Integer.parseInt(property);
    }

}
