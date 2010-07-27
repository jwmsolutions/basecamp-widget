package com.jwmsolutions.timeCheck.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author <a href="mailto:jorge.ruiz@jwmsolutions.com">Jorge Ruiz Aquino</a>
 */
public class BasecampProjects extends BaseObject {
	private ProjectArrayList project = new ProjectArrayList();

	public ProjectArrayList getProject() {
		return project;
	}
	public void setProject(ProjectArrayList project) {
		this.project = project;
	}
	public void addProject(BasecampProject o) {
		this.project.add(o);
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof BasecampProjects)) {
			return false;
		}
		BasecampProjects rhs = (BasecampProjects) object;
		return new EqualsBuilder().append(this.datePatterns, rhs.datePatterns)
				.append(this.project, rhs.project).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1202754413, -660571513).append(
				this.datePatterns).append(this.project).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("projectList", this.project).toString();
	}
}
