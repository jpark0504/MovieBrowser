package com.example.demo.model;

import java.util.Base64;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int id;
	
	@Column(name = "title")
	private String title;

	@Temporal(value=TemporalType.DATE)
	@Column(name = "releasedate")
	private Date releaseDate;
	
	@Column(name = "boxoffice")
	private Long boxOffice;
	
	@Column(name = "award")
	private Boolean award;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "director_id")
	private Director director;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "filmmaker_id")
	private FilmMaker filmMaker;
	
	@JsonIgnore
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	@Column(name = "poster")
	private byte[] poster;
	
	@Transient
	private String poster_encoded;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Long getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(Long boxOffice) {
		this.boxOffice = boxOffice;
	}

	public Boolean getAward() {
		return award;
	}

	public void setAward(Boolean award) {
		this.award = award;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public FilmMaker getFilmMaker() {
		return filmMaker;
	}

	public void setFilmMaker(FilmMaker filmMaker) {
		this.filmMaker = filmMaker;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public String getPoster_encoded() {
		return poster_encoded;
	}

	public void setPoster_encoded(String poster_encoded) {
		this.poster_encoded = poster_encoded;
	}
}
