package app.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@MappedSuperclass
public abstract class AbstractEntity implements Persistable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected String id;

	@Version
	protected long version;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public long getVersion() {
		return version;
	}

	@Override
	public boolean equals(Object that) {
		if (that == null) {
			return false;
		}
		if (this == that) {
			return true;
		}
		if (!(that instanceof AbstractEntity)) {
			return false;
		}
		return equals((AbstractEntity) that);
	}

	public boolean equals(AbstractEntity that) {
		if (that == null) {
			return false;
		}
		if (this == that) {
			return true;
		}
		if (this.id == null) {
			return that.id == null;
		}
		return this.id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
