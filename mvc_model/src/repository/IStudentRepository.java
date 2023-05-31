package repository;

import model.Student;

public interface IStudentRepository {
    Student[] findAll();

    int getSize();

    Student[] deleteStudent();

    int upSize();

    int downSize();
}

