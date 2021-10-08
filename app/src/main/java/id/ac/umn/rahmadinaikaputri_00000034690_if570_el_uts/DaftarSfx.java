package id.ac.umn.rahmadinaikaputri_00000034690_if570_el_uts;

import java.io.Serializable;

public class DaftarSfx implements Serializable {
    private String judulSfx;
    private String keteranganSfx;
    private String sfxURI;

    public DaftarSfx(String judulSfx, String keteranganSfx, String sfxURI){
        this.judulSfx = judulSfx;
        this.keteranganSfx = keteranganSfx;
        this.sfxURI = sfxURI;
    }

    public String getJudulSfx(){ return this.judulSfx; }
    public String getKeteranganSfx(){ return this.keteranganSfx; }
    public String getSfxURI(){ return this.sfxURI; }

    public void setJudulSfx(String judulSfx){
        this.judulSfx = judulSfx;
    }
    public  void setKeteranganSfx(String keteranganSfx){
        this.keteranganSfx = keteranganSfx;
    }
    public void setSfxURI(String sfxURI) {
        this.sfxURI = sfxURI;
    }
    public String toString(){
        return this.getJudulSfx() + " => " + this.getKeteranganSfx();
    }
}
