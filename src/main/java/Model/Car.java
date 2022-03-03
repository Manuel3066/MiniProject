package Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cars")
public class Car {
	@Id
	@GeneratedValue
	private int carId;
	@Column(name="SAFETYRATING")
	private int safetyRating;
	@Column(name="MPG")
	private int mpg;
	@Column(name="PRICE")
	private double price;
	@Column(name="TYPE")
	private String Type;
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	@Column(name="YEAR")
	private String year;
	@Column(name="COLOR")
	private String color;
	@Column(name="ENGINE")
	private String engine;
	@Column(name="TRANSMISSION")
	private String transmission;
	@Column(name="FUELTYPE")
	private String fuelType;
	@Column(name="DRIVETRAIN")
	private String drivetrain;
	@Column(name="ORDERED")
	private Boolean ordered;
	
	public Car() {
		super();
	}

	public Car(int safetyRating, int mpg, double price, String type, String make, String model, String year,
			String color, String engine, String transmission, String fuelType, String drivetrain, Boolean ordered) {
		super();
		this.safetyRating = safetyRating;
		this.mpg = mpg;
		this.price = price;
		Type = type;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.engine = engine;
		this.transmission = transmission;
		this.fuelType = fuelType;
		this.drivetrain = drivetrain;
		this.ordered = ordered;
	}
	
	public int getCarId() {
		return carId;
	}
	
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public int getSafetyRating() {
		return safetyRating;
	}
	
	public void setSafetyRating(int safetyRating) {
		this.safetyRating = safetyRating;
	}
	
	public int getMpg() {
		return mpg;
	}
	
	public void setMpg(int mpg) {
		this.mpg = mpg;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String type) {
		Type = type;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getEngine() {
		return engine;
	}
	
	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	public String getTransmission() {
		return transmission;
	}
	
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	
	public String getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	public String getDrivetrain() {
		return drivetrain;
	}
	
	public void setDrivetrain(String drivetrain) {
		this.drivetrain = drivetrain;
	}

	public Boolean getOrdered() {
		return ordered;
	}

	public void setOrdered(Boolean ordered) {
		this.ordered = ordered;
	}
}
