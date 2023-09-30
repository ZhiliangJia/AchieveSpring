package ren.beginner.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
    /**
     * 拿到对应的数据流
     *
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
