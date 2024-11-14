package com.devArceus.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;
@Embeddable
public class BelongingBK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game id;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BelongingBK(){

    }

    public BelongingBK(Game id, GameList list) {
        this.id = id;
        this.list = list;
    }

    public Game getGame() {
        return id;
    }

    public void setGame(Game id) {
        this.id = id;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BelongingBK that)) return false;
        return Objects.equals(getGame(), that.getGame()) && Objects.equals(getList(), that.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGame(), getList());
    }
}
