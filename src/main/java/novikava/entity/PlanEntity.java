package novikava.entity;

import javax.persistence.*;

@Entity
@Table(name = "plan", schema = "mydb", catalog = "")
public class PlanEntity {
    private int idMonth;
    private int idType;
    private int idSem;
    private Integer hours;
    private int teacherId;
    private int id;
    private MonthsEntity monthsEntityByIdMonth;
    private TypeOfClassEntity typeOfClassByIdType;
    private SemestrEntity semestrEntityByIdSem;
    private TeacherEntity teacherByTeacherEntityId;

    @Basic
    @Column(name = "id_month")
    public int getIdMonth() {
        return idMonth;
    }

    public void setIdMonth(int idMonth) {
        this.idMonth = idMonth;
    }

    @Basic
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

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanEntity that = (PlanEntity) o;

        if (idMonth != that.idMonth) return false;
        if (idType != that.idType) return false;
        if (idSem != that.idSem) return false;
        if (teacherId != that.teacherId) return false;
        if (id != that.id) return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMonth;
        result = 31 * result + idType;
        result = 31 * result + idSem;
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + teacherId;
        result = 31 * result + id;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_month", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public MonthsEntity getMonthsByIdMonth() {
        return monthsEntityByIdMonth;
    }

    public void setMonthsByIdMonth(MonthsEntity monthsEntityByIdMonth) {
        this.monthsEntityByIdMonth = monthsEntityByIdMonth;
    }

    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TypeOfClassEntity getTypeOfClassByIdType() {
        return typeOfClassByIdType;
    }

    public void setTypeOfClassByIdType(TypeOfClassEntity typeOfClassByIdType) {
        this.typeOfClassByIdType = typeOfClassByIdType;
    }

    @ManyToOne
    @JoinColumn(name = "id_sem", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public SemestrEntity getSemestrByIdSem() {
        return semestrEntityByIdSem;
    }

    public void setSemestrByIdSem(SemestrEntity semestrEntityByIdSem) {
        this.semestrEntityByIdSem = semestrEntityByIdSem;
    }

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TeacherEntity getTeacherByTeacherId() {
        return teacherByTeacherEntityId;
    }

    public void setTeacherByTeacherId(TeacherEntity teacherByTeacherEntityId) {
        this.teacherByTeacherEntityId = teacherByTeacherEntityId;
    }
}
