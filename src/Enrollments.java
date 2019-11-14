public class Enrollments {
    private long id;
    private long studentId;
    private long facultyId;
    private long classId;
    private String date;

    public Enrollments() {
    }

    public Enrollments(long id, long studentId, long facultyId, long classId, String date) {
        this.id = id;
        this.studentId = studentId;
        this.facultyId = facultyId;
        this.classId = classId;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
