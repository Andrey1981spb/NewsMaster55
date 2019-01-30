package ru.spb.push.directions;

import javax.persistence.*;

@Entity
@Table(name = "directionmaster")
public class Directiondata {

    @Id
    @SequenceGenerator(name = "directionmaster_id_seq",
            sequenceName = "directionmaster_id_seq",
            allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE,
            generator = "directionmaster_id_seq")
    @Column(name = "dir_id", unique = true)
    public int dir_id;

    private String job;
    private String admission;

    public Directiondata() {
    }

    public int getDir_id() {
        return dir_id;
    }

    public void setDir_id(int dir_id) {
        this.dir_id = dir_id;
    }

    @Column(name = "job")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Column(name = "admission")
    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }
}
