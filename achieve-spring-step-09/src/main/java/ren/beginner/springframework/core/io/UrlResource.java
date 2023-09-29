package ren.beginner.springframework.core.io;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * 根据Url加载配置资源
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 12:13
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        Preconditions.checkNotNull(url, "URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.url.openConnection();
        try {
            return connection.getInputStream();
        } catch (IOException e) {
            if (connection instanceof HttpURLConnection) {
                ((HttpURLConnection) connection).disconnect();
            }
            throw e;
        }
    }
}
