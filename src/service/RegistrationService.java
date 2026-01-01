package service;

import model.Registration;

import java.util.List;

public interface RegistrationService {
    void register(Registration registration);
    List<Registration> getByStudent(String studentId);
    List<Registration> getAll();
}
