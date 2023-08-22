package com.Student.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "result_table_student")
public class StudentResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	private int marks;
	
	@Column(name="is_recheck")
	private Boolean is_active=null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public StudentResult(int id, Student student, Subject subject, int marks) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.marks = marks;
	}

	public StudentResult() {
		super();
	}

	public Boolean get_Is_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public StudentResult(int id, Student student, Subject subject, int marks, Boolean is_active) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
		this.marks = marks;
		this.is_active = is_active;
	}

}
