package com.xadmin.usermanagement.model;


public class Country {
	protected int id;
	protected String name;
	protected float $2020;
	protected float $2021;
	protected float $2022;
	
	public Country() {
	}
	public Country(String name, float $2022) {
		super();
		this.name = name;
		this.$2022 = $2022;
	}
	public Country(String name, float $2021, float $2022) {
		super();
		this.name = name;
		this.$2021 = $2021;
		this.$2022 = $2022;
	}

	public Country(String name, float $2020, float $2021, float $2022) {
		super();
		this.name = name;
		this.$2020 = $2020;
		this.$2021 = $2021;
		this.$2022 = $2022;
	}

	public Country(int id, String name, float $2020, float $2021, float $2022) {
		super();
		this.id = id;
		this.name = name;
		this.$2020 = $2020;
		this.$2021 = $2021;
		this.$2022 = $2022;
	}

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float get$2020() {
		return $2020;
	}

	public void set$2020(float $2020) {
		this.$2020 = $2020;
	}

	public float get$2021() {
		return $2021;
	}

	public void set$2021(float $2021) {
		this.$2021 = $2021;
	}

	public float get$2022() {
		return $2022;
	}

	public void set$2022(float $2022) {
		this.$2022 = $2022;
	}
}