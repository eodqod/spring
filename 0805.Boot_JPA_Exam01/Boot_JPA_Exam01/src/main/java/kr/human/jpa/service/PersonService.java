package kr.human.jpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.human.jpa.dao.PersonRepository;
import kr.human.jpa.vo.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	// long count() - 사용 가능한 엔터티 수를 반환합니다.
	public long selectCount() {
		return personRepository.count();
	}

	// save(S 엔티티) - 주어진 엔티티를 저장합니다.
	public void insert(Person person) {
		if(person!=null) {
			person.setRegDate(new Date());
			// save(S 엔티티) - 주어진 엔티티를 저장합니다.
			personRepository.save(person); // 1개 저장이다.
		}
	}
	
	// Iterable  saveAll(Iterable entities) - 주어진 모든 엔티티를 저장합니다.
	public void saveAll(List<Person> list) {
		if(list!=null && list.size()>0) {
			personRepository.saveAll(list);
		}
	}
	
	// Iterable findAll() - 해당 유형의 모든 인스턴스를 반환합니다.
	public List<Person> selectList(String sort) {
		Iterable<Person> it = null;
		if(sort.equals("asc"))
			it =  personRepository.findAll(); // 기본적으로 저장순서이다.
		else
			it =  personRepository.findAllByOrderByIdxDesc();
			
		List<Person> list = new ArrayList<>();
		it.forEach(list::add);  
		return list;  
	}
	// Iterable findAllById(Iterable ids) - 주어진 ID를 가진 유형의 모든 인스턴스를 반환합니다.
	public List<Person> findAllByIds() {
		Iterable<Person> it = personRepository.findAll(); 
		List<Long> list = new ArrayList<>();
		Random rnd = new Random();
		for(Person person : it) {
			if(rnd.nextBoolean()) {
				list.add(person.getIdx());
			}
		}
		Iterable<Person> persons = personRepository.findAllById(list);
		List<Person> personList = new ArrayList<>();
		persons.forEach(personList::add);  
		return personList;  
	}
	
	//void deleteAll() - 저장소에서 관리하는 모든 엔티티를 삭제합니다.
	public void deleteAll() {
		personRepository.deleteAll();
	}
	
	// void deleteAll(Iterable<? extends T> entities) - 주어진 엔티티를 삭제합니다.
	public void deleteAll2() {
		Iterable<Person> it = personRepository.findAll(); // 모두 가져와
		List<Person> list = new ArrayList<Person>(); // 리스트를 만들고
	    it.forEach(list::add); // 리스트에 추가
		
	    List<Person> delList = new ArrayList<>();
	    for(int i=0;i<list.size();i++) {
	    	if(i%2==0) delList.add(list.get(i));
	    }
		personRepository.deleteAll(delList);
	}
	
	//void deleteById(ID id) - 주어진 id를 가진 엔티티를 삭제합니다.
	public void deleteByIdx(long idx) {
		personRepository.deleteById(idx);
	}
	
	// void delete(T entity) - 주어진 엔티티를 삭제합니다.
	// Optional<T>  findById(ID id) - 해당 ID로 엔티티를 검색합니다.
	public void deleteByObject(long idx) {
		// 검색
		Optional<Person> optional = personRepository.findById(idx);
		// 존재하면
		if(optional.isPresent()) {
			// 객체 삭제
			personRepository.delete(optional.get());
		}
	}
	// boolean existById(ID id) - 주어진 ID를 가진 엔터티가 있는지 여부를 반환합니다.
	public String existById() {
		Iterable<Person> it = personRepository.findAll(); // 모두 가져와
		List<Person> list = new ArrayList<Person>(); // 리스트를 만들고
	    it.forEach(list::add); // 리스트에 추가
	    Random rnd = new Random();
	    long idx = 0;
	    if(rnd.nextBoolean()) {
	    	idx = list.get(rnd.nextInt(list.size())).getIdx();
	    }else {
	    	idx = rnd.nextInt(1000);
	    }
		return personRepository.existsById(idx) ? idx + "번 데이터 있다" : idx + "번 데이터 없다";
	}
}
