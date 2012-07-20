package app.domain.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaSpecificationQueryDslRepository<T, ID extends Serializable>
		extends JpaRepository<T, ID>, QueryDslPredicateExecutor<T>,
		JpaSpecificationExecutor<T> {

}
