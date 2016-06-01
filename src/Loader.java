import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 */
public class Loader {

    public URLConnection openConnection(URL u) throws IOException {
        URL resourceUrl = getClass().getClassLoader().getResource(u.getPath());
        if(resourceUrl!=null){
            return resourceUrl.openConnection();
        }else {
            throw  new RuntimeException("не найден ресурс:"+u);
        }
    }



}
