package kr.human.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.human.jpa.vo.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
/*
public interface CrudRepository<T, ID> extends Repository<T, ID>
T : Type
ID : 키필드의 자료형
---------------------------------------------------------------------
CrudRepository에서 기본으로 제공되는 메서드들!!!!!
---------------------------------------------------------------------
// long count() - 사용 가능한 엔터티 수를 반환합니다.
// void delete(T entity) - 주어진 엔티티를 삭제합니다.
// void deleteAll() - 저장소에서 관리하는 모든 엔티티를 삭제합니다.
// void deleteAll(Iterable<? extends T> entities) - 주어진 엔티티를 삭제합니다.
// void deleteById(ID id) - 주어진 id를 가진 엔티티를 삭제합니다.
// boolean existById(ID id) - 주어진 ID를 가진 엔터티가 있는지 여부를 반환합니다.
// Iterable findAll() - 해당 유형의 모든 인스턴스를 반환합니다.
// Iterable findAllById(Iterable ids) - 주어진 ID를 가진 유형의 모든 인스턴스를 반환합니다.
// Optional<T>  findById(ID id) - 해당 ID로 엔티티를 검색합니다.
// save(S 엔티티) - 주어진 엔티티를 저장합니다.
// Iterable  saveAll(Iterable entities) - 주어진 모든 엔티티를 저장합니다.
*/
	// 사용자가 추가한 메서드
	// findAllByOrderBy필드명[Asc|Desc]필드명[Asc|Desc]...
	List<Person> findAllByOrderByIdxDesc();
}