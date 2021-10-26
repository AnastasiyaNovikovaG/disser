package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Logbook {
    private int id;
    private Date date;
    private Integer idType;
    private Integer idSubj;
    private Integer hours;
    private Integer idTeach;
    private Integer idSem;
    private int monthsId;
    private int departmentId;
    private TypeOfClass typeOfClassByIdType;
    private Subject subjectByIdSubj;
    private Teacher teacherByIdTeach;
    private Semestr semestrByIdSem;
    private Months monthsByMonthsId;
    private Department departmentByDepartmentId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "id_type")
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "id_subj")
    public Integer getIdSubj() {
        return idSubj;
    }

    public void setIdSubj(Integer idSubj) {
        this.idSubj = idSubj;
    }

    @Basic
    @Column(name = "hours")
    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "id_teach")
    public Integer getIdTeach() {
        return idTeach;
    }

    public void setIdTeach(Integer idTeach) {
        this.idTeach = idTeach;
    }

    @Basic
    @Column(name = "id_sem")
    public Integer getIdSem() {
        return idSem;
    }

    public void setIdSem(Integer idSem) {
        this.idSem = idSem;
    }

    @Basic
    @Column(name = "months_id")
    public int getMonthsId() {
        return monthsId;
    }

    public void setMonthsId(int monthsId) {
        this.monthsId = monthsId;
    }

    @Basic
    @Column(name = "department_id")
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logbook logbook = (Logbook) o;

        if (id != logbook.id) return false;
        if (monthsId != logbook.monthsId) return false;
        if (departmentId != logbook.departmentId) return false;
        if (date != null ? !date.equals(logbook.date) : logbook.date != null) return false;
        if (idType != null ? !idType.equals(logbook.idType) : logbook.idType != null) return false;
        if (idSubj != null ? !idSubj.equals(logbook.idSubj) : logbook.idSubj != null) return false;
        if (hours != null ? !hours.equals(logbook.hours) : logbook.hours != null) return false;
        if (idTeach != null ? !idTeach.equals(logbook.idTeach) : logbook.idTeach != null) return false;
        if (idSem != null ? !idSem.equals(logbook.idSem) : logbook.idSem != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (idType != null ? idType.hashCode() : 0);
        result = 31 * result + (idSubj != null ? idSubj.hashCode() : 0);
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (idTeach != null ? idTeach.hashCode() : 0);
        result = 31 * result + (idSem != null ? idSem.hashCode() : 0);
        result = 31 * result + monthsId;
        result = 31 * result + departmentId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    public TypeOfClass getTypeOfClassByIdType() {
        return typeOfClassByIdType;
    }

    public void setTypeOfClassByIdType(TypeOfClass typeOfClassByIdType) {
        this.typeOfClassByIdType = typeOfClassByIdType;
    }

    @ManyToOne
    @JoinColumn(name = "id_subj", referencedColumnName = "id")
    public Subject getSubjectByIdSubj() {
        return subjectByIdSubj;
    }

    public void setSubjectByIdSubj(Subject subjectByIdSubj) {
        this.subjectByIdSubj = subjectByIdSubj;
    }

    @ManyToOne
    @JoinColumn(name = "id_teach", referencedColumnName = "id")
    public Teacher getTeacherByIdTeach() {
        return teacherByIdTeach;
    }

    public void setTeacherByIdTeach(Teacher teacherByIdTeach) {
        this.teacherByIdTeach = teacherByIdTeach;
    }

    @ManyToOne
    @JoinColumn(name = "id_sem", referencedColumnName = "id")
    public Semestr getSemestrByIdSem() {
        return semestrByIdSem;
    }

    public void setSemestrByIdSem(Semestr semestrByIdSem) {
        this.semestrByIdSem = semestrByIdSem;
    }

    @ManyToOne
    @JoinColumn(name = "months_id", referencedColumnName = "id", nullable = false)
    public Months getMonthsByMonthsId() {
        return monthsByMonthsId;
    }

    public void setMonthsByMonthsId(Months monthsByMonthsId) {
        this.monthsByMonthsId = monthsByMonthsId;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    public Department getDepartmentByDepartmentId() {
        return departmentByDepartmentId;
    }

    public void setDepartmentByDepartmentId(Department departmentByDepartmentId) {
        this.departmentByDepartmentId = departmentByDepartmentId;
    }
}
