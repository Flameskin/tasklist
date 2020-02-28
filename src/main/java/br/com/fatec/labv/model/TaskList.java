package br.com.fatec.labv.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TASKLIST")
public class TaskList {
	
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="tasklist_generator")
	@SequenceGenerator(name="tasklist_generator", sequenceName = "TASKLIST_SEQ", allocationSize=1)
	private Long id;
	
	@Column(name="TASKLIST_NAME", nullable = false, unique = true)
	private String name;
	
	@ManyToOne
	private User user; 
	
	@OneToMany(mappedBy = "tasklist", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
	private List<Task> tasks;
	
}
