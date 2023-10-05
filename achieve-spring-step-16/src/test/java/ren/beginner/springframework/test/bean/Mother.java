package ren.beginner.springframework.test.bean;

/**
 * @Created by Zhiliang
 * @Date 2023/10/5 15:25
 */
public class Mother implements IMother {
    @Override
    public String callMother() {
        return "213";
    }
}
