package services.implementations;

import entities.implementations.Teacher;
import repositories.implementations.TeacherRepository;
import services.base.TeacherServiceInterface;

import java.util.List;
import java.util.Optional;

public class TeacherService implements TeacherServiceInterface {

    private final TeacherRepository teachersRepository;

    public TeacherService() {
        this.teachersRepository = new TeacherRepository();
    }

    public TeacherService(TeacherRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }

    public Teacher createTeacher(String name, String degree){
        Teacher teacher = new Teacher(name, degree);
        return this.addTeacher(teacher);
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        this.teachersRepository.save(teacher);
        return teacher;
    }

    @Override
    public List<Teacher> getAll(){
        return this.teachersRepository.getAll();
    }

    @Override
    public String getTeacherUUID(int seqId) {
      Optional<String> res = this.teachersRepository.getUUID(seqId);
        return res.orElse(null);
    }

    public int getCortegesNr() {
        return this.teachersRepository.getCortegesNr();
    }

    public Optional<Teacher> get(String id) {
        return this.teachersRepository.get(id);
    }
}
