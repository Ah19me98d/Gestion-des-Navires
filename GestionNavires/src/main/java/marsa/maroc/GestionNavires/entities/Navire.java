package marsa.maroc.GestionNavires.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Navire {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateArrivee, dateTravail;
	@DecimalMax("3")@DecimalMin("1")
	private int shift;
	private String marchandise;
	@ToString.Exclude
	@OneToMany(mappedBy = "navire")
	private Collection<Grue> grues;
}
