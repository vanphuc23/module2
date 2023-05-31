package service;

import model.Student;

public interface IStudentService {
    void display();

    Student[] add();

    Student[] edit();

    void delete();
}

