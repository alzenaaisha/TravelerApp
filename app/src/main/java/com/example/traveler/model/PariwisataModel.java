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
        private static final String BASE_URL="https://fpi-pariwisata-palembang-api.herokuapp.com";
        public Data(JSONObject jsonObject) {
            try {
                String name=jsonObject.getString("name");
                String thumbnail=jsonObject.getString("thumbnail");

                this.name=name;
                this.thumbnail=thumbnail;

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

        //untuk logcat
        @Override
        public String toString() {
            return "Data{" +
                    ", name='" + name + '\'' +
                    ", thumbnail='" + BASE_URL+thumbnail + '\'' +
                    '}';
        }
    }
}

