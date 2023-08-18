package com.Collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployENtity {

	
	
		private String name;
		
		private List<String> Phone;

		private Set<String> address;
		
		private Map<String,Integer> subjectmark;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getPhone() {
			return Phone;
		}

		public void setPhone(List<String> phone) {
			Phone = phone;
		}

		public Set<String> getAddress() {
			return address;
		}

		public void setAddress(Set<String> address) {
			this.address = address;
		}

		public Map<String, Integer> getSubjectmark() {
			return subjectmark;
		}

		public void setSubjectmark(Map<String, Integer> subjectmark) {
			this.subjectmark = subjectmark;
		}

		public EmployENtity(String name, List<String> phone, Set<String> address, Map<String, Integer> subjectmark) {
			super();
			this.name = name;
			Phone = phone;
			this.address = address;
			this.subjectmark = subjectmark;
		}

		public EmployENtity() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "EmployENtity [name=" + name + ", Phone=" + Phone + ", address=" + address + ", subjectmark="
					+ subjectmark + "]";
		} 
		
		
		
}
