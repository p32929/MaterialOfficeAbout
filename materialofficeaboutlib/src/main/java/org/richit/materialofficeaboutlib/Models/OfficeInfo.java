package org.richit.materialofficeaboutlib.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class OfficeInfo implements Parcelable {
    String officeLogoUrl;
    ArrayList<Link> links = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    public String getOfficeLogoUrl() {
        return officeLogoUrl;
    }

    public void setOfficeLogoUrl(String officeLogoUrl) {
        this.officeLogoUrl = officeLogoUrl;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Link> links) {
        this.links = links;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    protected OfficeInfo(Parcel in) {
        officeLogoUrl = in.readString();
        if (in.readByte() == 0x01) {
            links = new ArrayList<Link>();
            in.readList(links, Link.class.getClassLoader());
        } else {
            links = null;
        }
        if (in.readByte() == 0x01) {
            members = new ArrayList<Member>();
            in.readList(members, Member.class.getClassLoader());
        } else {
            members = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(officeLogoUrl);
        if (links == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(links);
        }
        if (members == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(members);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<OfficeInfo> CREATOR = new Parcelable.Creator<OfficeInfo>() {
        @Override
        public OfficeInfo createFromParcel(Parcel in) {
            return new OfficeInfo(in);
        }

        @Override
        public OfficeInfo[] newArray(int size) {
            return new OfficeInfo[size];
        }
    };
}