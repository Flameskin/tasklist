package br.com.fatec.labv.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="USER")
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="user_generator")
	@SequenceGenerator(name="user_generator", sequenceName = "USER_SEQ", allocationSize=1)
	private Long id;
	
	@Column(name = "USER_USERNAME")
	private String userName; 
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	private List<TaskList> taskLists;	
	
}
