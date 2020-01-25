
package com.app.cancellingretrofitrequests.java.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Item {

    @SerializedName("checksum")
    private Checksum mChecksum;
    @SerializedName("dataset_citation")
    private String mDatasetCitation;
    @SerializedName("dataset_id")
    private String mDatasetId;
    @SerializedName("dataset_name")
    private String mDatasetName;
    @SerializedName("dataset_persistent_id")
    private String mDatasetPersistentId;
    @SerializedName("file_content_type")
    private String mFileContentType;
    @SerializedName("file_id")
    private String mFileId;
    @SerializedName("file_type")
    private String mFileType;
    @SerializedName("md5")
    private String mMd5;
    @SerializedName("name")
    private String mName;
    @SerializedName("published_at")
    private String mPublishedAt;
    @SerializedName("size_in_bytes")
    private Long mSizeInBytes;
    @SerializedName("type")
    private String mType;
    @SerializedName("url")
    private String mUrl;

    public Checksum getChecksum() {
        return mChecksum;
    }

    public void setChecksum(Checksum checksum) {
        mChecksum = checksum;
    }

    public String getDatasetCitation() {
        return mDatasetCitation;
    }

    public void setDatasetCitation(String datasetCitation) {
        mDatasetCitation = datasetCitation;
    }

    public String getDatasetId() {
        return mDatasetId;
    }

    public void setDatasetId(String datasetId) {
        mDatasetId = datasetId;
    }

    public String getDatasetName() {
        return mDatasetName;
    }

    public void setDatasetName(String datasetName) {
        mDatasetName = datasetName;
    }

    public String getDatasetPersistentId() {
        return mDatasetPersistentId;
    }

    public void setDatasetPersistentId(String datasetPersistentId) {
        mDatasetPersistentId = datasetPersistentId;
    }

    public String getFileContentType() {
        return mFileContentType;
    }

    public void setFileContentType(String fileContentType) {
        mFileContentType = fileContentType;
    }

    public String getFileId() {
        return mFileId;
    }

    public void setFileId(String fileId) {
        mFileId = fileId;
    }

    public String getFileType() {
        return mFileType;
    }

    public void setFileType(String fileType) {
        mFileType = fileType;
    }

    public String getMd5() {
        return mMd5;
    }

    public void setMd5(String md5) {
        mMd5 = md5;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        mPublishedAt = publishedAt;
    }

    public Long getSizeInBytes() {
        return mSizeInBytes;
    }

    public void setSizeInBytes(Long sizeInBytes) {
        mSizeInBytes = sizeInBytes;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
