package com.tomclaw.appsend.main.item;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.tomclaw.appsend.util.Unobfuscatable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivsolkin on 11.01.17.
 */
public class StoreItem extends BaseItem implements Parcelable, Unobfuscatable {

    public static final int NOT_INSTALLED = -1;

    @SerializedName("def_label")
    private final String label;
    private final Map<String, String> labels;
    private final String icon;
    @SerializedName("app_id")
    private final String appId;
    @SerializedName("package")
    private final String packageName;
    @SerializedName("ver_name")
    private final String version;
    @SerializedName("ver_code")
    private final int versionCode;
    @SerializedName("sdk_version")
    private final int sdkVersion;
    @SerializedName("android")
    private final String androidVersion;
    private final List<String> permissions;
    private final long size;
    private final int downloads;
    private final float rating;
    @SerializedName("download_time")
    private final long downloadTime;
    private final long time;
    private final String sha1;
    @SerializedName("user_id")
    private final long userId;
    private final String filter;
    private int installedVersionCode;

    public StoreItem(String label, Map<String, String> labels, String icon,
                     String appId, String packageName, String version,
                     int versionCode, int sdkVersion, String androidVersion,
                     List<String> permissions, long size, int downloads, long downloadTime,
                     long time, String sha1, long userId, float rating, String filter) {
        this.label = label;
        this.labels = labels;
        this.icon = icon;
        this.appId = appId;
        this.packageName = packageName;
        this.version = version;
        this.versionCode = versionCode;
        this.sdkVersion = sdkVersion;
        this.androidVersion = androidVersion;
        this.permissions = permissions;
        this.size = size;
        this.downloads = downloads;
        this.downloadTime = downloadTime;
        this.time = time;
        this.sha1 = sha1;
        this.userId = userId;
        this.rating = rating;
        this.filter = filter;
        this.installedVersionCode = NOT_INSTALLED;
    }

    protected StoreItem(Parcel in) {
        label = in.readString();
        labels = new HashMap<>();
        int labelsCount = in.readInt();
        for (int i = 0; i < labelsCount; i++) {
            String key = in.readString();
            String value = in.readString();
            labels.put(key, value);
        }
        icon = in.readString();
        appId = in.readString();
        packageName = in.readString();
        version = in.readString();
        versionCode = in.readInt();
        sdkVersion = in.readInt();
        androidVersion = in.readString();
        permissions = in.createStringArrayList();
        size = in.readLong();
        downloads = in.readInt();
        downloadTime = in.readLong();
        time = in.readLong();
        sha1 = in.readString();
        userId = in.readLong();
        rating = in.readFloat();
        filter = in.readString();
        installedVersionCode = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        dest.writeInt(labels.size());
        for (Map.Entry<String, String> entry : labels.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
        dest.writeString(icon);
        dest.writeString(appId);
        dest.writeString(packageName);
        dest.writeString(version);
        dest.writeInt(versionCode);
        dest.writeInt(sdkVersion);
        dest.writeString(androidVersion);
        dest.writeStringList(permissions);
        dest.writeLong(size);
        dest.writeInt(downloads);
        dest.writeLong(downloadTime);
        dest.writeLong(time);
        dest.writeString(sha1);
        dest.writeLong(userId);
        dest.writeFloat(rating);
        dest.writeString(filter);
        dest.writeInt(installedVersionCode);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StoreItem> CREATOR = new Creator<StoreItem>() {
        @Override
        public StoreItem createFromParcel(Parcel in) {
            return new StoreItem(in);
        }

        @Override
        public StoreItem[] newArray(int size) {
            return new StoreItem[size];
        }
    };

    @Override
    public int getType() {
        return STORE_ITEM;
    }

    public String getLabel() {
        return label;
    }

    public Map<String, String> getLabels() {
        return labels;
    }

    public String getIcon() {
        return icon;
    }

    public String getAppId() {
        return appId;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getVersion() {
        return version;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public int getSdkVersion() {
        return sdkVersion;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public long getSize() {
        return size;
    }

    public int getDownloads() {
        return downloads;
    }

    public float getRating() {
        return rating;
    }

    public long getDownloadTime() {
        return downloadTime;
    }

    public long getTime() {
        return time;
    }

    public String getSha1() {
        return sha1;
    }

    public long getUserId() {
        return userId;
    }

    public String getFilter() {
        return filter;
    }

    public int getInstalledVersionCode() {
        return installedVersionCode;
    }

    public void setInstalledVersionCode(int installedVersionCode) {
        this.installedVersionCode = installedVersionCode;
    }
}
