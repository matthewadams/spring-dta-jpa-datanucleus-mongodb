package app.domain;

public interface Persistable {

	Object getId();

	long getVersion();
}
