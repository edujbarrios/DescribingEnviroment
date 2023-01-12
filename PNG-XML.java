import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class PNGtoXML {
    public static void main(String[] args) {
      // Misma carpeta
        File pngFile = new File("input.png");
        File xmlFile = new File("output.xml");
        try {
            TranscoderInput input = new TranscoderInput(ImageIO.read(pngFile));
            TranscoderOutput output = new TranscoderOutput(xmlFile);
            PNGTranscoder transcoder = new PNGTranscoder();
            transcoder.transcode(input, output);
        } catch (IOException | TranscoderException e) {
            e.printStackTrace();
        }
    }
}
