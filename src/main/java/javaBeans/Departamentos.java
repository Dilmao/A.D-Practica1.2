package javaBeans;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "departamentos")
public class Departamentos {
    private List<Departamento> listaDeps;

    public Departamentos() {

    }

    @XmlElement(name = "departamento")
    public List<Departamento> getListaDeps() {
        return listaDeps;
    }

    public void setListaDeps(List<Departamento> listaDeps) {
        this.listaDeps = listaDeps;
    }
}
