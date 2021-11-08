package novikava.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class SubjectEntity {
    private int id;
    private String subject;
    private Collection<LogbookEntity> logbooksById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectEntity subjectEntity1 = (SubjectEntity) o;

        if (id != subjectEntity1.id) return false;
        if (subject != null ? !subject.equals(subjectEntity1.subject) : subjectEntity1.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "subjectByIdSubj")
    public Collection<LogbookEntity> getLogbooksById() {
        return logbooksById;
    }

    public void setLogbooksById(Collection<LogbookEntity> logbooksById) {
        this.logbooksById = logbooksById;
    }
}
