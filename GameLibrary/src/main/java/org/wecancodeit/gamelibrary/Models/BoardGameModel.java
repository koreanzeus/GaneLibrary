package org.wecancodeit.gamelibrary.Models;

import org.springframework.lang.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_Boardgame")
public class BoardGameModel {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Size(max = 100, min = 5)
    @Column(name = "GameName", length = 100, unique = true)
    private String name;

    @NonNull
    @Size(max = 500)
    @Column(length = 500)
    private String description;

    @NonNull
    @Size(max = 500)
    @Column(length = 500)
    private String imageUrl;

    @ManyToOne
    @JsonIgnore
    private PublisherModel publisher;

    protected BoardGameModel() {
    }

    public BoardGameModel(@Size(max = 100, min = 5) String name, @Size(max = 500) String description,
            @Size(max = 500) String imageUrl, PublisherModel publisher) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public PublisherModel getPublisher() {
        return publisher;
    }
    
    public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setPublisher(PublisherModel publisher) {
		this.publisher = publisher;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BoardGameModel other = (BoardGameModel) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BoardGameModel [id=" + id + ", name=" + name + "]";
    }
}
