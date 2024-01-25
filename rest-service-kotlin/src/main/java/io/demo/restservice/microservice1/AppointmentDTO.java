package io.demo.restservice.microservice1;

public class AppointmentDTO {
    public record Appointment(String id) {
    }
    public record InnerAppointmentDTO() {
    }
}
