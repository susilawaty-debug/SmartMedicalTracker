package com.kelompok15.tracker.medical;

import android.os.Parcel;
import android.os.Parcelable;

public class MedicalRecord implements Parcelable {

    private String patientName;
    private String deviceType;
    private double measurementValue;
    private String status;

    public MedicalRecord(String patientName, String deviceType,
                         double measurementValue, String status) {
        this.patientName = patientName;
        this.deviceType = deviceType;
        this.measurementValue = measurementValue;
        this.status = status;
    }

    protected MedicalRecord(Parcel in) {
        patientName = in.readString();
        deviceType = in.readString();
        measurementValue = in.readDouble();
        status = in.readString();
    }

    public static final Creator<MedicalRecord> CREATOR = new Creator<MedicalRecord>() {
        @Override
        public MedicalRecord createFromParcel(Parcel in) {
            return new MedicalRecord(in);
        }

        @Override
        public MedicalRecord[] newArray(int size) {
            return new MedicalRecord[size];
        }
    };

    public String getPatientName() {
        return patientName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public double getMeasurementValue() {
        return measurementValue;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(patientName);
        parcel.writeString(deviceType);
        parcel.writeDouble(measurementValue);
        parcel.writeString(status);
    }
}