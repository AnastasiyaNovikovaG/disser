package entity;

import javax.persistence.*;

@Entity
@IdClass(PlanPK.class)
public class PlanEntity {
    private int idMonth;
    private int idType;
    private int idSem;
    private Integer hours;
    private int teacherId;
    private MonthsEntity monthsEntityByIdMonth;
    private TypeOfClass typeOfClassByIdType;
    private SemestrEntity semestrEntityByIdSem;
    private TeacherEntity teacherByTeacherEntityId;

    @Id
    @Column(name = "id_month")
    public int getIdMonth() {
        return idMonth;
    }

    public void setIdMonth(int idMonth) {
        this.idMonth = idMonth;
    }

    @Id
    @Column(name = "id_type")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "id_sem")
    public int getIdSem() {
        return idSem;
    }

    public void setIdSem(int idSem) {
        this.idSem = idSem;
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
    @Column(name = "teacher_id")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanEntity planEntity = (PlanEntity) o;

        if (idMonth != planEntity.idMonth) return false;
        if (idType != planEntity.idType) return false;
        if (idSem != planEntity.idSem) return false;
        if (teacherId != planEntity.teacherId) return false;
        if (hours != null ? !hours.equals(planEntity.hours) : planEntity.hours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMonth;
        result = 31 * result + idType;
        result = 31 * result + idSem;
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + teacherId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_month", referencedColumnName = "id", nullable = false)
    public MonthsEntity getMonthsByIdMonth() {
        return monthsEntityByIdMonth;
    }

    public void setMonthsByIdMonth(MonthsEntity monthsEntityByIdMonth) {
        this.monthsEntityByIdMonth = monthsEntityByIdMonth;
    }

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id", nullable = false)
    public TypeOfClass getTypeOfClassByIdType() {
        return typeOfClassByIdType;
    }

    public void setTypeOfClassByIdType(TypeOfClass typeOfClassByIdType) {
        this.typeOfClassByIdType = typeOfClassByIdType;
    }

    @ManyToOne
    @JoinColumn(name = "id_sem", referencedColumnName = "id", nullable = false)
    public SemestrEntity getSemestrByIdSem() {
        return semestrEntityByIdSem;
    }

    public void setSemestrByIdSem(SemestrEntity semestrEntityByIdSem) {
        this.semestrEntityByIdSem = semestrEntityByIdSem;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public TeacherEntity getTeacherByTeacherId() {
        return teacherByTeacherEntityId;
    }

    public void setTeacherByTeacherId(TeacherEntity teacherByTeacherEntityId) {
        this.teacherByTeacherEntityId = teacherByTeacherEntityId;
    }
}
