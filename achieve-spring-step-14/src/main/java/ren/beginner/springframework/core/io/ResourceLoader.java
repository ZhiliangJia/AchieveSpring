package ren.beginner.springframework.core.io;

public interface ResourceLoader {
    /**
     * classpath资源的前缀
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 获取对应资源的Resource
     *
     * @param location
     * @return
     */
    Resource getResource(String location);
}
