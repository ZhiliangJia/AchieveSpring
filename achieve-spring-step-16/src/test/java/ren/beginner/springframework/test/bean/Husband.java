package ren.beginner.springframework.test.bean;

/**
 * @Created by Zhiliang
 * @Date 2023/10/4 22:32
 */
public class Husband {

    private Wife wife;

    public String queryWife(){
        return "Husband.wife";
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

}
