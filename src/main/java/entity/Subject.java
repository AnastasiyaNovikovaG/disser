package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Subject {
    private int id;
    private String subject;
    private Collection<Logbook> logbooksById;

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

        Subject subject1 = (Subject) o;

        if (id != subject1.id) return false;
        if (subject != null ? !subject.equals(subject1.subject) : subject1.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "subjectByIdSubj")
    public Collection<Logbook> getLogbooksById() {
        return logbooksById;
    }

    public void setLogbooksById(Collection<Logbook> logbooksById) {
        this.logbooksById = logbooksById;
    }
}
