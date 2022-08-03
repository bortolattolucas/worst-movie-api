package com.goldenraspberryawards.worstmovieapi.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Award extends DefaultEntity {

    private Long nominationYear;
    private String title;
    private boolean winner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_award_studio",
            joinColumns = @JoinColumn(name = "award_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private final Set<Studio> studios = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_award_producer",
            joinColumns = @JoinColumn(name = "award_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id"))
    private final Set<Producer> producers = new HashSet<>();

    public Award() {
    }

    public Award(Long nominationYear, String title, boolean winner) {
        this.nominationYear = nominationYear;
        this.title = title;
        this.winner = winner;
    }

    public Long getNominationYear() {
        return nominationYear;
    }

    public void setNominationYear(Long year) {
        this.nominationYear = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public Set<Studio> getStudios() {
        return studios;
    }

    public Set<Producer> getProducers() {
        return producers;
    }
}
