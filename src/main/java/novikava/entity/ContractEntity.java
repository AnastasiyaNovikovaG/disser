package novikava.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class ContractEntity {
    private int id;
    private Integer idTeacher;
    private Date dateFrom;
    private Date dateTo;
    private Integer valueH;
    private String dateC;
    private String conAggrNo;
    private Integer idFunsAccount;
    private String contractNo;
    private TeacherEntity teacherByIdTeacherEntity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_teacher")
    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Basic
    @Column(name = "date_from")
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Basic
    @Column(name = "date_to")
    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Basic
    @Column(name = "value_h")
    public Integer getValueH() {
        return valueH;
    }

    public void setValueH(Integer valueH) {
        this.valueH = valueH;
    }

    @Basic
    @Column(name = "date_c")
    public String getDateC() {
        return dateC;
    }

    public void setDateC(String dateC) {
        this.dateC = dateC;
    }

    @Basic
    @Column(name = "con_aggr_no")
    public String getConAggrNo() {
        return conAggrNo;
    }

    public void setConAggrNo(String conAggrNo) {
        this.conAggrNo = conAggrNo;
    }

    @Basic
    @Column(name = "id_funs_account")
    public Integer getIdFunsAccount() {
        return idFunsAccount;
    }

    public void setIdFunsAccount(Integer idFunsAccount) {
        this.idFunsAccount = idFunsAccount;
    }

    @Basic
    @Column(name = "contract_no")
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractEntity contractEntity = (ContractEntity) o;

        if (id != contractEntity.id) return false;
        if (idTeacher != null ? !idTeacher.equals(contractEntity.idTeacher) : contractEntity.idTeacher != null) return false;
        if (dateFrom != null ? !dateFrom.equals(contractEntity.dateFrom) : contractEntity.dateFrom != null) return false;
        if (dateTo != null ? !dateTo.equals(contractEntity.dateTo) : contractEntity.dateTo != null) return false;
        if (valueH != null ? !valueH.equals(contractEntity.valueH) : contractEntity.valueH != null) return false;
        if (dateC != null ? !dateC.equals(contractEntity.dateC) : contractEntity.dateC != null) return false;
        if (conAggrNo != null ? !conAggrNo.equals(contractEntity.conAggrNo) : contractEntity.conAggrNo != null) return false;
        if (idFunsAccount != null ? !idFunsAccount.equals(contractEntity.idFunsAccount) : contractEntity.idFunsAccount != null)
            return false;
        if (contractNo != null ? !contractNo.equals(contractEntity.contractNo) : contractEntity.contractNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idTeacher != null ? idTeacher.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (valueH != null ? valueH.hashCode() : 0);
        result = 31 * result + (dateC != null ? dateC.hashCode() : 0);
        result = 31 * result + (conAggrNo != null ? conAggrNo.hashCode() : 0);
        result = 31 * result + (idFunsAccount != null ? idFunsAccount.hashCode() : 0);
        result = 31 * result + (contractNo != null ? contractNo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id")
    public TeacherEntity getTeacherByIdTeacher() {
        return teacherByIdTeacherEntity;
    }

    public void setTeacherByIdTeacher(TeacherEntity teacherByIdTeacherEntity) {
        this.teacherByIdTeacherEntity = teacherByIdTeacherEntity;
    }
}
