package ren.beginner.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 根据绝对或者相对路径加载配置资源
 *
 * @Created by Zhiliang
 * @Date 2023/9/21 12:13
 */
public class FileSystemResource implements Resource {
    /**
     * 文件
     */
    private final File file;
    /**
     * 文件路径
     */
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public String getPath() {
        return path;
    }
}
