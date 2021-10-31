package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class LogbookEntity {
    private int id;
    private Date date;
    private Integer idType;
    private Integer idSubj;
    private Integer hours;
    private Integer idTeach;
    private Integer idSem;
    private int monthsId;
    private int departmentId;
    private TypeOfClassEntity typeOfClassByIdType;
    private SubjectEntity subjectEntityByIdSubj;
    private TeacherEntity teacherEntityByIdTeach;
    private SemestrEntity semestrEntityByIdSem;
    private MonthsEntity monthsByMonthsEntityId;
    private DepartmentEntity departmentByDepartmentEntityId;

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

        LogbookEntity logbookEntity = (LogbookEntity) o;

        if (id != logbookEntity.id) return false;
        if (monthsId != logbookEntity.monthsId) return false;
        if (departmentId != logbookEntity.departmentId) return false;
        if (date != null ? !date.equals(logbookEntity.date) : logbookEntity.date != null) return false;
        if (idType != null ? !idType.equals(logbookEntity.idType) : logbookEntity.idType != null) return false;
        if (idSubj != null ? !idSubj.equals(logbookEntity.idSubj) : logbookEntity.idSubj != null) return false;
        if (hours != null ? !hours.equals(logbookEntity.hours) : logbookEntity.hours != null) return false;
        if (idTeach != null ? !idTeach.equals(logbookEntity.idTeach) : logbookEntity.idTeach != null) return false;
        if (idSem != null ? !idSem.equals(logbookEntity.idSem) : logbookEntity.idSem != null) return false;

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
    public TypeOfClassEntity getTypeOfClassByIdType() {
        return typeOfClassByIdType;
    }

    public void setTypeOfClassByIdType(TypeOfClassEntity typeOfClassByIdType) {
        this.typeOfClassByIdType = typeOfClassByIdType;
    }

    @ManyToOne
    @JoinColumn(name = "id_subj", referencedColumnName = "id")
    public SubjectEntity getSubjectByIdSubj() {
        return subjectEntityByIdSubj;
    }

    public void setSubjectByIdSubj(SubjectEntity subjectEntityByIdSubj) {
        this.subjectEntityByIdSubj = subjectEntityByIdSubj;
    }

    @ManyToOne
    @JoinColumn(name = "id_teach", referencedColumnName = "id")
    public TeacherEntity getTeacherByIdTeach() {
        return teacherEntityByIdTeach;
    }

    public void setTeacherByIdTeach(TeacherEntity teacherEntityByIdTeach) {
        this.teacherEntityByIdTeach = teacherEntityByIdTeach;
    }

    @ManyToOne
    @JoinColumn(name = "id_sem", referencedColumnName = "id")
    public SemestrEntity getSemestrByIdSem() {
        return semestrEntityByIdSem;
    }

    public void setSemestrByIdSem(SemestrEntity semestrEntityByIdSem) {
        this.semestrEntityByIdSem = semestrEntityByIdSem;
    }

    @ManyToOne
    @JoinColumn(name = "months_id", referencedColumnName = "id", nullable = false)
    public MonthsEntity getMonthsByMonthsId() {
        return monthsByMonthsEntityId;
    }

    public void setMonthsByMonthsId(MonthsEntity monthsByMonthsEntityId) {
        this.monthsByMonthsEntityId = monthsByMonthsEntityId;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    public DepartmentEntity getDepartmentByDepartmentId() {
        return departmentByDepartmentEntityId;
    }

    public void setDepartmentByDepartmentId(DepartmentEntity departmentByDepartmentEntityId) {
        this.departmentByDepartmentEntityId = departmentByDepartmentEntityId;
    }
}
