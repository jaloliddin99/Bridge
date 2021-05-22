package com.jaloliddinabdullaevv.bridge.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionNumber implements Parcelable {
    private int id;
    private String savol, javobA, javobB, javobC, aniqJavob;


    public QuestionNumber() {
    }

    public QuestionNumber(int id, String savol, String javobA, String javobB, String javobC, String aniqJavob) {
        this.id = id;
        this.savol = savol;
        this.javobA = javobA;
        this.javobB = javobB;
        this.javobC = javobC;

        this.aniqJavob = aniqJavob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSavol() {
        return savol;
    }

    public void setSavol(String savol) {
        this.savol = savol;
    }

    public String getJavobA() {
        return javobA;
    }

    public void setJavobA(String javobA) {
        this.javobA = javobA;
    }

    public String getJavobB() {
        return javobB;
    }

    public void setJavobB(String javobB) {
        this.javobB = javobB;
    }

    public String getJavobC() {
        return javobC;
    }

    public void setJavobC(String javobC) {
        this.javobC = javobC;
    }

    public String getAniqJavob() {
        return aniqJavob;
    }

    public void setAniqJavob(String aniqJavob) {
        this.aniqJavob = aniqJavob;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(savol);
        dest.writeString(javobA);
        dest.writeString(javobB);
        dest.writeString(javobC);
        dest.writeString(aniqJavob);
    }


    public QuestionNumber(Parcel in) {
        id = in.readInt();
        savol = in.readString();
        javobA=in.readString();
        javobB=in.readString();
        javobC=in.readString();
        aniqJavob=in.readString();
    }

    public static final Creator<QuestionNumber> CREATOR = new Creator<QuestionNumber>() {
        public QuestionNumber createFromParcel(Parcel in) {
            return new QuestionNumber(in);
        }

        public QuestionNumber[] newArray(int size) {
            return new QuestionNumber[size];
        }
    };
}
