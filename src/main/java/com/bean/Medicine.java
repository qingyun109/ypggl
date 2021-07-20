package main.java.com.bean;

public class Medicine {
    private int id;
    private String ypmc;
    private String yplb;
    private String ypjx;
    private String ypdw;
    private String ypjj;
    private String ypsl;
    private String jhrq;
    private String ypph;
    private String ypcd;
    private String yxq;

    public Medicine() {
    }

    public Medicine(String ypjx) {
        this.ypjx = ypjx;
    }

    public Medicine(int id, String ypmc, String yplb, String ypjx, String ypdw, String ypjj, String ypsl, String jhrq, String ypph, String ypcd, String yxq) {
        this.id = id;
        this.ypmc = ypmc;
        this.yplb = yplb;
        this.ypjx = ypjx;
        this.ypdw = ypdw;
        this.ypjj = ypjj;
        this.ypsl = ypsl;
        this.jhrq = jhrq;
        this.ypph = ypph;
        this.ypcd = ypcd;
        this.yxq = yxq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc;
    }

    public String getYplb() {
        return yplb;
    }

    public void setYplb(String yplb) {
        this.yplb = yplb;
    }

    public String getYpjx() {
        return ypjx;
    }

    public void setYpjx(String ypjx) {
        this.ypjx = ypjx;
    }

    public String getYpdw() {
        return ypdw;
    }

    public void setYpdw(String ypdw) {
        this.ypdw = ypdw;
    }

    public String getYpjj() {
        return ypjj;
    }

    public void setYpjj(String ypjj) {
        this.ypjj = ypjj;
    }

    public String getYpsl() {
        return ypsl;
    }

    public void setYpsl(String ypsl) {
        this.ypsl = ypsl;
    }

    public String getJhrq() {
        return jhrq;
    }

    public void setJhrq(String jhrq) {
        this.jhrq = jhrq;
    }

    public String getYpph() {
        return ypph;
    }

    public void setYpph(String ypph) {
        this.ypph = ypph;
    }

    public String getYpcd() {
        return ypcd;
    }

    public void setYpcd(String ypcd) {
        this.ypcd = ypcd;
    }

    public String getYxq() {
        return yxq;
    }

    public void setYxq(String yxq) {
        this.yxq = yxq;
    }
}
