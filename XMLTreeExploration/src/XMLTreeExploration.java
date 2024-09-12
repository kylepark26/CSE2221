import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * XMLTree demo
 *
 * @author Kyle Park
 *
 */
public final class XMLTreeExploration {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private XMLTreeExploration() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        XMLTree xml = new XMLTree1(
                "https://cse22x1.engineering.osu.edu/2221/web-sw1/extras/instructions/xmltree-model/columbus-weather.xml");

        xml.display();
        xml.toString();

        boolean tag = xml.isTag();
        String label = xml.label();

        out.println(tag);
        out.println(label);

        in.close();
        out.close();
    }

}
