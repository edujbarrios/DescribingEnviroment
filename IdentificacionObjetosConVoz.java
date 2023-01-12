import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class ImageDescriber {
    public static void describeScene(String imagePath) {
        // Cargar la imagen y procesarla con OpenCV
        Mat image = Imgcodecs.imread(imagePath);
      //poner fotos en la misma carpeta que este código
        CascadeClassifier objectDetector = new CascadeClassifier("path_to_xml_file");
        MatOfRect objectDetections = new MatOfRect();
        objectDetector.detectMultiScale(image, objectDetections);
        // Genera audio que describa los objetos identificados
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        for (Rect rect : objectDetections.toArray()) {
            String objectDescription = "Se ha detectado un objeto en las coordenadas " + rect.x + "," + rect.y;
            voice.speak(objectDescription);
        }
    }
}
