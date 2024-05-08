
package com.example.Model;

public class MemberDeleteCondition {

    private String khoa;
    private String nganh;
    private String maTVSubstring;

    public MemberDeleteCondition(String khoa, String nganh, String maTVSubstring) {
        this.khoa = khoa;
        this.nganh = nganh;
        this.maTVSubstring = maTVSubstring;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getMaTVSubstring() {
        return maTVSubstring;
    }

    public void setMaTVSubstring(String maTVSubstring) {
        this.maTVSubstring = maTVSubstring;
    }

    @Override
    public String toString() {
        return "MemberDeleteCondition{" +
                "khoa='" + khoa + '\'' +
                ", nganh='" + nganh + '\'' +
                ", maTVSubstring='" + maTVSubstring + '\'' +
                '}';
    }

    
}
