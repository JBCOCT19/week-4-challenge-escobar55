public class Enrollments {
    private long id;
    private long studentId;
    private long facultyId;
    private long classId;

    public Enrollments() {
    }

    public Enrollments(long id, long studentId, long facultyId, long classId) {
        this.id = id;
        this.studentId = studentId;
        this.facultyId = facultyId;
        this.classId = classId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }
}
