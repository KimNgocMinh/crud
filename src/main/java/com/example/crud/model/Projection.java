package com.example.crud.model;

import org.springframework.beans.factory.annotation.Value;

public class Projection {
    public static class AddressSumary {

        private String city;

        public AddressSumary(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

    }

    public interface AddressDTO {

        @Value("#{target.city} #{target.street}")
        String getInfo();

    }

    public interface UserDTO {

        @Value("#{target.lastName} #{target.firstName} #{target.balance}")
        String getInfo();
    }


}
