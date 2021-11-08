package novikava.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class TeacherEntity {
    private int id;
    private String surname;
    private String name;
    private String fathername;
    private String passport;
    private String idPassport;
    private String idInsurance;
    private Date datePassport;
    private String placePassport;
    private String postCode;
    private String address;
    private String mainJob;
    private String position;
    private String telHome;
    private String telJob;
    private String telMobile;
    private int idDegree;
    private int idTitle;
    private AcademicDegreeEntity academicDegreeByIdDegreeEntity;
    private AcademicTitleEntity academicTitleByIdTitleEntity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "fathername")
    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Basic
    @Column(name = "passport")
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "id_passport")
    public String getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(String idPassport) {
        this.idPassport = idPassport;
    }

    @Basic
    @Column(name = "id_insurance")
    public String getIdInsurance() {
        return idInsurance;
    }

    public void setIdInsurance(String idInsurance) {
        this.idInsurance = idInsurance;
    }

    @Basic
    @Column(name = "date_passport")
    public Date getDatePassport() {
        return datePassport;
    }

    public void setDatePassport(Date datePassport) {
        this.datePassport = datePassport;
    }

    @Basic
    @Column(name = "place_passport")
    public String getPlacePassport() {
        return placePassport;
    }

    public void setPlacePassport(String placePassport) {
        this.placePassport = placePassport;
    }

    @Basic
    @Column(name = "post_code")
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "main_job")
    public String getMainJob() {
        return mainJob;
    }

    public void setMainJob(String mainJob) {
        this.mainJob = mainJob;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "tel_home")
    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    @Basic
    @Column(name = "tel_job")
    public String getTelJob() {
        return telJob;
    }

    public void setTelJob(String telJob) {
        this.telJob = telJob;
    }

    @Basic
    @Column(name = "tel_mobile")
    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    @Basic
    @Column(name = "id_degree")
    public int getIdDegree() {
        return idDegree;
    }

    public void setIdDegree(int idDegree) {
        this.idDegree = idDegree;
    }

    @Basic
    @Column(name = "id_title")
    public int getIdTitle() {
        return idTitle;
    }

    public void setIdTitle(int idTitle) {
        this.idTitle = idTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherEntity teacherEntity = (TeacherEntity) o;

        if (id != teacherEntity.id) return false;
        if (idDegree != teacherEntity.idDegree) return false;
        if (idTitle != teacherEntity.idTitle) return false;
        if (surname != null ? !surname.equals(teacherEntity.surname) : teacherEntity.surname != null) return false;
        if (name != null ? !name.equals(teacherEntity.name) : teacherEntity.name != null) return false;
        if (fathername != null ? !fathername.equals(teacherEntity.fathername) : teacherEntity.fathername != null) return false;
        if (passport != null ? !passport.equals(teacherEntity.passport) : teacherEntity.passport != null) return false;
        if (idPassport != null ? !idPassport.equals(teacherEntity.idPassport) : teacherEntity.idPassport != null) return false;
        if (idInsurance != null ? !idInsurance.equals(teacherEntity.idInsurance) : teacherEntity.idInsurance != null) return false;
        if (datePassport != null ? !datePassport.equals(teacherEntity.datePassport) : teacherEntity.datePassport != null)
            return false;
        if (placePassport != null ? !placePassport.equals(teacherEntity.placePassport) : teacherEntity.placePassport != null)
            return false;
        if (postCode != null ? !postCode.equals(teacherEntity.postCode) : teacherEntity.postCode != null) return false;
        if (address != null ? !address.equals(teacherEntity.address) : teacherEntity.address != null) return false;
        if (mainJob != null ? !mainJob.equals(teacherEntity.mainJob) : teacherEntity.mainJob != null) return false;
        if (position != null ? !position.equals(teacherEntity.position) : teacherEntity.position != null) return false;
        if (telHome != null ? !telHome.equals(teacherEntity.telHome) : teacherEntity.telHome != null) return false;
        if (telJob != null ? !telJob.equals(teacherEntity.telJob) : teacherEntity.telJob != null) return false;
        if (telMobile != null ? !telMobile.equals(teacherEntity.telMobile) : teacherEntity.telMobile != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fathername != null ? fathername.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (idPassport != null ? idPassport.hashCode() : 0);
        result = 31 * result + (idInsurance != null ? idInsurance.hashCode() : 0);
        result = 31 * result + (datePassport != null ? datePassport.hashCode() : 0);
        result = 31 * result + (placePassport != null ? placePassport.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (mainJob != null ? mainJob.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (telHome != null ? telHome.hashCode() : 0);
        result = 31 * result + (telJob != null ? telJob.hashCode() : 0);
        result = 31 * result + (telMobile != null ? telMobile.hashCode() : 0);
        result = 31 * result + idDegree;
        result = 31 * result + idTitle;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_degree", referencedColumnName = "id", nullable = false)
    public AcademicDegreeEntity getAcademicDegreeByIdDegree() {
        return academicDegreeByIdDegreeEntity;
    }

    public void setAcademicDegreeByIdDegree(AcademicDegreeEntity academicDegreeByIdDegreeEntity) {
        this.academicDegreeByIdDegreeEntity = academicDegreeByIdDegreeEntity;
    }

    @ManyToOne
    @JoinColumn(name = "id_title", referencedColumnName = "id", nullable = false)
    public AcademicTitleEntity getAcademicTitleByIdTitle() {
        return academicTitleByIdTitleEntity;
    }

    public void setAcademicTitleByIdTitle(AcademicTitleEntity academicTitleByIdTitleEntity) {
        this.academicTitleByIdTitleEntity = academicTitleByIdTitleEntity;
    }
}
