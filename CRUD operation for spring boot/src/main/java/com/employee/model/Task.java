package com.employee.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
// import javax.persistence.Table;

@Entity
// @Table(name = "task")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String description;
    @ManyToOne

    
    @JoinTable(name = "emp_id" , joinColumns = {@JoinColumn(name = "id")} , 
     inverseJoinColumns =  {@JoinColumn(name = "id")})

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return description;
    }

    public void setName(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}
