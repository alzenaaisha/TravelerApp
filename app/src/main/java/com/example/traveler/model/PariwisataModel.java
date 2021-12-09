package com.example.traveler.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class PariwisataModel {
    private List<Data> data;


    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data{
        private String name;
        private String thumbnail;
        private String description;
        private String latitude;
        private String longitude;

        private static final String BASE_URL="https://fpi-pariwisata-palembang-api.herokuapp.com";
        public Data(JSONObject jsonObject) {
            try {
                String name=jsonObject.getString("name");
                String thumbnail=jsonObject.getString("thumbnail");
                String description=jsonObject.getString("description");
                String latitude=jsonObject.getString("latitude");
                String longitude=jsonObject.getString("longitude");

                this.name = name;
                this.thumbnail = thumbnail;
                this.description = description;
                this.latitude = latitude;
                this.longitude = longitude;

            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumbnail() {
            return BASE_URL+thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        //untuk logcat
        @Override
        public String toString() {
            return "Data{" +
                    ", name='" + name + '\'' +
                    ", thumbnail='" + BASE_URL+thumbnail + '\'' +
                    ", deskripsi='" + description + '\'' +
                    ", latitude='" + latitude + '\'' +
                    ", longitude='" + longitude + '\'' +
                    '}';
        }
    }
}

