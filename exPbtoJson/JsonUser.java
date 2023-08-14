package com.ex.pbtojson;

public class JsonUser {
        private long registertime;
        private String userid;
        private String regionid;
        private String gender;

        public JsonUser() {
            // Default constructor
        }

        public long getRegistertime() {
            return registertime;
        }

        public void setRegistertime(long registertime) {
            this.registertime = registertime;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getRegionid() {
            return regionid;
        }

        public void setRegionid(String regionid) {
            this.regionid = regionid;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Users{" +
                    "registertime=" + registertime +
                    ", userid='" + userid + '\'' +
                    ", regionid='" + regionid + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }

}
