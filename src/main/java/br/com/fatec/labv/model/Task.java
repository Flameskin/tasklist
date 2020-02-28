package br.com.fatec.labv.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TASK")
public class Task {
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "task_generator")
	@SequenceGenerator(name = "task_generator", sequenceName = "TASK_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name = "TASK_NAME", nullable = false)
	private String name;
	
	@Column(name = "TASK_DESCRIPTION")
	private String description;
	
	@Column(name = "TASK_CONCLUSION")
	private String conclusion;
	
	@Column(name = "TASK_STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	private TaskList tasklist;
}
