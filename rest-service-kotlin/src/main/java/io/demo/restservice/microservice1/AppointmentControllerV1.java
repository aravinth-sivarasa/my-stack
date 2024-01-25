package io.demo.restservice.microservice1;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.demo.restservice.microservice1.AppointmentDTO.Appointment;

@RestController
@RequestMapping("appointments/v1")
public class AppointmentControllerV1 {
    

    @GetMapping
    List<Appointment> all(){
        return Arrays.asList(//
            new Appointment(UUID.randomUUID().toString()),
            new Appointment(UUID.randomUUID().toString()));
    }
}
