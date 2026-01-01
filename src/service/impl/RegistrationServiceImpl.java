package service.impl;

import model.Registration;
import service.RegistrationService;

import java.util.*;

public class RegistrationServiceImpl implements RegistrationService {

    private final List<Registration> registrations = new ArrayList<>();

    @Override
    public void register(Registration registration) {
        registrations.add(registration);
    }

    @Override
    public List<Registration> getByStudent(String studentId) {
        List<Registration> result = new ArrayList<>();
        for (Registration r : registrations) {
            if (r.getStudentId().equals(studentId)) {
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public List<Registration> getAll() {
        return registrations;
    }
}
