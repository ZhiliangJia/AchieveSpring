package ren.beginner.springframework.core.io;

import com.google.common.base.Preconditions;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 自动选择资源加载器
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 12:13
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Preconditions.checkNotNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource((url));
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
