package ren.beginner.springframework.core.io;

import com.google.common.base.Preconditions;
import ren.beginner.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 根据Classpath加载配置资源
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 12:13
 */
public class ClassPathResource implements Resource {
    /**
     * 配置文件路径
     */
    private final String path;
    /**
     * 类加载器
     */
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Preconditions.checkNotNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }


    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
