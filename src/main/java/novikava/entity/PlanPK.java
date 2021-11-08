package novikava.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PlanPK implements Serializable {
    private int idMonth;
    private int idType;

    @Column(name = "id_month")
    @Id
    public int getIdMonth() {
        return idMonth;
    }

    public void setIdMonth(int idMonth) {
        this.idMonth = idMonth;
    }

    @Column(name = "id_type")
    @Id
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanPK planPK = (PlanPK) o;

        if (idMonth != planPK.idMonth) return false;
        if (idType != planPK.idType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMonth;
        result = 31 * result + idType;
        return result;
    }
}
